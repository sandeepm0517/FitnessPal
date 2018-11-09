package com.example.sandeepmungara.myfitnesspal.restApi;

import com.example.sandeepmungara.myfitnesspal.model.ArticlesQueryResponseResponseModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ArticlesQueryApi {

    @GET("svc/search/v2/articlesearch.json")
    Observable<ArticlesQueryResponseResponseModel> getArticles(@Query("api-key") String API_KEY);
}
