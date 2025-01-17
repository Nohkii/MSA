package jpamvcexam.controller;
import jpamvcexam.model.dao.StudentDAO;
import jpamvcexam.model.dto.Student;
import java.util.List;
public class StudentController {
    private StudentDAO dao;
    public StudentController(){
        dao = new StudentDAO();
    }
    public void printAll() {
        List<Student> list = dao.getAllStudent();
        System.out.println("학생이름  점수");
        System.out.println("===========");
        for(Student vo : list) {
            System.out.print(vo.getName()+"\t");
            System.out.print(vo.getScore()+"\n");
        }
    }
    public void printScore(String name) {
        List<Student> list = dao.getScore(name);
        if (list.size() == 0)
            System.out.println(name + "학생은 존재하지 않습니다.");
        else
            for(Student vo : list) {
                System.out.print("학생의 점수는 "+vo.getScore()+"입니다.%n");
            }
    }
    public void insert(String name, int score) {
        Student vo = new Student();
        vo.setName(name);
        vo.setScore(score);
        System.out.println(vo);
        boolean result = dao.insertStudent(vo);
        if (result)
            System.out.println("입력 성공");
        else
            System.out.println("입력 실패");
    }
    public boolean oneStudent(String name, boolean output) {
        Student vo = dao.one(name);
        boolean result = false;
        if(vo != null ) {
            result = true;
            if(output) {
                System.out.print(vo.getName()+"\t");
            }
        }
        return result;
    }
    public void update(String name, int score) {
        Student vo = new Student();
        vo.setName(name);
        vo.setScore(score);
        boolean result = dao.updateStudent(vo);
        if (result)
            System.out.println(name +"학생의 점수를 변경했습니다.");
        else
            System.out.println(name +"학생은 존재하지 않습니다.");
    }
    public void delete(String name) {
        boolean result = dao.deleteStudent(name);
        if (result)
            System.out.println(name +"학생의 데이터를 삭제했습니다.");
        else
            System.out.println(name +"학생은 존재하지 않습니다.");
    }
    public void close() {
        dao.close();
    }
}