package com.ohgiraffers.employee;

import com.ohgiraffers.config.EmployeeDTO;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        int num = 1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========== 로그인 하시겠습니까 ? ==========");
            System.out.println("1. 로그인하기");
            System.out.println("2. 회원가입 하기");
            System.out.println("9. 시스템 종료");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    if(EmployeeService.login(inputNameAndNo())== true) {
                        LoginSuccess.gogocase();
                    }else {
                        System.out.println("로그인 실패했습니다.. 다시 입력하세요 !");
                        System.out.println("시도 횟수 : " + num);
                        num++;
                        if(num == 6) return;
                    }
                    break;
                case 2 : EmployeeService.registByEmployee(registSet()); break;
                case 9:
                    System.out.println("시스템을 종료합니다..");
                    return;
            }

        }
    }

    private static EmployeeDTO registSet() {

        Scanner sc = new Scanner(System.in);
        System.out.print("사원번호를 입력하세요 : ");
        String empId = sc.nextLine();
        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("주민등록번호를 입력해주세요 (ex.123456-1234567) :");
        String empNo = sc.nextLine();
        System.out.print("휴대폰 번호 입력해주세요 : ( -없이 ) : ");
        String phone = sc.nextLine();
        System.out.print("입사일을 입력해주세요 (ex. 2000-00-00 ) : ");
        String date = sc.nextLine();
        System.out.print("직업 코드 입력해주세요 : ");
        String jobCode = sc.nextLine();
        System.out.print("급여 등급을 입력해주세요 : ");
        String salLevel = sc.nextLine();


        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpId(empId);
        employeeDTO.setEmpName(name);
        employeeDTO.setEmpNo(empNo);
        employeeDTO.setPhone(phone);
        employeeDTO.setHireDate(Date.valueOf(date));
        employeeDTO.setJobCode(jobCode);
        employeeDTO.setSalLevel(salLevel);

        return employeeDTO;
    }

    private static EmployeeDTO inputNameAndNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 이름을 입력해 주세요: ");
        String empName = sc.nextLine();
        System.out.print("주민등록번호를 입력해주세요 (ex.123456-1234567) : ");
        String empNo = sc.nextLine();

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpName(empName);
        employeeDTO.setEmpNo(empNo);

        return employeeDTO;
    }


}
