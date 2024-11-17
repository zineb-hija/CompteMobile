package com.example.myapplication.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.data.models.Account;
import com.example.myapplication.ui.viewmodels.AccountViewModel;

public class AddAccountDialog {
    private Dialog dialog;
    private AccountViewModel accountViewModel;

    public AddAccountDialog(Context context, AccountViewModel accountViewModel) {
        this.accountViewModel = accountViewModel;
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_account);

        EditText editTextType = dialog.findViewById(R.id.editTextType);
        EditText editTextBalance = dialog.findViewById(R.id.editTextBalance);
        Button buttonAdd = dialog.findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = editTextType.getText().toString();
                double balance = Double.parseDouble(editTextBalance.getText().toString());
                Account account = new Account(0, type, balance); // ID auto-généré par le serveur
                accountViewModel.addAccount(account);
                dialog.dismiss();
            }
        });
    }

    public void show() {
        dialog.show();
    }
}