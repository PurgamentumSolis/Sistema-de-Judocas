package test.java.org.fpij.jitakyoei.util;

import main.java.org.fpij.jitakyoei.util.DatabaseManager;
import com.db4o.ext.ExtObjectContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DatabaseManagerTest {

    @Before
    public void setUp() {
        // Configura o ambiente para TEST antes de cada teste
        DatabaseManager.setEnviroment(DatabaseManager.TEST);
    }

    @After
    public void tearDown() {
        // Fecha a conexão e remove o arquivo de teste após cada teste
        DatabaseManager.close();
        File testDb = new File(DatabaseManager.TEST);
        if (testDb.exists()) {
            assertTrue("O arquivo de teste não foi excluído corretamente.", testDb.delete());
        }
    }

    @Test
    public void testConnection() {
        // Testa se a conexão é aberta corretamente
        ExtObjectContainer connection = DatabaseManager.getConnection();
        assertNotNull("A conexão não deve ser nula.", connection);
        assertFalse("A conexão deve estar aberta.", connection.isClosed());
    }

    @Test
    public void testEnvironmentChange() {
        // Testa a alteração para o ambiente de produção
        DatabaseManager.setEnviroment(DatabaseManager.PRODUCTION);
        assertEquals("O ambiente deve ser PRODUCTION.", DatabaseManager.PRODUCTION, DatabaseManager.ENVIROMENT);

        // Testa a alteração de volta para o ambiente de teste
        DatabaseManager.setEnviroment(DatabaseManager.TEST);
        assertEquals("O ambiente deve ser TEST.", DatabaseManager.TEST, DatabaseManager.ENVIROMENT);
    }

    @Test
    public void testCloseConnection() {
        // Testa se a conexão é fechada corretamente
        ExtObjectContainer connection = DatabaseManager.getConnection();
        assertNotNull("A conexão não deve ser nula.", connection);
        assertFalse("A conexão deve estar aberta.", connection.isClosed());

        // Fecha a conexão
        DatabaseManager.close();
        assertTrue("A conexão deve estar fechada.", connection.isClosed());
    }
}
