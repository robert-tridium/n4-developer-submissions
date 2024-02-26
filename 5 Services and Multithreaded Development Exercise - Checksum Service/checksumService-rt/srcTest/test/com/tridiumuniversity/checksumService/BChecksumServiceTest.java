package test.com.tridiumuniversity.checksumService;

import com.tridiumuniversity.checksumService.BChecksumService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.baja.control.trigger.BTimeTrigger;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.test.BTestNg;
import javax.baja.util.BFolder;
import java.util.Optional;

@NiagaraType
@Test
public class BChecksumServiceTest extends BTestNg {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.checksumService.BChecksumServiceTest(2979906276)1.0$ @*/
/* Generated Mon Feb 26 08:50:02 CST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BChecksumServiceTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

	@BeforeClass
	public void setup() throws Exception {
		handler = createTestStation();
		handler.startStation();

		Optional<BIService> checksumService = Sys.findService(BChecksumService.TYPE);
		if(checksumService.isPresent()) {
			service = (BChecksumService) checksumService.get();
		} else {
			service = new BChecksumService();
			handler.getStation().getServices().add("ChecksumService", service);
		}
	}

	@AfterClass
	public void cleanup() {
		handler.stopStation();
		handler.releaseStation();
		handler = null;
	}

	public void testAfterComponentTreeChanges() {
		BStation station = handler.getStation();
		long baselineChecksum = service.computeStationChecksum();

		station.add("Folder1", new BFolder());
		long add1Checksum = service.computeStationChecksum();
		Assert.assertNotEquals(add1Checksum, baselineChecksum);

		station.add("Folder2", new BFolder());
		long add2Checksum = service.computeStationChecksum();
		Assert.assertNotEquals(add2Checksum, baselineChecksum);
		Assert.assertNotEquals(add2Checksum, add1Checksum);

		station.remove("Folder2");
		long remove2Checksum = service.computeStationChecksum();
		Assert.assertEquals(remove2Checksum, add1Checksum);

		station.remove("Folder1");
		long remove1Checksum = service.computeStationChecksum();
		Assert.assertEquals(remove1Checksum, baselineChecksum);
	}

	public void testTriggerLinkCreation() {
		BLink[] links = service.getLinks(service.getSlot("generateChecksum"));
		Assert.assertEquals(links.length , 1);

		BLink link = links[0];
		BTimeTrigger trigger = service.getTrigger();
		this.verifyEquivalent(link.getSourceComponent(), trigger);
		this.verifyEquivalent(link.getTargetComponent(), service);
		Assert.assertEquals(link.getSourceSlot(), trigger.getSlot("fireTrigger"));
		Assert.assertEquals(link.getTargetSlot(), service.getSlot("generateChecksum"));
	}

	private TestStationHandler handler;
	private BChecksumService service;
}
