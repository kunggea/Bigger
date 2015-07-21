package com.kunggea.bigger.activity;

import android.os.Bundle;
import android.widget.Button;

import com.kunggea.bigger.R;
import com.kunggea.bigger.base.BaseActivity;
import com.kunggea.bigger.util.FontUtil;

public class MainActivity extends BaseActivity {

    private Button homeButton;

    private void initView() {
        homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setTypeface(FontUtil.getTypeface(this, "HelveticaNeue"));
        homeButton.setText("BIGGER");

        // almost push to github lk
        // must push in master...
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }
}
