package GestionAABRI;

import java.io.FileWriter;
import java.io.IOException;

import Class.Arbre;
import Class.GrandArbre;


public class AABRIVersFichier {

	
        /**
         * écrit une ligne à partir d'un arbre
         * @param unArbre
         * @return 
         */
    public static String construireLigne(Arbre unArbre){
        String str = "";
        if(unArbre != null){
            if(unArbre.getMin() >0){
                str+= unArbre.getMin();
                str += ":";
                str+= unArbre.getMax();
                str += ";";
            }
            str += unArbre.getRacine();
            str += ":";
            str += construireLigne(unArbre.getSag());
            str += construireLigne(unArbre.getSad());
        }		
        return str;
    }


        /**
         * Ecrit dans un fichier sous forme de ligne le contenu d'un grand Arbre
         * @param unGrandArbre
         * @param fichier 
         */
	public static void ecrireFichier(GrandArbre unGrandArbre, FileWriter fichier) {
            if(unGrandArbre != null){
                String ligne = "";
                ligne = construireLigne(unGrandArbre.getRacine());
                ligne += "\n";
                try {
                    fichier.write(ligne);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ecrireFichier(unGrandArbre.getSag(), fichier);
                ecrireFichier(unGrandArbre.getSad(), fichier);
            }
	}
	
        /**
         * affiche à l'écran sous forme de ligne, le contenu d'un grand Arbre
         * @param unGrandArbre 
         */
	public static String afficherArbre(GrandArbre unGrandArbre){
            String ligne = "";
            if(unGrandArbre != null){
                ligne = construireLigne(unGrandArbre.getRacine());
                ligne += "\n";
                System.out.print(ligne);
                afficherArbre(unGrandArbre.getSag());
                afficherArbre(unGrandArbre.getSad());
            }
            return ligne;
		
	}
		

	
	
}
