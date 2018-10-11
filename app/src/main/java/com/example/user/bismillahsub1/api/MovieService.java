package com.example.user.bismillahsub1.api;

import com.example.user.bismillahsub1.pojo.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("movie?api_key=ef2b66099a63d242660e26a77cd29a6b&language=en-US")
    Call<MovieResponse>getMovie(@Query("query") String query);
}