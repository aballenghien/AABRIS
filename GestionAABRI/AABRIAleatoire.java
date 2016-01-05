package GestionAABRI;

import Class.Arbre;
import Class.GrandArbre;


public class AABRIAleatoire {
	
	/**
         * génère un arbre à partir d'un nombre de noeud p
         * d'une valeur minimale
         * et d'une valeur maximale
         * @param p
         * @param valMin
         * @param valMax
         * @return 
         */
	public static Arbre genererArbre(int p,int valMin, int valMax){
            Arbre unArbre = new Arbre();
            int min = valMax;
            int max = valMin;
            int valRacine = 0;
            for(int i=1; i<= p; i++){
                valRacine = valMin + (int)(Math.random() * (valMax - valMin));
                unArbre = ManipulationAABRI.insererValeurArbre(valRacine, unArbre);
                if(valRacine < min){
                    min = valRacine;
                }
                if(valRacine > max && valRacine <= valMax){
                    max = valRacine;
                }
            }
            unArbre.setMax(max);
            unArbre.setMin(min);
            return unArbre;
	}
	
	
	
	
	
	/**
         * généreer un arbre aléatoire constitué de plusieurs arbres
         * @param p
         * @param q
         * @return 
         */
	public static GrandArbre genererGrandArbre(int p, int q){
            GrandArbre unGrandArbre = new GrandArbre();
            Arbre unArbre;
            int i;
            int nbNoeudArbre;
            int min = 1;
            int max = q;
            int valMin[] = new int[2];
            int valMax = q;
            int valeurChoisieMin;

            // on génère un arbre qui sera la racine, c'est valeur sont à peu près au centre de 0 et p
            nbNoeudArbre = 1 + (int)(Math.random() * (p-1));
            unArbre = AABRIAleatoire.genererArbre(nbNoeudArbre,(q/2)-(q/p), (q/2)+(q/p));
            unGrandArbre = AABRIAleatoire.insererArbre(unArbre, unGrandArbre);
            min = unGrandArbre.getRacine().getMin();
            max = unGrandArbre.getRacine().getMax();

            // chaque arbre générer doit se placer à droite ou à gauche de la racine
            for(i = 1; i<  p; i++){                     
                nbNoeudArbre = 1 + (int)(Math.random() * p);
                valMin[0] = (int)(Math.random() * min);
                valMin[1] = max +1;
                valeurChoisieMin = (int)(Math.random()*2);
                if(valMin[valeurChoisieMin] < min){
                        valMax = min ;
                        min = valMin[valeurChoisieMin];
                }else if(valMin[valeurChoisieMin] > max){
                        valMax = valMin[valeurChoisieMin] + (int)(Math.random() * (q - valMin[valeurChoisieMin]));
                        max = valMax;
                }
                unArbre = AABRIAleatoire.genererArbre(nbNoeudArbre, valMin[valeurChoisieMin], valMax);                    
                unGrandArbre = AABRIAleatoire.insererArbre(unArbre, unGrandArbre);
                unArbre = new Arbre();
            }
            return unGrandArbre;
	}
	
	
	/**
         * insérer arbre dans grand arbre
         * @param unArbre
         * @param unGrandArbre
         * @return 
         */
	public static GrandArbre insererArbre(Arbre unArbre,GrandArbre unGrandArbre){
            if(unGrandArbre.getRacine().getRacine()==0){
                    unGrandArbre.setRacine(unArbre);
            }else{
                if(unArbre.getMin() > unGrandArbre.getRacine().getMax() && unGrandArbre.getSag() != null){
                    unGrandArbre.setSag(insererArbre(unArbre, unGrandArbre.getSag()));
                }else if(unArbre.getMin() > unGrandArbre.getRacine().getMax() && unGrandArbre.getSag() == null){
                    unGrandArbre.setSag(new GrandArbre());
                    unGrandArbre.getSag().setRacine(unArbre);
                }else if(unArbre.getMax() < unGrandArbre.getRacine().getMin() && unGrandArbre.getSad() != null){
                    unGrandArbre.setSad(insererArbre(unArbre, unGrandArbre.getSad()));
                }else if(unArbre.getMax() < unGrandArbre.getRacine().getMin() && unGrandArbre.getSad() == null){
                    unGrandArbre.setSad(new GrandArbre());
                    unGrandArbre.getSad().setRacine(unArbre);
                }
            }
            return unGrandArbre;
	}

}
