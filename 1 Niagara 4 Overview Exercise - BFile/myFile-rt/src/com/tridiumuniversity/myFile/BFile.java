package com.tridiumuniversity.myFile;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;


@NiagaraType
@NiagaraProperty(
        name = "filename",
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
        defaultValue = "0",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name = "createdDate",
        type = "BAbsTime",
        defaultValue = "BAbsTime.NULL"
)

@NiagaraProperty(
        name = "modifiedDate",
        type = "BAbsTime",
        defaultValue = "BAbsTime.NULL"
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
/*@ $com.tridiumuniversity.myFile.BFile(1337830447)1.0$ @*/
/* Generated Wed Jul 31 08:07:47 BRT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "filename"

  /**
   * Slot for the {@code filename} property.
   * @see #getFilename
   * @see #setFilename
   */
  public static final Property filename = newProperty(0, "", null);

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

  //endregion Property "size"

  //region Property "createdDate"

  /**
   * Slot for the {@code createdDate} property.
   * @see #getCreatedDate
   * @see #setCreatedDate
   */
  public static final Property createdDate = newProperty(0, BAbsTime.NULL, null);

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
  public static final Property modifiedDate = newProperty(0, BAbsTime.NULL, null);

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

    public void doTouch(){
        setModifiedDate(BAbsTime.now());
    }

    public void doPrint()
    {
        // Retrieve property values
        String filename = getFilename();
        String path = getPath();
        int size = getSize();
        BAbsTime createdDate = getCreatedDate();
        BAbsTime modifiedDate = getModifiedDate();

        // Create a summary string
        String summary = String.format(
                "File Summary:\n" +
                        "Filename: %s\n" +
                        "Path: %s\n" +
                        "Size: %d\n" +
                        "Created Date: %s\n" +
                        "Modified Date: %s",
                filename, path, size, createdDate, modifiedDate
        );

        // Print the summary
        System.out.println(summary);
    }

}
