package com.mahmodjaf.newprojectmahmod.data.MySubjectTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface MySubjectQuery {
    void insert(MySubject s1);

    @Dao
    public interface mySubjectQuery {

        /**
         * إعادة جميع متطلبات جدول المواضيع
         * @return * قائمة من المواضيع
         */
        @Query("SELECT * FROM MySubject")
        List<MySubject> getAllSubjects();

        /**
         * ادخال مهام
         * @param s * مجموعة مهام
         */
        @Insert
        void insert(MySubject... s); // ثلاثة نقاط تعني مجموعة

        /**
         * تعديل المهام
         * @param s
         */
        @Update
        void update(MySubject... s);

        /**
         * حذف مهمة او مهام
         * @param s * حذف المهام (حسب المفتاح الرئيسي)
         */
        @Delete
        void deleteTask(MySubject... s);

        @Query("DELETE FROM MySubject WHERE key_id=:keyid")
        void delete(long keyid);

        @Query("SELECT * FROM MySubject WHERE title=:sub")
        MySubject checkSubject(String sub);

    }
}
