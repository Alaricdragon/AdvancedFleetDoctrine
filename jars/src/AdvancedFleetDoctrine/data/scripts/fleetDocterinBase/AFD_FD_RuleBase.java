package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import org.json.JSONObject;

public class AFD_FD_RuleBase {
    /*this exists to act as a single 'rule' in a fleet doctrine.*/
    public AFD_FD_RuleBase create(JSONObject json) {
        return null;
    }
    public boolean canPreform(AFD_FleetData data){
        return true;
    }
    public void apply(AFD_FleetData data){

    }
}
