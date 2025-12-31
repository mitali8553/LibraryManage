package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Member;

public class MemberDAO {

	private Connection conn;
	public MemberDAO(Connection conn) {
		this.conn = conn;
	}
	
	//Add Member
	public boolean addMember(Member m) {
		boolean f = false;
		try {
			String sql = "INSERT INTO members(first_name,last_name,phone_no,email,address) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getFirstName());
			ps.setString(2, m.getLastName());
			ps.setString(3, m.getPhoneNo());
			ps.setString(4, m.getEmail());
			ps.setString(5, m.getAddress());
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		return f;
	}
	
	//View All Members
	public List<Member> getAllMembers() {
		List<Member> list = new ArrayList<Member>();
		try {
			String sql = "SELECT * FROM members";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setFirstName(rs.getString("first_name"));
				m.setLastName(rs.getString("last_name"));
				m.setPhoneNo(rs.getString("phone_no"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Delete Member
	public boolean deleteMember(int id) {
		boolean f = false;
		try {
			String sql = "DELETE FROM members WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	//Update Member
	public boolean updateMember(int id, String fname) {
	    boolean f = false;
	    try {
	        String sql = "UPDATE members SET first_name=? WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, fname);
	        ps.setInt(2, id);

	        int i = ps.executeUpdate();
	        if (i == 1) {
	            f = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}
	}
