package com.example.myapplication.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.models.Account;
import com.example.myapplication.data.repository.AccountRepository;

import java.util.List;

public class AccountViewModel extends ViewModel {
    private final AccountRepository repository = new AccountRepository();
    private final MutableLiveData<List<Account>> accounts = new MutableLiveData<>();

    public LiveData<List<Account>> getAccounts() {
        accounts.setValue(repository.getAccounts());
        return accounts;
    }

    public void addAccount(Account account) {
        repository.addAccount(account);
        accounts.setValue(repository.getAccounts());
    }

    public void removeAccount(String id) {
        repository.removeAccount(id);
        accounts.setValue(repository.getAccounts());
    }

    public void updateAccount(Account account) {
        repository.updateAccount(account);
        accounts.setValue(repository.getAccounts());
    }
}
