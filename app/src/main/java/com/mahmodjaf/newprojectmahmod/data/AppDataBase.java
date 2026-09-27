package com.mahmodjaf.newprojectmahmod.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mahmodjaf.newprojectmahmod.data.MySubjectTable.MySubject;
import com.mahmodjaf.newprojectmahmod.data.MySubjectTable.MySubjectQuery;
import com.mahmodjaf.newprojectmahmod.data.MyUserTable.MyUser;
import com.mahmodjaf.newprojectmahmod.data.MyUserTable.MyUserQuery;
import com.mahmodjaf.newprojectmahmod.data.MytaskTable.MyTask;
import com.mahmodjaf.newprojectmahmod.data.MytaskTable.MyTaskQuery;



/**
 * الفئة المسؤولة عن بناء قاعدة البيانات بكل جداولها
 * وتوفير كائن للتعامل مع قاعدة البيانات
 */
@Database(entities = {MyUser.class, MySubject.class, MyTask.class}, version = 1)
    public abstract class AppDataBase extends RoomDatabase {
        /**
         * كائن للتعامل مع قاعدة البيانات
         */
        private static AppDataBase db;

        /**
         * يعيد كائن لعمليات جدول المستخدمين
         * @return
         */
        public abstract MyUserQuery getMyUserQuery();

        /**
         * يعيد كائن لعمليات جدول المواضيع
         * @return
         */
        public abstract MySubjectQuery getMySubjectQuery();

        /**
         * يعيد كائن لعمليات جدول المهمات
         * @return
         */
        public abstract MyTaskQuery getMyTaskQuery();

        /**
         * بناء قاعدة البيانات وإعادة كائن يوفر عليها
         * @param context
         * @return
         */
        public static AppDataBase getDB(Context context){
            if(db==null)
            {
                db = Room.databaseBuilder(context,
                                AppDataBase.class,
                                "samirDataBase") //اسم قاعدة البيانات
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
            return db;
        }
    }

