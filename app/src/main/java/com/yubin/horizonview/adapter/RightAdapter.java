package com.yubin.horizonview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yubin.horizonview.R;
import com.yubin.horizonview.bean.Product;
import com.yubin.horizonview.utils.NumberUtil;

import java.util.List;

/**
 * author : Yubin.Ying
 * time : 2018/8/2
 */
public class RightAdapter extends ArrayAdapter<Product> {
    List<Product> mList;

    public RightAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        mList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(getContext(), R.layout.item_right, null);
            viewHolder.tv_item1 = (TextView) convertView.findViewById(R.id.tv_item1);
            viewHolder.tv_item2 = (TextView) convertView.findViewById(R.id.tv_item2);
            viewHolder.tv_item3 = (TextView) convertView.findViewById(R.id.tv_item3);
            viewHolder.tv_item4 = (TextView) convertView.findViewById(R.id.tv_item4);
            viewHolder.tv_item5 = (TextView) convertView.findViewById(R.id.tv_item5);
            viewHolder.tv_item6 = (TextView) convertView.findViewById(R.id.tv_item6);
            viewHolder.tv_item7 = (TextView) convertView.findViewById(R.id.tv_item7);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Product product = mList.get(position);
        viewHolder.tv_item1.setText(NumberUtil.beautifulDouble(product.getLast()));
        viewHolder.tv_item2.setText(NumberUtil.beautifulDouble(product.getSell() - product.getLastClose()));
        viewHolder.tv_item3.setText(NumberUtil.beautifulDouble(product.getUpDownRate()));
        viewHolder.tv_item4.setText(NumberUtil.beautifulDouble(product.getOpen()));
        viewHolder.tv_item5.setText(NumberUtil.beautifulDouble(product.getHigh()));
        viewHolder.tv_item6.setText(NumberUtil.beautifulDouble(product.getLow()));
        viewHolder.tv_item7.setText(NumberUtil.beautifulDouble(product.getLastClose()));
        return convertView;
    }

    @Override
    public int getCount() {
        return mList.size();

    }

    @Override
    public Product getItem(int position) {
        if (mList != null && mList.size() > 0) {
            return mList.get(position);
        } else {
            return null;
        }
    }

    class ViewHolder {
        TextView tv_item1, tv_item2, tv_item3, tv_item4, tv_item5, tv_item6, tv_item7;
    }
}
