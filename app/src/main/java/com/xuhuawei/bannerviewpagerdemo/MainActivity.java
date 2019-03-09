package com.xuhuawei.bannerviewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xuhuawei.bannerviewpagerdemo.adapters.MainVPAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MainVPAdapter adapter;
    private TextView textViews[]=new TextView[4];
    private View itemView[]=new View[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViews[0]=findViewById(R.id.text0);
        textViews[1]=findViewById(R.id.text1);
        textViews[2]=findViewById(R.id.text2);
        textViews[3]=findViewById(R.id.text3);

        itemView[0]=findViewById(R.id.view0);
        itemView[1]=findViewById(R.id.view1);
        itemView[2]=findViewById(R.id.view2);
        itemView[3]=findViewById(R.id.view3);

        for (int i = 0; i <4 ; i++) {
            textViews[i].setTag(i++);
            textViews[i].setOnClickListener(onClickListener);
            itemView[i].setVisibility(View.INVISIBLE);
        }


        viewPager=findViewById(R.id.viewPager);
        List<Fragment> fragmentList=new ArrayList<>();
        Fragment oneFragment=Fragment.instantiate(this, OtherFragment.class.getName());
        Fragment firstFragment=Fragment.instantiate(this, FirstFragment.class.getName());
        Fragment threeFragment=Fragment.instantiate(this, OtherFragment.class.getName());
        Fragment fourFragment=Fragment.instantiate(this, OtherFragment.class.getName());
        fragmentList.add(oneFragment);
        fragmentList.add(firstFragment);
        fragmentList.add(threeFragment);
        fragmentList.add(fourFragment);
        adapter=new MainVPAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);

        viewPager.setCurrentItem(1);
        itemView[1].setVisibility(View.VISIBLE);
    }
    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer position= (Integer) v.getTag();
            viewPager.setCurrentItem(position);
        }
    };
    private ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }
        @Override
        public void onPageSelected(int i) {
            for (int j = 0; j < 4; j++) {
                if (j==i){
                    itemView[j].setVisibility(View.VISIBLE);
                }else{
                    itemView[j].setVisibility(View.INVISIBLE);
                }
            }
        }
        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
