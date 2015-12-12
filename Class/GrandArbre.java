package Class;

public class GrandArbre {
	
	private Arbre racine;
	private GrandArbre sag;
	private GrandArbre sad;
	
	public GrandArbre(){
		this.racine = new Arbre();
	}
	
	public GrandArbre getSag (){
		return this.sag;
	}
	
	public GrandArbre getSad (){
		return this.sad;
	}
	
	public Arbre getRacine(){
		return this.racine;
	}
	
	public void setSag (GrandArbre sag){
		this.sag = sag;
	}
	
	public void setSad (GrandArbre sad){
		this.sad = sad;
	}
	
	public void setRacine(Arbre racine){
		this.racine = racine;
	}
	
	public String toString(){
		String result;
		result = "GrandArbre:{racine : "+ this.racine;
		if (this.sag != null){
			result += ", sag : "+this.sag;
		}
		if (this.sad != null){
			result += ", sad:"+this.sad+"}";
		}
		result += " }";
		return result;
	}
}
