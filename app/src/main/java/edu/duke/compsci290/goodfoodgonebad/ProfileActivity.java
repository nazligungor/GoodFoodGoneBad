package edu.duke.compsci290.goodfoodgonebad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.login.LoginManager;

/**
 * Created by Alonso on 4/18/2018.
 */

public class ProfileActivity extends AppCompatActivity{
        final Context context = this;
        private Button button;
        private EditText result;


       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.profile_layout);

           // PURPOSE: To get variables from Facebook Login to populate fields. (FB integration not done)
           Intent intent = getIntent();
           Bundle extras = intent.getExtras();
           String name_string = extras.getString("EXTRA_NAME");
           String email_string = extras.getString("EXTRA_EMAIL");
           String num_string = extras.getString("EXTRA_NUM");

           TextView nameView = findViewById(R.id.name_field);
           TextView emailView = findViewById(R.id.email_field);
           TextView numView = findViewById(R.id.num_field);

           //nameView.setText(name_string);
           //nameView.setText(email_string);
           //nameView.setText(num_string);

           SharedPreferences prefs = this.getSharedPreferences(
                   "Count_Sender_GoodFoodGoneBad", Context.MODE_PRIVATE);
           int count = prefs.getInt("countKey",-1);

           TextView logCount = findViewById(R.id.itemsLoggedCount);
           logCount.setText(Integer.toString(count));

           LinearLayout shareLayout = findViewById(R.id.share_layout);
           LinearLayout misc1Layout = findViewById(R.id.share_layout);
           LinearLayout misc2Layout = findViewById(R.id.share_layout);
           LinearLayout misc3Layout = findViewById(R.id.share_layout);

           shareLayout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   //Intent picture_intent = new Intent(ProfileActivity.this, PictureActivity.class);
                   //startActivity(picture_intent);

                   // SHARE LOG TO FACEBOOK - COMING SOON
               }
           });

           final Button button = (Button) findViewById(R.id.sign_out_button);
           button.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                   // On Button Press, SIGN OUT
                   LoginManager.getInstance().logOut();
               }
           });

       }
}
