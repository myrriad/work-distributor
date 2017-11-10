package testcalendar;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import due.Project;
import due.quota.DailyQuota;
import due.workunit.IObjective;
import due.workunit.WorkClumper;
import due.workunit.WorkQuantity;
import due.workunit.WorkType;
import due.workunit.WorkUnitStandard;

public class BoilerPlateTests {

	@Test
	public void testProject() {
		
		WorkQuantity quantity = new WorkQuantity(WorkUnitStandard.PAGE, 1);
		IObjective work = WorkClumper.from(quantity);
		Project p = new Project(LocalDate.of(2000, 1, 1), LocalDate.of(2000, 1, 2), work);
		assertEquals(1, p.intDays());
		
	}
	@Test
	public void testWorkQuantity1() {
		WorkQuantity quantity = new WorkQuantity(WorkUnitStandard.PAGE, 1);
		assertEquals(false, quantity.canConvertToHours());
		assertEquals(1, quantity.getQuantity(), 0);
		assertEquals(WorkUnitStandard.PAGE, quantity.getType());
	}
	@Test
	public void testWorkType1() {
		String name = "testunit";
		WorkType type = new WorkType(4, name);
		WorkQuantity quantity = new WorkQuantity(type, 7);
		assertEquals(true, quantity.canConvertToHours());
		assertEquals(7, quantity.getQuantity(), 0);
		assertEquals(28, quantity.convertToHours(), 0);
	}
	@Test
	public void clump(){
		String name = "testunit";
		WorkType type1 = new WorkType(4, name);
		WorkQuantity qua1 = new WorkQuantity(type1, 4);
		IObjective c1 = WorkClumper.from(qua1, qua1);
		// double it
		assertEquals(c1.quantityOf(type1), 8, 0);
	}
	@Test
	public void duplicateType(){
		String name = "testunit";
		WorkType type1 = new WorkType(4, name);
		WorkQuantity qua1 = new WorkQuantity(type1, 4);
		IObjective c1 = WorkClumper.from(qua1, qua1);
		// merge please
		assertEquals(c1.getQuantities().get(0).getType(), qua1.getType());
	}
	@Test
	public void testEquals(){
		String name = "testunit";
		WorkType type1 = new WorkType(4, name);
		WorkType type2 = new WorkType(4, name);
		WorkType type3 = new WorkType(3, name);
		WorkType type4 = new WorkType(4, "dont match");
		assertThat(type1, is(type2));
		assertThat(type1, not(type3));
		assertThat(type1, not(type4));
		assertThat(type3, not(type4));
		WorkQuantity qua1 = new WorkQuantity(type1, 4);
		WorkQuantity qua2 = new WorkQuantity(type2, 4);
		WorkQuantity qua3 = new WorkQuantity(type3, 6);
		WorkQuantity qua4 = new WorkQuantity(type4, 4);
		assertThat(qua1, is(qua2));
		assertThat(qua1, not(qua3));
		assertThat(qua1, not(qua3));
		assertThat(qua3, not(qua4));
		IObjective c1 = WorkClumper.from(qua1);
		IObjective c2 = WorkClumper.from(qua2);
		IObjective c3 = WorkClumper.from(qua3);
		IObjective c4 = WorkClumper.from(qua4);
		assertThat(c1, is(c2));
		assertThat(c1, not(c3));
		assertThat(c1, not(c3));
		assertThat(c3, not(c4));
		LocalDate date = LocalDate.of(2000, 1, 1);
		DailyQuota q1 = new DailyQuota(date, c1);
		DailyQuota q2 = new DailyQuota(date, c2);
		DailyQuota q3 = new DailyQuota(date, c3);
		DailyQuota q4 = new DailyQuota(date, c4);
		assertThat(q1, is (q2));
		assertThat(q1, not(q3));
		assertThat(q1, not(q3));
		assertThat(q3, not(q4));
	}

}
