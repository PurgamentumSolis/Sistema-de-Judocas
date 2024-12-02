package test.java.Model;

import main.java.org.fpij.jitakyoei.model.beans.Rg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RgTest {

	@Test
	public void testeCriarRG(){
		Rg rg = new Rg("123456789", "SEJUSP");
		assertEquals("123456789", rg.getNumero());
		assertEquals("SEJUSP", rg.getOrgaoExpedidor());
	}

	@Test
	public void testeCompararRG(){
		Rg rg = new Rg("123456789", "SEJUSP");
		Rg rg2 = new Rg("987654321", "SEJUSP");
		assertFalse(rg.equals(rg2));
	
		Rg rg3 = new Rg("123456789", "SEJUSP");
		assertTrue(rg.equals(rg3));
	}

	@Test
	public void testeCompararHashCode(){
		Rg rg = new Rg("123456789", "SEJUSP");
		Rg rg2 = new Rg("987654321", "SEJUSP");
		assertNotEquals(rg.hashCode(), rg2.hashCode());
	
		Rg rg3 = new Rg("123456789", "SEJUSP");
		assertEquals(rg.hashCode(), rg3.hashCode());
	}

	@Test
	public void testeSetterGetter(){
		Rg rg = new Rg("123456789", "SEJUSP");
		assertEquals(rg.getNumero(),"123456789");
		assertEquals(rg.getOrgaoExpedidor(), "SEJUSP");
	}

}