package com.tridiumuniversity.driverFinder;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.query.BQueryResult;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BValue;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.tag.Entity;
import javax.baja.util.IFuture;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

@NiagaraType
@NiagaraAction(
        name = "find",
        flags = Flags.ASYNC
)
public class BDriverFinderNEQL extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.driverFinder.BDriverFinderNEQL(2723955055)1.0$ @*/
/* Generated Mon Sep 30 12:58:36 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

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
  public static final Type TYPE = Sys.loadType(BDriverFinderNEQL.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void doFind (Context context) {
        BQueryResult result = (BQueryResult)BOrd.make("neql:n:network and n:parent->n:type!='driver:DriverContainer'").get(Sys.getStation(), context);
        result.stream().forEach(this::processEntity);
        }
    private void processEntity(Entity entity) {
        BComponent component = (BComponent)entity;
        logger.info("Is not in Driver Container: " + component.getSlotPath());
    }
    @Override
    public void started() { executor = newSingleThreadExecutor();}
    @Override
    public void stopped() {
        if (executor != null) {
            executor.shutdownNow();
        }
    }
    @Override
    public IFuture post(Action action, BValue argument, Context context){
        if (find.equals(action)) {
            executor.execute(() -> doFind(context));
        }
        return null;
    }
    private ExecutorService executor;
    private static final Logger logger = Logger.getLogger("DriverFinder");
}
