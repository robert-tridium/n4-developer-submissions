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
        name = "regex",
        type = "String",
        defaultValue = "new String()",
        flags = Flags.SUMMARY
)
@NiagaraAction(
        name = "unhide",
        flags = Flags.SUMMARY | Flags.ASYNC
)
public class BUnhider extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.recursiveUnhider.BUnhider(3831675021)1.0$ @*/
/* Generated Thu Nov 16 09:55:49 EST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "regex"

  /**
   * Slot for the {@code regex} property.
   * @see #getRegex
   * @see #setRegex
   */
  public static final Property regex = newProperty(Flags.SUMMARY, new String(), null);

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

  //endregion Property "regex"

  //region Action "unhide"

  /**
   * Slot for the {@code unhide} action.
   * @see #unhide()
   */
  public static final Action unhide = newAction(Flags.SUMMARY | Flags.ASYNC, null);

  /**
   * Invoke the {@code unhide} action.
   * @see #unhide
   */
  public void unhide() { invoke(unhide, null, null); }

  //endregion Action "unhide"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUnhider.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void doUnhide()
    {
        helper((BComponent) getParent());
    }

    //public static boolean isHidden(BComplex object, Slot slot)
    //public static void remove(BComponent comp, Slot slot, Context cx, int... flags)

    private void helper(BComponent parent)
    {
        Pattern slotName = Pattern.compile(getRegex());
        for (BComponent child : parent.getChildComponents())
        {
            helper(child);
        }
        for (Slot slot : parent.getSlotsArray())
        {
            if (Flags.isHidden(parent, slot) && slotName.matcher(slot.getName()).matches())
            {
                Flags.remove(parent, slot, null, Flags.HIDDEN);
            }
            if (Flags.isHidden(parent, slot)) System.out.println("Failed");
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
        if (unhide.equals(a))
        {
            exec.execute(this::doUnhide);
        }
        return null;
    }

    private ExecutorService exec;
}
