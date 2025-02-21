package AdvancedFleetDoctrine.data.scripts;

import AdvancedFleetDoctrine.data.scripts.fleetDocterinBase.AFD_FactionsDoctingBase;
import AdvancedFleetDoctrine.data.scripts.fleetDocterinBase.AFD_MasterControl;
import AdvancedFleetDoctrine.data.scripts.startupData.Constants;
import com.fs.starfarer.api.Global;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

public class JsonDataHandler {
    public static void getJsonFiles() throws JSONException, IOException {
        String path="data/config/Advanced Fleet Doctrine/AdvancedFleetDoctrine.json";
        JSONObject json = Global.getSettings().getMergedJSONForMod(path, Constants.MOD_ID);
        for (Iterator it = json.keys(); it.hasNext(); ) {
            String key = (String) it.next();
            getJsonForFaction(key,json.getJSONObject(key));
        }
    }
    private static void getJsonForFaction(String faction, JSONObject json) throws JSONException {
        //here is were i am going to create a new json faction file for each of my god dam guys
        //also, yes I know i only have something creating a empty factionDocting. but thats fine. I can impove it with time.
        AFD_FactionsDoctingBase doctoring = new AFD_FactionsDoctingBase(json);
        AFD_MasterControl.setDoctrine(faction,doctoring);
    }
}
