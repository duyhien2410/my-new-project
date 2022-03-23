package de_thi_c08.controller;

import de_thi_c08.model.SavingAccount;
import de_thi_c08.service.impl.PaymentAccountImpl;
import de_thi_c08.service.impl.SavingAccountImpl;
import de_thi_c08.util.NotFoundBankAccountException;

import java.util.Scanner;

public class BankController {
    public void displayMainMenu() {
        PaymentAccountImpl paymentAccount = new PaymentAccountImpl();
        SavingAccountImpl savingAccount = new SavingAccountImpl();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("\n--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG –-" +
                    "\n1.Thêm mới" +
                    "\n2.Xóa" +
                    "\n3.Xem danh sách các tài khoản ngân hàng" +
                    "\n4.Tìm kiếm" +
                    "\n5.Thoát");
            System.out.print("Chọn chức năng theo số(để tiếp tục):");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1.Thêm mới tài khoản thanh toán." +
                            "\n2.Thêm mới tài khoản tiết kiệm." +
                            "\n3.Trở về menu chính.");
                    System.out.print("\n Chọn loại tài khoản thêm mới:");
                    int choose1 = Integer.parseInt(sc.nextLine());
                    switch (choose1){
                        case 1:
                            paymentAccount.addAccount();
                            break;
                        case 2:
                            savingAccount.addAccount();
                            break;
                        case 3:
                            flag = false;
                    }
                case 2:
                    System.out.println("1.Xoá tài khoản thanh toán." +
                            "\n2.Xoá tài khoản tiết kiệm." +
                            "\n3.Trở về menu chính.");
                    System.out.print("\n Chọn loại tài khoản để xoá:");
                    int choose2 = Integer.parseInt(sc.nextLine());
                    switch (choose2){
                        case 1:
                            try {
                                paymentAccount.deleteAccount();
                            } catch (NotFoundBankAccountException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                savingAccount.deleteAccount();
                            } catch (NotFoundBankAccountException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            flag = false;
                    }
                case 3:
                    paymentAccount.displayAccount();
                    savingAccount.displayAccount();
                    break;
                case 4:
                    System.out.println("1.Tìm kiếm tài khoản thanh toán." +
                            "\n2.Tìm kiếm tài khoản tiết kiệm." +
                            "\n3.Trở về menu chính.");
                    System.out.print("\n Chọn loại tài khoản để tìm kiếm:");
                    int choose3 = Integer.parseInt(sc.nextLine());
                    switch (choose3){
                        case 1:
                            paymentAccount.searchAccount();
                            break;
                        case 2:
                            savingAccount.searchAccount();
                            break;
                        case 3:
                            flag = false;
                    }
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập sai, vui lòng nhập lại");
                    flag = false;
            }
        } while (flag);
    }
}
