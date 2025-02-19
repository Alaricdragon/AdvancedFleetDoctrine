package AdvancedFleetDoctrine.data.scripts.fleetEditerTools;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.characters.OfficerDataAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.fleet.FleetMemberType;

import java.util.ArrayList;

public class AFD_FleetTools {
    public static void changeFleetMaster(CampaignFleetAPI fleet){
        test(fleet);
    }
    public static void test(CampaignFleetAPI fleet){
        float size = AFD_FleetTools.getFleetPower(fleet);
        ArrayList<OfficerDataAPI> officers = AFD_FleetTools.getOfficers(fleet);
        AFD_FleetTools.clearFleetsShips(fleet);
        for (int a = 0; a < size; a++) {
            fleet.getFleetData().addFleetMember(Global.getFactory().createFleetMember(FleetMemberType.SHIP,"hyperion_Attack"));
        }
        AFD_FleetTools.applyOfficers(fleet,officers);

    }
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
