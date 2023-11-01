package com.tridiumuniversity.userserviceview.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.js.BJsBuild;

@NiagaraType
@NiagaraSingleton
public final class BUserServiceViewJsBuild extends BJsBuild
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.userserviceview.ux.BUserServiceViewJsBuild(2747097003)1.0$ @*/
/* Generated Tue Oct 31 16:13:47 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  public static final BUserServiceViewJsBuild INSTANCE = new BUserServiceViewJsBuild();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUserServiceViewJsBuild.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  private BUserServiceViewJsBuild()
  {
    super(
      "userServiceView",
      BOrd.make("module://userServiceView/rc/userServiceView.built.min.js"),
      BUserServiceViewCssResource.TYPE
    );
  }
}
