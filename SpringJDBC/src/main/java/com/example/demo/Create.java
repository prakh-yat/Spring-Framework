package com.example.demo;
import java.util.Map;
import java.util.List;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Create {
    @Autowired
    private JdbcTemplate jt;
    public void createTable(){
        var query = "CREATE TABLE student(id Serial PRIMARY KEY , name varchar(50) not null, city varchar(80))";
        int update = this.jt.update(query);
        System.out.println(update);
    }

    public void insertData(String name, String city){
        String q = "insert into student(name,city) values(?,?)";
        int update = this.jt.update(q,name,city);
        System.out.println(update + "row added");

    }

    public void updateData(String name, String city) {
        String q = " update student set name= ? where city=?";
        int h = this.jt.update(q, name, city);
        System.out.println(h + "row updated");
    }

    public Map<String, Object> readData(int id) {
    String q = "SELECT * FROM student WHERE id = ?";
    Map<String, Object> result = this.jt.queryForMap(q, id);
    return result;
    }

    public List<Map<String, Object>> readAll() {
        String q = "SELECT * FROM student";
        List<Map<String, Object>> rows = this.jt.queryForList(q);
        return rows;
    }
    public void deleteData(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        int h = this.jt.update(sql, id);
        System.out.println(h + "row deleted");
    }

}
