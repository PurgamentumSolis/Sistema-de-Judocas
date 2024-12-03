package test.java.org.fpij.jitakyoei.util;

import static org.junit.Assert.*;

import org.junit.Test;
import main.java.org.fpij.jitakyoei.util.CorFaixa;
import java.util.List;

public class CorFaixaTest {

    @Test
    public void testGetDescricao() {
        // Testando o método getDescricao para algumas faixas específicas
        assertEquals("Branca", CorFaixa.BRANCA.getDescricao());
        assertEquals("Azul", CorFaixa.AZUL.getDescricao());
        assertEquals("Preta 1º Dan", CorFaixa.PRETA1DAN.getDescricao());
    }

    @Test
    public void testToString() {
        // Testando o método toString para algumas faixas
        assertEquals("Branca", CorFaixa.BRANCA.toString());
        assertEquals("Cinza", CorFaixa.CINZA.toString());
        assertEquals("Vermelha 10º Dan", CorFaixa.VERMELHA10DAN.toString());
    }

    @Test
    public void testGetCoresFaixa() {
        // Testando o método getCoresFaixa para garantir que todas as cores estão sendo
        // retornadas
        List<CorFaixa> cores = CorFaixa.getCoresFaixa();

        // Verificando se a lista não está vazia
        assertNotNull(cores);
        assertFalse(cores.isEmpty());

        // Verificando se todas as faixas foram adicionadas à lista
        assertTrue(cores.contains(CorFaixa.BRANCA));
        assertTrue(cores.contains(CorFaixa.AZUL));
        assertTrue(cores.contains(CorFaixa.PRETA5DAN));
        assertTrue(cores.contains(CorFaixa.VERMELHA10DAN));

        // Verificando o número de faixas
        assertEquals(18, cores.size());
    }
}