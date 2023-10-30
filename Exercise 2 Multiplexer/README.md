# Exercise 2: Multiplexer
In this exercise, you will create a Niagara Component that implements the behavior of a 4-to-1 multiplexer.

## Description
 Your component should have the following behavior:
* There should be six inputs of type `BBoolean` named `in0`, `in1`, `in2`, `in3`, `s0`, and `s1`.
* There should be one output of type `BBoolean` named `out`.
* The value of `out` should always be equal to `in0`, `in1`, `in2`, or `in3`. The current value of `out` is determined by `s0` and `s1` according to the following truth table:

| `s1` | `s0` | `out` |
| ---- | ---- | ----- |
| F | F | `in0` |
| F | T | `in1` |
| T | F | `in2` |
| T | T | `in3` |

## Recommended Steps
Try to implement the behavior described above without reading this section. If you need a nudge in the right direction, here are some recommended steps.

1. Create a Java class to hold your Niagara component in this module. Don't forget to make your Java class a subclass of the appropriate Niagara type.
2. Add the necessary Niagara annotations to implement the behavior described above and run slotomatic to generate the slot code. Your class should have a total of 8 annotations.
3. Implement the necessary functionality to update `out` whenever one of the six inputs changes.
4. Add your component to module.palette so that it is easily accessible from within Workbench.
5. Use Workbench to create a station to test your component.
6. Start your station and connect to it from within Workbench
7. Add your component from your palette to the station and test its behavior.
