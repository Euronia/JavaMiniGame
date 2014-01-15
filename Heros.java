
import java.util.ArrayList;

	public class Heros implements java.io.Serializable
	{
		private Place lieuActuel ; 
		private ArrayList<Objet> inventaire ; 

		public Heros (Place lieu) 
		{
			this.lieuActuel = lieu ; 
			this.inventaire = new ArrayList<Objet> () ;
		} 

		public void deplacer (String lieu ) 
		{
			if ( this.lieuActuel.getSortie(lieu) == null) 
				System.out.println("Destination unknown");
			else if (this.lieuActuel.getSortie(lieu).passer(this) == false )
				System.out.println("The door is locked");				
			else
				this.lieuActuel = this.lieuActuel.getSortie(lieu).getLieu() ;
		} 

		public void whereAmI () 
		{
			System.out.println(this.lieuActuel.getNom()) ; 
		}

		public ArrayList<Objet> getInventaire () 
		{
			return this.inventaire ;
		}

		public Place getLieuActuel () 
		{
			return this.lieuActuel ; 
		}

		public void deleteObjet (String obj)
		{
			int i ;
			for ( i=0 ; i<inventaire.size() ; i++ ) 
			{
				if (inventaire.get(i).getNom().equals(obj) ) 
					{ 
					inventaire.remove(inventaire.get(i)) ; 
					break ; 
					}
			}
		}		

		public void ramasser (String obj) 
		{
			if (this.lieuActuel.objetIsHere(obj))
			{
				this.inventaire.add(this.lieuActuel.getObjet(obj));
				this.lieuActuel.deleteObjet(obj);
			}
			else
			{
				System.out.println("This object doesn't exist or isn't in this place");	
			}
		}
                
                public void ajoutObjet (Objet obj)
                {
                    this.inventaire.add(obj) ;
                }
	
		public void affichInventaire ()
		{
			if (inventaire.size() != 0 ) 
				{
				System.out.println("=== Inventory ===") ;
				int i ; 
				for (i=0;i<inventaire.size();i++) 	
					{
					System.out.println("- "+inventaire.get(i).getNom()) ;
					}
					System.out.println("=================") ;
				}
			else
				System.out.println("Empty inventory") ;

		}

		public boolean objetIsHere (String obj)
		{
			
				int i ;
				for ( i=0 ; i<this.inventaire.size() ; i++ ) 
				{
					if (this.inventaire.get(i).getNom().equals(obj) ) 
						{ 
						return true ;
						}
				}		
			return false ;		
			
		}

		public void examine (String obj) 
		{
			
				int i ;
				for ( i=0 ; i<this.inventaire.size() ; i++ ) 
				{
					if (this.inventaire.get(i).getNom().equals(obj) ) 
						{			
						this.inventaire.get(i).examine() ;	
						}
				}
		}

		public void use (String obj , String obj2)
		{ 
		
			int i ; 
				for ( i=0 ; i<this.inventaire.size() ; i++ ) 
				{
					if (this.inventaire.get(i).getNom().equals(obj) ) 
						{			
								if (this.inventaire.get(i).ObjetEffectIsHere(obj2) ) 	
								{
									this.inventaire.add(this.inventaire.get(i).use(obj2)) ; 
									this.deleteObjet(obj) ;
									this.deleteObjet(obj2) ;
								}		
						}
				}			
			
		}

}
