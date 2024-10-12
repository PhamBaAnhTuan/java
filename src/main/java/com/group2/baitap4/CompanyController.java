package com.group2.baitap4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/companies")
    public String listCompany(Model model) {
        List<CompanyModel> companies = (List<CompanyModel>) companyService.getAll();
        System.out.println("companies: " + companies);

        model.addAttribute("companies", companies);
        return "companies";
    }

    @GetMapping("/companyAdd")
    public String addCompany(Model model) {
        CompanyModel company = new CompanyModel();
        model.addAttribute("company", company);

        return "companyAdd";
    }

    @PostMapping("/companyAdd")
    public String saveOrUpdate(@ModelAttribute("company") CompanyModel company) {
        List<EmployeeModel> employee = (List<EmployeeModel>) employeeService.getAll();
        company.setEmployee(employee);
        companyService.saveOrUpdate(company);

        return "redirect:/companies";
    }


    @GetMapping("company/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        CompanyModel company = companyService.getById(id);

        model.addAttribute("company", company);
        return "companyUpdate";
    }

    @PostMapping("/company/update/{id}")
    public String updateCompanyForm(@PathVariable("id") int id, @ModelAttribute("company") CompanyModel company, CompanyModel model) {
        company.setId(id);
        companyService.saveOrUpdate(company);
        System.out.println("Updated company!");
        return "redirect:/companies";
    }

    @PostMapping("company/delete/{id}")
    public String deleteCompany(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
        System.out.println("Deleted company!");
        return "redirect:/companies";
    }
}
