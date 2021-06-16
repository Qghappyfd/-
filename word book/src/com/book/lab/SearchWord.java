package com.book.lab;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


 public class SearchWord {

    private static Logger logger = LoggerFactory.getLogger(SearchWord.class);

    private static final String YOUDAO_URL = "https://openapi.youdao.com/api";

    private static final String APP_KEY = "26cc7f4cXXXXXXX";  //这里的秘钥需要自己去有道云官网申请

    private static final String APP_SECRET = "OiUhfvHspgRARnXsOkyQJgPr1GXXXXXX";

    public static void main(String[] args) throws IOException {

        Map<String,String> params = new HashMap<String,String>();
        String q = "i have an apple";
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("from", "auto");
        params.put("to", "auto");
        params.put("signType", "v3");
        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
        params.put("curtime", curtime);
        String signStr = APP_KEY + truncate(q) + salt + curtime + APP_SECRET;
        String sign = getDigest(signStr);
        params.put("appKey", APP_KEY);
        params.put("q", q);
        params.put("salt", salt);
        params.put("sign", sign);
        params.put("vocabId","您的用户词表ID");
        /** 处理结果 */
        requestForHttp(YOUDAO_URL,params);
    }

    public static String requestForHttp(String url,Map<String,String> params) throws IOException {

        /** 创建HttpClient */
        CloseableHttpClient httpClient = HttpClients.createDefault();

        /** httpPost */
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
        Iterator<Map.Entry<String,String>> it = params.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> en = it.next();
            String key = en.getKey();
            String value = en.getValue();
            paramsList.add(new BasicNameValuePair(key, value));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(paramsList,"UTF-8"));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        String tmp;
        /** 响应不是音频流，直接显示结果 */
        HttpEntity httpEntity = httpResponse.getEntity();
        String string = EntityUtils.toString(httpEntity,"UTF-8");
        EntityUtils.consume(httpEntity);
        JSONObject json= JSONObject.parseObject(string);
        StringBuffer str = new StringBuffer("");
        String key=null;

        JSONObject json2= JSONObject.parseObject(json.getString("basic"));
        tmp=json2.getString("us-phonetic");
        if(!(tmp==null))
        {
            str = new StringBuffer("美式音标:");
            str.append(tmp);
            str.append("\t英式音标:"+json2.getString("phonetic"));
            tmp=json.getString("translation");
            str.append("\n释译:"+tmp.substring(2,tmp.length()-2));

            JSONArray jsonArray= JSONArray.parseArray(json.get("web").toString());
            str.append("\n联想:\n");
            for (int i = 0; i < jsonArray.size(); i++){
                json2 = jsonArray.getJSONObject(i);
                tmp=json2.get("value").toString();
                str.append("   "+json2.get("key").toString()+"      "+tmp.substring(1,tmp.length()-1)+ "\r\n");
            }
        }
        else
        {

            str.append("汉语拼音:"+json2.getString("phonetic"));
            tmp=json.getString("translation");
            str.append("\n释译:"+tmp.substring(2,tmp.length()-2));

            JSONArray jsonArray= JSONArray.parseArray(json.get("web").toString());
            str.append("\n联想:\n");
            for (int i = 0; i < jsonArray.size(); i++){
                json2 = jsonArray.getJSONObject(i);
                tmp=json2.get("value").toString();
                str.append("   "+json2.get("key").toString()+"      "+tmp.substring(1,tmp.length()-1)+ "\r\n");
            }
        }

        System.out.println(str);




        try{
            if(httpResponse!=null){
                httpResponse.close();
            }
        }catch(IOException e){
            logger.info("## release resouce error ##" + e);
        }
        return str.toString();
    }


    /**
     * 生成加密字段
     */
    public static String getDigest(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest mdInst = MessageDigest.getInstance("SHA-256");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     *
     * @param result 音频字节流
     * @param file 存储路径
     */
    private static void byte2File(byte[] result, String file) {
        File audioFile = new File(file);
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(audioFile);
            fos.write(result);

        }catch (Exception e){
            logger.info(e.toString());
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String truncate(String q) {
        if (q == null) {
            return null;
        }
        int len = q.length();
        String result;
        return len <= 20 ? q : (q.substring(0, 10) + len + q.substring(len - 10, len));
    }

     public static Logger getLogger() {
         return logger;
     }

     public static String getYoudaoUrl() {
         return YOUDAO_URL;
     }

     public static String getAppKey() {
         return APP_KEY;
     }

     public static String getAppSecret() {
         return APP_SECRET;
     }


     public static String requestForHttp2(String url,Map<String,String> params) throws IOException {

         /** 创建HttpClient */
         CloseableHttpClient httpClient = HttpClients.createDefault();

         /** httpPost */
         HttpPost httpPost = new HttpPost(url);
         List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
         Iterator<Map.Entry<String,String>> it = params.entrySet().iterator();
         while(it.hasNext()){
             Map.Entry<String,String> en = it.next();
             String key = en.getKey();
             String value = en.getValue();
             paramsList.add(new BasicNameValuePair(key, value));
         }
         httpPost.setEntity(new UrlEncodedFormEntity(paramsList,"UTF-8"));
         CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
         String tmp;
         /** 响应不是音频流，直接显示结果 */
         HttpEntity httpEntity = httpResponse.getEntity();
         String string = EntityUtils.toString(httpEntity,"UTF-8");
         EntityUtils.consume(httpEntity);
         JSONObject json= JSONObject.parseObject(string);
         StringBuffer str = new StringBuffer("");

         tmp=json.getString("translation");
         str.append(tmp.substring(2,tmp.length()-2));




         try{
             if(httpResponse!=null){
                 httpResponse.close();
             }
         }catch(IOException e){
             logger.info("## release resouce error ##" + e);
         }
         return str.toString();
     }
 }
