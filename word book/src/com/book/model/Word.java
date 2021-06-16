package com.book.model;

public class Word {
    private int id;
    private String englishword;
    private String meaning;
    private String example;

    public Word() {
        super();
    }

    public Word(String englishword, String meaning, String example) {
        this.englishword = englishword;
        this.meaning = meaning;
        this.example = example;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishword() {
        return englishword;
    }

    public void setEnglishword(String englishword) {
        this.englishword = englishword;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
