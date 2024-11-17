package com.example.myapplication.ui.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.models.Account;
import com.example.myapplication.data.repository.AccountRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountViewModel extends ViewModel {
    private AccountRepository accountRepository;
    private MutableLiveData<List<Account>> accounts;

    public AccountViewModel() {
        accountRepository = new AccountRepository();
        accounts = new MutableLiveData<>();
        fetchAccounts();
    }

    public LiveData<List<Account>> getAccounts() {
        return accounts;
    }

    private void fetchAccounts() {
        accountRepository.getAccounts().enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if (response.isSuccessful()) {
                    accounts.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {
                // Gérer l'erreur
            }
        });
    }

    public void addAccount(Account account) {
        accountRepository.addAccount(account).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                fetchAccounts(); // Rafraîchir la liste après ajout
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                // Gérer l'erreur
            }
        });
    }

    public void deleteAccount(int id) {
        accountRepository.deleteAccount(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                fetchAccounts(); // Rafraîchir la liste après suppression
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Gérer l'erreur
            }
        });
    }

    public void updateAccount(Account account) {
        // Implémentez la logique de mise à jour ici si nécessaire
        fetchAccounts(); // Rafraîchir la liste après mise à jour
    }
}