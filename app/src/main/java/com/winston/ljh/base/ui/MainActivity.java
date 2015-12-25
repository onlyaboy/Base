package com.winston.ljh.base.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.winston.ljh.base.R;
import com.winston.ljh.base.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void findView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initListener() {
        findViewById(R.id.text).setOnClickListener(this);
    }

    @Override
    protected void initUI() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text:
                startActivity(NoteActivity.class);
                break;
        }
    }


}
