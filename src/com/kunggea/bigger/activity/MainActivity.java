package com.kunggea.bigger.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
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

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

	}
}
