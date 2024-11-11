package com.tridiumuniversity.trafficLightWidget.ui;

import com.tridiumuniversity.trafficLightWidget.BTrafficLight;
import com.tridiumuniversity.trafficLightWidget.BTrafficLightState;

import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponentEvent;
import javax.baja.sys.BObject;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.workbench.view.BWbComponentView;

@NiagaraType(agent = @AgentOn(types = "trafficLightWidget:TrafficLight"))
public class BTrafficLightView extends BWbComponentView {

    private BTrafficLightWidget traffic = new BTrafficLightWidget();
    public BTrafficLightView() {
        setContent(traffic);
    }

    @Override
    protected void doLoadValue(BObject obj, Context cx) {
        BTrafficLight trafficLight = (BTrafficLight) obj;
        traffic.updateLightState(trafficLight.getState());
    }

    @Override
    public void handleComponentEvent(BComponentEvent event) {
        BTrafficLight trafficLight = (BTrafficLight) event.getSourceComponent();
        trafficLight.lease();
        traffic.updateLightState(trafficLight.getState());
    }

    @Override
    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BTrafficLightView.class);
}
