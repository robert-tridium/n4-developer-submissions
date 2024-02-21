package com.tridiumuniversity.recursiveUnhider;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.util.logging.Logger;
import java.util.stream.Stream;

@NiagaraType
@NiagaraAction(name = "unhide", flags = Flags.ASYNC)
public class BRecursiveUnhider extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.recursiveUnhider.BRecursiveUnhider(3247439684)1.0$ @*/
/* Generated Wed Feb 21 12:03:53 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

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
  public static final Type TYPE = Sys.loadType(BRecursiveUnhider.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

	public void doUnhide(Context cx) {
		BComponent root = this.getParent().getParentComponent();
		if (root == null) {
			log.warning("Root component is null");
			return;
		}

		log.info(String.format("Starting from root: %s", root.getSlotPath()));
		recurseComponent(root, cx);
		log.info("Unhide complete");
	}

	private void recurseComponent(BComponent root, Context cx) {
		for(BComponent child: root.getChildComponents()) {
			log.fine(String.format("Recursing into: %s", child.getSlotPath()));
			recurseComponent(child, cx);
			unhideComponentProperties(child, cx);
		}
		unhideComponentProperties(root, cx);
	}

	private void unhideComponentProperties(BComponent component, Context cx) {
		component.getProperties().stream()
			.filter(p -> Flags.has(component, p, Flags.HIDDEN))
			.forEachOrdered(p -> Flags.remove(component, p, cx, Flags.HIDDEN));
	}

	private final Logger log = Logger.getLogger("unhider");
}
