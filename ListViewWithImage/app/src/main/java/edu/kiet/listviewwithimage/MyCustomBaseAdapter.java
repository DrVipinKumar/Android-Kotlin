package edu.kiet.listviewwithimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyCustomBaseAdapter extends BaseAdapter {
    Context context;
    int [] images;
    String [] imageName;
    LayoutInflater layoutInflater;
    public MyCustomBaseAdapter(Context context, int[] images, String[] imageName) {
        this.context=context;
        this.imageName=imageName;
        this.images=images;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return imageName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.listviewlayout,parent,false);
        ImageView image;
        TextView name;
        image=view.findViewById(R.id.listImage);
        name=view.findViewById(R.id.txtTile);
        image.setImageResource(images[position]);
        name.setText(imageName[position]);
        return view;
    }
}
