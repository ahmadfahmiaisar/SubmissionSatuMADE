package com.example.user.bismillahsub1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.bismillahsub1.adapter.ItemAdapter;
import com.example.user.bismillahsub1.api.ApiMovie;
import com.example.user.bismillahsub1.api.MovieService;
import com.example.user.bismillahsub1.pojo.ItemResponse;
import com.example.user.bismillahsub1.pojo.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etSearchMovie;
    private Button btnSearchMovie;

    private ArrayList<ItemResponse> listItems;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearchMovie = findViewById(R.id.etSearchMovie);
        btnSearchMovie = findViewById(R.id.btnSearchMovie);
        recyclerView = findViewById(R.id.rv_listMovie);
        getSupportActionBar().setTitle("Cari Film Kesukaanmu Disini");
        listItems = new ArrayList<>();
        btnSearchMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieService movieService = ApiMovie.getRetrofit();
                movieService.getMovie(etSearchMovie.getText().toString().trim())
                        .enqueue(new Callback<MovieResponse>() {
                            @Override
                            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                                if (response.isSuccessful()) {
//                                    Log.d("respon", "onResponse: " + response.isSuccessful());
                                    //MovieResponse movieResponse = response.body();
//                                    Log.d("coba get", "onResponse: "+movieResponse.getPage());
                                    listItems = response.body().getResult();
                                    //Log.d("mbuh iki", "onResponse: " + response);
                                    ItemAdapter adapter = new ItemAdapter(MainActivity.this, listItems);
                                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                    recyclerView.setAdapter(adapter);
                                } else {
                                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<MovieResponse> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "error fail", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}