package de_thi_c08.model;

public abstract class AccountBanking {
    private int accountId;
    private String accountCode;
    private String accountName;
    private String accountCreatDay;

    public AccountBanking() {
    }

    public AccountBanking(int accountId, String accountCode, String accountName, String accountCreatDay) {
        this.accountId = accountId;
        this.accountCode = accountCode;
        this.accountName = accountName;
        this.accountCreatDay = accountCreatDay;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountCreatDay() {
        return accountCreatDay;
    }

    public void setAccountCreatDay(String accountCreatDay) {
        this.accountCreatDay = accountCreatDay;
    }

    @Override
    public String toString() {
        return
                "accountId='" + accountId + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountCreatDay=" + accountCreatDay;
    }
}
