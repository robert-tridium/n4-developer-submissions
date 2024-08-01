package com.tridiumuniversity.myFile;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "filename",
        type = "String",
        flags = Flags.READONLY | Flags.SUMMARY
)@NiagaraProperty(
        name = "path",
        type = "String",
        flags = Flags.READONLY | Flags.SUMMARY
)@NiagaraProperty(
        name = "size",
        type = "int",
        flags = Flags.READONLY | Flags.SUMMARY
)
@NiagaraProperty(
        name = "createdDate",
        type = "baja:AbsTime",
        defaultValue = "BAbsTime.DEFAULT",
        flags = Flags.READONLY | Flags.SUMMARY
)@NiagaraProperty(
        name = "modifiedDate",
        type = "baja:AbsTime",
        defaultValue = "BAbsTime.DEFAULT",
        flags = Flags.READONLY | Flags.SUMMARY
)
@NiagaraAction(
        name="touch",
        flags = Flags.SUMMARY
)@NiagaraAction(
        name="print",
        flags = Flags.SUMMARY
)

public class BFile extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.myFile.BFile(4153978362)1.0$ @*/
/* Generated Thu Aug 01 11:29:47 KST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "filename"

  /**
   * Slot for the {@code filename} property.
   * @see #getFilename
   * @see #setFilename
   */
  public static final Property filename = newProperty(Flags.READONLY | Flags.SUMMARY, "", null);

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
  public static final Property path = newProperty(Flags.READONLY | Flags.SUMMARY, "", null);

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
  public static final Property size = newProperty(Flags.READONLY | Flags.SUMMARY, 0, null);

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
  public static final Property createdDate = newProperty(Flags.READONLY | Flags.SUMMARY, BAbsTime.DEFAULT, null);

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
  public static final Property modifiedDate = newProperty(Flags.READONLY | Flags.SUMMARY, BAbsTime.DEFAULT, null);

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


    public void doTouch()
    {
        setModifiedDate(BAbsTime.now());
    }

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

    public void doPrint()
    {
        System.out.println("Filename : "+getFilename());
        System.out.println("Path : "+getPath());
        System.out.println("Size : "+getSize());
        System.out.println("CreateDate : "+getCreatedDate());
        System.out.println("ModifiedDate : "+getModifiedDate());
    }

  //endregion Action "print"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFile.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
