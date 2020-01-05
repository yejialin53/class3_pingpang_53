package com.example.hp.android_final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFragment2 extends Fragment {
    private ListView listview_men ;
    private ListView listview_women ;
    private String[] number = new String[]{"1","2","3","4","5","6","7","8","9","10"};
    private String[] name = new String[]{"樊振东","许昕","林高远","波尔","奥恰洛夫","马龙","李尚洙","张本智和","黄镇廷","雨果"};
    private int[] imageId = new int[]{R.mipmap.guoqi , R.mipmap.guoqi , R.mipmap.guoqi,R.mipmap.deguo,R.mipmap.deguo,R.mipmap.guoqi,R.mipmap.hanguo,R.mipmap.riben,R.mipmap.xainggang,R.mipmap.baxi};

    private String[] number_w = new String[]{"1","2","3","4","5","6","7","8","9","10"};
    private String[] name_w = new String[]{"朱雨玲","刘诗雯","陈梦","石川佳纯","王曼昱","丁宁","伊藤美诚","郑怡静","平野美宇","陈幸同"};
    private int[] imageId_w = new int[]{R.mipmap.guoqi , R.mipmap.guoqi , R.mipmap.guoqi,R.mipmap.riben,R.mipmap.guoqi,R.mipmap.guoqi,R.mipmap.riben,R.mipmap.taibei,R.mipmap.riben,R.mipmap.guoqi};
    public MyFragment2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_page,container,false);
        listview_men = (ListView)view.findViewById(R.id.listview_men);
        List<Map<String, Object>> list = getData();
        listview_men.setAdapter(new RankingAdapter(getActivity(), list));

        listview_women = (ListView)view.findViewById(R.id.listview_women);
        List<Map<String, Object>> list1 = getData1();
        listview_women.setAdapter(new RankingAdapter(getActivity(), list1));
        return view;
    }

    public List<Map<String , Object>> getData(){
        List<Map<String , Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0 ; i <number.length ; i++){
            Map<String , Object> map = new HashMap<String ,  Object>();
            map.put("image", imageId[i]);
            map.put("number",number[i]);
            map.put("name",name[i]);
            list.add(map);
        }
        return list ;
    }
    public List<Map<String , Object>> getData1(){
        List<Map<String , Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0 ; i <number.length ; i++){
            Map<String , Object> map = new HashMap<String ,  Object>();
            map.put("image", imageId_w[i]);
            map.put("number",number_w[i]);
            map.put("name",name_w[i]);
            list.add(map);
        }
        return list ;
    }
}
