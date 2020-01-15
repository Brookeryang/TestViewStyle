package com.njxw.testviewstyle.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/**
 * @Package: com.xwtec.qhmcc.util
 * @ClassName: GlideImageUtils
 * @Author: yyh
 * @CreateDate: 2019-09-25 10:50
 * @功能描述:
 * @Version: 1.0
 */
public class GlideImageUtils {
    private static GlideImageUtils instances;

    private GlideImageUtils() {
    }

    public static GlideImageUtils getInstance() {
        if (instances == null) {
            synchronized (GlideImageUtils.class) {
                if (instances == null) {
                    instances = new GlideImageUtils();
                }
            }

        }
        return instances;
    }

    /**
     * 加载圆形图
     *
     * @param context
     * @param url
     * @param image
     */
    public void loadRoundImg(Context context, String url, ImageView image) {
        if (TextUtils.isEmpty(url) || url.equalsIgnoreCase("null")) return;
        // 设置Glide
        RequestOptions options = new RequestOptions()
                .skipMemoryCacheOf(false); //开启缓存

        Glide.with(context).load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .apply(options)
                .into(image);
    }

    /**
     * 简单的使用方式
     *
     * @param context
     * @param url
     * @param image
     * @param drawableId 本地默认图片
     */
    public void simpleShowImage(Context context, String url, final ImageView image, int drawableId) {
        if (TextUtils.isEmpty(url) || url.equalsIgnoreCase("null")) return;
        // 设置Glide
        RequestOptions options = new RequestOptions()
                .placeholder(drawableId)//图片加载出来前，显示的图片
                .fallback(drawableId) //url为空的时候,显示的图片
                .skipMemoryCacheOf(false) //开启缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(drawableId);//图片加载失败后，显示的图片

        Glide.with(context).asDrawable().load(url).apply(options).into(image);
    }

    /**
     * 简单的使用方式
     *
     * @param context
     * @param url
     * @param image
     */
    public void simpleShowImage(Context context, String url, ImageView image) {
        if (TextUtils.isEmpty(url) || url.equalsIgnoreCase("null")) return;
        // 设置Glide
        RequestOptions options = new RequestOptions()
                .skipMemoryCacheOf(false) //开启缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL); //开启缓存

        Glide.with(context).asDrawable().load(url).apply(options).into(image);
    }

    /**
     * 加载带缓存
     *
     * @param context
     * @param url
     * @param image
     */
    public void loadCacheShowImage(Context context, String url, ImageView image) {
        if (TextUtils.isEmpty(url) || url.equalsIgnoreCase("null")) return;

        Glide.with(context).load(url).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                .apply(RequestOptions.skipMemoryCacheOf(false)).into(image);

    }

    /**
     * 取消加载
     *
     * @param context
     * @param imageView 尽管及时取消不必要的加载是很好的实践，
     *                  但这并不是必须的操作。实际上，当 Glide.with()
     *                  中传入的 Activity 或 Fragment
     *                  实例销毁时，Glide 会自动取消加载并回收资源。
     */
    public void cancelSimpleShowImage(Context context, ImageView imageView) {
        Glide.with(context).clear(imageView);
    }

    /**
     * 加载动态图
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void showGifImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .asGif()
                .load(url)
                .into(imageView);
    }

    /**
     * 加载本地动态图（gif）
     *
     * @param context
     * @param imgId
     * @param imageView
     */
    public void loadLocalGifImg(Context context, int imgId, ImageView imageView) {
        Glide.with(context)
                .asGif()
                .load(imgId)
                .into(imageView);
    }
}
