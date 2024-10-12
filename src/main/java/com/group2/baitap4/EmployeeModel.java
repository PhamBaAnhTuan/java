package com.group2.baitap4;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "Employee")
@Entity
public class EmployeeModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private List<CompanyModel> companies;

    // Getters and Setters
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

    public List<CompanyModel> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyModel> companies) {
        this.companies = companies;
    }
}
