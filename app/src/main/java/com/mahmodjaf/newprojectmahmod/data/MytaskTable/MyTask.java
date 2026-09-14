package com.mahmodjaf.newprojectmahmod.data.MytaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class MyTask {
    /**
     * فئة تمثل مهمة
     */
    @Entity
    public class myTask
    {
        @PrimaryKey(autoGenerate = true)
        /** رقم المهمة */
        public long keyId;
        /** درجة الاهمية 1-5 */
        public int importance;
        /** عنوان قصير */
        public String shortTitle;
        /** نص المهمة */
        public String text;
        /** زمن بناء المهمة */
        public long time;
        /** هل تمت المهمة */
        public boolean isCompleted;
        /** رقم موضوع المهمة */
        public long subId;
        /** رقم المستخدم الذي اضاف المهمة */
        public long userId;
    }
}
