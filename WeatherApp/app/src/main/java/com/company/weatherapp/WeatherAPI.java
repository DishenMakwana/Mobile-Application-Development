package com.company.weatherapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("weather?&appid=ba6efd72483cf817bbd3979b3599efb1&units=metric")
    Call<OpenWeathwerMap> getWeatherWithLocation(@Query("lat")double lat, @Query("lon")double lon);

    @GET("weather?&appid=ba6efd72483cf817bbd3979b3599efb1&units=metric")
    Call<OpenWeathwerMap>getWeatherWithCityName(@Query("q")String name);
}