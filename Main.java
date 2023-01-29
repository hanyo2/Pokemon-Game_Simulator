 import java.util.*; 
import java.io.*; 
import java.lang.*;
public class Main 
{
    public static void main(String[] args) 
    {



        Scanner sc = new Scanner (System.in); 
        boolean menuLoop = true; 
        int menuChoice = 0; 
        String path = "mon_database.csv"; 
        String line = ""; 
        Mon [] monArray = new Mon [20]; 
        int lineNum = 0; 

        try
        {
            BufferedReader br = new BufferedReader(new FileReader (path)); 

            while((line = br.readLine()) != null)
            {
                String [] values = line.split (",");  
                Mon currStu = new Mon(values[0], Integer.parseInt(values[1]),Integer.parseInt(values[2]),Integer.parseInt(values[3]),Integer.parseInt(values[4]));
                lineNum ++; 
                monArray [lineNum -1] = currStu; 
            }
        
        } catch (FileNotFoundException e)
        {
            e.printStackTrace(); 
        } catch (IOException e)
        {
            e.printStackTrace(); 
        } catch (NumberFormatException e)
        {
            System.out.println ("Number format exception"); 
        }


        while(menuLoop == true)
        {
            menuChoice = 0; 
            System.out.println("\nHAN-JIEN'S MONSTER BATTLE:\n\n(Enter a number corresponding to the menu options below)");
            System.out.println ("1. MonBattle (Player vs. Ai) \n2. MonBattle (Player vs. Player)\n3. MonBattle (Ai vs. Ai)\n4. Exit game");  
            menuChoice = sc.nextInt(); 

            do
            {
                    if (menuChoice == 1) 
                    {
                        String monAlly = monSelectionAlly(monArray, menuChoice); 
                        String monEnemy = monSelectionEnemy(monArray, menuChoice); 

                        Mon monAllyObj = monCreationAlly(monArray, monAlly); 
                        Mon monEnemyObj = monCreationEnemy(monArray, monEnemy); 

                        monBattleAI(monAllyObj, monEnemyObj); 
                    } 
                
                
                    else if (menuChoice == 2)
                    {
                        String monAlly = monSelectionAlly(monArray, menuChoice); 
                        String monEnemy = monSelectionEnemy(monArray, menuChoice); 

                        Mon monAllyObj = monCreationAlly(monArray, monAlly); 
                        Mon monEnemyObj = monCreationEnemy(monArray, monEnemy); 

                        monBattlePVP(monAllyObj, monEnemyObj); 
                    }
                
                    else if (menuChoice == 3)
                    {
                        String monAlly = monSelectionAlly(monArray, menuChoice); 
                        String monEnemy = monSelectionEnemy(monArray, menuChoice); 

                        Mon monAllyObj = monCreationAlly(monArray, monAlly); 
                        Mon monEnemyObj = monCreationEnemy(monArray, monEnemy); 

                        monBattleAIAI(monAllyObj, monEnemyObj); 
                    }

                    else if (menuChoice == 4)
                    {
                        System.out.println("Exiting the game :'(");
                        menuLoop = false;  
                    }

                    else 
                    {
                        System.out.println("Enter a number between 1 and 3");
                    }
            }while (menuChoice>3 || menuChoice<1); 
        }

        
    } 


