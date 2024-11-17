package com.example.myapplication.data.api;

import com.example.myapplication.data.models.Account;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
    @GET("accounts")
    Call<List<Account>> getAccounts();

    @POST("accounts")
    Call<Account> createAccount(@Body Account account);

    @PUT("accounts/{id}")
    Call<Account> updateAccount(@Path("id") String id, @Body Account account);

    @DELETE("accounts/{id}")
    Call<Void> deleteAccount(@Path("id") String id);
}