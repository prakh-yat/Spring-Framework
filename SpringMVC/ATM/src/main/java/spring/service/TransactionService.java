package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.TransactionDao;
import spring.model.AccountDetail;
import spring.model.Transaction;
import spring.model.UserDetail;
import java.util.Random;


@Service
public class TransactionService {
    @Autowired
    private TransactionDao transactionDao;

    public String transactionReferenceNumber(){
        Random random = new Random();
        long randomNumber = random.nextLong();
        String trn = String.valueOf(Math.abs(randomNumber));
        while (trn.length() < 10) {
            trn = "0" + trn;
        }
        return trn;
    }
    public int registerTransaction(Transaction transaction, UserDetail userDetail){
        transaction.setReferenceNo(transactionReferenceNumber());
        transaction.setUserDetail(userDetail);
        return this.transactionDao.save(transaction);
    }
    public void updateBalance(Transaction transaction){
        String type =transaction.getType();
        switch(type){
            case "Fund Transfer":
                double amount = transaction.getAmount();
                double tobal = transactionDao.getBalanceForAccount(transaction.getAccountNo());
                double frombal = transactionDao.getBalanceForAccount(transaction.getUserAcc());

                tobal+=amount;
                frombal-=amount;

                transactionDao.updateBalance(transaction.getAccountNo(),tobal);
                transactionDao.updateBalance(transaction.getUserAcc(),frombal);
                break;
            case "Deposit":
                double damount = transaction.getAmount();
                double dtobal = transactionDao.getBalanceForAccount(transaction.getAccountNo());
                dtobal+=damount;
                transactionDao.updateBalance(transaction.getAccountNo(),dtobal);
                break;
            case "Withdraw":
                double wamount = transaction.getAmount();
                double wfrombal = transactionDao.getBalanceForAccount(transaction.getUserAcc());
                wfrombal-=wamount;
                transactionDao.updateBalance(transaction.getAccountNo(),wfrombal);
                break;
        }
    }
    public boolean checkBalance(Transaction transaction) {
        double frombal = transactionDao.getBalanceForAccount(transaction.getUserAcc());
        double amount = transaction.getAmount();
        if (amount<frombal && frombal>500){
            return true;
        }
        return false;
    }
}
