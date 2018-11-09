package com.example.sandeepmungara.myfitnesspal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeadLine implements Serializable {

    @SerializedName("main")
    @Expose
    public String main;

    @SerializedName("kicker")
    @Expose
    public String kicker;

    @SerializedName("content_kicker")
    @Expose
    public String contentKicker;

    @SerializedName("print_headline")
    @Expose
    public String printHeadLine;

    @SerializedName("name")
    @Expose
    public String headLineName;

    @SerializedName("seo")
    @Expose
    public String seo;

    @SerializedName("sub")
    @Expose
    public String sub;
}
