package com.example.myapplication.data.api;

import com.example.myapplication.data.models.Account;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("accounts")
    Call<List<Account>> getAccounts();

    @POST("accounts")
    Call<Account> addAccount(@Body Account account);

    @DELETE("accounts/{id}")
    Call<Void> deleteAccount(@Path("id") int id);
}