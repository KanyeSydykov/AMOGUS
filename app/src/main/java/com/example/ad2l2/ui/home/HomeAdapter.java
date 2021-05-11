package com.example.ad2l2.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ad2l2.databinding.ListItemBinding;
import com.example.ad2l2.ui.App;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter <HomeAdapter.HomeViewHolder> {
    private ListItemBinding listItemBinding;
    private Listen listen;
    private List<HomeModel> list = new ArrayList<>();

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.onBind(list.get(position), listen);
        if (position % 2 == 0) {
            listItemBinding.holder.setBackgroundColor(Color.CYAN);

        } else {
            listItemBinding.holder.setBackgroundColor(Color.YELLOW);
        }
        holder.onBind(list.get(position), listen);
    }

    public HomeAdapter(Listen listen) {

        this.listen = listen;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(List<HomeModel> homeModel) {
        list.addAll(homeModel);
        notifyDataSetChanged();
    }

    public HomeModel getModelTold(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return list.get(i);
            }

        }return null;
    }
     public void addItemList(List<HomeModel> homeModelList){
        list = homeModelList;
        notifyDataSetChanged();
     }



    class HomeViewHolder extends  RecyclerView.ViewHolder{
        public HomeViewHolder(@NonNull ListItemBinding itemView) {


            super(itemView.getRoot());
            listItemBinding = itemView;
        }
        public void onBind(HomeModel homeModel, Listen listen){
        listItemBinding.nameItem.setText(homeModel.getTitle());
        listItemBinding.numberItem.setText(homeModel.getDescription());
//        listItemBinding.date.setText(homeModel.getDate());
        listItemBinding.getRoot().setOnClickListener(v -> {
         listen.setDatForFrom(homeModel,getAdapterPosition());

        });
        listItemBinding.getRoot().setOnLongClickListener(v -> {
            AlertDialog.Builder adg = new AlertDialog.Builder(listItemBinding.getRoot().getContext());
            String positive = "Да";
            String negative = "Нет";
            adg.setMessage("Вы хотите удалить?");
            adg.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    App.fillDatabase.fillDao().delete(list.get(getAdapterPosition()));
                    notifyItemChanged(getAdapterPosition());

                }
            });
            adg.setNegativeButton(negative, null);
            adg.show();
            return true;
        });
        }

    }

}
