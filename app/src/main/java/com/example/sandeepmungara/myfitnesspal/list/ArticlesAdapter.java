package com.example.sandeepmungara.myfitnesspal.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sandeepmungara.myfitnesspal.R;
import com.example.sandeepmungara.myfitnesspal.model.ArticlesQueryResponseResponseModel;
import com.example.sandeepmungara.myfitnesspal.model.Docs;

import java.util.ArrayList;

import rx.Observable;
import rx.subjects.PublishSubject;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    private ArrayList<Docs> responseModelList = new ArrayList<>();

    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_detail, viewGroup, false);
        return new ArticlesViewHolder(view, itemClicks);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder articlesViewHolder, int i) {
        Docs articleQueryResponseModel = responseModelList.get(i);
        articlesViewHolder.bind(articleQueryResponseModel);
    }

    @Override
    public int getItemCount() {
        if (responseModelList != null && responseModelList.size() > 0) {
            return responseModelList.size();
        } else
            return 0;
    }

    public Observable<Integer> onbserverClicks() {
        return itemClicks;
    }

    public void swapAdapter(ArticlesQueryResponseResponseModel responseModels) {
        this.responseModelList.addAll(responseModels.response.docsList);
        notifyDataSetChanged();
    }
}
