package dao;

import entity.Student;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;
    @Transactional
    public int insert (Student student){
        Student i = this.hibernateTemplate.save(student);
        return i;
    }

    public Student getStudent(int id){
        Student student = this.hibernateTemplate.load(Student.class, id);
        return student;
    }

    public List<Student> getAll(){
        List<Student> student = this.hibernateTemplate.loadAll(Student.class);
        return student;
    }
    @Transactional
    public void delete(int id){
        Student student = this.hibernateTemplate.load(Student.class,id);
        this.hibernateTemplate.delete(student);
    }
    @Transactional
    public void update(Student student){
        this.hibernateTemplate.update(student);
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
