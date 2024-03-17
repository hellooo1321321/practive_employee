package com.ohgiraffers.employee;

import java.util.HashMap;
import java.util.Scanner;

public class LoginSuccess {

    public static void gogocase() {
        System.out.println("회원관리에 오신걸 환영합니다!!!!!!!!");
        do {
            System.out.println("========== 회원 관리 메뉴 ==========");
            System.out.println("1. 개인정보 전체 조회 ");
            System.out.println("2. 개인정보 조회 (emp_id) 입력");
            System.out.println("3. 개인정보 수정 (emp_name) 입력");
            System.out.println("4. 퇴사하시겠습니까?? (emp_id) 입력");
            System.out.println("5. 올해의 연봉왕 Top3 조회");
            System.out.println("9. 로그아웃..");
            Scanner sc = new Scanner(System.in);
            int no = sc.nextInt();
            switch (no) {
                case 1 : EmployeeService.selectAll(); break;
                case 2 : EmployeeService.searchByEmployee(inputId()); break;
                case 3 : EmployeeService.updateByEmployee(inputUpdate()); break;
                case 4 : EmployeeService.deleteByEmployee(inputId()); break;
                case 5 : EmployeeService.thisYearKing();
                case 9 : return;
            }

        }while (true);
    }

    private static HashMap<String,String> inputUpdate() {
        //name,e-mail,phone,급여 수정
        Scanner sc = new Scanner(System.in);
        System.out.print("사원이름을 입력해 주세요 : ");
        String empName = sc.nextLine();
        System.out.print("수정할 e-mail 을 입력해주세요 :  ");
        String email = sc.nextLine();
        System.out.print("수정할 휴대폰 번호를 입력해주세요 (- 쓰지마세요) : ");
        String phone = sc.nextLine();
        System.out.print("수정할 급여를 입력해주세요 : ");
        String salary = sc.nextLine();

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("empName",empName);
        hashMap.put("email",email);
        hashMap.put("phone",phone);
        hashMap.put("salary",salary);

        return hashMap;
    }

    private static String inputId() {

        Scanner sc = new Scanner(System.in);
        System.out.print("회원 아이디를 입력해주세요 : ");
        String id = sc.nextLine();

        return id;
    }
}
