package com.tridiumuniversity.driverFinder;

import javax.baja.collection.BITable;
import javax.baja.collection.Column;
import javax.baja.collection.ColumnList;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.query.BQueryResult;
import javax.baja.sys.*;
import java.util.logging.Logger;

@NiagaraType
@NiagaraAction(name = "find", parameterType = "BQueryImplementation", defaultValue = "BQueryImplementation.bql")
public class BDriverFinder extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.driverFinder.BDriverFinder(3872368741)1.0$ @*/
/* Generated Thu Feb 22 09:14:00 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Action "find"

  /**
   * Slot for the {@code find} action.
   * @see #find(BQueryImplementation parameter)
   */
  public static final Action find = newAction(0, BQueryImplementation.bql, null);

  /**
   * Invoke the {@code find} action.
   * @see #find
   */
  public void find(BQueryImplementation parameter) { invoke(find, parameter, null); }

  //endregion Action "find"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDriverFinder.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

	@SuppressWarnings("unused")
	public void doFind(BQueryImplementation impl, Context cx) {
		if(impl.equals(BQueryImplementation.bql)) useBql(cx);
		else useNeql(cx);
	}

	private static void useBql(Context cx) {
		BOrd ord = BOrd.make("bql:select slotPath from driver:DeviceNetwork where parent.slotPath != 'slot:/Drivers'");
		BITable result = (BITable)ord.get(Sys.getStation(), cx);
		ColumnList columns = result.getColumns();
		Column valueColumn = columns.get(0);
		try(TableCursor c = result.cursor()){
			while(c.next()){
				BString path = (BString) c.cell(valueColumn);
				log.info(path.toString());
			}
		}
	}

	private static void useNeql(Context cx) {
		BOrd query = BOrd.make("neql:n:network and n:parent->n:type != \"driver:DriverContainer\"");
		BQueryResult result = (BQueryResult)query.get(Sys.getStation(), cx);
		result.stream()
			.map(e -> ((BComponent)e).getSlotPath().toString())
			.forEach(log::info);
	}

	private static final Logger log = Logger.getLogger("driverFinder");
}
