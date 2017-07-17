package com.ysr.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.ysr.timeline.adapter.TraceListAdapter;
import com.ysr.timeline.bean.ResultData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTrace;
    private List<ResultData.TracesBean> traceList = new ArrayList<>(10);
    private TraceListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTrace = (RecyclerView) findViewById(R.id.rvTrace);
        ResultData data = new Gson().fromJson(Data.data, ResultData.class);
        traceList = data.getTraces();
        adapter = new TraceListAdapter(this, traceList);
        rvTrace.setLayoutManager(new LinearLayoutManager(this));
        rvTrace.setAdapter(adapter);

    }
}
