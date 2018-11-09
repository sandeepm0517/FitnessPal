package com.example.sandeepmungara.myfitnesspal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticlesQueryResponseResponseModel {

    @SerializedName("response")
    @Expose
    public ArticleQueryResponseModel response;

}
