package de_thi_c08.service.impl;

import de_thi_c08.model.PaymentAccount;
import de_thi_c08.service.BankingAccount;
import de_thi_c08.util.NotFoundBankAccountException;
import de_thi_c08.util.ReadAndWritePaymentAccount;
import de_thi_c08.util.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentAccountImpl implements BankingAccount {
    private static List<PaymentAccount> paymentAccountList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public final String CODE_REGEX = "^(TECHCOMBANK)[-]\\d{4}$";
    public final String NAME_REGEX = "^[A-Z][a-z]{1,}$";
    public final String DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    public final String CARD_NUMBER_REGEX = "^(1900)[-]\\d{4}[-]\\d{4}$";
    public final String AMOUNT_ACCOUNT_REGEX = "^\\d+$";

    @Override
    public void addAccount() {
        int accountId = 1;
        if (!paymentAccountList.isEmpty()) {
            accountId = paymentAccountList.get(paymentAccountList.size()-1).getAccountId() +1;
        }

        String accountCode = inputAccountCode();
        String accountName = inputAccountName();
        String accountCreatDay = inputAccountCreatDay();
        String cardNumber = inputCardNumber();
        String amountAccount = inputAccountAmount();

        PaymentAccount paymentAccount = new PaymentAccount(accountId, accountCode, accountName, accountCreatDay, cardNumber, amountAccount);
        paymentAccountList.add(paymentAccount);
        ReadAndWritePaymentAccount.write(paymentAccountList, false);
        System.out.println("Đã thêm mới thành công.");
    }

    @Override
    public void deleteAccount() throws NotFoundBankAccountException{
        displayAccount();
        paymentAccountList = ReadAndWritePaymentAccount.read();
        System.out.print("Nhập id muốn xoá:");
        int accountId = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < paymentAccountList.size(); i++) {
            if (accountId == paymentAccountList.get(i).getAccountId()){
                System.out.println("Bạn có chắc chắn muốn xoá?");
                System.out.print("\n Nhập YES hoặc NO:");
                String choose = sc.nextLine().toLowerCase();
                if (choose.contains("yes")){
                    paymentAccountList.remove(i);
                    ReadAndWritePaymentAccount.write(paymentAccountList,false);
                    System.out.println("Đã xoá thành công.");
                    break;
                } else if (choose.contains("no")){
                    System.out.println("Vẫn giữ nguyên tài khoản.");
                    break;
                } else {
                    throw new NotFoundBankAccountException("Chỉ có thể nhập YES hoặc NO.");
                }
            }
        }
    }

    @Override
    public void displayAccount() {
        paymentAccountList = ReadAndWritePaymentAccount.read();
        System.out.println("-- Danh sách các tài khoản ngân hàng thanh toán --");
        for (PaymentAccount pa : paymentAccountList) {
            System.out.println(pa);
        }
    }

    @Override
    public void searchAccount() {
        paymentAccountList = ReadAndWritePaymentAccount.read();
        System.out.print("Nhập mã tài khoản cần tìm kiếm:");
        String searchAccountCode = sc.nextLine().toLowerCase();

        for (int i = 0; i < paymentAccountList.size(); i++){
            if (searchAccountCode.contains(paymentAccountList.get(i).getAccountCode().toLowerCase())){
                System.out.println("-- Tài khoản bạn cần tìm --");
                System.out.println(paymentAccountList.get(i).toString());
            }
        }
    }

    private String inputAccountCode() {
        System.out.print("Nhập mã tài khoản (TECHCOMBANK-xxxx):");
        return RegexData.regexStr(sc.nextLine(), CODE_REGEX, "Nhập sai cú pháp, vui lòng nhập lại:");
    }

    private String inputAccountName() {
        System.out.print("Nhập tên chủ tài khoản (Chữ cái đầu in hoa):");
        return RegexData.regexStr(sc.nextLine(), NAME_REGEX, "Nhập sai cú pháp, vui lòng nhập lại:");
    }

    private String inputAccountCreatDay() {
        System.out.print("Nhập ngày tạo tài khoản (dd/MM/yyyy):");
        return RegexData.regexStr(sc.nextLine(), DATE_REGEX, "Nhập sai cú pháp, vui lòng nhập lại:");
    }

    private String inputCardNumber() {
        System.out.print("Nhập số thẻ tài khoản (1900-xxxx-xxxx):");
        return RegexData.regexStr(sc.nextLine(), CARD_NUMBER_REGEX, "Nhập sai cú pháp, vui lòng nhập lại:");
    }

    private String inputAccountAmount() {
        System.out.print("Nhập số tiền trong tài khoản:");
        return RegexData.regexStr(sc.nextLine(), AMOUNT_ACCOUNT_REGEX, "Nhập sai cú pháp, vui lòng nhập lại:");
    }
}
