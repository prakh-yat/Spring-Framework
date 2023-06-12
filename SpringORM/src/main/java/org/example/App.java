package org.example;


import dao.StudentDao;
import entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext c = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = c.getBean("studentDao", StudentDao.class);
        System.out.print("Choose option number for action:\n1.Insert\n2.Read\n3.Update\n4.Delete");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Number of rows you wish to insert?");
                int row=sc.nextInt();
                for (int i = 0; i<row;i++){
                    int id = sc.nextInt();
                    String name = sc.next();
                    String address = sc.next();
                    String number = sc.next();
                    Student student = new Student(id,name,address,number);
                    int in = studentDao.insert(student);
                    System.out.println("done" + in);
                }
                break;
            case 2:
                System.out.println("How do you wish to see the data\n1.single\n2.multiple");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("No. of rows you wish to see?");
                        int show = sc.nextInt();
                        for (int i = 0; i<show;i++){
                            int id = sc.nextInt();
                            Student student = studentDao.getStudent(id);
                            System.out.println("Id:"+student.getId());
                            System.out.println("Name:"+student.getName());
                            System.out.println("Address:"+student.getAddress());
                            System.out.println("Number:"+student.getNumber());
                        }
                        break;
                    case 2:
                        List<Student> all = studentDao.getAll();
                        for(Student st : all){
                            System.out.println("Id:"+st.getId());
                            System.out.println("Name:"+st.getName());
                            System.out.println("Address:"+st.getAddress());
                            System.out.println("Number:"+st.getNumber());
                        }
                        break;

                }
                break;
            case 3:
                System.out.println("Number of rows you wish to update");
                int no = sc.nextInt();
                for(int i = 0;i<no;i++){
                    int id = sc.nextInt();
                    String name = sc.next();
                    String address = sc.next();
                    String number = sc.next();
                    Student student = new Student(id,name,address,number);
                    studentDao.update(student);
                }
                break;
            case 4:
                int del = sc.nextInt();
                studentDao.delete(del);
                System.out.println("Deleted row with id:"+del);
                break;

        }



    }
}
