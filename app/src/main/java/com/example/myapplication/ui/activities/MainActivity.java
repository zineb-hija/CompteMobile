package com.example.myapplication.ui.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.models.Account;
import com.example.myapplication.ui.adapters.AccountAdapter;
import com.example.myapplication.ui.viewmodels.AccountViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AccountViewModel accountViewModel;
    private AccountAdapter accountAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Correction: ajout du point-virgule
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        accountAdapter = new AccountAdapter(new ArrayList<>()); // Initialisation avec une ArrayList vide
        recyclerView.setAdapter(accountAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Utilisation de ViewModelProvider pour obtenir l'instance de AccountViewModel
        accountViewModel = new ViewModelProvider(this).get(AccountViewModel.class);
        accountViewModel.getAccounts().observe(this, new Observer<List<Account>>() {
            @Override
            public void onChanged(List<Account> accounts) {
                accountAdapter.updateAccounts(accounts);
            }
        });

        // Ajoutez ici des boutons ou des dialogues pour ajouter, modifier ou supprimer des comptes
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Sauvegardez ici les données nécessaires pour restaurer l'état de l'interface utilisateur
    }
}