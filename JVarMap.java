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

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Double.MIN_VALUE;
import static java.lang.Double.NaN;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import java.util.ArrayList;
import java.util.Arrays;


public class JVarMap {
    
    
    private static ArrayList<String> Key;
    private static ArrayList<Double> Value;
    private byte[] BArray;
    private int nOffset;    
    
  
    
    public JVarMap()
    {
        Key = new ArrayList<String>();
        Value = new ArrayList<Double>();
        BArray = null;   
        nOffset = 0;
    }   
    

    
    public int Add(String svarnam, double dval)
    {
        Key.add(svarnam);
        Value.add(dval);
        BArray = null;
        nOffset = 0;
        return 1;
    }
    
    public int Update(String svarnam, double dval)
    {
        int nIndex = getKeyIndex(svarnam);
        if(nIndex < 0) return 0;
        Value.set(nIndex, dval);
        return 1;
    }
    
    public int Erase(String svarnam)
    {
        int nIndex = getKeyIndex(svarnam);
        if(nIndex < 0) return 0;
        Key.remove(nIndex);
        Value.remove(nIndex);
        
        return 1;
    }
 
         
 
    public ArrayList<String> getKeyArray()
    {
        return Key;
    }
    
    public ArrayList<Double> getValueArray()
    {
        return Value;
    }
       
    public void dump()
    {
        System.out.println(String.format("map dump: %d", Key.size()));
        for(int i = 0; i < Key.size(); i++)
        {
           System.out.println(String.format("Key[[%d] =: %s", i, Key.get(i)));
           
            System.out.println(String.format("%2.8f",  Value.get(i)));
        }
    }
            
    public int getKeyIndex(String svarnam)
    {
        int nIndex = 0;
        boolean bfound = false;
        int nsize = Key.size();
        for(int i = 0; i < nsize; i++)
        {
           
            if( Key.get(i).equals(svarnam))
            {
                nIndex = i;
                bfound = true;   
            }
            if(bfound) break;
        }
        if(!bfound) {
            System.out.println(String.format("%s is not currently mapped", svarnam));
            return -1;
        }
        return nIndex;
    }
    
    public String[] getKeyList()
    {
        int nsize = Key.size();
        String [] keyListArray = new  String[nsize];
        for(int i = 0; i < nsize; i++)
        {
            keyListArray[i] = Key.get(i);
            
        }
        return keyListArray; 
    }
    
    public void dumpKeys()
    {
        int nsize = Key.size();
        System.out.println(String.format("Key Dump: %d", nsize));
        for(int i = 0; i < nsize; i++) {
            System.out.println(String.format("Key[%d] =: %s", i, Key.get(i)));
        }        
        System.out.println("");
    }
    
    public boolean isKey(String svarnam)
    {
        System.out.println("JVarMap.isKey(String svarnam:");
        System.out.println("svarnam =: " + svarnam);
       for(int i = 0; i < Key.size(); i++) {
            if (Key.get(i).equals(svarnam) ) return true;
       
        }
        return false;
    }
   
    public double getValue(String sKey)
    {
        int ndx = -1;
        boolean bfound = false;
        double dnull = NaN;
       
        if( !Key.contains(sKey) ) return dnull;
        for(int i = 0; i < Key.size(); i++)
        {
            if(Key.get(i).equals(sKey)) bfound = true;
            if(bfound) ndx = i;
            if(bfound) break;
        }
        if(!bfound) return dnull;
        double dm = Value.get(ndx);
        return dm;
    }
 
    public static void byteDump(byte[] bar)
    {
        System.out.println("byte dump: "+bar.length);
        for(int i = 0; i < bar.length; i++)
        {
            System.out.print(String.format("%02X ", bar[i]));
            boolean isEven = (i+1) % 16 == 0;
            boolean isEven2 = (i+1) % 8 == 0;
            if(isEven2) System.out.print(" ");
            if(isEven) System.out.println("");
        }      
        System.out.println("");

    }
    
    private byte[] toByteArray(String s)
    {
      byte[] output = new byte[4 * s.length()]; 
      output = s.getBytes();
      return output;  
    }
    
    byte[] toByteArray(int value) {
        return  ByteBuffer.allocate(4).putInt(value).array();
    }

    private byte[] toByteArray(Double d) {
        byte[] output = new byte[8];
        Long lng = Double.doubleToLongBits(d);
        for (int i = 0; i < 8; i++) {
            output[i] = (byte)((lng >> ((7 - i) * 8)) & 0xff);
        }
        return output;
    }
    
