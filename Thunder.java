package components;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Thunder {
	public static void main12() {
		 // Klavyeden okuma yapmak i�in Scanner nesnesini olu�tur.
        Scanner reader = new Scanner(System.in);
        Console.main(null);
        
        int num;
        int toplam=0;

        do{
          
        System.out.print("Bir Say� Girin: ");
        num = reader.nextInt();
        toplam+=num;
  
        }while(num != 0);

        System.out.println("Say�lar�n Toplam�: " + toplam);
		
		
	}
	
	
	 public static  void Tarih(String URL){
		if(URL.equals("help") ||(URL.equals("Help"))||(URL.equals("h"))) {
			System.out.println("yyyy:y�l,MM:ay,dd:g�n;");
			
		}
		Date tarih = new Date();
		SimpleDateFormat format = new SimpleDateFormat(URL);
		System.out.println(format.format(tarih));
		
		
	}
	 public static void ��k��(String URL) {
		 Console.LOGGER.info(URL);
		 System.exit(0);
		 
		 
		 
	 }
	 public static void LoggerInfo(String URL) {
		 Console.LOGGER.info(URL);
		 
		 
	 }
	 public static void LoggerError(String URL) {
		 Console.LOGGER.error(URL);
		 
		 
	 }
	 public static void LoggerDebug(String URL) {
		 Console.LOGGER.debug(URL);
		 
		 
	 }
	 public static void LoggerWarn(String URL) {
		 Console.LOGGER.warn(URL);
		 
		 
	 }
	 public static void deneme(String URL) {
		boolean arabul;
		 arabul=URL.contains("cesar.");
		 
		 if(arabul==true) {
			 String textbul123456=URL.substring(8,URL.length());
			 
		 

	        try
	        {

	           
	           
	            char [] harfler=textbul123456.toCharArray();
	            String sifreli="";
	   
	                for (int i = 0; i < harfler.length; i++) {
	           

	                    sifreli += Character.toString((char)((harfler[i]+5)+harfler.length));
	           
	                }

	            JOptionPane.showMessageDialog(null, sifreli);
	            System.out.println(sifreli);
	        }
	    catch(Exception ex)
	                {
	                    JOptionPane.showMessageDialog(null, ex.getMessage());
	                }
		 }
	   

	 }

}
