package de_thi_c08.service;

import de_thi_c08.util.NotFoundBankAccountException;

public interface BankingAccount {
    void addAccount();
    void deleteAccount() throws NotFoundBankAccountException;
    void displayAccount();
    void searchAccount();
}
