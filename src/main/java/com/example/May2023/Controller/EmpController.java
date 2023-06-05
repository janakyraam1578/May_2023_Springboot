package com.example.May2023.Controller;

import com.example.May2023.Model.Emp;
import com.example.May2023.Service.EmpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    private static Logger log= LoggerFactory.getLogger(EmpController.class);

    @Autowired
    EmpService eService;

    @GetMapping("/all")
    @Operation(description= "THIS IS RETRIEVING THE EMPLOYEE DETAILS BASED ON EMPNO PROVIDED")
    @ApiResponse(responseCode = "200", description = "THIS IS SUCCESSFUL RESPONSE")
    @ApiResponse(responseCode = "400", description = "THIS RESPONSE INDICATES SOME WRONG INPUT BEING PROVIDED")
    public List<Emp> getAllEmpDetails(){
        return eService.getAllEmpDetails();
    }

    @GetMapping("/get/{empno}")
    public ResponseEntity<Object> getEmpDetailsByEmpID(
            @PathVariable("empno") Integer empno
            ){
        Emp emp=eService.getEmpDetailsByEmpNo(empno);
        if (emp.getEmpno() == null){
            log.error("Employee doesn't exist");
            return new ResponseEntity<>("Employee doesn't exist", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

   /* @GetMapping("/get/name/{ename}")
    public List<Emp> getEmpDetailsByEmpName(
            @PathVariable("ename") String ename
    ){
        return eService.getAllEmpDetailsByName(ename);
    }*/

      @GetMapping("/get/job/{job}")
    public List<Emp> getEmpDetailsByEmpJob(
            @PathVariable("job") String job
    ){
        return eService.getAllEmpDetailsByJob(job);
    }

    @PostMapping("/add")
    public void addEmp(@RequestBody Emp emp) throws JsonProcessingException {
          eService.upsert(emp);
    }

    @PutMapping("/update")
    public void updateEmp(@RequestBody Emp emp) throws JsonProcessingException {
        eService.upsert(emp);
    }

    @DeleteMapping("/delete/{empno}")
    public void deleteEmp(@PathVariable("empno") Integer empno){
         eService.deleteEmp(empno);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handlefileupload(
            @RequestParam("file") MultipartFile file
    ){
          try {
              eService.readFileContents(file.getInputStream());
          } catch (Exception e){
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
          }
          return ResponseEntity.ok("File uploaded successfully");
    }

    @GetMapping(path = "/download")
    public void getAllEmployeesInCSV(HttpServletResponse servletResponse) throws IOException {
          servletResponse.setContentType("text/csv");
          servletResponse.addHeader("Content-Disposition", "attachment; filename=\"employees.csv\"");
          eService.writeEmployeeToCSV(servletResponse.getWriter());
    }
}
