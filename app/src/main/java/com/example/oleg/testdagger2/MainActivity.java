package com.example.oleg.testdagger2;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.oleg.testdagger2.models.UserModel;
import com.example.oleg.testdagger2.util.App;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = MainActivity.class.getSimpleName();
  @Inject
  SharedPreferences mSharedPreferences;
  @Inject
  UserModel mUserModel;
  @Inject
  Application mApplication;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ((App) getApplication()).getMUrlComponent().inject(this);
    Log.d(TAG, "onCreate: "+mSharedPreferences.getAll()+" "+mUserModel.getmUserAge()+" "
            +mUserModel.getmUserPosition()+" "+mApplication.getPackageName());
    mUserModel.setmUserAge(54);
    mUserModel.setmUserPosition("Movie director");

  }

  @Override
  protected void onDestroy() {
    Log.d(TAG, "onDestroy: "+mUserModel.getmUserAge()+" "+mUserModel.getmUserPosition());
    super.onDestroy();
  }
}
