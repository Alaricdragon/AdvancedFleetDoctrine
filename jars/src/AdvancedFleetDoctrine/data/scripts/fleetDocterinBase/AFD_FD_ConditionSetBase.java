package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import java.util.ArrayList;

public class AFD_FD_ConditionSetBase {
    /*this acts as a set of conditions in a */
    ArrayList<AFD_FD_ConditionBase> conditions = new ArrayList<>();
    public boolean canPreform(AFD_FleetData data){
        for (AFD_FD_ConditionBase a : conditions){
            if (!a.canPreform(data)) return false;
        }
        return true;
    }
}
