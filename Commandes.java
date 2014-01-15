
		public enum Commandes  {
					GO , 
					HELP , 
					LOOK , 
					TAKE ,
					QUIT , 
					EXITS , 
					WHERE , 
					INVENTORY ,
					SAVE,
                                        LOAD,
					USE,
                                        RESOLVE,
					TALK;

		public String commande () 
		{
			return this.toString().toLowerCase() ; 
		}

	}



