package edu.kiet.menuexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button showDialog, showPopup;
    TextView showContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialog=findViewById(R.id.btnShowDialog);
        showContext=findViewById(R.id.txtShowContext);
        showPopup=findViewById(R.id.btnShowPopup);
        showPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),showPopup);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId())
                        {
                            case R.id.item1:
                                Toast.makeText(getApplicationContext(),"You clicked on Item 1",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item2:
                                Toast.makeText(getApplicationContext(),"You clicked on Item 2",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item3:
                                Toast.makeText(getApplicationContext(),"You clicked on Item 3",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item4:
                                Toast.makeText(getApplicationContext(),"You clicked on Item 4",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();

            }
        });
        registerForContextMenu(showContext);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
               builder.setTitle("Show Message");
               builder.setIcon(R.mipmap.person);
                builder.setMessage("Do you want to show message?");
               //builder.setView(R.layout.alertresource);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You selected YES!",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You selected NO!",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,"Insert");
        menu.add(0,2,0,"Delete");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case 1:
                Toast.makeText(getApplicationContext(),"You clicked on Insert",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(),"You clicked on Delete",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.open:
                Toast.makeText(getApplicationContext(),"You clicked on open",Toast.LENGTH_SHORT).show();
                break;
            case R.id.close:
                Toast.makeText(getApplicationContext(),"You clicked on close",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Profile:
                Toast.makeText(getApplicationContext(),"You clicked on Profile",Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_bar_switch:
                Toast.makeText(getApplicationContext(),"You clicked on switch",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}