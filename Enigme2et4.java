
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
/**
 *
 * @author Euronia
 */
public class Enigme2et4 extends Enigme {
    int pos ; 
    int pos1 ;
   
public Enigme2et4 (String affich , String result, Objet obj)
{
    super.Enigme(affich, result,obj);
    this.pos =4 ; 
    this.pos1 =0 ;
}
 
@Override public void reset () 
{
    this.affichage = this.reset.toCharArray();
    pos = 4 ;
    pos1 = 0 ; 
}
 
@Override public void fonctionA () 
{ 
    if (pos == 0)
    {
    Character tmp  ;
    tmp = affichage[0] ; 
    affichage[0] = affichage[4] ;
    affichage[4] = tmp ;
    pos = 4 ;
    }
    else
    {
    Character tmp  ;
    tmp = affichage[pos] ; 
    affichage[pos] = affichage[pos-1] ;
    affichage[pos-1] = tmp ;
    pos -- ; 
    }
}

@Override public void fonctionB () 
{ 
    if (pos1 == 4)
    {
    Character tmp  ;
    tmp = affichage[0] ; 
    affichage[0] = affichage[4] ;
    affichage[4] = tmp ;
    pos1 = 0 ;
    }
    else
    {
    Character tmp  ;
    tmp = affichage[pos1] ; 
    affichage[pos1] = affichage[pos1+1] ;
    affichage[pos1+1] = tmp ;
    pos1++ ;
    }
}

@Override public void displayEnigme () 
{
    System.out.println(Arrays.toString(affichage));
    
}
}
