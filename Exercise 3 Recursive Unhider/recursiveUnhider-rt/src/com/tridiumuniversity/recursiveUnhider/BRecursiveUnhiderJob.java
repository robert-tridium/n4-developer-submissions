package com.tridiumuniversity.recursiveUnhider;

import javax.baja.job.BSimpleJob;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
public class BRecursiveUnhiderJob extends BSimpleJob
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridiumuniversity.recursiveUnhider.BRecursiveUnhiderJob(2979906276)1.0$ @*/
/* Generated Mon Sep 25 23:23:41 AEST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BRecursiveUnhiderJob.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    @Override
    public void run(Context cx)
    {
        BRecursiveUnhiderService recursiveUnhiderService = (BRecursiveUnhiderService)Sys.getService(BRecursiveUnhiderService.TYPE);
        if (recursiveUnhiderService == null)
        {
            throw new IllegalStateException("Recursive Unhider Service not available.");
        }
        if(!recursiveUnhiderService.getRootOrd().isNull())
        {
            try
            {
                BComponent component = (BComponent)recursiveUnhiderService.getRootOrd().get(Sys.getStation());
                unhideChildren(component, cx);
            }
            catch(Exception e)
            {
                BRecursiveUnhiderService.log.severe(e.toString());
            }
        }
    }

    public void unhideChildren(BComponent component, Context cx)
    {
        SlotCursor<Slot> slots = component.getSlots();
        while(slots.next())
        {
            if(slots.slot().isDynamic())
            {
                if(Flags.isHidden(component, slots.slot()))
                {
                    BRecursiveUnhiderService.log.info("Removing Hidden Flag on Slot: " + slots.slot().getName() + " on Component: " + component);
                    Flags.remove(component, slots.slot(), cx, Flags.HIDDEN);
                }
                if(slots.get().isComponent())
                {
                    unhideChildren(slots.get().asComponent(), cx);
                }
            }
        }
    }
}
