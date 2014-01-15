
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Euronia
 */
public class Enigme7letters extends Enigme{
    private int pos ;

public Enigme7letters (String affich , String result, Objet obj)
{
    super.Enigme(affich, result,obj);
    this.pos = 0 ;
}

@Override public void fonctionA () 
{ 
    Character tmp ;
 
    if (pos == 6)
    {
        tmp = affichage[pos];
        affichage[pos] = affichage [0] ;
        affichage[0] = tmp;
    }    
    else
    {
      tmp = affichage[pos] ;   
      affichage[pos] = affichage[pos+1] ;
      affichage[pos+1] = tmp ;
    }
}

@Override public void fonctionB () 
{ 
    if (pos == 5) 
    {
        pos = 0 ;
    }
    else if (pos == 6)
    {
        pos = 1 ;
    }
    else pos += 2 ;
        
}

@Override public void displayEnigme () 
{
    System.out.println(Arrays.toString(affichage));
    
}
}    

