package de_thi_c08.util;

import de_thi_c08.model.PaymentAccount;
import de_thi_c08.model.SavingAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteSavingAccount {
    public static void write(List<SavingAccount> savingAccountList, boolean append) {
        File file = new File("src/de_thi_c08/data/bank_saving_account.csv");

        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (SavingAccount e : savingAccountList) {
                bufferedWriter.write(e.getInfoSavingAccountToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<SavingAccount> read() {
        List<SavingAccount> savingAccountList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/de_thi_c08/data/bank_saving_account.csv");
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            SavingAccount savingAccount;
            while ((line = bufferedReader.readLine())!= null){
                temp = line.split(",");
                savingAccount = new SavingAccount(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3],
                        Integer.parseInt(temp[4]), temp[5], Float.parseFloat(temp[6]),temp[7] );
                savingAccountList.add(savingAccount);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savingAccountList;
    }
}
