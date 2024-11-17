package com.example.myapplication.ui.dialogs;


import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.data.models.Account;
import com.example.myapplication.ui.viewmodels.AccountViewModel;

public class EditAccountDialog {
    private Dialog dialog;
    private AccountViewModel accountViewModel;
    private Account account;

    public EditAccountDialog(Context context, AccountViewModel accountViewModel, Account account) {
        this.accountViewModel = accountViewModel;
        this.account = account;
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_account);

        EditText editTextType = dialog.findViewById(R.id.editTextType);
        EditText editTextBalance = dialog.findViewById(R.id.editTextBalance);
        Button buttonEdit = dialog.findViewById(R.id.buttonAdd);

        // Remplir les champs avec les données existantes
        editTextType.setText(account.getType());
        editTextBalance.setText(String.valueOf(account.getBalance()));

        buttonEdit.setText("Modifier");
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = editTextType.getText().toString();
                double balance = Double.parseDouble(editTextBalance.getText().toString());
                account.setType(type);
                account.setBalance(balance);
                accountViewModel.updateAccount(account); // Méthode pour mettre à jour le compte
                dialog.dismiss();
            }
        });
    }

    public void show() {
        dialog.show();
    }
}