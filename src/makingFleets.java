import java.util.Arrays;

public class makingFleets {

    public static void makePossibilitiesOfDamage(float[] fleetDmg_1, int add_dices_1, int[] upgrade_1, float[] fleetDmg_2, int add_dices_2, int[] upgrade_2, int[] fleetEmpty){

        fleetDmg_1[0] = 0.2f + 0.1f*(add_dices_1 + upgrade_1[0]); fleetDmg_1[1] = 0.2f + 0.1f*add_dices_1; fleetDmg_1[2] = 0.2f + 0.1f*(add_dices_1 + upgrade_1[1]);
        fleetDmg_1[3] = 0.6f + 0.1f*add_dices_1; fleetDmg_1[4] = 0.4f + 0.1f*(add_dices_1 + upgrade_1[2]); fleetDmg_1[5] = 0.8f + 0.1f*add_dices_1;
        fleetDmg_1[6] = 0.4f + 0.1f*add_dices_1;

        fleetDmg_2[0] = 0.2f + 0.1f*(add_dices_2 + upgrade_2[0]); fleetDmg_2[1] = 0.2f + 0.1f*add_dices_2; fleetDmg_2[2] = 0.2f + 0.1f*(add_dices_2 + upgrade_2[1]);
        fleetDmg_2[3] = 0.6f + 0.1f*add_dices_2; fleetDmg_2[4] = 0.4f + 0.1f*(add_dices_2 + upgrade_2[2]); fleetDmg_2[5] = 0.8f + 0.1f*add_dices_2;
        fleetDmg_2[6] = 0.4f + 0.1f*add_dices_2;

        Arrays.fill(fleetEmpty,0);
    }

}
