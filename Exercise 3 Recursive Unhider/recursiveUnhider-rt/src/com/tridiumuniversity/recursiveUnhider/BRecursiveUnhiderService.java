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

@NiagaraProperty(
        name = "regex",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "\"\""
)

@NiagaraAction( name = "unhide" )

public class BRecursiveUnhiderService extends BAbstractService
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridiumuniversity.recursiveUnhider.BRecursiveUnhiderService(458091323)1.0$ @*/
/* Generated Mon Sep 25 16:33:17 CEST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
  public static final Property regex = newProperty(Flags.SUMMARY, "", null);
  
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
  public static final Type TYPE = Sys.loadType(BRecursiveUnhiderService.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void doUnhide(Context cx)
    {
        BJobService.getService().submit(new BRecursiveUnhideJob(), cx);
    }

    @Override
    public Type[] getServiceTypes()
    {
        return serviceTypes;
    }

    private static final Type[] serviceTypes = new Type[] { TYPE };


}
