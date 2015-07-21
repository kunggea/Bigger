package com.kunggea.bigger.util;

import android.text.TextUtils;

import com.spreada.utils.chinese.ZHConverter;

public class ChineseConvertUtil {

    // private static ChineseConvertUtil sCovert = null;
    //
    // public static ChineseConvertUtil getInstance() {
    // if (sCovert == null) {
    // sCovert = new ChineseConvertUtil();
    // }
    // return sCovert;
    // }

    /**
     * 获取繁体体文字
     * 
     * @param value
     * @return
     */
    public static String getSimplified(String value) {
        String result = "";
        if (!TextUtils.isEmpty(value)) {
            ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
            result = converter.convert(value);
        }
        return result;
    }

    /**
     * 获取简体文字
     * 
     * @param value
     * @return
     */
    public static String getTraditional(String value) {
        String result = "";
        if (!TextUtils.isEmpty(value)) {
            ZHConverter converter = ZHConverter.getInstance(ZHConverter.TRADITIONAL);
            result = converter.convert(value);
        }
        return result;
    }
}
