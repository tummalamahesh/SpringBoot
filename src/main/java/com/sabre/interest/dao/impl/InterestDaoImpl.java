package com.sabre.interest.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sabre.interest.beans.InterestBean;
import com.sabre.interest.dao.InterestDao;
import com.sabre.interest.rowmapper.InterestRowMapper;

@Component
public class InterestDaoImpl  implements InterestDao{
	
		public InterestDaoImpl() {
		super();
		System.out.println("------------------InterestDaoImpl constructor------------");
	}
		
	private static final String GET_ALL_ACTIVE_INTERESTS = "select id, name, address, amount, datetime,rate from interest where status = 1";
	private static final String ADD_NEW_INTEREST = "insert into interest(name,address,amount,datetime,status,rate) values(?,?,?,?,?,?)";
	private static final String GET_INTEREST_BY_ID = "select id, name, address, amount, datetime, status, rate from interest where id= ?";
	private static final String UPDATE_INTEREST = "update interest set name = ?, address = ?, amount = ?, datetime = ?, rate = ? where id = ?";
	private static final String DELETE_INTEREST = "update interest set status = 0 where id = ?";
	final SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private InterestRowMapper rowMapper;
	
	
	


	public static void main(String a[]) throws ParseException {
		System.out.println("hello");
		String pattern = "yyyy-MMM-dd";
		//String pattern = "dd-MMM-YYYY";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		java.util.Date date = simpleDateFormat.parse("2018-OCT-09");
		System.out.println(date);
	}
	

	@Override
	public void addInterest(InterestBean interestBean) {
		System.out.println("addInterest-------------------------"+interestBean.getDatetime());
		jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement statement = connection.prepareStatement(ADD_NEW_INTEREST);
                    statement.setString(1, interestBean.getName());
                    statement.setString(2, interestBean.getAddress() );
                    statement.setDouble(3, interestBean.getAmount());
                    statement.setDate(4, convertDateStringToDate(interestBean.getDatetime()));
                    statement.setInt(5, 1);
                    statement.setDouble(6, interestBean.getRate());
                    return statement;
            }

			private Date convertDateStringToDate(String datetime) {
				try {
					System.out.println("parsing--------------"+format.parse(datetime));
					Date time = new Date(format.parse(datetime).getTime());
					return time;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
            });
		
	}

	@Override
	public List<InterestBean> getAllInterests() {
		System.out.println("getAllInterests-------------------------"+jdbcTemplate);
		return jdbcTemplate.query(GET_ALL_ACTIVE_INTERESTS, rowMapper);
		
	}

	@Override
	public InterestBean getInterest(InterestBean interestBean) {
		return jdbcTemplate.queryForObject(GET_INTEREST_BY_ID, rowMapper,interestBean.getId());
		//return null;
	}

	@Override
	public void updateInterest(InterestBean interestBean) {
		jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement statement = connection.prepareStatement(UPDATE_INTEREST);
                    statement.setString(1, interestBean.getName());
                    statement.setString(2, interestBean.getAddress() );
                    statement.setDouble(3, interestBean.getAmount());
                    statement.setDate(4, convertDateStringToDate(interestBean.getDatetime()));
                    statement.setDouble(5, interestBean.getRate());
                    statement.setInt(6, interestBean.getId());
                    return statement;
            }

			private Date convertDateStringToDate(String datetime) {
				try {
					System.out.println("parsing--------------"+format.parse(datetime));
					Date time = new Date(format.parse(datetime).getTime());
					return time;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
            });
		
	}

	@Override
	public void deleteInterest(InterestBean interestBean) {
		jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement statement = connection.prepareStatement(DELETE_INTEREST);
                    statement.setInt(1, interestBean.getId());
                    return statement;
            }

			private Date convertDateStringToDate(String datetime) {
				try {
					System.out.println("parsing--------------"+format.parse(datetime));
					Date time = new Date(format.parse(datetime).getTime());
					return time;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
            });
		
	}
	
	public void setRowMapper(InterestRowMapper rowMapper) {
		this.rowMapper = rowMapper;
	}
}
