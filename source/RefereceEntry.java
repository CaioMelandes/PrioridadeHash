package source;

public class RefereceEntry {
    private Entry inicio = null;
    private Entry fim = null;

    public boolean isEmpty(){
        if (inicio == null && fim == null){
            return true;
        }

        return false;
    }

    public Entry getInicio() {
        return inicio;
    }

    public void setInicio(Entry inicio) {
        this.inicio = inicio;
    }

    public Entry getFim() {
        return fim;
    }

    public void setFim(Entry fim) {
        this.fim = fim;
    }
}
