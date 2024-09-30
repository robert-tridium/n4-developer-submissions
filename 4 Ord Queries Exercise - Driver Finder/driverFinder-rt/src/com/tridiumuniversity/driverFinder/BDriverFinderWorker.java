package com.tridiumuniversity.driverFinder;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.util.BThreadPoolWorker;
import javax.baja.util.Queue;
import javax.baja.util.ThreadPoolWorker;
import javax.baja.util.Worker;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
public class BDriverFinderWorker extends BThreadPoolWorker {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.driverFinder.BDriverFinderWorker(2979906276)1.0$ @*/
/* Generated Mon Sep 30 13:09:08 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDriverFinderWorker.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    @Override
    public Worker getWorker() {
        return worker;
    }
    public void addWork(Runnable runnable) {
        queue.enqueue(runnable);
    }
    private final Queue queue = new Queue();
    private final ThreadPoolWorker worker = new ThreadPoolWorker(queue);
}
