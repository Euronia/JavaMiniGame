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
public class EnigmeCavalier3 extends Enigme {
   
public EnigmeCavalier3 (String affich , String result, Objet obj)
{
    super.Enigme(affich, result,obj);
}

@Override public void fonctionA () 
{ 
    Character tmp  ;
    tmp = affichage[0] ; 
    affichage[0] = affichage[2] ;
    affichage[2] = tmp ;
}

@Override public void fonctionB () 
{ 
    Character tmp , tmp2 ;
    tmp = affichage[1] ; 
    affichage[1] = affichage[2] ;
    affichage[2] = tmp ;
}

@Override public void displayEnigme () 
{
    System.out.println(Arrays.toString(affichage));
    
}
}
