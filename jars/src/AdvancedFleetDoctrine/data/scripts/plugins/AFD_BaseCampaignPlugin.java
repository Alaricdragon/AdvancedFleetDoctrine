package AdvancedFleetDoctrine.data.scripts.plugins;

import com.fs.starfarer.api.PluginPick;
import com.fs.starfarer.api.campaign.BaseCampaignPlugin;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.campaign.CampaignPlugin;
import com.fs.starfarer.api.campaign.FleetInflater;
import com.fs.starfarer.api.impl.campaign.fleets.DefaultFleetInflaterParams;

public class AFD_BaseCampaignPlugin extends BaseCampaignPlugin {
    @Override
    public boolean isTransient() {
        return true;
    }
    @Override
    public PluginPick<FleetInflater> pickFleetInflater(CampaignFleetAPI fleet, Object params) {
        //keept here for now. but like, just not usefull just yet.
        if (params instanceof DefaultFleetInflaterParams) {
            DefaultFleetInflaterParams p = (DefaultFleetInflaterParams) params;
            return new PluginPick<FleetInflater>(new AFD_DefaultFleetInflater(p), CampaignPlugin.PickPriority.CORE_GENERAL);
        }
        return null;
    }
}
