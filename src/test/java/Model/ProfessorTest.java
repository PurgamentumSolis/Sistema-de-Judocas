package test.java.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Professor;

public class ProfessorTest {

	private static Entidade entidade;
	private static Endereco endereco;
	private static Filiado filiadoProf;
    private static Filiado filiadoProf2;
    private static Date dataAtual = new Date();

    @BeforeClass
	public static void setUp(){

		endereco = new Endereco();
		endereco.setBairro("Dirceu");
		endereco.setCep("64078-213");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setRua("Rua Des. Berilo Mota");
		
		filiadoProf = new Filiado();
		filiadoProf.setNome("Professor");
		filiadoProf.setCpf("036.464.453-27");
		filiadoProf.setDataNascimento(dataAtual);
		filiadoProf.setDataCadastro(dataAtual);
		filiadoProf.setId(3332L);
		filiadoProf.setEndereco(endereco);
        filiadoProf.setRegistroCbj("1234568944");
        filiadoProf.setEmail("EMAIL");

        filiadoProf2 = new Filiado();
		filiadoProf2.setNome("Professorr");
		filiadoProf2.setCpf("036.464.453-26");
		filiadoProf2.setDataNascimento(dataAtual);
		filiadoProf2.setDataCadastro(dataAtual);
		filiadoProf2.setId(3332L);
		filiadoProf2.setEndereco(endereco);
        filiadoProf2.setRegistroCbj("1234568944");
        filiadoProf2.setEmail("EMAIL");
	
	
		entidade = new Entidade();
		entidade.setEndereco(endereco);
		entidade.setNome("Academia 1");
		entidade.setTelefone1("(086)1234-5432");
		
	}
    

    @Test
    public void TesteCriarProfessor(){
        Professor professor = new Professor();
        professor.setFiliado(filiadoProf);

        List<Entidade> listaDeEntidades = new ArrayList<>();
        listaDeEntidades.add(entidade);
        professor.setEntidades(listaDeEntidades);

        assertEquals(professor.getFiliado().getNome(), "Professor");
        assertEquals(professor.getFiliado().getRegistroCbj(), "1234568944");
        assertEquals(professor.getFiliado().getDataNascimento(), dataAtual);
        assertEquals(professor.getFiliado().getEmail(), "EMAIL");

        assertEquals(professor.getEntidades().get(0).getNome(), "Academia 1");
        assertEquals(professor.getEntidades().get(0).getTelefone1(), "(086)1234-5432");

    }

    @Test 
    public void TesteCompararHashCode(){
        Professor professor = new Professor();
        professor.setFiliado(filiadoProf);

        Professor professor2 = new Professor();
        professor2.setFiliado(filiadoProf2);

        assertNotEquals(professor.hashCode(), professor2.hashCode());
        
        assertEquals(professor.hashCode(), professor.hashCode());

    }

    @Test
    public void TesteFunçãoEquals(){
        Professor professor = new Professor();  
        assertEquals(professor.equals(professor), true);

        Professor professor2 = new Professor();  
        assertEquals(professor.equals(professor2), false);
    }

}
