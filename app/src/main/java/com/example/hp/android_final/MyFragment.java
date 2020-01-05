package com.example.hp.android_final;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyFragment extends Fragment {
private ListView listview ;
private String[] title = new String[]{"中国乒协换届大会召开","陈梦“傻乎乎”的一天","“昕雯”联播再度合体"};
private String[] content = new String[]{"刘国梁正式出席乒协主席","赢了比赛还是要早起","许昕刘诗雯取得奥地利公开赛冠军"};
private int[] imageId = new int[]{R.mipmap.liu , R.mipmap.chen , R.mipmap.xuliu};
private Context mContext;

    private ViewFlipper vflp_help;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_page,container,false);
        vflp_help = (ViewFlipper) view.findViewById(R.id.vflp);
        vflp_help.setFlipInterval(3000);
        vflp_help.startFlipping();
        listview = (ListView)view.findViewById(R.id.listview);
        List<Map<String, Object>> list = getData();
        listview.setAdapter(new NewsAdapter(getActivity(), list));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = null ;
                        switch(position){
                            case 0 :
                                intent = new Intent(parent.getContext(),Main2Activity.class);
                                break;
                            case 1 :
                                intent = new Intent(parent.getContext(),Main7Activity.class);
                                break;
                            case 2 :
                                intent = new Intent(parent.getContext(),Main8Activity.class);
                                break;
                        }
                        startActivity(intent);
                }
        });
        return view;
    }
    public List<Map<String , Object>> getData(){
        List<Map<String , Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0 ; i <title.length ; i++){
            Map<String , Object> map = new HashMap<String ,  Object>();
            map.put("image", imageId[i]);
            map.put("title",title[i]);
            map.put("content",content[i]);
            list.add(map);
        }
        return list ;
    }

}


