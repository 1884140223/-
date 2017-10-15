package sys_bs.service;

import java.util.List;

import sys_bs.entity.Account;

/**
 * 业务层接口
 * @author Administrator
 *
 */
public interface TeacherService {
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
	public boolean addTeacher(Account account);
	/**
	 * 删除
	 * @param account
	 * @return
	 */
	public boolean deleteTeacher(Account account);
	/**
	 * 修改
	 * @param account
	 * @return
	 */
	public boolean updateTeacher(Account account);
}
