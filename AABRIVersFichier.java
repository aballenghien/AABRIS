import java.io.FileWriter;
import java.io.IOException;

import Class.Arbre;
import Class.GrandArbre;


public class AABRIVersFichier {

	
	public String construireLigne(Arbre unArbre){
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
			str += this.construireLigne(unArbre.getSag());
			str += this.construireLigne(unArbre.getSad());
		}		
		return str;
	}


	public void ecrireFichier(GrandArbre unGrandArbre, FileWriter fichier) {
		if(unGrandArbre != null){
			String ligne = "";
			ligne = this.construireLigne(unGrandArbre.getRacine());
			ligne += "\n";
			try {
				fichier.write(ligne);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.ecrireFichier(unGrandArbre.getSag(), fichier);
			this.ecrireFichier(unGrandArbre.getSad(), fichier);
		}
	}
		
	public void afficherArbre(GrandArbre unGrandArbre){
		if(unGrandArbre != null){
			String ligne = "";
			ligne = this.construireLigne(unGrandArbre.getRacine());
			ligne += "\n";
			System.out.print(ligne);
			this.afficherArbre(unGrandArbre.getSag());
			this.afficherArbre(unGrandArbre.getSad());
		}
		
	}
		

	
	
}
