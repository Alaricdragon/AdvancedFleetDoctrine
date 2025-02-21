package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import AdvancedFleetDoctrine.data.scripts.JsonDataHandler;
import org.json.JSONObject;

import java.util.HashMap;

public class AFD_MasterControl {
    private static HashMap<String,AFD_FactionsDoctingBase> doctrines = new HashMap<>();
    private static HashMap<String, AFD_FD_ConditionBase> conditionMasterList = new HashMap<>();
    private static HashMap<String, AFD_FD_RuleBase> ruleMasterList = new HashMap<>();
    public static void startup(){
        getJsonFiles();
    }
    public static void setDoctrine(String faction,AFD_FactionsDoctingBase factionsDocting){
        doctrines.put(faction,factionsDocting);
    }
    public static AFD_FactionsDoctingBase getDoctrine(String faction){
        return doctrines.get(faction);
    }
    public static boolean applyDocterin(AFD_FleetData data){
        AFD_FactionsDoctingBase doctrine = getDoctrine(data.faction);
        if (doctrine == null) return false;
        return doctrine.applyFleetSets(data);
    }



    private static void getJsonFiles(){
        try {
            JsonDataHandler.getJsonFiles();
        } catch (Exception ignored) {
        }
        //from withen this
    }
    public static AFD_FD_ConditionBase getNewCondtion(String name, JSONObject json){
        return conditionMasterList.get(name).create(json);
    }
    public static AFD_FD_RuleBase getNewRule(String name, JSONObject json){
        return ruleMasterList.get(name).create(json);
    }
}
