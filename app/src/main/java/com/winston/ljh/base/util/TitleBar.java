package com.winston.ljh.base.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.winston.ljh.base.R;

import static android.util.TypedValue.COMPLEX_UNIT_PX;


public class TitleBar extends FrameLayout {
    private static final int DEFAULT_TITLE_COLOR = 0XFF000000;//默认的标题颜色
    private static final int DEFAULT_TEXT_COLOR = 0XFF000000;//默认的左右text颜色
    private static final int DEFAULT_TITLE_SIZE = 22;//默认的左右text大小
    private static final int DEFAULT_TEXT_SIZE = 12;//默认的左右text大小
    private static final int DEFAULT_MARGIN = 8; //默认左右 图片/文字 外边距

    TextView mTitle;
    ImageView mLeftImageView;
    ImageView mRightImageView;
    TextView mLeftTextView;
    TextView mRightTextView;

    public TitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context) {
        this(context, null);
    }

    //初始化
    private void initView(Context context, AttributeSet attrs) {
        //初始化view
        mTitle = new TextView(context);
        mLeftImageView = new ImageView(context);
        mRightImageView = new ImageView(context);
        mLeftTextView = new TextView(context);
        mRightTextView = new TextView(context);

        //初始化所以view的LayoutParams
        mTitle.setLayoutParams(getTitleLayoutParams());
        mLeftImageView.setLayoutParams(getLeftLayoutParams());
        mLeftTextView.setLayoutParams(getLeftLayoutParams());
        mRightImageView.setLayoutParams(getRightLayoutParams());
        mRightTextView.setLayoutParams(getRightLayoutParams());

        //把所有的view添加入TitleBar
        addView(mTitle);
        addView(mLeftImageView);
        addView(mLeftTextView);
        addView(mRightImageView);
        addView(mRightTextView);

        //view的居中设置
        mTitle.setGravity(Gravity.CENTER);
        mLeftTextView.setGravity(Gravity.CENTER_VERTICAL);
        mRightTextView.setGravity(Gravity.CENTER_VERTICAL);

        mLeftImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        mRightImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        //从attrs中获得各种设置参数
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        int titleColor = a.getColor(R.styleable.TitleBar_titleColor, DEFAULT_TITLE_COLOR);
        float titleSize = a.getDimension(R.styleable.TitleBar_titleSize, ValueUtil.sp2px(DEFAULT_TITLE_SIZE, context));
        CharSequence titleText = a.getText(R.styleable.TitleBar_titleText);

        int leftTextColor = a.getColor(R.styleable.TitleBar_leftTextColor, DEFAULT_TEXT_COLOR);
        float leftTextSize = a.getDimension(R.styleable.TitleBar_leftTextSize, ValueUtil.sp2px(DEFAULT_TEXT_SIZE, context));
        CharSequence leftText = a.getText(R.styleable.TitleBar_leftText);
        int leftImageSrc = a.getResourceId(R.styleable.TitleBar_leftImageSrc, 0);


        int rightTextColor = a.getColor(R.styleable.TitleBar_rightTextColor, DEFAULT_TEXT_COLOR);
        float rightTextSize = a.getDimension(R.styleable.TitleBar_rightTextSize, ValueUtil.sp2px(DEFAULT_TEXT_SIZE, context));
        CharSequence rightText = a.getText(R.styleable.TitleBar_rightText);
        int rightImageSrc = a.getResourceId(R.styleable.TitleBar_rightImageSrc, 0);

        a.recycle();

        //设置view的样式
        mTitle.setTextColor(titleColor);
        mTitle.setTextSize(COMPLEX_UNIT_PX, titleSize);
        mTitle.setText(titleText);

        mLeftTextView.setTextColor(leftTextColor);
        mLeftTextView.setTextSize(COMPLEX_UNIT_PX, leftTextSize);
        mLeftTextView.setText(leftText);

        mRightTextView.setTextColor(rightTextColor);
        mRightTextView.setTextSize(COMPLEX_UNIT_PX, rightTextSize);
        mRightTextView.setText(rightText);

        //判断如何设置了图片，则显示图片，不然显示text
        if (leftImageSrc != 0) {
            mLeftImageView.setImageResource(leftImageSrc);
            mLeftImageView.setVisibility(View.VISIBLE);
            mLeftTextView.setVisibility(View.GONE);
        } else {
            mLeftImageView.setVisibility(View.GONE);
            mLeftTextView.setVisibility(View.VISIBLE);
        }

        if (rightImageSrc != 0) {
            mRightImageView.setImageResource(rightImageSrc);
            mRightImageView.setVisibility(View.VISIBLE);
            mRightTextView.setVisibility(View.GONE);
        } else {
            mRightImageView.setVisibility(View.GONE);
            mRightTextView.setVisibility(View.VISIBLE);
        }

    }

    //获取Title的LayoutParams
    private FrameLayout.LayoutParams getTitleLayoutParams() {
        FrameLayout.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.gravity = Gravity.CENTER;
        return lp;
    }

    //获取左边 图片/文字 的LayoutParams
    private FrameLayout.LayoutParams getLeftLayoutParams() {
        FrameLayout.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.gravity = Gravity.LEFT;
        lp.leftMargin = ValueUtil.dp2px(DEFAULT_MARGIN, getContext());
        lp.topMargin = ValueUtil.dp2px(DEFAULT_MARGIN, getContext());
        lp.bottomMargin = ValueUtil.dp2px(DEFAULT_MARGIN, getContext());
        return lp;
    }

    //获取右边 图片/文字 的LayoutParams
    private FrameLayout.LayoutParams getRightLayoutParams() {
        FrameLayout.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.gravity = Gravity.RIGHT;
        lp.rightMargin = ValueUtil.dp2px(DEFAULT_MARGIN, getContext());
        lp.topMargin = ValueUtil.dp2px(DEFAULT_MARGIN, getContext());
        lp.bottomMargin = ValueUtil.dp2px(DEFAULT_MARGIN, getContext());
        return lp;
    }

    //设置左边监听事件
    public void setLeftOnClickListener(View.OnClickListener onClickListener) {
        mLeftImageView.setOnClickListener(onClickListener);
        mLeftTextView.setOnClickListener(onClickListener);
    }

    //设置右边边监听事件
    public void setRightOnClickListener(View.OnClickListener onClickListener) {
        mRightImageView.setOnClickListener(onClickListener);
        mRightTextView.setOnClickListener(onClickListener);
    }

}
