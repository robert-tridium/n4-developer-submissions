# Exercise 6: Traffic Light Widget
In this exercise, you will use the bajaui framework to create a widget that allows you to view the state of a traffic light:

![Traffic Light Widget](../images/TrafficLightWidget.png)

## Description
You've been provided in the -rt module part with two classes from the labs: `BTrafficLightState` and `BTrafficLight`. Use the bajaui framework to create a new widget. Each of the lights in this widget should have a high opacity when the `state` Property is equal to that light color and a low opacity when the `state` Property is not equal to that light color. For instance, it's clear in the above image that the current value of the `state` Property is `red`, since the red light has a high opacity and the yellow and green lights have a low opacity. Here are some of the fundamentals that you need to know:
* You need to create a class that extends `BWbComponentView` and declares itself to be an agent on `BTrafficLight` in its `@NiagaraType` annotation.
* In order to set the content of the component view class to a widget, use the `setContent` method.
* In order to paint something to the screen, override the `paint` method. This method accepts a single parameter: an instance of `javax.baja.gx.Graphics`.  In order to create a shape using the `Graphics` class, you'll want to set the brush to a color, then draw a shape. Here's an example:

```java
@Override
public void paint(Graphics g)
{
  // Make a blue 10x10 rectangle
  BRectGeom rectangle = BRectGeom.make(0, 0, 10, 10);
  g.setBrush(BColor.make("blue"));
  g.fill(rectangle);
}
```

  * The `setBrush` method takes a `BColor` parameter.
  * The `fill` method takes an `IGeom` parameter. There are several implementations of `IGeom`, but the ones you should care about for this exercise are `BRectGeom` and `BEllipseGeom`
  * For the traffic light dimensions, I recommend a 100x250 rectangle where each light is 50x50 and has a padding of 25 around it.
  * I recommend the following colors, although feel free to choose your own. These color formats are RRGGBBAA (red, green, blue, alpha)

| Light Component | Color |
| --------------- | ----- |
| Traffic Light Rectangle | `222222FF` |
| Active Red Light | `FF0000FF` |
| Inactive Red Light | `FF000019` |
| Active Yellow Light | `FFFF00FF` |
| Inactive Yellow Light | `FFFF0019` |
| Active Green Light | `00FF7FFF` |
| Inactive Green Light | `00FF7F19` |

## Recommended Steps
Try to implement the behavior described above without reading this section. If you need a nudge in the right direction, here are some recommended steps.

1. Create a subclass of `BWbComponentView` named `BTrafficLightView` and make it an agent on `BTrafficLight`.
2. Create a subclass of `BWidget` named `BTrafficLightWidget`. In the constructor for `BTrafficLightView`, create an instance of `BTrafficLightWidget` and pass it into `setContent`. This will set an instance of `BTrafficLightWidget` to be the content of your `BTrafficLightView`
3. Override the `paint` method in `BTrafficLightWidget` and use the `Graphics` parameter to draw the traffic light rectangle.
4. Add an instance of `BTrafficLight` to a running station and confirm that you see your traffic light rectangle as its default view in Workbench.
5. Add in the three traffic light circles (for now just use the active colors) and confirm that you see those correctly in Workbench.
6. Override `doLoadValue` in `BTrafficLightView` and implement it such that when a `BTrafficLight` is loaded in, the `BTrafficLightWidget` paints the circles with the appropriate opacity.

## Added Challenge
For an added challenge, make your view update whenever the `state` Property changes without having to manually refresh the page. To do this, you'll want to look into the `BWbComponentView#handleComponentEvent` and `BWidget#repaint` methods.