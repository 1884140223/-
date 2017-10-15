package sys_bs.dao;

import java.util.List;

import sys_bs.entity.*;
/**
 * 登录持久化接口
 * @author Administrator
 *
 */
public interface ILoginDao {
/**
 * 登录
 * @param code
 * @param password
 * @return
 */
	public int login(String code,String password);
	
	
/**
 * 查询
 * @param account
 * @return
 */
	public List<Account> listAccount(Account account);
	
	/**
	 * 增加
	 * @param account
	 * @return
	 */
	public int addAccount(Account account);
	
	
	/**
	 * 删除
	 * @param account
	 * @return
	 */
	public int deleteAccount(Account account);
	
	
	/**
	 * 修改
	 * @param account
	 * @return
	 */
	public int updateAccount(Account account);
}
