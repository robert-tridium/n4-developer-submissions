package com.tridiumuniversity.checksumService;

import javax.baja.control.trigger.BTimeTrigger;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

@NiagaraType
@NiagaraProperty(name = "checksum", type = "long", defaultValue = "0L", flags = Flags.SUMMARY | Flags.READONLY)
@NiagaraProperty(name = "trigger", type = "BTimeTrigger", defaultValue = "new BTimeTrigger()")
@NiagaraAction(name = "generateChecksum", flags = Flags.HIDDEN)
public class BChecksumService extends BAbstractService {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.checksumService.BChecksumService(1069283780)1.0$ @*/
/* Generated Mon Feb 26 09:31:34 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "checksum"

  /**
   * Slot for the {@code checksum} property.
   * @see #getChecksum
   * @see #setChecksum
   */
  public static final Property checksum = newProperty(Flags.SUMMARY | Flags.READONLY, 0L, null);

  /**
   * Get the {@code checksum} property.
   * @see #checksum
   */
  public long getChecksum() { return getLong(checksum); }

  /**
   * Set the {@code checksum} property.
   * @see #checksum
   */
  public void setChecksum(long v) { setLong(checksum, v, null); }

  //endregion Property "checksum"

  //region Property "trigger"

  /**
   * Slot for the {@code trigger} property.
   * @see #getTrigger
   * @see #setTrigger
   */
  public static final Property trigger = newProperty(0, new BTimeTrigger(), null);

  /**
   * Get the {@code trigger} property.
   * @see #trigger
   */
  public BTimeTrigger getTrigger() { return (BTimeTrigger)get(trigger); }

  /**
   * Set the {@code trigger} property.
   * @see #trigger
   */
  public void setTrigger(BTimeTrigger v) { set(trigger, v, null); }

  //endregion Property "trigger"

  //region Action "generateChecksum"

  /**
   * Slot for the {@code generateChecksum} action.
   * @see #generateChecksum()
   */
  public static final Action generateChecksum = newAction(Flags.HIDDEN, null);

  /**
   * Invoke the {@code generateChecksum} action.
   * @see #generateChecksum
   */
  public void generateChecksum() { invoke(generateChecksum, null, null); }

  //endregion Action "generateChecksum"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BChecksumService.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

	@SuppressWarnings("unused")
	public void doGenerateChecksum() {
		if(!getEnabled() || thread != null) return;

		thread = new Thread(() -> {
			try {
				long checksum = this.computeStationChecksum();
				setChecksum(checksum);
			} finally {
				thread = null;
			}
		}, "computeStationChecksumThread");
		thread.start();
	}

	public long computeStationChecksum() {
		Checksum checksum = new CRC32();
		recurseComponentTree(Sys.getStation(), checksum);
		return checksum.getValue();
	}

	@Override
	public void serviceStarted() {
		Slot generateChecksumSlot = getSlot("generateChecksum");
		Slot fireTriggerSlot = getTrigger().getSlot("fireTrigger");
		this.linkTo(getTrigger(), fireTriggerSlot, generateChecksumSlot);
	}

	@Override
	public Type[] getServiceTypes() { return new Type[]{ BChecksumService.TYPE }; }

	private void recurseComponentTree(BComponent comp, Checksum checksum) {
		for(BComponent child: comp.getChildComponents()) recurseComponentTree(child, checksum);
		String handle = (String)comp.getHandle();
		byte[] bytes = handle.getBytes();
		checksum.update(bytes, 0, bytes.length);
	}

	private Thread thread;
}
