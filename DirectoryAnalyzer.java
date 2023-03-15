import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class DirectoryAnalyzer{

    private static int newAlpha = 0;
    private static int newNum = 0;
    private static int newSpace = 0;
    private static long newStorage = 0;
    public static void main(String[] args) {

        try{
        int totalFiles = 0;

        File directory = new File(args[0]);
        if(!directory.isDirectory()){
            System.out.println("Path is not a directory, try again.");
            System.exit(0);
        }

        File[] directoryArray = directory.listFiles();
        for(File fil: directoryArray) {
            totalFiles++;
            if(fil.isFile()){
                System.out.println("File:  " + fil.getName()+ "\t : \t" + size(fil) + chars(fil));
            }else if(fil.isDirectory()){
                System.out.println("Directory: " + fil.getName()+ "\t : \t" + size(fil) + chars(fil));
            }else{
                System.out.println("Unreadable");
            }
        }



        System.out.println("Total Files : \t\t"+ totalFiles);
        System.out.println("Total Alpha Chars: \t"+newAlpha);
        System.out.println("Total Numeric Chars: \t"+newNum);
        System.out.println("Total Space Chars: \t"+newSpace);
        System.out.println("\nTotal Size Disk: "+totalSize(newStorage));
        }catch(IOException e){
            System.out.println("End of program");
            System.exit(0);
        }

    }

    public static String chars(File newFile) throws FileNotFoundException{
        Scanner newScanner=new Scanner(newFile);
        int alphas = 0;
        int numbers = 0;
        int spaces = 0;

        while(newScanner.hasNextLine()) {
            String newString = newScanner.nextLine();
    
        for(int x=0; x<newString.length();x++){
            char newChar = newString.charAt(x);
            if(newChar == 32) {
                spaces++;
                
            }else if((newChar >64 && newChar < 91)||(newChar >96&&newChar<123)){
                alphas++;
            }else if(newChar > 47&&newChar < 58){
                numbers++;
            }
        }
        newAlpha += alphas;
        newNum += numbers;
        newSpace += spaces;

    }
        return "\t" +alphas+"\t"+numbers+"\t"+spaces;
    }

    public static String size(File newFile) {
        long totalStorage = newFile.length();
        newStorage += totalStorage;

        if(newFile.length()<1024) {
            return newFile.length() + " bytes";
        }else if(newFile.length()>=1024 && newFile.length()< (1024*1024)){
            long newDub = newFile.length()/1024;
            return newDub + " kb";
        }else if(newFile.length()>=(1024*1024)){
            long newDub = newFile.length()/(1024*1024);
            return newDub + " mb";
        }else{
            long newDub = newFile.length()/(1024*1024*1024);
            return newDub + " gb";
        }
    }

    public static String totalSize(long newInt) {

        if(newInt<1024) {
            return newInt + " bytes";
        }else if(newInt>=1024 && newInt< (1024*1024)){
            long newDub = newInt/1024;
            return newDub + " kb";
        }else if(newInt>=(1024*1024)){
            long newDub = newInt/(1024*1024);
            return newDub + " mb";
        }else{
            long newDub = newInt/(1024*1024*1024);
            return newDub + " gb";
        }

    }

}