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

public class AddAccountDialog extends Dialog {
    private AccountViewModel accountViewModel;

    public AddAccountDialog(@NonNull Context context, AccountViewModel viewModel) {
        super(context);
        this.accountViewModel = viewModel;
        setContentView(R.layout.dialog_account);

        EditText accountTypeEditText = findViewById(R.id.accountTypeEditText);
        EditText accountBalanceEditText = findViewById(R.id.accountBalanceEditText);
        Button addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = accountTypeEditText.getText().toString();
                double balance = Double.parseDouble(accountBalanceEditText.getText().toString());
                accountViewModel.addAccount(new Account(String.valueOf(System.currentTimeMillis()), type, balance));
                dismiss();
            }
        });
    }
}