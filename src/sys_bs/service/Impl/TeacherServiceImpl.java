package sys_bs.service.Impl;

import java.util.List;

import sys_bs.dao.TeacherDao;
import sys_bs.dao.Impl.TeacherDaoImpl;
import sys_bs.entity.Account;
import sys_bs.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	TeacherDao teacherDao=new TeacherDaoImpl();
	/**
	 * 查询
	 */
	@Override
	public List<Account> listAccount(Account account) {
		List<Account> listAccount = teacherDao.listAccount(account);
		return listAccount;
	}

	/**
	 * 增加
	 */
	@Override
	public boolean addTeacher(Account account) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=teacherDao.addTeacher(account);
		if(1==num){
			flag=true;
		}
		return flag;
	}

	/**
	 * 删除
	 */
	@Override
	public boolean deleteTeacher(Account account) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=teacherDao.deleteTeacher(account);
		if(1==num){
			flag=true;
		}
		return flag;
	}

	/**
	 * 修改
	 */
	@Override
	public boolean updateTeacher(Account account) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=teacherDao.updateTeacher(account);
		if(1==num){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean login(String code, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int i=teacherDao.login(code, password);
		if(i==1){
			flag=true;
		}
		return flag;
	}



}
