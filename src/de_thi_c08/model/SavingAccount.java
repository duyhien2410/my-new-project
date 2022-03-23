package de_thi_c08.model;

public class SavingAccount extends AccountBanking{
    private int depositAmount;
    private String depositDay;
    private float interestRate;
    private String tenor;

    public SavingAccount() {
    }

    public SavingAccount(int accountId, String accountCode, String accountName,
                         String accountCreatDay, int depositAmount, String depositDay, float interestRate, String tenor) {
        super(accountId, accountCode, accountName, accountCreatDay);
        this.depositAmount = depositAmount;
        this.depositDay = depositDay;
        this.interestRate = interestRate;
        this.tenor = tenor;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getDepositDay() {
        return depositDay;
    }

    public void setDepositDay(String depositDay) {
        this.depositDay = depositDay;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                super.toString() +
                ", depositAmount=" + depositAmount +
                ", depositDay='" + depositDay + '\'' +
                ", interestRate=" + interestRate +
                ", tenor='" + tenor + '\'' +
                '}';
    }

    public String getInfoSavingAccountToCSV(){
        return this.getAccountId()+","+this.getAccountCode()+","+this.getAccountName()+","+
                this.getAccountCreatDay()+","+this.getDepositAmount()+","+this.getDepositDay()+","+
                this.getInterestRate()+","+this.getTenor();
    }
}
