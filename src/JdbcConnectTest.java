import java.sql.*;

public class JdbcConnectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; //select 구문 전용 객체
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql1 = "select * from emp01";
//		String sql2= "insert into emp01"
//				+ " values(1118, '똥남이', 'SALES', 7788, sysdate, 1000, null, 30)";
//		String sql3 = "update emp01"
//				+ " set empno = 1818"
//				+ " where empno = 1111";
		String sql4 = "delete from emp01 where empno = 1818";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("연결성공");
			stmt = con.createStatement();
//			int result = stmt.executeUpdate(sql2);
//			int result = stmt.executeUpdate(sql3);
			int result = stmt.executeUpdate(sql4);
			if(result <= 0) {
				System.out.println("데이터 처리 실패");
			}else {
				System.out.println("데이터 처리 성공");
			}
			rs = stmt.executeQuery(sql1); //executuQuery() : select, excuteUpdate() : insert, update, delete
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				
				System.out.println(empno + " : " + ename+ " : " + job);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
