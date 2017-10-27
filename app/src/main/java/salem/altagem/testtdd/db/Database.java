package salem.altagem.testtdd.db;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import salem.altagem.testtdd.dao.UserDao;

/**
 * Created by stuart on 10/22/17.
 */

public abstract class Database extends RoomDatabase {
    private static Database INSTANCE;
    public abstract UserDao userDao();

    public static Database getInstanceDB(Context context) {
        if (null == INSTANCE) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Database.class, "testtdd_db")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
}
