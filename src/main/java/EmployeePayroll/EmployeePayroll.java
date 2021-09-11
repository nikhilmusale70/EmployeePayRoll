package EmployeePayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeePayroll {
    int id;
    String name;
    Double salary;
    ArrayList<EmployeePayrollData> empData = new ArrayList<EmployeePayrollData>();
    EmployeePayrollData dataObj;


    public static int main(String[] args) throws IOException {
        EmployeePayroll obj = new EmployeePayroll();
        obj.readingDataFromConsole();
        obj.readingDataFromConsole();
        obj.writingOnConsole();
        obj.writingOnFile();

        return obj.count;
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
    int count =0;
    public void writingOnFile() throws IOException {
        Path path = Paths.get("C:\\Nikhil\\bridgelabz\\texts\\EmployeePayRoll\\EmployeePayRoll.txt");
        if (Files.exists(path)){
            System.out.println("File already Exists, so appending on it ");
        }
        else {
            System.out.println("File does not exists, So creating new file ");
            Files.createFile(path);
        }

        ArrayList<String> data = new ArrayList<>();
        data.add("Name \t ID \t Salary");
        for (int i=0 ;i<empData.size(); i++){
            count++;
            data.add(empData.get(i).name + " " + empData.get(i).id+ " " + empData.get(i).salary );
        }

        Files.write(path,data);
        System.out.println("Data written in file using string" + empData.size());
    }

    public void printingFromFile() throws IOException {
        Path path = Paths.get("C:\\Nikhil\\bridgelabz\\texts\\EmployeePayRoll\\EmployeePayRoll.txt");
        List<String> data = null;
        if (!Files.exists(path)){
            System.out.println("File does not exists");
        }
        else {
           data =  Files.readAllLines(path);
        }
        for (String s : data)
            System.out.println(s);
    }

}
