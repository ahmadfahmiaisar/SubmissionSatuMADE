package com.example.user.bismillahsub1.pojo;

import com.google.gson.annotations.SerializedName;

public class ItemResponse {

    @SerializedName("title")
    private String title_movie;

    @SerializedName("overview")
    private String overview_movie;

    @SerializedName("backdrop_path")
    private String backdrop_movie;

    @SerializedName("poster_path")
    private String poster_movie;

    @SerializedName("release_date")
    private String release_movie;

    @SerializedName("popularity")
    private String popular;

    @SerializedName("vote_average")
    private String vote;

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getPopular() {
        return popular;
    }

    public void setPopular(String popular) {
        this.popular = popular;
    }

    public String getTitle_movie() {
        return title_movie;
    }

    public void setTitle_movie(String title_movie) {
        this.title_movie = title_movie;
    }

    public String getOverview_movie() {
        return overview_movie;
    }

    public void setOverview_movie(String overview_movie) {
        this.overview_movie = overview_movie;
    }

    public String getBackdrop_movie() {
        return backdrop_movie;
    }

    public void setBackdrop_movie(String backdrop_movie) {
        this.backdrop_movie = backdrop_movie;
    }

    public String getPoster_movie() {
        return poster_movie;
    }

    public void setPoster_movie(String poster_movie) {
        this.poster_movie = poster_movie;
    }

    public String getRelease_movie() {
        return release_movie;
    }

    public void setRelease_movie(String release_movie) {
        this.release_movie = release_movie;
    }
}
