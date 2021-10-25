package com.koreait.first.ch10.searchmoviemodel;

import java.util.List;

public class MovieListResultVO {
    private int totCnt;
    private List<MovieVO> movieListResult;

    public int getTotCnt() {
        return totCnt;
    }

    public void setTotCnt(int totCnt) {
        this.totCnt = totCnt;
    }

    public List<MovieVO> getMovieListResult() {
        return movieListResult;
    }

    public void setMovieListResult(List<MovieVO> movieListResult) {
        this.movieListResult = movieListResult;
    }
}
