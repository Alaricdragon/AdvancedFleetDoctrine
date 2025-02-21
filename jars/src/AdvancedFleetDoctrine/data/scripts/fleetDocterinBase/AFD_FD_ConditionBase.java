package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import org.json.JSONObject;

public class AFD_FD_ConditionBase {
    /*this acts as a single 'condition' in a 'condition set'*/
    int id;
    public AFD_FD_ConditionBase create(JSONObject json) {
        return null;
    }
    public boolean canPreform(AFD_FleetData data){
        return true;
    }
}
