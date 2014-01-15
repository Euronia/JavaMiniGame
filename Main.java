import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

	public class Main {


		public static void help ()
		{
		System.out.printf (Commandes.QUIT.commande()+" -- Makes you quit the game\n");
		System.out.printf (Commandes.GO.commande()+" -- Say in which place you want to go (ex: go hall)\n");
		System.out.printf (Commandes.WHERE.commande()+" -- Tells you where you are\n");
		System.out.printf (Commandes.EXITS.commande()+" -- Gives you all the exits at your current location\n");
		System.out.printf (Commandes.LOOK.commande()+" -- Gives you a description of your current location or of an item given as a parameter\n");
		System.out.printf (Commandes.INVENTORY.commande()+" -- Show your inventory (with fancy graphics)\n");
		System.out.printf (Commandes.TAKE.commande()+" -- Allows you to take an object (ex : take key)\n");
                System.out.printf (Commandes.SAVE.commande()+" -- Allows you to save your game\n");
                System.out.printf (Commandes.LOAD.commande()+" -- Allows you to save your game\n");
                System.out.printf (Commandes.TALK.commande()+" -- Talk with Frank the ghost\n");
                System.out.printf (Commandes.USE.commande()+" -- Use an item on another item ( ex: use key box)\n");
                System.out.printf (Commandes.RESOLVE.commande()+" -- Try the Enigma\n");

		}




		public static void main (String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
		{
			Scanner scanner = new Scanner(System.in) ;
                        boolean victory = false ;
								// INIT //

								// OBJETS //
						Objet bronze_key = new Objet("bronze_key","A small bronze key") ;
						Objet bronze_box = new Objet("bronze_box","A large bronze box with a keyhole. It looks like it's locked.")  ;
                                                Objet golden_key = new Objet("golden_key","A magnificient golden key with a rupee inside") ;
                                                Objet golden_box = new Objet("golden_box","A small golden box with a keyhole. Looks like it's locked.")  ;
                                                Objet medal_friend = new Objet("medal_friend","A small medal with a picture of a man holding a contract") ;
                                                Objet medal_wife = new Objet("medal_wife","A small medal with a picture of a family") ;
                                                Objet medal_train = new Objet("medal_train","A small medal with a picture of a train") ;
                                                Objet bureau_key  = new Objet("bureau_key","A key with a paper attached to itr.On the paper , 'Bureau' is written") ;
                                                Objet frank_room_key  = new Objet("frank_room_key","A key with a paper attached to it.On the paper , 'My bedroom' is written") ;
						Objet friend_room_key  = new Objet("friend_room_key","A key with a paper attached to it.On the paper , 'Friend's bedroom is written") ;
						ObjetEffect bronze_keyandbox = new ObjetEffect(bronze_key,bronze_box,golden_box,"The key fits. You open the box and find a golden box inside .") ;
						bronze_key.ajoutEffet ("bronze_box",bronze_keyandbox) ;
                                                ObjetEffect golden_keyandbox = new ObjetEffect(golden_key,golden_box,friend_room_key,"The key fits. You open the box and find a key inside .") ;
						golden_key.ajoutEffet ("golden_box",golden_keyandbox) ;

                                                                // ENIGMES //
                                                Enigme enigme_caval = new EnigmeCavalier3("213","123",bureau_key);
                                                Enigme enigme_success = new Enigme7letters("5764231","1234567",medal_wife);
                                                Enigme enigme_switch = new EnigmeSwitch("111111","000000",frank_room_key);
                                                Enigme enigme_2_4 = new Enigme2et4("41352","12345",medal_friend);
                                                Enigme enigme_heure = new EnigmeHeure("1","1",medal_train);

								//  PNJ  //
                                                //==============================================================================================================//
						Pnj frank_hall = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
						frank_hall.ajouterParole("Here we are in the reception room of my manor, if you want to go to the treasure's\n" +
                                                                            "	room, you have to find the three amulets and put them into the three holes on the\n" +
                                                                            "	ground.\" He designates you the sceal on the ground with the amulets recipes.\n");
						frank_hall.ajouterParole("From this place, you can go to the banquet hall, or you can discover\n" +
                                                                            "	my art collection in the gallery. You can also go to the kitchen or\n" +
                                                                            "	to my office by passing through the corridor. You can go upstairs too.\n");
                                                //==============================================================================================================//
                                                Pnj frank_banquet = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_banquet.ajouterParole("Here is the banquet hall. Many famous people sat around this great table \n" +
                                                                            "like Mike Storgheim, the inventor of the steam locomotive or Fred Holder, the \n" +
                                                                            "principal auctioneer of the local railway company.");
						frank_banquet.ajouterParole(" From here you can go to the kitchen or to the reception hall");
                                                //==============================================================================================================//
                                                Pnj frank_art_gallery = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_art_gallery.ajouterParole("Look at all this masterpieces ! We are in my personal art gallery. All\n" +
                                                                                " these pictures and sculptures are gifts from famous people and artists. Some of \n" +
                                                                                " them are very old so please don't touch !");
						frank_art_gallery.ajouterParole(" From here we can go to my personnal office or to the reception hall.");
                                                //==============================================================================================================//
                                                Pnj frank_corridor1 = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_corridor1.ajouterParole("A simple corridor.");
						frank_corridor1.ajouterParole(" You can go to the kitchen, to my office or to the reception hall.");
                                                //==============================================================================================================//
                                                Pnj frank_kitchen = new Pnj ("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_kitchen.ajouterParole("Here we are in my kitchen. As you can see, there are many fruits and spices \n" +
                                                                            "from all the parts of the worlds. But we are not here for this. He walks to the \n" +
                                                                            "dresser, and show you a little machine. This is one of my enigma machinas. \n" +
                                                                            "Solve it and my bureau's key will be yours !");
                                                frank_kitchen.ajouterParole("From here you can go to the banquet hall or the corridor");
                                                //==============================================================================================================//
                                                Pnj frank_bureau = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_bureau.ajouterParole("Here we are in my office. I spent many time of my life here planning meetings, \n" +
                                                                            "analyzing railway world market. Hard work is one of the secrets that made me \n"+
                                                                            "rich. And it's your turn now ! He shows you another enigma machinima in a \n"+
                                                                            "drawer. Solve it and you will earn one of my medal ! \n");
						frank_bureau.ajouterParole(" You can go to the corridor or the art gallery.");
                                                //==============================================================================================================//
                                                Pnj frank_corridor2 = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_corridor2.ajouterParole("These stairs were a mountain for an old man like me !");
						frank_corridor2.ajouterParole("So, from here you can go to the west wing of the manor or the east wing.");
                                                //==============================================================================================================//
                                                Pnj frank_east_wing = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_east_wing.ajouterParole("The east wing was reserved to me and my family.");
						frank_east_wing.ajouterParole("You can go to my personal bedroom or my child's bedroom.");
                                                //==============================================================================================================//
                                                Pnj frank_frank_bedroom = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_frank_bedroom.ajouterParole("This is my bedroom. I shared it with my wife until she died from\n" +
                                                                                    "	cancer. Since she died, I lost all motivation and nothing was important \n" +
                                                                                    "	to me. But when I found the amulet she offered me with a photography\n" +
                                                                                    "	of our family, I promised myself that I will be the best father for my son and I went\n" +
                                                                                    "	back to work like never before. Family is one of the secrets that made me rich.\n" +
                                                                                    "	And now, it's yout turn !\" He shows you a machinima on the bedside table\n" +
                                                                                    "	Solve this enigma and you will earn my family's amulet.\"");
						frank_frank_bedroom.ajouterParole("You can only go back to the east wing");
                                                //==============================================================================================================//
                                                Pnj frank_child_bedroom = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_child_bedroom.ajouterParole("Here is my child's bedroom. He died in a car accident. It almost destoyed me and he didn't\n" +
                                                                                    "helped my wife with her condition.  He walks to the\n" +
                                                                                    "cupboard, and shows you a little machine. This is one of my enigma machinimas." +
                                                                                    "If you find the solution of this enigma my bedroom's key will be yours !");
						frank_child_bedroom.ajouterParole("You can only go back to the east wing");
                                                //==============================================================================================================//
                                                Pnj frank_friend_bedroom = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_friend_bedroom.ajouterParole("This is the friends' bedroom. When I won my first contract, we " +
                                                                                    "organised a huge party here .On that night ,my friend offered me a medal with a photography " +
                                                                                    " of the contract signature. Friendship  is one of the secrets that " +
                                                                                    "made me rich. And now it's your turn !. He shows you another machina on the " +
                                                                                    "desk. Solve this enigma and you will earn my friends' medal.");
						frank_friend_bedroom.ajouterParole("You can only go back to the west wing");
                                                //==============================================================================================================//
                                                Pnj frank_bathroom = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_bathroom.ajouterParole("This is the bathroom. Please don't take a bath ! ");
						frank_bathroom.ajouterParole("You can only go back to the east wing");
                                                //==============================================================================================================//


                                                Pnj frank_west_wing = new Pnj("Is there anything you want to talk about ? \n 0-Quit \n1-This room \n2-Exits ? \n");
                                                frank_west_wing.ajouterParole("It's teh east wing");
						frank_west_wing.ajouterParole("You can go to the bathroom or the friends' bedroom");
								// PLACE //
						Place hall = new Place("hall","A big hall with stairs to access the 1st floor. \n They are many doors and a desk n  ext to the stairs. ");
						Place banquet = new Place("banquet","A big banquet room with a big table which got some unicorns on it");
						Place art_gallery = new Place("Art Gallery","A room with some paintings and sculptures");
						Place corridor1 = new Place("Rdc Corridor","A corridor");
						Place kitchen = new Place("Kitchen","A kitchen where there is food !");
						Place bureau = new Place("Bureau","A small place to work");
						Place corridor2 = new Place("1stFloor Corridor","The main corridor in the 1st floor");
						Place east_wing = new Place("1stFloor East Wing","The east wing of the 1st floor");
						Place west_wing = new Place("1stFloor West Wing","The west wing of the 1st floor");
						Place bathroom = new Place("1stFloor Bathroom","A simple bathroom");
						Place friend_bedroom = new Place("1stFloor friend bedroom","The red bedroom in the west wing of the 1st floor");
						Place frank_bedroom = new Place("1stFloor frank bedroom","The blue bedroom in the east wing of the 1st floor");
						Place child_bedroom = new Place("1stFloor child bedroom","The yellow bedroom in the east wing of the 1st floor");

								// EXITS //
						Exit TObanquet = new Exit (banquet);
						Exit TOcorridor1 = new Exit (corridor1);
						Exit TOart_gallery = new Exit (art_gallery);
						Exit TOcorridor2 = new Exit (corridor2) ;
						Exit TOhall = new Exit (hall);
						Exit TOkitchen = new Exit (kitchen);
						Exit TObureau = new ExitLocked (bureau_key,bureau);
						Exit TOeast_wing = new Exit (east_wing);
						Exit TOwest_wing = new Exit (west_wing);
						Exit TObathroom = new Exit (bathroom);
						Exit TOfriend_bedroom = new ExitLocked (friend_room_key,friend_bedroom);
						Exit TOfrank_bedroom = new ExitLocked (frank_room_key,frank_bedroom);
						Exit TOchild_bedroom = new Exit (child_bedroom);

								// HALL //
						hall.ajoutSortie("banquet",TObanquet);
						hall.ajoutSortie("corridor",TOcorridor1);
						hall.ajoutSortie("art_gallery",TOart_gallery);
						hall.ajoutSortie("1st_floor_corridor",TOcorridor2);
                                                hall.ajoutPnj(frank_hall);


								// BANQUET //
						banquet.ajoutSortie("hall",TOhall);
						banquet.ajoutSortie("kitchen",TOkitchen);
                                                banquet.ajoutObjet(bronze_box);
                                                banquet.ajoutPnj(frank_banquet);

								// KITCHEN //
						kitchen.ajoutSortie("corridor",TOcorridor1);
						kitchen.ajoutSortie("banquet",TObanquet);
                                                kitchen.ajoutEnigme(enigme_caval);
                                                kitchen.ajoutPnj(frank_kitchen);

								// RDC CORRIDOR //
						corridor1.ajoutSortie("hall",TOhall);
						corridor1.ajoutSortie("bureau",TObureau);
						corridor1.ajoutSortie("kitchen",TOkitchen);
                                                corridor1.ajoutPnj(frank_corridor1);

								// BUREAU //
						bureau.ajoutSortie("corridor",TOcorridor1);
						bureau.ajoutSortie("art_gallery",TOart_gallery);
						bureau.ajoutEnigme(enigme_heure) ;
                                                bureau.ajoutPnj(frank_bureau);

								// ART GALLERY //
						art_gallery.ajoutSortie("bureau",TObureau);
						art_gallery.ajoutSortie("hall",TOhall);
                                                art_gallery.ajoutObjet(bronze_key);
                                                art_gallery.ajoutPnj(frank_art_gallery);


								//1ST FLOOR CORRIDOR//
						corridor2.ajoutSortie("hall",TOhall);
						corridor2.ajoutSortie("east_wing",TOeast_wing) ;
						corridor2.ajoutSortie("west_wing",TOwest_wing) ;
                                                corridor2.ajoutPnj(frank_corridor2);

								//WEST_WING//
						west_wing.ajoutSortie("1st_floor_corridor",TOcorridor2);
						west_wing.ajoutSortie("blue_bedroom",TOfrank_bedroom);
						west_wing.ajoutSortie("yellow_bedroom",TOchild_bedroom);

                                                west_wing.ajoutPnj(frank_west_wing);

								//CHILD BEDROOM//
						child_bedroom.ajoutSortie("west_wing",TOwest_wing);

                                                child_bedroom.ajoutPnj(frank_child_bedroom);
                                                child_bedroom.ajoutEnigme(enigme_switch);

								//FRANK BEDROOM//
						frank_bedroom.ajoutSortie("west_wing",TOwest_wing);

                                                frank_bedroom.ajoutPnj(frank_frank_bedroom);

                                                frank_bedroom.ajoutEnigme(enigme_2_4);

								//EAST_WING//
						east_wing.ajoutSortie("1st_floor_corridor",TOcorridor2);
						east_wing.ajoutSortie("bathroom",TObathroom);
						east_wing.ajoutSortie("red_bedroom",TOfriend_bedroom);
                                                                                // EAST_WING PNJ //
                                                east_wing.ajoutPnj(frank_east_wing);

								//BATHROOM//
						bathroom.ajoutSortie("east_wing",TOeast_wing);
                                                bathroom.ajoutObjet(golden_key);

                                                bathroom.ajoutPnj(frank_bathroom);

								//FRIEND_BEDROOM//
						friend_bedroom.ajoutSortie("east_wing",TOeast_wing);
                                                friend_bedroom.ajoutPnj(frank_friend_bedroom);
                                                friend_bedroom.ajoutEnigme(enigme_success);
								// HEROS //

						Heros perso = new Heros(hall);


								// FIN INIT //
				System.out.printf("Welcome detective ! My name is Franck McFolter and I'm the lord of this manor.\n" +
                                                    "	Don't be scared, I'm not here to fear you or something like that.\n" +
                                                    "	I guess you are here to find my treasure.\n" +
                                                    "	But, I'm sure that you can find more if you have some brain.\n" +
                                                    "	During my life, I hid in these walls all the rest of my money and more.\n" +
                                                    "	But only clever people will be able to find it. I am here only to guide you in \n" +
                                                    "	this great place but you are the only one who can solve the enigmas who drive to\n" +
                                                    "	the treasure.Now stop talking, and let this extrordinary adventure begin !\n \n ") ;

			while (victory == false)
                        {

				System.out.printf ("\n\n You're in the "+ perso.getLieuActuel().getNom() + " \n \n ") ;
				String commande = scanner.nextLine() ;
				String mots[] = commande.split(" ") ;

				if (mots[0].equals(Commandes.QUIT.commande())||mots[0].equals("q"))
						break ;
				else if (mots[0].equals(Commandes.GO.commande()))
						{
						if (mots.length == 1)
							{
							System.out.println("Precise your destination");
							}
						else
							{
							perso.deplacer(mots[1]);
							}
						}
				else if (mots[0].equals(Commandes.WHERE.commande()))
						{
						perso.whereAmI();
						}
				else if (mots[0].equals(Commandes.EXITS.commande()))
						{
						perso.getLieuActuel().afficheSorties();
						}
				else if (mots[0].equals(Commandes.LOOK.commande()))
						{
                                                if (mots.length == 1)
                                                {
                                                    perso.getLieuActuel().afficheDescription();
                                                }
                                                else if (mots.length == 2)
                                                {
                                                    if (perso.objetIsHere(mots[1]) == false )
							{
							System.out.println("You don't have any objects which match this name in your inventory");
							}
                                                    else
							{
							perso.examine(mots[1]);
							}
                                                }
                                                else
                                                {
                                                    System.out.println("Wrong command");
                                                }
						}
				else if (mots[0].equals(Commandes.INVENTORY.commande()))
						{
						perso.affichInventaire();
						}
				else if (mots[0].equals(Commandes.TAKE.commande()))
						{
						if (mots.length == 1)
							{
							System.out.println("Precise what you wanna take");
							}
						else if (perso.getLieuActuel().objetIsHere(mots[1]) == false )
							{
							System.out.println("This object doesn't exist/or isn't here");
							}
						else
							{
							perso.ramasser(mots[1]);
							System.out.println(mots[1]+" taken");
							}
						}
				else if (mots[0].equals(Commandes.USE.commande()))
						{
						if (mots.length == 2)
							{
							System.out.println("use , use ,use");
							}
						else if (perso.objetIsHere(mots[1]) == false && perso.objetIsHere(mots[2]) == false )
							{
							System.out.println("You don't seem to have those objects");
							}
						else if (perso.objetIsHere(mots[1]) == false )
							{
							System.out.println("You don't seem to have the 1st object");
							}
						else if (perso.objetIsHere(mots[2]) == false )
							{
							System.out.println("You don't seem to have the 2nd object");
							}
						else
							{
						perso.use(mots[1],mots[2]);
							}
						}
				else if (mots[0].equals(Commandes.HELP.commande()))
						{
						help() ;
						}
				else if (mots[0].equals(Commandes.TALK.commande()))
						{
						if (perso.getLieuActuel().pnjIsHere() == false )
							{
							System.out.println ("There don't seem to be anyone to talk with");
							}
						else
							{
							perso.getLieuActuel().getPnj().parler() ;
							}
						}
                               else if (mots[0].equals(Commandes.RESOLVE.commande()))
						{
						if (perso.getLieuActuel().enigmeIsHere() == false )
							{
							System.out.println ("There don't seem to be an enigma to resolve");
							}
						else
							{
                                                            if (perso.getLieuActuel().getEnigme().isResolved())
                                                            {
                                                               System.out.println ("You already solved this enigma");
                                                            }
                                                            else
                                                            {
                                                               if (perso.getLieuActuel().getEnigme().play()== true )
                                                               {
                                                                   perso.ajoutObjet( perso.getLieuActuel().getEnigme().giveTreasure()) ;
                                                               }
                                                            }
							}
						}
                               else if (mots[0].equals(Commandes.SAVE.commande()))
						{
                                                OutputStream saveFile = new FileOutputStream("saveFile.sav") ;
                                                try (ObjectOutputStream save = new ObjectOutputStream(saveFile)) {
                                                    save.writeObject(perso);
                                                    save.writeObject(hall);
                                                    save.writeObject(banquet);
                                                    save.writeObject(art_gallery);
                                                    save.writeObject(corridor1);
                                                    save.writeObject(kitchen);
                                                    save.writeObject(bureau);
                                                    save.writeObject(corridor2);
                                                    save.writeObject(east_wing);
                                                    save.writeObject(west_wing);
                                                    save.writeObject(bathroom);
                                                    save.writeObject(friend_bedroom);
                                                    save.writeObject(frank_bedroom);
                                                    save.writeObject(child_bedroom);
                                                    save.close();
                                                }
                                                }
                                else if (mots[0].equals(Commandes.LOAD.commande()))
						{
                                                InputStream saveFile = new FileInputStream("saveFile.sav");
                                                try (ObjectInputStream restore = new ObjectInputStream(saveFile)) {
                                                    perso = (Heros)restore.readObject();
                                                    hall = (Place)restore.readObject();
                                                    banquet = (Place)restore.readObject();
                                                    art_gallery = (Place)restore.readObject();
                                                    corridor1 = 	(Place)restore.readObject();
                                                    kitchen = (Place)restore.readObject();
                                                    bureau = (Place)restore.readObject();
                                                    corridor2 = (Place)restore.readObject();
                                                    east_wing = (Place)restore.readObject();
                                                    west_wing = (Place)restore.readObject();
                                                    bathroom = (Place)restore.readObject();
                                                    friend_bedroom = (Place)restore.readObject();
                                                    frank_bedroom = (Place)restore.readObject();
                                                    child_bedroom = (Place)restore.readObject();
                                                    }
                                                }
                                else
                                                    {
                                                        System.out.printf("Unknown Command");
                                                    }
                                 victory = (perso.getLieuActuel()==hall&&perso.objetIsHere("medal_friend")&&perso.objetIsHere("medal_wife")&&perso.objetIsHere("medal_train"));
                                 }

                       if (victory)
                       {
                           System.out.printf ("Congratulations ! You found the three medals. Put them in the holes on the ground. \n" +
                                                "You place the three medals and a mysterious scale appears in front of you. You climb this scale \n" +
                                                "to the ceiling. When you reach the top of the scale, you are in a little secret room. Here there's \n +
                                                "a very old chest. When you open it, a huge amount of golds. You found the secret treasure of Franck McFolter \n" +
                                                "and finish this game !");

                       }
		}

	}
