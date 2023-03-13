package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
				
		// create a client object and use it to
		Client client = new Client("display:", Common.BROKERHOST, Common.BROKERPORT);
		
		// - connect to the broker - use "display" as the username
		client.connect();

		// - create the temperature topic on the broker
		client.createTopic(Common.TEMPTOPIC);

		// - subscribe to the topic
		client.subscribe(Common.TEMPTOPIC);

		// - receive messages on the topic
		for (int i = 0; i < COUNT; i++) { //for (int i = 0; i < 10; i++)
			System.out.println(((PublishMsg)client.receive()).getMessage());
		}

		// - unsubscribe from the topic
		client.unsubscribe(Common.TEMPTOPIC);

		// - disconnect from the broker
		client.disconnect();

		System.out.println("Display stopping ... ");
		
		throw new UnsupportedOperationException(TODO.method());
		
	}
}
