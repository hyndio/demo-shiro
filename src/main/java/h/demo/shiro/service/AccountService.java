package h.demo.shiro.service;

import h.demo.shiro.entity.Account;

public interface AccountService {

    Account getAccount(String username);

    Account getAccount(String username, String password);

    void insertAccount(Account account);

    void updateAccount(Account account);

}
