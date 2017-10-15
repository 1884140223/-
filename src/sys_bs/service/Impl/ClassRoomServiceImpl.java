package sys_bs.service.Impl;

import java.util.List;

import sys_bs.dao.ClassRoomDao;
import sys_bs.dao.StudentDao;
import sys_bs.dao.Impl.ClassRoomDaoImpl;
import sys_bs.dao.Impl.StudentDaoImpl;
import sys_bs.entity.ClassRoom;
import sys_bs.service.ClassRoomService;

public class ClassRoomServiceImpl implements ClassRoomService {
	ClassRoomDao ClassDao=new ClassRoomDaoImpl();
	@Override
	public List<ClassRoom> listAccount(ClassRoom account) {
		// TODO Auto-generated method stub
		List<ClassRoom> listAccount = ClassDao.listAccount(account);
		return listAccount;
	}

	@Override
	public boolean addClassRoom(ClassRoom account) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=ClassDao.addClassRoom(account);
		if(1==num){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deleteClassRoom(ClassRoom account) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=ClassDao.deleteClassRoom(account);
		if(1==num){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateClassRoom(ClassRoom account) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=ClassDao.updateClassRoom(account);
		if(1==num){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean login(String code, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int i=ClassDao.login(code, password);
		if(i==1){
			flag=true;
		}
		return flag;
	}

}
