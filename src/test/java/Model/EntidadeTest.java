package test.java.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;

public class EntidadeTest {
    
    private static Endereco endereco;

    @BeforeClass
	public static void setUp(){
        endereco = new Endereco();
		endereco.setBairro( "Dirceu");
		endereco.setCep("64078-213");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setRua("Rua Des. Berilo Mota");
        endereco.setNumero("10");
    }

    @Test
    public void TestCriarEntidade(){

        Entidade entidade = new Entidade();
        entidade.setCnpj("123456789");
		entidade.setEndereco(endereco);
		entidade.setNome("Academia 1");
		entidade.setTelefone1("(086)1234-5432");
        entidade.setTelefone2("(011)1234-6789");

        System.out.println(endereco);

        assertEquals(entidade.getCnpj() , "123456789");
        assertNotNull(entidade.getEndereco());
        assertEquals(entidade.getNome() , "Academia 1");
        assertEquals(entidade.getTelefone1(), "(086)1234-5432");
        assertEquals(entidade.getTelefone2(), "(011)1234-6789");
        
    }

}
