package com.njxw.testviewstyle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;


/**
  *
  * @Package:        com.njxw.testviewstyle
  * @ClassName:      MainActivity
  * @Description:    作用描述
  * @Author:         yyh
  * @CreateDate:     2019-11-29 16:19
  * @Version:        1.0
  */

public class MainActivity extends AppCompatActivity {
    private TextView textView,textView2;
     private SpannableString sStr,Str2;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVies();
    }

    private void initVies() {
        //创建一个SpannableString对象
//        sStr = new SpannableString("最是那一低头的温柔，像一朵水莲花不胜");
        String s = "100.0 分钟";
        sStr = new SpannableString(s);
//        String s = "100.0分钟";
//        String [] ss = s.split("分");
        String s2 = "● ● ● ● 分";
        Str2 = new SpannableString(s2);
//
        textView = findViewById(R.id.tv_stare);
        textView2 = findViewById(R.id.textView);

//        textView2.setText(ss[0].toString());
        //设置字体大小（绝对值,单位：像素）,第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素
//        sStr.setSpan(new AbsoluteSizeSpan(20), 10, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sStr.setSpan(new AbsoluteSizeSpan(28, true), 0, s.length()-2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setTextColor(this.getResources().getColor(R.color.colorAccent1));
        //TextPaint tp = tv.getPaint();
        //tp.setFakeBoldText(true);
        textView.getPaint().setFakeBoldText(true);

        Str2.setSpan(new AbsoluteSizeSpan(9, true), 0, s.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView2.setTextColor(this.getResources().getColor(R.color.colorAccent2));
        //TextPaint tp = tv.getPaint();
        //tp.setFakeBoldText(true);
        textView2.getPaint().setFakeBoldText(true);

        //设置字体大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍   ,0.5表示一半
//        sStr.setSpan(new RelativeSizeSpan(0.5f), 14, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体前景色
        //sStr.setSpan(new ForegroundColorSpan(Color.RED), 16, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(sStr);
        textView2.setText(Str2);

    }
}
