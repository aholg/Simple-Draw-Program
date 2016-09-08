package aholg.controller;

import aholg.model.Observer;

public class testObsderver implements Observer{
	private String lastOutput;
	public String getLastOutput() {
		return lastOutput;
	}
	@Override
	public void notify(String output) {
		lastOutput=output;
		
	}

	
}
