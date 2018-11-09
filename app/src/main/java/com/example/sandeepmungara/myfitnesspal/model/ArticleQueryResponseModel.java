package com.example.sandeepmungara.myfitnesspal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleQueryResponseModel implements Serializable {

    @SerializedName("docs")
    @Expose
    public List<Docs> docsList;
}
