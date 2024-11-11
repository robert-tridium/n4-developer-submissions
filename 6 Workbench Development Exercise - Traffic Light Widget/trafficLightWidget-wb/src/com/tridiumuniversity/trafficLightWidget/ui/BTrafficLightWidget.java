package com.tridiumuniversity.trafficLightWidget.ui;

import com.tridiumuniversity.trafficLightWidget.BTrafficLightState;

import javax.baja.gx.BColor;
import javax.baja.gx.BEllipseGeom;
import javax.baja.gx.BRectGeom;
import javax.baja.gx.Graphics;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.ui.BWidget;

@NiagaraType
public class BTrafficLightWidget extends BWidget {

    private BTrafficLightState state;

    public BTrafficLightWidget() {
        this.state = BTrafficLightState.red;
    }

    @Override
    public void paint(Graphics g) {
        BRectGeom rectangle = BRectGeom.make(0, 0, 100, 250);

        BEllipseGeom red = BEllipseGeom.make(25, 25, 50, 50);
        BEllipseGeom yellow = BEllipseGeom.make(25, 100, 50, 50);
        BEllipseGeom green = BEllipseGeom.make(25, 175, 50, 50);

        g.setBrush(BColor.make("#ffc0c0c0"));
        g.fill(rectangle);

        if (state == BTrafficLightState.red) {
            g.setBrush(BColor.make("#ffff0000"));
        } else {
            g.setBrush(BColor.make("#ff800000"));
        }
        g.fill(red);

        if (state == BTrafficLightState.yellow) {
            g.setBrush(BColor.make("#ffffff00"));
        } else {
            g.setBrush(BColor.make("#ff808000"));
        }
        g.fill(yellow);

        if (state == BTrafficLightState.green) {
            g.setBrush(BColor.make("#ff00ff00"));
        } else {
            g.setBrush(BColor.make("#ff008000"));
        }
        g.fill(green);
    }

    public void updateLightState(BTrafficLightState newState) {
        this.state = newState;
        repaint();
    }

    @Override
    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BTrafficLightWidget.class);
}
