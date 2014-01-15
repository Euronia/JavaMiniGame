import java.util.HashMap;

	public class Objet implements java.io.Serializable { 
		private String nom ;
		private String description ;
		private HashMap<String,ObjetEffect> effets ; 
				
		public Objet ( String nom , String description ) 
		{ 
			this.nom = nom ;
			this.description = description ;  
			this.effets = new HashMap<String,ObjetEffect>(); 
		}

		public  String getNom ()
		{
			return this.nom ;
		} 
	
		public void examine() 
		{
			System.out.println(description) ;
		}

		public Objet use(String nom)
		{
			if (this.effets.containsKey(nom) == false )
			{
				return null ; 
			}
			else
			{
				return this.effets.get(nom).getResult() ;
			}
		}

		public boolean ObjetEffectIsHere (String nom)
		{
			return this.effets.containsKey(nom);
		}
			

		public void ajoutEffet (String nom ,ObjetEffect objE)
		{
			effets.put(nom,objE);
		} 

	} 
