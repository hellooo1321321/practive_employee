package com.ohgiraffers.employee;

import com.ohgiraffers.config.EmployeeDTO;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========== 로그인 하시겠습니까 ? ==========");
            System.out.println("1. 로그인하기");
            System.out.println("9. 시스템 종료");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    if(EmployeeService.login(inputNameAndNo())== true) {
                        LoginSuccess.gogocase();
                    }else {
                        System.out.println("로그인 실패했습니다.. 시스템 종료");
                        return;
                    }
                    break;
                case 9:
                    System.out.println("시스템을 종료합니다..");
                    return;
            }

        }
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
