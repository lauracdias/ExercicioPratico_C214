public class Professor
{
    private String nome;
    private String horario;
    private String periodo;

    public Professor(String nome, String horario, String periodo)
    {
        this.nome = nome;
        this.horario = horario;
        this.periodo = periodo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
