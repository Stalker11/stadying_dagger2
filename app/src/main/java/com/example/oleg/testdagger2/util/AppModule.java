package com.example.oleg.testdagger2.util;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oleg on 04.10.17.
 */
@Module
public class AppModule {
  Application mApplication;

  public AppModule(Application mApplication) {
    this.mApplication = mApplication;
  }

  @Provides
  @Singleton
  public Application getmApplication() {
    return mApplication;
  }
}
