package EmployeePayroll;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class EmployeePayRollTest {
    public String DIR = System.getProperty("user.dir");
    Path path = Paths.get(DIR , "../texts/").normalize();
    public String folderName = "nik";
    File dir = new File("C:\\Nikhil\\texts\\nik");
    File[] fileList = dir.listFiles();


    @Test
    public void ifPathPresent_ReturnTrue(){
        System.out.println("Current working dir :" + path);
        Assert.assertTrue(Files.exists(path));
    }

    @Test
    public void  ifFilePresent_ReturnTrue() throws IOException {
        int i=0;
        if (dir.isDirectory()){
            for (File file : fileList){
                i++;
                System.out.println(" Index " + i + " file -> " + file.getName());
            }
        }
        else
            System.out.println("No directory specified");
        Assert.assertTrue(dir.isDirectory());
    }

    @Test
    public void deleteFiles() throws IOException{

        Path checkFilePath = Paths.get(path + "/" + folderName );
        if (!dir.isDirectory()) {
            System.out.println("Not an directory");
        }
        System.out.println(fileList);
        if (fileList != null)
            for (File file : fileList){
                System.out.println("Deleting " + file.getName());
                file.delete();
            }
    }

    @Test
    public void createFiles() throws IOException {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        int count =0;
        for (int num : numbers) {
            String key = "file "+num;
            File file = new File( "C:\\Nikhil\\texts\\nik\\" + key + ".txt" );
            if (file.createNewFile()) {
                System.out.println("File created succesfully");
                count++;
            } else
                System.out.println("error");
        }
        Assert.assertEquals(9,count);
    }

    @Test
    public void printDetailsOfADirectory(){
        System.out.println("  Name  \t size\textension");
        for (File file : fileList){
            String extension = "";
            int i = file.getName().lastIndexOf('.');
            if (i > 0) {
                extension = file.getName().substring(i+1);
            }
            System.out.println(file.getName() +"\t"+ file.length()/1024 + " kb\t" + extension);
        }
    }

}
