import org.junit.Test;
import static org.junit.Assert.*;

public class TesteBuscaHorario
{
    //Cenários de sucesso
    @Test
    public void testeBuscaHorarioChris()
    {
        HorarioProfService service = new MockHorarioProfService();
        BuscaHorario buscaHorario = new BuscaHorario(service);

        Professor chris = buscaHorario.busca(1);

        assertEquals("Chris", chris.getNome());
        assertEquals("Terca - 17:30",chris.getHorario());
        assertEquals("noturno", chris.getPeriodo());
    }

    @Test
    public void testeBuscaHorarioGuilherme()
    {
        HorarioProfService service = new MockHorarioProfService();
        BuscaHorario buscaHorario = new BuscaHorario(service);

        Professor guilherme = buscaHorario.busca(2);

        assertEquals("Guilherme", guilherme.getNome());
        assertEquals("Quinta - 10:00",guilherme.getHorario());
        assertEquals("integral", guilherme.getPeriodo());
    }

    @Test
    public void testeEnviaHorario()
    {
        HorarioProfService service = new MockHorarioProfService();
        BuscaHorario buscaHorario = new BuscaHorario(service);

        Professor renzo = new Professor("Renzo", "Quarta - 19:30", "integral");

        assertTrue(buscaHorario.enviaHorario(renzo.getNome(), renzo.getHorario(), renzo.getPeriodo()));
    }

    //Cenários de falha
    @Test
    public void testeBuscaHorarioChrisFalha()
    {
        HorarioProfService service = new MockHorarioProfService();
        BuscaHorario buscaHorario = new BuscaHorario(service);

        Professor chris = buscaHorario.busca(1);

        assertEquals("Chris", chris.getNome());
        assertNotEquals("Sexta - 10:00",chris.getHorario());
        assertNotEquals("integral", chris.getPeriodo());
    }

    @Test
    public void testeBuscaHorarioFalha()
    {
        HorarioProfService service = new MockHorarioProfService();
        BuscaHorario buscaHorario = new BuscaHorario(service);

        Professor joao = buscaHorario.busca(5);

        assertNotEquals("João", joao.getNome());
        assertNotEquals("Segunda - 17:00",joao.getHorario());
        assertNotEquals("integral", joao.getPeriodo());
    }

    @Test
    public void testeEnviaHorarioFalha()
    {
        HorarioProfService service = new MockHorarioProfService();
        BuscaHorario buscaHorario = new BuscaHorario(service);

        Professor renzo = new Professor("Renzo", " ", " ");

        assertFalse(buscaHorario.enviaHorario(renzo.getNome(), renzo.getHorario(), renzo.getPeriodo()));
    }
}
