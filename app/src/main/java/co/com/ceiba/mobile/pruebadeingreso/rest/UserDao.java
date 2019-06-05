package co.com.ceiba.mobile.pruebadeingreso.rest;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.entity.User;
import co.com.ceiba.mobile.pruebadeingreso.models.Users;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<Users> getAll();

    @Query("SELECT * FROM users where id LIKE  :id AND username LIKE :username")
    Users findByName(float id, String username);

    @Query("SELECT COUNT(*) from users")
    int countUsers();

    @Insert
    void insertAll(Users... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllOrders(List<Users> order);

    @Delete
    void delete(Users user);
}
