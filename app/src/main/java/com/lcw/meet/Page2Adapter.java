package com.lcw.meet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Page2Adapter extends RecyclerView.Adapter {
    ArrayList<Page2Item> datas;
    Context context;

    public Page2Adapter(ArrayList<Page2Item> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.page2_item,parent,false);

        VH vh=new VH(itemView); // itemView가 가지고 있는 카드뷰가 전달됨

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder; //명시적 다운 캐스팅

        Page2Item ite= datas.get(position);

//        vh.tvMsg.setText(ite.msg);

//        Glide.with(context).load(ite.imgPath).into(vh.ivDaily);
        Picasso.get().load(ite.imgPath).into(vh.ivDaily);


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //이너클래스 : 아이템뷰를 보관하는 클래스
    class VH extends RecyclerView.ViewHolder{

        ImageView ivDaily;


        public VH(@NonNull View itemView) {
            super(itemView);

            ivDaily=itemView.findViewById(R.id.iv_page2img);


            //일상 사진 눌렀을 때
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= getLayoutPosition();
                    Intent intent= new Intent(context, Page2DailyActivity.class);
                    intent.putExtra("position",position);
                    context.startActivity(intent);

                }
            });

        }
    }
}
