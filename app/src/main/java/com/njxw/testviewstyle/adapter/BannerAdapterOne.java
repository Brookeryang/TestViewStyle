package com.njxw.testviewstyle.adapter;

import android.content.Context;

import com.njxw.testviewstyle.R;
import com.njxw.testviewstyle.bean.HomeBannerVo;

import java.util.List;

/**
 * @Package: com.njxw.testviewstyle.adapter
 * @ClassName: BannerAdapterOne
 * @Author: yyh
 * @CreateDate: 2019-12-12 21:35
 * @功能描述:
 * @Version: 1.0
 */
public class BannerAdapterOne extends CommonAdapter4RecyclerView<HomeBannerVo.DataBean> {
    private Context mContext;

    public BannerAdapterOne(Context context, List<HomeBannerVo.DataBean> data, int layoutId) {
        super(context, data, layoutId);
        this.mContext = context;
    }

    @Override
    public void convert(CommonHolder4RecyclerView holder, HomeBannerVo.DataBean homeBannerVo) {
        holder.setImageViewImage(mContext,R.id.image_view, "https://www.nxsx365.com/" + homeBannerVo.getAdvImage());

    }
}
