package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.Transaction;
import spring.service.impl.TransferServiceImpl;


@Controller
public class TransactionController {


    @Autowired
    private TransferServiceImpl transferServiceImpl;

    @RequestMapping(path = "/transaction", method = RequestMethod.POST)
    public String transaction(@RequestParam ("accountNo") String accountNo,
                              @RequestParam("balance") String balance,
                              @RequestParam("username") String username, Model model) {
        model.addAttribute("acc",accountNo);
        model.addAttribute("bal",balance);
        model.addAttribute("use",username);
            return "transaction";
        }



    @RequestMapping(path="/transfer", method = RequestMethod.POST)
    public String transfer(@ModelAttribute Transaction transaction,
                           @RequestParam("username") String username, Model model) {
        try {
            if (transferServiceImpl.validTransaction(transaction, username)) {
                return "transactionS";
            } else {
                model.addAttribute("errorMessage", "Transfer failed");
                return "transactionF";
            }
        } catch (TransferServiceImpl.AccountNotValidException ex) {
            model.addAttribute("errorMessage", "Invalid account number");
            return "transactionF";
        } catch (TransferServiceImpl.AmountNotValidException ex) {
            model.addAttribute("errorMessage", "Invalid transaction amount");
            return "transactionF";
        } catch (TransferServiceImpl.NotEnoughBalanceException ex) {
            model.addAttribute("errorMessage", "Not enough balance in the account");
            return "transactionF";
        }
    }


}


