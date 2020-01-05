package com.example.hp.android_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ScheduleAdapter extends BaseAdapter {
    private List<Map<String , Object>> data ;
    private LayoutInflater layoutInflater ;
    private Context context ;
    public ScheduleAdapter(Context context , List<Map<String , Object>> data ){
        this.context = context ;
        this.data = data ;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public final class schedule{
        public TextView time ;
        public TextView name ;
        public TextView place ;
    }
    public int getCount(){
        return data.size();
    }
    public Object getItem(int position){
        return data.get(position);
    }
    public long getItemId(int position){
        return position ;
    }
    public View getView(int position , View convertView , ViewGroup parent){
        schedule sc = null;
        if (convertView == null) {
           sc = new schedule();
            convertView = layoutInflater.inflate(R.layout.schedule_item,null);
            sc.time = (TextView)convertView.findViewById(R.id.time);
            sc.name = (TextView)convertView.findViewById(R.id.name);
            sc.place = (TextView)convertView.findViewById(R.id.place);
            convertView.setTag(sc);
        }else{
            sc = (schedule)convertView.getTag();
        }
        sc.time.setText((String)data.get(position).get("time"));
        sc.name.setText((String)data.get(position).get("name"));
        sc.place.setText((String)data.get(position).get("place"));
        return convertView ;
    }
}
