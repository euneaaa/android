package com.koreait.first.ch10.searchmoviemodel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.koreait.first.R;

import java.util.ArrayList;
import java.util.List;

public class movieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
    }
}


class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyviewHolder> {
    private List<MovieVO> list = new ArrayList();

    public void addItem(MovieVO vo){
        list.add(vo);
    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class MyviewHolder extends  RecyclerView.ViewHolder{
        private TextView tvMovieNm;
        private TextView tvRepNationNm;
        private TextView tvMovieNmEn;
        private TextView tvRepGenreNm;

        public MyviewHolder(View v){
            super(v);
            tvMovieNm = v.findViewById(R.id.tvMovieNm);
            tvRepNationNm = v.findViewById(R.id.tvRepNationNm);
            tvMovieNmEn = v.findViewById(R.id.tvMovieNmEn);
            tvRepGenreNm = v.findViewById(R.id.tvRepGenreNm);
        }

        public void setItem(MovieVO vo){
            tvMovieNm.setText(vo.getMovieNm());
            tvRepNationNm.setText(vo.getRepNationNm());
            tvMovieNmEn.setText(vo.getMovieNmEn());
            tvRepGenreNm.setText(vo.getRepGenreNm());
        }
    }
}