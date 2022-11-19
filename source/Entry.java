package source;

public class Entry {
    private int key;
    private String value;
    private int priority;
    public Entry prev, next;

    public Entry(String v, int p){
        key = calculaKey(v);
        value = v;
        priority = p;
        prev = null;
        next = null;
    }

    private int calculaKey(String v){
        int soma = 0;
        char[] caracteres = v.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            soma += caracteres[i]; //* (i + 1);
        }
        return soma;
    }

    @Override
    public String toString() {
        return "(" +
                value +
                ", " + key +
                ", " + priority +
                ") ";
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Entry getPrev(){
        return prev;
    }

    public void setPrev(Entry prev) {
        this.prev = prev;
    }

    public Entry getNext(){
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}
