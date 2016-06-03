package space;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlaneTest {
	Plane plane;
	@Before
	public void newPlane(){
		plane = new Plane(50,50);
	}
	
	@Test
	public void testGetX() {
		Assert.assertEquals(50, plane.getX());	
	}
	
	@Test
	public void testSetX(){
		plane.setX(38);
		Assert.assertEquals(38, plane.getX());
	}

}
