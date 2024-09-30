package com.tridiumuniversity.driverFinder;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.baja.naming.OrdTarget;
import javax.baja.naming.SlotPath;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Sys;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.baja.sys.Action;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraAction(
        name = "find",
        flags = Flags.ASYNC
)
public class BDriverFinder extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.driverFinder.BDriverFinder(2723955055)1.0$ @*/
/* Generated Fri Sep 27 07:44:37 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

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
       BITable <BComponent> table = (BITable<BComponent>) BOrd.make("bql:select * from driver:DeviceNetwork where navParent like 'Service Container' or navParent like 'App Container' or navParent like 'Folder'" )
               .get(Sys.getStation(), context);

     try (TableCursor<BComponent> curser = table.cursor()){
         while (curser.next()) {
             logger.info("Is not in Driver Container: " + curser.get().getSlotPath());
         }
       }
    }

    private static final Logger logger = Logger.getLogger("DriverFinder");
}
