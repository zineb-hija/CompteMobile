package com.example.myapplication.data.repository;

import com.example.myapplication.data.api.ApiService;
import com.example.myapplication.data.api.RetrofitClient;
import com.example.myapplication.data.models.Account;
import java.util.List;
import retrofit2.Call;

public class AccountRepository {
    private ApiService apiService;

    public AccountRepository() {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }

    public Call<List<Account>> getAccounts() {
        return apiService.getAccounts();
    }

    public Call<Account> addAccount(Account account) {
        return apiService.addAccount(account);
    }

    public Call<Void> deleteAccount(int id) {
        return apiService.deleteAccount(id);
    }
}