package sys_bs.dao.Impl;

import java.sql.*;
import java.util.*;

import sys_bs.common.DataSources;
import sys_bs.dao.ILoginDao;
import sys_bs.entity.Account;

public class LoginDaoImpl implements ILoginDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	private int num;
	@Override
	public int login(String code, String password) {
		// TODO Auto-generated method stub
		int i=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_sql","root","123456");
			String sql="select * from user where code ='"+ code + "' and password='"+password+"';";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			rs.last();
			i=rs.getRow();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public List<Account> listAccount(Account account) {
		// TODO Auto-generated method stub
		//st=DataSources.getst();
		conn = DataSources.getconn();
		String sql = "select * from user";
		if(null != account.getId()){
			sql = "select * from user where id= '"+account.getId()+"';";
		}
		List<Account> listAccount = new ArrayList<Account>();
		try{
			//rs = st.executeQuery(sql);
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				account=new Account();
				account.setId(rs.getString("id"));
				account.setCode(rs.getString("code"));
				account.setName(rs.getString("name"));
				account.setSex(rs.getString("sex"));
				account.setAge(rs.getString("age"));
				listAccount.add(account);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataSources.close(rs, pst, conn);
		}
		return listAccount;
	}
	@Override
	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql = "insert into user(id code name password sex age)"+"value('"+account.getId()
			+"','"+account.getCode()+"','"+account.getName()+"','"+account.getPassword()+"','"
				+account.getSex()+"','"+account.getAge()+"';";
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1, account.getPassword());
			pst.setString(2, account.getSex());
			pst.setString(3, account.getAge());
			num = pst.executeUpdate();
		}catch (SQLException e1){
			e1.printStackTrace();
		}finally {
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}
	@Override
	public int deleteAccount(Account account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql = "delete from user where code=?;";
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1,account.getId());
			num = pst.executeUpdate();
		}catch (SQLException e1){
			e1.printStackTrace();
		}finally {
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}
	@Override
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql = "updata user set id=?,code=?,name=?,password=?sex=?,age=?;";
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1, account.getName());
			pst.setString(2, account.getPassword());
			pst.setString(3, account.getSex());
			pst.setString(4, account.getAge());
			pst.setString(5, account.getId());
			num = pst.executeUpdate();
		}catch (SQLException e1){
			e1.printStackTrace();
		}finally {
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}

}
