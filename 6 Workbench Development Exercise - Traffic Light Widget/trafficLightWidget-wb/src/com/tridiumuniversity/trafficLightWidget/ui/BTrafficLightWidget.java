package com.tridiumuniversity.trafficLightWidget.ui;

import com.tridiumuniversity.trafficLightWidget.BTrafficLight;
import com.tridiumuniversity.trafficLightWidget.BTrafficLightState;

import javax.baja.gx.BColor;
import javax.baja.gx.BEllipseGeom;
import javax.baja.gx.BRectGeom;
import javax.baja.gx.Graphics;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.ui.BWidget;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
public class BTrafficLightWidget extends BWidget {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightWidget.ui.BTrafficLightWidget(2979906276)1.0$ @*/
/* Generated Tue Feb 27 10:19:51 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightWidget.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

	public void setComponent(BTrafficLight component) {
		this.component = component;
	}

	@Override
	public void paint(Graphics g) {
		drawTrafficLight(g);
		drawRedLight(g);
		drawYellowLight(g);
		drawGreenLight(g);
	}

	private void drawRedLight(Graphics g) {
		BEllipseGeom light = BEllipseGeom.make(25, 25, lightDiameter, lightDiameter);
		boolean isRedLightActive = component != null && component.getState().getOrdinal() == BTrafficLightState.RED;
		g.setBrush(isRedLightActive ? activeRedColor : inactiveRedColor);
		g.fill(light);
	}

	private void drawYellowLight(Graphics g) {
		BEllipseGeom light = BEllipseGeom.make(25, 100, lightDiameter, lightDiameter);
		boolean isYellowLightActive = component != null && component.getState().getOrdinal() == BTrafficLightState.YELLOW;
		g.setBrush(isYellowLightActive ? activeYellowColor : inactiveYellowColor);
		g.fill(light);
	}

	private void drawGreenLight(Graphics g) {
		BEllipseGeom light = BEllipseGeom.make(25, 175, lightDiameter, lightDiameter);
		boolean isGreenLightActive = component != null && component.getState().getOrdinal() == BTrafficLightState.GREEN;
		g.setBrush(isGreenLightActive ? activeGreenColor : inactiveGreenColor);
		g.fill(light);
	}

	private void drawTrafficLight(Graphics g) {
		BRectGeom rectangle = BRectGeom.make(0, 0, rectangleWidth, rectangleHeight);
		g.setBrush(trafficLightColor);
		g.fill(rectangle);
	}


	private BTrafficLight component;

	private static final BColor trafficLightColor = BColor.make("#FF222222");
	private static final BColor activeRedColor = BColor.make("#FFFF0000");
	private static final BColor inactiveRedColor = BColor.make("#19FF0000");
	private static final BColor activeYellowColor = BColor.make("#FFFFFF00");
	private static final BColor inactiveYellowColor = BColor.make("#19FFFF00");
	private static final BColor activeGreenColor = BColor.make("#FF00FF7F");
	private static final BColor inactiveGreenColor = BColor.make("#1900FF7F");

	private static final int lightDiameter = 50;
	private static final int rectangleWidth = 100;
	private static final int rectangleHeight = 250;
}
