package AdvancedFleetDoctrine.data.scripts.plugins;

import AdvancedFleetDoctrine.data.scripts.fleetEditerTools.AFD_FleetTools;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.campaign.FleetInflater;
import com.fs.starfarer.api.campaign.listeners.FleetInflationListener;

public class AFD_FleetInflationListener implements FleetInflationListener {
    @Override
    public void reportFleetInflated(CampaignFleetAPI fleet, FleetInflater inflater) {
        //keept here for now, but has no use. just for refrnce.
    }
}
