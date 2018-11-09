package com.example.sandeepmungara.myfitnesspal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.sandeepmungara.myfitnesspal.utils.ConstanData;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.sandeepmungara.myfitnesspal.utils.ConstanData.ADAPTER_POSITION;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.detail_article_name)
    TextView articleName;
    @BindView(R.id.detail_article_detail)
    TextView articleDetail;
    @BindView(R.id.detail_article_detail_2)
    TextView articleDetail2;
    @BindView(R.id.detail_article_detail_3)
    TextView articleDetail3;

    private int integer;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        integer = (int) getIntent().getExtras().get(ADAPTER_POSITION);

        articleName.setText(ConstanData.getArticlesQueryResponseResponseModel().response.docsList.get(integer).abstractValue);
        articleDetail.setText(ConstanData.getArticlesQueryResponseResponseModel().response.docsList.get(integer).documentType);
        articleDetail2.setText(ConstanData.getArticlesQueryResponseResponseModel().response.docsList.get(integer).docsSource);
        articleDetail3.setText(ConstanData.getArticlesQueryResponseResponseModel().response.docsList.get(integer).pubDate);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    public void bind(Integer integer) {
        this.integer = integer;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
