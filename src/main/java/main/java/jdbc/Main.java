package main.java.jdbc;

import java.sql.*;

// === JDBC 연결 흐름 ===
/*
 * 1. JDBC 드라이버 로딩
 * 2. DB 접속 정보 설정(URL, 사용자명, 비밀번호)
 * 3. DriverManager를 통해 DB연결을 시도
 * 4. Connection 객체를 통해 DB작업 수행
 * 5. 연결 종료
 * */
public class Main {
    public static void main(String[] args) {
        // === 1. DB 접속 정보 ===
        // jdbc:mysql://localhost:3306/jdbc_db
        // - jdbc 프로토콜: 사용하는 DBMS://서버주소:포트번호(mysql 기본 3306)/DB이름
        final String URL = "jdbc:mysql://localhost:3306/jdbc_db";
        String user = "root";
        String password = "root"; // ?본인의 비밀번호로 변경

        Connection conn = null;// db 연결객체
        Statement stmt = null;// db 실행 객체
        PreparedStatement pstmt = null; // 동적 db 실행 객체
        ResultSet rs = null;// db 결과 객체


        try{
            // 1. 드라이버 로딩
            // : JDBC 드라이버 클래스를 메모리에 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. DB 연결
            // : 실제로 MySQL DB 접속 시도 (성공 시 Connection 객체를 반환)
            conn = DriverManager.getConnection(URL, user, password);
            System.out.println("DB연결 성공");

//            // === DB 전체 데이터 조회(READ)
//            String sql = "SELECT * FROM member";
//            stmt = conn.createStatement();// statement 사용
//            rs = stmt.executeQuery(sql);// select 실행
//
//            while (rs.next()){
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                System.out.println(id + " | " + name + " | " + email);
//            }
//            // === DB 데이터 삽입(Create) ===
//            String sql = "INSERT INTO member (name,email) VALUES (?, ?)";
//            pstmt = conn.prepareStatement(sql);//preparedstatemnet 사용
//
//            pstmt.setString(1, "김명진");
//            pstmt.setString(2, "dfg000");
//
//            int result = pstmt.executeUpdate();// insert 실행
//            System.out.println(result + "명 회원 추가됨");

//            // === db 데이터 수정(update)
//            String sql = "UPDATE member SET email = ? where id = ?";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,"newemail.com");
//            pstmt.setInt(2, 1);
//
//            int updated = pstmt.executeUpdate();
//            System.out.println(updated + "명 수정됨");


            // === DB 데이터 삭제 ===
            String sql = "DELETE FROM member Where id =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);// parameterIndex: 1부터 시작
            int deleted = pstmt.executeUpdate();
            System.out.println(deleted + "명 삭제됨");



            // 3. 연결 종료
            // conn.close();



        }catch (Exception e){
            System.out.println("DB연결 실패");
            e.printStackTrace();
        }
        // 자바 7버젼 이상 부터는 자동 자원 해제로 생략 가능
//        finally{
//            // 연결 종료
//            try{
//                if(conn != null && stmt != null && rs != null){
//                    // DB Connetion 이 존재하면 - 자원 누수를 막기 위해 자원 해제를 호출
//                    conn.close();
//                    stmt.close();
//                    rs.close();
//                    System.out.println("DB 연결 종료");
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }
    }
}