package com.ohgiraffers.employee;

import com.ohgiraffers.config.EmployeeDTO;

import java.util.List;

public interface Mapper {

    boolean login(EmployeeDTO employeeDTO);

    List<EmployeeDTO> searchByEmployee(String empId);

    List<EmployeeDTO> selectAll();

    int updateByEmployee(EmployeeDTO updatehashmap);

    int deleteByEmployee(String empId);

    int registByEmployee(EmployeeDTO empDTO);

    List<EmployeeDTO> thisYearKing();


}
