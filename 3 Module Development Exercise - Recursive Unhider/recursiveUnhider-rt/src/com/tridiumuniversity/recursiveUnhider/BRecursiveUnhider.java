package com.tridiumuniversity.recursiveUnhider;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.util.logging.Logger;
import java.util.stream.Stream;

@NiagaraType
@NiagaraProperty(name = "regex", type = "String", defaultValue = "")
@NiagaraAction(name = "unhide", flags = Flags.ASYNC)
public class BRecursiveUnhider extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.recursiveUnhider.BRecursiveUnhider(3863023903)1.0$ @*/
/* Generated Wed Feb 21 15:14:33 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "regex"

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
		Stream<Property> stream = component.getProperties().stream()
			.filter(p -> Flags.has(component, p, Flags.HIDDEN));

		String regex = getRegex().trim();
		if(!regex.isEmpty()) stream = stream.filter(p -> p.getName().matches(regex));

		stream.forEachOrdered(p -> Flags.remove(component, p, cx, Flags.HIDDEN));
	}

	private final Logger log = Logger.getLogger("unhider");
}
