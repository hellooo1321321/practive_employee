package com.ohgiraffers.employee;

import org.apache.ibatis.session.SqlSession;

import com.ohgiraffers.config.EmployeeDTO;

import java.util.HashMap;
import java.util.List;

import static com.ohgiraffers.config.Template.getSqlSession;

public class EmployeeService {

    private static Mapper mapper;

    public static boolean login(EmployeeDTO employeeDTO) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(Mapper.class);

        boolean result = mapper.login(employeeDTO);
        sqlSession.close();

        if(result){
            System.out.println("로그인에 성공하였습니다 !!");
        } else System.out.println("로그인 실패 !!");

        return result;
    }

    public static void searchByEmployee(String empId) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(Mapper.class);

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpId(empId);
        List<EmployeeDTO> employeeList = mapper.searchByEmployee(empId);

        System.out.println(employeeList);

        sqlSession.close();
    }

    public static void selectAll() {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(Mapper.class);

        List<EmployeeDTO> employeeList = mapper.selectAll();

        for (EmployeeDTO list : employeeList ){
            System.out.println(list);
        }

        sqlSession.close();
    }
    public static void thisYearKing() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(Mapper.class);
        List<EmployeeDTO> empList = mapper.thisYearKing();

        for(int i = 0; i < 3; i++){
            EmployeeDTO emp = empList.get(i);
            System.out.println((i + 1) + "위 이름 : " + emp.getEmpName() + " 급여 : " + emp.getSalary());
        }

        sqlSession.close();

    }

    public static int updateByEmployee(HashMap<String, String> updatehashmap) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(Mapper.class);
        String empName = updatehashmap.get("empName");
        String email = updatehashmap.get("email");
        String phone = updatehashmap.get("phone");
        int salary = Integer.parseInt(updatehashmap.get("salary"));


        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpName(empName);
        employeeDTO.setEmail(email);
        employeeDTO.setPhone(phone);
        employeeDTO.setSalary(salary);


        int result = mapper.updateByEmployee(employeeDTO);

        if(result == 1){
            System.out.println("수정성공 !");
            sqlSession.commit();
        } else{
            System.out.println("수정실패 !");
            sqlSession.rollback();
        }


        sqlSession.close();

        return result;
    }

    public static void deleteByEmployee(String empId) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(Mapper.class);

        int result = mapper.deleteByEmployee(empId);

        if ( result == 1){
            System.out.println("삭제 성공");
            sqlSession.commit();
        } else {
            System.out.println(" 삭제 실패");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public static void registByEmployee(EmployeeDTO empDTO) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(Mapper.class);


        int result = mapper.registByEmployee(empDTO);

        if (result == 1){
            System.out.println("회원가입 성공!!");
            sqlSession.commit();
        } else {
            System.out.println("회원가입 실패..");
            sqlSession.rollback();
        }

        sqlSession.close();
    }


}
