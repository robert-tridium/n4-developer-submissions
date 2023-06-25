package com.tridiumuniversity.recursiveUnhider;


import javax.baja.job.BJobService;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "rootOrd",
        type = "BOrd",
        defaultValue = "BOrd.DEFAULT"
)
@NiagaraAction(
        name = "unhide"
)
@NiagaraProperty(
        name = "regex",
        type = "String",
        defaultValue = "\"\""
)
public class BRecursiveUnhider extends BAbstractService {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.pentasolutions.devTrafficLights.BRecursiveUnhider(1276087253)1.0$ @*/
/* Generated Fri Jun 23 05:54:13 CDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Property "regex"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code regex} property.
   * @see #getRegex
   * @see #setRegex
   */
  public static final Property regex = newProperty(0, "", null);
  
  /**
   * Get the {@code regex} property.
   * @see #regex
   */
  public String getRegex() { return getString(regex); }
  
  /**
   * Set the {@code regex} property.
   * @see #regex
   */
  public void setRegex(String v) { setString(regex, v, null); }

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
  public static final Type TYPE = Sys.loadType(BRecursiveUnhider.class);



    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doUnhide(Context cx)
  {
    BJobService.getService().submit(new BJob(getRootOrd()), cx);
  }
    @Override
    public Type[] getServiceTypes() {
        return serviceTypes;
    }
  private static final Type[] serviceTypes = new Type[] { TYPE };

}
