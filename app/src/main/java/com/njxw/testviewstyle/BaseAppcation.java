package com.njxw.testviewstyle;

import android.app.Application;
import android.content.Context;

/**
 * @Package: com.njxw.testviewstyle
 * @ClassName: BaseAppcation
 * @Author: yyh
 * @CreateDate: 2019-12-12 21:30
 * @功能描述:
 * @Version: 1.0
 */
public class BaseAppcation extends Application {
    private static BaseAppcation baseApplication;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    public static Context getApp() {
        return baseApplication;
    }
}
