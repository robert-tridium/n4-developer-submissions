package com.tridiumuniversity.multiplexer;

import org.testng.Assert;
import org.testng.annotations.*;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.test.BTest;
import javax.baja.test.BTestNg;

@NiagaraType
public class BSuperMultiplexerTest extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.multiplexer.BSuperMultiplexerTest(2979906276)1.0$ @*/
/* Generated Tue Feb 20 11:33:02 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSuperMultiplexerTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

	private TestStationHandler handler;
	private BStation station;
	private BSuperMultiplexer multiplexer;


	@BeforeClass(alwaysRun=true)
	public void setup() throws Exception {
		handler = BTest.createTestStation();
		handler.startStation();
		station = handler.getStation();
	}

	@AfterClass(alwaysRun=true)
	public void cleanup() throws Exception {
		handler.stopStation();
		handler.releaseStation();
		handler = null;
	}

	@BeforeMethod
	public void addComponent() {
		multiplexer = new BSuperMultiplexer();
		station.add("multi", multiplexer);
	}

	@AfterMethod
	public void removeComponent() {
		station.remove(multiplexer);
		multiplexer = null;
	}

	@Test(dataProvider = "slotCounts")
	public void dynamicInputSlotsTest(Integer selectCount, Integer inputCount) {
		multiplexer.setNumOfSelects(selectCount);
		for(int i = 0; i < inputCount; i++){
			Property p = multiplexer.getProperty(String.format("in%d", i));
			Assert.assertNotNull(p);
		}
	}

	@Test(dataProvider = "slotCounts")
	public void dynamicSelectSlotsTest(Integer selectCount, Integer _inputCount) {
		multiplexer.setNumOfSelects(selectCount);
		for(int i = 0; i < selectCount; i++){
			Property p = multiplexer.getProperty(String.format("s%d", i));
			Assert.assertNotNull(p);
		}
	}

	@Test(dataProvider = "truthTable")
	public void outputTest(Boolean s2, Boolean s1, Boolean s0, String inputPropName) {
		multiplexer.setNumOfSelects(3);

		Assert.assertFalse(multiplexer.getOut());

		multiplexer.set(inputPropName, BBoolean.TRUE);
		multiplexer.set("s2", BBoolean.make(s2));
		multiplexer.set("s1", BBoolean.make(s1));
		multiplexer.set("s0", BBoolean.make(s0));

		Assert.assertTrue(multiplexer.getOut());
	}


	@DataProvider(name="slotCounts")
	public Object[][] createSlotCounts() {
		return new Object[][] {
			// Select Count, Input Count
			{ 0, (int) Math.pow(2, 0) },
			{ 1, (int) Math.pow(2, 1) },
			{ 2, (int) Math.pow(2, 2) },
			{ 3, (int) Math.pow(2, 3) },
		};
	}

	@DataProvider(name = "truthTable")
	public Object[][] createTruthTable() {
		return new Object[][] {
			{ false, false, false, "in0" },
			{ false, false, true,  "in1" },
			{ false, true,  false, "in2" },
			{ false, true,  true,  "in3" },
			{ true,  false, false, "in4" },
			{ true,  false, true,  "in5" },
			{ true,  true,  false, "in6" },
			{ true,  true,  true,  "in7" },
		};
	}
}
