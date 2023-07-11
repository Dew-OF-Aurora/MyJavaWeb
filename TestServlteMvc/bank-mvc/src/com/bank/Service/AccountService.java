package com.bank.Service;

import com.bank.Exceptions.AppException;
import com.bank.Exceptions.MoneyNotEnoughException;

public interface AccountService {
    void transfer(String formName, String toName, double money) throws MoneyNotEnoughException, AppException;
}