    public int writeMap(Path p) {
        System.out.println("aMap.WriteMap(Path p):");  
        System.out.println(String.format("p =: %s\\%s", p.getParent(), p.getFileName()));

       
        String sn = "";         
        double dv = MIN_VALUE;  
        byte[] basn = null;     
        byte[] badv = null;     
        int snlen;              
        int dvlen;              
        
      try (OutputStream out = new BufferedOutputStream(
         
          Files.newOutputStream(p, CREATE, TRUNCATE_EXISTING))) {
            for(int i = 0; i < Key.size(); i++) {   
                BArray = toByteArray(Value.get(i));
                byte[] data = BArray;
                byte[] snam = Key.get(i).getBytes();    
                snlen = snam.length;
               
                dvlen = BArray.length;
                basn = toByteArray(snlen);  
                badv = toByteArray(dvlen);  
        
               
                out.write(basn);
                out.write(snam, 0, snam.length);
                
                out.write(badv);
               
                out.write(data, 0, data.length); 
            }
           
        } catch (IOException x) {
          System.err.println(x);
          return 0;
        }       
        
        return 1;
    }    
    
    public byte[] loadBytes(Path p)
    {
        byte[] data = new byte[1];
        try
        {
            data = Files.readAllBytes(p);
        }
        catch(IOException x) {
            System.err.println(x);
            return data;
        }    
        
        
        return data;
    }    
 
    String BytesToString(byte[] b)
    {
        String s = new String(b);
        return s;
    }
    
   int byteArrayToInteger(byte[] bytes) {
     return ByteBuffer.wrap(bytes).getInt();
}
    public  double byteArrayToDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }
    
    public int readMap(Path p) throws FileNotFoundException
    {
        System.out.println("JVarMap.ReadMap2(Path p):");  
        System.out.println(String.format("p =: %s\\%s", p.getParent(), p.getFileName()));
       
        JVarMap tmap = new JVarMap();
        
        byte[] bdata = null;
        bdata = loadBytes(p);  
        byteDump(bdata);
        
        nOffset = 0; 
    
       
        byte[] slice = Arrays.copyOfRange(bdata, nOffset, 4);  byteDump(slice);
       
        int nsize = byteArrayToInteger(slice);  System.out.println("nsize =: " + nsize);
        
        slice = Arrays.copyOfRange(bdata, nOffset+4, nOffset + 4 + nsize); byteDump(slice); // ?? + 4 for int bytes ??
        
        String snam =  BytesToString(slice);
        System.out.println("snam =: " + snam);

      
        nOffset = nOffset + nsize + 4;  System.out.println("nOffset =: " + nOffset);
       
        slice = Arrays.copyOfRange(bdata, nOffset, nOffset + 4);  byteDump(slice);
       
        nsize = byteArrayToInteger(slice);  System.out.println("nsize =: " + nsize);
       
        slice = Arrays.copyOfRange(bdata, nOffset+4, nOffset + nsize + 4); byteDump(slice); // ?? + 4 for int bytes ??      
       
        Double dv = byteArrayToDouble(slice);
        System.out.println("dv =: " + dv);
        tmap.Add(snam, dv);
       
        do { 
       
       
        nOffset = nOffset + nsize + 4;  System.out.println("nOffset =: " + nOffset);
        
        slice = Arrays.copyOfRange(bdata, nOffset, nOffset + 4);  byteDump(slice);
       
        nsize = byteArrayToInteger(slice);  System.out.println("nsize =: " + nsize);
        
        slice = Arrays.copyOfRange(bdata, nOffset+4, nOffset + nsize + 4); byteDump(slice); 
       
        snam =  BytesToString(slice);
        System.out.println("snam =: " + snam);
         
        
        nOffset = nOffset + nsize + 4;  System.out.println("nOffset =: " + nOffset);
       
        slice = Arrays.copyOfRange(bdata, nOffset, nOffset + 4);  byteDump(slice);
       
        nsize = byteArrayToInteger(slice);  System.out.println("nsize =: " + nsize);
       
        slice = Arrays.copyOfRange(bdata, nOffset+4, nOffset + nsize + 4); byteDump(slice); // nb: from -> to    
        
        dv = byteArrayToDouble(slice);
        System.out.println("dv =: " + dv);
        
        tmap.Add(snam, dv);
        
       } while ( nOffset + nsize + 4 < bdata.length);
        
        
        Key = tmap.getKeyArray();
        Value = tmap.getValueArray();        
 
        return 1;
    }       
    
    
}
