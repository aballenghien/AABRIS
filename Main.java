import Class.Arbre;
import Class.GrandArbre;
import java.io.*;

public class Main {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
                String Emplacement = "C:\\Users\\Audrey\\Documents\\DOCUMENTS\\ETUDES\\UNIVERSITE\\Cours\\Master 1\\Complément en algorithme\\Projet AABRIS\\src\\";
		String fichier = Emplacement+"arbre.txt";
		GrandArbre unGrandArbre;
		Arbre unArbre;
                VerifierAABRI vAABRI = new VerifierAABRI();
		
		FichierVersAABRI FVA = new FichierVersAABRI();
		unGrandArbre = FVA.lireFichier(fichier);
		System.out.println("Fichier vers arbre :");
		System.out.println(unGrandArbre);
		
		File fichier2 = new File(Emplacement+"arbre2.txt");
		FileWriter fw = new FileWriter(fichier2);
		AABRIVersFichier AVF = new AABRIVersFichier();
		AVF.ecrireFichier(unGrandArbre, fw);
		fw.close();		
		AVF.afficherArbre(unGrandArbre); 
                System.out.println("Insertion de la valeur 1");
                unGrandArbre = ManipulationAABRI.insererValeur(unGrandArbre, 1);
                AVF.afficherArbre(unGrandArbre); 
                System.out.println("Insertion de la valeur 111");
                unGrandArbre = ManipulationAABRI.insererValeur(unGrandArbre, 111);
                AVF.afficherArbre(unGrandArbre); 
                System.out.println("Suppression de la valeur 80");
                unGrandArbre = ManipulationAABRI.supprimerValeur(unGrandArbre,80);
                AVF.afficherArbre(unGrandArbre); 
                
                if(vAABRI.isAABRI(unGrandArbre)){
                    System.out.println("L'arbre généré est bien un AABRI");
                }else{
                    System.out.println("L'arbre généré n'est pas un AABRI"); 
                }
		
		/*System.out.println("Arbre généré:");
		AABRIAleatoire AA = new AABRIAleatoire();
		unGrandArbre = AA.genererGrandArbre(5, 100);
		AVF.afficherArbre(unGrandArbre);
                
                if(vAABRI.isAABRI(unGrandArbre)){
                    System.out.println("L'arbre généré est bien un AABRI");
                }else{
                    System.out.println("L'arbre généré n'est pas un AABRI"); 
                }*/
                
                
                
		
	}
		
		
		
			
	

}
