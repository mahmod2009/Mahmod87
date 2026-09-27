package com.mahmodjaf.newprojectmahmod.data.MytaskTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * واجهة استعلامات على جدول مهام
 */
@Dao
public interface MyTaskQuery {

    /**
     * إعادة جميع معطيات جدول المهام
     * @return قائمة من المهام
     */
    @Query("SELECT * FROM MyTask ORDER BY importance DESC")
    List<MyTask> getAllTasks();

    /**
     * إرجاع المهام حسب المستخدم وإذا انتهت أم لا ومرتبة تنازلياً حسب الأهمية
     * @param user_id_p رقم المستخدم
     * @return قائمة مهام
     */
    @Query("SELECT * FROM MyTask WHERE userId=:user_id_p ORDER BY time DESC")
    LiveData<List<MyTask>> getAllTaskOrederBy(long user_id_p);

    /**
     * إرجاع المهام حسب المستخدم وإذا انتهت أم لا ومرتبة تنازلياً حسب الأهمية
     * @param user_id_p رقم المستخدم
     * @param isCompleted_p هل تمت أم لا
     * @return قائمة مهام
     */
    @Query("SELECT * FROM MyTask WHERE userId=:user_id_p AND isCompleted=:isCompleted_p " +
            "ORDER BY importance DESC")
    LiveData<List<MyTask>>getAllTaskOrederBy(long user_id_p, boolean isCompleted_p);

    /**
     * إدخال مهام
     * @param t * مجموعة مهام
     */
    @Insert
    void insertTask(MyTask... t); // ثلاثة نقاط تعني مجموعة

    /**
     * تعديل المهامات
     * @param tasks * مجموعة مهام للتعديل (التعديل حسب المفتاح الرئيسي)
     */
    @Update
    void updateTask(MyTask... tasks);

    /**
     * حذف مهمة او مهام *
     * @param tasks * حذف المهامات (حسب المفتاح الرئيسي)
     */
    @Delete
    void deleteTask(MyTask... tasks);

    @Query("DELETE FROM MyTask WHERE keyId=:kid")
    void deleteTask(long kid);

    /**
     * استخراج جميع المهامات التابعة لرقم الموضوع
     * @param key_id رقم الموضوع
     * @return
     */
    @Query("SELECT * FROM MyTask WHERE subId=:key_id " +
            "ORDER BY importance DESC")
    List<MyTask> getTasksBySubId(long key_id);
}


