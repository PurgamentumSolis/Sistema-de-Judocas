package main.java.org.fpij.jitakyoei.model.beans;

import org.junit.Test;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Faixa;
import main.java.org.fpij.jitakyoei.model.beans.Rg;

import java.util.Date;

import static org.junit.Assert.*;

public class FiliadoTest {

    @Test
    public void testEquals() {
        Filiado f1 = new Filiado();
        Filiado f2 = new Filiado();

        f1.setId(1L);
        f1.setNome("João");
        f2.setId(1L);
        f2.setNome("João");

        assertTrue("Objetos iguais deveriam retornar true no equals", f1.equals(f2));
    }

    @Test
    public void testHashCode() {
        Filiado f1 = new Filiado();
        Filiado f2 = new Filiado();

        f1.setId(1L);
        f2.setId(1L);

        assertEquals("HashCodes devem ser iguais para objetos iguais", f1.hashCode(), f2.hashCode());
    }

    @Test
    public void testToString() {
        Filiado f = new Filiado();
        f.setNome("João");
        f.setDataNascimento(new Date());
        f.setCpf("123.456.789-00");

        String expected = "Nome: João\nRegistroCbj: null\nDataNasc: " + f.getDataNascimento()
                + "\nE-mail: null\nCPF: 123.456.789-00";
        assertEquals("toString não retorna o formato esperado", expected, f.toString());
    }

    @Test
    public void testGetSetNome() {
        Filiado f = new Filiado();
        f.setNome("João");
        assertEquals("Getter ou setter de nome não funciona corretamente", "João", f.getNome());
    }

    @Test
    public void testGetSetCpf() {
        Filiado f = new Filiado();
        f.setCpf("123.456.789-00");
        assertEquals("Getter ou setter de CPF não funciona corretamente", "123.456.789-00", f.getCpf());
    }

    @Test
    public void testCopyProperties() {
        Filiado source = new Filiado();
        source.setNome("João");
        source.setCpf("123.456.789-00");

        Filiado target = new Filiado();
        target.copyProperties(source);

        assertEquals("Nome não foi copiado corretamente", "João", target.getNome());
        assertEquals("CPF não foi copiado corretamente", "123.456.789-00", target.getCpf());
    }

    @Test
    public void testAddFaixa() {
        Filiado f = new Filiado();
        Faixa faixa = new Faixa();
        f.getFaixas().add(faixa);

        assertEquals("Faixa não foi adicionada corretamente", 1, f.getFaixas().size());
        assertTrue("Lista de faixas não contém a faixa adicionada", f.getFaixas().contains(faixa));
    }

    @Test
    public void testSetGetEndereco() {
        Filiado f = new Filiado();
        Endereco endereco = new Endereco();
        endereco.setRua("Rua A");
        f.setEndereco(endereco);

        assertEquals("Endereço não foi configurado corretamente", "Rua A", f.getEndereco().getRua());
    }

    @Test
    public void testSetGetRg() {
        Filiado f = new Filiado();
        Rg rg = new Rg();
        rg.setNumero("123456");
        f.setRg(rg);

        assertEquals("RG não foi configurado corretamente", "123456", f.getRg().getNumero());
    }
}