    public static String monSelectionAlly(Mon[] pMonArray, int pMenuChoice)
    {
        Scanner sc = new Scanner (System.in); 
        String monAlly = ""; 
        String monEnemy = ""; 
        int relevantMonIndex = 0; 
            

            System.out.println("Mon available for battle:\n");
            for (int i = 0; i <= pMonArray.length -1; i++) 
            {
                if (pMonArray[i] != null)
                    {
                    System.out.println(pMonArray[i].toString()); 
                    }
            }


            if (pMenuChoice == 1)
            {
                System.out.println("\nChoose a mon to fight as");
            }
            else if (pMenuChoice == 2)
            {
                System.out.println("\nPlayer 1, choose a mon to fight as");
            }
            else if (pMenuChoice == 3)
            {
                System.out.println("\nChoose a mon for Ai1");
            }

            do
            {
                monAlly = sc.nextLine();

                for (int i = 0; i < pMonArray.length; i++)     
                {
                    if (pMonArray[i] != null)
                    {
                        String relevantMon = pMonArray[i].getName(); 

                        if (relevantMon.equals(monAlly))
                        {
                            relevantMonIndex++; 
                        }
                    }
                }

                if (relevantMonIndex == 0)
                {
                    System.out.println("This mon does not exist in the MonDex, please enter another mon");
                }


            }while(relevantMonIndex == 0); 

            if (pMenuChoice == 1)
            {
            System.out.println("You have chosen to fight as " + monAlly);
            }
            else if (pMenuChoice == 2)
            {
                System.out.println("\nPlayer 1 has chosen to fight as " + monAlly);
            } 
            else if (pMenuChoice == 3)
            {
                System.out.println("\nAi1 is " + monAlly);
            } 
            
    

            return monAlly; 
    }




    public static String monSelectionEnemy(Mon[] pMonArray, int pMenuChoice)
    {
        Scanner sc = new Scanner (System.in); 
        String monEnemy = ""; 
        int relevantMonIndex = 0; 
        
        if (pMenuChoice == 1)
        {
            System.out.println("\nChoose a mon to fight against");
        }
        else if (pMenuChoice == 2)
        {
            System.out.println("\nPlayer 2, choose a mon to fight as");
        }
        else if (pMenuChoice == 3)
        {
            System.out.println("\nChoose a mon for Ai2");
        }


        do
        {
            monEnemy = sc.nextLine();

            for (int i = 0; i < pMonArray.length; i++)     
            {
                if (pMonArray[i] != null)
                {
                    String relevantMon = pMonArray[i].getName(); 

                    if (relevantMon.equals(monEnemy))
                    {
                        relevantMonIndex++; 
                    }
                }
            }

            if (relevantMonIndex == 0)
            {
                System.out.println("This mon does not exist in the MonDex, please enter another mon");
            }


         }while(relevantMonIndex == 0); 




         if (pMenuChoice == 1)
         {
            System.out.println("You have chosen to fight against " + monEnemy);
         }
         else if (pMenuChoice == 2)
         {
             System.out.println("\nPlayer 2 has chosen to fight as " + monEnemy);
         } 
         else if (pMenuChoice == 3)
         {
             System.out.println("\nAi2 is " + monEnemy);
         } 

        return monEnemy; 
    }




    public static Mon monCreationAlly(Mon[] pMonArray, String pMonAlly)
    {
        Mon monAlly = new Mon(); 

        for (int i = 0; i < pMonArray.length; i++)
        {
            if (pMonArray[i] != null)
            {
                if (pMonArray[i].getName().equals(pMonAlly))
                {
                    monAlly = new Mon (pMonArray[i]); 
                  //  System.out.println(monAlly.toString());
                }
            }
        }

        return monAlly; 
    }



    public static Mon monCreationEnemy(Mon[] pMonArray, String pMonEnemy)
    {
        Mon monEnemy = new Mon(); 

        for (int i = 0; i < pMonArray.length; i++)
        {
            if (pMonArray[i] != null)
            {
                if (pMonArray[i].getName().equals(pMonEnemy))
                {
                    monEnemy = new Mon (pMonArray[i]); 
                    //System.out.println(monEnemy.toString());
                }
            }
        }

        return monEnemy; 
    }



