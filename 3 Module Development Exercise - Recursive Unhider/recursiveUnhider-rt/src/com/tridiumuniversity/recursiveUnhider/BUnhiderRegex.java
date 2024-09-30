package com.tridiumuniversity.recursiveUnhider;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BValue;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Slot;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.IFuture;
import java.util.logging.Logger;
import java.util.regex.Pattern;

@NiagaraType
@NiagaraAction(
        name = "unhide",
        flags = Flags.ASYNC
)
@NiagaraProperty(
        name = "regex",
        type = "String",
        defaultValue = "",
        flags = Flags.SUMMARY
)
public class BUnhiderRegex extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.recursiveUnhider.BUnhiderRegex(4125138625)1.0$ @*/
/* Generated Thu Sep 26 19:42:08 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "regex"

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

  //endregion Property "regex"

  //region Action "unhide"

  /**
   * Slot for the {@code unhide} action.
   * @see #unhide()
   */
  public static final Action unhide = newAction(Flags.ASYNC, null);

  /**
   * Invoke the {@code unhide} action.
   * @see #unhide
   */
  public void unhide() { invoke(unhide, null, null); }

  //endregion Action "unhide"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUnhiderRegex.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void doUnhide (Context context) {
      removeHiddenFlagFromChildren((BComponent) getParent(), context);
    }
    private void removeHiddenFlagFromChildren(BComponent component, Context context) {
      removeHiddenFlagFromSlots(component, context);
      if (component.getChildComponents() == null) {
        return;
      }
      for (BComponent c : component.getChildComponents()) {
        removeHiddenFlagFromChildren(c, context);
      }
    }
    private void removeHiddenFlagFromSlots (BComponent component, Context context) {
      Pattern regex = Pattern.compile(getRegex());

      for (Slot slot : component.getSlots()){
        if (Flags.isHidden(component, slot) && regex.matcher(slot.getName()).matches()){
          Flags.remove(component, slot, context, Flags.HIDDEN);
          logger.fine("Hidden Flag removed from: " + slot);
        }
      }
    }
    @Override
    public IFuture post (Action action, BValue value, Context context) {
      if (unhide.equals(action)) {
        Thread thread = new Thread(() -> doUnhide(context), "UnhiderRegexThread");
        thread.start();
      }
      return null;
    }
    private static final Logger logger = Logger.getLogger("UnhiderRegex");
}
