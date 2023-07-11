package com.aurora.bank.service;

import com.aurora.bank.exception.NoMoneyException;
import com.aurora.bank.exception.TransferException;

public interface AccountService {

    void transfer(String from,String to,double MoneyCount) throws NoMoneyException, TransferException;
}
