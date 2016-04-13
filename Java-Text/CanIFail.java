package canifail;
import java.util.*;
/**
 *
 * @author Austin Helmholz
 */
public class CanIFail {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          ArrayList array = new ArrayList<Double>();
          System.out.print("What Grade would you like to finish with(Ex 90.1): ");
          double wanted = sc.nextDouble();
          boolean val = true;
          while(val){
               if(wanted <= 100 && wanted > 1){
                    val = false;
               }
               else{
                    System.out.print("Invalid input. Try again: ");
                    wanted = sc.nextDouble();
               }
          }
          
          System.out.print("What is the percent of the category unknown for example the final category:");
          double unknown = sc.nextDouble();
          double next;
          double total = 0;    
          while(total + unknown < 100){
               System.out.print("Category percentage: ");
               next = sc.nextDouble();
               array.add(next);
               total += next;
               if(total + unknown > 100){
                    System.out.println("Try again category percentage was too high.");
                    System.exit(0);
               }
               System.out.print("Points Earned: ");
               next = sc.nextDouble();
               array.add(next);
               System.out.print("Points Possible: ");
               next = sc.nextDouble();
               array.add(next);
               
          }
          double adjusted = 0;

          for(int i = 0; i < array.size(); i += 3){
               adjusted += (double)array.get(i) * ((double)array.get(i + 1)/(double)array.get(i + 2));
               //For Testing System.out.println(wanted - adjusted);
          }
          double neededPercent = (wanted -adjusted)/(.01 * unknown);
          System.out.println("You must obtain at least a " + 
          ((Math.round(neededPercent*100)) / 100.0) +  "% to get a " + 
          (Math.round(wanted)*100)/100.0 + "%");
     }
     
}
