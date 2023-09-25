package com.tridiumuniversity.recursiveUnhider;

import javax.baja.job.BSimpleJob;
import javax.baja.job.JobCancelException;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
public class BUnhideJob extends BSimpleJob
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridiumuniversity.recursiveUnhider.BUnhideJob(2979906276)1.0$ @*/
/* Generated Mon Sep 25 19:38:22 SGT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUnhideJob.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public BUnhideJob(){}
  public BUnhideJob(BComponent rootComp){
    this.rootComp = rootComp;
  }

  @Override
  public void run(Context context){
    unhideSlots(this.rootComp);
  }

  private void unhideSlots(BComponent parentComp){
    if(parentComp == null) throw new IllegalArgumentException("Root component must be valid.");

    // loop through all the slots
    Slot[] slots = parentComp.getSlotsArray();

    for(Slot slot:slots){
      if (canceled)
      {
        throw new JobCancelException();
      }
      heartbeat();

      if(Flags.isHidden(parentComp,slot)){
        int propFlags = parentComp.getFlags(slot);
        int newFlags = propFlags & ~Flags.HIDDEN;

        parentComp.setFlags(slot,newFlags);

        log().message("Unhidden slot : " + parentComp.getSlotPath() + "." + slot.getName());
      }
    }

    // loop through all the child components' slots
    SlotCursor<Property> c = parentComp.getProperties();
    int count = 0;
    while (c.nextComponent())
    {
      unhideSlots((BComponent)c.get());
    }
  }

  @Override
  public void doCancel(Context cx)
  { // Overridden here to set the canceled flag
    canceled = true;
    super.doCancel(cx);
  }

  // This flag gets set if the user cancels the active job
  private boolean canceled = false;
  private BComponent rootComp;
}
