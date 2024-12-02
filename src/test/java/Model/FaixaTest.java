package test.java.Model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import main.java.org.fpij.jitakyoei.model.beans.Faixa;
import main.java.org.fpij.jitakyoei.util.CorFaixa;

public class FaixaTest {

    private static Date data = new Date();
    
    @Test
    public void TesteCriarFaixa(){
        CorFaixa cor = CorFaixa.BRANCA;
        Faixa faixa = new Faixa(cor, data);
        
        assertEquals(faixa.getCor(), "Branca");
    }


}
