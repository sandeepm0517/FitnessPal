package com.example.sandeepmungara.myfitnesspal.utils;

import com.example.sandeepmungara.myfitnesspal.model.ArticlesQueryResponseResponseModel;

public class ConstanData {

    private static ArticlesQueryResponseResponseModel articlesQueryResponseResponseModel;
    public static final String ADAPTER_POSITION = "Adapter_Position";

    public static void setArticlesQueryResponseResponseModel(ArticlesQueryResponseResponseModel articlesQueryResponseResponseModel) {
        ConstanData.articlesQueryResponseResponseModel = articlesQueryResponseResponseModel;
    }

    public static ArticlesQueryResponseResponseModel getArticlesQueryResponseResponseModel() {
        return articlesQueryResponseResponseModel;
    }
}
