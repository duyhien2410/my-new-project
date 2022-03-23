package de_thi_c08.util;

import de_thi_c08.model.PaymentAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWritePaymentAccount {
    public static void write(List<PaymentAccount> paymentAccountList, boolean append) {
        File file = new File("src/de_thi_c08/data/bank_payment_accounts.csv");

        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (PaymentAccount e : paymentAccountList) {
                bufferedWriter.write(e.getInfoPaymentAccountToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PaymentAccount> read() {
        List<PaymentAccount> paymentAccountList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/de_thi_c08/data/bank_payment_accounts.csv");
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            PaymentAccount paymentAccount;
            while ((line = bufferedReader.readLine())!= null){
                temp = line.split(",");
                paymentAccount = new PaymentAccount(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5]);
                paymentAccountList.add(paymentAccount);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paymentAccountList;
    }
}
