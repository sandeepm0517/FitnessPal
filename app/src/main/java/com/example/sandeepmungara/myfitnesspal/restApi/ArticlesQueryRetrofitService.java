package com.example.sandeepmungara.myfitnesspal.restApi;

import com.example.sandeepmungara.myfitnesspal.model.ArticlesQueryResponseResponseModel;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ArticlesQueryRetrofitService {

    private static final String BASE_URL = "https://api.nytimes.com/";

    private ArticlesQueryApi provideApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient.Builder().build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        return retrofit.create(ArticlesQueryApi.class);
    }

    public Observable<ArticlesQueryResponseResponseModel> provideListOfArticles() {
        return provideApiService().getArticles("d31fe793adf546658bd67e2b6a7fd11a");
    }
}
