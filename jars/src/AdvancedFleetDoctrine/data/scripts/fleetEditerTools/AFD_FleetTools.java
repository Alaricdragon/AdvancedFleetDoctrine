package AdvancedFleetDoctrine.data.scripts.fleetEditerTools;

import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.characters.OfficerDataAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;

import java.util.ArrayList;

public class AFD_FleetTools {
    public static float getFleetPower(CampaignFleetAPI fleet){
        return fleet.getFleetData().getMembersListCopy().size();
    }
    public static PersonAPI getCommander(CampaignFleetAPI fleet) {
        return fleet.getCommander();
    }
    public static ArrayList<OfficerDataAPI> getOfficers(CampaignFleetAPI fleet){
        return new ArrayList<>(fleet.getFleetData().getOfficersCopy());
    }
    public static void clearFleetsShips(CampaignFleetAPI fleet){
        ArrayList<FleetMemberAPI> fleetmembers = new ArrayList<>(fleet.getFleetData().getMembersListCopy());
        for (FleetMemberAPI a : fleetmembers) {
            fleet.getFleetData().removeFleetMember(a);
        }
    }
    public static void applyOfficers(CampaignFleetAPI fleet,ArrayList<OfficerDataAPI> officers){
        int b = 0;
        for (FleetMemberAPI a : fleet.getFleetData().getMembersListCopy()) {
            if (b >= officers.size()) return;
            a.setCaptain(officers.get(b).getPerson());
            b++;
        }
    }
    public static void applyDMods(CampaignFleetAPI fleet){

    }
    public static void applySMods(CampaignFleetAPI fleet){

    }
}
