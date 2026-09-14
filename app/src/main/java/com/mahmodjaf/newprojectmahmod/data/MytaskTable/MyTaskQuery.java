package com.mahmodjaf.newprojectmahmod.data.MytaskTable;

import androidx.room.Dao;
import androidx.room.Query;

import com.mahmodjaf.newprojectmahmod.data.MytaskTable.MyTask;

import java.util.List;

/**
 * واجهة استعلامات على جدول معطيات
 */
@Dao
public interface MyTaskQuery {

    /**
     * إعادة جميع معطيات جدول المهامات
     * @return * قائمة من المهامات *
     */
    @Query("SELECT * FROM MyTask ORDER BY importance DESC")
    List<MyTask> getAllTasks();

    /**
     * ارجاع المهامات حسب المستخدم واذا انتهت ام لا ومرتبة تنازليا حسب الاهمية
     * @param userId_p* رقم المستخدم
     * @return
     */
    @Query("SELECT * FROM MyTask WHERE userId=:userId_p ORDER BY time DESC")
    List<MyTask> getAllTaskOrderedBy(long userId_p);

    /**
     * ارجاع المهامات حسب المستخدم واذا انتهت ام لا ومرتبة تنازليا حسب الاهمية
     * @param userid_p* رقم المستخدم
     * @param isCompleted_p * هل تمت ام لا *
     * @return * قائمة مهامات *
     */
    @Query("SELECT * FROM MyTask WHERE userId=:userid_p AND isCompleted=:isCompleted_p " +
            "ORDER BY importance DESC")
    List<MyTask> getAllTaskOrderedBy(long userid_p, boolean isCompleted_p);
}
