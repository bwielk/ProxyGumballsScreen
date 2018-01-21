package gumballs;

import java.io.*;

public interface State extends Serializable{
	String acceptQuarter();
	boolean ejectQuarter();
	boolean turnCrank();
	String dispense();
}
