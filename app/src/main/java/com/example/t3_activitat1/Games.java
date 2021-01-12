package com.example.t3_activitat1;

import java.io.Serializable;

public class Games implements Serializable {
    // id, img, name, desc, type

    private int id;
    private String img;
    private String name;
    private String desc;
    private String type;

    public Games(int id, String img, String name, String desc, String type) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.type = type;
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
}
