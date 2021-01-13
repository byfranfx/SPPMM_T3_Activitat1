package com.example.t3_activitat1;

import java.io.Serializable;

public class Games implements Serializable {
    // id, img, name, desc, type

    private int id;
    private String img;
    private String name;
    private String desc;
    private String type;
    private boolean checkbox;

    public Games(int id, String img, String name, String desc, String type, boolean checkbox) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.checkbox = checkbox;
    }

    public Games() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCheckbox() { return checkbox; }

    public void setCheckbox(boolean checkbox) { this.checkbox = checkbox; }
}
