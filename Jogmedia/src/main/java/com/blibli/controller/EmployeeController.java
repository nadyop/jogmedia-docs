package com.blibli.controller;

import com.blibli.model.Employee;
import com.blibli.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeService;

    @RequestMapping("/tampilemp")
    public String EmployeeList(Model model){
        model.addAttribute("employee",employeeService.showAllEmployee());
        return "tampilemp";
    }
    @RequestMapping(value = "/tampilemp/", method = RequestMethod.POST)
    public String simpanDataEmployee(Employee employee){
        employeeService.save(employee);
        return "redirect:/tampilemp";
    }
    @RequestMapping(value = "/tampilemp/search", method = RequestMethod.POST)
    public String search(Model model, @ModelAttribute("searchKey") String searchKey){
        model.addAttribute("employee", employeeService.search(searchKey));
        return "tampilemp";
    }

    @RequestMapping(value = "/tampilemp/createEmployee", method = RequestMethod.GET)
    public String tampilFormCreateEmployee(Model model)
    {
        model.addAttribute("employee",new Employee());
        return "createEmployee";
    }
    @RequestMapping(value = "/tampilemp/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("employee",employeeService.getIdEmployee(id));
        return "createEmployee";
    }
    @RequestMapping(value = "/tampilemp/hapus/{id}", method = RequestMethod.GET)
    public String hapusData(@PathVariable Integer id,Model model) {
        employeeService.deleteEmployee(id);
        return "redirect:/tampilemp";
    }
    @RequestMapping(value = "/employee/softDelete/{id}", method = RequestMethod.GET)
    public String softDeleteEmployee(@PathVariable Integer id) {
        employeeService.softDeleteEmployee(id);
        return "redirect:/tampilemp";
    }
}
