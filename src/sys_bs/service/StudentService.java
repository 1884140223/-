package sys_bs.service;

import java.util.List;

import sys_bs.entity.Account;

public interface StudentService {
	/**
	 * 登录
	 * @param code
	 * @param password
	 * @return
	 */
	public boolean login(String code, String password);
	
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
	public boolean addStudent(Account account);
	/**
	 * 删除
	 * @param account
	 * @return
	 */
	public boolean deleteStudent(Account account);
	/**
	 * 修改
	 * @param account
	 * @return
	 */
	public boolean updateStudent(Account account);
}
