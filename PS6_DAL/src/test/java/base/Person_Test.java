package base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	private static PersonDomainModel per1 = new PersonDomainModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		per1.setBirthday(new Date(0));
		per1.setCity("York");
		per1.setFirstName("Becca");
		per1.setLastName("Schwartz");
		per1.setPostalCode(17403);
		per1.setStreet("35 Ray");
		
		PersonDAL.addPerson(per1);
		
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		
		assertNotNull(per2);
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(per1.getPersonID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AddPerson() {
		PersonDomainModel per1 = new PersonDomainModel();
		per1.setBirthday(new Date(0));
		per1.setCity("York");
		per1.setFirstName("Rebecca");
		per1.setLastName("Schwartz");
		per1.setPostalCode(17403);
		per1.setStreet("35 Rat");
		
		PersonDAL.addPerson(per1);
		
	}

	@Test
	public void TestUpdateDeletePerson() {
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per1.getPersonID(), per2.getPersonID());
		per2.setLastName("McClane");
		PersonDAL.updatePerson(per2);
		assertEquals("McClane", per2.getLastName());
		assertNotEquals(per1.getLastName(), per2.getLastName());
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDomainModel per3 = PersonDAL.getPerson(per1.getPersonID());
		assertNull(per3);
		
		
		
	}
	@Test
	public void TestGetAllPersons() {
		ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
		assertNotNull(pers);
		
	}

}
