package nl.uu.cs.aplib.MainConcepts;

import static nl.uu.cs.aplib.AplibEDSL.* ;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.* ;

public class Test_GoalTree {
	
	
	@Test
	public void test_getNextPrimitiveGoalWorker() {
		
		var g1 = lift(goal("g1")) ;
		var g2 = lift(goal("g2")) ;
		var g3 = lift(goal("g3")) ;
		var g4 = lift(goal("g4")) ;
		var g5 = lift(goal("g5")) ;
		var g6 = lift(goal("g6")) ;
		var a = FIRSTof(g1,g2) ;
		var b = FIRSTof(g3,g4) ;
		var c = SEQ(a,b,g5) ;
		var d = FIRSTof(c,g6) ;
		
		var h1f = g1.getNextPrimitiveGoalWorker(ProgressStatus.FAILED) ;
		var h1s = g1.getNextPrimitiveGoalWorker(ProgressStatus.SUCCESS) ;
		System.out.println(h1f.goal.getName()) ;
		System.out.println(h1s.goal.getName()) ;
		assertTrue(h1f == g2) ;
		assertTrue(h1s == g3) ;
		
		var h2f = g2.getNextPrimitiveGoalWorker(ProgressStatus.FAILED) ;
		var h2s = g2.getNextPrimitiveGoalWorker(ProgressStatus.SUCCESS) ;
		System.out.println(h2f.goal.getName()) ;
		System.out.println(h2s.goal.getName()) ;
		assertTrue(h2f == g6) ;
		assertTrue(h2s == g3) ;
		
		var h3f = g3.getNextPrimitiveGoalWorker(ProgressStatus.FAILED) ;
		var h3s = g3.getNextPrimitiveGoalWorker(ProgressStatus.SUCCESS) ;
		System.out.println(h3f.goal.getName()) ;
		System.out.println(h3s.goal.getName()) ;
		assertTrue(h3f == g4) ;
		assertTrue(h3s == g5) ;
				
		var h5f = g5.getNextPrimitiveGoalWorker(ProgressStatus.FAILED) ;
		var h5s = g5.getNextPrimitiveGoalWorker(ProgressStatus.SUCCESS) ;
		System.out.println(h5f.goal.getName()) ;
		System.out.println("" + h5s) ;
		assertTrue(h5f == g6) ;
		assertTrue(h5s == null) ;
		
		var h6f = g6.getNextPrimitiveGoalWorker(ProgressStatus.FAILED) ;
		var h6s = g6.getNextPrimitiveGoalWorker(ProgressStatus.SUCCESS) ;
		System.out.println("" + h6f) ;
		System.out.println("" + h6s) ;
		assertTrue(h6f == null) ;
		assertTrue(h6s == null) ;
		
	}
	
	
	static public void main(String[] args) {
		
	}

}