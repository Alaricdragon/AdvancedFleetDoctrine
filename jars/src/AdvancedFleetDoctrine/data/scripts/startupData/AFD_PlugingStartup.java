package AdvancedFleetDoctrine.data.scripts.startupData;

import AdvancedFleetDoctrine.data.scripts.plugins.AFD_BaseCampaignPlugin;
import com.fs.starfarer.api.Global;

public class AFD_PlugingStartup {
    public static void apply(){
        Global.getSector().registerPlugin(new AFD_BaseCampaignPlugin());
    }
}
