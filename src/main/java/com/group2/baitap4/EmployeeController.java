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
public class EmployeeController {

    @Autowired
    CompanyService companyService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employeeAdd")
    public String addEmployee(Model model) {
        EmployeeModel employee = new EmployeeModel();
        model.addAttribute("employee", employee);

        return "employeeAdd";
    }

//    @PostMapping("/employeeAdd")
//    public String saveOrUpdate(@ModelAttribute("employee") EmployeeModel employee) {
//        List<CompanyModel> company = (List<CompanyModel>) companyService.getAll();
//        company.setCompany(employee);
//        companyService.saveOrUpdate(employee);
//
//        return "redirect:/companies";
//    }

    @GetMapping("/companies")
    public String detailPage(Model model) {
        List<CompanyModel> companies = (List<CompanyModel>) companyService.getAll();
        System.out.println("companies: " + companies);

        model.addAttribute("companies", companies);
        return "companies";
    }

//    Update employee
    @GetMapping("employee/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        EmployeeModel employee = employeeService.getById(id);

        model.addAttribute("employee", employee);
        return "employeeUpdate";
    }

    @PostMapping("/employee/update/{id}")
    public String updateCompanyForm(@PathVariable("id") int id, @ModelAttribute("employee") EmployeeModel employee, EmployeeModel employee) {
        employee.setId(id);
        employeeService.saveOrUpdate(employee);
        System.out.println("Updated employee!");
        return "redirect:/companies";
    }

    @PostMapping("employee/delete/{id}")
    public String deleteCompany(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        System.out.println("Deleted employee!");
        return "redirect:/companies";
    }
}
