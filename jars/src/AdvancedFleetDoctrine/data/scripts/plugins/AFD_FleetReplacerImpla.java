package AdvancedFleetDoctrine.data.scripts.plugins;

import AdvancedFleetDoctrine.data.scripts.fleetEditerTools.AFD_FleetTools;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.BaseCampaignEventListener;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import org.apache.log4j.Logger;

public class AFD_FleetReplacerImpla extends BaseCampaignEventListener {
    public AFD_FleetReplacerImpla(boolean permaRegister) {
        super(permaRegister);
    }
    @Override
    public void reportFleetSpawned(CampaignFleetAPI fleet) {
        super.reportFleetSpawned(fleet);
        Logger log = Global.getLogger(AFD_FleetReplacerImpla.class);
        log.info("DEBUG: fleet spawn reported from AFD_FleetReplacerImpla");

        AFD_FleetTools.changeFleetMaster(fleet);
    }
}
