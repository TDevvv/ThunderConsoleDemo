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


public class JPreScan {
    
    
    private JVarMap varmap;
    protected String sCommIn;
    protected String sCommOut;
    
   
    public JPreScan()
    {
        sCommIn = "";
        sCommOut = "";
        varmap = null;
    }
    
    public JPreScan(JVarMap vmap)
    {
        sCommIn = "";
        sCommOut = "";
        varmap = vmap;
    }
    
    public JPreScan(JVarMap vmap, String sIn)
    {
        sCommIn = sIn;
        varmap = vmap;
        sCommOut = Prescan(sIn);
    }
 
   
    public String getOutStr() { return sCommOut; }
    
    public void setVarMap(JVarMap vmap) { varmap = vmap; }
    
 
    public String Prescan(String sCommand)
    {
        String sCommand2, sv;
        double dv = 0.0;
        sv = "";
        sCommand2 = sCommand;
        
       
        String sx = sCommand2;
        System.out.println("sx =: " + sx);
        sx = sx.replaceAll("\\(", " ");
        sx = sx.replaceAll("\\)", " ");
        sx = sx.replaceAll("\\*", " ");
        sx = sx.replaceAll("\\+", " ");
        sx = sx.replaceAll("\\-", " ");
        sx = sx.replaceAll("\\/", " ");
        sx = sx.replaceAll("\\^", " ");
        System.out.println("sx =: " + sx);
        
        String[] sar = sx.split(" ");
        for(int i = 0; i < sar.length; i++) {
            System.out.println(String.format("sar[%d] =: %s", i, sar[i]));
        }
       
        
        System.out.println("sCommand2 =: " + sCommand2);
        for(int i = 0; i < sar.length; i++)
        {
            if(sar[i].isEmpty()) continue;   
            if(sar[i].matches("[-+]?\\d*\\.?\\d+") ) continue;  
            System.out.println(String.format("sar[%d] =: %s", i, sar[i]));
            if(varmap.isKey(sar[i])) {
                
                dv = varmap.getValue(sar[i]);  System.out.println("dv =: " + dv);
                sv = Double.toString(dv);       System.out.println("sv =: " + sv);
                sCommand2 = sCommand2.replaceAll(sar[i], sv);
            }
        }
        System.out.println("sCommand2 =: " + sCommand2);
             
        return sCommand2;
    }

    
    
}
