package com.example.ad2l2.ui.home;

public class FireBaseModel {
    private  int id;
    private String name;
    private String number;
    private String docId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public FireBaseModel(int id, String name, String number, String docId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.docId = docId;
    }
}
