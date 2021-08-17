package com.exam.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.SQLException;

public class RequestDAO {
	Connection con = null;
	PreparedStatement ps = null;
	public boolean addRequest(String e_code,int stud_id, int facId, int reqId)
	{
		boolean b = false;
		con = DBconnection.getConnection();
		try {
			ps = con.prepareStatement("insert into exam_requests values(?,?,?,?,?)");
=======
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.model.Request;

public class RequestDAO {
	Connection con = null;
	PreparedStatement ps = null;
	public boolean addRequest(String e_code,int stud_id, int facId, int reqId,String studName,String cName)
	{
		boolean b = false;
		String status="Enroll";
		con = DBconnection.getConnection();
		try {
			ps = con.prepareStatement("insert into exam_requests values(?,?,?,?,?,?,?,?)");
>>>>>>> abae294 (added code for rquest sent)
			ps.setInt(1, reqId);
			ps.setString(2, e_code);
			ps.setInt(3, stud_id);
			ps.setInt(4, facId);
			ps.setInt(5, 0);
<<<<<<< HEAD
=======
			ps.setString(6, studName);
			ps.setString(7, cName);
			ps.setString(8, status);
>>>>>>> abae294 (added code for rquest sent)
			int i = ps.executeUpdate();
			if(i>0)
				b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
<<<<<<< HEAD
=======
	public ResultSet getDataByFacId(int id) {
		con=DBconnection.getConnection();
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from exam_requests where facId=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public Request getDataByReqId(int id) {
		con=DBconnection.getConnection();
		ResultSet rs=null;
		Request r =null;
		try {
			ps=con.prepareStatement("select * from exam_requests where req_id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				r=new Request();
				r.setReqId(rs.getInt(1));
				r.setExamCode(rs.getString(2));
				r.setStudId(rs.getInt(3));
				r.setFacId(rs.getInt(4));
				r.setStudName(rs.getString(6));
				r.setCourseName(rs.getString(7));
				r.setStatus(rs.getString(8));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public boolean updateStatus(String string,int id) {
		boolean b=false;
		con=DBconnection.getConnection();
		try {
			ps=con.prepareStatement("update exam_requests set status=? where req_id=?");
			ps.setString(1, string);
			ps.setInt(2, id);
			int i=ps.executeUpdate();
			if(i>0) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
>>>>>>> abae294 (added code for rquest sent)

}
