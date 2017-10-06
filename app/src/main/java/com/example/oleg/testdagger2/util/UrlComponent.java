package com.example.oleg.testdagger2.util;

import com.example.oleg.testdagger2.MainActivity;

/**
 * Created by oleg on 06.10.17.
 */
@UserScope
@dagger.Component(dependencies = Component.class, modules = NetflixModule.class)
public interface UrlComponent {
  void inject(MainActivity activity);
}
