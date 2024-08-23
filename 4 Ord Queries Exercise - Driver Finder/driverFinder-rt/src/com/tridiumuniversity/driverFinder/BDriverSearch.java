package com.tridiumuniversity.driverFinder;

import javax.baja.collection.*;
import javax.baja.naming.BOrd;
import javax.baja.naming.SlotPath;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusBoolean;
import javax.baja.sys.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.regex.Pattern;

@NiagaraType
@NiagaraProperty(
        name = "slotNameRegex",
        type = "String",
        defaultValue = "\".*\"",
        flags = Flags.HIDDEN
)
@NiagaraAction(
        name = "find",
        flags = Flags.SUMMARY
)
public class BDriverSearch extends BComponent{
    private static final Logger logger = Logger.getLogger("Driver Finder");

    public void doFind(Context cx) {
        Pattern regex = Pattern.compile(getSlotNameRegex());
        BITable<? extends BIObject> table = (BITable<? extends BIObject>) BOrd.make("bql:select * from driver:DeviceNetwork where parent.slotPath != 'slot:/Drivers'").get(Sys.getStation(), cx);

        ColumnList columns = table.getColumns();
        Column slotColumn = columns.get("slotPath");

        try(TableCursor<? extends BIObject> cursor = table.cursor()) {
            while (cursor.next()) {
                String ord = ((BString)cursor.cell(slotColumn)).getString();
                if(regex.matcher(ord).matches()) {
                    if(logger.isLoggable(Level.INFO)) {
                        logger.info(String.format("Driver Found at Ord - " + ord));
                    }
                }
            }
        }

    }
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.driverFinder.BDriverSearch(1648588232)1.0$ @*/
/* Generated Fri Aug 23 11:34:01 BST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "slotNameRegex"

  /**
   * Slot for the {@code slotNameRegex} property.
   * @see #getSlotNameRegex
   * @see #setSlotNameRegex
   */
  public static final Property slotNameRegex = newProperty(Flags.HIDDEN, ".*", null);

  /**
   * Get the {@code slotNameRegex} property.
   * @see #slotNameRegex
   */
  public String getSlotNameRegex() { return getString(slotNameRegex); }

  /**
   * Set the {@code slotNameRegex} property.
   * @see #slotNameRegex
   */
  public void setSlotNameRegex(String v) { setString(slotNameRegex, v, null); }

  //endregion Property "slotNameRegex"

  //region Action "find"

  /**
   * Slot for the {@code find} action.
   * @see #find()
   */
  public static final Action find = newAction(Flags.SUMMARY, null);

  /**
   * Invoke the {@code find} action.
   * @see #find
   */
  public void find() { invoke(find, null, null); }

  //endregion Action "find"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDriverSearch.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
