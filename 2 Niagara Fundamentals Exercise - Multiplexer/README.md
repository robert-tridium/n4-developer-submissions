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

## Added Challenge
For an added challenge, generalize your 4-to-1 multiplexer to be a 2^n-to-1 multiplexer for any value of n:
1. Remove all of your component's frozen properties except for `out` so that they can be added dynamically.
2. Whenever a property changes, your component should check to see how many `in*` properties it has and how many `s*` properties it has. Then, perform the necessary logic to select one of the `in*` properties based on the values of the `s*` properties and forward its value to `out`.

   For instance, I should be able to add an instance of your component to a running station, add eight `BBoolean` properties named `in0` through `in7`, add three `BBoolean` properties named `s0`, `s1`, and `s2`, and your component should automatically set the value of `out` according to the following truth table for an 8-to-1 multiplexer:

| `s2` | `s1` | `s0` | `out` |
| ---- | ---- | ---- | ----- |
| F | F | F | `in0` |
| F | F | T | `in1` |
| F | T | F | `in2` |
| F | T | T | `in3` |
| T | F | F | `in4` |
| T | F | T | `in5` |
| T | T | F | `in6` |
| T | T | T | `in7` |

  I should then be able to change the number of `in*` properties and `s*` properties on your component to make a 2-to-1, 4-to-1, 16-to-1, etc. multiplexer.

3. In your module.palette, create a few versions of your component that already have the correct numbers of inputs for several types of multiplexers. We haven't strictly gone over how to do this yet - look at the Module Development slide deck or ask for help if you need it.