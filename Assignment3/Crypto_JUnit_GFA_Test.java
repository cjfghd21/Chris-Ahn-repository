
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Crypto_JUnit_GFA_Test {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.stringInBounds("THIS TEST SHOULD SUCCEED"));
	}
	@Test
	public void testEncryptCaesar() {
		assertEquals("KHOOR#ZRUOG",CryptoManager.encryptCaesar("HELLO WORLD", 3));
	}
	@Test
	public void testDecryptCaesar() {
		assertEquals("FCJJM^UMPJB", CryptoManager.decryptCaesar("IFMMP!XPSME", 3));
	
	}
}
