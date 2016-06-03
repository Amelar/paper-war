package space;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class CollisionDetectionTest {

	ArrayList<Plane> enemy = new ArrayList<Plane>();
	Plane plane;
	boolean endgame;
	CollisionDetection cd;
	int actuallife;
	public CollisionDetectionTest(int a, int b, int c, int d, boolean endgame, int life, int actuallife){
		this.actuallife=actuallife;
		plane = new Plane(a,b, life); 
		enemy.add(new Plane(c,d));
		this.endgame=endgame;
		
	}
	
	@Before
	public void setUp(){
		
		cd = new CollisionDetection();
	}
	@Test
	public void test() {
		cd.isCollisionDetection(plane, enemy);
		cd.isBulletCollisionDetection(plane, enemy);
		Assert.assertEquals(actuallife, (Object)plane.getLife());
		Assert.assertEquals(endgame, cd.endgame);
	}
	
	@Parameters
	public static List<Object[]> parameters(){
		List<Object[]> params = new ArrayList<Object[]>();
		params.add(new Object[] {100, 100, 100, 100, true, 10,9});
		params.add(new Object[] {40, 40, 50, 50, true, 10,8});
		params.add(new Object[] {40, 40, 40, 100, false, 10, 10});
		params.add(new Object[] {40, 40, 120, 40, false, 10,10});
		params.add(new Object[] {60, 90, 90, 140, false, 10,9});
		params.add(new Object[] {400, 425, 410, 415,   true, 10,9});
		params.add(new Object[] {225, 35, 190, 45, false, 10,10});
		 return params; 
		
	}

}
