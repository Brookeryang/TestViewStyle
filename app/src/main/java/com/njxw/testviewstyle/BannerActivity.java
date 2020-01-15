package com.njxw.testviewstyle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.njxw.testviewstyle.adapter.BannerAdapterOne;
import com.njxw.testviewstyle.adapter.BannerAdapterTwe;
import com.njxw.testviewstyle.bean.HomeBannerVo;
import com.njxw.testviewstyle.utils.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.List;

public class BannerActivity extends AppCompatActivity {
    private Banner banner;
    private List<HomeBannerVo.DataBean> images;
    private RecyclerView ReView;
    private BannerAdapterOne adapterOne;//适配器一
    private BannerAdapterTwe adapterTwe;//适配器二

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        //图片地址
        //" https://www.nxsx365.com/app-biz/buyer/getIndexBanner2.action"
        initViews();
    }

    private void initViews() {

        banner = findViewById(R.id.banner);
        ReView = findViewById(R.id.recycler_vew);

        String json = "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"AdvImage\": \"/$img/EC10_Adv/14811447/banner6.jpg\",\n" +
                "            \"goods\": \"44672389\",\n" +
                "            \"AssociatedData\": \"2\",\n" +
                "            \"Inventory\": \"999\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdvImage\": \"/$img/EC10_Adv/14811448/banner5.jpg\",\n" +
                "            \"goods\": \"2832672\",\n" +
                "            \"AssociatedData\": \"2\",\n" +
                "            \"Inventory\": \"991\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdvImage\": \"/$img/EC10_Adv/18135590/banner4.jpg\",\n" +
                "            \"goods\": \"6197421\",\n" +
                "            \"AssociatedData\": \"3\",\n" +
                "            \"Inventory\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"AdvImage\": \"/$img/EC10_Adv/18135599/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20190419162247.png\",\n" +
                "            \"goods\": \"2230544\",\n" +
                "            \"AssociatedData\": \"3\",\n" +
                "            \"Inventory\": \"0\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"rspCode\": \"1000\",\n" +
                "    \"rspDesc\": \"成功\"\n" +
                "}";
        HomeBannerVo homeBannerVo = new Gson().fromJson(json, HomeBannerVo.class);
        for (int i = 0; i < homeBannerVo.getData().size(); i++) {

            images = homeBannerVo.getData();
            Log.d("Image---->", homeBannerVo.getData().get(i).getAdvImage());
            ReView.setLayoutManager(new LinearLayoutManager(this));
            adapterOne = new BannerAdapterOne(this, null, R.layout.item_layout_01);
            ReView.setAdapter(adapterOne);
            adapterOne.mData.add(homeBannerVo.getData().get(0));
            adapterOne.notifyDataSetChanged();

            //第二个适配器
            adapterTwe = new BannerAdapterTwe(this, null, R.layout.item_layout_02);
            ReView.setAdapter(adapterTwe);
            adapterTwe.mData.addAll(homeBannerVo.getData());
            adapterTwe.notifyDataSetChanged();


        }

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();

    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
