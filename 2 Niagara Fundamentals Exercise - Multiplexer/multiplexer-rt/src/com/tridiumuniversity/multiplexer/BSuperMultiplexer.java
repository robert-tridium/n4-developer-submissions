package com.tridiumuniversity.multiplexer;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(name = "out", type = "boolean", defaultValue = "false", flags = Flags.SUMMARY | Flags.READONLY)
@NiagaraProperty(name = "numOfSelects", type = "int", defaultValue = "2")
public class BSuperMultiplexer extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.multiplexer.BSuperMultiplexer(1803414455)1.0$ @*/
/* Generated Tue Feb 20 08:59:32 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "out"

  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.SUMMARY | Flags.READONLY, false, null);

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

  //region Property "numOfSelects"

  /**
   * Slot for the {@code numOfSelects} property.
   * @see #getNumOfSelects
   * @see #setNumOfSelects
   */
  public static final Property numOfSelects = newProperty(0, 2, null);

  /**
   * Get the {@code numOfSelects} property.
   * @see #numOfSelects
   */
  public int getNumOfSelects() { return getInt(numOfSelects); }

  /**
   * Set the {@code numOfSelects} property.
   * @see #numOfSelects
   */
  public void setNumOfSelects(int v) { setInt(numOfSelects, v, null); }

  //endregion Property "numOfSelects"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSuperMultiplexer.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


	@Override
	public void started() throws Exception {
		super.started();
		// Mainly to initialize component on drop
		if(slotsNeedUpdated()) updateSlots(getNumOfSelects());
	}

	@Override
	public void changed(Property property, Context context) {
		super.changed(property, context);
		if(!isRunning()) return;
		if(property == out) return;
		if(property == numOfSelects) updateSlots(getNumOfSelects());

		String propName = property.getName();
		boolean inputOrSelectChanged = propName.startsWith("in") || propName.startsWith("s");
		if(inputOrSelectChanged) computeOutput();
	}

	private void computeOutput() {
		int inputSelect = 0;
		for(int i = 0; i < getNumOfSelects(); i++){
			Property prop = getProperty(getSelectName(i));
			if(prop == null) continue;

			boolean select = getBoolean(prop);
			if(!select) continue;
			inputSelect = enableBit(inputSelect, i);
		}
		Property prop = getProperty(getInputName(inputSelect));
		if(prop == null) return;
		setOut(getBoolean(prop));
	}

	private void updateSlots(int selectCount) {
		removeAll();
		for (int i = 0; i < selectCount; i++) {
			this.add(getSelectName(i), BBoolean.FALSE);
		}
		for (int i = 0; i < getInputCount(); i++) {
			this.add(getInputName(i), BBoolean.FALSE);
		}
	}

	private boolean slotsNeedUpdated() {
		for (int i = 0; i < getNumOfSelects(); i++) {
			Slot slot = this.getSlot(getSelectName(i));
			if(slot == null) return true;
		}
		for (int i = 0; i < getInputCount(); i++) {
			Slot slot = this.getSlot(getInputName(i));
			if(slot == null) return true;
		}
		return false;
	}

	private int enableBit(int value, int position) {
		return value | (1 << position);
	}

	private String getSelectName(int i) { return String.format("s%d", i); }
	private String getInputName(int i) { return String.format("in%d", i); }
	private int getInputCount() { return (int) Math.pow(2, getNumOfSelects()); }
}
