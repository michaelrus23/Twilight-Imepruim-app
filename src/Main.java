import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //Making fleet of the first player
        int[] fleet_1 = new int[7];
        float[] fleetDmg_1 = new float[7];

        //Making fleet of the second player
        int[] fleet_2 = new int[7];
        float[] fleetDmg_2 = new float[7];

        //Making empty fleet as an example
        int[] empty_fleet = new int[7];

        makingFleets.makePossibilitiesOfDamage(fleetDmg_1, fleetDmg_2, empty_fleet);

        //Add ships
        fleet_1[0] = 6; fleet_1[5] = 1;
        fleet_2[3] = 5;
        int addHP_1 = fleet_1[3] + fleet_1[5] + fleet_1[6];
        int addHP_2 = fleet_2[3] + fleet_2[5] + fleet_2[6];

        //Begin journey!
        HashMap Results1 = new HashMap<Integer, Float>();
        HashMap Results2 = new HashMap<Integer, Float>();
        MathCore.CalculateChances(fleet_1, fleetDmg_1, addHP_1, Results1, fleet_2, fleetDmg_2, addHP_2, Results2, 1, empty_fleet);
        myCOUT.printResults(fleet_1, Results1, fleet_2, Results2);
    }

}