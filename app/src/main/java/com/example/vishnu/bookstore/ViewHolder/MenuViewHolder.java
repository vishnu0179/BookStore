package com.example.vishnu.bookstore.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vishnu.bookstore.Interface.ItemClickListener;
import com.example.vishnu.bookstore.R;

/**
 * Created by Vishnu on 05/08/2018.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView year;
    public TextView subject;

    private ItemClickListener itemClickListener;


    public MenuViewHolder(View itemView) {
        super(itemView);

        year = (TextView)itemView.findViewById(R.id.year);
        subject =(TextView) itemView.findViewById(R.id.subject);

        itemView.setOnClickListener(this);


    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false );
    }
}
