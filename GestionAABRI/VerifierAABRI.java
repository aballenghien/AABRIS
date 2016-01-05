package GestionAABRI;


import Class.Arbre;
import Class.GrandArbre;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
public class VerifierAABRI {
    
    public static boolean isAABRI(GrandArbre unGrandArbre){
        boolean rst = true;
        ArrayList tabArbreGrandArbre = new ArrayList();
        tabArbreGrandArbre = ManipulationAABRI.GrandArbreToTab(unGrandArbre);
        int i =0;
        int valMaxSauv = ((Arbre)tabArbreGrandArbre.get(i)).getMax();
        if (!isABRI((Arbre)tabArbreGrandArbre.get(i))){
            rst = false;
        }
        i++;
        while(i < tabArbreGrandArbre.size() && rst == true){
            if (((Arbre)tabArbreGrandArbre.get(i)).getMin() <= valMaxSauv || !isABRI((Arbre)tabArbreGrandArbre.get(i)) ){
                rst = false;
            }
            i++;
        }
        return rst;
    }
    
    public static boolean isABRI(Arbre unArbre){
        boolean rst  = true;
        ArrayList tabValArbre = new ArrayList();
        tabValArbre = ManipulationAABRI.ArbreToTab(unArbre);
        int i = 0;
        int valSauv =(int) tabValArbre.get(i);
        i++;
        while (i < tabValArbre.size() && rst == true){
            if (valSauv < (int) tabValArbre.get(i)){
                rst = false;
            }
            i++;
        }      
        return rst;
    }  
    
}
