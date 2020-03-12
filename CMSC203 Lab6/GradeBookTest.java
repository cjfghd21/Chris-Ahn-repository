import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
		GradeBook testOne;
		GradeBook testTwo;
	@BeforeEach
	void setUp() throws Exception {
		 testOne = new GradeBook(5);
		 testTwo = new GradeBook(5);
		
		testOne.addScore(90.5);
		testOne.addScore(85.4);
		testOne.addScore(75.4);
		
		testTwo.addScore(76.60);
		testTwo.addScore(85.40);
		testTwo.addScore(89.00);
		testTwo.addScore(83.30);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		testOne = null;
		testTwo = null;
	}

	@Test
	void testGetScoreSize() {
		assertEquals(3, testOne.getScoreSize());
		assertEquals(4, testTwo.getScoreSize());
	}

	@Test
	void testAddScore() {
		assertTrue(testOne.toString().equals("90.5 85.4 75.4 "));
		int scoresSize = testOne.getScoreSize();
		assertEquals(3, scoresSize);
		
		assertTrue(testTwo.toString().equals("76.6 85.4 89.0 83.3 "));
		scoresSize = testTwo.getScoreSize();
		assertEquals(4, scoresSize);
	}

	@Test
	void testSum() {
		
		assertEquals(251.3, testOne.sum());	
		assertEquals(334.3, testTwo.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(75.4, testOne.minimum());
		assertEquals(76.6, testTwo.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(175.9 ,testOne.finalScore());
	}


	

}
