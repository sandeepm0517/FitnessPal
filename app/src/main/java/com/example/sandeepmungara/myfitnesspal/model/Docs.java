package com.example.sandeepmungara.myfitnesspal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Docs implements Serializable {
    @SerializedName("web_url")
    @Expose
    public String webUrl;

    @SerializedName("snippet")
    @Expose
    public String snippet;

    @SerializedName("abstract")
    @Expose
    public String abstractValue;

    @SerializedName("print_page")
    @Expose
    public String printPage;

    @SerializedName("source")
    @Expose
    public String docsSource;

    @SerializedName("headline")
    @Expose
    public HeadLine headLine;

    @SerializedName("keywords")
    @Expose
    public List<KeyWords> keyWords;

    @SerializedName("pub_date")
    @Expose
    public String pubDate;

    @SerializedName("document_type")
    @Expose
    public String documentType;

    @SerializedName("byline")
    @Expose
    public Byline byline;

    @SerializedName("type_of_material")
    @Expose
    public String typeOfMaterial;

    @SerializedName("_id")
    @Expose
    public String id;

    @SerializedName("word_count")
    @Expose
    public String workCount;

    @SerializedName("score")
    @Expose
    public int score;
}
