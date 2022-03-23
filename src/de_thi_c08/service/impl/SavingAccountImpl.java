package de_thi_c08.service.impl;

import de_thi_c08.model.SavingAccount;
import de_thi_c08.service.BankingAccount;
import de_thi_c08.util.NotFoundBankAccountException;
import de_thi_c08.util.ReadAndWriteSavingAccount;
import de_thi_c08.util.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SavingAccountImpl implements BankingAccount {
    private static List<SavingAccount> savingAccountList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public final String CODE_REGEX = "^(TECHCOMBANK)[-]\\d{4}$";
    public final String NAME_REGEX = "^[A-Z][a-z]{1,}$";
    public final String DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    public final String AMOUNT_REGEX = "^\\d+$";
    public final String INTEREST_RATE_REGEX = "^\\d+([.]\\d+)*$";

    @Override
    public void addAccount() {
        int accountId = 1;
        if (!savingAccountList.isEmpty()) {
            accountId = savingAccountList.get(savingAccountList.size()-1).getAccountId() +1;
        }

        String accountCode = inputAccountCode();
        String accountName = inputAccountName();
        String accountCreatDay = inputAccountCreatDay();
        int depositAmount = Integer.parseInt(inputDepositAmount());
        String depositDay = inputDepositDay();
        float interestRate = Float.parseFloat(inputInterestRate());
        String tenor = inputTenor();

        SavingAccount savingAccount = new SavingAccount(accountId, accountCode, accountName, accountCreatDay, depositAmount,
                depositDay, interestRate, tenor);
        savingAccountList.add(savingAccount);
        ReadAndWriteSavingAccount.write(savingAccountList, false);
        System.out.println("Đã thêm mới thành công.");
    }

    @Override
    public void deleteAccount() throws NotFoundBankAccountException {
        displayAccount();
        savingAccountList = ReadAndWriteSavingAccount.read();
        System.out.print("Nhập id muốn xoá:");
        int accountId = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < savingAccountList.size(); i++) {
            if (accountId == savingAccountList.get(i).getAccountId()){
                System.out.println("Bạn có chắc chắn muốn xoá?");
                System.out.print("\n Nhập YES hoặc NO:");
                String choose = sc.nextLine().toLowerCase();
                if (choose.contains("yes")){
                    savingAccountList.remove(i);
                    ReadAndWriteSavingAccount.write(savingAccountList,false);
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
        savingAccountList = ReadAndWriteSavingAccount.read();
        System.out.println("-- Danh sách các tài khoản ngân hàng tiết kiệm --");
        for (SavingAccount sa : savingAccountList) {
            System.out.println(sa);
        }
    }

    @Override
    public void searchAccount() {
        savingAccountList = ReadAndWriteSavingAccount.read();
        System.out.print("Nhập mã tài khoản cần tìm kiếm:");
        String searchAccountCode = sc.nextLine().toLowerCase();

        for (int i = 0; i < savingAccountList.size(); i++){
            if (searchAccountCode.contains(savingAccountList.get(i).getAccountCode().toLowerCase())){
                System.out.println("-- Tài khoản bạn cần tìm --");
                System.out.println(savingAccountList.get(i).toString());
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

    private String inputDepositAmount(){
        System.out.print("Nhập số tiền gửi tiết kiệm:");
        return RegexData.regexStr(sc.nextLine(), AMOUNT_REGEX, "Nhập sai cú pháp, vui lòng nhập lại:");
    }

    private String inputDepositDay(){
        System.out.print("Nhập ngày gửi tiết kiệm:");
        return RegexData.regexStr(sc.nextLine(), DATE_REGEX, "Nhập sai cú pháp, vui lòng nhập lại:");
    }

    private String inputInterestRate(){
        System.out.print("Nhập lãi suất");
        return RegexData.regexStr(sc.nextLine(), INTEREST_RATE_REGEX, "Nhập sai cú pháp, vui lòng nhập lại:");
    }

    private String inputTenor(){
        System.out.print("Nhập kì hạn gửi tiết kiệm (số tháng):");
        return RegexData.regexStr(sc.nextLine(), AMOUNT_REGEX, "Nhập sai cú pháp, vui lòng nhập lại:");
    }
}
