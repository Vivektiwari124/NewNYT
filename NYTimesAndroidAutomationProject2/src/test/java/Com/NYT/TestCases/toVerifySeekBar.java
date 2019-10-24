package Com.NYT.TestCases;

import org.testng.annotations.Test;
import Com.NYT.BasePackage.businessComponent;

public class toVerifySeekBar extends businessComponent {

	@Test
	public void SeekbarTest() throws InterruptedException {
		
		//drag seek bar to 30 percent
		dragSeekBarTo(30);
		//drag seek bar to 50 percent
		dragSeekBarTo(50);
		//drag seek bar to 70 percent
		dragSeekBarTo(70);
		//drag seek bar to 90 percent
		dragSeekBarTo(90);
		dragFullSeekbar();
		
		
	}

	

	
}
