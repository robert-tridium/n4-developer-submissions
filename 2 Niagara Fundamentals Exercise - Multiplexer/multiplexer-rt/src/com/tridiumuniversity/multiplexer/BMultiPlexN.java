package com.tridiumuniversity.multiplexer;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@NiagaraType
@NiagaraProperty(
        name = "out",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)",
        flags = Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE
)
@NiagaraAction(
        name = "addInput"
)
@NiagaraAction(
        name = "addSelector"
)
//TO-DO delete Action for both types
public class BMultiPlexN extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.multiplexer.BMultiPlexN(2303573508)1.0$ @*/
/* Generated Wed Aug 21 22:45:00 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "out"

  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BBoolean.make(false).as(BBoolean.class).getBoolean(), null);

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

  //region Action "addInput"

  /**
   * Slot for the {@code addInput} action.
   * @see #addInput()
   */
  public static final Action addInput = newAction(0, null);

  /**
   * Invoke the {@code addInput} action.
   * @see #addInput
   */
  public void addInput() { invoke(addInput, null, null); }

  //endregion Action "addInput"

  //region Action "addSelector"

  /**
   * Slot for the {@code addSelector} action.
   * @see #addSelector()
   */
  public static final Action addSelector = newAction(0, null);

  /**
   * Invoke the {@code addSelector} action.
   * @see #addSelector
   */
  public void addSelector() { invoke(addSelector, null, null); }

  //endregion Action "addSelector"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMultiPlexN.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void changed(Property p, Context cx)
  {
    if (!isRunning()) return;
    calculate();
  }
  @Override
  public void added(Property p, Context cx)
  {
    countDynamicsSlots();
  }
  @Override
  public void removed(Property property, BValue oldValue, Context context)
  {
    countDynamicsSlots();
  }
  public void doAddInput()
  {
    //To-do maximum number of input slots
    int flags = Flags.SUMMARY | Flags.DEFAULT_ON_CLONE;
    add("in0?", BBoolean.make(false).as(BBoolean.class), flags); // BBoolean.make(false).as(BBoolean.class).getBoolean()
  }
  public void doAddSelector()
  {
    //To-do minimum number of input slots
    int flags = Flags.SUMMARY | Flags.DEFAULT_ON_CLONE;
    add("s0?", BBoolean.make(false).as(BBoolean.class), flags);
 }


 public void calculate()
 {
   String nameBuilder = "";
   List<BBoolean> inputsList = new ArrayList<>();     //List of all Boolean inputs
   List<BBoolean> selectorsList = new ArrayList<>();  //List of all Boolean selectors

   for(int i = 0; i < countInputs; i++) {
     nameBuilder = "in" + i;
     BValue value = get(getSlot(nameBuilder).asProperty());
       inputsList.add(0, (BBoolean) value);
   }

   for(int i = 0; i < countSelectors; i++) {
     nameBuilder = "s" + i;
     BValue value = get(getSlot(nameBuilder).asProperty());
     selectorsList.add(0, (BBoolean) value);
   }

   int selectedInput = 0;
   for (int i = 0; i < countSelectors; i++) {
     if (selectorsList.get(i).getBoolean()) {
       selectedInput |= 1 << (countSelectors - 1 - i);
     }
   }

   setOut(inputsList.get(selectedInput).getBoolean());
 }
 private void countDynamicsSlots() {
    countInputs = 0;
    countSelectors = 0;
    for (Slot slot : getSlotsArray()) {
      if (slot.getName().startsWith("in")) {
        countInputs++;
      } else if (slot.getName().startsWith("s")) {
        countSelectors++;
      }
    }
 }
 private int countInputs = 0;
 private int countSelectors = 0;
}
