package com.springDev.Pjt210609_01.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springDev.Pjt210609_01.member.Member;

@Repository
public class MemberDao implements IMemberDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String userpw = "tiger";

	private DriverManagerDataSource dataSource;
	private JdbcTemplate template;
	
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;

	public MemberDao() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(userid);
		dataSource.setPassword(userpw);

		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}

	@Override
	public int memberInsert(Member member) {
		
		int result = 0;

		String sql = "INSERT INTO member (memId, memPw, memMail) values (?,?,?)";
		result = template.update(sql, member.getMemId(), member.getMemPw(), member.getMemMail());

		/*
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "INSERT INTO member (memId, memPw, memMail) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2, member.getMemPw());
			pstmt.setString(3, member.getMemMail());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		return result;
		
	}

	@Override
	public Member memberSelect(Member member) {
		List<Member> members = null;
//		Member mem = null;

		final String sql = "SELECT * FROM member WHERE memId = ? AND memPw = ?";

		// 1st
//		members = template.query(sql, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement pstmt) throws SQLException {
//				pstmt.setString(1, member.getMemId());
//				pstmt.setString(2, member.getMemPw());
//			}
//		}, new RowMapper<Member>() {
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Member member = new Member();
//				member.setMemId(rs.getString("memId"));
//				member.setMemPw(rs.getString("memPw"));
//				member.setMemMail(rs.getString("memMail"));
//				member.setMemPurcNum(rs.getInt("memPurcNum"));
//
//				return member;
//			}
//		});

		// 2nd
		members = template.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemId());
				pstmt.setString(2, member.getMemPw());
				return pstmt;
			}
		}, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setMemId(rs.getString("memId"));
				mem.setMemPw(rs.getString("memPw"));
				mem.setMemMail(rs.getString("memMail"));
				mem.setMemPurcNum(rs.getInt("memPurcNum"));
				return mem;
			}
		});

		return (members.isEmpty()) ? null : members.get(0);

		/*
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "SELECT * FROM member WHERE memId = ? AND memPw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2, member.getMemPw());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String memId = rs.getString("memid");
				String memPw = rs.getString("mempw");
				String memMail = rs.getString("memMail");
				int memPurcNum = rs.getInt("memPurcNum");
				
				mem = new Member();
				mem.setMemId(memId);
				mem.setMemPw(memPw);
				mem.setMemMail(memMail);
				mem.setMemPurcNum(memPurcNum);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mem;
	 	*/
	}

	@Override
	public int memberUpdate(Member member) {
		int result = 0;
		final String sql = "UPDATE member SET memPw = ?, memMail = ? WHERE memId = ?";

		result = template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMemPw());
				pstmt.setString(2, member.getMemMail());
				pstmt.setString(3, member.getMemId());
			}
		});

		/*
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "UPDATE member SET memPw = ?, memMail = ? WHERE memId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemPw());
			pstmt.setString(2, member.getMemMail());
			pstmt.setString(3, member.getMemId());
			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		return result;
		
	}

	@Override
	public int memberDelete(Member member) {
		int result = 0;
		final String sql = "DELETE member WHERE memId = ? AND memPw = ?";

		result = template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMemId());
				pstmt.setString(2, member.getMemPw());
			}
		});

		/*
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "DELETE member WHERE memId = ? AND memPw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2, member.getMemPw());
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		return result;
		
	}

}