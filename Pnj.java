import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


	public class Pnj implements java.io.Serializable {
			private List<String> parole ; // 0 - Phrase d'acceuil , 1 - Phrase "menu" , puis reponses 
			
			
	public Pnj (   String menu )
		{		
			this.parole = new ArrayList<String>() ;
			this.parole.add(menu); 
		}
		
	public void ajouterParole (String talk) 
		{
			parole.add(talk);
		}
	
	public void parler ()
		{
			int talk = 1;
			int nb_paroles = this.parole.size() - 1 ;
			Scanner scanner = new Scanner(System.in);
			while ( talk != 0 ) 
			{
				System.out.printf("%s" ,parole.get(0)); // c-a-d le menu
				talk = scanner.nextInt();
				if (talk > nb_paroles  ) 
				{
					System.out.printf ("I didn't understand what you just said");
				}
				else
				{
					System.out.printf ("%s\n", parole.get(talk)) ; 
				}
			}
			System.out.println("Goodbye") ; 
		}		
			
	}
			
	