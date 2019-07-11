package edu.duke.compsci290.goodfoodgonebad;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import edu.duke.compsci290.goodfoodgonebad.Database.AppDatabase;
import edu.duke.compsci290.goodfoodgonebad.Database.Product;

/**
 * Created by nazligungor on 26.04.2018.
 */

public class ItemListViewModel extends AndroidViewModel{
    //we wrap our list items inside LiveData so that
    //the Activity can observe changes in data and update UI
    private final LiveData<List<Product>> itemList;
    private AppDatabase appDatabase;

    public ItemListViewModel(Application application) {
        super(application);

        //getting an instance of our database
        appDatabase = AppDatabase.getAppDatabase(this.getApplication());
        //we load all the items
        itemList = appDatabase.getProductDao().getAllEntries();

    }

    public LiveData<List<Product>> getItemList() {
        return itemList;
    }

    // Failure to get object by name at this line
    public Product getItembyName(String n) {

        // NOTE: Added temporarily for click error
        if(n != null){
            return appDatabase.getProductDao().getObjectbyname(n);
        }
        // Should be fixed but n is not accurate
        return new Product();
    }

    public void deleteItem(Product p) {
        new deleteAsyncTask(appDatabase).execute(p);
    }

    private static class deleteAsyncTask extends AsyncTask<Product, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Product... params) {
            db.getProductDao().delete(params[0]);
            return null;
        }

    }

}
