package com.tridiumuniversity.recursiveUnhider;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.IFuture;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

@NiagaraType
@NiagaraProperty(
        name = "unhideRegex",
        type = "String",
        defaultValue = "new String()",
        flags = Flags.SUMMARY
)
@NiagaraAction(
        name = "unhideSlots",
        flags = Flags.SUMMARY | Flags.ASYNC
)
public class BUnhider extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.recursiveUnhider.BUnhider(2130432398)1.0$ @*/
/* Generated Mon Nov 20 12:07:19 EST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "unhideRegex"

  /**
   * Slot for the {@code unhideRegex} property.
   * @see #getUnhideRegex
   * @see #setUnhideRegex
   */
  public static final Property unhideRegex = newProperty(Flags.SUMMARY, new String(), null);

  /**
   * Get the {@code unhideRegex} property.
   * @see #unhideRegex
   */
  public String getUnhideRegex() { return getString(unhideRegex); }

  /**
   * Set the {@code unhideRegex} property.
   * @see #unhideRegex
   */
  public void setUnhideRegex(String v) { setString(unhideRegex, v, null); }

  //endregion Property "unhideRegex"

  //region Action "unhideSlots"

  /**
   * Slot for the {@code unhideSlots} action.
   * @see #unhideSlots()
   */
  public static final Action unhideSlots = newAction(Flags.SUMMARY | Flags.ASYNC, null);

  /**
   * Invoke the {@code unhideSlots} action.
   * @see #unhideSlots
   */
  public void unhideSlots() { invoke(unhideSlots, null, null); }

  //endregion Action "unhideSlots"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUnhider.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void doUnhideSlots()
    {
        slotPattern = Pattern.compile(getUnhideRegex());
        recurse((BComponent) getParent());
    }

    private void recurse(BComponent parent)
    {
        BValue child;
        for (Slot slot : parent.getSlotsArray())
        {
            if (slot.isProperty())
            {
                child = parent.get(slot.asProperty());
                if (child instanceof BComponent) recurse((BComponent) child);
            }
            if (Flags.isHidden(parent, slot) && slotPattern.matcher(slot.getName()).matches())
            {
                Flags.remove(parent, slot, null, Flags.HIDDEN);
            }
            if (Flags.isHidden(parent, slot)) System.out.println("Hidden slot name did not match");
            else System.out.println("Unhid a slot");
        }
    }

    @Override
    public void started()
    {
        exec = newSingleThreadExecutor();
    }

    @Override
    public IFuture post(Action a, BValue arg, Context c)
    {
        if (unhideSlots.equals(a))
        {
            exec.execute(this::doUnhideSlots);
        }
        return null;
    }

    private ExecutorService exec;
    private Pattern slotPattern;
}
