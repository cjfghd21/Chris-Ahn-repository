package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	GradeBook gradeOne;
	GradeBook gradeTwo;

	@BeforeEach
	void setUp() throws Exception {
		gradeOne = new GradeBook(5);
		gradeOne.addScore(30);
		gradeOne.addScore(50);
		gradeOne.addScore(40);
		gradeOne.addScore(35);
		gradeOne.addScore(31);
		
		gradeTwo = new GradeBook(5);
		gradeTwo.addScore(25);
		gradeTwo.addScore(20);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeOne = null;
		gradeTwo = null;
	}
	



	@Test
	void testAddScore() {
		assertTrue(gradeOne.toString().equals("30.0 50.0 40.0 35.0 31.0 "));
		assertTrue(gradeTwo.toString().equals("25.0 20.0 "));
		
		assertEquals(gradeOne.getScoreSize(),5);
		assertEquals(gradeTwo.getScoreSize(),2);
	
	}

	@Test
	void testSum() {
		assertEquals(gradeOne.sum(),186.0);
		assertEquals(gradeTwo.sum(),45.0);
		
	}

	@Test
	void testMinimum() {
		assertEquals(gradeOne.minimum(),30.0);
		assertEquals(gradeTwo.minimum(),20.0);
	}

	@Test
	void testFinalScore() {
		assertEquals(gradeOne.finalScore(),156.0);
		assertEquals(gradeTwo.finalScore(),25.0);
		
	}

}
