import java.util.ArrayList;

	public class Exit implements java.io.Serializable
	{ 
		protected Place lieuArrivee ; 

		public Exit (Place lieu) 
		{
			this.lieuArrivee = lieu ;   
		} 

		public Place getLieu () 
		{ 
			return this.lieuArrivee ; 
		} 	

		public boolean passer (Heros perso) 
		{
			return true ; 
		}
	

}
