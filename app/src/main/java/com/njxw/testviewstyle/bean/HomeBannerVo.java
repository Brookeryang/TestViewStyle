package com.njxw.testviewstyle.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Package: com.njxw.testviewstyle.bean
 * @ClassName: HomeBannerVo
 * @Author: yyh
 * @CreateDate: 2019-12-03 20:41
 * @功能描述:
 * @Version: 1.0
 */
public class HomeBannerVo implements Serializable {


    /**
     * data : [{"AdvImage":"/$img/EC10_Adv/14811447/banner6.jpg","goods":"44672389","AssociatedData":"2","Inventory":"999"},{"AdvImage":"/$img/EC10_Adv/14811448/banner5.jpg","goods":"2832672","AssociatedData":"2","Inventory":"991"},{"AdvImage":"/$img/EC10_Adv/18135590/banner4.jpg","goods":"6197421","AssociatedData":"3","Inventory":"0"},{"AdvImage":"/$img/EC10_Adv/18135599/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20190419162247.png","goods":"2230544","AssociatedData":"3","Inventory":"0"}]
     * rspCode : 1000
     * rspDesc : 成功
     */

    private String rspCode;
    private String rspDesc;
    private List<DataBean> data;

    public String getRspCode() {
        return rspCode;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspDesc() {
        return rspDesc;
    }

    public void setRspDesc(String rspDesc) {
        this.rspDesc = rspDesc;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * AdvImage : /$img/EC10_Adv/14811447/banner6.jpg
         * goods : 44672389
         * AssociatedData : 2
         * Inventory : 999
         */

        private String AdvImage;
        private String goods;
        private String AssociatedData;
        private String Inventory;

        public String getAdvImage() {
            return AdvImage;
        }

        public void setAdvImage(String AdvImage) {
            this.AdvImage = AdvImage;
        }

        public String getGoods() {
            return goods;
        }

        public void setGoods(String goods) {
            this.goods = goods;
        }

        public String getAssociatedData() {
            return AssociatedData;
        }

        public void setAssociatedData(String AssociatedData) {
            this.AssociatedData = AssociatedData;
        }

        public String getInventory() {
            return Inventory;
        }

        public void setInventory(String Inventory) {
            this.Inventory = Inventory;
        }
    }
}
