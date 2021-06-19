/*
 * Copyright (c) 2017, Michael B.Pliam / PliaTech. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of PliaTech or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

/*
* from: BullyWiiPlaza  Feb 2, 2015
* http://stackoverflow.com/questions/766956/how-do-i-create-a-right-click-context-menu-in-java-swing
*/
package components;

import static java.awt.Event.BACK_SPACE;

import java.awt.Color;
import java.awt.datatransfer.Clipboard;
import java.util.List;

import java.util.Date;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


import org.apache.log4j.Logger;
import components.Thunder;
import components.Thunder;



public class Console extends javax.swing.JFrame {
	public static final int n =8;
	 static final Logger LOGGER = Logger.getLogger(Console.class);
	private static final String illik98 = null;
	
	
	
	
   
 
   

    public boolean quitFlag; 
    File curDir;
    
    
    public JParser parser = new JParser();
    public JVarMap varmap = new JVarMap();
    public int nindex;
    
   
    public Console() {
        initComponents();

       
        Path p = Paths.get("./data/varmap.dat");
        try {
            varmap.readMap(p);
            varmap.dumpKeys();
        }
        catch (FileNotFoundException ex) {
            System.out.println(String.format("%s", ex.getMessage()));
        }
        
        this.setLocationRelativeTo(null);
        
        jTextArea1.setText("\tThunderConsole\n\n<< ");  
        
        
        quitFlag = false;
        
        curDir = new File("./");
        
        DefaultContextMenu contextMenu = new DefaultContextMenu();
        contextMenu.add(jTextArea1);
    }

    public JPreScan prescan = new JPreScan();

	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                try {
					jTextArea1KeyPressed(evt);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }

