package com.example.room_recyclerview_integration.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room_recyclerview_integration.R;
import com.example.room_recyclerview_integration.model.ProjectModel;
import com.example.room_recyclerview_integration.util.ListDiffUtil;

import java.util.List;

public class ViewRecordsAdapter extends RecyclerView.Adapter<ViewRecordsAdapter.ViewHolder> {

    private List<ProjectModel> projectModels;

    public ViewRecordsAdapter(List<ProjectModel> projectModels) {
        this.projectModels = projectModels;
    }

    @NonNull
    @Override
    public ViewRecordsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProjectModel projectModel = projectModels.get(position);
        holder.textData.setText(projectModel.getTextData());
    }

    @Override
    public int getItemCount() {
        return projectModels.size();
    }

    public void addUpdatedList(List<ProjectModel> newProjectModels) {
        ListDiffUtil listDiffUtil = new ListDiffUtil(projectModels, newProjectModels);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(listDiffUtil);
        projectModels.clear();
        projectModels.addAll(newProjectModels);
        diffResult.dispatchUpdatesTo(this);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textData = (TextView) itemView.findViewById(R.id.list_item_text);
        }
    }
}
