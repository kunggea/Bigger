package com.kunggea.bigger.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.kunggea.bigger.R;
import com.kunggea.bigger.base.BaseActivity;
import com.kunggea.bigger.util.FontUtil;
import com.kunggea.bigger.view.XListView;
import com.kunggea.bigger.view.XListView.IXListViewListener;

public class MainActivity extends BaseActivity implements IXListViewListener {

	private Button homeButton;
	private Button addButton;
	private XListView xListView;

	private void initView() {
		addButton = (Button) findViewById(R.id.addButton);
		homeButton = (Button) findViewById(R.id.homeButton);
		xListView = (XListView) findViewById(R.id.xListview);

		addButton.setOnClickListener(this);
		homeButton.setTypeface(FontUtil.getTypeface(this, "HelveticaNeue"));
		homeButton.setText("BIGGER");
		// title animation set
		ObjectAnimator animateAlpha = ObjectAnimator.ofFloat(homeButton,
				"alpha", 0f, 1f);
		ObjectAnimator animateScaleX = ObjectAnimator.ofFloat(homeButton,
				"scaleX", 0f, 1f);
		ObjectAnimator animateScaleY = ObjectAnimator.ofFloat(homeButton,
				"scaleY", 0f, 1f);

		AnimatorSet set = new AnimatorSet();
		set.playTogether(animateAlpha, animateScaleX, animateScaleY);
		set.setDuration(2000);
		set.setInterpolator(new DecelerateInterpolator());
		set.start();

		xListView = (XListView) findViewById(R.id.xListview);
		xListView.setPullLoadEnable(true);
		xListView.setXListViewListener(this);

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.addButton:
			Toast.makeText(MainActivity.this,
					"Thanks for your interview,dear.", 1).show();
			break;

		default:
			break;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

	}

	@Override
	public void onLoadMore() {
		
	}

	@Override
	public void onRefresh() {
		
	}
}