    public static void monBattleAI(Mon pMonAllyObj, Mon pMonEnemyObj)
    {
        Scanner sc = new Scanner (System.in); 
 
        int max = 3;
        int min = 1;

        int allyBattleChoice = 0; 
        int enemyBattleChoice = 0;


        boolean loop = true; 
        
        aILoop: 
        while (loop == true)
        {
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("BATTLE OPTIONS:\n1. Attack\n2. Heal\n3. Do nothing");
            System.out.println();
            System.out.println("ALLY MON:\n" + pMonAllyObj.toString());
            System.out.println("ENEMY MON:\n" + pMonEnemyObj.toString());

            do
            {
                allyBattleChoice = sc.nextInt(); 
                

                if (allyBattleChoice == 1)
                {
                    pMonEnemyObj.setHp(pMonEnemyObj.getHp() - pMonAllyObj.getAp()); 
                    System.out.println(pMonAllyObj.getName() + " attacks " + pMonEnemyObj.getName() + ", dealing " + pMonAllyObj.getAp() + " damage");
                }
                else if (allyBattleChoice == 2)
                {
                    if (pMonAllyObj.getHeal() > 0)
                    {
                        pMonAllyObj.setHp(pMonAllyObj.getHp() + pMonAllyObj.getRp() ); 
                        pMonAllyObj.setHeal(pMonAllyObj.getHeal()-1); 

                        if (pMonAllyObj.getHp() > 100)
                        {
                            pMonAllyObj.setHp(100);
                        }
                        System.out.println(pMonAllyObj.getName() + " heals, its Hp is now " + pMonAllyObj.getHp());
                    }
                    else
                    {
                        System.out.println(pMonAllyObj.getName() + " is out of heals, it does nothing this turn");
                    }
                }
                else if (allyBattleChoice == 3)
                {
                    System.out.println(pMonAllyObj.getName() + " does nothing");
                }
                else
                {
                    System.out.println("Enter a number from BATTLE OPTIONS:");
                }

                 if (pMonAllyObj.getHp() <= 0)
                {
                    loop = false; 
                    pMonAllyObj.setHp(0); 
                    System.out.println("ALLY MON:\n" + pMonAllyObj.toString());
                    System.out.println("ENEMY MON:\n" + pMonEnemyObj.toString());
                    break aILoop;
                }
                else if (pMonEnemyObj.getHp() <= 0)
                {
                    loop = false; 
                    pMonEnemyObj.setHp(0); 
                    System.out.println("ALLY MON:\n" + pMonAllyObj.toString());
                    System.out.println("ENEMY MON:\n" + pMonEnemyObj.toString());
                    break aILoop;
                }  
            }while (allyBattleChoice>3 || allyBattleChoice<1); 




            for (int i = 0; i < 10; i++) 
            {
                enemyBattleChoice = (int)(Math.random() * (max-min+1)) + min;
            }

            if(pMonEnemyObj.getHp() == 100)
            {
                while(enemyBattleChoice == 2)
                {
                    for (int i = 0; i < 10; i++) 
                    {
                        enemyBattleChoice = (int)(Math.random() * (max-min+1)) + min;
                    }
                }
            }
            
            if(pMonEnemyObj.getHp() < 50)
            {
                max = 2; 
                enemyBattleChoice = (int)(Math.random() * (max-min+1)) + min;
            }

            if(pMonEnemyObj.getHeal() == 0)
            {
                while(enemyBattleChoice == 2)
                {
                    for (int i = 0; i < 10; i++) 
                    {
                        enemyBattleChoice = (int)(Math.random() * (max-min+1)) + min;
                    }
                }
            }

            if(pMonEnemyObj.getHp() < 50 & pMonEnemyObj.getHeal() == 0)
            {
                enemyBattleChoice = 1; 
            }

            if(pMonAllyObj.getHp() <= pMonEnemyObj.getAp())
            {
                enemyBattleChoice = 1; 
            }

            if(pMonEnemyObj.getHp() < pMonAllyObj.getAp() & pMonEnemyObj.getHeal() == 0)
            {
                enemyBattleChoice = 1; 
            }


            
            if (enemyBattleChoice == 1)
            {
                pMonAllyObj.setHp(pMonAllyObj.getHp() - pMonEnemyObj.getAp()); 
                System.out.println(pMonEnemyObj.getName() + " attacks " + pMonAllyObj.getName() + ", dealing " + pMonEnemyObj.getAp() + " damage");
            }
            else if (enemyBattleChoice == 2)
            {
                if (pMonEnemyObj.getHeal() > 0)
                {
                    pMonEnemyObj.setHp(pMonEnemyObj.getHp() + pMonEnemyObj.getRp() ); 
                    pMonEnemyObj.setHeal(pMonEnemyObj.getHeal()-1); 

                    if (pMonEnemyObj.getHp() > 100)
                    {
                        pMonEnemyObj.setHp(100);
                    }
                    System.out.println(pMonEnemyObj.getName() + " heals, its Hp is now " + pMonEnemyObj.getHp());
                }
                else
                {
                    System.out.println(pMonEnemyObj.getName() + " is out of heals, it does nothing this turn");
                }
            }
            else if (enemyBattleChoice == 3)
            {
                System.out.println(pMonEnemyObj.getName() + " does nothing");
            }

             if (pMonAllyObj.getHp() <= 0)
            {
                loop = false; 
                pMonAllyObj.setHp(0); 
                System.out.println("ALLY MON:\n" + pMonAllyObj.toString());
                System.out.println("ENEMY MON:\n" + pMonEnemyObj.toString());
                break aILoop;
            }
            else if (pMonEnemyObj.getHp() <= 0)
            {
                loop = false; 
                pMonEnemyObj.setHp(0); 
                System.out.println("ALLY MON:\n" + pMonAllyObj.toString());
                System.out.println("ENEMY MON:\n" + pMonEnemyObj.toString());
                break aILoop;
            } 







        }

        if (pMonAllyObj.getHp() <= 0)
        {
            System.out.println(pMonAllyObj.getName() + " has fainted, you lose :((");
        }
        else if (pMonEnemyObj.getHp() <= 0)
        {
            System.out.println(pMonEnemyObj.getName() + " has fainted, you win! XDD");
        }

    }





