package demo;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.*;

/**
 * @author lz
 * @data 2019-09-11
 * @comment 描述
 */
public class StudentManager {
        private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
        private static final String URL = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "123";

        static {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //int Type,String ID_Card,String Exam_Card,String Student_Name,String Location,int Grade
        public int addStu(Student student){
            String add_sql = "INSERT into examstudent (Type,ID_Card,Exam_Card,Student_Name,Location,Grade) value(?,?,?,?,?,?)";
//            try {
//                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//                PreparedStatement preparedStatement = connection.prepareStatement(add_sql);
//                preparedStatement.setInt(1,student.getType());
//                preparedStatement.setString(2,student.getID_Card());
//                preparedStatement.setString(3,student.getExam_Card());
//                preparedStatement.setString(4,student.getStudent_Name());
//                preparedStatement.setString(5,student.getLocation());
//                preparedStatement.setInt(6,student.getGrade());
//
//                int i = preparedStatement.executeUpdate();
//
//                preparedStatement.close();
//                connection.close();
//                return i;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }finally {
//            }
//            return 0;
            Object[] params = {
                    student.getType(),
                    student.getID_Card(),
                    student.getExam_Card(),
                    student.getStudent_Name(),
                    student.getLocation(),
                    student.getGrade(),
                    student.getFlow_ID()
            };

            return excuteUpdate(add_sql,params);
        }

        public int delete_ID(String ID_Card){
            String delete_sql = "DELETE FROM examstudent where ID_Card = ?";
//            try {
//                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//                PreparedStatement preparedStatement = connection.prepareStatement(delete_sql);
//                preparedStatement.setString(1,ID_Card);
//
//                int i = preparedStatement.executeUpdate();
//
//                preparedStatement.close();
//                connection.close();
//                return i;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return 0;
            return excuteUpdate(delete_sql,ID_Card);
        }

        public int delete_Exam(String Exam_Card){
            String delete_sql = "DELETE FROM examstudent where Exam_Card = ?";
//            try {
//                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//                PreparedStatement preparedStatement = connection.prepareStatement(delete_sql);
//                preparedStatement.setString(1,Exam_Card);
//
//                int i = preparedStatement.executeUpdate();
//
//                preparedStatement.close();
//                connection.close();
//                return i;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return 0;
            return excuteUpdate(delete_sql,Exam_Card);
        }

        public static int update(String ID_Card,String Student_Name){
            String update_sql = "UPDATE examstudent set Student_Name = ?  where ID_Card = ?";
            try {
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(update_sql);
                preparedStatement.setString(1,Student_Name);
                preparedStatement.setString(2,ID_Card);

                int i = preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
                return i;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }



        public static Student Query_ID(String ID_Card){
            String Query_sql = "SELECT * from examstudent where ID_Card = ?";
            try {
                Student student = new Student();
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(Query_sql);
                preparedStatement.setString(1,ID_Card);
                ResultSet resultSet = preparedStatement.executeQuery();

                    while(resultSet.next()){
                        int Flow_ID = resultSet.getInt(1);
                        int Type = resultSet.getInt(2);
                        String Exam_Card = resultSet.getString(4);
                        String Student_Name = resultSet.getString(5);
                        String Location = resultSet.getString(6);
                        int Grade = resultSet.getInt(7);
                        student.setFlow_ID(Flow_ID);
                        student.setType(Type);
                        student.setExam_Card(Exam_Card);
                        student.setStudent_Name(Student_Name);
                        student.setLocation(Location);
                        student.setGrade(Grade);
                        student.setID_Card(ID_Card);
                    }
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return student;
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {

            }
            return null;
        }

        public static Student Query_Exam(String Exam_Card){
            try {
                Student student = new Student();
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String Query_sql = "SELECT * from examstudent where Exam_Card = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(Query_sql);
                preparedStatement.setString(1,Exam_Card);
                ResultSet resultSet = preparedStatement.executeQuery();
                int Type = resultSet.getInt(2);
                String ID_Card = resultSet.getString(3);
                String Student_Name = resultSet.getString(5);
                String Location = resultSet.getString(6);
                int Grade = resultSet.getInt(7);
                student.setType(Type);
                student.setExam_Card(Exam_Card);
                student.setStudent_Name(Student_Name);
                student.setLocation(Location);
                student.setGrade(Grade);
                student.setID_Card(ID_Card);
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return student;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static List<Student> Query(){
            try {

                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String Query_sql = "SELECT * from examstudent";
                PreparedStatement preparedStatement = connection.prepareStatement(Query_sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                List list = new ArrayList();
                while (resultSet.next()){
                    //Map map = new HashMap();
                    Student student = new Student();
                    int Flow_ID = resultSet.getInt(1);
                    int Type = resultSet.getInt(2);
                    String ID_Card = resultSet.getString(3);
                    String Exam_Card = resultSet.getString(4);
                    String Student_Name = resultSet.getString(5);
                    String Location = resultSet.getString(6);
                    int Grade = resultSet.getInt(7);
//                    map.put("Type",Type);
//                    map.put("ID_Card",ID_Card);
//                    map.put("Exam_Card",Exam_Card);
//                    map.put("Student_Name",Student_Name);
//                    map.put("Location",Location);
//                    map.put("Grade",Grade);
                    student.setFlow_ID(Flow_ID);
                    student.setType(Type);
                    student.setExam_Card(Exam_Card);
                    student.setStudent_Name(Student_Name);
                    student.setLocation(Location);
                    student.setGrade(Grade);
                    student.setID_Card(ID_Card);
                    list.add(student);
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return list;
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {

            }
            return null;
        }

        public void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultset){
            try {
                if(resultset != null) {resultset.close();}
                if(preparedStatement != null) {preparedStatement.close();}
                if(connection != null){connection.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Connection  getConnection(){
            try {
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    public int excuteUpdate(String sql,Object...params){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if(params != null){
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1 ,params[i]);
                }
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,preparedStatement,null);
        }
        return 0;
    }
}
