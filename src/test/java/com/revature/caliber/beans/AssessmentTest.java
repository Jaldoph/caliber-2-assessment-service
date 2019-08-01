package com.revature.caliber.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AssessmentTest {

	@Test
	public void testAssessment()  {
		
		Assessment a = new Assessment();
		a.setAssessmentCategory(2);
		a.setAssessmentId(4);
		a.setAssessmentTitle("Java");
		a.setAssessmentType("Exam");
		a.setBatchId(5);
		a.setRawScore(80);
		a.setWeekNumber(3);
		
		assertEquals(Integer.valueOf(2), a.getAssessmentCategory());
		assertEquals(Integer.valueOf(4), a.getAssessmentId());
		assertEquals("Exam", a.getAssessmentType());
		assertEquals("Java", a.getAssessmentTitle());
		assertEquals(Integer.valueOf(5), a.getBatchId());
		assertEquals(Integer.valueOf(80), a.getRawScore());
		assertEquals(Integer.valueOf(3), a.getWeekNumber());
	}
	
	@Test
	public void testAssessmentConstructor()  {
		
		Assessment as = new Assessment(2,60,"Spring","Verbal",8,7,8);
		
		assertEquals(Integer.valueOf(2), as.getAssessmentId());
		assertEquals(Integer.valueOf(60), as.getRawScore());
		assertEquals("Spring", as.getAssessmentTitle());
		assertEquals("Verbal", as.getAssessmentType());
		assertEquals(Integer.valueOf(8), as.getWeekNumber());
		assertEquals(Integer.valueOf(7), as.getBatchId());
		assertEquals(Integer.valueOf(8), as.getAssessmentCategory());
	}
}
