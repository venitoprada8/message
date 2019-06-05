package co.com.ceiba.mobile.pruebadeingreso.utils;


import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;


import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.database.AppDatabase;
import co.com.ceiba.mobile.pruebadeingreso.models.Users;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db,List<Users>  users) {
        PopulateDbAsync task = new PopulateDbAsync(db,users);
        task.execute();
    }
    public static List<Users>  getdata(@NonNull final AppDatabase db) {
        List<Users> userList = db.userDao().getAll();
        return userList;
    }

    private static List<Users>  addUser(final AppDatabase db, List<Users> user) {
        db.userDao().insertAllOrders(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db, List<Users>  user) {

        addUser(db, user);
        List<Users> userList = db.userDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;
        private List<Users>  us;

        PopulateDbAsync(AppDatabase db,List<Users>  users) {
            mDb = db;
            us=users;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb,us);
            return null;
        }

    }
}
