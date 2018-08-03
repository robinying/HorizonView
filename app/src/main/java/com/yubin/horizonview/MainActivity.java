package com.yubin.horizonview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yubin.horizonview.adapter.LeftAdapter;
import com.yubin.horizonview.adapter.RightAdapter;
import com.yubin.horizonview.bean.Product;
import com.yubin.horizonview.utils.DataUtil;
import com.yubin.horizonview.utils.ToastUtil;
import com.yubin.horizonview.widget.HorizonScrollView;
import com.yubin.horizonview.widget.MListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rightTitleHorscrollView)
    HorizonScrollView rightTitleHorscrollView;
    @BindView(R.id.contentListViewLeft)
    MListView contentListViewLeft;
    @BindView(R.id.contentListViewRight)
    MListView contentListViewRight;
    @BindView(R.id.rightContentHorscrollView)
    HorizonScrollView rightContentHorscrollView;
    @BindView(R.id.tv_item)
    TextView tvItem;
    @BindView(R.id.tv_item1)
    TextView tvItem1;
    @BindView(R.id.tv_item2)
    TextView tvItem2;
    @BindView(R.id.tv_item3)
    TextView tvItem3;
    @BindView(R.id.tv_item4)
    TextView tvItem4;
    @BindView(R.id.tv_item5)
    TextView tvItem5;
    @BindView(R.id.tv_item6)
    TextView tvItem6;
    @BindView(R.id.tv_item7)
    TextView tvItem7;
    @BindView(R.id.titleLayout)
    LinearLayout titleLayout;
    @BindView(R.id.contentLayout)
    LinearLayout contentLayout;
    @BindView(R.id.contentScrollView)
    ScrollView contentScrollView;

    private LeftAdapter mLeft = null;
    private RightAdapter mRight = null;
    private List<Product> mList = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rightTitleHorscrollView.setSyncView(rightContentHorscrollView);
        rightContentHorscrollView.setSyncView(rightTitleHorscrollView);

        mLeft = new LeftAdapter(this, 0, new ArrayList<Product>());
        contentListViewLeft.setAdapter(mLeft);
        mRight = new RightAdapter(this, 0, new ArrayList<Product>());
        contentListViewRight.setAdapter(mRight);
        contentListViewLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ToastUtil.makeText(MainActivity.this,mLeft.getItem(position).getName());

            }
        });
        contentListViewRight.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ToastUtil.makeText(MainActivity.this,mRight.getItem(position).getName()+mRight.getItem(position).getCode());

            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        String data = DataUtil.convertStreamToString(MainActivity.this);
        Observable.just(data)
                .map(new Func1<String, List<Product>>() {
                    @Override
                    public List<Product> call(String data) {
                        Gson gson = new Gson();
                        mList = gson.fromJson(data, new TypeToken<ArrayList<Product>>() {
                        }.getType());
                        return mList;
                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Product>>() {
                    @Override
                    public void onCompleted() {
                        for (Product product : mList) {
                            mLeft.add(product);
                            mRight.add(product);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Product> s) {

                    }
                });
    }

    @OnClick({R.id.tv_item, R.id.tv_item1, R.id.tv_item2, R.id.tv_item3, R.id.tv_item4, R.id.tv_item5, R.id.tv_item6, R.id.tv_item7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_item:
                ToastUtil.makeText(MainActivity.this,"名称");
                break;
            case R.id.tv_item1:
                ToastUtil.makeText(MainActivity.this,"tv_item1");
                break;
            case R.id.tv_item2:
                ToastUtil.makeText(MainActivity.this,"tv_item2");
                break;
            case R.id.tv_item3:
                ToastUtil.makeText(MainActivity.this,"tv_item3");
                break;
            case R.id.tv_item4:
                ToastUtil.makeText(MainActivity.this,"tv_item4");
                break;
            case R.id.tv_item5:
                ToastUtil.makeText(MainActivity.this,"tv_item5");
                break;
            case R.id.tv_item6:
                ToastUtil.makeText(MainActivity.this,"tv_item6");
                break;
            case R.id.tv_item7:
                ToastUtil.makeText(MainActivity.this,"tv_item7");
                break;
        }
    }
}
