package pack2;

import java.util.ArrayList;

public class StackOverFlowOutOffMemory {

	StackOverFlowOutOffMemory() {
		new StackOverFlowOutOffMemory();
	}

	public static void main(String[] args) {
		StackOverFlowOutOffMemory flow = new StackOverFlowOutOffMemory();
	}

}
