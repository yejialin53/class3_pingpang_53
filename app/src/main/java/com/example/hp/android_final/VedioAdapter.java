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

public class VedioAdapter extends BaseAdapter {
    private List<Map<String , Object>> data ;
    private LayoutInflater layoutInflater ;
    private Context context ;
    public VedioAdapter(Context context , List<Map<String , Object>> data ){
        this.context = context ;
        this.data = data ;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public final class Vedio{
        public ImageView image ;
        public TextView titles ;
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
        Vedio vs = null;
        if (convertView == null) {
            vs = new Vedio();
            convertView = layoutInflater.inflate(R.layout.vedio_item ,null);
            vs.image = (ImageView)convertView.findViewById(R.id.image);
            vs.titles = (TextView)convertView.findViewById(R.id.titles);
            convertView.setTag(vs);
        }else{
            vs = (Vedio)convertView.getTag();
        }
        vs.image.setBackgroundResource((Integer)data.get(position).get("image"));
        vs.titles.setText((String)data.get(position).get("titles"));
        return convertView ;
    }
}
