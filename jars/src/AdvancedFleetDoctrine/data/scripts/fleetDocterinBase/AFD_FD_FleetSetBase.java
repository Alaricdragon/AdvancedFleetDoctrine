package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import java.util.ArrayList;

public class AFD_FD_FleetSetBase {
    /*this acts as a set of rules and conditions sets that act as a single type of fleet.*/
    float cost;
    ArrayList<AFD_FD_ConditionSetBase> condtionSets = new ArrayList<>();
    ArrayList<AFD_FD_RuleBase> rules = new ArrayList<>();

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
    public float getCost(AFD_FleetData data){
        return cost;
    }
}
