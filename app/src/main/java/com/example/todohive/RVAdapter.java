package com.example.todohive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todohive.databinding.ListRowBinding;

public class RVAdapter extends ListAdapter<Note, RVAdapter.ViewHolder> {

    public RVAdapter(MainActivity mainActivity) {
        super(CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note> CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) && oldItem.getDisp().equals(newItem.getDisp());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = getNote(position);
        holder.binding.title.setText(note.getTitle());
        holder.binding.disp.setText(note.getDisp());
    }

    public Note getNote(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ListRowBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ListRowBinding.bind(itemView);
        }
    }
}
