//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class
import java.util.*;

// one class needs to have a main() method
public class Lab6
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    
    
    Scanner sc = new Scanner(System.in);
    int commandTotal = sc.nextInt();
    String nextLineCatcher = sc.nextLine();
    String command;
    int energy;
    int gold;
    int id;
    int queryEnergy;
    long goldEarned;
    Quest questFound;
    
    TreeSet<Quest> ts = new TreeSet<>(new QuestSort());
    for (int commandNo=0; commandNo < commandTotal; commandNo++){
        command = sc.next();
        // System.out.println("ggg" + (command=="add"));
        if (command.equals("add")){
            energy = sc.nextInt();
            gold = sc.nextInt();
            // System.out.println("bb"+gold);
            // System.out.println("add success?"+ts.add(new Quest(commandNo,energy,gold)) +" commandNo"+commandNo+" energy"+energy+" gold"+gold);
            ts.add(new Quest(commandNo,energy,gold));
        } else if (command.equals("query")){
            
            // System.out.println("querying");
            queryEnergy = sc.nextInt();
            
            // System.out.println("queryEnergy"+queryEnergy);
            questFound = ts.ceiling(new Quest(commandNo,queryEnergy,100001));
            goldEarned = 0;
            
            // System.out.println("contains..."+ts.contains(new Quest(0,8,10)));
            // System.out.println("questFound..." + (questFound==null));
            
            
            while (questFound != null & queryEnergy > 0){
                // questFound = ts.ceiling(new Quest(commandNo,queryEnergy,0));
                // System.out.println("questFound"+questFound.energy+" questID"+questFound.id+" queryEnergy"+queryEnergy + " goldEarned"+goldEarned + " questGold"+ questFound.gold);
                queryEnergy = queryEnergy - questFound.energy;
                goldEarned = goldEarned + questFound.gold;
                // System.out.println("ggg"+questFound.gold + " earn"+goldEarned);
                ts.remove(questFound);
                
                questFound = ts.ceiling(new Quest(commandNo,queryEnergy,100001));
                
                
            }
            
            
            
            System.out.println(goldEarned);
        }
        
        nextLineCatcher = sc.nextLine();
    }
  }
}


class Quest{
  int id, energy, gold;
  public Quest(int id, int energy, int gold){
    this.id=id;
    this.energy=energy;
    this.gold=gold;
  }
}

class QuestSort implements Comparator<Quest>{
  public int compare(Quest q1, Quest q2){
    if ((q2.energy-q1.energy)==0){
        if ((q2.gold-q1.gold) == 0){
            return q2.id - q1.id;
        }else{
            return q2.gold - q1.gold;
            
        }
    }else{
        return q2.energy-q1.energy; 
        
    }
  }
}