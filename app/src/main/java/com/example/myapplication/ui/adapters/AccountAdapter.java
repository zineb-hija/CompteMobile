package com.example.myapplication.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.data.models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountViewHolder> {
    private List<Account> accounts;

    public AccountAdapter(List<Account> accounts) {
        this.accounts = accounts;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account, parent, false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        Account account = accounts.get(position);
        holder.bind(account);
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public void updateAccounts(List<Account> accounts) {
        this.accounts = accounts;
        notifyDataSetChanged();
    }

    class AccountViewHolder extends RecyclerView.ViewHolder {
        private TextView accountType;
        private TextView accountBalance;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            accountType = itemView.findViewById(R.id.accountType);
            accountBalance = itemView.findViewById(R.id.accountBalance);
        }

        public void bind(Account account) {
            accountType.setText(account.getType());
            accountBalance.setText(String.valueOf(account.getBalance()));
        }
    }
}