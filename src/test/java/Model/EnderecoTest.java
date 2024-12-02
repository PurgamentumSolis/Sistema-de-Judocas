package test.java.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;

public class EnderecoTest {
    
    @Test
    public void TestCriarEndereço(){

        Endereco end = new Endereco();
		end.setBairro("Dirceu");
		end.setCep("64078-213");
		end.setCidade("Teresina");
		end.setEstado("PI");
		end.setRua("Rua Des. Berilo Mota");
        end.setNumero("10");

        assertEquals(end.getBairro(), "Dirceu");
        assertEquals(end.getCep(), "64078-213");
        assertEquals(end.getCidade(), "Teresina");
        assertEquals(end.getEstado(), "PI");
        assertEquals(end.getRua(), "Rua Des. Berilo Mota");
        assertEquals(end.getNumero(), "10");
        
    }
}
