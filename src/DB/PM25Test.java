package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 
public class PM25Test
{
    public static void main(String args[])
    {
        Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        //StringBuffer strSqlQuery = new StringBuffer(); //StringBuffer 객체
        //strSqlQuery.append("SELECT * \n");
        //strSqlQuery.append("from realtimePm25" + "\n");
        //strSqlQuery.append("where col1 = '?' and col2 = '?' ");
        
        try {
            // SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
            // 그 결과를 담을 ResulSet 객체를 준비한 후 실행시킨다.
            String quary = "SELECT 지역, 수치 FROM realtimePm25 where 수치 < 30";
            
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(quary);
            rs = pstm.executeQuery();
           
            
            System.out.println("조건에 맞는 지역 출력");
            System.out.println("============================================");
            
            while(rs.next()){
            	String 시간 = rs.getString(1);
                //int empno = rs.getInt("empno"); 숫자 대신 컬럼 이름을 적어도 된다.
                String 지역 = rs.getString(2);
                int 수치 = rs.getInt(3);

                String result = 시간+" "+지역+" "+수치;
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            System.out.println("SELECT문에서 예외 발생");
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
    }
}
