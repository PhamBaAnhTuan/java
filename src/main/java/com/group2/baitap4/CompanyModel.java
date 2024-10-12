package com.group2.baitap4;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "Company")
@Entity
public class CompanyModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "company_employee",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<EmployeeModel> employee;

    public List<EmployeeModel> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeModel> employee) {
        this.employee = employee;
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
}