     void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) throws FileNotFoundException {//GEN-FIRST:event_jTextArea1KeyPressed
    	
    	 
    	 if (evt.getKeyCode() == KeyEvent.VK_TAB) {
    		String[] lines = jTextArea1.getText().split("\\n");
            int nline = lines.length;
            String sCommand = lines[nline - 1];
            boolean textbul413=sCommand.contains("console");
            if(textbul413==true) {
            	sCommand = sCommand.replaceAll("<< ", "");
            	
            	jTextArea1.setText("console.run.cmd");
            	LOGGER.info(">>Clicked Tab<<");
            	LOGGER.info(">>"+jTextArea1.getText()+"<<");
            	
            	
            	
            	
            }
            
    		
    		
    	}
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           
            LOGGER.info(">>Clicked Enter<<");
            LOGGER.info(">>"+jTextArea1.getText()+"<<");
            String[] lines = jTextArea1.getText().split("\\n");
            int nline = lines.length;
            String sCommand = lines[nline - 1];
            sCommand = sCommand.replaceAll("<< ", "");
            
            System.out.println("sCommand =: |" + sCommand + "|");
            LOGGER.info(">>"+sCommand+"<<");
            if (sCommand.equals("console.çýkýþ")) {
            	LOGGER.info(">>"+sCommand+"<<");
                quitFlag = true;
                appendString("Eminmisin (evet/hayýr)?\n");
                
                return;
            }               
            if(sCommand.equals("Evet") || sCommand.equals("evet") || sCommand.equals("e")) {
                if(quitFlag) { 
                	Date date = new Date();
                    System.out.println("User confirmed quit");
                    LOGGER.info(">>"+"Quitted Log Finish"+"<<"+">>"+date);
                    Path p = Paths.get("./data/varmap.dat");
                    varmap.writeMap(p);
                    System.exit(0); 
                }
            }
            if(sCommand.equals("Hayýr") || sCommand.equals("hayýr") || sCommand.equals("h")) {
                if(quitFlag) { System.out.println("User cancelled quit"); quitFlag = false;
                LOGGER.info(">>"+jTextArea1.getText()+"<<");
                    jTextArea1.append("\n\n<< "); return; }    
            }
            
            if (sCommand.equals("console.süpür")) {
                int nlineCount = jTextArea1.getLineCount();
                System.out.println("nlineCount =: " + nlineCount);
                sCommand = sCommand.replaceAll("<< ", "");
                jTextArea1.setText("");
                jTextArea1.selectAll();
                jTextArea1.append("<< ");
                return;
            } 
              
            if (sCommand.equals("console")) {
            	appendString("ThunderConsole>>süpür,run,renk,oluþtur,çalýþtýr,derle");
            	LOGGER.info(">>"+jTextArea1.getText()+"<<");
    			return;
                
            
    			
            	 
            } 
            if(sCommand.equals("console.ortbul")) {
            	int Sayý1 = Integer.parseInt(JOptionPane.showInputDialog("1.Sayýyý Giriniz:"));
            	int Sayý2 = Integer.parseInt(JOptionPane.showInputDialog("2.Sayýyý Giriniz:"));
            	int Sonuc= (Sayý1+Sayý2)/2;
            	appendString("ThunderConsole>>Ortalama>>:"+Sonuc);
            	return;
            }
            if(sCommand.equals("console.ortbul.3")) {
            	int Sayý1 = Integer.parseInt(JOptionPane.showInputDialog("1.Sayýyý Giriniz:"));
            	int Sayý2 = Integer.parseInt(JOptionPane.showInputDialog("2.Sayýyý Giriniz:"));
            	int Sayý3 = Integer.parseInt(JOptionPane.showInputDialog("3.Sayýyý Giriniz:"));
            	int Sonuc= (Sayý1+Sayý2+Sayý3)/3;
            	appendString("ThunderConsole>>Ortalama>>3>>	:"+Sonuc);
            	return;
            }
            if(sCommand.equals("console.ortbul.4")) {
            	int Sayý1 = Integer.parseInt(JOptionPane.showInputDialog("1.Sayýyý Giriniz:"));
            	int Sayý2 = Integer.parseInt(JOptionPane.showInputDialog("2.Sayýyý Giriniz:"));
            	int Sayý3 = Integer.parseInt(JOptionPane.showInputDialog("3.Sayýyý Giriniz:"));
            	int Sayý4 = Integer.parseInt(JOptionPane.showInputDialog("4.Sayýyý Giriniz:"));
            	int Sonuc= (Sayý1+Sayý2+Sayý3+Sayý4)/4;
            	appendString("ThunderConsole>>Ortalama>>4>>:"+Sonuc);
            	return;
            }
            
            boolean textbul789;
            textbul789=sCommand.contains("console.terscevir.");
            if(textbul789==true) {
            	String illik982=sCommand.substring(18,sCommand.length());
            	String  reverse = "";
                

                System.out.println("Ters çevirilecek stringi girin");
                
                int length = illik982.length();

                for (int i = length - 1 ; i >= 0 ; i--)
                  reverse = reverse + illik982.charAt(i);

                appendString("Ters Hali: " + reverse);
                return;
            	
            	
            }
            boolean textbul9812;
            textbul9812=sCommand.contains("console.sil.");
            if(textbul9812==true) {

            	LOGGER.info(">>"+jTextArea1.getText()+"<<");
            	String illik98=sCommand.substring(12,sCommand.length());

       		 File f = new File(illik98);
       		 if(!f.exists()){ 
       		 appendString(f.getName()+" Dosyasý bulunamadýðýndan silinemedi");
       		 }else{
       		 f.delete(); 
       		 appendString(f.getName() +" adlý dosya baþarýlý bir þekilde silinmiþtir.");
       		 }
            	 return;
            	
            }
            	
            
            boolean textbul1567;
            textbul1567=sCommand.contains("console.ntortalama.");
            if(textbul1567==true) {
            	LOGGER.info(">>"+jTextArea1.getText()+"<<");
            	String illik1567=sCommand.substring(19,sCommand.length());
            	int not= Integer.parseInt(illik1567);
            	if(not<0)
            	{
            		appendString("HATALI NOT");
            		return;
            	}
            	else if(not<50)
            	{
            	appendString("KALDI(1)");
            	return;
            	}
            	else if (not < 60)
            	{
            		appendString("GEÇER(2)");
            		return;
            	}
            	else if (not < 70)
            	{
            		appendString("ORTA(3)");
            		return;
            	}
            	else if (not < 85)
            	{
            		appendString("ÝYÝ(4)");
            		return;
            	}
            	else if (not <= 100)
            	{
            		appendString("PEKÝYÝ(5)");
            		return;
            	}
            	 
            	
            	

            	
            	
            }
            boolean textbul156;
            textbul156=sCommand.contains("console.küçükyap.");
            if(textbul156==true) {
            	String illik156=sCommand.substring(17,sCommand.length());
            	String illik156k = illik156.toLowerCase();
            	
            	appendString(illik156k);
            	return;
            	
            	
            }
            boolean textbul1566;
            textbul1566=sCommand.contains("console.büyükyap.");
            if(textbul1566==true) {
            	String illik156=sCommand.substring(17,sCommand.length());
            	String illik1566k = illik156.toUpperCase();
            	
            	appendString(illik1566k);
            	return;
            	
            	
            }
            boolean textbul324;
            textbul324=sCommand.contains("console.sayýkntrl.");
            if(textbul324==true) {
            	String illik324=sCommand.substring(18,sCommand.length());
            	int illik1324i = Integer.parseInt(illik324);
            	if(illik1324i%2==0) {
            		appendString("ThunderConsole>>"+illik1324i+">>Sayýsý Çifttir.");
            		return;
            		
            	}
            	else {
            		appendString("ThunderConsole>>"+illik1324i+">>Sayýsý Tektir.");
            		return;
            		
            	}
            	
            	
            	
            }
            boolean textbul123;
            textbul123=sCommand.contains("console.þifre-.");
            if(textbul123==true) {
            	String illik123= sCommand.substring(15,sCommand.length());
            	 try
                 {
                     
                     int otele=5;
                     char [] harfler=illik123.toCharArray();
                     String sifresiz="";
             
                     for (int i = 0; i < harfler.length; i++) {
                     

                       sifresiz += Character.toString((char)((harfler[i]-otele)-harfler.length));
                     
                     }

                     
                     appendString(sifresiz);
                 }
                 catch(Exception ex)
                         {
                             JOptionPane.showMessageDialog(null, ex.getMessage());
                             LOGGER.error(">>Error Diin Geçerli Deðil<<");
                         }
            }
            	
            boolean textbul12345;
            textbul12345=sCommand.contains("console.þifrele.");
            if(textbul12345==true) {
            	String illik12345= sCommand.substring(16,sCommand.length());
            	try
                {

                	String metin=illik12345;
                    int otele=5;
                    char [] harfler=metin.toCharArray();
                    String sifreli="";
           
                        for (int i = 0; i < harfler.length; i++) {
                   

                            sifreli += Character.toString((char)((harfler[i]+otele)+harfler.length));
                   
                        }

                    appendString("Þifrelenmiþ Metin:"+sifreli);
                    return;
                }
            catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            LOGGER.info(">>Error<<");
                        }
           

            	
            	
            }
            boolean textbul9823=true;
            textbul9823=sCommand.contains("console.þifrelioku.");
            if(textbul9823==true) {
            	String illik22345=sCommand.substring(19,sCommand.length());
          
            	
            		File file = new File("C:/Users/Kodek/Desktop/"+illik22345);
                    BufferedReader reader = null;
                    try {
            			reader = new BufferedReader(new FileReader(file));
            			
            		} catch (FileNotFoundException e) {
            			
            			e.printStackTrace();
            		}
                    String satir;
            		try {
            		 satir = reader.readLine();
            		int strlnght=satir.length();
            			int a = 0;
            			 while (a<5) {
            				 try
                             {
                                 a++;
                                 int otele=5;
                                 char [] harfler=satir.toCharArray();
                                 String sifresiz="";
                         
                                 for (int i = 0; i < harfler.length; i++) {
                                 

                                   sifresiz += Character.toString((char)((harfler[i]-otele)-harfler.length));
                                 
                                 }

                                 
                                 appendString("ThunderConsole>>Þifreli Kayýt:Oku>>"+sifresiz);
                             }
                             catch(Exception ex)
                                     {
                                         JOptionPane.showMessageDialog(null, ex.getMessage());
                                     }
                        
            	                
            	            }
            			 return;

            		} catch (IOException e) {
            			
            			e.printStackTrace();
            		}
            }
            boolean textbul982;
            textbul982=sCommand.contains("console.oku.");
            if(textbul982==true) {
            	String illik2=sCommand.substring(12,sCommand.length());
            	
            	
            		File file = new File("C:/Users/Kodek/Desktop/"+illik2);
                    BufferedReader reader = null;
                    try {
            			reader = new BufferedReader(new FileReader(file));
            			
            		} catch (FileNotFoundException e) {
            			
            			e.printStackTrace();
            		}
                    String satir;
            		try {
            			satir = reader.readLine();
            			 while (satir!=null) {
            	            	appendString(satir);
            	                satir = reader.readLine();
            	                
            	            }
            			 return;

            		} catch (IOException e) {
            		
            			e.printStackTrace();
            		}

                }
            	            	
           


            	
            
            	            
            	
            	
            	
            boolean textbul98;
            textbul98=sCommand.contains("console.rnþifre.");
            if(textbul98==true) {
            	String illik=sCommand.substring(16,sCommand.length());
            	int sifresayý = Integer.parseInt(illik);
            	String metin = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                        + "0123456789"
                        + "abcdefghijklmnopqrstuvxyz"; 

            String n="";
            
            StringBuilder sb = new StringBuilder(n); 

            for (int i = 0; i < sifresayý; i++) { 

            
            int index 
                = (int)(metin.length() 
                        * Math.random()); 

            
            sb.append(metin 
                          .charAt(index)); 
            } 
             final String l =sb.toString();
             appendString(l);
            return;  
            }  
            if (sCommand.equals("console.run.Console.log")) {
            	new AWTConsole();
            	return;
            }   
            if (sCommand.equals("console.run.hesapmakinesi")) {
            	Runtime r = Runtime.getRuntime();
            	Process p = null;
            	try
            	{
            	p = r.exec("C:\\WINDOWS\\system32\\calc");
            	System.out.print("çalýþtý");
            	}
            	catch(Exception e)
            	{
            	System.out.print("çalýþmadý");
            	}
            	return;
            }
                
            
    			
            	 
            if (sCommand.equals("console.log")) {
            	SimpleDateFormat sekil = new SimpleDateFormat("yyyy/MM/dd");
    	        Date tarih = new Date();
    	        String merhaba = tarih.toString();
            	String illik123=jTextArea1.getText();
            	
            	String path= "C:/Users/Kodek/Desktop/log.txt";
        		appendString("Log Dosyasý Baþarýyla Oluþturuldu."+illik123);
        		 FileOutputStream fos;
             	File file = new File("C:/Users/Kodek/Desktop/log.txt");
             	try {
             		if (!file.exists()) { file.createNewFile(); 
             		} FileWriter fileWriter = new FileWriter(file, false); 
             		BufferedWriter bWriter = new BufferedWriter(fileWriter); 
             		bWriter.write(illik123);bWriter.write(merhaba); bWriter.close(); 
             		return;
     			
     				
     			} catch (IOException e) {
     				
     				e.printStackTrace();
     			}
                     
        		
        		
            	
    			
            	 
            }     
            if (sCommand.equals("console.run.cmd")) {
            	try {
            		   Process p =  Runtime.getRuntime()
            		    .exec("cmd /c start \"");
            		  } catch (IOException ex) {
            		}
            	jTextArea1.setForeground(Color.cyan);
            	return;
                
            	
    			
            	 
            }     
            if (sCommand.equals("run.wp")) {
            	Runtime r = Runtime.getRuntime();
            	Process p = null;
            	try
            	{
            	p = r.exec("C:\\Users\\Kodek\\AppData\\Local\\WhatsApp\\Whatsapp.exe");
            	System.out.print("çalýþtý");
            	}
            	catch(Exception e)
            	{
            	System.out.print("çalýþmadý");
            	}
            	return;
                
            
    			
            	 
            } 
            if (sCommand.equals(""
            		+ "")) {
            	jTextArea1.setBackground(Color.cyan);
            	appendString("ThunderConsole>>Renk>>Arkaplan:Camgöbeði");
    			return;
                
            
    			
            	 
            }  
            if (sCommand.equals("console.renk.arkaplan.koyugri")) {
            	jTextArea1.setBackground(Color.darkGray);
            	appendString("ThunderConsole>>Renk>>Arkaplan:Koyugri");
    			return;
                
            
    			
            	 
            }  
            if(sCommand.equals("console.ö")) {
            	String q =System.getProperties().toString();
            	appendString(q);
            	return;
            	
            }
            if(sCommand.equals("console.fullkonum")) {
            	String u=System.getenv().toString();
            	appendString(u);
            }
            if(sCommand.equals("denem")) {
            	
            	
            }
            if (sCommand.equals("console.renk.arkaplan.gri")) {
            	jTextArea1.setBackground(Color.gray);
            	appendString("ThunderConsole>>Renk>>Arkaplan:Gri");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.arkaplan.yeþil")) {
            	jTextArea1.setBackground(Color.green);
            	appendString("ThunderConsole>>Renk>>Arkplan:Yeþil");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.arkaplan.açýkgri")) {
            	jTextArea1.setBackground(Color.lightGray);
            	appendString("ThunderConsole>>Renk>>Arkplan:Açýkgri");
    			return;
                
            
    			
            	 
            } 
            if (sCommand.equals("console.renk.arkaplan.fuþya")) {
            	jTextArea1.setBackground(Color.magenta);
            	appendString("ThunderConsole>>Renk>>Arkplan:Fuþya");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.arkaplan.turuncu")) {
            	jTextArea1.setBackground(Color.orange);
            	appendString("ThunderConsole>>Renk>>Arkplan:Turuncu");
    			return;
                
            
    			
            	 
            }  
            if (sCommand.equals("console.renk.arkaplan.pembe")) {
            	jTextArea1.setBackground(Color.pink);
            	appendString("ThunderConsole>>Renk>>Arkplan:Pembe");
    			return;
                
            
    			
            	 
            }  
            if (sCommand.equals("console.renk.arkaplan.bordo")) {
            	jTextArea1.setBackground(Color.red);
            	appendString("ThunderConsole>>Renk>>Arkplan:Bordo");
    			return;
                
            
    			
            	 
            }  
            if (sCommand.equals("console.renk.arkaplan.normal")) {
            	jTextArea1.setBackground(Color.white);
            	appendString("ThunderConsole>>Renk>>Arkplan:Normal");
    			return;
                
            
    			
            	 
            }  
            if (sCommand.equals("console.renk.camgöbeði")) {
            	jTextArea1.setForeground(Color.cyan);
            	appendString("ThunderConsole>>Renk:Camgöbeði");
    			return;
                
            
    			
            	 
            }  
            if (sCommand.equals("console.renk.koyugri")) {
            	jTextArea1.setForeground(Color.darkGray);
            	appendString("ThunderConsole>>Renk:KoyuGri");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.gri")) {
            	jTextArea1.setForeground(Color.gray);
            	appendString("ThunderConsole>>Renk:Gri");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.açýkgri")) {
            	jTextArea1.setForeground(Color.lightGray);
            	appendString("ThunderConsole>>Renk:AçýkGri");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.fuþya")) {
            	jTextArea1.setForeground(Color.magenta);
            	appendString("ThunderConsole>>Renk:Fuþya");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.pembe")) {
            	jTextArea1.setForeground(Color.pink);
            	appendString("ThunderConsole>>Renk:Pembe");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.bordo")) {
            	jTextArea1.setForeground(Color.red);
            	appendString("ThunderConsole>>Renk:Bordo");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.normal")) {
            	jTextArea1.setForeground(Color.white);
            	appendString("ThunderConsole>>Renk:Normal");
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.renk.mavi")) {
            	jTextArea1.setForeground(Color.blue);
            	appendString("ThunderConsole>>Renk:Mavi");
    			return;
                
            
    			
            	 
            }     
            if (sCommand.equals("console.renk.turuncu")) {
            	jTextArea1.setForeground(Color.orange);
            	appendString("ThunderConsole>>Renk:Turuncu");
    			return;
                
            
    			
            	 
            }  
            if (sCommand.equals("console.renk.siyah")) {
            	appendString("ThunderConsole>>Renk:Siyah");
            	jTextArea1.setForeground(Color.black);
    			return;
                
            
    			
            	 
            }  
            
            boolean textbul1;
            textbul1=sCommand.contains("console.oluþtur.");
            if(textbul1==true) {
            	String illik1=sCommand.substring(16,sCommand.length());
            		String path= "C:/Users/Kodek/Desktop/"+illik1;
            		appendString(illik1+" Dosyasý Baþarýyla Oluþturuldu.");
            		 FileOutputStream fos;
            	File file = new File(path);
            	try {
					file.createNewFile();
					
				return;
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
            	
            	
            	
            	
            }
            
            boolean textbul12;
            textbul12=sCommand.contains("console.þifrelikaydet.");
            if(textbul12==true) {
            	String illlik12=sCommand.substring(22,sCommand.length());
            	SimpleDateFormat sekil = new SimpleDateFormat("yyyy/MM/dd");
    	        Date tarih = new Date();
    	        String merhaba = tarih.toString();
            	double plk = Math.random();
            	Integer.toString((int)plk);
            	String path= "C:/Users/Kodek/Desktop/log.txt";
        		 FileOutputStream fos;
             	File file = new File("C:/Users/Kodek/Desktop/ÞifreliKaydet"+plk+".txt");
             	try
                {

                	String metin=illlik12;
                    int otele=5;
                    char [] harfler=metin.toCharArray();
                    String sifreli="";
           
                        for (int i = 0; i < harfler.length; i++) {
                   

                            sifreli += Character.toString((char)((harfler[i]+otele)+harfler.length));
                   
                        }
                        String illik123=sifreli;
                        if (!file.exists()) { file.createNewFile(); 
                 		} FileWriter fileWriter = new FileWriter(file, false); 
                 		BufferedWriter bWriter = new BufferedWriter(fileWriter); 
                 		bWriter.write(illik123); bWriter.close(); 
                 		return;
                   
                }
            catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
           

             
                     
        		
            	
            	
            }
            boolean textbul;
            textbul=sCommand.contains("console.dikte.");
            if(textbul==true) {
            	String illik=sCommand.substring(14,sCommand.length());
            	appendString(illik);
            	return;
            	
            }
            boolean textbul3;
            textbul3=sCommand.contains("console.derle.");
            if(textbul3==true)
            {
            	String illik1= sCommand.substring(14,sCommand.length());
        		String path= "C:/Users/Kodek/Desktop/run.bat";
        		File file = new File(path);//proje içinde text.txt adýnda bir txt oluþturun.
        		try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
        		br.write("javac "+illik1);
        		    
        		  
        		} catch (IOException e) {
        		    System.out.println("Unable to read file " +file.toString());
        		}
        	
        		Runtime r = Runtime.getRuntime();
            	Process p = null;
            	try
            	{
            	p = r.exec(path);
            	System.out.print("çalýþtý");
            	}
            	catch(Exception e)
            	{
            	System.out.print("çalýþmadý");
            	}
            	return;
                
            
            }
           boolean textbul412;
            textbul412=sCommand.contains("console.çalýþtýr.");
            if(textbul412==true)
            {
            	String illik3= sCommand.substring(14,sCommand.length());
        		String path= "C:/Users/Kodek/Desktop/run.bat";
        		File file = new File(path);//proje içinde text.txt adýnda bir txt oluþturun.
        		try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
        		br.write("java "+illik3);
        		    
        		  
        		} catch (IOException e) {
        		    System.out.println("Unable to read file " +file.toString());
        		}
        	
        		Runtime r = Runtime.getRuntime();
            	Process p = null;
            	try
            	{
            	p = r.exec(path);
            	System.out.print("çalýþtý");
            	}
            	catch(Exception e)
            	{
            	System.out.print("çalýþmadý");
            	}
            	return;
                
            
            }
            
            	
            	if (sCommand.equals("console.tarih")) {
            
            	SimpleDateFormat sekil = new SimpleDateFormat();
    	        Date tarih = new Date();
    	        appendString(sekil.format(tarih));
    			return;
                
            
    			
            	 
            }     
            if (sCommand.equals("console.tarih.gün")) {
            	SimpleDateFormat sekil = new SimpleDateFormat("dd");
    	        Date tarih = new Date();
    	        appendString(sekil.format(tarih));
    			return;
                
            
    			
            	 
            } 
            if (sCommand.equals("console.tarih.ay")) {
            	SimpleDateFormat sekil = new SimpleDateFormat("MM");
    	        Date tarih = new Date();
    	        appendString(sekil.format(tarih));
    	        appendString(sekil.format(tarih));
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.tarih.yýl")) {
            	SimpleDateFormat sekil = new SimpleDateFormat("yyyy");
    	        Date tarih = new Date();
    	        appendString(sekil.format(tarih));
    			return;
                
            
    			
            	 
            }
            if (sCommand.equals("console.tarih.saat.dakika.saniye")) {
            	SimpleDateFormat sekil = new SimpleDateFormat("h:m:s");
    	        Date tarih = new Date();
    	    
    	        appendString(sekil.format(tarih));
    			return;
                
            
    			
            	 
            }
            
            if (sCommand.equals("console.konum")) {
                ArrayList<String> als;
                
                als = getAllFiles2(curDir);   
                String dirList = "";
                for(int i = 0; i < als.size(); i++) {
                    dirList += als.get(i);
                    dirList += "\n";
                }
                appendString(dirList);
                return;
            }
            
            
            if (sCommand.contains("cd")) {
                String reqDir = "";
                ArrayList<String> als = getWords(sCommand);
                for(int i = 0; i < als.size(); i++) {
                    System.out.println(String.format("als[%d] =: %s", i, als.get(i)));
                }
                for(int i = 1; i < als.size(); i++){
                    reqDir += als.get(i);
                    reqDir += "/";
                }
                System.out.println("reqDir =: " + reqDir);
                curDir = new File(reqDir);
                
                appendString("<< ");
                return;
                
            }
            
         
            if(sCommand.equals("console.var.listele"))
            {
              
                String [] sVarListArray = varmap.getKeyList();
                String svarlist = "\n\n";
                for(int i = 0; i < sVarListArray.length; i++) {
                    svarlist += sVarListArray[i]; 
                    svarlist += " ";
                    if((i+1) % 12 == 0) svarlist += "\n";
                }
                svarlist += "\n";
                jTextArea1.append(svarlist);
                jTextArea1.append("\n<< ");
                int condition = JComponent.WHEN_FOCUSED;
                InputMap taInputMap = jTextArea1.getInputMap(condition);
                ActionMap taActionMap = jTextArea1.getActionMap();
                taInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), BACK_SPACE);   // this works to insert a backspace
                return;  
            }
               
                        if(sCommand.contains("erase"))
            {
                int ndx = sCommand.indexOf("erase");
                ndx += 6;
                
                String ss = sCommand.substring(ndx, ndx + sCommand.length() - ndx);
                System.out.println("ss =: " + ss);
                
                String[] sa = ss.split(",");
               
                for(int i = 0; i < sa.length; i++) {
                    sa[i] = sa[i].replaceAll(" ", "");
                    System.out.println(String.format("sa[%d] = |%s|", i, sa[i]));
                }
                
                
                int ncount = 0;
                for(int i = 0; i < sa.length; i++) {
                    int n = varmap.Erase(sa[i]); ncount += n;
                }
                String sresult = String.format("%d variables erased\n", ncount);
                appendString(sresult);
                return;
            }

            
            
            boolean bAssign = false;
            int nIndex = sCommand.indexOf('=');
            System.out.println("nIndex =: " + nIndex);
            String sassign = "assignment found\n";
            String svarnam = "";
            if(varmap.isKey(sCommand) && nIndex == -1) 
            {   System.out.println("Simple variable evaluation");
                Double dv = varmap.getValue(sCommand);
               
                String sval = Double.toString(dv);
                sval += "\n";
                appendString(sval);
            }            
            else if(nIndex >= 0) 
            {
                System.out.println("Assignment of new or update of variable plus evaluation");
                svarnam = sCommand.substring(0, nIndex-1);
                System.out.println(String.format("svarnam =: |%s|", svarnam));
                sCommand = sCommand.substring(nIndex + 1, sCommand.length());
                System.out.println(String.format("New sCommand =: |%s|", sCommand));
                JPreScan prescan = new JPreScan(varmap, sCommand);
                sCommand = prescan.getOutStr();
                try {
                    double dval = parser.eval(sCommand);
                    System.out.println("dval =: " + dval);
                    if(varmap.isKey(svarnam)) varmap.Update(svarnam, dval);
                    else varmap.Add(svarnam, dval);
                    String smtx = Double.toString(dval);
                    smtx += "\n";
                    appendString(smtx);  
                }
                 catch (RuntimeException ex) {
                    System.out.println(String.format("Warning: %s", ex.getMessage()));
                    appendString("Unknown variable or function\n");
                }
            }
            else if(nIndex  == -1)
            {
                System.out.println("Mapped variable expression evaluation.");
                JPreScan prescan = new JPreScan(varmap, sCommand);
                sCommand = prescan.getOutStr();
                try {
                double dval = parser.eval(sCommand);
                System.out.println("dval =: " + dval);
                String smtx = Double.toString(dval);
                smtx += "\n";          
                appendString(smtx);
                }
                catch (RuntimeException ex) {
                    System.out.println(String.format("Warning: %s", ex.getMessage()));
                    appendString("Unknown variable or function\n");
                }
            }
            else
            {
                appendString("\nInvalid command\n");
            }
            
            

        }

        
        
    }

    private void DosyaSil(String URL) {
    	
    	 
    		 
    		 
    	 
    		 File f = new File(URL); 
    		 if(!f.exists()){ 
    		 System.out.println("Dosya bulunamadýðýndan silinemedi");
    		 }else{
    		 f.delete(); 
    		 System.out.println(f.getName() +" adlý dosya baþarýlý bir þekilde silinmiþtir.");
    		 }
    		 
    	 
	
    }
	private void appendString(String str)
    {
        jTextArea1.append("\n\n");
        jTextArea1.append(str);
        jTextArea1.append("\n<< ");
        int condition = JComponent.WHEN_FOCUSED;
        InputMap taInputMap = jTextArea1.getInputMap(condition);
        ActionMap taActionMap = jTextArea1.getActionMap();
        taInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), BACK_SPACE);   // this works to insert a backspace

    }
       
    private static void getAllFiles(File curDir) {
       
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
                System.out.println(f.getName());
            if(f.isFile()){
                System.out.println(f.getName());
            }
        }
    }    
    
    private static ArrayList<String> getAllFiles2(File curDir) {
        
        String absPath = curDir.getAbsolutePath();
        ArrayList<String> als = new ArrayList<String>();
        File[] filesList = curDir.listFiles();
        als.add(absPath);
        for(File f : filesList){
            if(f.isDirectory())
               
                als.add(f.getName());
            if(f.isFile()){
                
                als.add(f.getName());
            }
        }
        return als;
    }    
    
    private static ArrayList<String> getWords(String str)
    {
        System.out.println("getWords(String str):");
        System.out.println("str =: " + str);
    
      
        str = str.replace("\\", "/");
        str = str.replaceAll("/", " ");
       
        String[] words = str.split("\\s+");
        
        ArrayList<String> bList = new ArrayList<String>();
        Collections.addAll(bList, words);    
        return bList; 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Console().setVisible(true);
            }
        });
    }

    
    
    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
   
}
