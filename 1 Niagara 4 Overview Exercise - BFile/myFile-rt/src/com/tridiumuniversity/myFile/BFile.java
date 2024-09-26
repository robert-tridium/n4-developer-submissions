package com.tridiumuniversity.myFile;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusString;
import javax.baja.sys.Action;
import javax.baja.sys.BAbsTime;
import javax.baja.sys.BComponent;
import javax.baja.sys.BMonth;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Slot;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
        name = "fileName",
        type = "BStatusString",
        defaultValue = "new BStatusString (\"\", BStatus.nullStatus)",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name = "path",
        type = "String",
        defaultValue = "\"path\"",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "size",
        type = "BStatusNumeric",
        defaultValue = "new BStatusNumeric(0, BStatus.nullStatus)",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "createdDate",
        type = "BAbsTime",
        defaultValue = "BAbsTime.make(2023, BMonth.make(5), 28, 12, 34, 14, 3)",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "modifiedDate",
        type = "BAbsTime",
        defaultValue = "BAbsTime.DEFAULT",
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
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.myFile.BFile(2239895290)1.0$ @*/
/* Generated Thu Sep 26 19:09:39 CEST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "fileName"

  /**
   * Slot for the {@code fileName} property.
   * @see #getFileName
   * @see #setFileName
   */
  public static final Property fileName = newProperty(Flags.SUMMARY, new BStatusString ("", BStatus.nullStatus), null);

  /**
   * Get the {@code fileName} property.
   * @see #fileName
   */
  public BStatusString getFileName() { return (BStatusString)get(fileName); }

  /**
   * Set the {@code fileName} property.
   * @see #fileName
   */
  public void setFileName(BStatusString v) { set(fileName, v, null); }

  //endregion Property "fileName"

  //region Property "path"

  /**
   * Slot for the {@code path} property.
   * @see #getPath
   * @see #setPath
   */
  public static final Property path = newProperty(Flags.SUMMARY, "path", null);

  /**
   * Get the {@code path} property.
   * @see #path
   */
  public String getPath() { return getString(path); }

  /**
   * Set the {@code path} property.
   * @see #path
   */
  public void setPath(String v) { setString(path, v, null); }

  //endregion Property "path"

  //region Property "size"

  /**
   * Slot for the {@code size} property.
   * @see #getSize
   * @see #setSize
   */
  public static final Property size = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.nullStatus), null);

  /**
   * Get the {@code size} property.
   * @see #size
   */
  public BStatusNumeric getSize() { return (BStatusNumeric)get(size); }

  /**
   * Set the {@code size} property.
   * @see #size
   */
  public void setSize(BStatusNumeric v) { set(size, v, null); }

  //endregion Property "size"

  //region Property "createdDate"

  /**
   * Slot for the {@code createdDate} property.
   * @see #getCreatedDate
   * @see #setCreatedDate
   */
  public static final Property createdDate = newProperty(Flags.SUMMARY, BAbsTime.make(2023, BMonth.make(5), 28, 12, 34, 14, 3), null);

  /**
   * Get the {@code createdDate} property.
   * @see #createdDate
   */
  public BAbsTime getCreatedDate() { return (BAbsTime)get(createdDate); }

  /**
   * Set the {@code createdDate} property.
   * @see #createdDate
   */
  public void setCreatedDate(BAbsTime v) { set(createdDate, v, null); }

  //endregion Property "createdDate"

  //region Property "modifiedDate"

  /**
   * Slot for the {@code modifiedDate} property.
   * @see #getModifiedDate
   * @see #setModifiedDate
   */
  public static final Property modifiedDate = newProperty(Flags.SUMMARY, BAbsTime.DEFAULT, null);

  /**
   * Get the {@code modifiedDate} property.
   * @see #modifiedDate
   */
  public BAbsTime getModifiedDate() { return (BAbsTime)get(modifiedDate); }

  /**
   * Set the {@code modifiedDate} property.
   * @see #modifiedDate
   */
  public void setModifiedDate(BAbsTime v) { set(modifiedDate, v, null); }

  //endregion Property "modifiedDate"

  //region Action "touch"

  /**
   * Slot for the {@code touch} action.
   * @see #touch()
   */
  public static final Action touch = newAction(Flags.SUMMARY, null);

  /**
   * Invoke the {@code touch} action.
   * @see #touch
   */
  public void touch() { invoke(touch, null, null); }

  //endregion Action "touch"

  //region Action "print"

  /**
   * Slot for the {@code print} action.
   * @see #print()
   */
  public static final Action print = newAction(Flags.SUMMARY, null);

  /**
   * Invoke the {@code print} action.
   * @see #print
   */
  public void print() { invoke(print, null, null); }

  //endregion Action "print"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFile.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public void doTouch () {
        setModifiedDate(BAbsTime.now());
    }

    public void doPrint () {
        System.out.println("filename: " + getFileName().getValue());
        System.out.println("path: " + getPath());
        System.out.println("size: " + getSize().getValue());
        System.out.println("created date: " + getCreatedDate().encodeToString());
        System.out.println("modified date: " + getModifiedDate().encodeToString());

       for (Slot slot : getSlots()){
         System.out.println(slot.getName());
       }
    }

}
