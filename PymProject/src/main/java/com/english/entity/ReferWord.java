package com.english.entity;



import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReferWord {

    private Integer id;
    private String refer;
    private List wids;
    private String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public List getWids() {
        return wids;
    }

    public void setWids(List wids) {
        this.wids = wids;
    }

    public ReferWord() {
    }
    public ReferWord(String refer, List wids) {
        this.refer=refer;
        this.wids=wids;
    }
    public ReferWord(Integer id,String refer, List wids) {
        this.id=id;
        this.refer=refer;
        this.wids=wids;
    }
}
