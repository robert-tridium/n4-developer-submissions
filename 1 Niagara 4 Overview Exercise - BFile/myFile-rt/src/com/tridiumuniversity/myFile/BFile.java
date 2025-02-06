package com.tridiumuniversity.myFile;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraProperty(name = "FileName", type = "String",defaultValue = "\\myFile.txt\\")
@NiagaraProperty(name = "Path", type = "String",defaultValue = "c:\\myFile.txt")
@NiagaraProperty(name = "Size", type = "int",defaultValue = "0")
@NiagaraProperty(name = "CreatedDate",type = "baja:AbsTime",defaultValue = "BAbsTime.NULL")
@NiagaraProperty(name = "ModifiedDate",type = "baja:AbsTime",defaultValue = "BAbsTime.NULL")
@NiagaraAction(name="touch")
@NiagaraAction(name="print")
@NiagaraType
public class BFile extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.myFile.BFile(669012475)1.0$ @*/
/* Generated Wed Feb 05 17:32:57 CST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "FileName"

  /**
   * Slot for the {@code FileName} property.
   * @see #getFileName
   * @see #setFileName
   */
  public static final Property FileName = newProperty(0, "\\myFile.txt\\", null);

  /**
   * Get the {@code FileName} property.
   * @see #FileName
   */
  public String getFileName() { return getString(FileName); }

  /**
   * Set the {@code FileName} property.
   * @see #FileName
   */
  public void setFileName(String v) { setString(FileName, v, null); }

  //endregion Property "FileName"

  //region Property "Path"

  /**
   * Slot for the {@code Path} property.
   * @see #getPath
   * @see #setPath
   */
  public static final Property Path = newProperty(0, "c:\\myFile.txt", null);

  /**
   * Get the {@code Path} property.
   * @see #Path
   */
  public String getPath() { return getString(Path); }

  /**
   * Set the {@code Path} property.
   * @see #Path
   */
  public void setPath(String v) { setString(Path, v, null); }

  //endregion Property "Path"

  //region Property "Size"

  /**
   * Slot for the {@code Size} property.
   * @see #getSize
   * @see #setSize
   */
  public static final Property Size = newProperty(0, 0, null);

  /**
   * Get the {@code Size} property.
   * @see #Size
   */
  public int getSize() { return getInt(Size); }

  /**
   * Set the {@code Size} property.
   * @see #Size
   */
  public void setSize(int v) { setInt(Size, v, null); }

  //endregion Property "Size"

  //region Property "CreatedDate"

  /**
   * Slot for the {@code CreatedDate} property.
   * @see #getCreatedDate
   * @see #setCreatedDate
   */
  public static final Property CreatedDate = newProperty(0, BAbsTime.NULL, null);

  /**
   * Get the {@code CreatedDate} property.
   * @see #CreatedDate
   */
  public BAbsTime getCreatedDate() { return (BAbsTime)get(CreatedDate); }

  /**
   * Set the {@code CreatedDate} property.
   * @see #CreatedDate
   */
  public void setCreatedDate(BAbsTime v) { set(CreatedDate, v, null); }

  //endregion Property "CreatedDate"

  //region Property "ModifiedDate"

  /**
   * Slot for the {@code ModifiedDate} property.
   * @see #getModifiedDate
   * @see #setModifiedDate
   */
  public static final Property ModifiedDate = newProperty(0, BAbsTime.NULL, null);

  /**
   * Get the {@code ModifiedDate} property.
   * @see #ModifiedDate
   */
  public BAbsTime getModifiedDate() { return (BAbsTime)get(ModifiedDate); }

  /**
   * Set the {@code ModifiedDate} property.
   * @see #ModifiedDate
   */
  public void setModifiedDate(BAbsTime v) { set(ModifiedDate, v, null); }

  //endregion Property "ModifiedDate"

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
    public void doTouch(){
        setModifiedDate(BAbsTime.now());
    }
    public void doPrint(){
        System.out.println("filename: " + getFileName() + "path "+ getPath() + "filesize " + getSize() + "created date "+ getCreatedDate() + "modified date "+ getModifiedDate());
    }
}
