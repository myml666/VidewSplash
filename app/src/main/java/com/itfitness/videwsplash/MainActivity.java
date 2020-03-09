package com.itfitness.videwsplash;

import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
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
    private BaseQuickAdapter<Integer, BaseViewHolder> baseQuickAdapter1;
    private BaseQuickAdapter<Integer, BaseViewHolder> baseQuickAdapter2;
    private BaseQuickAdapter<Integer, BaseViewHolder> baseQuickAdapter3;
    private Handler handler = new Handler();
    private ScrollSpeedLinearLayoutManger scrollSpeedLinearLayoutManger1;
    private ScrollSpeedLinearLayoutManger scrollSpeedLinearLayoutManger2;
    private ScrollSpeedLinearLayoutManger scrollSpeedLinearLayoutManger3;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setEnterTransition(new Explode().setDuration(500));
        getWindow().setExitTransition(new Explode().setDuration(500));
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
        baseQuickAdapter3 = new BaseQuickAdapter<Integer, BaseViewHolder>(R.layout.item_img,getImagesThree()) {
            @Override
            protected void convert(BaseViewHolder helper, Integer item) {
                ImageView itemImgIcon = helper.getView(R.id.item_img_icon);
                ViewGroup.LayoutParams layoutParams = itemImgIcon.getLayoutParams();
                int i = baseQuickAdapter3.getData().indexOf(item);
                if(i == 0){
                    layoutParams.height = (int) (ScreenUtils.getScreenWidth()/5*1.5);
                }else {
                    layoutParams.height = (int) (ScreenUtils.getScreenWidth()/3*1.5);
                }
                Glide.with(MainActivity.this).load(item).into(itemImgIcon);
            }
        };
        rvThree.setAdapter(baseQuickAdapter3);
        rvOne.scrollToPosition(4);
        rvThree.scrollToPosition(4);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollSpeedLinearLayoutManger1.smoothScrollToPosition(rvOne, null,0);
                scrollSpeedLinearLayoutManger2.smoothScrollToPosition(rvTwo, null,6);
                scrollSpeedLinearLayoutManger3.smoothScrollToPosition(rvThree, null,0);
            }
        },500);
    }

    private void initAdapterTwo() {
        baseQuickAdapter2 = new BaseQuickAdapter<Integer, BaseViewHolder>(R.layout.item_img,getImagesTwo()) {
            @Override
            protected void convert(BaseViewHolder helper, Integer item) {
                ImageView itemImgIcon = helper.getView(R.id.item_img_icon);
                ViewGroup.LayoutParams layoutParams = itemImgIcon.getLayoutParams();
                layoutParams.height = (int) (ScreenUtils.getScreenWidth()/3*1.5);
                Glide.with(MainActivity.this).load(item).into(itemImgIcon);
            }
        };
        rvTwo.setAdapter(baseQuickAdapter2);
    }

    private void initAdapterOne() {
        baseQuickAdapter1 = new BaseQuickAdapter<Integer, BaseViewHolder>(R.layout.item_img,getImagesOne()) {
            @Override
            protected void convert(BaseViewHolder helper, Integer item) {
                ImageView itemImgIcon = helper.getView(R.id.item_img_icon);
                ViewGroup.LayoutParams layoutParams = itemImgIcon.getLayoutParams();
                int i = baseQuickAdapter1.getData().indexOf(item);
                if(i == 0){
                    layoutParams.height = (int) (ScreenUtils.getScreenWidth()/5*1.5);
                }else {
                    layoutParams.height = (int) (ScreenUtils.getScreenWidth()/3*1.5);
                }
                Glide.with(MainActivity.this).load(item).into(itemImgIcon);
            }
        };
        rvOne.setAdapter(baseQuickAdapter1);
    }
    private ArrayList<Integer> getImagesOne(){
        ArrayList<Integer> imgs = new ArrayList<>();
        imgs.add(R.drawable.ic_mv_one_bottom);
        imgs.add(R.drawable.ic_mv_two);
        imgs.add(R.drawable.ic_mv_seven);
        imgs.add(R.drawable.ic_mv_eight);
        imgs.add(R.drawable.ic_mv_three);
        imgs.add(R.drawable.ic_mv_four);
        imgs.add(R.drawable.ic_mv_five);
        imgs.add(R.drawable.ic_mv_six);
        imgs.add(R.drawable.ic_mv_nine);
        imgs.add(R.drawable.ic_mv_ten);
        return imgs;
    }
    private ArrayList<Integer> getImagesTwo(){
        ArrayList<Integer> imgs = new ArrayList<>();
        imgs.add(R.drawable.ic_mv_eight);
        imgs.add(R.drawable.ic_mv_nine);
        imgs.add(R.drawable.ic_mv_ten);
        imgs.add(R.drawable.ic_mv_one);
        imgs.add(R.drawable.ic_mv_two);
        imgs.add(R.drawable.ic_mv_seven);
        imgs.add(R.drawable.ic_mv_three);
        imgs.add(R.drawable.ic_mv_four);
        imgs.add(R.drawable.ic_mv_five);
        imgs.add(R.drawable.ic_mv_six);
        return imgs;
    }
    private ArrayList<Integer> getImagesThree(){
        ArrayList<Integer> imgs = new ArrayList<>();
        imgs.add(R.drawable.ic_mv_eight_bottom);
        imgs.add(R.drawable.ic_mv_six);
        imgs.add(R.drawable.ic_mv_seven);
        imgs.add(R.drawable.ic_mv_ten);
        imgs.add(R.drawable.ic_mv_two);
        imgs.add(R.drawable.ic_mv_eight);
        imgs.add(R.drawable.ic_mv_nine);
        imgs.add(R.drawable.ic_mv_five);
        imgs.add(R.drawable.ic_mv_three);
        imgs.add(R.drawable.ic_mv_four);
        return imgs;
    }
}
