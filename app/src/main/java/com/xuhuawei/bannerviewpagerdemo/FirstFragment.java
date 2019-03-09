package com.xuhuawei.bannerviewpagerdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xuhuawei.bannerviewpagerdemo.adapters.BannerViewAdapter;
import com.xuhuawei.bannerviewpagerdemo.anim.BannerTransformer;
import com.xuhuawei.bannerviewpagerdemo.beans.BannerItem;
import com.xuhuawei.bannerviewpagerdemo.views.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private View view;
    private ListView listView;
    private BannerViewAdapter adapter;
    private BannerViewPager bannerViewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view=inflater.inflate(R.layout.fragment_first,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.listView);
        View headerView=LayoutInflater.from(view.getContext()).inflate(R.layout.layout_header_banner,null);
        bannerViewPager=headerView.findViewById(R.id.bannerView);
        adapter=new BannerViewAdapter(bannerViewPager);
        bannerViewPager.setPageTransformer(false,new BannerTransformer(bannerViewPager,adapter));
        List<BannerItem> dataList=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            BannerItem item=new BannerItem();
            dataList.add(item);
        }
        adapter.addCardItemAll(dataList);
        bannerViewPager.setAdapter(adapter);

        listView.addHeaderView(headerView);

        String[] names = new String[100];
        for (int i = 0; i < 100; i++) {
            names[i] = "Item-" + i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.adapter_listview_item, R.id.text_name, names);
        listView.setAdapter(adapter);
    }
}
