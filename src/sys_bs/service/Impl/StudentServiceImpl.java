package sys_bs.service.Impl;

import java.util.List;

import sys_bs.dao.StudentDao;
import sys_bs.dao.Impl.StudentDaoImpl;
import sys_bs.entity.Account;
import sys_bs.service.StudentService;

public class StudentServiceImpl implements StudentService {
	StudentDao studentDao=new StudentDaoImpl();
	@Override
	public List<Account> listAccount(Account account) {
		// TODO Auto-generated method stub
		List<Account> listAccount = studentDao.listAccount(account);
		return listAccount;
	}

	@Override
	public boolean addStudent(Account account) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=studentDao.addStudent(account);
		if(1==num){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deleteStudent(Account account) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=studentDao.deleteStudent(account);
		if(1==num){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateStudent(Account account) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=studentDao.updateStudent(account);
		if(1==num){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean login(String code, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int i=studentDao.login(code, password);
		if(i==1){
			flag=true;
		}
		return flag;
	}

}
