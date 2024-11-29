import java.util.Arrays;
import java.util.HashMap;

public class MathCore {

    public static void CalculateChances(int[] Army1, float[] pssblty1, int addHP_1, HashMap<Integer,Float> Results1, int[] Army2, float[] pssblty2, int addHP_2, HashMap<Integer,Float> Results2, float PssbltyOfEvent, int[] empty_fleet){

        float[] DamagePossibilities_1 = getDamagePossibilities(Army1, pssblty1);
        float[] DamagePossibilities_2 = getDamagePossibilities(Army2, pssblty2);
        float normalized_pssblty = 1f - DamagePossibilities_1[0]*DamagePossibilities_2[0];

        for(int dmgOfArmy1 = 0; dmgOfArmy1 < DamagePossibilities_1.length; dmgOfArmy1++)
            for(int dmgOfArmy2 = 0; dmgOfArmy2 < DamagePossibilities_2.length; dmgOfArmy2++){
                float _Pssblty;
                if(dmgOfArmy1 == 0 && dmgOfArmy2 == 0)
                    continue;
                _Pssblty =  DamagePossibilities_1[dmgOfArmy1] * DamagePossibilities_2[dmgOfArmy2] / normalized_pssblty;
                _Pssblty *=  PssbltyOfEvent;

                int[] damagedFleet_1 = fleetProccessing.takingDamage(Army1, addHP_1, dmgOfArmy2);
                int[] damagedFleet_2 = fleetProccessing.takingDamage(Army2, addHP_2, dmgOfArmy1);
                if(Arrays.mismatch(damagedFleet_1,empty_fleet) == -1 && Arrays.mismatch(damagedFleet_2,empty_fleet) == -1) {
                    if(Results1.containsKey(0))
                        Results1.put(0,Results1.get(0) + _Pssblty * 100f);
                    else Results1.put(0,_Pssblty * 100f);
                    continue;
                }

                int shipsAmount_1 = fleetProccessing.getShipsAmount(damagedFleet_1);
                int shipsAmount_2 = fleetProccessing.getShipsAmount(damagedFleet_2);

                if(Arrays.mismatch(damagedFleet_1,empty_fleet) == -1){
                    if(Results2.containsKey(shipsAmount_2))
                        Results2.put(shipsAmount_2,Results2.get(shipsAmount_2) + _Pssblty * 100f);
                    else Results2.put(shipsAmount_2,_Pssblty * 100f);

                } else if(Arrays.mismatch(damagedFleet_2,empty_fleet) == -1){
                    if(Results1.containsKey(shipsAmount_1))
                        Results1.put(shipsAmount_1,Results1.get(shipsAmount_1) + _Pssblty * 100f);
                    else Results1.put(shipsAmount_1,_Pssblty * 100f);

                } else CalculateChances(damagedFleet_1, pssblty1, Math.max(0,addHP_1-dmgOfArmy2), Results1, damagedFleet_2, pssblty2, Math.max(0,addHP_2-dmgOfArmy1), Results2, _Pssblty, empty_fleet);

            }


    }

//    public static int[] takingDamage(int[] fleet, int addHP, int Dmg){
//        int[] workfleet = Arrays.copyOf(fleet,fleet.length);
//        if (addHP >= Dmg)
//            addHP -= Dmg;
//        else {
//            Dmg -= addHP;
//            addHP = 0;
//            for (int i = 0; i < fleet.length; i++) {
//                int substract = Math.min(Dmg, workfleet[i]);
//                Dmg -= substract;
//                workfleet[i] -= substract;
//                if (Dmg == 0)
//                    break;
//            }
//        }
//
//        return workfleet;
//    }

    public static float[] getDamagePossibilities(int[] fleet, float[] fleetDmg){

        //Makig dices array
        int[] dices;
        dices = Arrays.copyOf(fleet,fleet.length);  dices[6] *= 2;  dices[5] *= 3;

        //Counting total damage
        int total = 0;
        for (int i = 0; i < fleetDmg.length; i++)
            total += dices[i];

        //Making damage possibility matrix for each type of ship
        float[][] fleetPossblDmg = new float[dices.length][total+1];
        for (int i = 0; i < dices.length; i++)
            if (dices[i] == 0)
                continue;
            else
                for (int j = 0; j < Math.min(dices[i]+1,total+1); j++)
                    fleetPossblDmg[i][j] = getNewPssblty(dices[i], fleetDmg[i], j);

        //Counting damage possibility vector for all ships
        int frstTypeOfShip;
        for (frstTypeOfShip = 0; frstTypeOfShip < dices.length; frstTypeOfShip++)
            if (dices[frstTypeOfShip] != 0)
                break;
        int accumulatedNum = dices[frstTypeOfShip] + 1;
        float[] num = new float[accumulatedNum];
        int[] dmgMatr = new int[accumulatedNum];
        for (int j = 0; j < accumulatedNum; j++) {
            num[j] = fleetPossblDmg[frstTypeOfShip][j];
            dmgMatr[j] = j;
        }

        for (int i = frstTypeOfShip + 1; i < dices.length; i++) {
            if (dices[i] == 0)
                continue;
            int N = accumulatedNum * (dices[i] + 1);
            float[] temp = new float[N];
            int[] tempDmg = new int[N];
            for (int j = 0; j < dices[i] + 1; j++) {
                for (int k = 0; k < accumulatedNum; k++) {
                    temp[k + j * accumulatedNum] = fleetPossblDmg[i][j] * num[k];
                    tempDmg[k + j * accumulatedNum] = dmgMatr[k] + j;
                }
            }
            accumulatedNum = N;
            num = Arrays.copyOfRange(temp,0,N);
            dmgMatr = Arrays.copyOfRange(tempDmg,0,N);
        }

        //Collecting and sum results
        float[] result = new float[total+1];
        for (int i = 0; i < num.length; i++)
            result[dmgMatr[i]] += num[i];

        return result;
    }

    public static float getNewPssblty(int Army1, float pssblty1, int Damage1){

        float Pssblty1 = (float) ( Math.pow(pssblty1,Damage1) * Math.pow(1f-pssblty1,Army1 - Damage1) ) * getFactorial(Army1) / (getFactorial(Army1 - Damage1)*getFactorial(Damage1));

        return Pssblty1;
    }

    public static int getFactorial(int f) {
        int result = 1;
        if (f == 0)
            return 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

//    public static int getShipsAmount(int[] fleet){
//        int amount = 0;
//
//        for (int i = 0; i < fleet.length; i++)
//            amount += fleet[i];
//
//        return amount;
//    }

}
