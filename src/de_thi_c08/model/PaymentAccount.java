package de_thi_c08.model;

public class PaymentAccount extends AccountBanking{
    private String cardNumber; //số thẻ
    private String amountAccount; //số tiền trong tài khoản;

    public PaymentAccount() {
    }

    public PaymentAccount(int accountId, String accountCode, String accountName, String accountCreatDay, String cardNumber, String amountAccount) {
        super(accountId, accountCode, accountName, accountCreatDay);
        this.cardNumber = cardNumber;
        this.amountAccount = amountAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAmountAccount() {
        return amountAccount;
    }

    public void setAmountAccount(String amountAccount) {
        this.amountAccount = amountAccount;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                super.toString() +
                ", cardNumber='" + cardNumber + '\'' +
                ", amountAccount='" + amountAccount + '\'' +
                '}';
    }

   public String getInfoPaymentAccountToCSV(){
        return this.getAccountId()+","+this.getAccountCode()+","+this.getAccountName()+","+
                this.getAccountCreatDay()+","+this.getCardNumber()+","+this.getAmountAccount();
   }
}
