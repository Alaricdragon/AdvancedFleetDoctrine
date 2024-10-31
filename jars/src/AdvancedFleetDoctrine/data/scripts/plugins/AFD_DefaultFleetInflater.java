package AdvancedFleetDoctrine.data.scripts.plugins;

import AdvancedFleetDoctrine.data.scripts.fleetEditerTools.AFD_FleetTools;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.characters.OfficerDataAPI;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.impl.campaign.fleets.DefaultFleetInflater;
import com.fs.starfarer.api.impl.campaign.fleets.DefaultFleetInflaterParams;

import java.util.ArrayList;

public class AFD_DefaultFleetInflater extends DefaultFleetInflater {
    public AFD_DefaultFleetInflater(DefaultFleetInflaterParams p) {
        super(p);
    }
    @Override
    public void inflate(CampaignFleetAPI fleet) {
        float size = AFD_FleetTools.getFleetPower(fleet);
        ArrayList<OfficerDataAPI> officers = AFD_FleetTools.getOfficers(fleet);
        AFD_FleetTools.clearFleetsShips(fleet);
        for (int a = 0; a < size; a++) {
            fleet.getFleetData().addFleetMember(Global.getFactory().createFleetMember(FleetMemberType.SHIP,"hyperion_Attack"));
        }
        AFD_FleetTools.applyOfficers(fleet,officers);
    }
}
