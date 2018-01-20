package gumballs;

import java.util.HashMap;

public class Monitor {
	
	private GumballMachine machine;
	
	public Monitor(GumballMachine machine){
		this.machine = machine;
	}
	
	public HashMap generateReport(){
		HashMap report = new HashMap();
		report.put("location", machine.getLocation());
		report.put("number of gums", machine.getCount());
		report.put("current state", machine.getState());
		report.put("current income", machine.getTotal());
		return report;
	}
}
