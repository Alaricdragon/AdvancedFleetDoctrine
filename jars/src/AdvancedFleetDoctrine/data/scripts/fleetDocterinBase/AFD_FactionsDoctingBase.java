package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class AFD_FactionsDoctingBase {
    String faction;
    ArrayList<AFD_FD_FleetSetBase> fleetSets = new ArrayList<>();
    public AFD_FactionsDoctingBase(JSONObject json) throws JSONException {
        //get normal stats from a json object.
        for (Iterator it = json.keys(); it.hasNext(); ) {
            String key = (String) it.next();
            fleetSets.add(new AFD_FD_FleetSetBase(json.getJSONObject(key)));
        }
    }
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
