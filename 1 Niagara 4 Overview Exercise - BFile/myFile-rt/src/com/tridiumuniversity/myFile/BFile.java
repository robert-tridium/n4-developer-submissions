package com.tridiumuniversity.myFile;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.sys.BComponent;
import javax.baja.sys.Action;
import javax.baja.sys.Flags;
// import javax.baja.sys.Property;
// import javax.baja.sys.Sys;
// import javax.baja.sys.Type;

@NiagaraType

@NiagaraProperty(
        name = "fileName",
        type = "String",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "path",
        type = "String",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "size",
        type = "int",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "createdDate",
        type = "BAbsTime",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "modifiedDate",
        type = "BAbsTime",
        flags = Flags.SUMMARY
)
@NiagaraAction(
        name = "touch",
        flags = Flags.SUMMARY
)
@NiagaraAction(
        name = "print",
        flags = Flags.SUMMARY
)

public class BFile extends BComponent {
}
