package com.tridiumuniversity.checksumService;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.control.trigger.BTimeTrigger;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BAbstractService;
import javax.baja.sys.BComponent;
import javax.baja.sys.BValue;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Type;
import javax.baja.sys.Action;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.util.IFuture;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.Checksum;


@NiagaraType

@NiagaraProperty(
        name = "checksum",
        type = "double",
        defaultValue = "0.0"
)
@NiagaraProperty(
        name = "trigger",
        type = "control:TimeTrigger",
        defaultValue = "new BTimeTrigger()"
)
@NiagaraAction(
        name = "generateChecksum",
        flags = Flags.ASYNC | Flags.HIDDEN
)
public class BChecksumService extends BAbstractService {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.checksumService.BChecksumService(34314850)1.0$ @*/
/* Generated Mon Sep 30 07:18:19 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "checksum"

  /**
   * Slot for the {@code checksum} property.
   * @see #getChecksum
   * @see #setChecksum
   */
  public static final Property checksum = newProperty(0, 0.0, null);

  /**
   * Get the {@code checksum} property.
   * @see #checksum
   */
  public double getChecksum() { return getDouble(checksum); }

  /**
   * Set the {@code checksum} property.
   * @see #checksum
   */
  public void setChecksum(double v) { setDouble(checksum, v, null); }

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
  public static final Action generateChecksum = newAction(Flags.ASYNC | Flags.HIDDEN, null);

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

    public void doGenerateChecksum(Context context) {
        Checksum crc32 = new CRC32();
       if (getEnabled()) {
            BITable<BComponent> componentTable = (BITable<BComponent>) BOrd.make("bql:select * from baja:Component")
                            .get(Sys.getStation(), context);
           String handleString = new String("");
           byte[] handleBytes;

            try (TableCursor<BComponent> cursor = componentTable.cursor()) {
                for (BComponent component:cursor)
                handleString = component.getHandle().toString();
                handleBytes = handleString.getBytes();
                crc32.update(handleBytes, 0, handleBytes.length );
            }
            setChecksum(crc32.getValue());
        }

    }

    @Override
    public IFuture post (Action action, BValue value, Context context) {
        if (generateChecksum.equals(action)) {
            Thread thread = new Thread(() -> doGenerateChecksum(context), "generateChecksumThread");
            thread.start();
        }
        return null;
    }
    public static final Logger logger =java.util.logging.Logger.getLogger("ChecksumService");

    @Override
    public  void started () {
        this.linkTo(getTrigger(), getTrigger().getSlot("fireTrigger"),this.getSlot("generateChecksum") );
    }
    @Override
    public Type [] getServiceTypes() {
        return new Type[] {TYPE };
    }
}
