package EmployeePayroll;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayroll {
    int id;
    String name;
    Double salary;
    ArrayList<EmployeePayrollData> empData = new ArrayList<EmployeePayrollData>();
    EmployeePayrollData dataObj;


    public static void main(String[] args) {
        EmployeePayroll obj = new EmployeePayroll();
        obj.readingDataFromConsole();
        obj.readingDataFromConsole();
        obj.writingOnConsole();

    }

    public void readingDataFromConsole(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id :- ");
        id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Name :- ");
        name = sc.nextLine();
        System.out.print("Enter salary :- ");
        salary = sc.nextDouble();
        dataObj = new EmployeePayrollData(id,name,salary);
        empData.add(dataObj);
    }

    public void writingOnConsole(){
        for (int i=0; i<empData.size(); i++) {
            System.out.println("Id :-" + empData.get(i).id);
            System.out.println("Name :-" + empData.get(i).name);
            System.out.println("Salary:-" + empData.get(i).salary);
        }

    }

}
