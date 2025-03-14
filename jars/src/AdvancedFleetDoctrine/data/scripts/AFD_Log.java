package AdvancedFleetDoctrine.data.scripts;

import com.fs.starfarer.api.Global;
import org.apache.log4j.Logger;

public class AFD_Log {
    static final private boolean logsActive = false;
    public static int depth = 0;
    private static final char space = ' ';
    public static void push(){
        depth++;
    }
    public static void pop(){
        depth--;
    }
    public static void setDepth(int newDepth){
        depth = newDepth;
    }
    public static int getDepth(){
        return depth;
    }
    public static void loging(String output,Object displayClass,boolean displayOverride){
        trueloging(output,displayClass,displayOverride);
    }
    public static void loging(String output,Object displayClass) {
        trueloging(output,displayClass,logsActive);
    }
    private static void trueloging(String output,Object displayClass,boolean go){
        if(!go){
            return;
        }
        String add = "";
        for(int a = 0; a < depth; a++){
            add+=space;
        }
        final Logger LOG = Global.getLogger(displayClass.getClass());
        LOG.info(add + output);
    }
}

