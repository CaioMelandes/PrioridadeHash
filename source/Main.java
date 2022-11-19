package source;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        HashTable tabela = new HashTable();

        while (true){
            int op, prioridade;
            String aux, nome;

            aux = JOptionPane.showInputDialog("Escolha a opção:\n" +
                    "1 - Inserir elemento\n" +
                    "2 - Remover elemento\n" +
                    "3 - Listar elementos\n" +
                    "0 - Sair");

            op = Integer.parseInt(aux);

            switch (op){
                case 1:
                    try {
                        nome = JOptionPane.showInputDialog("Digite o nome:");
                        prioridade = Integer.parseInt(JOptionPane.showInputDialog("Digite a prioridade(0 ou 1):"));

                        JOptionPane.showMessageDialog(null, tabela.insert(nome, prioridade));
                        break;
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Prioridade deve ser preenchida");
                        break;
                    }

                case 2:
                    nome = JOptionPane.showInputDialog("Digite o nome:");

                    JOptionPane.showMessageDialog(null, tabela.remove(nome));
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, tabela.lista());
                    break;

                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
