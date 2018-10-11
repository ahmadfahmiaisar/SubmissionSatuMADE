package com.example.user.bismillahsub1.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResponse {
    @SerializedName("page")
    private int page;

    @SerializedName("total_pages")
    private int total_page;

    @SerializedName("results")
    private ArrayList<ItemResponse> result;

    @SerializedName("total_results")
    private int total_result;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public ArrayList<ItemResponse> getResult() {
        return result;
    }

    public void setResults(ArrayList<ItemResponse> result) {
        this.result = result;
    }

    public int getTotal_result() {
        return total_result;
    }

    public void setTotal_result(int total_result) {
        this.total_result = total_result;
    }
}
