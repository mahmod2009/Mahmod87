package com.mahmodjaf.newprojectmahmod.model.MytaskTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyTaskQuery {

    /**
     * إعادة جميع معطيات جدول المهمات
     * @return قائمة من المهمات
     */
    @Query("SELECT * FROM MyTask ORDER BY importance DESC")
    LiveData<List<MyTask>> getAllTasks();

    /**
     * إرجاع المهمات حسب المستعمل مرتبة تنازلياً حسب وقت البداية
     * @param userid_p رقم المستعمل
     * @return قائمة مهمات
     */
    @Query("SELECT * FROM MyTask WHERE userid=:userid_p ORDER BY startTime DESC")
    LiveData<List<MyTask>> getAllTaskOrderBy(long userid_p);

    /**
     * إرجاع المهمات حسب المستعمل وإذا انتهت أم لا ومرتبة تنازلياً حسب الأهمية
     * @param userId_p رقم المستعمل
     * @param isCompleted_p هل تمت أم لا
     * @return قائمة مهمات مرتبة
     */
    @Query("SELECT * FROM MyTask WHERE userid=:userId_p AND isCompleted=:isCompleted_p ORDER BY importance DESC")
    LiveData<List<MyTask>> getAllTaskOrderedBy(long userId_p, boolean isCompleted_p);

    /**
     * ادخال مهام
     * @param t مجموعة مهام
     */
    @Insert
    void insertTask(MyTask... t);

    @Insert
    void insert(MyTask... tasks);

    /**
     * تعديل المهمات
     * @param tasks مجموعة مهام للتعديل
     */
    @Update
    void updateTask(MyTask... tasks);

    @Update
    void update(MyTask... tasks);

    /**
     * تعديل بيانات مهمة محددة
     */
    @Query("UPDATE MyTask SET shortTitle=:title, description=:description, importance=:priority WHERE taskId=:taskId")
    void updateTask(long taskId, String title, String description, int priority);

    /**
     * حذف مهمة أو مهام
     * @param tasks المهام المراد حذفها
     */
    @Delete
    void deleteTask(MyTask... tasks);

    @Delete
    void delete(MyTask... tasks);

    @Query("DELETE FROM MyTask WHERE KeyId=:kid")
    void deleteTask(long kid);

    @Query("DELETE FROM MyTask WHERE taskId=:taskId")
    void deleteTaskById(long taskId);

    /**
     * استرجاع جميع المهام التابعة لرقم الموضوع
     * @param key_id رقم الموضوع
     * @return قائمة المهام
     */
    @Query("SELECT * FROM MyTask WHERE subId=:key_id ORDER BY importance DESC")
    List<MyTask> getTasksBySubId(long key_id);

    @Query("SELECT * FROM MyTask WHERE taskId=:taskId ORDER BY importance DESC")
    LiveData<MyTask> getTaskById(long taskId);

    @Query("SELECT * FROM MyTask WHERE shortTitle LIKE '%' || :title || '%' ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByTitle(String title);

    @Query("SELECT * FROM MyTask WHERE description LIKE '%' || :description || '%' ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByDescription(String description);

    @Query("SELECT * FROM MyTask WHERE importance=:priority ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByPriority(int priority);

    @Query("SELECT * FROM MyTask WHERE userid=:userId AND shortTitle LIKE '%' || :title || '%' ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title);
}
