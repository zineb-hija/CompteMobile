package com.example.myapplication.data.repository;


import com.example.myapplication.data.models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private List<Account> accountList = new ArrayList<>();

    public List<Account> getAccounts() {
        return accountList;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(String id) {
        accountList.removeIf(account -> account.getId().equals(id));
    }

    public void updateAccount(Account updatedAccount) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getId().equals(updatedAccount.getId())) {
                accountList.set(i, updatedAccount);
                break;
            }
        }
    }
}