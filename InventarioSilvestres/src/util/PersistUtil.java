package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PersistUtil {

	private static DataSource dataSource;
	private static final String DATE_PATTERN ="yyyy/MM/dd HH:mm:ss";
	
	public static DataSource getDataSource(){  	
    	try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/SilvestrespgDS");
		} catch (Exception e) {
			e.toString();
		}
    	return dataSource;
    }

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void closeResources(PreparedStatement instruccion, ResultSet resultado) throws Exception{
		instruccion.close();
		resultado.close();
		
	}

	public static void closeResources(PreparedStatement instruccion) throws Exception {
		instruccion.close();
	}
	
//	public String formatDate(String date) {
//		SimpleDateFormat formatFrom = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		java.util.Date tempDate = formatFrom.parse(date);
//		SimpleDateFormat formatTo = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		return formatTo.format(tempDate);
//	}
//	
	 
	public static java.sql.Timestamp convertStringToDate(String dateString){
	    Date date = null;
	    java.sql.Timestamp sqlDate;
	    try {
	        DateFormat format = new SimpleDateFormat(DATE_PATTERN, Locale.ENGLISH);
	        date = format.parse(dateString);
	    }catch (Exception e){
	        e.toString();
	    }
	    sqlDate = new java.sql.Timestamp(date.getTime());
	    return sqlDate;
	}
	
	public static java.sql.Timestamp date(){
		java.util.Date fecha = new Date();
		java.sql.Timestamp sqlDate;
		sqlDate = new java.sql.Timestamp(fecha.getTime());
		return sqlDate;
	}
}