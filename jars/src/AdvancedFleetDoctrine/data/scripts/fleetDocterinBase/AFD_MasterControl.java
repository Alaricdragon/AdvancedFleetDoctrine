package AdvancedFleetDoctrine.data.scripts.fleetDocterinBase;

import java.util.ArrayList;

public class AFD_MasterControl {
    ArrayList<AFD_FactionsDoctingBase> Doctrines = new ArrayList<>();
    public void startup(){
        getJsonFiles();
    }
    public void addDoctrine(String faction){

    }
    public AFD_FactionsDoctingBase getDoctrine(String faction){
        for (AFD_FactionsDoctingBase a : Doctrines){
            if (a.faction.equals(faction)) return a;
        }
        return null;
    }
    public boolean applyDocterin(AFD_FleetData data){
        AFD_FactionsDoctingBase doctrine = getDoctrine(data.faction);
        if (doctrine == null) return false;
        return doctrine.applyFleetSets(data);
    }



    private void getJsonFiles(){

    }
}
