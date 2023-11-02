# Exercise 3: Recursive Unhider
In this exercise, you will create a component that traverses a component tree and unhides all hidden slots.

## Description
Create a new component with an Action named `unhide`. Invoking the `unhide` Action should perform a search of the component tree rooted at the component's parent and unhide all slots that currently have the `HIDDEN` flag. Keep in mind that `javax.baja.sys.Flags` has some very helpful utility methods.

## Recommended Steps
Try to implement the behavior described above without reading this section. If you need a nudge in the right direction, here are some recommended steps.

1. Create a Java class to hold your Niagara component in this module. Don't forget to make your Java class a subclass of the appropriate Niagara type and add the necessary annotations.
2. Define a recursive method that takes a `BComponent` as a parameter and unhides all of its slots, then calls itself on all of that component's child `BComponent` slots. Look through the `javax.baja.sys.Flags` class for methods that check a slot's flags and remove flags from a slot.
3. Implement the `unhide` Action in your component to call your recursive method on the component's parent.
4. To test your component in a station, add some dynamic slots to some components, make them hidden by adding the `HIDDEN` flag, and then test that your component unhides them.

## Added Challenge
For an added challenge, add a `String` Property to your component named `regex` and only unhide slots whose names match the `regex`.