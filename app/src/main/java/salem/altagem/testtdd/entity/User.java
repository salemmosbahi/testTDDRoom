package salem.altagem.testtdd.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by stuart on 10/22/17.
 */

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    public int id() {
        return id;
    }

    public void id(int pId) {
        id = pId;
    }

    public String username() {
        return username;
    }

    public void username(String pUsername) {
        username = pUsername;
    }

    public String password() {
        return password;
    }

    public void password(String pPassword) {
        password = pPassword;
    }
}
