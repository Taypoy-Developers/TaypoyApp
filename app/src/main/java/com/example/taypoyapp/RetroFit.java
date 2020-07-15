package com.example.taypoyapp;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroFit {
    @GET("complete/search")
    Observable<String> getSuggestFromYoutube(@Query("q") String query,
                                             @Query("client") String client,
                                             @Query("hl") String language,
                                             @Query("ds") String restrict);
    Observable<String> getSuggestFromGoogle(@Query("q") String query,
                                             @Query("client") String client,
                                             @Query("hl") String language);
}
