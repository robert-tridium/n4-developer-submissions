package com.tridiumuniversity.recursiveUnhider;

import javax.baja.job.BJobService;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.util.logging.Logger;

@NiagaraProperty(
        name = "rootOrd",
        type = "BOrd",
        defaultValue = "BOrd.DEFAULT"
)
@NiagaraAction(
        name = "unhide"
)

@NiagaraType
public class BRecursiveUnhiderService extends BAbstractService
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridiumuniversity.recursiveUnhider.BRecursiveUnhiderService(2746338207)1.0$ @*/
/* Generated Tue Sep 26 00:16:33 AEST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "rootOrd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code rootOrd} property.
   * @see #getRootOrd
   * @see #setRootOrd
   */
  public static final Property rootOrd = newProperty(0, BOrd.DEFAULT, null);
  
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
  public static final Type TYPE = Sys.loadType(BRecursiveUnhiderService.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void doUnhide(Context cx)
  {
    BJobService.getService().submit(new BRecursiveUnhiderJob(), cx);
  }

  @Override
  public Type[] getServiceTypes()
  { // Since this service only implements a single service Type (itself),
    // return a static array of one Type element
    return serviceTypes;
  }

  private static final Type[] serviceTypes = new Type[] { TYPE };

  public static final Logger log = Logger.getLogger("recursiveUnhiderService");
}
