import java.util.HashMap;

public class myCOUT {

    public static void printResults(int[] fleet_1, HashMap<Integer,Float> Results1, int[] fleet_2, HashMap<Integer,Float> Results2){
        System.out.println();
        System.out.println("Tie possibility is " + Math.round( (float) Results1.get(0)) + " %");
        System.out.println();

        int total1 = 0;
        float chance1 = 0;
        for (int i = 0; i < fleet_1.length; i++)
            total1 += fleet_1[i];
        for (int i = 1; i <= total1; i++)
            chance1 += (float) Results1.get(i);

        System.out.println("Player 1 win possibility is " + Math.round(chance1) + " %");
        System.out.println("Possible ships stayed in line to serve (in case):");
        for (int i = 1; i <= total1; i++)
            System.out.print(i + "\t" + "\t" + "\t");
        System.out.println();
        for (int i = 1; i <= total1; i++)
            System.out.print(Math.round((float) Results1.get(i)/chance1*100f) + " %" + "\t" + "\t");

        System.out.println();

        int total2 = 0;
        float chance2 = 0;
        for (int i = 0; i < fleet_2.length; i++)
            total2 += fleet_2[i];
        for (int i = 1; i <= total2; i++)
            chance2 += (float) Results2.get(i);

        System.out.println();

        System.out.println("Player 2 win possibility is " + Math.round(chance2) + " %");
        System.out.println("Possible ships stayed in line to serve (in case):");
        for (int i = 1; i <= total2; i++)
            System.out.print(i + "\t" + "\t" + "\t");
        System.out.println();
        for (int i = 1; i <= total2; i++)
            System.out.print(Math.round((float) Results2.get(i)/chance2*100f) + " %" + "\t" + "\t");
        System.out.println();
    }

}
