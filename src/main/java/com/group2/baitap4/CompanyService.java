package com.group2.baitap4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public Iterable<CompanyModel> getAll(){
        return companyRepository.findAll();
    }

    public CompanyModel getById(int id){
        return companyRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(CompanyModel company){
        companyRepository.save(company);
    }


    public void deleteCompany(int id){
        companyRepository.deleteById(id);
    }

}
