package com.example.sandeepmungara.myfitnesspal;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.sandeepmungara.myfitnesspal.list.ArticlesAdapter;
import com.example.sandeepmungara.myfitnesspal.model.ArticlesQueryResponseResponseModel;
import com.example.sandeepmungara.myfitnesspal.restApi.ArticlesQueryRetrofitService;
import com.example.sandeepmungara.myfitnesspal.utils.AppRxSchedulers;
import com.example.sandeepmungara.myfitnesspal.utils.ConstanData;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress_horizontal)
    ProgressBar progressBar;

    private ArticlesQueryRetrofitService retrofitService;
    private AppRxSchedulers rxSchedulers;
    private CompositeSubscription subscription;
    private ArticlesAdapter articlesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        retrofitService = new ArticlesQueryRetrofitService();
        rxSchedulers = new AppRxSchedulers();
        subscription = new CompositeSubscription();
        articlesAdapter = new ArticlesAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(articlesAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu, menu);
        // Associate searchable configuration with the SearchView
        final SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search_item).getActionView();
        if (searchManager != null)
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private Subscription getArticlesList() {
        return retrofitService.provideListOfArticles().observeOn(rxSchedulers.androidThread()).subscribeOn(rxSchedulers.internet())
                .subscribe(new Subscriber<ArticlesQueryResponseResponseModel>() {
                    @Override
                    public void onCompleted() {
                        Log.d("ARTICLES_SUCCESS", "Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ARTICLES_ERROR", e.getMessage());
                    }

                    @Override
                    public void onNext(ArticlesQueryResponseResponseModel articlesQueryResponseResponseModel) {
                        ConstanData.setArticlesQueryResponseResponseModel(articlesQueryResponseResponseModel);
                        progressBar.setVisibility(View.GONE);
                        articlesAdapter.swapAdapter(articlesQueryResponseResponseModel);
                    }
                });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);
        subscription.add(getArticlesList());
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.isUnsubscribed();
    }
}
