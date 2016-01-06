/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Audrey
 */
public class FiltreFichier extends FileFilter {
    
    String [] lesSuffixes;
    String  laDescription;
    
    
    public FiltreFichier(String []lesSuffixes, 
                         String laDescription){
      this.lesSuffixes = lesSuffixes;
      this.laDescription = laDescription;
   }
    
    @Override
    public boolean accept(File f) {
    if (f.isDirectory())  return true;
    String suffixe = null;
    String s = f.getName();
    int i = s.lastIndexOf('.');
    if(i > 0 &&  i < s.length() - 1)
    suffixe=s.substring(i+1).toLowerCase();
    return suffixe!=null&&appartient(suffixe);
}
    
     boolean appartient( String suffixe ){
      for( int i = 0; i<lesSuffixes.length; ++i)
         if(suffixe.equals(lesSuffixes[i]))
            return true;
         return false;
   }

    @Override
    public String getDescription() {
        return laDescription;
    }
    
    
    
}
