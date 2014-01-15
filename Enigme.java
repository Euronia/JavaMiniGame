/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 *//**
 *
 * @author Euronia
 */
import java.util.Arrays;
import java.util.Scanner;

public abstract class Enigme implements java.io.Serializable{
    protected char[] affichage ;
    protected char[] result ;
    protected String reset ; 
    protected boolean resolved ;
    private Objet treasure ;
    
    
    public void Enigme(String affich , String result,Objet obj)
    {
        this.affichage = affich.toCharArray();  
        this.result = result.toCharArray(); 
        this.reset = affich ;
        this.resolved = false ;
        this.treasure = obj ;    
    }
    
    public boolean isResolved ()
    {
        return this.resolved ;
    }
    
    
    public boolean resolving ()
    {
        if (Arrays.equals(affichage,result) == true) 
                {
                    return true ;
                }
        else
            return false ;
    }
    
    public void reset ()
    {
        this.affichage = this.reset.toCharArray();
    }
    
    public Objet giveTreasure ()
    { 
       return treasure ;           
    }
    
    abstract void displayEnigme ();
    abstract void fonctionA () ;
    abstract void fonctionB () ; 
    
    public boolean play ()
    {
        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        while (resolved == false && choice != 0)
        {
            displayEnigme() ;
            System.out.println ("0 - Quit \n 1 - 1st Button \n 2 - 2nd Button \n 3 - Reset Button \n");
            choice = scanner.nextInt();
            if (choice > 3 || choice < 0  ) 
                {
                    System.out.printf ("You entered something false");
                }
            else if (choice == 1)
		{
                    fonctionA(); 
                    this.resolved = resolving();               
                }
             else if (choice == 2)
		{
                     fonctionB();
                     this.resolved = resolving();
                }
            else if (choice == 3)
		{
                    System.out.printf ("RESET \n");
                    reset();
                }
            
        }
        if (resolved == true)
        {
            displayEnigme() ;
            System.out.printf ("You solved the enigma and you obtained a %s",this.treasure.getNom());
            return true ; 
        }
        else
        {
            return false ; 
        }
    }

}
