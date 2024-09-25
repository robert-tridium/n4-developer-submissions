package com.tridiumuniversity.multiplexer;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.sys.BBoolean;

import javax.baja.sys.BComponent;
import javax.baja.sys.Flags;

@NiagaraType

@NiagaraProperty(
    name = "ln0",
    type = "BInteger",
    defaultValue = "BInteger.make(0)",
    flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "ln1",
        type = "BInteger",
        defaultValue = "BInteger.make(1)",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "ln2",
        type = "BInteger",
        defaultValue = "BInteger.make(2)",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "ln3",
        type = "BInteger",
        defaultValue = "BInteger.make(3)",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "s0",
        type = "BBoolean",
        defaultValue = "BBoolean.FALSE",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name = "s1",
        type = "BBoolean",
        defaultValue = "BBoolean.FALSE",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "out",
        type = "BInteger",
        defaultValue = "BInteger.make(0)",
        flags = Flags.READONLY | Flags.SUMMARY
)

public class BMultiplexer extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.multiplexer.BMultiplexer(2450380299)1.0$ @*/
/* Generated Wed Sep 25 10:55:41 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "ln0"

  /**
   * Slot for the {@code ln0} property.
   * @see #getLn0
   * @see #setLn0
   */
  public static final Property ln0 = newProperty(Flags.SUMMARY, BInteger.make(0).as(BInteger.class).getInt(), null);

  /**
   * Get the {@code ln0} property.
   * @see #ln0
   */
  public int getLn0() { return getInt(ln0); }

  /**
   * Set the {@code ln0} property.
   * @see #ln0
   */
  public void setLn0(int v) { setInt(ln0, v, null); }

  //endregion Property "ln0"

  //region Property "ln1"

  /**
   * Slot for the {@code ln1} property.
   * @see #getLn1
   * @see #setLn1
   */
  public static final Property ln1 = newProperty(Flags.SUMMARY, BInteger.make(1).as(BInteger.class).getInt(), null);

  /**
   * Get the {@code ln1} property.
   * @see #ln1
   */
  public int getLn1() { return getInt(ln1); }

  /**
   * Set the {@code ln1} property.
   * @see #ln1
   */
  public void setLn1(int v) { setInt(ln1, v, null); }

  //endregion Property "ln1"

  //region Property "ln2"

  /**
   * Slot for the {@code ln2} property.
   * @see #getLn2
   * @see #setLn2
   */
  public static final Property ln2 = newProperty(Flags.SUMMARY, BInteger.make(2).as(BInteger.class).getInt(), null);

  /**
   * Get the {@code ln2} property.
   * @see #ln2
   */
  public int getLn2() { return getInt(ln2); }

  /**
   * Set the {@code ln2} property.
   * @see #ln2
   */
  public void setLn2(int v) { setInt(ln2, v, null); }

  //endregion Property "ln2"

  //region Property "ln3"

  /**
   * Slot for the {@code ln3} property.
   * @see #getLn3
   * @see #setLn3
   */
  public static final Property ln3 = newProperty(Flags.SUMMARY, BInteger.make(3).as(BInteger.class).getInt(), null);

  /**
   * Get the {@code ln3} property.
   * @see #ln3
   */
  public int getLn3() { return getInt(ln3); }

  /**
   * Set the {@code ln3} property.
   * @see #ln3
   */
  public void setLn3(int v) { setInt(ln3, v, null); }

  //endregion Property "ln3"

  //region Property "s0"

  /**
   * Slot for the {@code s0} property.
   * @see #getS0
   * @see #setS0
   */
  public static final Property s0 = newProperty(Flags.SUMMARY, BBoolean.FALSE.as(BBoolean.class).getBoolean(), null);

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
  public static final Property s1 = newProperty(Flags.SUMMARY, BBoolean.FALSE.as(BBoolean.class).getBoolean(), null);

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
  public static final Property out = newProperty(Flags.READONLY, BInteger.make(0).as(BInteger.class).getInt(), null);

  /**
   * Get the {@code out} property.
   * @see #out
   */
  public int getOut() { return getInt(out); }

  /**
   * Set the {@code out} property.
   * @see #out
   */
  public void setOut(int v) { setInt(out, v, null); }

  //endregion Property "out"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMultiplexer.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  @Override
  public void changed(Property property, Context context) {
    super.changed(property, context);
    //System.out.println("Property changed: " + property.getName());
    updateOutput();
  }

  public void updateOutput () {
    if (!getS0() && !getS1()) {
      setOut(getLn0());
    }
    if (!getS0() && getS1()) {
      setOut(getLn1());
    }
    if (getS0() && !getS1()) {
      setOut(getLn2());
    }
    if (getS0() && getS1()) {
      setOut(getLn3());
    }
  }

}
