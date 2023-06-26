package com.tridumuniversity.myFile;



import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name="fileName",
        type="String",
        defaultValue = "\"\"",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "path",
        type="String",
        defaultValue = "\"\"",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name="size",
        type="int",
        defaultValue = "0",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name="createDate",
        type="BAbsTime",
        defaultValue = "BAbsTime.now()",
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
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.pentasolutions.devTrafficLights.BFile(1082329750)1.0$ @*/
/* Generated Mon Jun 19 08:45:19 CDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "fileName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fileName} property.
   * @see #getFileName
   * @see #setFileName
   */
  public static final Property fileName = newProperty(Flags.SUMMARY, "", null);
  
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
  public static final Property path = newProperty(Flags.SUMMARY, "", null);
  
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
  public static final Property size = newProperty(Flags.SUMMARY, 0, null);
  
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
// Property "createDate"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code createDate} property.
   * @see #getCreateDate
   * @see #setCreateDate
   */
  public static final Property createDate = newProperty(Flags.SUMMARY, BAbsTime.now(), null);
  
  /**
   * Get the {@code createDate} property.
   * @see #createDate
   */
  public BAbsTime getCreateDate() { return (BAbsTime)get(createDate); }
  
  /**
   * Set the {@code createDate} property.
   * @see #createDate
   */
  public void setCreateDate(BAbsTime v) { set(createDate, v, null); }

////////////////////////////////////////////////////////////////
// Property "modifiedDate"
////////////////////////////////////////////////////////////////
  
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

////////////////////////////////////////////////////////////////
// Action "touch"
////////////////////////////////////////////////////////////////
  
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

////////////////////////////////////////////////////////////////
// Action "print"
////////////////////////////////////////////////////////////////
  
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

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFile.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public void doTouch(){
        setModifiedDate(BAbsTime.now());
    }
    public void doPrint(){
        System.out.println(getFileName()+"\n"+getPath()+"\n"+getSize()+"\n"+getCreateDate()+"\n"+getModifiedDate());
    }
}
