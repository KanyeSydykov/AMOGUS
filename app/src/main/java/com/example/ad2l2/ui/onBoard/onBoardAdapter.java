package com.example.ad2l2.ui.onBoard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ad2l2.R;
import com.example.ad2l2.databinding.LayoutOnboardBinding;

public class onBoardAdapter extends RecyclerView.Adapter<onBoardAdapter.onBoardViewHolder> {
       private LayoutOnboardBinding binding;


    private String [] text =  new String[]{"2", "2","2"};
    private Integer[] gif = new Integer[]{R.raw.lottie1,R.raw.lottie2,R.raw.lottie3};

    @NonNull
    @Override
    public onBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new onBoardViewHolder(LayoutOnboardBinding.inflate
                (LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull onBoardViewHolder holder, int position) {

      holder.onBind();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class onBoardViewHolder extends RecyclerView.ViewHolder{
       private onBoardViewHolder(LayoutOnboardBinding itemView){
           super(itemView.getRoot());
           binding = itemView;

       }

        public void onBind(){
        binding.titlePager.setText(text[getAdapterPosition()]);
        binding.gif.setAnimation(gif[getAdapterPosition()]);
       }
    }
}


