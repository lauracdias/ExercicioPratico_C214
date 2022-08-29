import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaHorario
{
    HorarioProfService horarioProfService;

    public BuscaHorario(HorarioProfService horarioService)
    {
        this.horarioProfService = horarioService;
    }

    public Professor busca(int matricula)
    {
        String horarioJson = horarioProfService.buscaHorario(matricula);
        JsonObject jsonObject = JsonParser.parseString(horarioJson).getAsJsonObject();

        return new Professor(jsonObject.get("nomeDoProfessor").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsString(),
                jsonObject.get("periodo").getAsString());
    }

    public boolean enviaHorario(String nome, String horario, String periodo)
    {
        Professor prof = new Professor(nome, horario, periodo);
        if(horarioProfService.enviaHorario(prof))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
