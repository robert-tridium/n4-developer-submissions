package com.tridiumuniversity.trafficLightWidget;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

import javax.baja.sys.BComponent;

@NiagaraType
@NiagaraProperty(
  name = "minimumYellowTime",
  type = "baja:RelTime",
  defaultValue = "BRelTime.makeSeconds(5)"
)
@NiagaraProperty(
  name = "state",
  type = "BTrafficLightState",
  defaultValue = "BTrafficLightState.red"
)
@NiagaraProperty(
  name = "lastChange",
  type = "baja:AbsTime",
  defaultValue = "BAbsTime.NULL"
)
@NiagaraAction(
  name="transition",
  parameterType="BTrafficLightState",
  defaultValue = "BTrafficLightState.red"
)
public class BTrafficLight extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightWidget.BTrafficLight(942206876)1.0$ @*/
/* Generated Tue Oct 31 13:27:24 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "minimumYellowTime"

  /**
   * Slot for the {@code minimumYellowTime} property.
   * @see #getMinimumYellowTime
   * @see #setMinimumYellowTime
   */
  public static final Property minimumYellowTime = newProperty(0, BRelTime.makeSeconds(5), null);

  /**
   * Get the {@code minimumYellowTime} property.
   * @see #minimumYellowTime
   */
  public BRelTime getMinimumYellowTime() { return (BRelTime)get(minimumYellowTime); }

  /**
   * Set the {@code minimumYellowTime} property.
   * @see #minimumYellowTime
   */
  public void setMinimumYellowTime(BRelTime v) { set(minimumYellowTime, v, null); }

  //endregion Property "minimumYellowTime"

  //region Property "state"

  /**
   * Slot for the {@code state} property.
   * @see #getState
   * @see #setState
   */
  public static final Property state = newProperty(0, BTrafficLightState.red, null);

  /**
   * Get the {@code state} property.
   * @see #state
   */
  public BTrafficLightState getState() { return (BTrafficLightState)get(state); }

  /**
   * Set the {@code state} property.
   * @see #state
   */
  public void setState(BTrafficLightState v) { set(state, v, null); }

  //endregion Property "state"

  //region Property "lastChange"

  /**
   * Slot for the {@code lastChange} property.
   * @see #getLastChange
   * @see #setLastChange
   */
  public static final Property lastChange = newProperty(0, BAbsTime.NULL, null);

  /**
   * Get the {@code lastChange} property.
   * @see #lastChange
   */
  public BAbsTime getLastChange() { return (BAbsTime)get(lastChange); }

  /**
   * Set the {@code lastChange} property.
   * @see #lastChange
   */
  public void setLastChange(BAbsTime v) { set(lastChange, v, null); }

  //endregion Property "lastChange"

  //region Action "transition"

  /**
   * Slot for the {@code transition} action.
   * @see #transition(BTrafficLightState parameter)
   */
  public static final Action transition = newAction(0, BTrafficLightState.red, null);

  /**
   * Invoke the {@code transition} action.
   * @see #transition
   */
  public void transition(BTrafficLightState parameter) { invoke(transition, parameter, null); }

  //endregion Action "transition"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLight.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void doTransition(BTrafficLightState newState)
  {
    BTrafficLightState oldState = getState();
    if (stateChangeScheduled())
    {
      cancelStateChange();
    }

    if (oldState.equals(BTrafficLightState.green) && newState.equals(BTrafficLightState.red))
    {
      setState(BTrafficLightState.yellow);
      scheduleStateChange(getMinimumYellowTime(), BTrafficLightState.red);
    }
    else if (oldState.equals(BTrafficLightState.yellow) && newState.equals(BTrafficLightState.red))
    {
      long timeInYellow = getLastChange().delta(BAbsTime.now()).getMillis();
      long timeLeftInYellow = getMinimumYellowTime().getMillis() - timeInYellow;

      if (timeLeftInYellow > 0)
      {
        scheduleStateChange(BRelTime.make(timeLeftInYellow), newState);
      }
      else
      {
        setState(newState);
      }
    }
    else
    {
      setState(newState);
    }

    if(!getState().equals(oldState))
    {
      setLastChange(BAbsTime.now());
    }
  }

  private void scheduleStateChange(BRelTime delay, BTrafficLightState newState)
  {
    ticket = Clock.schedule(this, delay, transition, newState);
  }

  private boolean stateChangeScheduled()
  {
    return ticket != null && !ticket.isExpired();
  }

  private void cancelStateChange()
  {
    if (ticket != null)
    {
      ticket.cancel();
      ticket = null;
    }
  }

  private Clock.Ticket ticket = null;
}
