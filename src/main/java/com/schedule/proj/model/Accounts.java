package com.schedule.proj.model;


import javax.persistence.*;

@Entity
//@Table(name="Accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accounts_id")
    private int accountsId;

//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "user_id")
//    @MapsId
//    private User user;

    @OneToOne(mappedBy = "accounts", cascade = CascadeType.PERSIST)
    private Teacher teacher;

    @OneToOne(mappedBy = "accounts", cascade = CascadeType.REFRESH)
    private Student student;

    public Accounts() {
    }

//    public Accounts(User user) {
//        this.user = user;
//    }

    public Accounts(Teacher teacher) {
        this.teacher = teacher;
    }

    public Accounts(Student student) {
        this.student = student;
    }

    public int getAccountsId() {
        return accountsId;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}