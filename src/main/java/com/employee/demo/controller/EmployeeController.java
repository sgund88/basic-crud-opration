package com.employee.demo.controller;

import com.employee.demo.model.Employee;
import com.employee.demo.model.User;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/employees")
    public Page<Employee> getAllEmployees(Pageable pageable) {
//        for(int i = 1;i<=100;i++){
//            employeeRepository.save(new Employee(i,"test Name"+i,"i@google.co.in","1234567890","00/00/0000","19","150"));
//        }
        return employeeRepository.findAll(pageable);
    }

    @GetMapping("/user/login")
    public User getUserLogin(@RequestParam(value="email", required=true) String email,
                                   @RequestParam(value="password", required=true) String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @PostMapping("/user")
    public User addUser(@RequestParam(value="name", required=true) String name,
                        @RequestParam(value="email", required=true) String email,
                        @RequestParam(value="password", required=true) String password){
        Long id = Long.valueOf(userRepository.findAll().size() + 1);
        return userRepository.save(new User(id,name,email,password));
    }

    @PostMapping("/user/update")
    public User updateUser(@RequestParam(value="id", required=true) Long id,
                           @RequestParam(value="name", required=true) String name,
                           @RequestParam(value="email", required=true) String email,
                           @RequestParam(value="password", required=true) String password){
        Optional<User> user = userRepository.findById(id);
        user.get().setName(name);
        user.get().setEmail(email);
        user.get().setPassword(password);
        if(user.get().getId() != 0){
            return userRepository.save(user.get());
        }
        return null;
    }
}