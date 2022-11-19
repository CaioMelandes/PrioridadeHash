package source;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        HashTable teste = new HashTable();
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] caracteres = a.toCharArray();
        Random random = new Random();

        for (int i = 0; i < caracteres.length; i++) {
            int n = random.nextInt(2);
            teste.insert(String.valueOf(caracteres[i]), n);
        }
        /*teste.insert("F", 1);
        teste.insert("P", 1);
        teste.insert("Z", 0);
        teste.insert("d", 0);
        teste.insert("n", 1);
        teste.insert("x", 0);*/
        teste.lista();


    }

}
