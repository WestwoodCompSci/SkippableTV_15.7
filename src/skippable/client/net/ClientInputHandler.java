package skippable.client.net;

import skippable.common.net.NetworkInputHandler;

public class ClientInputHandler extends NetworkInputHandler {

	@Override
	public void handleInput(String input) {
		String[] temp = parseInput(input);
		//getPrintWriter().println(input);
		System.out.println(input);
		
	}

}
