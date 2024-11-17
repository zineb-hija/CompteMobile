package com.example.myapplication.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.data.models.Account;

import java.util.List;

public class AccountAdapter extends ArrayAdapter<Account> {
    private List<Account> accounts;

    public AccountAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Account account = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_account, parent, false);
        }

        TextView textViewType = convertView.findViewById(R.id.textViewType);
        TextView textViewBalance = convertView.findViewById(R.id.textViewBalance);

        textViewType.setText(account.getType());
        textViewBalance.setText(String.valueOf(account.getBalance()));

        return convertView;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
        clear();
        addAll(accounts);
        notifyDataSetChanged();
    }
}