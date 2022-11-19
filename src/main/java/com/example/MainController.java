package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;

public class MainController {

	public static void main(String[] args) throws IOException {
	  
		String file1="C:\\Users\\ganreddy\\My_Data\\Nevian_Project\\Nevian_Workspace\\Csv2Rdf.zip";
		String file2="C:\\Users\\ganreddy\\My_Data\\Nevian_Project\\Nevian_Workspace\\PriorityQueue.zip";
      String file1Hash= Compare(file1);
      
      String file2Hash=Compare(file2);
      
      if(file1Hash.contentEquals(file2Hash))
    	  System.out.println("Two Files are same");
      else
    	  System.out.println("Two Files are not same");
	}
	public static String Compare(String file1) throws IOException {
		
		String cmd="powershell.exe get-filehash "+file1;
		
		Process powershellProcess=Runtime.getRuntime().exec(cmd);
		
		powershellProcess.getOutputStream().close();
		
		Scanner scan=new Scanner(powershellProcess.getInputStream());
		scan.nextLine();
		scan.nextLine();
		scan.nextLine();
		String temp[]=scan.nextLine().split("\\s+");
		return temp[1];
	}

}