    public static void monBattlePVP(Mon pMonObjP1, Mon pMonObjP2)
    {
        Scanner sc = new Scanner (System.in); 

        int p1BattleChoice = 0; 
        int p2BattleChoice = 0;

        boolean loop = true; 
        
        pvpLoop:
        while (loop == true)
        {
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("PLAYER 1 TURN\nBATTLE OPTIONS:\n1. Attack\n2. Heal\n3. Do nothing");
            System.out.println();
            System.out.println("P1 MON:\n" + pMonObjP1.toString());
            System.out.println("P2 MON:\n" + pMonObjP2.toString());

            do
            {
                p1BattleChoice= sc.nextInt(); 
                

                if (p1BattleChoice== 1)
                {
                    pMonObjP2.setHp(pMonObjP2.getHp() - pMonObjP1.getAp()); 
                    System.out.println(pMonObjP1.getName() + " attacks " + pMonObjP2.getName() + ", dealing " + pMonObjP1.getAp() + " damage");
                }
                else if (p1BattleChoice== 2)
                {
                    pMonObjP1.setHp(pMonObjP1.getHp() + pMonObjP1.getRp()); 

                    if (pMonObjP1.getHp() > 100)
                    {
                        pMonObjP1.setHp(100);
                    }
                    System.out.println(pMonObjP1.getName() + " heals, its Hp is now " + pMonObjP1.getHp());
                }
                else if (p1BattleChoice== 3)
                {
                    System.out.println(pMonObjP1.getName() + " does nothing");
                }
                else
                {
                    System.out.println("Enter a number from BATTLE OPTIONS:");
                }

                if (pMonObjP1.getHp() <= 0)
                {
                    loop = false; 
                    pMonObjP1.setHp(0); 
                    System.out.println("P1 MON:\n" + pMonObjP1.toString());
                    System.out.println("P2 MON:\n" + pMonObjP2.toString());
                    break pvpLoop;
                }
                else if (pMonObjP2.getHp() <= 0)
                {
                    loop = false; 
                    pMonObjP2.setHp(0); 
                    System.out.println("P1 MON:\n" + pMonObjP1.toString());
                    System.out.println("P2 MON:\n" + pMonObjP2.toString());
                    break pvpLoop;
                }
            }while (p1BattleChoice>3 || p1BattleChoice<1); 

            System.out.println("\nPLAYER 1 TURN ENDED");




            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("PLAYER 2 TURN\nBATTLE OPTIONS:\n1. Attack\n2. Heal\n3. Do nothing");
            System.out.println();
            System.out.println("P2 MON:\n" + pMonObjP2.toString());
            System.out.println("P1 MON:\n" + pMonObjP1.toString());

            do
            {
                p2BattleChoice= sc.nextInt(); 
                

                if (p2BattleChoice== 1)
                {
                    pMonObjP1.setHp(pMonObjP1.getHp() - pMonObjP2.getAp()); 
                    System.out.println(pMonObjP2.getName() + " attacks " + pMonObjP1.getName() + ", dealing " + pMonObjP2.getAp() + " damage");
                }
                else if (p2BattleChoice== 2)
                {
                    pMonObjP2.setHp(pMonObjP2.getHp() + pMonObjP2.getRp()); 

                    if (pMonObjP2.getHp() > 100)
                    {
                        pMonObjP2.setHp(100);
                    }
                    System.out.println(pMonObjP2.getName() + " heals, its Hp is now " + pMonObjP2.getHp());
                }
                else if (p2BattleChoice== 3)
                {
                    System.out.println(pMonObjP2.getName() + " does nothing");
                }
                else
                {
                    System.out.println("Enter a number from BATTLE OPTIONS:");
                }

                if (pMonObjP2.getHp() <= 0)
                {
                    loop = false; 
                    pMonObjP2.setHp(0); 
                    System.out.println("P2 MON:\n" + pMonObjP2.toString());
                    System.out.println("P1 MON:\n" + pMonObjP1.toString());
                    break pvpLoop;
                }
                else if (pMonObjP1.getHp() <= 0)
                {
                    loop = false; 
                    pMonObjP1.setHp(0); 
                    System.out.println("P2 MON:\n" + pMonObjP2.toString());
                    System.out.println("P1 MON:\n" + pMonObjP1.toString());
                    break pvpLoop;
                }
            }while (p2BattleChoice>3 || p2BattleChoice<1); 

            System.out.println("\nPLAYER 2 TURN ENDED");


        }

        if (pMonObjP2.getHp() <= 0)
        {
            System.out.println(pMonObjP2.getName() + " has fainted, player 1 wins! XDD");
        }
        else if (pMonObjP1.getHp() <= 0)
        {
            System.out.println(pMonObjP1.getName() + " has fainted, player 2 wins! XDD");
        }

    }






