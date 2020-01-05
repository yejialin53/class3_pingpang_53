package com.example.hp.android_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class NewsAdapter extends BaseAdapter {
private List<Map<String , Object>> data ;
private LayoutInflater layoutInflater ;
private Context context ;
public NewsAdapter(Context context , List<Map<String , Object>> data ){
    this.context = context ;
    this.data = data ;
    this.layoutInflater = LayoutInflater.from(context);
}

public final class News{
    public ImageView image ;
    public TextView title ;
    public TextView content ;
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
    News ns = null;
    if (convertView == null) {
        ns = new News();
        convertView = layoutInflater.inflate(R.layout.news_item ,null);
        ns.image = (ImageView)convertView.findViewById(R.id.image);
        ns.title = (TextView)convertView.findViewById(R.id.title);
        ns.content = (TextView)convertView.findViewById(R.id.content);
        convertView.setTag(ns);
    }else{
        ns = (News)convertView.getTag();
        }
        ns.image.setBackgroundResource((Integer)data.get(position).get("image"));
        ns.title.setText((String)data.get(position).get("title"));
        ns.content.setText((String)data.get(position).get("content"));
    return convertView ;
    }
 }
