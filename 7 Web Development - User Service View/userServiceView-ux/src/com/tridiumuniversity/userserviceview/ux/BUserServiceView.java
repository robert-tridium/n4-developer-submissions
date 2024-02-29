package com.tridiumuniversity.userserviceview.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.web.BIFormFactorMax;
import javax.baja.web.js.BIJavaScript;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.js.JsInfo;

@NiagaraType(
	agent = @AgentOn(types = "baja:UserService")
)
@NiagaraSingleton
public final class BUserServiceView extends BSingleton implements BIJavaScript, BIFormFactorMax {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.userserviceview.ux.BUserServiceView(3329009296)1.0$ @*/
/* Generated Thu Feb 29 10:36:56 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  public static final BUserServiceView INSTANCE = new BUserServiceView();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUserServiceView.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

	private BUserServiceView() {}

	@Override
	public JsInfo getJsInfo(Context context) { return JS_INFO; }

	private static final JsInfo JS_INFO = JsInfo.make(
		BOrd.make("module://userServiceView/rc/UserServiceView.js"),
		BUserServiceViewJsBuild.TYPE
	);
}
