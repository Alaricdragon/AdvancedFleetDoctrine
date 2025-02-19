package AdvancedFleetDoctrine.data.scripts.startupData;

import AdvancedFleetDoctrine.data.scripts.plugins.AFD_FleetReplacerImpla;
import com.fs.starfarer.api.Global;

public class AFD_PlugingStartup {
    public static void apply(){
        Global.getSector().addTransientListener(new AFD_FleetReplacerImpla(false));
    }
}
