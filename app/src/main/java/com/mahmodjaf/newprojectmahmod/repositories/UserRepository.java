package com.mahmodjaf.newprojectmahmod.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.mahmodjaf.newprojectmahmod.model.AppDataBase;
import com.mahmodjaf.newprojectmahmod.model.MyUserTable.MyUser;
import com.mahmodjaf.newprojectmahmod.model.MyUserTable.MyUserQuery;

import java.util.List;

/**
 * مستودع المستخدمين (MyUser) يعمل كطبقة وسيطة ومنظمة للوصول إلى بيانات المستخدمين (UserRepository).
 * يقوم بفصل قاعدة بيانات Room و {@link MyUserQuery} عن بقية أجزاء التطبيق (ViewModels).
 */
public class UserRepository {
    private final MyUserQuery userQuery; // واجهة الاستعلامات
    private final LiveData<List<MyUser>> allUsers; // قائمة جميع المستخدمين المحدثة كـ LiveData

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمستخدمين.
     *
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */
    public UserRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        userQuery = db.getMyUserQuery();
        allUsers = userQuery.getAllUsers();
    }

    /**
     * جلب جميع المستخدمين الموجودين في قاعدة البيانات كـ LiveData.
     *
     * @return قائمة بجميع المستخدمين المحدثة تلقائياً.
     */
    public LiveData<List<MyUser>> getAllUsers() {
        return allUsers;
    }

    /**
     * جلب جميع المستخدمين كقائمة عادية (List).
     *
     * @return قائمة بجميع المستخدمين.
     */
    public List<MyUser> getAll() {
        return userQuery.getAll();
    }

    /**
     * جلب مستخدم محدد بناءً على معرّفه الفريد (keyid).
     *
     * @param userId معرف المستخدم.
     * @return كائن المستخدم المطلوب كـ LiveData.
     */
    public LiveData<MyUser> getUserById(long userId) {
        return userQuery.getUserById(userId);
    }

    /**
     * التحقق من وجود المستخدم بواسطة البريد الإلكتروني وكلمة المرور (تسجيل الدخول).
     *
     * @param email    البريد الإلكتروني للمستخدم.
     * @param password كلمة المرور.
     * @return كائن المستخدم في حال تطابق البيانات أو null إذا لم يوجد.
     */
    public MyUser checkEmailPassw(String email, String password) {
        return userQuery.checkEmailPassw(email, password);
    }

    /**
     * التحقق من وجود البريد الإلكتروني مسبقاً في قاعدة البيانات.
     *
     * @param email البريد الإلكتروني المراد فصحه.
     * @return كائن المستخدم إن وجد أو null.
     */
    public MyUser checkEmail(String email) {
        return userQuery.checkEmail(email);
    }

    /**
     * إدراج مستخدم جديد في قاعدة البيانات.
     *
     * @param user المستخدم المراد إضافته.
     */
    public void insert(MyUser user) {
        userQuery.insert(user);
    }

    /**
     * إدراج مجموعة من المستخدمين في قاعدة البيانات.
     *
     * @param users المستخدمون المراد إضافتهم.
     */
    public void insertAll(MyUser... users) {
        userQuery.insertAll(users);
    }

    /**
     * تحديث بيانات مستخدم أو مجموعة مستخدمين.
     *
     * @param users المستخدمون المراد تحديث بياناتهم.
     */
    public void update(MyUser... users) {
        userQuery.update(users);
    }

    /**
     * حذف مستخدم أو مجموعة مستخدمين من قاعدة البيانات.
     *
     * @param users المستخدمون المراد حذفهم.
     */
    public void delete(MyUser... users) {
        userQuery.delete(users);
    }

    /**
     * حذف مستخدم بواسطة معرفه الفريد (id).
     *
     * @param id معرف المستخدم المراد حذفه.
     */
    public void deleteById(int id) {
        userQuery.deleteById(id);
    }
}
