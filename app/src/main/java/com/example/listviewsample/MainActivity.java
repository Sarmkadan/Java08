package com.example.listviewsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvname;
    Button btnname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvname = (TextView) findViewById(R.id.textView3);
        btnname = (Button) findViewById(R.id.button2);
        btnname.setOnClickListener(this);

        registerForContextMenu(tvname);
    }

    public void onClick(View v){
        Intent newintent = new Intent(this,ListActivity1.class);
        startActivityForResult(newintent,1);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.textView3:
                menu.add(0,1,0,"скинути");
                menu.add(0,2,0,"контекст(XML)");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 1:
                tvname.setText("Виберіть станцію");
                break;
            case 2:
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK) {
            if (data == null) {
                return;
            }
            String name = data.getStringExtra("name");
            tvname.setText(name);
        }else{
            tvname.setText("Ви не вибрали станцію");
        }
    }
}
