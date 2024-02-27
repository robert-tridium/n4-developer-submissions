package com.tridiumuniversity.trafficLightWidget.ui;

import com.tridiumuniversity.trafficLightWidget.BTrafficLight;

import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.workbench.view.BWbComponentView;

@NiagaraType(
	agent = @AgentOn(types = "trafficLightWidget:TrafficLight")
)
public class BTrafficLightView extends BWbComponentView {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightWidget.ui.BTrafficLightView(33629217)1.0$ @*/
/* Generated Tue Feb 27 09:21:43 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightView.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

	@Override
	protected void doLoadValue(BObject value, Context context) {
		BTrafficLight component = (BTrafficLight) value;
		content.setComponent(component);
		content.repaint();
	}

	@Override
	public void handleComponentEvent(BComponentEvent event) {
		if(event.getId() != BComponentEvent.PROPERTY_CHANGED) return;
		content.repaint();
	}

	public BTrafficLightView() {
		content = new BTrafficLightWidget();
		setContent(content);
	}

	private final BTrafficLightWidget content;
}
