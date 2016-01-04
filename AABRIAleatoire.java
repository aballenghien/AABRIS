import Class.Arbre;
import Class.GrandArbre;


public class AABRIAleatoire {
	
	// générer un arbre à partir d'un nombre de noeud p et d'une valeur maximum q
	public Arbre genererArbre(int p,int valMin, int valMax){
		Arbre unArbre = new Arbre();
		int min = valMax;
		int max = valMin;
		int valRacine = 0;
		for(int i=1; i<= p; i++){
			valRacine = valMin + (int)(Math.random() * (valMax - valMin));
			unArbre = insererValeur(valRacine, unArbre);
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
	
	
	// insérer une valeur dans l'arbre
	public Arbre insererValeur(int val, Arbre unArbre){
		if(unArbre.getRacine()==0){
			unArbre.setRacine(val);
		}else{
			if(val > unArbre.getRacine() && unArbre.getSag() != null){
				unArbre.setSag(insererValeur(val, unArbre.getSag()));
			}else if(val > unArbre.getRacine() && unArbre.getSag() == null){
				unArbre.setSag(new Arbre());
				unArbre.getSag().setRacine(val);
			}else if(val < unArbre.getRacine() && unArbre.getSad() != null){
				unArbre.setSad(insererValeur(val, unArbre.getSad()));
			}else if(val < unArbre.getRacine() && unArbre.getSad() == null){
				unArbre.setSad(new Arbre());
				unArbre.getSad().setRacine(val);
			}
		}
		return unArbre;
	}
	
	
	// généreer un arbre constitué de plusieurs arbre
	public GrandArbre genererGrandArbre(int p, int q){
		GrandArbre unGrandArbre = new GrandArbre();
		Arbre unArbre;
		int i;
		int nbNoeudArbre;
		int min = 1;
		int max = q;
		int valMin[] = new int[2];
		int valMax = q;
		int valeurChoisieMin;
		
		nbNoeudArbre = 1 + (int)(Math.random() * (p-1));
		unArbre = this.genererArbre(nbNoeudArbre,(q/2)-(q/p), (q/2)+(q/p));
		unGrandArbre = this.insererArbre(unArbre, unGrandArbre);
		min = unGrandArbre.getRacine().getMin();
		max = unGrandArbre.getRacine().getMax();
		
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
                    unArbre = this.genererArbre(nbNoeudArbre, valMin[valeurChoisieMin], valMax);                    
                    unGrandArbre = this.insererArbre(unArbre, unGrandArbre);
                    unArbre = new Arbre();
		}
		return unGrandArbre;
	}
	
	
	// insérer arbre dans grand arbre
	public GrandArbre insererArbre(Arbre unArbre,GrandArbre unGrandArbre){
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
