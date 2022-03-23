package de_thi_c08.util;

public class NotFoundBankAccountException extends Exception{
    public NotFoundBankAccountException(String error){
        super(error);
    }
}
