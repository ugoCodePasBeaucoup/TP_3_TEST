package ilu2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {

	@BeforeEach
	void setUp() {

	}

	@Test
	void EX_1() {
		assertEquals("Hello, Bob", Welcome.welcome("bob"));
		assertEquals("Hello, Jack", Welcome.welcome("jack"));
		assertEquals("Hello, Marc", Welcome.welcome("Marc"));
		assertEquals("Hello, M", Welcome.welcome("m"));
	}

	@Test
	void EX_2() {
		assertEquals("Hello, my friend", Welcome.welcome(""));
		assertEquals("Hello, my friend", Welcome.welcome(" "));
		assertEquals("Hello, my friend", Welcome.welcome("   "));
	}

	@Test
	void EX_3() {
		assertEquals("HELLO, BOB !", Welcome.welcome("BOB"));
		assertEquals("HELLO, DEPARDIEUX !", Welcome.welcome("DEPARDIEUX"));
		assertEquals("HELLO, CHUUUUUUT !", Welcome.welcome("CHUUUUUUT"));
	}

	@Test
	void EX_4() {
		assertEquals("Hello, Amy and Bob", Welcome.welcome("amy,bob"));
		assertEquals("Hello, Marc and Jean", Welcome.welcome("marc,Jean"));
		assertEquals("Hello, Eric and CHUt", Welcome.welcome("eric,CHUt"));
	}

	@Test
	void EX_5() {
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("amy,bob,jerry"));
		assertEquals("Hello, Marc, Jean, Kevin and Arnold", Welcome.welcome("marc,Jean,Kevin,arnold"));
		assertEquals("Hello, Eric, Franck and Simon", Welcome.welcome("eric,franck,simon"));
	}

	@Test
	void EX_6() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("Amy,BOB,Jerry"));
		assertEquals("Hello, Marc and Kevin. AND HELLO, JEAN AND ARNOLD !", Welcome.welcome("marc,JEAN,Kevin,ARNOLD"));
		assertEquals("Hello, Eric, Franck and Simon. AND HELLO, CHUT !", Welcome.welcome("CHUT,eric,franck,simon"));
	}

	@Test
	void EX_7() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("Amy,BOB,Jerry"));
		assertEquals("Hello, Marc and Kevin. AND HELLO, JEAN AND ARNOLD !", Welcome.welcome("marc,JEAN,Kevin,ARNOLD"));
		assertEquals("Hello, Eric, Franck and Simon. AND HELLO, CHUT !", Welcome.welcome("CHUT,eric,franck,simon"));
	}

	@Test
	void EX_8() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("Amy  ,  BOB,Jerry   "));
		assertEquals("Hello, Marc and Kevin. AND HELLO, JEAN AND ARNOLD !",
				Welcome.welcome("marc     ,JEAN, Kevin,ARNOLD"));
		assertEquals("Hello, Eric, Franck and Simon. AND HELLO, CHUT !",
				Welcome.welcome("     CHUT  ,eric ,  franck,  simon"));
	}

}
