/**
 * @file XListViewHeader.java
 * @create Apr 18, 2012 5:22:27 PM
 * @author Maxwin
 * @description XListView's header
 */
package com.kunggea.bigger.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kunggea.bigger.R;
import com.android.common.util.CMLoadingUtil;

public class XListViewHeader extends LinearLayout {
    private ImageView image_view_reflesh_logo;
    private AnimationDrawable animaitionLogo;

    private LinearLayout mContainer;
    private TextView mProgressBar;
    private TextView mHintTextView;
    private int mState = STATE_NORMAL;

    private Animation mRotateUpAnim;
    private Animation mRotateDownAnim;

    private final int ROTATE_ANIM_DURATION = 180;

    public final static int STATE_NORMAL = 0;
    public final static int STATE_READY = 1;
    public final static int STATE_REFRESHING = 2;

    public XListViewHeader(Context context) {
        super(context);
        initView(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public XListViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public int getVisiableHeight() {
        return mContainer.getHeight();
    }

    public void setState(int state) {
        if (state == mState) {
            return;
        }

        if (state == STATE_REFRESHING) { // 显示进度
            // mArrowImageView.setVisibility(View.INVISIBLE);
            mProgressBar.setVisibility(View.VISIBLE);
            // mProgressBar.startAnimation(mRotateUpAnim);
            // mProgressBar.getAnimation().startNow();
            // refreshTVAnimation(mProgressBar);
            CMLoadingUtil.statLoading(mProgressBar);
            animaitionLogo.start();
        } else { // 显示箭头图片
            // mArrowImageView.setVisibility(View.VISIBLE);
            // mProgressBar.clearAnimation();
            // mProgressBar.setVisibility(View.INVISIBLE);
            CMLoadingUtil.stopLoading(mProgressBar);
            animaitionLogo.stop();
        }

        switch (state) {
        case STATE_NORMAL:
            if (mState == STATE_READY) {
                // mArrowImageView.startAnimation(mRotateDownAnim);
            }
            if (mState == STATE_REFRESHING) {
                // mArrowImageView.clearAnimation();
            }
            mHintTextView.setText(R.string.xlistview_header_hint_normal);
            break;
        case STATE_READY:
            if (mState != STATE_READY) {
                // mArrowImageView.clearAnimation();
                mHintTextView.setText(R.string.xlistview_header_hint_ready);
            }
            break;
        case STATE_REFRESHING:
            mHintTextView.setText(R.string.xlistview_header_hint_loading);
            break;
        default:
        }

        mState = state;
    }

    public void setVisiableHeight(int height) {
        if (height < 0) {
            height = 0;
        }
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContainer.getLayoutParams();
        lp.height = height;
        mContainer.setLayoutParams(lp);
    }

    private void initView(Context context) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 0);
        mContainer = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.xlistview_header,
                null);
        addView(mContainer, lp);
        setGravity(Gravity.BOTTOM);

        image_view_reflesh_logo = (ImageView) findViewById(R.id.image_view_reflesh_logo);
        image_view_reflesh_logo.setBackgroundResource(R.anim.xiaoma_pull_reflesh_logo);
        animaitionLogo = (AnimationDrawable) image_view_reflesh_logo.getBackground();
        animaitionLogo.setOneShot(false);

        // mArrowImageView = (ImageView)
        // findViewById(R.id.xlistview_header_arrow);
        mHintTextView = (TextView) findViewById(R.id.xlistview_header_hint_textview);
        mProgressBar = (TextView) findViewById(R.id.xlistview_header_progressbar);

        mRotateUpAnim = new RotateAnimation(0.0f, 100000 * 360f, RotateAnimation.RELATIVE_TO_SELF,
                0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        mRotateUpAnim.setDuration(100000 * 800);
        mRotateUpAnim.setRepeatCount(-1);

        mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);
    }

}
