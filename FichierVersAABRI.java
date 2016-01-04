import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Class.Arbre;
import Class.GrandArbre;


public class FichierVersAABRI {
	
    /**
     * Lit le fichier d'entrée et à partir des lignes, constitue un aabri
     * @param fichier
     * @return 
     */
	public GrandArbre lireFichier(String fichier){
            String tabLigne[];
            String tabValeur[];
            Arbre unArbre;
            GrandArbre unGrandArbre ;
            ArrayList tabArbres;		

            unGrandArbre = new GrandArbre();


            //lecture du fichier texte	
            try{
                InputStream ips=new FileInputStream(fichier); 
                InputStreamReader ipsr=new InputStreamReader(ips);
                BufferedReader br=new BufferedReader(ipsr);
                String ligne;
                tabArbres = new ArrayList();
                while ((ligne=br.readLine())!=null){
                    unArbre = new Arbre();
                    tabLigne = ligne.split(";");
                    unArbre.setMin(Integer.parseInt((tabLigne[0].split(":"))[0]));
                    unArbre.setMax(Integer.parseInt((tabLigne[0].split(":"))[1]));
                    tabValeur = (tabLigne[1]).split(":");
                    unArbre = this.construireArbre(tabValeur, 0, tabValeur.length-1, unArbre);
                    tabArbres.add(unArbre);
                }
                br.close(); 
                this.construireGrandArbre(tabArbres, 0, tabArbres.size()-1, unGrandArbre);
            }		
            catch (Exception e){
                    System.out.println(e.toString());
            }

            return unGrandArbre;
		
	}
	
        /**
         * Construit un arbre à partir d'un tableau de valeur
         * @param tabValeur
         * @param indiceMin
         * @param indiceMax
         * @param unArbre
         * @return 
         */
	public Arbre construireArbre (String tabValeur[], int indiceMin, int indiceMax, Arbre unArbre){
            int i;
            int max;
            int valeur;	
            if (unArbre != null){
                valeur = Integer.parseInt(tabValeur[indiceMin]);
                i = indiceMin;
                max = i;
                unArbre.setRacine(valeur);		
                while(i< indiceMax && Integer.parseInt(tabValeur[i+1]) > valeur){
                        i++;
                        max = i;					
                }
                if(indiceMin < indiceMax && max >= indiceMin+1){
                        unArbre.setSag(this.construireArbre(tabValeur, indiceMin+1, max, new Arbre()));
                }else{
                        unArbre.setSag(this.construireArbre(tabValeur, indiceMin, max, null));
                }
                if (indiceMin < indiceMax && indiceMax >= max+1){
                        unArbre.setSad(this.construireArbre(tabValeur, max+1, indiceMax, new Arbre()));
                }else{
                        unArbre.setSad(this.construireArbre(tabValeur, max, indiceMax, null));
                }

            }
            return unArbre;
	}
	
        /**
         * Construire un grand arbre à partir d'un tableau d'arbre 
         * @param tabArbres
         * @param indiceMin
         * @param indiceMax
         * @param unGrandArbre
         * @return 
         */
	public GrandArbre construireGrandArbre (ArrayList tabArbres, int indiceMin, int indiceMax, GrandArbre unGrandArbre){
            int i;
            int max;
            Arbre racine;	
            if (unGrandArbre != null){
                racine = (Arbre)tabArbres.get(indiceMin);
                i = indiceMin;
                max = i;
                unGrandArbre.setRacine(racine);		
                while( i < indiceMax &&  ((Arbre)tabArbres.get(i+1)).getMax() < racine.getMin()){
                    i++;
                    max = i;					
                }
                if(indiceMin < indiceMax && max >= indiceMin+1){
                    unGrandArbre.setSag(this.construireGrandArbre(tabArbres, indiceMin+1, max, new GrandArbre()));
                }else{
                    unGrandArbre.setSag(this.construireGrandArbre(tabArbres, indiceMin, max, null));
                }
                if (indiceMin < indiceMax && indiceMax >= max+1){
                    unGrandArbre.setSad(this.construireGrandArbre(tabArbres, max+1, indiceMax, new GrandArbre()));
                }else{
                    unGrandArbre.setSad(this.construireGrandArbre(tabArbres, max, indiceMax, null));
                }

            }
            return unGrandArbre;
	}

}
