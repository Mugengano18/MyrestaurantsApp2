package com.example.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myrestaurants.models.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener{
////    public static final String TAG = MainActivity.class.getSimpleName();
//@BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
//    @BindView(R.id.locationEditText) EditText mLocationEditText;
//    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
////        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
////        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
//        ButterKnife.bind(this);
//        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
//                String location = mLocationEditText.getText().toString();
//                intent.putExtra("location", location);
//                startActivity(intent);
//            }
//        });
//    }
//}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    @BindView(R.id.findRestaurantsButton)
    Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText)
    EditText mLocationEditText;
    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        if (v == mFindRestaurantsButton) {
//            String location = mLocationEditText.getText().toString();
//            addToSharedPreferences(location);
//            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
//            intent.putExtra("location", location);
//            startActivity(intent);
//        }

        if (v == mFindRestaurantsButton) {
            String location = mLocationEditText.getText().toString();
            if(!(location).equals("")) {
                addToSharedPreferences(location);
            }
            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
            startActivity(intent);
        }
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
}
