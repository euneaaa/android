package com.koreait.first.ch10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.koreait.first.R;
import com.koreait.first.ch10.searchmoviemodel.ActorVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoResultBodyVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoResultVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetaActivity extends AppCompatActivity {

    private TextView tvmovieNm;
    private TextView tvmovieNmEn;
    private TextView tvshowTm;
    private RecyclerView actors;
    private MovieInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_deta);
        Intent intent = getIntent();
        String movieCd = intent.getStringExtra("movieCd");
        Log.i("myLog","movieCd:"+movieCd);
        //movieCd 값 전Activity (MovieListActivity)에서 전달 받는다.

        getData(movieCd);

        adapter = new MovieInfoAdapter();

        tvmovieNm =findViewById(R.id.tvmovieNm);
        tvmovieNmEn =findViewById(R.id.tvmovieNmEn);
        tvshowTm =findViewById(R.id.tvshowTm);
        actors =findViewById(R.id.actors);
        actors.setAdapter(adapter);
    }

    private void getData(String movieCd){
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KobisService service = rf.create(KobisService.class);
        final String KEY = "1a0a7ecf96ad3364d8de70e91560767a";
        Call <MovieInfoResultBodyVO> call = service.searchMovieInfo(KEY, movieCd);
        call.enqueue(new Callback<MovieInfoResultBodyVO>() {
            @Override
            public void onResponse(Call<MovieInfoResultBodyVO> call, Response<MovieInfoResultBodyVO> res) {
                if(res.isSuccessful()){
                    MovieInfoResultBodyVO result = res.body();

                    MovieInfoResultVO resultVO = result.getMovieInfoResult();
                    MovieInfoVO info = resultVO.getMovieInfo();

                    List<ActorVO> actors = info.getActors();

                    adapter.setList(actors);
                    adapter.notifyDataSetChanged();

                    tvmovieNm.setText(info.getMovieNm());
                    tvmovieNmEn.setText(info.getMovieNmEn());
                    tvshowTm.setText(info.getShowTm());

                    Log.i("myLog", actors.size() + "개");

                } else{

                }
            }

            @Override
            public void onFailure(Call<MovieInfoResultBodyVO> call, Throwable t) {

            }
        });
    }
}

class MovieInfoAdapter extends RecyclerView.Adapter<MovieInfoAdapter.MyViewHolder>{

    private List<ActorVO> actors;

    public void setList(List<ActorVO> actors) {
        this.actors = actors;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_actors, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ActorVO vo = actors.get(position);
        holder.setItem(vo);
    }

    @Override
    public int getItemCount() {
        return actors == null ? 0 : actors.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvpeoleNm;
        private TextView tvpeoleNmEn;
        private TextView tvcast;
        private TextView tvcastEn;

        public MyViewHolder(View v) {
            super(v);
            tvpeoleNm = v.findViewById(R.id.tvpeopleNm);
            tvpeoleNmEn = v.findViewById(R.id.tvpeopleNmEn);
            tvcast = v.findViewById(R.id.tvcast);
            tvcastEn = v.findViewById(R.id.tvcastEn);
        }

        public void setItem(ActorVO vo) {
            tvpeoleNm.setText(vo.getPeopleNm());
            tvpeoleNmEn.setText(vo.getPeopleNmEn());
            tvcast.setText(vo.getCast());
            tvcastEn.setText(vo.getCastEn());
        }
    }
}

