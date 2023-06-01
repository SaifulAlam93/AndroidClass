package com.example.myapplication1.entity;

public class Employee {

    private Integer id;
    private String name;
    private String email;
    private String address;
    private String dep;
    private Integer salary;

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
