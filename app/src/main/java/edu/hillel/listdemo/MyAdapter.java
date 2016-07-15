package edu.hillel.listdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.LinkedList;

/**
 * Created by yuriy on 13.07.16.
 */
public class MyAdapter extends BaseAdapter {

    private LinkedList<Goods> mGoods;
    private LinkedList<Goods> mFilteredGoods;
    private LayoutInflater mInfleter;

    public MyAdapter(Context c, LinkedList<Goods> goods) {
        mGoods = goods;
        mFilteredGoods = (LinkedList<Goods>) mGoods.clone();
        mInfleter = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mFilteredGoods.size();
    }

    @Override
    public Goods getItem(int i) {
        return mFilteredGoods.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInfleter.inflate(R.layout.list_item, viewGroup, false);
        ImageView ivItem = (ImageView) view.findViewById(R.id.ivImage);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvDesc = (TextView) view.findViewById(R.id.tvDesc);
        TextView tvCost = (TextView) view.findViewById(R.id.tvCost);

        Goods goods = getItem(i);

        ivItem.setImageResource(goods.getIconId());
        tvTitle.setText(goods.getTitle());
        tvDesc.setText(goods.getDesc());
        tvCost.setText(String.valueOf(goods.getCost()));

        if (goods.getCost() < 100) {
            RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.rlLayout);
            rl.setBackgroundColor(0xFF00FF00);
        }

        return view;
    }

//    public void shuffleData() {
//        Collections.shuffle(mGoods);
//    }

    public void filterData(int minConst) {
        LinkedList<Goods> newGoods = new LinkedList<>();
        for (int i = 0; i< mGoods.size(); i++) {
            if (mGoods.get(i).getCost() > minConst) {
                newGoods.add(mGoods.get(i));
            }
        }
        mFilteredGoods = newGoods;
        notifyDataSetChanged();
    }
}
