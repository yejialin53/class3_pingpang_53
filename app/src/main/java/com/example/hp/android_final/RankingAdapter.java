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

public class RankingAdapter extends BaseAdapter {
    private List<Map<String , Object>> data ;
    private LayoutInflater layoutInflater ;
    private Context context ;
    public RankingAdapter(Context context , List<Map<String , Object>> data ){
        this.context = context ;
        this.data = data ;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public final class ranking_men{
        public ImageView image ;
        public TextView number ;
        public TextView name ;
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
        ranking_men rm = null;
        if (convertView == null) {
            rm = new ranking_men();
            convertView = layoutInflater.inflate(R.layout.ranking_item ,null);
            rm.image = (ImageView)convertView.findViewById(R.id.image);
            rm.number = (TextView)convertView.findViewById(R.id.number);
            rm.name = (TextView)convertView.findViewById(R.id.name);
            convertView.setTag(rm);
        }else{
            rm = (ranking_men)convertView.getTag();
        }
        rm.image.setBackgroundResource((Integer)data.get(position).get("image"));
        rm.number.setText((String)data.get(position).get("number"));
        rm.name.setText((String)data.get(position).get("name"));
        return convertView ;
    }
}
