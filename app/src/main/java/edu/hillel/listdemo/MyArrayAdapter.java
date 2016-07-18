package edu.hillel.listdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by yuriy on 17.07.16.
 */
public class MyArrayAdapter extends ArrayAdapter<Goods> {

    LayoutInflater mInfleter;

    public MyArrayAdapter(Context context, List<Goods> objects) {
        super(context, R.layout.list_item, objects);
        mInfleter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ItemViewHolder vh;

        if (view == null) { // view is shown for the first time
            view = mInfleter.inflate(R.layout.list_item, parent, false);
            vh = new ItemViewHolder(view);
            view.setTag(vh);
        } else { // view was shown earlier
            vh = (ItemViewHolder) view.getTag();
        }

        Goods goods = getItem(position);
        vh.setData(goods);
        return view;


//        ImageView ivItem = (ImageView) view.findViewById(R.id.ivImage);
//        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
//        TextView tvDesc = (TextView) view.findViewById(R.id.tvDesc);
//        TextView tvCost = (TextView) view.findViewById(R.id.tvCost);

//        Goods goods = getItem(position);
//
//        ivItem.setImageResource(goods.getIconId());
//        tvTitle.setText(goods.getTitle());
//        tvDesc.setText(goods.getDesc());
//        tvCost.setText(String.valueOf(goods.getCost()));
//
//        if (goods.getCost() < 100) {
//            RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.rlLayout);
//            rl.setBackgroundColor(0xFF00FF00);
//        }
//
//        return view;
    }

    public class ItemViewHolder {
        private ImageView ivItem;
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvCost;

        public ItemViewHolder(View view) {
            ivItem = (ImageView) view.findViewById(R.id.ivImage);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvDesc = (TextView) view.findViewById(R.id.tvDesc);
            tvCost = (TextView) view.findViewById(R.id.tvCost);
        }

        public void setData(Goods goods) {
            ivItem.setImageResource(goods.getIconId());
            tvTitle.setText(goods.getTitle());
            tvDesc.setText(goods.getDesc());
            tvCost.setText(String.valueOf(goods.getCost()));
        }
    }
}
