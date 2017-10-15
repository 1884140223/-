package sys_bs.dao;

import java.util.List;

import sys_bs.entity.Account;

public interface StudentDao {
	/**
	 * 登录
	 * @param code
	 * @param password
	 * @return
	 */
	public int login(String code, String password);
	
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
	public int addStudent(Account account);
	
	/**
	 * 删除
	 * @param account
	 * @return
	 */
	public int deleteStudent(Account account);
	
	/**
	 * 修改
	 * @param account
	 * @return
	 */
	public int updateStudent(Account account);
}
