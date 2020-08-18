package com.lishuaihua.headerrecyclerviewdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.lishuaihua.headerrecyclerviewdemo.adapter.GridAdapter;
import com.lishuaihua.view.HeaderRecyclerView;


public class MainActivity extends AppCompatActivity {

    private HeaderRecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = (HeaderRecyclerView) findViewById(R.id.rv_list);
        showHeaderRecyclerView();
    }


    private void showHeaderRecyclerView() {
        GridAdapter adapter = new GridAdapter(this);
        rvList.setLayoutManager(new GridLayoutManager(this, 2));
        rvList.setAdapter(adapter);
        View hv1 = LayoutInflater.from(this).inflate(R.layout.layout_header, rvList, false);
        View hv2 = LayoutInflater.from(this).inflate(R.layout.layout_header_view, rvList, false);
        View fv = LayoutInflater.from(this).inflate(R.layout.layout_footer_view, rvList, false);
        rvList.addHeaderView(hv1);
        rvList.addHeaderView(hv2);
        rvList.addFooterView(fv);
    }
}
