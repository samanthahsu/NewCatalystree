package com.example.newcatalystree.Local;

import android.arch.persistence.room.Query;
import io.reactivex.Flowable;

public interface UserDAO {

    @Query("SELECT * FROM users WHERE id=:userId")
    Flowable<Users> getUserbyId(int userId);

    @Query("SELECT * FROM  users")
    Flowable<List<User>> getAllUsers();
    
    @Insert
    void insertUser(User... users);
    
    @Update
    void updateUser(User...users);
    
    @Query(“DELETE FROM users”)
    void deleteAllUsers();
}
