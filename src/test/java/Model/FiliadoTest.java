package test.java.Model;

import org.junit.Test;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Faixa;
import main.java.org.fpij.jitakyoei.model.beans.Rg;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class FiliadoTest {

    @Test
    public void testToString() {
        Filiado f = new Filiado();
        f.setNome("João");
        f.setDataNascimento(new Date());
        f.setCpf("123.456.789-00");

        String expected = "Nome: João\nRegistroCbj: null\nDataNasc: " + f.getDataNascimento()
                + "\nE-mail: null\nCPF: 123.456.789-00";
        assertEquals("Verificando saída do método toString", expected, f.toString());
    }

    @Test
    public void testEquals_SameObject() {
        Filiado f = new Filiado();
        f.setId(1L);
        f.setNome("João");

        assertTrue("O método equals deve retornar true para o mesmo objeto", f.equals(f));
    }

    @Test
    public void testEquals_DifferentObjectSameValues() {
        Filiado f1 = new Filiado();
        f1.setId(1L);
        f1.setNome("João");

        Filiado f2 = new Filiado();
        f2.setId(1L);
        f2.setNome("João");

        assertTrue("O método equals deve retornar true para objetos diferentes com os mesmos valores", f1.equals(f2));
    }

    @Test
    public void testEquals_NullObject() {
        Filiado f1 = new Filiado();
        f1.setId(1L);
        f1.setNome("João");

        Filiado f2 = null;

        assertFalse("O método equals deve retornar false para objeto null", f1.equals(f2));
    }

    @Test
    public void testEquals_DifferentClass() {
        Filiado f1 = new Filiado();
        f1.setId(1L);
        f1.setNome("João");

        Object obj = new Object();

        assertFalse("O método equals deve retornar false para objetos de classes diferentes", f1.equals(obj));
    }

    @Test
    public void testEquals_DifferentValues() {
        Filiado f1 = new Filiado();
        f1.setId(1L);
        f1.setNome("João");

        Filiado f2 = new Filiado();
        f2.setId(2L);
        f2.setNome("Maria");

        assertFalse("O método equals deve retornar false para objetos com valores diferentes", f1.equals(f2));
    }

    @Test
    public void testHashCode() {
        Filiado f = new Filiado();
        f.setId(123L);

        assertEquals("O hashCode deve ser baseado no campo id", 123, f.hashCode());
    }

    @Test
    public void testCopyProperties() {
        Filiado source = new Filiado();
        source.setId(1L);
        source.setNome("João");
        source.setCpf("123.456.789-00");

        Filiado target = new Filiado();
        target.copyProperties(source);

        assertEquals("Os valores devem ser copiados corretamente", source.getId(), target.getId());
        assertEquals("Os valores devem ser copiados corretamente", source.getNome(), target.getNome());
        assertEquals("Os valores devem ser copiados corretamente", source.getCpf(), target.getCpf());
    }

    @Test
    public void testAddFaixa() {
        Filiado f = new Filiado();
        Faixa faixa = new Faixa();
        f.getFaixas().add(faixa);

        assertEquals("Faixa deve ser adicionada à lista", 1, f.getFaixas().size());
        assertTrue("A lista deve conter a faixa adicionada", f.getFaixas().contains(faixa));
    }

    @Test
    public void testGetSetEndereco() {
        Filiado f = new Filiado();
        Endereco endereco = new Endereco();
        endereco.setRua("Rua A");
        f.setEndereco(endereco);

        assertEquals("Getter de Endereço não retorna o valor correto", "Rua A", f.getEndereco().getRua());
    }

    @Test
    public void testGetSetRg() {
        Filiado f = new Filiado();
        Rg rg = new Rg();
        rg.setNumero("123456");
        f.setRg(rg);

        assertEquals("Getter de RG não retorna o valor correto", "123456", f.getRg().getNumero());
    }

    @Test
    public void testSetGetObservacoes() {
        Filiado f = new Filiado();
        f.setObservacoes("Observação de teste");

        assertEquals("Getter e Setter de observações não funcionam corretamente", "Observação de teste",
                f.getObservacoes());
    }
}
