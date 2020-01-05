package com.example.hp.android_final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFragment4 extends Fragment {
    private ListView listview;
    private String[] time = new String[]{ "01月22日-01月27日","02月02日-02月03日","03月26日-03月31日","04月05日-04月07日","04月21日-04月28日",
                                            "05月28日-06月02日","06月04日-06月09日","06月12日-06月16日","06月20日-06月30日","07月02日-07月07日",
                                            "07月09日-07月14日","07月03日-07月14日","07月26日-08月11日","08月13日-08月18日","08月20日-08月25日",
                                            "09月03日-09月08日","09月14日-09月22日","10月01日-10月06日","10月08日-10月13日","10月18日-10月20日",
                                            "10月25日-10月27日","11月07日-11月10日","11月12日-11月17日","11月24日-12月01日","12月12日-12月15日"};
    private String[] name = new String[]{ "匈牙利公开赛","欧洲十六强赛","卡塔尔公开赛","乒球亚洲杯","单项世乒赛",
                                            "中国公开赛","中国香港公开赛","日本公开赛","欧运会","韩国公开赛",
                                            "澳大利亚公开赛","第30届世界大运会","泛美运动会","保加利亚公开赛","捷克公开赛",
                                            "欧锦赛","亚锦赛","瑞典公开赛","德国公开赛","女乒世界杯" ,
                                            "男乒世界杯","世界杯团体赛","奥地利公开赛","世青赛","国际乒联总决赛"};
    private String[] place = new String[]{"布达佩斯","蒙特勒","多哈","横滨","布达佩斯",
                                            "深圳","香港","札幌","明斯克","待定",
                                            "吉朗","那不勒斯","利马","帕纳久里什泰","奥洛穆茨",
                                            "南特","巴厘岛","斯德哥尔摩","不莱梅","成都" ,
                                            "成都","东京","林茨","待定","待定"};
    public MyFragment4() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fourth_page,container,false);
        listview = (ListView)view.findViewById(R.id.listview);
        List<Map<String, Object>> list = getData();
        listview.setAdapter(new ScheduleAdapter(getActivity(), list));
        return view;
    }
    public List<Map<String , Object>> getData(){
        List<Map<String , Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0 ; i <time.length ; i++){
            Map<String , Object> map = new HashMap<String ,  Object>();
            map.put("time", time[i]);
            map.put("name",name[i]);
            map.put("place",place[i]);
            list.add(map);
        }
        return list ;
    }
}
