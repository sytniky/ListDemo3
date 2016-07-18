package edu.hillel.listdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuriy on 17.07.16.
 */
public class MyListActivity extends ListActivity {

    MyArrayAdapter mAdapter;
    private LinkedList<Goods> goodsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        mAdapter = new MyArrayAdapter(this, (List<Goods>) goodsArray.clone());
//        setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, data));
//        setListAdapter(new MyArrayAdapter(this, goodsArray));
        setListAdapter(mAdapter);
    }

    private void initData() {
        goodsArray = new LinkedList<>();
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 1", "Model Table 1", 300.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 2", "Model Table 2", 201.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 3", "Model Table 3", 99.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 1", "Model Table 1", 300.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 2", "Model Table 2", 201.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 3", "Model Table 3", 99.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 1", "Model Table 1", 300.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 2", "Model Table 2", 201.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 3", "Model Table 3", 99.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 1", "Model Table 1", 300.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 2", "Model Table 2", 201.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 3", "Model Table 3", 99.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 1", "Model Table 1", 300.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 2", "Model Table 2", 201.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 3", "Model Table 3", 99.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 1", "Model Table 1", 300.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 2", "Model Table 2", 201.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 3", "Model Table 3", 99.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 1", "Model Table 1", 300.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 2", "Model Table 2", 201.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 3", "Model Table 3", 99.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 1", "Model Table 1", 300.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 2", "Model Table 2", 201.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 3", "Model Table 3", 99.1));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Goods goods = (Goods) mAdapter.getItem(position);
        mAdapter.remove(goods);
        Toast.makeText(this, goods.getTitle() + " was removed, size: "
                + goodsArray.size(), Toast.LENGTH_SHORT).show();
    }
}
