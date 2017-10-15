package sys_bs.service;

import java.util.List;

import sys_bs.entity.Account;
/**
 * 账户业务层接口
 * @author Administrator
 *
 */
public interface IAccountService {
	/**
	 * 账户查询
	 * @param account
	 * @return
	 */
	public List<Account> listAccount(Account account);
	/**
	 * 账户新增
	 * @param account
	 * @return
	 */
	public boolean addAccount(Account account);
	/**
	 * 账户删除
	 * @param account
	 * @return
	 */
	public boolean deleteAccount(Account account);
	/**
	 * 账户修改
	 * @param account
	 * @return
	 */
	public boolean updateAccount(Account account);
}
