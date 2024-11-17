package com.example.myapplication.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.example.myapplication.R;
import com.example.myapplication.data.models.Account;
import com.example.myapplication.ui.viewmodels.AccountViewModel;

public class EditAccountDialog extends Dialog {
    private final AccountViewModel accountViewModel;
    private final Account account;

    public EditAccountDialog(@NonNull Context context, AccountViewModel viewModel, Account account) {
        super(context);
        this.accountViewModel = viewModel;
        this.account = account;
        setContentView(R.layout.dialog_account);

        EditText accountTypeEditText = findViewById(R.id.accountTypeEditText);
        EditText accountBalanceEditText = findViewById(R.id.accountBalanceEditText);
        Button editButton = findViewById(R.id.editButton);

        // Remplir les champs avec les données existantes
        accountTypeEditText.setText(account.getType());
        accountBalanceEditText.setText(String.valueOf(account.getBalance()));

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = accountTypeEditText.getText().toString();
                double balance;

                // Validation de l'entrée pour le solde
                try {
                    balance = Double.parseDouble(accountBalanceEditText.getText().toString());
                } catch (NumberFormatException e) {
                    accountBalanceEditText.setError("Veuillez entrer un solde valide.");
                    return;
                }

                account.setType(type);
                account.setBalance(balance);
                accountViewModel.updateAccount(account);
                dismiss();
            }
        });
    }
}