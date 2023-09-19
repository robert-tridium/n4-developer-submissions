package com.tridiumuniversity.multiplexer;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "out",
        type = "BBoolean",
        flags = Flags.READONLY | Flags.SUMMARY,
        defaultValue = "BBoolean.DEFAULT"
)
@NiagaraProperty(
        name = "s0",
        type = "BBoolean",
        flags = Flags.SUMMARY,
        defaultValue = "BBoolean.DEFAULT"
)
@NiagaraProperty(
        name = "s1",
        type = "BBoolean",
        flags = Flags.SUMMARY,
        defaultValue = "BBoolean.DEFAULT"
)
@NiagaraProperty(
        name = "in0",
        type = "BBoolean",
        flags = Flags.SUMMARY,
        defaultValue = "BBoolean.DEFAULT"
)
@NiagaraProperty(
        name = "in1",
        type = "BBoolean",
        flags = Flags.SUMMARY,
        defaultValue = "BBoolean.DEFAULT"
)
@NiagaraProperty(
        name = "in2",
        type = "BBoolean",
        flags = Flags.SUMMARY,
        defaultValue = "BBoolean.DEFAULT"
)
@NiagaraProperty(
        name = "in3",
        type = "BBoolean",
        flags = Flags.SUMMARY,
        defaultValue = "BBoolean.DEFAULT"
)
public class BMux extends BComponent
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridiumuniversity.multiplexer.BMux(3188056521)1.0$ @*/
/* Generated Tue Sep 19 22:46:31 SGT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "out"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.READONLY | Flags.SUMMARY, ((BBoolean)(BBoolean.DEFAULT)).getBoolean(), null);
  
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

////////////////////////////////////////////////////////////////
// Property "s0"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code s0} property.
   * @see #getS0
   * @see #setS0
   */
  public static final Property s0 = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.DEFAULT)).getBoolean(), null);
  
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

////////////////////////////////////////////////////////////////
// Property "s1"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code s1} property.
   * @see #getS1
   * @see #setS1
   */
  public static final Property s1 = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.DEFAULT)).getBoolean(), null);
  
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

////////////////////////////////////////////////////////////////
// Property "in0"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in0} property.
   * @see #getIn0
   * @see #setIn0
   */
  public static final Property in0 = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.DEFAULT)).getBoolean(), null);
  
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

////////////////////////////////////////////////////////////////
// Property "in1"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in1} property.
   * @see #getIn1
   * @see #setIn1
   */
  public static final Property in1 = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.DEFAULT)).getBoolean(), null);
  
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

////////////////////////////////////////////////////////////////
// Property "in2"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in2} property.
   * @see #getIn2
   * @see #setIn2
   */
  public static final Property in2 = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.DEFAULT)).getBoolean(), null);
  
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

////////////////////////////////////////////////////////////////
// Property "in3"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in3} property.
   * @see #getIn3
   * @see #setIn3
   */
  public static final Property in3 = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.DEFAULT)).getBoolean(), null);
  
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

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMux.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  @Override
  public void changed(Property property, Context context) {
    super.changed(property, context);

    if(!out.equals(property)){
      if(!getS1() && !getS0()) setOut(getIn0());
      if(!getS1() && getS0()) setOut(getIn1());
      if(getS1() && !getS0()) setOut(getIn2());
      if(getS1() && getS0()) setOut(getIn3());
    }
  }
}
