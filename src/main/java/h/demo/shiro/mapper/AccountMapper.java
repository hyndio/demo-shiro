package h.demo.shiro.mapper;

import h.demo.shiro.entity.Account;

/**
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-12
 */
public interface AccountMapper {

  Account getAccountByUsername(String username);

  Account getAccountByUsernameAndPassword(Account account);

}
