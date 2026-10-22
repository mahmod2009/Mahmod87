package com.mahmodjaf.newprojectmahmod.model.MytaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class MyTask {
    @PrimaryKey(autoGenerate = true)
    public long userid;

    public int importance;

    public String shortTitle;

    public String text;

    public long startTime;

    public boolean isCompleted;

    public long subId;

    public long KeyId;

    public long taskId;


    public String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getKeyId() {
        return KeyId;
    }

    public void setKeyId(long keyId) {
        KeyId = keyId;
    }

    public long getSubId() {
        return subId;
    }

    public void setSubId(long subId) {
        this.subId = subId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
