package com.tridiumuniversity.multiplexer;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BBoolean;
import javax.baja.sys.BComponent;
import javax.baja.sys.BInteger;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Slot;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
@NiagaraType
@NiagaraProperty(
        name = "out",
        type = "BBoolean",  // oder baja:Boolean
        defaultValue = "BBoolean.FALSE",
        flags = Flags.READONLY | Flags.SUMMARY
)
@NiagaraAction(
        name = "addSSlots",
        parameterType = "BInteger",
        defaultValue = "BInteger.make(1)"
)
@NiagaraAction(
        name = "addInSlots",
        parameterType = "BInteger",
        defaultValue = "BInteger.make(1)"
)
public class BMultiplexer2 extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.multiplexer.BMultiplexer2(231429426)1.0$ @*/
/* Generated Thu Sep 26 19:48:38 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "out"

  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.READONLY | Flags.SUMMARY, BBoolean.FALSE.as(BBoolean.class).getBoolean(), null);

  /**
   * Get the {@code out} property.
   * @see #out
   */
  public boolean getOut() { return getBoolean(out); }

  /**
   * Set the {@code out} property.
   * @see #out
   */
  public void setOut(boolean v) { setBoolean(out, v, null); }

  //endregion Property "out"

  //region Action "addSSlots"

  /**
   * Slot for the {@code addSSlots} action.
   * @see #addSSlots(BInteger parameter)
   */
  public static final Action addSSlots = newAction(0, BInteger.make(1), null);

  /**
   * Invoke the {@code addSSlots} action.
   * @see #addSSlots
   */
  public void addSSlots(BInteger parameter) { invoke(addSSlots, parameter, null); }

  //endregion Action "addSSlots"

  //region Action "addInSlots"

  /**
   * Slot for the {@code addInSlots} action.
   * @see #addInSlots(BInteger parameter)
   */
  public static final Action addInSlots = newAction(0, BInteger.make(1), null);

  /**
   * Invoke the {@code addInSlots} action.
   * @see #addInSlots
   */
  public void addInSlots(BInteger parameter) { invoke(addInSlots, parameter, null); }

  //endregion Action "addInSlots"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMultiplexer2.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void doAddSSlots ( BInteger count, Context cx) {
    int sNumber = 0;
    for (int i = 0; i < count.getInt(); i++) {
        sNumber = checkSCount();
        add("s" + sNumber, BBoolean.make(false));
    }
  }
  public void doAddInSlots ( BInteger count, Context cx) {
    int inNumber = 0;
    for (int i = 0; i < count.getInt(); i++) {
        inNumber = checkInCount();
        add("in" + inNumber, BBoolean.make(false));
    }
  }

  @Override
  public void changed (Property property, Context context){
    for (Slot slot : getSlots()) {
      if (property.equals(slot)){
        setOut(calculate());
        return;
      }
    }
  }
  private boolean calculate () {
    int inCount = checkInCount();
    int sCount = checkSCount();
    int inNumber = 0;
    for (int i = 0; i < sCount; i++) {
      BBoolean sValue = (BBoolean) get ("s" + i);
      if (sValue.getBoolean()){
        inNumber = inNumber + (int)Math.pow(2, i);
      }
    }
    if (getSlot("in" + inNumber) != null){
      BBoolean inValue = (BBoolean) get ("in" + inNumber);
      return inValue.getBoolean();
    } else {
      return false;
    }
  }
  private int checkSCount () {
    int count = 0;
    for (Slot slot : getSlots()){
      if (slot.getName().regionMatches(0,"s", 0, 1)){
        count = count + 1;
      }
    }
    return count;
  }
  private int checkInCount () {
    int count = 0;
    for (Slot slot : getSlots()){
      if (slot.getName().regionMatches(0,"in", 0, 2)){
        count = count + 1;
      }
    }
    return count;
  }
}
