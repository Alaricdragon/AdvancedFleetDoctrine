package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import java.util.ArrayList;

public class AFD_FactionsDoctingBase {
    String faction;
    ArrayList<AFD_FD_FleetSetBase> fleetSets = new ArrayList<>();

    public boolean applyFleetSets(AFD_FleetData data){
        //the return is for determine if i should allow this to run the default fleet doctrine instead.
        float power = getFleetPower();
        for (AFD_FD_FleetSetBase a : fleetSets){
            power -= a.getCost(data);
            if (power < 0) return false;
            if (a.canPreform(data)){
                a.apply(data);
                return true;
            }
        }
        return false;
    }
    public float getFleetPower(){
        return 0f;
    }
}
