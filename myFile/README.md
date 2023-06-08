# File
In this exercise, you will create a component that represents a file. Note that for real applications, you should use the classes in javax.baja.file. The purpose of this exercise is to get more comfortable creating components in Niagara.

## Description
Create a new Niagara component named `BFile` with the following:
* A property named `fileName` with a type of `String`
* A property named `path` with a type of `String`
* A property named `size` with a type of `int`
* A property named `createdDate` with a type of `BAbsTime`
* A property named `modifiedDate` with a type of `BAbsTime`
* An action named `touch` that updates the `modifiedDate` property to the current time
* An action named `print` that prints a summary of the properties to `stdout`.

## Recommended Steps
Try to implement the behavior described above without reading this section. If you need a nudge in the right direction, here are some recommended steps.

1. Create a class named `BFile`.
2. Make `BFile` a subclass of `BComponent`.
3. Add a `@NiagaraType` annotation to denote this class as a Niagara Type.
4. Add `@NiagaraProperty` annotations for each of the properties described above.
5. Add `@NiagaraAction` annotations for each of the actions described above.
6. Run slotomatic with the command `gradlew slotomatic` to generate the slot code for the properties and actions.
7. Define methods named `doTouch()` and `doPrint()` to hold the implementations of the `touch` and `print` actions.
8. Add a `<p>` element to the `module.palette` file for `BFile`.
9. Compile your code with the command `gradlew jar`.
10. Create a new station in Workbench and add a `BFile` component from your palette.
11. Experiment with changing the property values and invoking the actions.