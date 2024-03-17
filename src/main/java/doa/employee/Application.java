package doa.employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();


        do {
            System.out.println("======== 회원관리 ==========");
            System.out.println(" 회원가입 or 로그인을 진행해 주세요 ");
            System.out.println("1. 회원가입 ");
            System.out.println("2. 로그인 ");
            System.out.println("9. 로그아웃 되었습니다. ");
            System.out.print("번호를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: EmployeeController.regist(inputRegist()); break;
                case 2: break;
                case 9: return;
            }
        } while (true);


    }

    private static Map<String, String> inputRegist() {

        Scanner sc = new Scanner(System.in);
        System.out.println("회원가입을 진행 합니다.");

        System.out.println("1. 가입할 ID 를 입력해주세요");
        String empId = sc.nextLine();
        System.out.println("2. 가입할 이름을 입력해주세요.");
        String empName = sc.nextLine();
        System.out.println("3. 가입할 주민번호를 입력해주세요.");
        String empNo = sc.nextLine();
        System.out.println("4. 가입할 핸드폰 번호를 입력해주세요.");
        String phone = sc.nextLine();
        System.out.println("5. 가입할 입사일을 입력해주세요.");
        String hireDate = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);
        parameter.put("empName", empName);
        parameter.put("empNo", empNo);
        parameter.put("phone", phone);
        parameter.put("hireDate", hireDate);

        return parameter;


    }

}


