package sys_bs.service.Impl;

import java.util.List;


import sys_bs.dao.ILoginDao;
import sys_bs.dao.Impl.LoginDaoImpl;
import sys_bs.entity.Account;
import sys_bs.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
	ILoginDao iloginDao=new LoginDaoImpl();
	@Override
	public boolean Login(String code, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int i=iloginDao.login(code, password);
		if(i==1){
			flag=true;
		}
		return flag;
	}
	
	
	/**
	 * 账户查询
	 */
	@Override
	public List<Account> listAccount(Account account) {
		List<Account> listAccount = iloginDao.listAccount(account);
		return listAccount;
	}
	
	
	public boolean addAccount(Account account) {
		int num=iloginDao.addAccount(account);
		boolean flag=false;
		if(1==num){
			flag=true;
		}
		return flag;
	}
	
	
	
	public boolean deleteAccount(Account account) {
		int num=iloginDao.addAccount(account);
		boolean flag=false;
		if(1==num){
			flag=true;
		}
		return flag;
	}
	
	public boolean updateAccount(Account account) {
		int num=iloginDao.addAccount(account);
		boolean flag=false;
		if(1==num){
			flag=true;
		}
		return flag;
	}
	
}
