package com.mahmodjaf.newprojectmahmod.data.MytaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class MyTask {
    @PrimaryKey(autoGenerate = true)
    public long keyId;

    public int importance;

    public String shortTitle;

    public String text;

    public long startTime;

    public boolean isCompleted;

    public long subId;

    public long usrId;

    }
