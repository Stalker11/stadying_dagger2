package com.example.oleg.testdagger2.util;

import android.app.Application;

/**
 * Created by oleg on 04.10.17.
 */

public class App extends Application {
  private Component mComponent;
  private UrlComponent mUrlComponent;
  @Override
  public void onCreate() {
    mComponent = DaggerComponent.builder().appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
            .testModule(new TestModule())
            .build();
    mUrlComponent = DaggerUrlComponent.builder().component(mComponent)
            .netflixComponent(new NetflixModule()).build();
    super.onCreate();
  }
  public Component getmComponent(){
    return mComponent;
  }
  public UrlComponent getMUrlComponent(){
    return mUrlComponent;
  }
}
