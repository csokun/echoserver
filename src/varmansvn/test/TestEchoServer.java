package varmansvn.test;

import org.junit.Test;

import varmansvn.util.EchoServerConfigReader;

public class TestEchoServer {

	@Test
	public void test() {
		
		EchoServerConfigReader configReader = EchoServerConfigReader.getInstance();
		
		assert(configReader.getPropertyValue("ip") == "127.0.0.1");
		
		assert(configReader.getPropertyValue("port") == "9899");
	}

}
