package test.java.org.fpij.jitakyoei.util;

import org.junit.Test;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Faixa;
import main.java.org.fpij.jitakyoei.model.beans.Rg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class FiliadoTest {

    // Testando o método toString
    @Test
    public void testToString() {
        Filiado f = new Filiado();
        f.setNome("João");
        f.setDataNascimento(new Date());
        f.setCpf("123.456.789-00");

        // Verificando se o método toString retorna o formato esperado
        String expected = "Nome: João\nRegistroCbj: null\nDataNasc: " + f.getDataNascimento()
                + "\nE-mail: null\nCPF: 123.456.789-00";
        assertEquals("Verificando saída do método toString", expected, f.toString());
    }

    // Testando o método equals com o mesmo objeto
    @Test
    public void testEquals_SameObject() {
        Filiado f = new Filiado();
        f.setId(1L);
        f.setNome("João");

        // Verifica se o método equals retorna true para o mesmo objeto
        assertTrue("O método equals deve retornar true para o mesmo objeto", f.equals(f));
    }

    // Testando o método equals com objetos diferentes mas com os mesmos valores
    @Test
    public void testEquals_DifferentObjectSameValues() {
        Filiado f1 = new Filiado();
        f1.setId(1L);
        f1.setNome("João");

        Filiado f2 = new Filiado();
        f2.setId(1L);
        f2.setNome("João");

        // Verifica se o método equals retorna true para objetos diferentes com os
        // mesmos valores
        assertTrue("O método equals deve retornar true para objetos diferentes com os mesmos valores", f1.equals(f2));
    }

    // Testando o método equals com objeto null
    @Test
    public void testEquals_NullObject() {
        Filiado f1 = new Filiado();
        f1.setId(1L);
        f1.setNome("João");

        Filiado f2 = null;

        // Verifica se o método equals retorna false quando comparado com null
        assertFalse("O método equals deve retornar false para objeto null", f1.equals(f2));
    }

    // Testando o método equals com objetos de classes diferentes
    @Test
    public void testEquals_DifferentClass() {
        Filiado f1 = new Filiado();
        f1.setId(1L);
        f1.setNome("João");

        Object obj = new Object();

        // Verifica se o método equals retorna false para objetos de classes diferentes
        assertFalse("O método equals deve retornar false para objetos de classes diferentes", f1.equals(obj));
    }

    // Testando o método equals com valores diferentes
    @Test
    public void testEquals_DifferentValues() {
        Filiado f1 = new Filiado();
        f1.setId(1L);
        f1.setNome("João");

        Filiado f2 = new Filiado();
        f2.setId(2L);
        f2.setNome("Maria");

        // Verifica se o método equals retorna false para objetos com valores diferentes
        assertFalse("O método equals deve retornar false para objetos com valores diferentes", f1.equals(f2));
    }

    // Testando o método hashCode
    @Test
    public void testHashCode() {
        Filiado f = new Filiado();
        f.setId(123L);

        // Verifica se o hashCode gera o valor esperado baseado no id
        assertEquals("O hashCode deve ser baseado no campo id", 123, f.hashCode());
    }

    // Testando o método copyProperties
    @Test
    public void testCopyProperties() {
        Filiado source = new Filiado();
        source.setId(1L);
        source.setNome("João");
        source.setCpf("123.456.789-00");

        Filiado target = new Filiado();
        target.copyProperties(source);

        // Verifica se os valores foram copiados corretamente
        assertEquals("Os valores devem ser copiados corretamente", source.getId(), target.getId());
        assertEquals("Os valores devem ser copiados corretamente", source.getNome(), target.getNome());
        assertEquals("Os valores devem ser copiados corretamente", source.getCpf(), target.getCpf());
    }

    // Testando a adição de faixa
    @Test
    public void testAddFaixa() {
        Filiado f = new Filiado();
        Faixa faixa = new Faixa();
        f.getFaixas().add(faixa);

        // Verifica se a faixa foi adicionada corretamente à lista
        assertEquals("Faixa deve ser adicionada à lista", 1, f.getFaixas().size());
        assertTrue("A lista deve conter a faixa adicionada", f.getFaixas().contains(faixa));
    }

    // Testando o Getter e Setter de Endereço
    @Test
    public void testGetSetEndereco() {
        Filiado f = new Filiado();
        Endereco endereco = new Endereco();
        endereco.setRua("Rua A");
        f.setEndereco(endereco);

        // Verifica se o getter retorna o valor correto
        assertEquals("Getter de Endereço não retorna o valor correto", "Rua A", f.getEndereco().getRua());
    }

    // Testando o Getter e Setter de RG
    @Test
    public void testGetSetRg() {
        Filiado f = new Filiado();
        Rg rg = new Rg();
        rg.setNumero("123456");
        f.setRg(rg);

        // Verifica se o getter retorna o valor correto
        assertEquals("Getter de RG não retorna o valor correto", "123456", f.getRg().getNumero());
    }

    // Testando o Getter e Setter de Observações
    @Test
    public void testSetGetObservacoes() {
        Filiado f = new Filiado();
        f.setObservacoes("Observação de teste");

        // Verifica se o getter e setter de observações funcionam corretamente
        assertEquals("Getter e Setter de observações não funcionam corretamente", "Observação de teste",
                f.getObservacoes());
    }
}