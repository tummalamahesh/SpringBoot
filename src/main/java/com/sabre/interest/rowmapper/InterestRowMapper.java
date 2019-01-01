package com.sabre.interest.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sabre.interest.beans.InterestBean;

@Component
public class InterestRowMapper implements RowMapper<InterestBean>{
		
		@Override
		public InterestBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("mapRow-------------------------");
			InterestBean bean = new InterestBean();
			bean.setId(rs.getInt("id"));
			bean.setName(rs.getString("name"));
			bean.setAddress(rs.getString("address"));
			bean.setAmount(rs.getDouble("amount"));
			bean.setDatetime(convertSQLDateToJodaDate(rs.getDate("datetime")));
			bean.setAmount(rs.getDouble("rate"));
			return bean;
		}
		
		private String convertSQLDateToJodaDate(Date date) {
			if(date != null) {
				DateTime time = new DateTime(date.getTime());
				return time.toString();
			}
			return null;

		}
		
	}
