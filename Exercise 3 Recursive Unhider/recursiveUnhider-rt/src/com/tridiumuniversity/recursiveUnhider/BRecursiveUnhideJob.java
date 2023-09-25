package com.tridiumuniversity.recursiveUnhider;

import javax.baja.job.BSimpleJob;
import javax.baja.job.JobCancelException;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType

public class BRecursiveUnhideJob extends BSimpleJob
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridiumuniversity.recursiveUnhider.BRecursiveUnhideJob(2979906276)1.0$ @*/
/* Generated Mon Sep 25 13:09:22 CEST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BRecursiveUnhideJob.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    @Override
    public void run(Context context)
    {
        // Find BRecursiveUnhiderService
        BRecursiveUnhiderService recursiveUnhiderService = (BRecursiveUnhiderService) Sys.getService(BRecursiveUnhiderService.TYPE);
        if (recursiveUnhiderService == null)
        {
            throw new IllegalStateException("Recursive Unhider Service not available.");
        }

        log().start("Preparing to search for hidden components...");

        // Prepare query to find hidden components
        BOrd rootOrd = recursiveUnhiderService.getRootOrd();
        BComponent rootComponent = (BComponent) rootOrd.get();

        // Loop through station from root component
        String regex = recursiveUnhiderService.getRegex();
        process(rootComponent, regex);
    }

    /**
     * Recursively process components and unhide hidden slots
     *
     * @param component Root component to process from
     * @param regex     Regular expression to match slot names
     */
    public void process(BComponent component, String regex)
    {
        if (canceled)
        {
            throw new JobCancelException();
        }
        // Get all slots for the component
        Slot[] slots = component.getSlotsArray();

        //Loop through slots
        for (Slot slot : slots)
        {
            // Check if slot is hidden
            if (Flags.isHidden(component, slot))
            {
                // Build message text for log
                String message = "Found hidden component: " +
                        component.getSlotPath() + "/" + slot.getName() + " - ";

                // Check if regex is empty or matches slot name
                if (regex.equals("") ||
                        slot.getName().matches(regex))
                {
                    // Unhide component and update log message
                    message = message + "Unhiding...";
                    Flags.remove(component, slot, null, Flags.HIDDEN);
                }
                else
                {
                    // Update log message
                    message = message + "Doesn't match regex: Skipping...";
                }

                log().message(message);
            }
        }

        // Loop through child components and process them. Send heartbeat to avoid timeout.
        for (BComponent child : component.getChildComponents())
        {
            heartbeat();
            process(child, regex);
        }
    }

    /**
     * Callback when the user cancels this active job.
     */
    @Override
    public void doCancel(Context cx)
    { // Overridden here to set the canceled flag
        canceled = true;
        super.doCancel(cx);
    }

    // This flag gets set if the user cancels the active job
    private boolean canceled = false;
}
