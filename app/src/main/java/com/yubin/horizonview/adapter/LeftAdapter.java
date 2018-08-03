package com.yubin.horizonview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yubin.horizonview.R;
import com.yubin.horizonview.bean.Product;

import java.util.List;

/**
 * author : Yubin.Ying
 * time : 2018/8/2
 */
public class LeftAdapter extends ArrayAdapter<Product> {
    List<Product> mList;
    public LeftAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        this.mList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(getContext(), R.layout.item_left, null);
            viewHolder.tv_item = (TextView)convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.tv_item.setText(mList.get(position).getName());
        return convertView;
    }

    @Override
    public int getCount() {
        return mList.size();

    }

    @Override
    public Product getItem(int position){
        if(mList != null && mList.size()>0){
            return mList.get(position);
        }else{
            return null;
        }

    }

    class ViewHolder {
        TextView tv_item;
    }
}
