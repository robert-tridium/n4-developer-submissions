package com.tridiumuniversity.myFile;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.*;
@NiagaraType
@NiagaraProperty(
        name = "filename",
        type = "String",
        defaultValue = "myFile"
)
@NiagaraProperty(
        name = "path",
        type = "String",
        defaultValue = "C:"
)

@NiagaraProperty(
        name = "size",
        type = "int",
        defaultValue = "0.0"
)

@NiagaraProperty(
        name = "createdDate",
        type = "BAbsTime" ,
        defaultValue = "BAbsTime.now()",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "modifiedTime",
        type = "BAbsTime" ,
        defaultValue = "BAbsTime.DEFAULT",
        flags = Flags.SUMMARY
)
@NiagaraAction(
        name = "touch"
)
@NiagaraAction(
        name = "print"
)
public class BFile extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.myFile.BFile(2749873516)1.0$ @*/
/* Generated Tue Nov 07 08:11:56 CET 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "filename"

  /**
   * Slot for the {@code filename} property.
   * @see #getFilename
   * @see #setFilename
   */
  public static final Property filename = newProperty(0, "myFile", null);

  /**
   * Get the {@code filename} property.
   * @see #filename
   */
  public String getFilename() { return getString(filename); }

  /**
   * Set the {@code filename} property.
   * @see #filename
   */
  public void setFilename(String v) { setString(filename, v, null); }

  //endregion Property "filename"

  //region Property "path"

  /**
   * Slot for the {@code path} property.
   * @see #getPath
   * @see #setPath
   */
  public static final Property path = newProperty(0, "C:", null);

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
  public static final Property size = newProperty(0, 0.0, null);

  /**
   * Get the {@code size} property.
   * @see #size
   */
  public int getSize() { return getInt(size); }

  /**
   * Set the {@code size} property.
   * @see #size
   */
  public void setSize(int v) { setInt(size, v, null); }

  //endregion Property "size"

  //region Property "createdDate"

  /**
   * Slot for the {@code createdDate} property.
   * @see #getCreatedDate
   * @see #setCreatedDate
   */
  public static final Property createdDate = newProperty(Flags.SUMMARY, BAbsTime.now(), null);

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

  //region Property "modifiedTime"

  /**
   * Slot for the {@code modifiedTime} property.
   * @see #getModifiedTime
   * @see #setModifiedTime
   */
  public static final Property modifiedTime = newProperty(Flags.SUMMARY, BAbsTime.DEFAULT, null);

  /**
   * Get the {@code modifiedTime} property.
   * @see #modifiedTime
   */
  public BAbsTime getModifiedTime() { return (BAbsTime)get(modifiedTime); }

  /**
   * Set the {@code modifiedTime} property.
   * @see #modifiedTime
   */
  public void setModifiedTime(BAbsTime v) { set(modifiedTime, v, null); }

  //endregion Property "modifiedTime"

  //region Action "touch"

  /**
   * Slot for the {@code touch} action.
   * @see #touch()
   */
  public static final Action touch = newAction(0, null);

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
  public static final Action print = newAction(0, null);

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


  public void doTouch()
  {
    setModifiedTime(BAbsTime.now());
  }

  public void doPrint()
  {
    System.out.println("Time created: " + getCreatedDate() + "\n" + "Time modified: " + getModifiedTime());
  }
}
