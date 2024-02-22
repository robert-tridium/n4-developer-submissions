package com.tridiumuniversity.driverFinder;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraEnum(
	range = {
		@Range("bql"),
		@Range("neql")
	},
	defaultValue = "bql"
)
public final class BQueryImplementation extends BFrozenEnum {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.driverFinder.BQueryImplementation(883047439)1.0$ @*/
/* Generated Thu Feb 22 09:12:51 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  /** Ordinal value for bql. */
  public static final int BQL = 0;
  /** Ordinal value for neql. */
  public static final int NEQL = 1;

  /** BQueryImplementation constant for bql. */
  public static final BQueryImplementation bql = new BQueryImplementation(BQL);
  /** BQueryImplementation constant for neql. */
  public static final BQueryImplementation neql = new BQueryImplementation(NEQL);

  /** Factory method with ordinal. */
  public static BQueryImplementation make(int ordinal)
  {
    return (BQueryImplementation)bql.getRange().get(ordinal, false);
  }

  /** Factory method with tag. */
  public static BQueryImplementation make(String tag)
  {
    return (BQueryImplementation)bql.getRange().get(tag);
  }

  /** Private constructor. */
  private BQueryImplementation(int ordinal)
  {
    super(ordinal);
  }

  public static final BQueryImplementation DEFAULT = bql;

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BQueryImplementation.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
