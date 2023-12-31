package com.anujmehla.captcha.controller;

import cn.apiclub.captcha.Captcha;
import com.anujmehla.captcha.model.Employee;
import com.anujmehla.captcha.util.CaptchaUtil;
import com.anujmehla.captcha.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
//@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private void setupCaptcha(Employee e) {
        System.out.println("START : SetupCaptcha() : EmployeeController");
//        Captcha captcha = CaptchaUtil.createCaptcha(250, 80);
//        String captchaAnswer = captcha.getAnswer();
//        e.setHidden(captchaAnswer);
//        e.setCaptcha(""); // Clear the captcha field before setting the new value
//        e.setCaptcha(captchaAnswer); // Set captcha to the new value
//        System.out.println("Answer is " + captchaAnswer);
//        System.out.println("Employee Captcha: " + e.getCaptcha());
//        System.out.println("Employee Hidden: " + e.getHidden());
//        e.setImage(CaptchaUtil.encodeBase64(captcha));
//************************************************************some changes
//        Captcha captcha = CaptchaUtil.createCaptcha(250, 80);
//        String captchaAnswer = captcha.getAnswer();
//        e.setHidden(captchaAnswer);
//        e.setCaptcha(captchaAnswer); // Set captcha to the new value
//        System.out.println("Answer is " + captchaAnswer);
//        System.out.println("Employee Captcha: " + e.getCaptcha());
//        System.out.println("Employee Hidden: " + e.getHidden());
//        e.setImage(CaptchaUtil.encodeBase64(captcha));
//        ****************************************base code
        Captcha captcha = CaptchaUtil.createCaptcha(250,80);
        e.setHidden(captcha.getAnswer());
        e.setCaptcha(""); //user  entered value
        e.setImage(CaptchaUtil.encodeBase64(captcha));
        System.out.println("END   : SetupCaptcha() : EmployeeController");
//        return captcha.getAnswer();
    }

    @Autowired
    private EmployeeService service;

    @GetMapping("/register")
    public String showReg(Model model) {
        System.out.println("START : showReq() : EmployeeController");

        Employee e = new Employee();
        setupCaptcha(e);
        model.addAttribute("employee",e);

        System.out.println("END   : showReq() : EmployeeController");
        return "EmployeeRegister";
//        return captchaValue;
    }

    String json = "{\"name\":\"John\",\"salary\":30,\"captcha\":\"1\",\"hidden\":\"1\"}";
    ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee, Model model) throws IOException {
//        employee = objectMapper.readValue(json,Employee.class);

        System.out.println(employee.getHidden());
        System.out.println(employee.getName());

        //save
        System.out.println("START : save() : EmployeeController");
        String enteredCaptcha = employee.getCaptcha();
        String real = "";
        if (enteredCaptcha.contains(",")) {
            real = enteredCaptcha.substring(2);
        }

        System.out.println("Employee Captcha "+real);
        System.out.println("Employee Hidden "+employee.getHidden());
        if (real.equals(employee.getHidden())) {
            System.out.println("***************Inside if captcha matched");

            service.createEmployee(employee);
            model.addAttribute("message","Employee Created");

            return "redirect:all";
        } else {
            System.out.println("***************Inside else Captcha didn't match");
            model.addAttribute("message","Invalid Captcha");
            setupCaptcha(employee);
            model.addAttribute("employee",employee);
        }

        System.out.println("END  : save() : EmployeeController");
        return "EmployeeRegister";
    }

    //display all employees
    @GetMapping("/all")
    public String showAll(Model model) {
        System.out.println("START : showAll() : EmployeeController");

        List<Employee> list = service.getAllEmployees();
        model.addAttribute("list",list);

        System.out.println("END  : showAll() : EmployeeController");
        return "EmployeeData";
    }

}
