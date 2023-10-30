# Exercise 3: Recursive Unhider
In this exercise, you will create a service that traverses a component tree and unhides all slots.

## Description
Create a new service with a `BOrd` property named `rootOrd` and an action named `unhide`. Invoking the `unhide` action should submit a job to the JobService that performs a search of the component tree rooted at `rootOrd` and unhides all slots that currently have the `HIDDEN` flag. For each slot that was previously hidden and was unhidden, log its slotPath to the job log. Keep in mind that `javax.baja.sys.Flags` has some very helpful utility methods.

For an added challenge, add a `String` property to your service named `regex` and only unhide slots whose names match the `regex`.

## Recommended Steps
Try to implement the behavior described above without reading this section. If you need a nudge in the right direction, here are some recommended steps.

1. Create a class that extends `BAbstractService` and add the three annotations necessary to mark this component as a Niagara Type and set up its slots.
2. Create a class that extends `BSimpleJob` and add the annotation necessary to mark it as a Niagara Type.
3. Define a recursive method in `BSimpleJob` that takes a `BComponent` as a parameter and unhides all of its slots, then calls itself on all of that component's child `BComponent` slots. Look through the `javax.baja.sys.Flags` class for methods that check a slot's flags and remove flags from a slot.
4. Override the `run()` method in `BSimpleJob` to call your recursive method on the component at `rootOrd`.
5. Implement the `unhide` action in your service to submit your job to the JobService when invoked.
6. To test your component in a station, add some dynamic slots to some components, make them hidden by adding the `HIDDEN` flag, and then test that your service unhides them and logs their slotPaths to the job log.
