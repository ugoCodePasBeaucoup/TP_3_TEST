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
	}

}