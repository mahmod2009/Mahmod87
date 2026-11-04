package com.mahmodjaf.newprojectmahmod.model.MyUserTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * واجهة تحوي عمليات/دوال/استعلامات على قاعدة البيانات لجدول المستخدمين
 */
@Dao
public interface MyUserQuery {

    /**
     * استخراج جميع المستعملين كـ LiveData
     */
    @Query("SELECT * FROM MyUser")
    LiveData<List<MyUser>> getAllUsers();

    /**
     * استخراج جميع المستعملين
     */
    @Query("SELECT * FROM MyUser")
    List<MyUser> getAll();

    /**
     * استخراج مستعمل حسب الرقم المميز
     */
    @Query("SELECT * FROM MyUser WHERE keyid = :id LIMIT 1")
    LiveData<MyUser> getUserById(long id);

    /**
     * استخراج مستعملين حسب الأرقام المميزة
     */
    @Query("SELECT * FROM MyUser WHERE keyid IN (:userIds)")
    List<MyUser> loadAllByIds(int[] userIds);

    /**
     * فحص هل المستعمل موجود حسب الايميل وكلمة السر
     */
    @Query("SELECT * FROM MyUser WHERE email = :myEmail AND passw = :myPassw LIMIT 1")
    MyUser checkEmailPassw(String myEmail, String myPassw);

    /**
     * فحص هل الايميل موجود من قبل
     */
    @Query("SELECT * FROM MyUser WHERE email = :myEmail LIMIT 1")
    MyUser checkEmail(String myEmail);

    /**
     * اضافة مجموعة مستعملين
     */
    @Insert
    void insertAll(MyUser... users);

    /**
     * اضافة مستعمل واحد
     */
    @Insert
    void insert(MyUser myUser);

    /**
     * تعديل مستعمل او قائمة مستعملين
     */
    @Update
    void update(MyUser... values);

    /**
     * حذف مستعمل او مجموعة مستعملين
     */
    @Delete
    void delete(MyUser... users);

    /**
     * حذف مستعمل واحد
     */
    @Delete
    void delete(MyUser user);

    /**
     * حذف حسب الرقم المميز id
     */
    @Query("DELETE FROM MyUser WHERE keyid = :id")
    void deleteById(int id);
}
