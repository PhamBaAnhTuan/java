package com.group2.baitap4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    public Iterable<EmployeeModel> getAll(){
        return employeeRepository.findAll();
    }

    public EmployeeModel getById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(EmployeeModel company){
        employeeRepository.save(company);
    }


    public void deleteCompany(int id){
        employeeRepository.deleteById(id);
    }

}
