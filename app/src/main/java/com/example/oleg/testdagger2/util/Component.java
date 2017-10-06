package com.example.oleg.testdagger2.util;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.oleg.testdagger2.MainActivity;

import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by oleg on 04.10.17.
 */
@Singleton
@dagger.Component(modules = {AppModule.class, TestModule.class})
public interface Component {

  void inject(MainActivity mainActivity);

  Retrofit retrofit();
  OkHttpClient okHttpClient();
  SharedPreferences shared();
}
