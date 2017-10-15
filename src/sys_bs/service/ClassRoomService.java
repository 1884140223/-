package sys_bs.service;

import java.util.List;

import sys_bs.entity.ClassRoom;

public interface ClassRoomService {
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
	public List<ClassRoom> listAccount(ClassRoom account);
	/**
	 * 增加
	 * @param account
	 * @return
	 */
	public boolean addClassRoom(ClassRoom account);
	/**
	 * 删除
	 * @param account
	 * @return
	 */
	public boolean deleteClassRoom(ClassRoom account);
	/**
	 * 修改
	 * @param account
	 * @return
	 */
	public boolean updateClassRoom(ClassRoom account);
}
