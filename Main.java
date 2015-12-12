import Class.Arbre;
import Class.GrandArbre;
import java.io.*;
import java.util.ArrayList;

public class Main {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                // constantes 
                final String EMPLACEMENT_FICHIER = "C:\\Users\\Audrey\\Documents\\IMPORTANT\\UNIVERSITE\\Cours\\Master 1\\Complément en algorithme\\Projet AABRIS\\src\\"; 
                
                //variables             
		String fichier =EMPLACEMENT_FICHIER+"arbre.txt";
		String tabLigne[];
		String tabValeur[];
		Arbre unArbre;
		GrandArbre unGrandArbre;
		ArrayList tabArbres;
		
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			tabArbres = new ArrayList();
			unGrandArbre = new GrandArbre();
			while ((ligne=br.readLine())!=null){
				unArbre = new Arbre();
				tabLigne = ligne.split(";");
				unArbre.setMin(Integer.parseInt((tabLigne[0].split(":"))[0]));
				unArbre.setMax(Integer.parseInt((tabLigne[0].split(":"))[1]));
				tabValeur = (tabLigne[1]).split(":");
				unArbre = construireArbre(tabValeur, 0, tabValeur.length-1, unArbre);
				System.out.println(unArbre.toString());
				tabArbres.add(unArbre);
			}
			br.close(); 
			construireGrandArbre(tabArbres, 0, tabArbres.size()-1, unGrandArbre);
			System.out.println(unGrandArbre.toString());
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}

	}
	
	public static Arbre construireArbre (String tabValeur[], int indiceMin, int indiceMax, Arbre unArbre){
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
				unArbre.setSag(construireArbre(tabValeur, indiceMin+1, max, new Arbre()));
			}else{
				unArbre.setSag(construireArbre(tabValeur, indiceMin, max, null));
			}
			if (indiceMin < indiceMax && indiceMax >= max+1){
				unArbre.setSad(construireArbre(tabValeur, max+1, indiceMax, new Arbre()));
			}else{
				unArbre.setSad(construireArbre(tabValeur, max, indiceMax, null));
			}
				
		}
		return unArbre;
	}
	
	public static GrandArbre construireGrandArbre (ArrayList tabArbres, int indiceMin, int indiceMax, GrandArbre unGrandArbre){
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
				unGrandArbre.setSag(construireGrandArbre(tabArbres, indiceMin+1, max, new GrandArbre()));
			}else{
				unGrandArbre.setSag(construireGrandArbre(tabArbres, indiceMin, max, null));
			}
			if (indiceMin < indiceMax && indiceMax >= max+1){
				unGrandArbre.setSad(construireGrandArbre(tabArbres, max+1, indiceMax, new GrandArbre()));
			}else{
				unGrandArbre.setSad(construireGrandArbre(tabArbres, max, indiceMax, null));
			}
				
		}
		return unGrandArbre;
	}

}
