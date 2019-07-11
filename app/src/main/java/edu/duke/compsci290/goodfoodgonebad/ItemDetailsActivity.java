package edu.duke.compsci290.goodfoodgonebad;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by Alonso on 4/18/2018.
 */

public class ItemDetailsActivity extends AppCompatActivity{


    private ItemListViewModel mView;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        //AppDatabase db = AppDatabase.getAppDatabase(ItemDetailsActivity.this);
        //mView = ViewModelProviders.of(this).get(ItemListViewModel.class);
        //LiveData<List<Product>> temp_list = mView.getItemList();

        Intent receivedIntent = this.getIntent();
        String itemName = receivedIntent.getStringExtra("item_name");
        String brandName = receivedIntent.getStringExtra("item_brand");
        String itemExp = receivedIntent.getStringExtra("item_exp");
        String itemPur = receivedIntent.getStringExtra("item_pur");


        //int drawableId = this.getResources().getIdentifier(..., "drawable", this.getPackageName());
        //Drawable itemPicture = this.getDrawable(drawableId);

        ImageView mImageView = findViewById(R.id.activity_new_item_image_view);
        TextView mItemName = findViewById(R.id.activity_item_name_text_view);
        TextView mItemBrand = findViewById(R.id.activity_brand_name_text_view);
        TextView mItemExpiration = findViewById(R.id.activity_expiration_date_text_view);
        TextView mItemPurchase = findViewById(R.id.activity_purchase_date_text_view);

        //mImageView.setImageDrawable(itemPicture);
        mItemName.setText("Name: " + itemName);
        mItemBrand.setText("Brand: " + brandName);
        mItemExpiration.setText("Expiration date: " + itemExp);
        mItemPurchase.setText("Purchase date: " + itemPur);


    }

}
