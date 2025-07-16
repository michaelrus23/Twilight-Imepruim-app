import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //Making fleet of the first player
        int[] fleet_1 = new int[7];
        float[] fleetDmg_1 = new float[7];
        int[] fleet_upgrade_1 = new int[3];

        //Making fleet of the second player
        int[] fleet_2 = new int[7];
        float[] fleetDmg_2 = new float[7];
        int[] fleet_upgrade_2 = new int[3];

        fleet_upgrade_1[0] = 0; //upgrade fighter
        fleet_upgrade_1[1] = 0; //upgrade destroyer
        fleet_upgrade_1[2] = 1; //upgrade cruiser

        fleet_upgrade_2[0] = 1; //upgrade fighter
        fleet_upgrade_2[1] = 0; //upgrade destroyer
        fleet_upgrade_2[2] = 0; //upgrade cruiser
        makingFleets.makePossibilitiesOfDamage(fleetDmg_1, 0, fleet_upgrade_1, fleetDmg_2, 0, fleet_upgrade_2);

        //Add ships
        fleet_1[0] = 6; // Fighter
        fleet_1[1] = 0; // Carrier
        fleet_1[2] = 0; // Destroyer
        fleet_1[3] = 0; // Dreadnought
        fleet_1[4] = 2; // Cruiser
        fleet_1[5] = 0; // War Sun
        fleet_1[6] = 0; // Flagship

        fleet_2[0] = 6; // Fighter
        fleet_2[1] = 0; // Carrier
        fleet_2[2] = 0; // Destroyer
        fleet_2[3] = 0; // Dreadnought
        fleet_2[4] = 2; // Cruiser
        fleet_2[5] = 0; // War Sun
        fleet_2[6] = 0; // Flagship

        int addHP_1 = fleet_1[3] + fleet_1[5] + fleet_1[6];
        int addHP_2 = fleet_2[3] + fleet_2[5] + fleet_2[6];

        //Begin journey!
        HashMap<Integer, Float> Results1 = new HashMap<Integer, Float>();
        HashMap<Integer, Float> Results2 = new HashMap<Integer, Float>();
        MathCore.CalculateChances(fleet_1, fleetDmg_1, addHP_1, Results1, fleet_2, fleetDmg_2, addHP_2, Results2, 1);
        myCOUT.printResults(fleet_1, Results1, fleet_2, Results2);
    }

}

//fleet[0] = Fighter
//fleet[1] = Carrier
//fleet[2] = Destroyer
//fleet[3] = Dreadnought
//fleet[4] = Cruiser
//fleet[5] = War Sun
//fleet[6] = Flagship