package com.kunggea.bigger.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * @author lk
 * 
 */
public class FontUtil {

    public static Typeface getTypeface(Context context, String fontName) {
        // 　 将字体文件保存在assets/fonts/目录下，创建Typeface对象
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName
                + ".ttf");
        return typeFace;
    }
}
