package com.tridiumuniversity.myFile;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.util.Properties;

@NiagaraType
@NiagaraProperty(
        name = "fileName",
        type = "String",
        defaultValue = "",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name = "path",
        type = "String",
        defaultValue = "",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name = "size",
        type = "int",
        defaultValue = "BInteger.make(0)",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name = "createdDate",
        type = "BAbsTime",
        defaultValue = "BAbsTime.DEFAULT",
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
/*@ $com.tridiumuniversity.devTrafficLights.BFile(3189332015)1.0$ @*/
/* Generated Mon Feb 03 14:42:22 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "fileName"

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

  //endregion Property "fileName"

  //region Property "path"

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

  //endregion Property "path"

  //region Property "size"

  /**
   * Slot for the {@code size} property.
   * @see #getSize
   * @see #setSize
   */
  public static final Property size = newProperty(Flags.SUMMARY, BInteger.make(0), null);

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
  public static final Property createdDate = newProperty(Flags.SUMMARY, BAbsTime.DEFAULT, null);

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

    public void doTouch()
    {
        setModifiedDate(BAbsTime.now());
    }

    public void doPrint()
    {
        System.out.println("These are all the properties in this component");
        this.loadSlots();
      Property[] propertiesArray = this.getPropertiesArray();
      for(Property prop : propertiesArray)
        System.out.println(prop.getName());

    }
}
