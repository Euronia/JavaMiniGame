

	public class ObjetEffect implements java.io.Serializable{
		private String name ;
		private Objet  obj1 ; 
		private Objet  obj2 ;
		private Objet  result ; 
		private String description ; 


	public ObjetEffect ( Objet obj1 , Objet obj2 , Objet result , String description ) 	
		{
				this.name = (obj1.getNom() +"and"+ obj2.getNom()) ;  				
				this.obj1 = obj1 ; 
				this.obj2 = obj2 ; 	
				this.result = result ; 
				this.description = description ; 
		}	

	public Objet getResult () 
		{
			System.out.println(this.description) ; 
			return this.result ; 
		} 
				
}	