    public static void monBattleAIAI(Mon pMonObj1, Mon pMonObj2)
    {
        boolean loop = true; 
        int max = 3; 
        int min = 1;


        int obj1BattleChoice = 0;
        int obj2BattleChoice = 0;  

        
        
        aILoop: 
        while(loop == true)
        {
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("AI 1 TURN\nBATTLE OPTIONS:\n1. Attack\n2. Heal\n3. Do nothing");
            System.out.println();
            System.out.println("Ai1 MON:\n" + pMonObj1.toString());
            System.out.println("Ai2 MON:\n" + pMonObj2.toString());
            
            
            for (int i = 0; i < 10; i++) 
            {
                obj1BattleChoice = (int)(Math.random() * (max-min+1)) + min;
            }

            if(pMonObj1.getHp() == 100)
            {
                while(obj1BattleChoice == 2)
                {
                    for (int i = 0; i < 10; i++) 
                    {
                        obj1BattleChoice = (int)(Math.random() * (max-min+1)) + min;
                    }
                }
            }
            
            if(pMonObj1.getHp() < 50)
            {
                max = 2; 
                obj1BattleChoice = (int)(Math.random() * (max-min+1)) + min;
            }

            if(pMonObj1.getHeal() == 0)
            {
                while(obj1BattleChoice == 2)
                {
                    for (int i = 0; i < 10; i++) 
                    {
                        obj1BattleChoice = (int)(Math.random() * (max-min+1)) + min;
                    }
                }
            }

            if(pMonObj1.getHp() < 50 & pMonObj1.getHeal() == 0)
            {
                obj1BattleChoice = 1; 
            }

            if(pMonObj2.getHp() <= pMonObj1.getAp())
            {
                obj1BattleChoice = 1; 
            }

            if(pMonObj1.getHp() < pMonObj2.getAp() & pMonObj1.getHeal() == 0)
            {
                obj1BattleChoice = 1; 
            }


            
            if (obj1BattleChoice == 1)
            {
                pMonObj2.setHp(pMonObj2.getHp() - pMonObj1.getAp()); 
                System.out.println(pMonObj1.getName() + " attacks " + pMonObj2.getName() + ", dealing " + pMonObj1.getAp() + " damage");
            }
            else if (obj1BattleChoice == 2)
            {
                if (pMonObj1.getHeal() > 0)
                {
                    pMonObj1.setHp(pMonObj1.getHp() + pMonObj1.getRp() ); 
                    pMonObj1.setHeal(pMonObj1.getHeal()-1); 

                    if (pMonObj1.getHp() > 100)
                    {
                        pMonObj1.setHp(100);
                    }
                    System.out.println(pMonObj1.getName() + " heals, its Hp is now " + pMonObj1.getHp());
                }
                else
                {
                    System.out.println(pMonObj1.getName() + " is out of heals, it does nothing this turn");
                }
            }
            else if (obj1BattleChoice == 3)
            {
                System.out.println(pMonObj1.getName() + " does nothing");
            }

            if (pMonObj2.getHp() <= 0)
            {
                loop = false; 
                pMonObj2.setHp(0); 
                System.out.println("Ai1 MON:\n" + pMonObj1.toString());
                System.out.println("Ai2 MON:\n" + pMonObj2.toString());
                break aILoop;
            }
            else if (pMonObj1.getHp() <= 0)
            {
                loop = false; 
                pMonObj1.setHp(0); 
                System.out.println("Ai2 MON:\n" + pMonObj2.toString());
                System.out.println("Ai1 MON:\n" + pMonObj1.toString());
                break aILoop;
            } 

            System.out.println("\nAi1 TURN ENDED");



            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("Ai2 TURN\nBATTLE OPTIONS:\n1. Attack\n2. Heal\n3. Do nothing");
            System.out.println();
            System.out.println("Ai2 MON:\n" + pMonObj2.toString());
            System.out.println("Ai1 MON:\n" + pMonObj1.toString());



            for (int i = 0; i < 10; i++) 
            {
                obj2BattleChoice = (int)(Math.random() * (max-min+1)) + min;
            }

            if(pMonObj2.getHp() == 100)
            {
                while(obj2BattleChoice == 2)
                {
                    for (int i = 0; i < 10; i++) 
                    {
                        obj2BattleChoice = (int)(Math.random() * (max-min+1)) + min;
                    }
                }
            }
            
            if(pMonObj2.getHp() < 50)
            {
                max = 2; 
                obj2BattleChoice = (int)(Math.random() * (max-min+1)) + min;
            }

            if(pMonObj2.getHeal() == 0)
            {
                while(obj2BattleChoice == 2)
                {
                    for (int i = 0; i < 10; i++) 
                    {
                        obj2BattleChoice = (int)(Math.random() * (max-min+1)) + min;
                    }
                }
            }

            if(pMonObj2.getHp() < 50 & pMonObj2.getHeal() == 0)
            {
                obj2BattleChoice = 1; 
            }

            if(pMonObj1.getHp() <= pMonObj2.getAp())
            {
                obj2BattleChoice = 1; 
            }

            if(pMonObj2.getHp() < pMonObj1.getAp() & pMonObj2.getHeal() == 0)
            {
                obj2BattleChoice = 1; 
            }


            
            if (obj2BattleChoice == 1)
            {
                pMonObj1.setHp(pMonObj1.getHp() - pMonObj2.getAp()); 
                System.out.println(pMonObj2.getName() + " attacks " + pMonObj1.getName() + ", dealing " + pMonObj2.getAp() + " damage");
            }
            else if (obj2BattleChoice == 2)
            {
                if (pMonObj2.getHeal() > 0)
                {
                    pMonObj2.setHp(pMonObj2.getHp() + pMonObj2.getRp() ); 
                    pMonObj2.setHeal(pMonObj2.getHeal()-1); 

                    if (pMonObj2.getHp() > 100)
                    {
                        pMonObj2.setHp(100);
                    }
                    System.out.println(pMonObj2.getName() + " heals, its Hp is now " + pMonObj2.getHp());
                }
                else
                {
                    System.out.println(pMonObj2.getName() + " is out of heals, it does nothing this turn");
                }
            }
            else if (obj2BattleChoice == 3)
            {
                System.out.println(pMonObj2.getName() + " does nothing");
            }

            if (pMonObj2.getHp() <= 0)
            {
                loop = false; 
                pMonObj2.setHp(0); 
                System.out.println("Ai1 MON:\n" + pMonObj1.toString());
                System.out.println("Ai2 MON:\n" + pMonObj2.toString());
                break aILoop;
            }
            else if (pMonObj1.getHp() <= 0)
            {
                loop = false; 
                pMonObj1.setHp(0); 
                System.out.println("Ai2 MON:\n" + pMonObj2.toString());
                System.out.println("Ai1 MON:\n" + pMonObj1.toString());
                break aILoop;
            } 


            System.out.println("\nAi2 TURN ENDED");
        }

        if (pMonObj1.getHp() <= 0)
        {
            System.out.println(pMonObj1.getName() + " has fainted," + pMonObj2.getName() + " wins! XDD");
        }
        else if (pMonObj2.getHp() <= 0)
        {
            System.out.println(pMonObj2.getName() + " has fainted," + pMonObj1.getName() + " wins! XDD");
        }


    }
    





