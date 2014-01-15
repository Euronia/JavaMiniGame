
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
    public class EnigmeHeure extends Enigme {
    private int min ;
   
public EnigmeHeure (String affich , String result, Objet obj)
{
    super.Enigme(affich, result,obj);
    this.min = 555 ;
}

@Override public boolean resolving ()
    {
        if (this.min == 720 ||this.min == 0) 
                {
                    return true ;
                }
        else
            return false ;
    }

@Override public void reset ()
    {
        this.min = 555;  
    }
@Override public void fonctionA () 
{ 
    if (this.min >570)
    {
     this.min = (this.min + 150) -720   ;
    }
    else
    {
            this.min += 150 ;
    }
}

@Override public void fonctionB () 
{ 
    if (this.min<105)
    {
        this.min = 720 - (105 - this.min );
    }
    else
    {
        this.min -= 105 ;
    }
}


@Override public void displayEnigme () 
{
    int val = this.min ; 
    int i = 0 ;
    int heure ;
    for (heure=this.min;heure>=60;heure-=60)
    {
        i ++ ;
    }  
    System.out.printf("%s h %s \n",Integer.toString(i),Integer.toString(heure));
    
    
}
}

