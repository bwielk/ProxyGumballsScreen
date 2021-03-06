package gumballs;

public class WinnerState implements State {
	
	transient GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	public String acceptQuarter() {
		return "The transaction is being processed";
	}

	public boolean ejectQuarter() {
		System.out.println("Sorry, too late. You have already turned the crank ");
		return false;
	}

	public boolean turnCrank() {
		return false;
	}

	public String dispense(){
		gumballMachine.releaseGum();
		System.out.println("You have won an extra gum ball!");
		if(gumballMachine.getCount() == 0){
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}else{
			gumballMachine.releaseGum();
			if(gumballMachine.getCount() > 0){
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			}else{
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
		return null;
	}
}