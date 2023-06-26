package com.tridiumuniversity.recursiveUnhider;

import javax.baja.job.BSimpleJob;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
public class BJob extends BSimpleJob {
    public BJob(BOrd root) {
        rootOrd = root;
    }
    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.pentasolutions.devTrafficLights.BJob(2979906276)1.0$ @*/
/* Generated Fri Jun 23 06:15:35 CDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BJob.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    @Override
    public void run(Context context) throws Exception {
        unHide(rootOrd.resolve().getComponent(),context);
    }

    public void unHide(BComponent component, Context cx){
        if(!component.isNull()){
            for (Slot slot:  component.getProperties()) {
                if(Flags.isHidden(component,slot)){
                    Flags.remove(component,slot,cx,Flags.HIDDEN);
                }
            }
            for ( BComponent comp: component.getChildComponents()) {
                unHide(comp,cx);
            }

        }
    }

    public BOrd rootOrd = BOrd.DEFAULT;
}
