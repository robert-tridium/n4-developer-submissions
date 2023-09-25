package com.tridiumuniversity.recursiveUnhider;

import javax.baja.job.BJob;
import javax.baja.naming.BOrd;
import javax.baja.naming.UnresolvedException;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BAbstractService;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
  name = "rootOrd",
  type = "BOrd",
  defaultValue = "BOrd.make(\"station:|slot:/\")"
)
@NiagaraAction(
  name = "unhide"

)
public class BUnhideService extends BAbstractService
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridiumuniversity.recursiveUnhider.BUnhideService(3515851161)1.0$ @*/
/* Generated Mon Sep 25 19:38:22 SGT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "rootOrd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code rootOrd} property.
   * @see #getRootOrd
   * @see #setRootOrd
   */
  public static final Property rootOrd = newProperty(0, BOrd.make("slot:/"), null);
  
  /**
   * Get the {@code rootOrd} property.
   * @see #rootOrd
   */
  public BOrd getRootOrd() { return (BOrd)get(rootOrd); }
  
  /**
   * Set the {@code rootOrd} property.
   * @see #rootOrd
   */
  public void setRootOrd(BOrd v) { set(rootOrd, v, null); }

////////////////////////////////////////////////////////////////
// Action "unhide"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code unhide} action.
   * @see #unhide()
   */
  public static final Action unhide = newAction(0, null);
  
  /**
   * Invoke the {@code unhide} action.
   * @see #unhide
   */
  public void unhide() { invoke(unhide, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUnhideService.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public Type[] getServiceTypes()
  { // Since this service only implements a single service Type (itself),
    // return a static array of one Type element
    return serviceTypes;
  }

  private static final Type[] serviceTypes = new Type[] { TYPE };

  public void doUnhide(Context cx){
    BComponent rootComp = null;
    try{
      rootComp = (BComponent) getRootOrd().get();

    }
    catch (UnresolvedException e){}
    finally {
      BJob job = new BUnhideJob(rootComp);
      job.submit(cx);
    }

  }
}
