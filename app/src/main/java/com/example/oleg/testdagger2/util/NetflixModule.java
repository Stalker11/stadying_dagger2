package com.example.oleg.testdagger2.util;

import com.google.gson.JsonElement;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by oleg on 06.10.17.
 */
@Module
public class NetflixModule {
  private interface NetflixAPIInterface {
    @GET("api.php?")
    public Call<JsonElement> getFilm(@Query("title=") String filmName);
  }

  @UserScope
  @Provides
  @Singleton
  public NetflixAPIInterface getRequestFilm(Retrofit retrofit) {
    return retrofit.create(NetflixAPIInterface.class);
  }
}
