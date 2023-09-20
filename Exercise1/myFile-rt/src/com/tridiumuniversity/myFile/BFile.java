package com.tridiumuniversity.myFile;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BAbsTime;
import javax.baja.sys.BComponent;
import javax.baja.sys.Flags;
import java.io.File;
import java.io.IOException;
import javax.baja.sys.*;
import javax.baja.util.Lexicon;

@NiagaraType
@NiagaraProperty(
        name = "filename",
        type = "BString",
        defaultValue = "BString.DEFAULT"
)
@NiagaraProperty(
        name = "path",
        type = "BString",
        defaultValue = "BString.DEFAULT"
)
@NiagaraProperty(
        name = "size",
        type = "BInteger",
        defaultValue = "BInteger.DEFAULT"
)
@NiagaraProperty(
        name = "createdDate",
        type = "BAbsTime",
        defaultValue = "BAbsTime.DEFAULT"
)
@NiagaraProperty(
        name = "modifiedDate",
        type = "BAbsTime",
        defaultValue = "BAbsTime.DEFAULT"
)

@NiagaraAction(
        name = "touch",
        defaultValue = "BFile.modifiedDate"
)
@NiagaraAction(
        name = "print",
        flags = Flags.SUMMARY
)

public class BFile extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridiumuniversity.myFile.BFile(1560643383)1.0$ @*/
/* Generated Wed Sep 20 11:58:54 IST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "filename"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code filename} property.
   * @see #getFilename
   * @see #setFilename
   */
  public static final Property filename = newProperty(0, BString.DEFAULT, null);
  
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

////////////////////////////////////////////////////////////////
// Property "path"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code path} property.
   * @see #getPath
   * @see #setPath
   */
  public static final Property path = newProperty(0, BString.DEFAULT, null);
  
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
  public static final Property size = newProperty(0, ((BInteger)(BInteger.DEFAULT)).getInt(), null);
  
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
  public static final Property createdDate = newProperty(0, BAbsTime.DEFAULT, null);
  
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
  public static final Property modifiedDate = newProperty(0, BAbsTime.DEFAULT, null);
  
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
    System.out.println("Hello, World  print");
    setModifiedDate((BAbsTime.now()));
  }
  public void doPrint()
  {
    System.out.println("Hello, World! 2nd Component1");
//    setTimeExecuted(BAbsTime.now());
  }

}
