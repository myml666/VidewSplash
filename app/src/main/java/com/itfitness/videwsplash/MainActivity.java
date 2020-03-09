package com.itfitness.videwsplash;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvOne;
    private RecyclerView rvTwo;
    private RecyclerView rvThree;
    private BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapter1;
    private BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapter2;
    private BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapter3;
    private Handler handler = new Handler();
    private ScrollSpeedLinearLayoutManger scrollSpeedLinearLayoutManger1;
    private ScrollSpeedLinearLayoutManger scrollSpeedLinearLayoutManger2;
    private ScrollSpeedLinearLayoutManger scrollSpeedLinearLayoutManger3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvOne = (RecyclerView) findViewById(R.id.rv_one);
        rvTwo = (RecyclerView) findViewById(R.id.rv_two);
        rvThree = (RecyclerView) findViewById(R.id.rv_three);
        scrollSpeedLinearLayoutManger1 = new ScrollSpeedLinearLayoutManger(this);
        scrollSpeedLinearLayoutManger2 = new ScrollSpeedLinearLayoutManger(this);
        scrollSpeedLinearLayoutManger3 = new ScrollSpeedLinearLayoutManger(this);
        rvOne.setLayoutManager(scrollSpeedLinearLayoutManger1);
        rvTwo.setLayoutManager(scrollSpeedLinearLayoutManger2);
        rvThree.setLayoutManager(scrollSpeedLinearLayoutManger3);
        rvOne.setEnabled(false);
        rvTwo.setEnabled(false);
        rvThree.setEnabled(false);
        initAdapterOne();
        initAdapterTwo();
        initAdapterThree();
    }

    private void initAdapterThree() {
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            if(i%2==0){
                arrayList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2812835425,1971619504&fm=26&gp=0.jpg");
            }else {
                arrayList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3033372597,1610405372&fm=26&gp=0.jpg");
            }
        }
        baseQuickAdapter3 = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_img,arrayList) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                ImageView itemImgIcon = helper.getView(R.id.item_img_icon);
                ViewGroup.LayoutParams layoutParams = itemImgIcon.getLayoutParams();
                layoutParams.height = (int) (ScreenUtils.getScreenWidth()/3*1.5);
                Glide.with(MainActivity.this).load(item).into(itemImgIcon);
            }
        };
        rvThree.setAdapter(baseQuickAdapter3);
        rvOne.scrollToPosition(6);
        rvThree.scrollToPosition(6);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollSpeedLinearLayoutManger1.smoothScrollToPosition(rvOne, null,0);
                scrollSpeedLinearLayoutManger2.smoothScrollToPosition(rvTwo, null,4);
                scrollSpeedLinearLayoutManger3.smoothScrollToPosition(rvThree, null,0);
            }
        },100);
    }

    private void initAdapterTwo() {
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            if(i%2==0){
                arrayList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2812835425,1971619504&fm=26&gp=0.jpg");
            }else {
                arrayList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3033372597,1610405372&fm=26&gp=0.jpg");
            }
        }
        baseQuickAdapter2 = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_img,arrayList) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                ImageView itemImgIcon = helper.getView(R.id.item_img_icon);
                ViewGroup.LayoutParams layoutParams = itemImgIcon.getLayoutParams();
                layoutParams.height = (int) (ScreenUtils.getScreenWidth()/3*1.5);
                Glide.with(MainActivity.this).load(item).into(itemImgIcon);
            }
        };
        rvTwo.setAdapter(baseQuickAdapter2);
    }

    private void initAdapterOne() {
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            if(i%2==0){
                arrayList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2812835425,1971619504&fm=26&gp=0.jpg");
            }else {
                arrayList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3033372597,1610405372&fm=26&gp=0.jpg");
            }
        }
        baseQuickAdapter1 = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_img,arrayList) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                ImageView itemImgIcon = helper.getView(R.id.item_img_icon);
                ViewGroup.LayoutParams layoutParams = itemImgIcon.getLayoutParams();
                layoutParams.height = (int) (ScreenUtils.getScreenWidth()/3*1.5);
                Glide.with(MainActivity.this).load(item).into(itemImgIcon);
            }
        };
        rvOne.setAdapter(baseQuickAdapter1);
    }
}
