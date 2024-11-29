import java.util.Arrays;

public class fleetProccessing {
    public static int[] takingDamage(int[] fleet, int addHP, int Dmg){
        int[] workfleet = Arrays.copyOf(fleet,fleet.length);
        if (addHP >= Dmg)
            addHP -= Dmg;
        else {
            Dmg -= addHP;
            addHP = 0;
            for (int i = 0; i < fleet.length; i++) {
                int substract = Math.min(Dmg, workfleet[i]);
                Dmg -= substract;
                workfleet[i] -= substract;
                if (Dmg == 0)
                    break;
            }
        }

        return workfleet;
    }

    public static int getShipsAmount(int[] fleet){
        int amount = 0;

        for (int i = 0; i < fleet.length; i++)
            amount += fleet[i];

        return amount;
    }
}
