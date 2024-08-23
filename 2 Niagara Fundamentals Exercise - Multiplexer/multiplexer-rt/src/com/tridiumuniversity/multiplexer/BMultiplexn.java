package com.tridiumuniversity.multiplexer;

import javax.baja.naming.SlotPath;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusBoolean;
import javax.baja.sys.*;
import java.util.ArrayList;
import java.util.List;

@NiagaraProperty(
        name = "out",
        type = "BBoolean",
        defaultValue = "BBoolean.FALSE",
        flags = Flags.READONLY | Flags.SUMMARY
)
@NiagaraAction(
        name = "addInSlot"
)
@NiagaraAction(
        name = "addSSlot"
)

public class BMultiplexn extends BComponent {


  private int inSlotsNumber = 0;
  private int sSlotsNumber = 0;

  public void doAddInSlot() {

    add("in?", BBoolean.FALSE, Flags.SUMMARY);
    }

    public void doAddSSlot() {

    add("s?", BBoolean.FALSE, Flags.SUMMARY);
    }

    public void calculateOut() {
    String slotName = "";
    List<BBoolean> inSlotsList = new ArrayList<>();
    List<BBoolean> sSlotsList = new ArrayList<>();

    for(int i = 0; i < inSlotsNumber; i++) {
      slotName = "in" + i;
      BValue value = get(getSlot(slotName).asProperty());
      inSlotsList.add(0, (BBoolean) value);
    }

      for(int i = 0; i < sSlotsNumber; i++) {
        slotName = "s" + i;
        BValue value = get(getSlot(slotName).asProperty());
        sSlotsList.add(0, (BBoolean) value);
      }

      int selectedInput = 0;
      for (int i = 0; i < sSlotsNumber; i++) {
        if (sSlotsList.get(i).getBoolean()) {
          selectedInput |= 1 << (sSlotsNumber - 1 - i);
        }
      }

      setOut(inSlotsList.get(selectedInput).getBoolean());
    }

    private void countDynamicSlots() {
      inSlotsNumber = 0;
      sSlotsNumber = 0;
      for (Slot slot : getSlotsArray()) {
        if (slot.getName().startsWith("in")) {
          inSlotsNumber++;
        } else if (slot.getName().startsWith("s")) {
          sSlotsNumber++;
        }
      }
    }

    @Override
    public void changed(Property p, Context cx) {
      if (!out.equals(p) && inSlotsNumber > 0 && sSlotsNumber > 0) {
        calculateOut();
      }
    }

//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.multiplexer.BMultiplexn(436164121)1.0$ @*/
/* Generated Tue Aug 20 15:58:34 BST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

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

  //region Action "addInSlot"

  /**
   * Slot for the {@code addInSlot} action.
   * @see #addInSlot()
   */
  public static final Action addInSlot = newAction(0, null);

  /**
   * Invoke the {@code addInSlot} action.
   * @see #addInSlot
   */
  public void addInSlot() { invoke(addInSlot, null, null); }

  //endregion Action "addInSlot"

  //region Action "addSSlot"

  /**
   * Slot for the {@code addSSlot} action.
   * @see #addSSlot()
   */
  public static final Action addSSlot = newAction(0, null);

  /**
   * Invoke the {@code addSSlot} action.
   * @see #addSSlot
   */
  public void addSSlot() { invoke(addSSlot, null, null); }

  //endregion Action "addSSlot"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMultiplexn.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
