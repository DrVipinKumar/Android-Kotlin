package edu.kiet.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String imageName[]={"Blub","Bookmark","Cup","Flag","Monitor","Mouse","Music","Person","Printer"};
    int image[]={R.mipmap.blub,R.mipmap.bookmark,R.mipmap.cup,R.mipmap.flag,R.mipmap.monitor,R.mipmap.mouse,R.mipmap.music,R.mipmap.person,R.mipmap.printer};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        RecyclerAdapter adapter =new RecyclerAdapter(getApplicationContext(),image,imageName);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}