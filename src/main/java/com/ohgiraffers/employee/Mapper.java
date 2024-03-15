package com.ohgiraffers.employee;

import com.ohgiraffers.config.EmployeeDTO;

import java.util.HashMap;
import java.util.List;

public interface Mapper {

    boolean login(EmployeeDTO employeeDTO);

    List<EmployeeDTO> searchByEmployee(String empId);

    List<EmployeeDTO> selectAll();

    int updateByEmployee(HashMap<String, String> updatehashmap);
}
