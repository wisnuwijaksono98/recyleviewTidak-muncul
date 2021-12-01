package com.example.submission2;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.submission2.databinding.ListRowUserBinding;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private ArrayList<Model> modelArrayList;

    public ListAdapter(ArrayList<Model> list) {
        this.modelArrayList = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ListRowUserBinding binding = ListRowUserBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Model model = modelArrayList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(model.getAvatar())
                .circleCrop()
                .into(holder.binding.imgAvatar);
        holder.binding.tvName.setText(model.getName());
        holder.binding.tvUsername.setText(model.getUsername());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.GET_DATA, (Parcelable) model);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        private final ListRowUserBinding binding;

        public ListViewHolder(ListRowUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
//            TextView tvName, tvUsername;
//            ImageView imgAvatar;
//            public ListViewHolder(View view) {
//            super(view);
//            tvName = view.findViewById(R.id.tv_name);
//            tvUsername = view.findViewById(R.id.tv_username);
//            imgAvatar = view.findViewById(R.id.img_avatar);
//        }

    }

    public void filterList(ArrayList<Model> filterList){
        modelArrayList = filterList;
        notifyDataSetChanged();
    }
}