    public static void monAdd(Mon[] pMonArray)
    {
        Scanner sc = new Scanner (System.in); 
        
        int moreMon = 0; 
        String newMonName = ""; 
        int newMonHp = 0; 
        int newMonAp = 0; 
        int newMonRp = 0; 
        int newMonHeal = 0; 
        int lineNum = 0; 
        String path = "/C:/Users/hanji/Desktop/Uni Stuff/poke/src/mon_database.csv"; 
        String line = ""; 

        try
        {
            BufferedReader br = new BufferedReader(new FileReader (path)); 

            while((line = br.readLine()) != null)
            {
                String [] values = line.split (",");                      
                Mon currStu = new Mon(values[0], Integer.parseInt(values[1]),Integer.parseInt(values[2]),Integer.parseInt(values[3]),Integer.parseInt(values[4]));
                lineNum ++; 
                pMonArray [lineNum -1] = currStu; 
               
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace(); 
        } catch (IOException e)
        {
            e.printStackTrace(); 
        }

        System.out.println ("How many mon would you like to add to the database?"); 
        moreMon = sc.nextInt(); 
        sc.nextLine(); 

        lineNum = 0; 

        for (int i = 0; i < moreMon; i++)  
        {
            System.out.println ("New mon name"); 
            newMonName = sc.nextLine(); 

            System.out.println ("New mon hp"); 
            newMonHp = sc.nextInt(); 
           

            System.out.println ("New mon ap"); 
            newMonAp = sc.nextInt(); 
            sc.nextLine(); 

            Mon currStu = new Mon(newMonName, newMonHp ,newMonAp, newMonRp, newMonHeal);

           
        pMonArray [lineNum + 5] = currStu; 
            lineNum ++; 
        }

        System.out.println (Arrays.toString(pMonArray)); 
        System.out.println (pMonArray[5]); 
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    