package edu.hillel.listdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] data = {"1", "2", "3", "4", "5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.lvList);
        list.setOnItemClickListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);



        GridView grid = (GridView) findViewById(R.id.gvGrid);
        grid.setOnItemClickListener(this);

        ArrayAdapter gridAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        grid.setAdapter(gridAdapter);



        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, data);
        spinner.setAdapter(spinnerAdapter);
     }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
//        String[] data = getResources().getStringArray(R.array.data);
        Toast.makeText(this, data[pos], Toast.LENGTH_SHORT).show();
    }
}
