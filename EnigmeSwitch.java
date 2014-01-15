
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
public class EnigmeSwitch extends Enigme {
    private int pos ;
   
public EnigmeSwitch (String affich , String result, Objet obj)
{
    super.Enigme(affich, result,obj);
    this.pos = 0 ;
}

private Character switch_1(int pos)
{
    if (affichage[pos] == '0') 
    {
        return '1' ;
    }
    else
    {
        return '0';
    }
}

public void switcher (int pos)
{
    if (pos == 0)
    {
        affichage[1] = switch_1(1);
    }
    else if ( pos == 5 ) 
    {
        affichage[4] = switch_1(4);
    }
    else 
    {
        affichage[pos-1] = switch_1(pos-1) ;
        affichage[pos+1] = switch_1(pos+1) ;               
    }
}

@Override public void fonctionA () 
{ 
    switcher(pos);
}

@Override public void fonctionB () 
{ 
    if (pos == 5)
    {
        pos = 0 ;
    }
    else
    {
        pos ++ ;
    }
}

@Override public void displayEnigme () 
{
    System.out.println(Arrays.toString(affichage));
    
}
}
    

