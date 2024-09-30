package com.tridiumuniversity.driverFinder;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BValue;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;
import java.util.logging.Logger;
import javax.baja.sys.Property;

@NiagaraType
@NiagaraAction(
        name = "find",
        flags = Flags.ASYNC
)
@NiagaraProperty(
        name = "worker",
        type = "BDriverFinderWorker",
        defaultValue = "new BDriverFinderWorker()"
)
public class BDriverFinder extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.driverFinder.BDriverFinder(2766870444)1.0$ @*/
/* Generated Mon Sep 30 13:12:38 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "worker"

  /**
   * Slot for the {@code worker} property.
   * @see #getWorker
   * @see #setWorker
   */
  public static final Property worker = newProperty(0, new BDriverFinderWorker(), null);

  /**
   * Get the {@code worker} property.
   * @see #worker
   */
  public BDriverFinderWorker getWorker() { return (BDriverFinderWorker)get(worker); }

  /**
   * Set the {@code worker} property.
   * @see #worker
   */
  public void setWorker(BDriverFinderWorker v) { set(worker, v, null); }

  //endregion Property "worker"

  //region Action "find"

  /**
   * Slot for the {@code find} action.
   * @see #find()
   */
  public static final Action find = newAction(Flags.ASYNC, null);

  /**
   * Invoke the {@code find} action.
   * @see #find
   */
  public void find() { invoke(find, null, null); }

  //endregion Action "find"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDriverFinder.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void doFind (Context context) {
    BITable <BComponent> table = (BITable<BComponent>) BOrd.make("bql:select from driver:DeviceNetwork where navParent.type!='driver:DriverContainer'" )
            .get(Sys.getStation(), context);

    try (TableCursor<BComponent> curser = table.cursor()){
      while (curser.next()) {
        logger.info("Is not in Driver Container: " + curser.get().getSlotPath());
      }
    }
  }

  @Override
  public IFuture post(Action action, BValue value, Context context) {
    if (find.equals(action)) {
      getWorker().addWork(new Invocation(this, find, value, context));
    }
    return null;
  }
  private static final Logger logger = Logger.getLogger("DriverFinder");
}
