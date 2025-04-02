package agenda;

public class Agenda {
    private int indice;
    private String descricao;
    private String data;
    private String hora;

    public Agenda(int indice, String descricao, String data, String hora) {
        this.indice = indice;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }

    public int getIndice() {
        return indice;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Agenda [indice=" + indice + ", descricao=" + descricao + ", data=" + data + ", hora=" + hora + "]";
    }
}