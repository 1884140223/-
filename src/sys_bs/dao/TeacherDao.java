package sys_bs.dao;

import java.util.List;

import sys_bs.entity.Account;

/**
 * 持久化接口层
 * @author Administrator
 *
 */
public interface TeacherDao {
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
	public int addTeacher(Account account);
	
	/**
	 * 删除
	 * @param account
	 * @return
	 */
	public int deleteTeacher(Account account);
	
	/**
	 * 修改
	 * @param account
	 * @return
	 */
	public int updateTeacher(Account account);
}
