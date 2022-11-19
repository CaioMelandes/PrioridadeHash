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

    public String insert(String v, int p){
        Entry novoNodo = new Entry(v, p);
        int pos = novoNodo.getKey() % 10;
        RefereceEntry bucket = tabela.get(pos);
        String msg;

        if (v.isEmpty()) {
            msg = "Nome deve ser preenchido";
            return msg;
        }else if (p != 0 && p != 1){
            msg = "Prioridade de ser 0 ou 1";
            return msg;
        }else if (bucket.isEmpty()){
            bucket.setInicio(novoNodo);
            bucket.setFim(novoNodo);
        } else {
            bucket.getFim().next = novoNodo;
            novoNodo.prev = bucket.getFim();
            bucket.setFim(novoNodo);

            organize(pos);
        }

        msg = "Nome: "+ novoNodo.getValue();
        msg += "\nChave: "+ novoNodo.getKey();
        msg += "\nPrioridade: "+ novoNodo.getPriority();
        msg += "\nPosição na tabela: "+ pos +"\n";

        return msg;
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

    public String lista(){
        String msg = "";

        for (int i = 0; i < tabela.size(); i++) {
            RefereceEntry referencia = tabela.get(i);

            if (referencia.isEmpty()){
                msg += "Bucket "+i+": Vazio\n";
            } else {
                msg += "Bucket "+i+": ";

                Entry aux = referencia.getInicio();

                while (aux != referencia.getFim()){
                    msg += aux.toString();
                    aux = aux.next;
                }

                msg += aux.toString()+"\n";
            }
        }
        return msg;
    }

    public String remove(String nome){
        Entry nodo = new Entry(nome, 0);
        RefereceEntry bucket = tabela.get(nodo.getKey()%10);

        Entry aux = bucket.getInicio();

        if (nome.isEmpty()){
            return "Nome deve ser preenchido";
        }else if (aux == null){
            return "Lista vazia";
        }

        while (!aux.getValue().equals(nome)){
            if (aux.next == null){
                return "Elemento não encontrado";
            }
            aux = aux.next;
        }

        if (aux == bucket.getInicio()){
            bucket.setInicio(aux.next);
            aux.next.prev = null;
        } else if (aux == bucket.getFim()){
            bucket.setFim(aux.prev);
            aux.prev.next = null;
        } else {
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
        }

        return "Removendo: "+ aux;
    }
}
