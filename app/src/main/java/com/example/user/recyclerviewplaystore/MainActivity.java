package com.example.user.recyclerviewplaystore;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView vertical_recycler_view,horizontal_recycler_view;
    private ArrayList<String> horizontalList,verticalList;
    private HorizontalAdapter horizontalAdapter;
    private  VerticalAdapter verticalAdapter;
    private int[] images={R.drawable.insta,R.drawable.gmail,R.drawable.watsupp};
    private int[] images1={R.drawable.dice,R.drawable.lollypop,R.drawable.knife};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        horizontal_recycler_view=(RecyclerView)findViewById(R.id.recyclrvw);
       vertical_recycler_view=(RecyclerView) findViewById(R.id.recycler2vw);
        horizontalList=new ArrayList<String>();
        horizontalList.add("Instagram ");
        horizontalList.add("Gmail");
        horizontalList.add("WatsApp");
        verticalList=new ArrayList<String>();
        verticalList.add("Dice");
        verticalList.add("Lollypop");
        verticalList.add("knife");
        horizontalAdapter=new HorizontalAdapter(horizontalList);
        verticalAdapter=new VerticalAdapter(verticalList);


        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        vertical_recycler_view.setLayoutManager(verticalLayoutmanager);

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);

        vertical_recycler_view.setAdapter(verticalAdapter);
        horizontal_recycler_view.setAdapter(horizontalAdapter);
    }




    public  class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {
        private List<String> horizontalList;

        public class MyViewHolder extends RecyclerView.ViewHolder
        {
            public TextView txtView;
            public ImageView image;
            public MyViewHolder(View view)
            {
                super(view);
                txtView=(TextView)view.findViewById(R.id.txtvw);
                image=(ImageView)view.findViewById(R.id.imgvw);
            }


        }
        public HorizontalAdapter(List<String> horizontalList) {
            this.horizontalList = horizontalList;
        }

        public MyViewHolder onCreateViewHolder(ViewGroup parent, int ViewType)
        {
            View itemview=LayoutInflater.from(parent.getContext()).inflate(R.layout.horiscrn,parent,false);
            return new MyViewHolder(itemview);
        }



        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.image.setImageResource(images[position]);
            holder.txtView.setText(horizontalList.get(position));
            holder.txtView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,holder.txtView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return horizontalList.size();

        }
        }
    public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {

        private List<String> verticalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView ttvw;
            public ImageView imgs;

            public MyViewHolder(View view) {
                super(view);
                ttvw = (TextView) view.findViewById(R.id.vertext);
                 imgs=(ImageView) view.findViewById(R.id.imgvw1);
            }
        }


        public VerticalAdapter(List<String> verticalList) {
            this.verticalList = verticalList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView1 = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.vertical, parent, false);

            return new MyViewHolder(itemView1);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.imgs.setImageResource(images1[position]);
            holder.ttvw.setText(verticalList.get(position));
            holder.ttvw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MainActivity.this,holder.ttvw.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return verticalList.size();
        }
    }

}

