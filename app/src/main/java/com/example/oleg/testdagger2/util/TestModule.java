package com.example.oleg.testdagger2.util;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.oleg.testdagger2.models.UserModel;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by oleg on 04.10.17.
 */
@Module
public class TestModule {

  @Provides
  @Singleton
  public SharedPreferences getSharedPreferences(Application application){
    return PreferenceManager.getDefaultSharedPreferences(application);
  }
  @Provides
  @Singleton
  public UserModel getUser(){
    return new UserModel();
  }
  @Provides
  @Singleton
  public Retrofit getRetrofit(OkHttpClient okHttpClient){
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(okHttpClient)
            .build();
    return retrofit;
  }
  @Provides
  @Singleton
  public OkHttpClient getOkHttpClient(){
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build();
    return okHttpClient;

  }

}

