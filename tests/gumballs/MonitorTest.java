package gumballs;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class MonitorTest{
	
	private GumballMachine machine1;
	private GumballMachine machine2;
	private Monitor monitor1;
	private Monitor monitor2;
	
	@Before
	public void before() throws RemoteException{
		machine1 = new GumballMachine("EH68SF", 30);
		machine2 = new GumballMachine("EH130QE", 20);
		monitor1 = new Monitor(machine1);
		monitor2 = new Monitor(machine2);
	}

	@Test
	public void monitorGeneratesinforAboutAMachineAfterASale1() {
		machine1.acceptQuarter();
		machine1.ejectQuarter();
		machine1.acceptQuarter();
		machine1.turnCrank();
		HashMap result = monitor1.generateReport();
		assertEquals("EH68SF", result.get("location"));
		assertEquals(29, result.get("number of gums"));
		assertEquals(0.25, result.get("current income"));
		assertEquals(NoQuarterState.class, result.get("current state").getClass());
	}
	
	@Test
	public void monitorGeneratesInfformationAboutMachineAfterASale2(){
		machine2.acceptQuarter();
		machine2.turnCrank();
		machine2.acceptQuarter();
		machine2.turnCrank();
		machine2.acceptQuarter();
		HashMap result = monitor2.generateReport();
		assertEquals("EH130QE", result.get("location"));
		assertEquals(18, result.get("number of gums"));
		assertEquals(0.75, result.get("current income"));
		assertEquals(HasQuarterState.class, result.get("current state").getClass());
	}

}
