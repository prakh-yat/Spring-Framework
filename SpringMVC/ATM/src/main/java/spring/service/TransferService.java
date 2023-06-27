package spring.service;

import spring.model.Transaction;
import spring.model.UserDetail;
import spring.service.impl.TransferServiceImpl;

public interface TransferService {
    boolean validAccount(Transaction transaction) throws TransferServiceImpl.AccountNotValidException;
    boolean validAmount(Transaction transaction) throws TransferServiceImpl.AmountNotValidException;
    boolean validTransaction(Transaction transaction,String username) throws TransferServiceImpl.AccountNotValidException, TransferServiceImpl.AmountNotValidException, TransferServiceImpl.NotEnoughBalanceException;



}
