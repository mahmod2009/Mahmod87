package com.mahmodjaf.newprojectmahmod.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mahmodjaf.newprojectmahmod.model.MyUserTable.MyUser;
import com.mahmodjaf.newprojectmahmod.repositories.UserRepository;

import java.util.List;

/**
 * نموذج عرض المستخدمين (UserViewModel) مسئول عن إدارة بيانات المستخدمين (MyUser) لصالح واجهات المستخدم (Views/Activities).
 * يتعامل مع {@link UserRepository} لتنفيذ العمليات المختلفة الخاصة بالمستخدمين.
 */
public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;
    private final LiveData<List<MyUser>> allUsers;

    /**
     * منشئ الكلاس (Constructor).
     *
     * @param application سياق التطبيق الممرر لـ AndroidViewModel.
     */
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
    }

    /**
     * جلب جميع المستخدمين كـ LiveData لمراقبتهم من واجهة المستخدم.
     *
     * @return قائمة بجميع المستخدمين المحدثة تلقائياً.
     */
    public LiveData<List<MyUser>> getAllUsers() {
        return allUsers;
    }

    /**
     * جلب قائمة جميع المستخدمين مباشرة.
     *
     * @return قائمة المستعملين.
     */
    public List<MyUser> getAll() {
        return repository.getAll();
    }

    /**
     * جلب مستخدم محدد بناءً على معرفه (userId).
     *
     * @param userId معرف المستخدم.
     * @return كائن المستخدم كـ LiveData.
     */
    public LiveData<MyUser> getUserById(long userId) {
        return repository.getUserById(userId);
    }

    /**
     * التحقق من البريد الإلكتروني وكلمة المرور (تسجيل الدخول).
     *
     * @param email البريد الإلكتروني.
     * @param password كلمة المرور.
     * @return كائن المستخدم إن وجد أو null.
     */
    public MyUser checkEmailPassw(String email, String password) {
        return repository.checkEmailPassw(email, password);
    }

    /**
     * التحقق من وجود البريد الإلكتروني مسبقاً.
     *
     * @param email البريد الإلكتروني.
     * @return كائن المستخدم إن وجد أو null.
     */
    public MyUser checkEmail(String email) {
        return repository.checkEmail(email);
    }

    /**
     * إدراج مستخدم جديد.
     *
     * @param user المستخدم المراد إضافته.
     */
    public void insert(MyUser user) {
        repository.insert(user);
    }

    /**
     * إدراج مجموعة مستخدمين.
     *
     * @param users المستخدمون المراد إضافتهم.
     */
    public void insertAll(MyUser... users) {
        repository.insertAll(users);
    }

    /**
     * تحديث بيانات مستخدم أو مجموعة مستخدمين.
     *
     * @param users المستخدمون المراد تحديث بياناتهم.
     */
    public void update(MyUser... users) {
        repository.update(users);
    }

    /**
     * حذف مستخدم أو مجموعة مستخدمين.
     *
     * @param users المستخدمون المراد حذفهم.
     */
    public void delete(MyUser... users) {
        repository.delete(users);
    }

    /**
     * حذف مستخدم بواسطة معرفه.
     *
     * @param id معرف المستخدم المراد حذفه.
     */
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
