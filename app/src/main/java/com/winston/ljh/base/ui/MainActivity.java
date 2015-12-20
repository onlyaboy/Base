package com.winston.ljh.base.ui;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.RequestParams;
import com.winston.ljh.base.DataInterface.DataInterface;
import com.winston.ljh.base.R;
import com.winston.ljh.base.entry.response.Response;
import com.winston.ljh.base.ui.base.BaseActivity;
import com.winston.ljh.base.util.http.HttpResponse;

public class MainActivity extends BaseActivity {
    private ListView listView;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void findView() {
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        listView = (ListView) findViewById(R.id.listView);
    }

    @Override
    protected void initListener() {
        fab.setOnClickListener(this);
    }

    @Override
    protected void initUI() {
//        setSupportActionBar(toolbar);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.fab:
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                return;
        }
    }
}
