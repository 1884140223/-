package sys_bs.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sys_bs.dao.IAccountDao;
import sys_bs.entity.Account;
import sys_bs.common.DataSources;

public class IAccountDaoImpl implements IAccountDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	private int num;
	
	/**
	 * 查询
	 */
	@Override
	public List<Account> listAccount(Account account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql = "select * from user;";
		if(null != account.getId()){
			sql = "select * from user where id =" + account.getId() + ";";
		}
		List<Account> listAccount = new ArrayList<Account>(); 
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				account = new Account();
				account.setId(rs.getString("id"));
				account.setCode(rs.getString("code"));
				account.setPassword(rs.getString("password"));
				account.setName(rs.getString("name"));
				account.setSex(rs.getString("sex"));
				account.setAge(rs.getString("age"));
				listAccount.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataSources.close(rs, pst, conn);
		}
		return listAccount;
	}

	/**
	 * 增加
	 */
	@Override
	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql = "insert into user(id, code, name, password, sex, age) "
				+ "value('" + account.getId() + "', '" + account.getCode() + "','" + account.getName() + "', ?, ?, ?);";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, account.getPassword());
			pst.setString(2, account.getSex());
			pst.setString(3, account.getAge());
			num = pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteAccount(Account account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql = "delete from user where id = ?;";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, account.getId());
			num = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}
	
	/**
	 * 修改
	 */
	@Override
	public int updateAccount(Account account) {
		conn = DataSources.getconn();
		String sql = "update user set name=?, password=?, sex=?, age=? where id = ?;";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, account.getName());
			pst.setString(2, account.getPassword());
			pst.setString(3, account.getSex());
			pst.setString(4, account.getAge());
			pst.setString(5, account.getId());
			num = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}

}
