public class MockHorarioProfService implements HorarioProfService
{
    @Override
    public String buscaHorario(int mat)
    {
        if(mat == 1) {
            return ProfConst.CHRIS;
        }

        if(mat == 2) {
            return ProfConst.GUILHERME;
        }

        else
        {
            return ProfConst.INVALIDO;
        }
    }

    @Override
    public boolean enviaHorario(Professor professor)
    {
        if(professor.getNome() != " " && professor.getHorario() != " " && professor.getPeriodo() != " ") {
            System.out.println("O horario do professor " + professor.getNome() + " foi postado no sistema.");
            return true;
        }
        else
        {
            System.out.println("Dados inválidos.");
            return  false;
        }
    }
}
