package com.tridiumuniversity.multiplexer;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "out",
        type = "BBoolean",
        defaultValue = "BBoolean.FALSE",
        flags = Flags.READONLY | Flags.SUMMARY
)
public class BMultiplexN extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.multiplexer.BMultiplexN(3653720171)1.0$ @*/
/* Generated Wed Nov 15 06:36:49 EST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "out"

  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.READONLY | Flags.SUMMARY, BBoolean.FALSE.as(BBoolean.class).getBoolean(), null);

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

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMultiplexN.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  //create array of properties (arraylist?)
  //add each new prop to the array
  //check size as root of 2
  //comp bits?
  //deceide out?
  public void changed(Property p, Context cx)
  {
    int maxS = 0, mult = 0;
    for (Property prop : getPropertiesArray())
    {
      if (prop.getName().matches("s\\d+") && get(prop).getType() == BBoolean.TYPE)
      {
        maxS = Math.max(maxS, Integer.valueOf(prop.getName().substring(1)));
      }
    }
    for (; maxS >= 0; maxS--)
    {
      BValue bool = get("s"+maxS);
      if (bool != null && ((BBoolean) bool).getBoolean()) mult += Math.pow(2, maxS);
    }
    BValue inToOut = get("in"+mult);
    if (inToOut != null && inToOut.getType() == BBoolean.TYPE) setOut(((BBoolean) inToOut).getBoolean());
    //setDebug(mult + "");
  }
}
