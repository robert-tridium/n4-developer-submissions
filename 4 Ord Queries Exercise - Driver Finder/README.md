# Exercise 4: Driver Finder
In this exercise, you will create a component that locates drivers in a station that are not underneath the Driver Container.

## Description
Create a new component with an action named `find`. When invoked, this action should search the entire station component tree for any Device Network (any subclass of `driver:DeviceNetwork`) that is not a child of the Driver Container (the container named `Drivers` underneath `Config`). The component should log the slotPath of any drivers it finds at the `INFO` level.

## Recommended Steps
Try to implement the behavior described above without reading this section. If you need a nudge in the right direction, here are some recommended steps.

1. Start a station and add a driver somewhere that is not under the Drivers Container (for instance, you can open the `bacnet` palette and drag a `BacnetNetwork` somewhere in your station).
2. Hit Ctrl+L to bring up the Ord dialog in Workbench and experiment until you find an ORD that resolves to a table containing the driver you just added but not the `NiagaraNetwork` (which is a Device Network underneath the Driver Container by default).
3. Create a component with an action named `find`. Implement the action such that it creates and resolves the ORD you found in Step 2.
4. Once you have the `BITable` from resolving the ORD in Step 3, iterate through it using a `TableCursor` and extract the `slotPath` from each component your ORD finds. Log the `slotPath` and you're done!

## Added Challenge
If you used BQL to complete this exercise, try it again but with NEQL (hint: Device Networks are tagged by the framework with `n:network` marker tags). If you used NEQL, try it again with BQL.