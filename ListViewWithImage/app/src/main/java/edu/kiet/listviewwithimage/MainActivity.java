package edu.kiet.listviewwithimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int images[]={R.mipmap.books,R.mipmap.computer,R.mipmap.disc,R.mipmap.drive,R.mipmap.glob,R.mipmap.printer,R.mipmap.star,R.mipmap.music};
    String imageName[]={"Books","Computer","Disc","Drive","Glob","Printer","Star","Music"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.mylistview);
        MyCustomBaseAdapter adapter =new MyCustomBaseAdapter(MainActivity.this,images,imageName);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"You clicked on "+imageName[position], Toast.LENGTH_SHORT).show();

            }
        });

    }
}