package agenda;

public class Vetor {
    private Agenda[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new Agenda[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(Agenda elemento) throws Exception {
        aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Vetor cheio");
        }
    }

    public Agenda busca(int indice) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].getIndice() == indice) {
                return elementos[i];
            }
        }
        return null;
    }

    public void remove(int indice) throws Exception {
        int posicao = -1;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].getIndice() == indice) {
                posicao = i;
                break;
            }
        }

        if (posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }
            this.tamanho--;
        } else {
            throw new Exception("Índice inválido");
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }
        s.append("]");
        return s.toString();
    }

    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Agenda[] elementosNovos = new Agenda[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }
}