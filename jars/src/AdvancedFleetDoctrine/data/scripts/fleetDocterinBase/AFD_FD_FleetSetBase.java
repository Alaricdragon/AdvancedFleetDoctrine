package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AFD_FD_FleetSetBase {
    /*this acts as a set of rules and conditions sets that act as a single type of fleet.*/
    float cost;
    private ArrayList<AFD_FD_ConditionSetBase> condtionSets = new ArrayList<>();
    private ArrayList<AFD_FD_RuleBase> rules = new ArrayList<>();
    public AFD_FD_FleetSetBase(JSONObject json) throws JSONException {
        //HashMap<Integer,ArrayList<AFD_FD_ConditionBase>> conditionsTemp = new HashMap<>();

        //get the condtions in a json object
        JSONObject conditions = json.getJSONObject("conditions");
        for (Iterator it = conditions.keys(); it.hasNext(); ) {
            String key = (String) it.next();
            AFD_FD_ConditionSetBase condtionsTemp = new AFD_FD_ConditionSetBase();
            //get the conditions in each set.
            for (Iterator it2 = conditions.getJSONObject(key).keys(); it2.hasNext(); ) {
                String key2 = (String) it.next();
                condtionsTemp.conditions.add(AFD_MasterControl.getNewCondtion(key,conditions.getJSONObject(key).getJSONObject(key2)));
            }
            condtionSets.add(condtionsTemp);
        }

        //get the rules in a json object.
        JSONObject rules = json.getJSONObject("rules");
        for (Iterator it = rules.keys(); it.hasNext(); ) {
            String key = (String) it.next();
            this.rules.add(AFD_MasterControl.getNewRule(key,rules.getJSONObject(key)));
        }
    }

    public boolean canPreform(AFD_FleetData data) {
        for (AFD_FD_RuleBase a : rules){
            if (!a.canPreform(data)) return false;
        }
        for (AFD_FD_ConditionSetBase a : condtionSets){
            if (a.canPreform(data)) return true;
        }
        return false;
    }
    public void apply(AFD_FleetData data){
        for (int a = 0; a < rules.size(); a++){
            rules.get(a).apply(data);
        }
    }
    public void calculateCost(){
    }
    public float getCost(AFD_FleetData data){
        return cost;
    }
}
