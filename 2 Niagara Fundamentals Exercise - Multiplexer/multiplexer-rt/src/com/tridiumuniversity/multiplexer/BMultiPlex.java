package com.tridiumuniversity.multiplexer;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "in0",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)",
        flags = Flags.SUMMARY | Flags.DEFAULT_ON_CLONE
)
@NiagaraProperty(
        name = "in1",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)",
        flags = Flags.SUMMARY | Flags.DEFAULT_ON_CLONE
)
@NiagaraProperty(
        name = "in2",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)",
        flags = Flags.SUMMARY | Flags.DEFAULT_ON_CLONE
)
@NiagaraProperty(
        name = "in3",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)",
        flags = Flags.SUMMARY | Flags.DEFAULT_ON_CLONE
)
@NiagaraProperty(
        name = "s0",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)",
        flags = Flags.SUMMARY | Flags.DEFAULT_ON_CLONE
)
@NiagaraProperty(
        name = "s1",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)",
        flags = Flags.SUMMARY | Flags.DEFAULT_ON_CLONE
)
@NiagaraProperty(
        name = "out",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)",
        flags = Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE
)
public class BMultiPlex extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.multiplexer.BMultiPlex(3651298292)1.0$ @*/
/* Generated Wed Aug 21 13:17:20 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "in0"

  /**
   * Slot for the {@code in0} property.
   * @see #getIn0
   * @see #setIn0
   */
  public static final Property in0 = newProperty(Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BBoolean.make(false).as(BBoolean.class).getBoolean(), null);

  /**
   * Get the {@code in0} property.
   * @see #in0
   */
  public boolean getIn0() { return getBoolean(in0); }

  /**
   * Set the {@code in0} property.
   * @see #in0
   */
  public void setIn0(boolean v) { setBoolean(in0, v, null); }

  //endregion Property "in0"

  //region Property "in1"

  /**
   * Slot for the {@code in1} property.
   * @see #getIn1
   * @see #setIn1
   */
  public static final Property in1 = newProperty(Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BBoolean.make(false).as(BBoolean.class).getBoolean(), null);

  /**
   * Get the {@code in1} property.
   * @see #in1
   */
  public boolean getIn1() { return getBoolean(in1); }

  /**
   * Set the {@code in1} property.
   * @see #in1
   */
  public void setIn1(boolean v) { setBoolean(in1, v, null); }

  //endregion Property "in1"

  //region Property "in2"

  /**
   * Slot for the {@code in2} property.
   * @see #getIn2
   * @see #setIn2
   */
  public static final Property in2 = newProperty(Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BBoolean.make(false).as(BBoolean.class).getBoolean(), null);

  /**
   * Get the {@code in2} property.
   * @see #in2
   */
  public boolean getIn2() { return getBoolean(in2); }

  /**
   * Set the {@code in2} property.
   * @see #in2
   */
  public void setIn2(boolean v) { setBoolean(in2, v, null); }

  //endregion Property "in2"

  //region Property "in3"

  /**
   * Slot for the {@code in3} property.
   * @see #getIn3
   * @see #setIn3
   */
  public static final Property in3 = newProperty(Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BBoolean.make(false).as(BBoolean.class).getBoolean(), null);

  /**
   * Get the {@code in3} property.
   * @see #in3
   */
  public boolean getIn3() { return getBoolean(in3); }

  /**
   * Set the {@code in3} property.
   * @see #in3
   */
  public void setIn3(boolean v) { setBoolean(in3, v, null); }

  //endregion Property "in3"

  //region Property "s0"

  /**
   * Slot for the {@code s0} property.
   * @see #getS0
   * @see #setS0
   */
  public static final Property s0 = newProperty(Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BBoolean.make(false).as(BBoolean.class).getBoolean(), null);

  /**
   * Get the {@code s0} property.
   * @see #s0
   */
  public boolean getS0() { return getBoolean(s0); }

  /**
   * Set the {@code s0} property.
   * @see #s0
   */
  public void setS0(boolean v) { setBoolean(s0, v, null); }

  //endregion Property "s0"

  //region Property "s1"

  /**
   * Slot for the {@code s1} property.
   * @see #getS1
   * @see #setS1
   */
  public static final Property s1 = newProperty(Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BBoolean.make(false).as(BBoolean.class).getBoolean(), null);

  /**
   * Get the {@code s1} property.
   * @see #s1
   */
  public boolean getS1() { return getBoolean(s1); }

  /**
   * Set the {@code s1} property.
   * @see #s1
   */
  public void setS1(boolean v) { setBoolean(s1, v, null); }

  //endregion Property "s1"

  //region Property "out"

  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BBoolean.make(false).as(BBoolean.class).getBoolean(), null);

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
  public static final Type TYPE = Sys.loadType(BMultiPlex.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void changed(Property p, Context cx)
    {
        if (!isRunning()) return;
        calculate();
    }

    public void calculate()
    {
      if (!getS0() && !getS1()) {
        //out = in0
        setOut(getIn0());
      } else if (getS0() && !getS1()) {
        //out = in1
        setOut(getIn1());
      } else if (!getS0() && getS1()) {
        //out = in2
        setOut(getIn2());
      } else {
        //out = in3
        setOut(getIn3());
      }
    }
}
