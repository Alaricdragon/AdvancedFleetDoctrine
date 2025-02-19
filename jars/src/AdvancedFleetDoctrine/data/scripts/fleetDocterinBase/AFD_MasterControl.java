package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import AdvancedFleetDoctrine.data.scripts.JsonDataHandler;
import AdvancedFleetDoctrine.data.scripts.startupData.Constants;
import com.fs.starfarer.api.Global;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AFD_MasterControl {
    private static HashMap<String,AFD_FactionsDoctingBase> doctrines = new HashMap<>();
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
}
