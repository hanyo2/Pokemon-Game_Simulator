import java.util.*;
public class Mon
{ 
    public String name;
    public int hp;
    public int ap; 
    public int rp; 
    public int heal; 

    public Mon (String pName, int pHp, int pAp, int pRp, int pHeal )
    {
        name = pName; 
        hp = pHp; 
        ap = pAp;  
        rp = pRp; 
        heal = pHeal; 
    }
 
    public Mon (Mon pMon)
    {
        name = pMon.name; 
        hp = pMon.hp;
        ap = pMon.ap; 
        rp = pMon.rp; 
        heal = pMon.heal; 
    }

    public Mon()
    {
        name = "Mon Name";
        hp = 100; 
        ap = 20;
        rp = 20;  
        heal = 3; 
    }

    public void setName (String name)
    {
        this.name = name; 
    }

    public void setHp (int hp)
    {
        this.hp = hp; 
    }

    public void setAp (int ap)
    {
        this.ap = ap; 
    }

    public void setRp (int rp)
    {
        this.rp = rp; 
    }

    public void setHeal (int heal)
    {
        this.heal = heal; 
    }
   


    public String getName ()
    {
        return name; 
    }

    public int getHp ()
    {
        return hp; 
    }

    public int getAp ()
    {
        return ap;  
    }

    public int getRp ()
    {
        return rp;  
    }

    public int getHeal ()
    {
        return heal; 
    }


    public String toString ()
    {
        return "Name: " + name + "\nHp: " + hp + "\nAttack Power: " + ap + "\nHealing Power: " + rp + "\nHeals Available: " + heal + "\n"; 
    }

    public boolean equals (Object obj)
    {
        Mon a = (Mon) obj; 

        if (name != a.name)
        {
            return false; 
        }

        if (hp != a.hp)
        {
            return false; 
        }

        if (ap != a.ap)
        {
            return false; 
        }

        if (rp != a.rp)
        {
            return false; 
        }

        if (heal != a.heal)
        {
            return false; 
        }

        return true; 
    }
 
    

}