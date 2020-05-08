package com.english.entity;

import java.util.List;

public class RequestJsonData {
    boolean success=true;
    int pageTotal;
    int countNum;
    int pageNum;
    Object datas;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pages) {
        this.pageTotal = pages;
    }

    public int getCountNum() {
        return countNum;
    }

    @Override
    public String toString() {
        return "RequestJsonData{" +
                "success=" + success +
                ", pageTotal=" + pageTotal +
                ", countNum=" + countNum +
                ", pageNum=" + pageNum +
                ", datas=" + datas +
                '}';
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    public RequestJsonData() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }
}
