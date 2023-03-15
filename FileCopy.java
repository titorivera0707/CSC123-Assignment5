import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class FileCopy{

    public static void main(String[] args) throws IOException{

        try{
            Scanner newScan = new Scanner(System.in);
            TreeSet<String> treeSet = new TreeSet<>();
            String data;
            String upData;

            String input = args[1];

            File oldFile = new File(input);

            if(!oldFile.exists()){
                System.out.println("Error, source file does not exist.");
                System.exit(0);
            }else if(oldFile.isDirectory()){
                System.out.println("Error, source file is a directory.");
                System.exit(0);
            }

            Scanner readFile = new Scanner(oldFile);
            
            while(readFile.hasNext()) {
                data = readFile.nextLine();
                treeSet.add(data);
            }
            Iterator<String> iterator = treeSet.iterator();

            String output = args[0];
            File newFile = new File(output);
            if(newFile.createNewFile()) {
                PrintWriter printWriter = new PrintWriter(newFile);
                System.out.println(newFile.exists());
                while(iterator.hasNext()) {
                    upData = iterator.next();
                    printWriter.println(upData);
                }
                printWriter.close();
            }else{
                System.out.println("File already exists.");
                System.exit(0);
            }
            readFile.close();
            newScan.close();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Missing arguments. Please try again.");
        }   
    }
}