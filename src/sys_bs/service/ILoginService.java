package sys_bs.service;

import sys_bs.entity.Account;
import java.util.*;
/**
 * 登录业务层实现
 * @author Administrator
 *
 */
public interface ILoginService {
	public boolean Login(String code,String password);
	
	public List<Account> listAccount(Account account);
	
	public boolean addAccount(Account account);
	public boolean deleteAccount(Account account);
	public boolean updateAccount(Account account);
}
