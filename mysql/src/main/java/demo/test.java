package demo;

import java.util.List;
import java.util.Scanner;

/**
 * @author lz
 * @data 2019-09-11
 * @comment 描述
 */
public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choose;
        do {
            System.out.println("-----------欢迎使用四六级查询系统！----------");
            System.out.println("1.增加学生信息\n2.删除学生信息\n3.修改学生信息\n4.查询学生信息\n5. 查询所有学生信息\n6.退出");
            choose = input.nextInt();
            switch (choose){
                case 1:
                    Student student = new Student();
                    System.out.println("请输入四级或者六级");
                    student.setType(input.nextInt());
                    System.out.println("请输入学生身份证号：");
                    student.setID_Card(input.next());
                    System.out.println("请输入学生准考生号:");
                    student.setExam_Card(input.next());
                    System.out.println("请输入学生姓名：");
                    student.setStudent_Name(input.next());
                    System.out.println("请输入学生住址：");
                    student.setLocation(input.next());
                    System.out.println("请输入学生成绩:");
                    student.setGrade(input.nextInt());
                    int i = StudentManager.addStu(student);
                    System.out.println(i>0 ?"添加成功":"添加失败");
                    break;
                case 2:
                    System.out.println("-----1.按身份证删除 2.按准考证号删除--------");
                    int choose1 = input.nextInt();
                    switch (choose1){
                        case 1:
                            System.out.println("请输入学生的身份证号码:");
                            System.out.println(StudentManager.delete_ID(input.next()) > 0 ? "删除成功！":"删除失败！");
                            break;
                        case 2:
                            System.out.println("请输入学生的准考证号：");
                            System.out.println(StudentManager.delete_Exam(input.next()) > 0 ? "删除成功！":"删除成功！");
                            break;
                        default:
                            System.out.println("请输入正确的指令！");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("请输入学生的身份证号码：");
                    String id_card = input.next();
                    System.out.println("请输入更改的姓名：");
                    String name = input.next();
                    System.out.println(StudentManager.update(id_card,name) > 0 ?"修改成功！":"修改失败！");
                    break;
                case 4:
                    System.out.println("-----1.按身份证查询 2.按准考证号查询--------");
                    int choose2 = input.nextInt();
                    switch (choose2){
                        case 1:
                            System.out.println("请输入身份证号码：");
                            System.out.println(StudentManager.Query_ID(input.next()));
                            break;
                        case 2:
                            System.out.println("请输入准考证号：");
                            System.out.println(StudentManager.Query_ID(input.next()));
                            break;
                        default:
                            System.out.println("请输入正确的指令！");
                            break;
                    }
                    break;
                case 5:
                    List<Student> students = StudentManager.Query();
                    for (Student student1 : students) {
                        System.out.println(student1);
                    }
                    break;
                case 6:
                    System.out.println("谢谢使用！");
                    break;
                default:
                    System.out.println("请输入正确的指令！");
                    break;
            }
        }while (choose != 6);
        }
}
