package com.tridiumuniversity.myFile;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType

@NiagaraProperty(
        name = "fileName",
        type = "String",
        defaultValue = ""
)
@NiagaraProperty(
        name = "path",
        type = "String",
        defaultValue = ""
)
@NiagaraProperty(
        name = "size",
        type = "int",
        defaultValue = "0"
)
@NiagaraProperty(
        name = "createdDate",
        type = "BAbsTime",
        defaultValue = "BAbsTime.now()"
)
@NiagaraProperty(
        name = "modifiedDate",
        type = "BAbsTime",
        defaultValue = "BAbsTime.now()"
)
@NiagaraAction(
        name = "touch",
        flags = Flags.ASYNC
)
@NiagaraAction(
        name = "print",
        flags = Flags.ASYNC
)

public class BFile extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.myFile.BFile(173795296)1.0$ @*/
/* Generated Mon Aug 05 22:10:10 MDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "fileName"

  /**
   * Slot for the {@code fileName} property.
   * @see #getFileName
   * @see #setFileName
   */
  public static final Property fileName = newProperty(0, "", null);

  /**
   * Get the {@code fileName} property.
   * @see #fileName
   */
  public String getFileName() { return getString(fileName); }

  /**
   * Set the {@code fileName} property.
   * @see #fileName
   */
  public void setFileName(String v) { setString(fileName, v, null); }

  //endregion Property "fileName"

  //region Property "path"

  /**
   * Slot for the {@code path} property.
   * @see #getPath
   * @see #setPath
   */
  public static final Property path = newProperty(0, "", null);

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
  public static final Property size = newProperty(0, 0, null);

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
  public static final Property createdDate = newProperty(0, BAbsTime.now(), null);

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
  public static final Property modifiedDate = newProperty(0, BAbsTime.now(), null);

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
  public static final Action touch = newAction(Flags.ASYNC, null);

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
  public static final Action print = newAction(Flags.ASYNC, null);

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
    public void doTouch(){
        setModifiedDate(BAbsTime.now());
    }
    public void doPrint(){
        System.out.printf("Filename = %s, Path = %s, Size = %s, Created Date = %s, Modified Date %s%n",getFileName(),getPath(),getSize(),getCreatedDate(),getModifiedDate());
    }
}