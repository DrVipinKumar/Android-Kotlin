package edu.kiet.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    Context context;
    int [] image;
    String [] imageName;
    LayoutInflater layoutInflater;
    public RecyclerAdapter( Context context, int[] image, String[] imageName) {
        this.context=context;
        this.image=image;
        this.imageName=imageName;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.recyclerlayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
                    holder.image.setImageResource(image[position]);
                    holder.imageName.setText(imageName[position]);
                    holder.imageName.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,"You clicked on "+imageName[position],Toast.LENGTH_SHORT).show();

                        }
                    });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView imageName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);
            imageName=itemView.findViewById(R.id.textView);
        }
    }
}
