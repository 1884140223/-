package sys_bs.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sys_bs.common.DataSources;
import sys_bs.dao.StudentDao;
import sys_bs.entity.Account;

public class StudentDaoImpl implements StudentDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	private int num;
	@Override
	public List<Account> listAccount(Account account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql="select * from student";
		if(null != account.getId()){
			sql="select * from student where id="+account.getId()+";";
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

	@Override
	public int addStudent(Account account) {
		// TODO Auto-generated method stub
		conn=DataSources.getconn();
		String sql="insert into student(id,code,name,password,age,sex) "
				+"value('" + account.getId()+"','" +account.getCode() +"','"
				+account.getName() +"',?,?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, account.getPassword());
			pst.setString(2, account.getAge());
			pst.setString(3, account.getSex());
			num=pst.executeUpdate();
		} catch(SQLException e1){
			e1.printStackTrace();
		}finally{
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}

	@Override
	public int deleteStudent(Account account) {
		// TODO Auto-generated method stub
		conn=DataSources.getconn();
		String sql="delete from student where id=?;";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, account.getId());
			num=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}

	@Override
	public int updateStudent(Account account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql= "update student set name=?, password=?, age=?, sex=? where id = ?;";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, account.getName());
			pst.setString(2, account.getPassword());
			pst.setString(3, account.getAge());
			pst.setString(4, account.getSex());
			pst.setString(5, account.getId());
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}

	@Override
	public int login(String code, String password) {
		// TODO Auto-generated method stub
		int i=0;
		conn = DataSources.getconn();
		String sql="select * from student where code ='"+ code + "' and password='"+password+"';";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			rs.last();
			i=rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
