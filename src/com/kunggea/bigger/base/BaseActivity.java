package com.kunggea.bigger.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

/**
 * @author lk
 * 
 */
public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏

    }

}
