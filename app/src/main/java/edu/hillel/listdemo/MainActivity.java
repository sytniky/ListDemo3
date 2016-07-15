package edu.hillel.listdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private LinkedList<Goods> goodsArray;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGoods();

        Button button = (Button) findViewById(R.id.btnShuffle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAdapter.filterData(100);
                myAdapter.notifyDataSetChanged();
            }
        });

        ListView list = (ListView) findViewById(R.id.lvList);
        list.setOnItemClickListener(this);
        list.setOnItemLongClickListener(this);

        myAdapter = new MyAdapter(this, goodsArray);
        list.setAdapter(myAdapter);
     }

    private void initGoods() {
        goodsArray = new LinkedList<>();
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 1", "Model Table 1", 300.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 2", "Model Table 2", 201.1));
        goodsArray.add(new Goods(android.R.drawable.alert_dark_frame, "Table 3", "Model Table 3", 99.1));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        Goods curGoods = myAdapter.getItem(pos);
        Toast.makeText(this, curGoods.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Goods curGoods = myAdapter.getItem(i);
        goodsArray.remove(curGoods);
        myAdapter.notifyDataSetChanged();
        return true;
    }
}
