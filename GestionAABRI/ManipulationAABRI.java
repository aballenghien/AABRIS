package GestionAABRI;


import Class.Arbre;
import Class.GrandArbre;
import Utilitaire.AABRIException;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
public class ManipulationAABRI {
    
    /**
     * Insérer un entier x dans un sous arbre de l'AABRI
     * @param AABRI
     * @param x
     * @return 
     */
    public static GrandArbre insererValeur(GrandArbre AABRI, int x) throws AABRIException{
        if(AABRI != null){
            if(x >= AABRI.getRacine().getMin() && x <= AABRI.getRacine().getMax()){
                AABRI.setRacine(insererValeurArbre(x, AABRI.getRacine()));
            }else if(x < AABRI.getRacine().getMin()){
                if(AABRI.getSag()!= null){
                    insererValeur(AABRI.getSag(), x);
                }else{
                    System.out.println("La valeur x est hors périmètre(trop petite)");
                    throw new AABRIException("la valeur x est hors périmètre(trop petite)");
                }
            }else if(x > AABRI.getRacine().getMax()){
                if(AABRI.getSad()!=null){
                  insererValeur(AABRI.getSad(),x);   
                }else{
                    System.out.println("La valeur x est hors périmètre (trop grande)");
                    throw new AABRIException("La valeur x est hors périmètre(trop grande)");
                }                            
            }
        }
        return AABRI;
    }
    
    public static GrandArbre supprimerValeur(GrandArbre AABRI, int x) throws AABRIException{
        if (AABRI != null){
            if(x >= AABRI.getRacine().getMin() && x<= AABRI.getRacine().getMax()){
                AABRI.setRacine(supprimerValeurArbre(AABRI.getRacine(),x));
            }else if(x < AABRI.getRacine().getMin()){
                if(AABRI.getSag()!= null){
                    supprimerValeur(AABRI.getSag(), x);
                }else{
                    System.out.println("la valeur x est hors périmètre(trop petite)");
                    throw new AABRIException("la valeur x est hors périmètre(trop petite)");
                }
            }else if(x > AABRI.getRacine().getMax()){
                if(AABRI.getSad()!=null){
                  supprimerValeur(AABRI.getSad(),x);   
                }else{
                    System.out.println("la valeur x est hors périmètre (trop grande)");
                    throw new AABRIException("la valeur x est hors périmètre(trop petite)");
                }                            
            }
        }
        return AABRI;
    }
    
    public static Arbre supprimerValeurArbre(Arbre unArbre, int x) throws AABRIException{
        int racine;
        if (unArbre != null){
            if (x == unArbre.getRacine()){
                racine = 0;
                if (unArbre.getSad()!= null){
                    racine = rechercherPlusGrandeValeur(unArbre.getSad(), -1);
                }else if(unArbre.getSag()!= null){
                    racine = rechercherPlusGrandeValeur(unArbre.getSag(), -1);                    
                }
                unArbre.setRacine(racine);
                supprimerValeurArbre(unArbre.getSad(), racine);
            }else{
                System.out.println("La valeur que vous rechercher n'existe pas");
                throw new AABRIException("La valeur que vous rechercher n'existe pas");
            }
        }
        return unArbre;
    }
    
    /**
     * Recherche la plus grande valeur du sous arbre droit
     * @param unArbre
     * @param val
     * @return 
     */
    public static int rechercherPlusGrandeValeur(Arbre unArbre, int val){
        if (unArbre != null){
            val = unArbre.getRacine();
            while(rechercherPlusGrandeValeur(unArbre.getSad(), val) > val && unArbre.getSad()!= null){
                val = rechercherPlusGrandeValeur(unArbre.getSad(), val);
            }
        }
        return val;
    }
    
    /**
         * insérer une valeur dans l'arbre
         * @param val
         * @param unArbre
         * @return 
         */
	public static Arbre insererValeurArbre(int val, Arbre unArbre) throws AABRIException{
            if(unArbre.getRacine()==0){
                    unArbre.setRacine(val);
            }else{
                if(val > unArbre.getRacine() && unArbre.getSag() != null){
                    unArbre.setSag(insererValeurArbre(val, unArbre.getSag()));
                }else if(val > unArbre.getRacine() && unArbre.getSag() == null){
                    unArbre.setSag(new Arbre());
                    unArbre.getSag().setRacine(val);
                }else if(val < unArbre.getRacine() && unArbre.getSad() != null){
                    unArbre.setSad(insererValeurArbre(val, unArbre.getSad()));
                }else if(val < unArbre.getRacine() && unArbre.getSad() == null){
                    unArbre.setSad(new Arbre());
                    unArbre.getSad().setRacine(val);
                }else if(val == unArbre.getRacine()){
                    System.out.println("la valeur existe déjà dans l'arbre");
                    throw new AABRIException("la valeur existe déjà dans l'arbre");
                }
            }
            return unArbre;
	}
    
   /**
    * Retourne un tableau d'entier résultat d'un parours infixe d'un arbre
    * @param unArbre
    * @return 
    */     
    public static ArrayList ArbreToTab(Arbre unArbre){
        ArrayList tabVal = new ArrayList();
        if (unArbre != null){
            tabVal.addAll(ArbreToTab(unArbre.getSag()));
            tabVal.add(unArbre.getRacine());
            tabVal.addAll(ArbreToTab(unArbre.getSad()));
        }
        return tabVal;
        
    }
    
    /**
     * Retourne un tableau d'arbre, résultat d'un parcours infixe d'un AABRI
     * @param unGrandArbre
     * @return 
     */
    public static ArrayList GrandArbreToTab(GrandArbre unGrandArbre){
        ArrayList tabArbre = new ArrayList();
        if (unGrandArbre != null){
            tabArbre.addAll(GrandArbreToTab(unGrandArbre.getSag()));
            tabArbre.add(unGrandArbre.getRacine());
            tabArbre.addAll(GrandArbreToTab(unGrandArbre.getSad()));
        }
        return tabArbre;
    }
    
}
