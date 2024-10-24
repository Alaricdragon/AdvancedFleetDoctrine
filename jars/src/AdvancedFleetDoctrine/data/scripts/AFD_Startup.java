package AdvancedFleetDoctrine.data.scripts;
import com.fs.starfarer.api.BaseModPlugin;
import com.thoughtworks.xstream.XStream;
import org.json.JSONException;

import java.io.IOException;

public class AFD_Startup extends BaseModPlugin {
    public void onNewGame(){
    }

    @Override
    public void configureXStream(XStream x) {
        super.configureXStream(x);
    }

    @Override
    public void onApplicationLoad() throws JSONException, IOException {
    }
    @Override
    public void onGameLoad(boolean newGame) {
        //something wrong with crewreplacer addCrewType. causes out of bounds
        //crew_replacer_start_outdated();
        super.onGameLoad(newGame);
    }
}