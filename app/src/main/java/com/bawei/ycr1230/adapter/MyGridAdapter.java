package com.bawei.ycr1230.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.ycr1230.Bean.MyShopGridData;
import com.bawei.ycr1230.NetUlit;
import com.bawei.ycr1230.R;

import java.util.ArrayList;
import java.util.List;

public class MyGridAdapter extends BaseAdapter {
    private List<MyShopGridData> shopGridData=new ArrayList<>();
    private Context context;

    public MyGridAdapter(List<MyShopGridData> shopGridData, Context context) {
        this.shopGridData.addAll(shopGridData);
        this.context = context;
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int position) {
        return shopGridData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
           convertView= View.inflate(context, R.layout.item_grid,null);
            holder=new ViewHolder();
            holder.img=convertView.findViewById(R.id.imgs);
            holder.title=convertView.findViewById(R.id.titles);
            holder.price=convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        NetUlit netUlit = NetUlit.getNetUlit();
         netUlit.doPoson(shopGridData.get(position).getImageurl(),holder.img);
         holder.title.setText(shopGridData.get(position).getTitle());
         holder.price.setText(shopGridData.get(position).getPrice());
        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView title,price;
    }
}
