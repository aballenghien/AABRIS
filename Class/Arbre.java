package Class;

public class Arbre {
	
	private int racine;
	private Arbre sag;
	private Arbre sad;
	int min;
	int max;
	
	public Arbre(){
		this.racine = 0;
		this.min = 0;
		this.max = 0;
	}
	
	public int getRacine(){
		return this.racine;
	}
	
	public Arbre getSag (){
		return this.sag;
	}
	
	public Arbre getSad (){
		return this.sad;
	}
	
	public int getMin(){
		return this.min;
	}
	
	public int getMax(){
		return this.max;
	}
	
	public void setRacine (int racine){
		this.racine = racine;
	}
	
	public void setSag (Arbre sag){
		this.sag = sag;
	}
	
	public void setSad (Arbre sad){
		this.sad = sad;
	}
	
	public void setMin (int min){
		this.min = min;
	}
	
	public void setMax (int max){
		this.max = max;
	}
	
	public String toString(){
		String result;
		result = "Arbre:{";
		if (this.min > 0){
			result += "m : "+this.min+ ", M : "+this.max;
		}
		result += "racine : "+ this.racine;
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


