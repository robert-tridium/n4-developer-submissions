package com.tridiumuniversity.myFile;


import javax.baja.nre.annotations.*;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
  name = "fileName",
  type = "String",
  defaultValue = "Shubham",
  flags = Flags.READONLY | Flags.SUMMARY
)
@NiagaraProperty(
  name = "path",
  type = "BString",
  defaultValue = "BString.DEFAULT",
  flags = Flags.READONLY
)
@NiagaraProperty(
  name = "size",
  type = "int",
  defaultValue = "2",
  flags = Flags.SUMMARY
)
@NiagaraProperty(
  name = "createdDate",
  type = "BAbsTime",
  defaultValue = "BAbsTime.DEFAULT",
  flags = Flags.READONLY
)
@NiagaraProperty(
  name = "modifiedDate",
  type = "BAbsTime",
  defaultValue = "BAbsTime.DEFAULT",
  flags = Flags.TRANSIENT
)
@NiagaraAction(
  name = "touch"
)
@NiagaraAction(
  name = "print"
)
public class BFile extends BComponent
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridiumuniversity.myFile.BFile(174408161)1.0$ @*/
/* Generated Wed Sep 20 17:56:02 IST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "fileName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fileName} property.
   * @see #getFileName
   * @see #setFileName
   */
  public static final Property fileName = newProperty(Flags.READONLY | Flags.SUMMARY, "Shubham", null);
  
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

////////////////////////////////////////////////////////////////
// Property "path"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code path} property.
   * @see #getPath
   * @see #setPath
   */
  public static final Property path = newProperty(Flags.READONLY, BString.DEFAULT, null);
  
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

////////////////////////////////////////////////////////////////
// Property "size"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code size} property.
   * @see #getSize
   * @see #setSize
   */
  public static final Property size = newProperty(Flags.SUMMARY, 2, null);
  
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

////////////////////////////////////////////////////////////////
// Property "createdDate"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code createdDate} property.
   * @see #getCreatedDate
   * @see #setCreatedDate
   */
  public static final Property createdDate = newProperty(Flags.READONLY, BAbsTime.DEFAULT, null);
  
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

////////////////////////////////////////////////////////////////
// Property "modifiedDate"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code modifiedDate} property.
   * @see #getModifiedDate
   * @see #setModifiedDate
   */
  public static final Property modifiedDate = newProperty(Flags.TRANSIENT, BAbsTime.DEFAULT, null);
  
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

////////////////////////////////////////////////////////////////
// Action "touch"
////////////////////////////////////////////////////////////////
  
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

////////////////////////////////////////////////////////////////
// Action "print"
////////////////////////////////////////////////////////////////
  
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

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFile.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void doTouch()
  {
    setModifiedDate(BAbsTime.now());
  }
  public void doPrint()
  {
    System.out.println("fileName: "+getFileName());
    System.out.println("path: "+getPath());
    System.out.println("size: "+getSize());
    System.out.println("CreatedDate: "+getCreatedDate());
    System.out.println("modifiedDate: "+getModifiedDate());

  }
}
