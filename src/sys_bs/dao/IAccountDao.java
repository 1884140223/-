package sys_bs.dao;

import java.util.List;

import sys_bs.entity.Account;

/**
 * 账户持久化层接口
 * @author Administrator
 *
 */
public interface IAccountDao {
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
	public int addAccount(Account account);
	/**
	 * 账户删除
	 * @param account
	 * @return
	 */
	public int deleteAccount(Account account);
	/**
	 * 账户修改
	 * @param account
	 * @return
	 */
	public int updateAccount(Account account);
}

