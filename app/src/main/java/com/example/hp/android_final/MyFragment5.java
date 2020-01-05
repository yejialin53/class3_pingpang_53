package com.example.hp.android_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFragment5 extends Fragment {
    private ListView listview;
    private String[] titles = new String[]{"樊振东十佳球","马龙十佳球","刘诗雯十佳球","陈梦十佳球"};
    private int[] image  = new int[]{R.mipmap.fanshi ,R.mipmap.mashi,R.mipmap.liushi,R.mipmap.chenshi};
    public MyFragment5() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fifth_page,container,false);
        listview = (ListView)view.findViewById(R.id.listview);
        List<Map<String, Object>> list = getData();
        listview.setAdapter(new VedioAdapter(getActivity(), list));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null ;
                switch(position){
                    case 0 :
                        intent = new Intent(parent.getContext(),Main3Activity.class);
                        break;
                    case 1 :
                        intent = new Intent(parent.getContext(),Main4Activity.class);
                        break;
                    case 2 :
                        intent = new Intent(parent.getContext(),Main5Activity.class);
                        break;
                    case 3 :
                        intent = new Intent(parent.getContext(),Main6Activity.class);
                        break;
                }
                startActivity(intent);
            }
        });
        return view;
    }
    public List<Map<String , Object>> getData(){
        List<Map<String , Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0 ; i <titles.length ; i++){
            Map<String , Object> map = new HashMap<String ,  Object>();
            map.put("image",image[i]);
            map.put("titles", titles[i]);
            list.add(map);
        }
        return list ;
    }
}
