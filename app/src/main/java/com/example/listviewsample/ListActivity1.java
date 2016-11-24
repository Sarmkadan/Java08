package com.example.listviewsample;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity1 extends android.app.ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources r = getResources();
        String[] stationsArray = r.getStringArray(R.array.stations);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                R.layout.list_item, stationsArray);
        setListAdapter(aa);
        ListView lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                CharSequence text = ((TextView) v).getText().toString();
                /*int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();
                Toast.makeText(context, text, duration).show();*/
                Intent intent = new Intent();
                intent.putExtra("name",text);
                setResult(RESULT_OK,intent);
                Log.d("MyLog","finish");
                finish();
            }
        });

    }

}
