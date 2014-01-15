import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


	public class Place implements java.io.Serializable { 
		private String nom ; 
		private Map <String,Exit> sorties; 
		private String description ; 
		private List<Objet> inventaire ; 
		private Pnj pnj ; 
                private Enigme enigme ;

		public Place (String nom , String description )	
		{ 
			this.nom = nom ; 
			this.sorties = new HashMap<String,Exit>() ;
			this.description=description; 
			this.inventaire= new ArrayList<Objet>() ; 
		} 		
		
                /*public Place (String nom , String description , Pnj pnj)	
		{ 
			this.nom = nom ; 
			this.sorties = new HashMap<String,Exit>() ;
			this.description=description; 
			this.inventaire= new ArrayList<Objet>() ; 
			this.pnj = pnj ; 
		} */
                

		public void ajoutSortie (String nom ,Exit sortie)
		{
			sorties.put(nom,sortie);
		} ;

		public void afficheSorties () 
		{
			for (String mapKey : sorties.keySet()) 
			{
	 			 System.out.println(mapKey);				
			}		
		}
                
                
		public Exit getSortie (String nom) 
		{	
			if (this.sorties.get(nom) != null ) 			
				return this.sorties.get(nom); 	
			else 
				return null ; 
		}
		
		public String getNom () 
		{ 
			return this.nom ;
		} 

		public boolean hasObjects () // a tester 
		{
			return this.inventaire.isEmpty();
		}
		
		public void descriptObjets () 
		{
                        if (inventaire.size() == 0)
                        {
                            System.out.println("There are no items in this place .");
                        }
                        else
                        {
                            System.out.printf(" You can see : ") ;
                            int i ;
                            for ( i=0 ; i<inventaire.size() ; i++ ) 
                            {
                                    System.out.printf("%s",this.inventaire.get(i).getNom() ) ;
                            }
                            System.out.printf("\n") ;
                        }
		}
		
		public void afficheDescription () 
		{
			System.out.println(this.description);
			descriptObjets();
                        if (enigmeIsHere())
                        {
                            System.out.println("There is an Enigma Machina in this room");
                        }
		}
	
		public void ajoutObjet (Objet obj)
		{
			inventaire.add(obj); 
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
		
		public Objet getObjet (String obj)
		{
			if (this.objetIsHere(obj)) 	// test deja present dans Heros.ramasser()
			{
				int i ;
				for ( i=0 ; i<inventaire.size() ; i++ ) 
				{
					if (inventaire.get(i).getNom().equals(obj) ) 
					{ 
					return inventaire.get(i) ;
					}
				}
			}
				return null ; 
		}
                
                public void ajoutPnj ( Pnj pnj)
                {
                    this.pnj = pnj ;                 
                }

		public boolean pnjIsHere ()
		{
			return this.pnj != null ;
		}
		
		public Pnj getPnj ()
		{
			return this.pnj ;
		}
		
                public void ajoutEnigme ( Enigme n)
                {
                   this.enigme = n; 
                }
                
                public boolean enigmeIsHere ()
                {
                        return this.enigme != null ;
                }
                
                public Enigme getEnigme ()
                {
                    return this.enigme ;
                }
} 
 



