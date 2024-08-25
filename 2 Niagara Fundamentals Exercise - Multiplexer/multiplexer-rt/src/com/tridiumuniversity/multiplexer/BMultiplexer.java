package com.tridiumuniversity.multiplexer;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.sys.*;
import java.util.ArrayList;
import java.util.logging.Logger;

@NiagaraType
@NiagaraProperty(
        name = "switchTotal",
        type = "BInteger",
        defaultValue = "BInteger.DEFAULT",
        flags = Flags.READONLY
)
@NiagaraProperty(
        name = "usableSwitches",
        type = "BInteger",
        defaultValue = "BInteger.DEFAULT",
        flags = Flags.READONLY
)
@NiagaraProperty(
        name = "out",
        type = "BBoolean",
        defaultValue = "BBoolean.DEFAULT",
        flags = Flags.SUMMARY | Flags.READONLY
)
public class BMultiplexer extends BComponent
{
    @Override
    public void started()
    {   // initializes the values when a component is dragged from the palette
        calcUsableInputCount();
        calcSLimit();
        calcSwitchSum();
        updateOut();
    }
    @Override
    public void added(Property p, Context cx)
    {
        if (p.getName().startsWith("in") || p.getName().startsWith("s"))
        {
            calcUsableInputCount();
            calcSLimit();
            calcSwitchSum();
            updateOut();

            Flags.add(this, p, Context.NULL, Flags.decodeFromString("s")); // user-friendly!
        }
    }
    @Override
    public void removed(Property p, BValue v, Context cx)
    {
        if (p.getName().startsWith("in") || p.getName().startsWith("s"))
        {
            calcUsableInputCount();
            calcSLimit();
            calcSwitchSum();
            updateOut();
        }
    }
    @Override
    public void renamed(Property p, String n, Context cx)
    {
        if (p.getName().startsWith("in") || p.getName().startsWith("s") || n.startsWith("in") || n.startsWith("s"))
        {
            calcUsableInputCount();
            calcSLimit();
            calcSwitchSum();
            updateOut();

            Flags.add(this, p, Context.NULL, Flags.decodeFromString("s")); // user-friendly!
        }
    }
    @Override
    public void changed(Property p, Context cx)
    {
        if (p.getName().startsWith("in") || p.getName().startsWith("s"))
        {
            calcSwitchSum();
            updateOut();
        }
    }


    /* Calculates how many "in" properties and "s" properties exist in the multiplexer */
    private void calcUsableInputCount()
    {
        if (!isRunning()) return; // allows the station to run this method but not workbench itself

        inInputCount = 0; // reset the old counts
        sInputCount = 0;

        for (Property property : getProperties())
        {
            if (get(property) instanceof BBoolean)
            {
                if (property.getName().startsWith("in")) {
                    inInputCount += 1;
                }

                if (property.getName().startsWith("s")) {
                    sInputCount += 1;
                }
            }
        }
        log.fine("Counted INs: " + inInputCount);
        log.fine("Counted Ss: " + sInputCount);
    }


    /* Calculates the effective input step. The input step decides how many sInputs are needed/used */
    private void calcSLimit()
    {
        if (!isRunning()) return;

        /* -1 in the loop so the iteration number matches with the index number of the array. */
        for (int i = 7; i>-1; i--)
        {
            if (inInputCount >= (int) Math.pow(2, i))
            {
                sLimit = i;
                log.fine("Effective input step: " + sLimit);
                break;
            }
            else
            {
                sLimit = 0;
            }
        }
    }


    /* Calculates the switchSum based on the combination of switches currently set to "true" */
    private void calcSwitchSum()
    {
        if (!isRunning()) return;

        switchSum = 0; // reset the switchSum

        /* process all the "in" inputs */
        for (int i = 0; i<sInputCount; i++)
        {
            if (!(get("s" + i) instanceof BBoolean)) // if the s input isn't a BBoolean, skip
            {
                continue;
            }

            if (getBoolean(getProperty("s" + i))) // If switch is true, add a numeric value to the switchSum
            {
                int switchValue = (int) Math.pow(2, i); // figure out the switch's numeric value based on the switch number

                if (i <= sLimit - 1) // if the switch number is an "active" switch...
                {
                    switchSum += switchValue; // apply the numeric value towards the sum
                }
            }
        }

        setUsableSwitches(sLimit);
        setSwitchTotal(switchSum);
    }


    /* updates the out property */
    private void updateOut()
    {
        if (!isRunning()) return;

        log.info("Elevated Property: " + "in" + switchSum);

        setOut(((BBoolean) getProperty("in" + switchSum).getDefaultValue()).getBoolean()); // e.g. a switchSum of 18 will pass in18 to "out"
    }



    private int inInputCount; // the number of "in" inputs in the multiplexer
    private int sInputCount; // the number of "s" inputs in the multiplexer

    private int sLimit; // the current amount of "s" inputs needed/used

    private int switchSum; // switchSum is the value calculated by the combination of switches that are "true"
    /* when a switch is "false", that switch counts a 0 towards the switchSum
    s0 counts as 1 when "true", s1 counts as 2 when "true", s2 counts as 4 when "true", s3 counts as 8 when "true", etc
    They work like a set of address DIP switches */

    private static final Logger log = Logger.getLogger("multiplexer.multiplexer");

//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.multiplexer.BMultiplexer(2176542802)1.0$ @*/
/* Generated Thu Aug 22 08:48:43 CDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "switchTotal"

  /**
   * Slot for the {@code switchTotal} property.
   * @see #getSwitchTotal
   * @see #setSwitchTotal
   */
  public static final Property switchTotal = newProperty(Flags.READONLY, BInteger.DEFAULT.as(BInteger.class).getInt(), null);

  /**
   * Get the {@code switchTotal} property.
   * @see #switchTotal
   */
  public int getSwitchTotal() { return getInt(switchTotal); }

  /**
   * Set the {@code switchTotal} property.
   * @see #switchTotal
   */
  public void setSwitchTotal(int v) { setInt(switchTotal, v, null); }

  //endregion Property "switchTotal"

  //region Property "usableSwitches"

  /**
   * Slot for the {@code usableSwitches} property.
   * @see #getUsableSwitches
   * @see #setUsableSwitches
   */
  public static final Property usableSwitches = newProperty(Flags.READONLY, BInteger.DEFAULT.as(BInteger.class).getInt(), null);

  /**
   * Get the {@code usableSwitches} property.
   * @see #usableSwitches
   */
  public int getUsableSwitches() { return getInt(usableSwitches); }

  /**
   * Set the {@code usableSwitches} property.
   * @see #usableSwitches
   */
  public void setUsableSwitches(int v) { setInt(usableSwitches, v, null); }

  //endregion Property "usableSwitches"

  //region Property "out"

  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.SUMMARY | Flags.READONLY, BBoolean.DEFAULT.as(BBoolean.class).getBoolean(), null);

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
  public static final Type TYPE = Sys.loadType(BMultiplexer.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/





}
