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
    public void added(Property p, Context cx)
    {
        calcSInputCount();
        calcInInputCount();
        calcInputStep();
        calcSwitchSum();
        updateOut();
    }
    @Override
    public void removed(Property p, BValue v, Context cx)
    {
        calcSInputCount();
        calcInInputCount();
        calcInputStep();
        calcSwitchSum();
        updateOut();
    }
    @Override
    public void renamed(Property p, String n, Context cx)
    {
        calcSInputCount();
        calcInInputCount();
        calcInputStep();
        calcSwitchSum();
        updateOut();
    }
    @Override
    public void changed(Property p, Context cx)
    {
        calcSwitchSum();
        updateOut();
    }


    /* Calculates how many "in" properties exist in the multiplexer */
    private void calcInInputCount()
    {
        inInputCount = 0; // reset the old count
        inInputs.clear(); // clear the old "in" input list
        SlotCursor<Property> propertyCursor = getProperties(); // create the cursor

        while (propertyCursor.next()) // iterate through the properties
        {
            Property property = propertyCursor.property();
            try
            {
                BBoolean value = (BBoolean) propertyCursor.get(); // get property value. If the property isn't a BBoolean, skip

                if (property.getName().startsWith("in")) {
                    inInputCount += 1; // add one to the count

                    inInputs.add(property);
                }
            }
            catch (Exception e)
            {
            }
        }
        log.fine("Counted INs: " + inInputCount); // FOR SOME REASON THIS LOGS IN THE WB CONSOLE WHEN SWITCHING VIEWS
    }


    /* Calculates how many "s" properties exist in the multiplexer */
    private void calcSInputCount()
    {
        sInputCount = 0; // reset the old count
        sInputs.clear(); // clear the old "s" input list
        SlotCursor<Property> propertyCursor = getProperties(); // create the cursor

        while (propertyCursor.next()) // iterate through the properties
        {
            Property property = propertyCursor.property(); // get property object
            try
            {
                BBoolean value = (BBoolean) propertyCursor.get(); // get property value. If the property isn't a BBoolean, skip

                if (property.getName().startsWith("s")) {
                    sInputCount += 1; // add one to the count

                    sInputs.add(property);
                }
            }
            catch (Exception e)
            {
            }
        }
        log.fine("Counted Ss: " + sInputCount); // FOR SOME REASON THIS LOGS IN THE WB CONSOLE WHEN SWITCHING VIEWS
    }


    /* Calculates the effective input step. The input step decides how many sInputs are needed/used */
    private void calcInputStep()
    {
        /* -1 in the loop so the iteration number matches with the index number of the array.
        I don't know if this is how it's normally done. It's the first time I've ever wanted to count backwards in a loop */
        for (int i = inputSteps.length - 1; i>-1; i--)
        //
        {
            if (inInputCount >= inputSteps[i])
            {
                effInputStep = i;
                log.fine("Effective input step: " + effInputStep);
                break;
            }
        }
    }


    /* Calculates the switchSum based on the combination of switches currently set to "true" */
    private void calcSwitchSum()
    {
        switchSum = 0; // reset the switchSum

        /* process all the "in" inputs */
        for (int i = 0; i<sInputs.size(); i++)
        {
            if (((BBoolean) sInputs.get(i).getDefaultValue()).getBoolean()) // get input as boolean. If true, add a numeric value to the switchSum
            {
                String propertyName = sInputs.get(i).getName(); // get the property's name
                int sNumber = Integer.parseInt(propertyName.replace("s", "")); // capture the number from the property's name

                int switchValue = switchValues[sNumber]; // figure out the switch's numeric value based on the switch number

                if (sNumber <= effInputStep - 1) // if the switch number is an "active" switch...
                {
                    switchSum += switchValue; // apply the numeric value towards the sum
                }
            }
        }

        setUsableSwitches(effInputStep);
        setSwitchTotal(switchSum);
    }


    /* updates the out property */
    private void updateOut()
    {
        log.info("Elevated Property: " + "in" + switchSum); // FOR SOME REASON THIS LOGS IN THE WB CONSOLE WHEN SWITCHING VIEWS

        setOut(((BBoolean) getProperty("in" + switchSum).getDefaultValue()).getBoolean()); // e.g. a switchSum of 18 will pass in18 to "out"
    }



    private int inInputCount; // the number of "in" inputs in the multiplexer
    private int sInputCount; // the number of "s" inputs in the multiplexer

    private ArrayList<Property> inInputs = new ArrayList<Property>(); // the "in" inputs as Property objects
    private ArrayList<Property> sInputs = new ArrayList<Property>(); // the "s" inputs as Property objects

    private final int[] inputSteps = {0, 2, 4, 8, 16, 32, 64, 128}; // values upon which more "s" inputs are needed/used
    private int effInputStep; // the current amount of "s" inputs needed/used

    private final int[] switchValues = {1, 2, 4, 8, 16, 32, 64};
    private int switchSum; // switchSum is the value calculated by the combination of switches that are "true"
    /* when a switch is "false", that switch counts a 0 towards the switchSum
    s0 counts as 1 when "true", s1 counts as 2 when "true", s2 counts as 4 when "true", s3 counts as 8 when "true", etc
    They work like a set of address DIP switches */

    //private String elevatedInput; // the current inInput being sent to "out"

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
