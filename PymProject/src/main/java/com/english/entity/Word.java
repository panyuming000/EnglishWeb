package com.english.entity;

public class Word {

    //区别3500词汇和10000词汇
//    private Integer ID;
    private Integer id;
    private String word;
    private String soundmark;
    private String cn;
    private String lx;

//    public Integer getID() {
//        return ID;
//    }
//
//    public void setID(Integer ID) {
//        this.ID = ID;
//    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", soundmark='" + soundmark + '\'' +
                ", cn='" + cn + '\'' +
                ", lx='" + lx + '\'' +
                '}';
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public Word(String word, String soundmark, String cn) {
        this.word = word;
        this.soundmark = soundmark;
        this.cn = cn;
    }

    public Word() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSoundmark() {
        return soundmark;
    }

    public void setSoundmark(String soundmark) {
        this.soundmark = soundmark;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }
}
