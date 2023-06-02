package com.example.May2023.Service;

import com.example.May2023.Model.Emp;
import com.example.May2023.Repository.EmpRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.time.LocalDate;
import java.util.*;

@Service
public class EmpService {

    @Autowired
    EmpRepository eRepo;
    public List<Emp> getAllEmpDetails(){
        return eRepo.findAll(); //select * from emp;
    }

    public Emp getEmpDetailsByEmpNo(Integer empno){
        Optional<Emp> opemp=eRepo.findById(empno);
        if (opemp.isPresent()){
            return opemp.get();
        }
        else
        return new Emp();
    }

   /* public List<Emp> getAllEmpDetailsByName(String ename){
        return eRepo.findByName(ename); //select * from emp where empname=?
    }*/

    public List<Emp> getAllEmpDetailsByJob(String job){
        return eRepo.findByJob(job); //select * from emp where job=?

    }

    public void upsert(Emp emp){ //Update or Insert
        eRepo.save(emp); //insert into emp values(????)
        //if the record is present, it will perform update operation
        //if the record is NOT present, it will perform insertion
    }

    public void deleteEmp(Integer empno){
        eRepo.deleteById(empno); //delete
    }

    public void readFileContents(InputStream inputStream) throws Exception{
        CSVParser parser=new CSVParser(new InputStreamReader(inputStream), CSVFormat.DEFAULT);

        List<CSVRecord> records=parser.getRecords();
        Random randomEmpNumbers=new Random();
        List<Emp> empList=new ArrayList<>();

        for (CSVRecord record : records){
            Emp emp=new Emp();
            emp.setEmpno(randomEmpNumbers.nextInt(400));
            emp.setEname(record.get(0));
            emp.setJob(record.get(1));
            //emp.setCreatedBy("File Upload");
            //emp.setCreatedDate(Date.valueOf(LocalDate.now()));

            empList.add(emp);
        }
        eRepo.saveAll(empList);
    }

    public void writeEmployeeToCSV(Writer writer){
        List<Emp> employees=eRepo.findAll();
        try(CSVPrinter csvPrinter=new CSVPrinter(writer, CSVFormat.DEFAULT)){
            csvPrinter.printRecord("EMPNO", "ENAME", "JOB");
            for (Emp emp : employees){ //Enhanced for loop
                csvPrinter.printRecord(emp.getEmpno(),
                        emp.getEname(),
                        emp.getJob());
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION RAISED");
        }
    }
}
