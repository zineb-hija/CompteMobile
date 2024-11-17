package com.example.myapplication.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.data.models.Account;
import com.example.myapplication.ui.adapters.AccountAdapter;
import com.example.myapplication.ui.dialogs.AddAccountDialog;
import com.example.myapplication.ui.dialogs.EditAccountDialog;
import com.example.myapplication.ui.viewmodels.AccountViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AccountViewModel accountViewModel;
    private AccountAdapter accountAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonDelete = findViewById(R.id.buttonDelete);
        Button buttonEdit = findViewById(R.id.buttonEdit);

        accountAdapter = new AccountAdapter(this);
        listView.setAdapter(accountAdapter);

        accountViewModel = new ViewModelProvider(this).get(AccountViewModel.class);
        accountViewModel.getAccounts().observe(this, new Observer<List<Account>>() {
            @Override
            public void onChanged(List<Account> accounts) {
                accountAdapter.setAccounts(accounts);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ouvrir un dialogue pour ajouter un compte
                new AddAccountDialog(MainActivity.this, accountViewModel).show();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Suppression de l'élément sélectionné
                int selectedPosition = listView.getSelectedItemPosition();
                if (selectedPosition != -1) {
                    Account account = accountAdapter.getItem(selectedPosition);
                    accountViewModel.deleteAccount(account.getId());
                }
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ouvrir un dialogue pour modifier le compte sélectionné
                int selectedPosition = listView.getSelectedItemPosition();
                if (selectedPosition != -1) {
                    Account account = accountAdapter.getItem(selectedPosition);
                    new EditAccountDialog(MainActivity.this, accountViewModel, account).show();
                }
            }
        });
    }
}