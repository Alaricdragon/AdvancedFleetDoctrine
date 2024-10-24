package AdvancedFleetDoctrine.data.scripts.plugins;

import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.impl.campaign.fleets.DefaultFleetInflater;
import com.fs.starfarer.api.impl.campaign.fleets.DefaultFleetInflaterParams;

public class AFD_DefaultFleetInflater extends DefaultFleetInflater {
    public AFD_DefaultFleetInflater(DefaultFleetInflaterParams p) {
        super(p);
    }
    public void inflate(CampaignFleetAPI fleet) {
    }
}
