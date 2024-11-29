import java.util.Arrays;

public class makingFleets {

    public static void makePossibilitiesOfDamage(float[] fleetDmg_1,float[] fleetDmg_2,int[] fleetEmpty){
        fleetDmg_1[0] = 0.2f; fleetDmg_1[1] = 0.2f; fleetDmg_1[2] = 0.2f;
        fleetDmg_1[3] = 0.6f; fleetDmg_1[4] = 0.4f; fleetDmg_1[5] = 0.8f;
        fleetDmg_1[6] = 0.4f;

        fleetDmg_2[0] = 0.2f; fleetDmg_2[1] = 0.2f; fleetDmg_2[2] = 0.2f;
        fleetDmg_2[3] = 0.6f; fleetDmg_2[4] = 0.4f; fleetDmg_2[5] = 0.8f;
        fleetDmg_2[6] = 0.4f;

        Arrays.fill(fleetEmpty,0);
    }

}
