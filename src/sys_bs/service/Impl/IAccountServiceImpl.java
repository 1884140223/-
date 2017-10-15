package sys_bs.service.Impl;

import java.util.List;

import sys_bs.entity.Account;
import sys_bs.service.IAccountService;
import sys_bs.dao.IAccountDao;
import sys_bs.dao.Impl.IAccountDaoImpl;;

public class IAccountServiceImpl implements IAccountService {
	IAccountDao iAccountDao = new IAccountDaoImpl();
	/**
	 * 账户查询
	 */
	@Override
	public List<Account> listAccount(Account account) {
		// TODO Auto-generated method stub
		List<Account> listAccount = iAccountDao.listAccount(account);
		return listAccount;
	}

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		int num = iAccountDao.addAccount(account);
		boolean flag = false;
		if(1 == num){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteAccount(Account account) {
		// TODO Auto-generated method stub
		int num = iAccountDao.deleteAccount(account);
		boolean flag = false;
		if(1 == num){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		int num = iAccountDao.updateAccount(account);
		boolean flag = false;
		if(1 == num){
			flag = true;
		}
		return flag;
	}

}
