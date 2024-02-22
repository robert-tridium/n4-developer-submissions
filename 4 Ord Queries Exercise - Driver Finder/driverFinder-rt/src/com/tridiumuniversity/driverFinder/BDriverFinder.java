package com.tridiumuniversity.driverFinder;

import javax.baja.collection.BITable;
import javax.baja.collection.Column;
import javax.baja.collection.ColumnList;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraAction(name = "find")
public class BDriverFinder extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.driverFinder.BDriverFinder(3201604963)1.0$ @*/
/* Generated Thu Feb 22 08:20:23 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Action "find"

  /**
   * Slot for the {@code find} action.
   * @see #find()
   */
  public static final Action find = newAction(0, null);

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

	@SuppressWarnings("unused")
	public void doFind() {
		BOrd ord = BOrd.make("bql:select slotPath from driver:DeviceNetwork where parent.slotPath != 'slot:/Drivers'");
		BITable result = (BITable)ord.resolve(Sys.getStation()).get();
		ColumnList columns = result.getColumns();
		Column valueColumn = columns.get(0);
		try(TableCursor c = result.cursor()){
			while(c.next()){
				BString path = (BString) c.cell(valueColumn);
				System.out.printf("cell: %s\n", path);
			}
		}
	}
}
