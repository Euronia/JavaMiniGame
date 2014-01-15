import java.util.ArrayList;

	public class ExitLocked extends Exit 
	{ 
		private boolean open ; 
		private Objet opener ;
		
		public ExitLocked(Objet obj,Place lieu) 
		{
			super(lieu);  
			this.open = false ; 
			this.opener = obj ; 
		}

		@Override public boolean passer (Heros perso) 
		{

			if (perso.getInventaire().contains(this.opener) ) 
				{ 
				return true ;
				}					
			return false ;
		}
	}
