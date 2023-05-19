package com.wappalik.Zadacha_3_1_2.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name = "name")
    @NotBlank(message = "should not be empty")
    @Size(min = 2, message = "min 2 symbols")
    @Pattern(regexp = "[^\\d]+", message = "should not be a number")
    @Pattern(regexp = "\\p{L}+", message = "should not be symbol")
    private String name;

    @Column (name = "department")
    @NotBlank(message = "should not be empty")
    private String department;

    @Column (name = "age")
    @Min(value = 18, message = "min is 18")
    @Max(value = 60, message = "max is 60")
    private long age;

    @Column (name = "salary")
    @Min (value = 500, message = "min salary is begin from 500")
    private long salary;

    public User() {
    }

    public User(String name, String department, long age, long salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && salary == user.salary && Objects.equals(name, user.name) && Objects.equals(department, user.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, age, salary);
    }
}
