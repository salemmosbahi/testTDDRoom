package salem.altagem.testtdd.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import salem.altagem.testtdd.entity.User;

/**
 * Created by stuart on 10/22/17.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM user where username = :pUsername AND password = :pPassword")
    User login(String pUsername, String pPassword);

    @Insert
    void insert(User user);
}
