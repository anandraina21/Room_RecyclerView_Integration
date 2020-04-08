package com.example.room_recyclerview_integration.util;

import androidx.recyclerview.widget.DiffUtil;

import com.example.room_recyclerview_integration.model.ProjectModel;

import java.util.List;

public class ListDiffUtil extends DiffUtil.Callback {
    List<ProjectModel> oldList;
    List<ProjectModel> newList;

    public ListDiffUtil(List<ProjectModel> oldList, List<ProjectModel> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
