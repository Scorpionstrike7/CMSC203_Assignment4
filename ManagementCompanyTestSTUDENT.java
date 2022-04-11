

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	// Variables
		ManagementCompany mgmtCo;
		
		@Before
		public void setUp() throws Exception {
			//student create a management company
			mgmtCo = new ManagementCompany("MGMT Company 1", "ABC123", 6);
			
			//student add three properties, with plots, to mgmt co
			mgmtCo.addProperty("Almost Aspen", "Glendale", 4844.00, "Sammy Smith",2,1,2,2);
			mgmtCo.addProperty("Ambiance", "Lakewood", 4114, "Tammy Taylor",4,1,2,2);
			mgmtCo.addProperty("Bear Creek Lodge", "Peninsula", 4905, "Bubba Burley",6,1,2,2);		
		}

		@After
		public void tearDown() {
			//student set mgmt co to null  
			mgmtCo = null;  
		}

		@Test
		public void testAddPropertyDefaultPlot() {
			assertEquals(mgmtCo.addProperty("Sunsational", "Beckman", 2613, "BillyBob Wilson"),4,0); //student should add property with 4 args 
			//& default plot (0,0,1,1)
			assertEquals(mgmtCo.addProperty("Mystic Cove", "Lakepointe", 5327, "Joey BagODonuts",4,5,2,2),5,0); //student should add property with 8 args
			assertEquals(mgmtCo.addProperty("Too Many Properties", "Lakepointe", 1000, "Joey BagODonuts"),6,0); //student should add property 
			//that exceeds the size of the mgmt co array and can not be added, add property should return -1		
		}
	 
		@Test
		public void testMaxPropertyRent() {
			//student should test if maxRentProp contains the maximum rent of properties
			assertEquals(mgmtCo.maxRentProp(),5000,0);
		}

		@Test
		public void testTotalRent() {
			//student should test if totalRent returns the total rent of properties
			assertEquals(mgmtCo.totalRent(),11450,0);
		}

	 }