package main.java.이론;

/*
* ===JDBC 환경설정===
*
* 1. 필요한 준비물
*   1) JDK (java - JDK 17)
*   2) IDE(intelliJ, Eclipse 등)
*   3) MySQL (MySQL Sercer 8.x 이상 권장)
*   4) JDBC 드라이버
*       :MySQL-connector-java-x.x.xx.jar
*   +) SQL 스키마, java 프로젝트
*
* */

// JDBC 연결 시 자주 발생하는 오류 및 해결법
// 1.ClassNotFoundException
// 외부 라이브러리 (sql connection가 프로젝트에 추가되지 않음

// 2.Access denide for user
// : DB 사용자 ID/PW 오타 또는 권한 없음

// 3. Communications link failure
// : MySQL 서버가 실행 중인지 확인 (포트번호 3306)

// 4. unknown database
// : DB 이름 오타 또는 미생성

public class Jdbc02 {
}
