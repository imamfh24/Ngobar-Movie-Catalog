package com.ifa.ngobarmoviecatalog.rest;

import com.ifa.ngobarmoviecatalog.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    //https://api.themoviedb.org/3/movie/popular?api_key=1805007963a4760044640bde94121491&language=en-US&page=1
    //https://api.themoviedb.org/3/search/movie?api_key=1805007963a4760044640bde94121491&language=en-US&query=cars&page=1
    @GET("/3/movie/{category}")
    Call<Response> getMovie(
            @Path("category") String category,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("/3/search/movie")
    Call<Response> getQuery(
            @Query("api_key") String apikey,
            @Query("language") String language,
            @Query("query") String query,
            @Query("page") int page
    );
}
