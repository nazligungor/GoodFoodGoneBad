package edu.duke.compsci290.goodfoodgonebad;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import edu.duke.compsci290.goodfoodgonebad.Database.AppDatabase;
import edu.duke.compsci290.goodfoodgonebad.Database.Product;

/**
 * Created by nazligungor on 29.04.2018.
 */

public class AddItemViewModel extends AndroidViewModel{
    private AppDatabase appDatabase;

    public AddItemViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getAppDatabase(this.getApplication());

    }

    public void addItem(final Product p) {
        new addAsyncTask(appDatabase).execute(p);
    }

    private static class addAsyncTask extends AsyncTask<Product, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Product... params) {
            db.getProductDao().insert(params[0]);
            return null;
        }

    }
}
