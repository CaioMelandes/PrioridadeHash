package source;

import java.util.ArrayList;

public class HashTable {

    private ArrayList<RefereceEntry> tabela;

    public HashTable() {
        this.tabela = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            tabela.add(new RefereceEntry());
        }
    }

    public void insert(String v, int p){
        Entry novoNodo = new Entry(v, p);
        int pos = novoNodo.getKey() % 10;
        RefereceEntry bucket = tabela.get(pos);

        if (bucket.isEmpty()){
            bucket.setInicio(novoNodo);
            bucket.setFim(novoNodo);
        } else {
            bucket.getFim().next = novoNodo;
            novoNodo.prev = bucket.getFim();
            bucket.setFim(novoNodo);

            organize(pos);
        }

        System.out.println("Nome: "+ novoNodo.getValue());
        System.out.println("Chave: "+ novoNodo.getKey());
        System.out.println("Prioridade: "+ novoNodo.getPriority());
        System.out.println("Posição na tabela: "+ pos);
        System.out.println();
    }

    public void organize(int pos){
        RefereceEntry bucket = tabela.get(pos);
        Entry inicio = bucket.getInicio();
        Entry novoNodo = bucket.getFim();

        if (novoNodo.getPriority() == 0 && novoNodo.prev.getPriority() == 1){
            if (inicio.getPriority() == 1){
                novoNodo.next = inicio;
                bucket.setFim(novoNodo.prev);
                bucket.setInicio(novoNodo);
                novoNodo.prev = null;
            } else {
                Entry aux = inicio;
                while (aux.next.getPriority() != 1){
                    aux = aux.next;
                }

                bucket.setFim(novoNodo.prev);
                bucket.getFim().next = null;
                novoNodo.next = aux.next;
                aux.next.prev = novoNodo;
                novoNodo.prev = aux;
                aux.next = novoNodo;
            }
        }
    }

    public void lista(){
        for (int i = 0; i < tabela.size(); i++) {
            RefereceEntry referencia = tabela.get(i);

            if (referencia.isEmpty()){
                System.out.println("Bucket "+i+": Vazio");
            } else {
                System.out.print("Bucket "+i+": ");

                Entry aux = referencia.getInicio();

                while (aux != referencia.getFim()){
                    System.out.print("("
                            +aux.getValue()+", "
                            +aux.getKey()+", "
                            +aux.getPriority()+") ");
                    aux = aux.next;
                }

                System.out.println("("
                        +aux.getValue()+", "
                        +aux.getKey()+", "
                        +aux.getPriority()+") ");
            }
        }
    }
}
