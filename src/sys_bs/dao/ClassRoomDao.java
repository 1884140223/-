package sys_bs.dao;

import java.util.List;

import sys_bs.entity.ClassRoom;

public interface ClassRoomDao {
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
	public List<ClassRoom> listAccount(ClassRoom account);
	
	/**
	 * 增加
	 * @param account
	 * @return
	 */
	public int addClassRoom(ClassRoom account);
	
	/**
	 * 删除
	 * @param account
	 * @return
	 */
	public int deleteClassRoom(ClassRoom account);
	
	/**
	 * 修改
	 * @param account
	 * @return
	 */
	public int updateClassRoom(ClassRoom account);
}
