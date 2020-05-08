package com.english.entity;

public class base {
    public Integer id;
    public String base;
    public String referBase;

    public base() {
    }

    @Override
    public String toString() {
        return "base{" +

                "id=" + id +
                ", base='" + base + '\'' +
                ", referBase='" + referBase + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getReferBase() {
        return referBase;
    }

    public void setReferBase(String referBase) {
        this.referBase = referBase;
    }
}
