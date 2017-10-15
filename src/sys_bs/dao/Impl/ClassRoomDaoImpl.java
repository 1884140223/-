package sys_bs.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sys_bs.common.DataSources;
import sys_bs.dao.ClassRoomDao;
import sys_bs.entity.ClassRoom;

public class ClassRoomDaoImpl implements ClassRoomDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	private int num;
	
	/**
	 * 查询
	 */
	@Override
	public List<ClassRoom> listAccount(ClassRoom account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql="select * from class;";
		if(null != account.getId()){
			sql="select * from class where id="+account.getId()+";";
		}
		List<ClassRoom> listAccount = new ArrayList<ClassRoom>(); 
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				account = new ClassRoom();
				account.setId(rs.getString("id"));
				account.setCode(rs.getString("code"));
				account.setPassword(rs.getString("password"));
				account.setLei(rs.getString("lei"));
				account.setNumber(rs.getString("number"));
				account.setTeacher(rs.getString("teacher"));
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
	public int addClassRoom(ClassRoom account) {
		// TODO Auto-generated method stub
		conn=DataSources.getconn();
		String sql="insert into class(id,code,password,lei,number,teacher) "
				+"value('" + account.getId()+"','" +account.getCode()+"','"+account.getPassword()+"',?,?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, account.getLei());
			pst.setString(2, account.getNumber());
			pst.setString(3, account.getTeacher());
			num=pst.executeUpdate();
		} catch(SQLException e1){
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
	public int deleteClassRoom(ClassRoom account) {
		// TODO Auto-generated method stub
		conn=DataSources.getconn();
		String sql="delete from class where id=?;";
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

	
	/**
	 * 修改
	 */
	@Override
	public int updateClassRoom(ClassRoom account) {
		// TODO Auto-generated method stub
		conn = DataSources.getconn();
		String sql= "update class set code=?, lei=?, number=?, teacher=?, password=? where id = ?;";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, account.getCode());
			pst.setString(2, account.getLei());
			pst.setString(3, account.getNumber());
			pst.setString(4, account.getTeacher());
			pst.setString(5, account.getPassword());
			pst.setString(6, account.getId());
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataSources.closeall(rs, pst, conn);
		}
		return num;
	}

	
	/**
	 * 登录验证
	 */
	@Override
	public int login(String code, String password) {
		// TODO Auto-generated method stub
		int i=0;
		conn = DataSources.getconn();
		String sql="select * from class where code ='"+ code + "' and password='"+password+"';";
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
