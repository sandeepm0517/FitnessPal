package com.example.sandeepmungara.myfitnesspal.list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sandeepmungara.myfitnesspal.DetailsActivity;
import com.example.sandeepmungara.myfitnesspal.R;
import com.example.sandeepmungara.myfitnesspal.model.Docs;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.subjects.PublishSubject;

import static com.example.sandeepmungara.myfitnesspal.utils.ConstanData.ADAPTER_POSITION;

public class ArticlesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View view;
    PublishSubject<Integer> itemClicks;

    @BindView(R.id.detail_screen_layout)
    LinearLayout linearLayout;

    @BindView(R.id.article_name)
    TextView name;
    @BindView(R.id.article_detail_text)
    TextView details;
    @BindView(R.id.article_release)
    TextView release;


    public ArticlesViewHolder(@NonNull View itemView, PublishSubject<Integer> itemClicks) {
        super(itemView);
        this.view = itemView;
        this.itemClicks = itemClicks;
        ButterKnife.bind(this, view);
        view.setOnClickListener(this);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra(ADAPTER_POSITION, getAdapterPosition());
                view.getContext().startActivity(intent);
            }
        });
    }

    public void bind(Docs articleQueryResponseModel) {
//        Glide.with(view.getContext()).load(articleQueryResponseModel).into(imageHero);
        name.setText(articleQueryResponseModel.snippet);
        details.setText(articleQueryResponseModel.abstractValue);
        release.setText(articleQueryResponseModel.pubDate);
    }

    @Override
    public void onClick(View view) {
        itemClicks.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                getAdapterPosition();
            }
        });
    }
}
