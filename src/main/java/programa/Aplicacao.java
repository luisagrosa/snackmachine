package programa;
import br.com.tt.snackmachine.model.CategoriaProduto;
import br.com.tt.snackmachine.model.Estoque;
import br.com.tt.snackmachine.model.Produto;

import java.util.*;

public class Aplicacao {

    private static List<Produto> produtosDisponiveis = new ArrayList<>();
    private static List<Estoque> estoqueDeProdutos;

    public static void main (String[] args){


        criarProdutosIniciais();
        criarEstoqueInicial();
        mostrarProdutosParaUsuario();
        pedeNumeroItem();
        //solicitaPagamento();
        //dispensaProduto();

    }

    private static void mostrarProdutosParaUsuario(){
        System.out.println("\n--M-E-N-U---- Hoje temos os seguintes produtos para voce experimentar: ----M-E-N-U--");
        int iterator = 1;
            for (Produto p : produtosDisponiveis) {
                System.out.printf("\nHoje temos %s, da categoria %s por R$%f. Se deseja esse, digite numero %d",
                        p.getDescricao(), p.getCategoria(), p.getPreco(), p.getId());
                iterator += 1;
            }
            System.out.println("\n--------------M-E-N-U--------------------------M-E-N-U------------------");

    }




    private static int pedeNumeroItem() {
        System.out.println("\nDigite o numero do item que deseja. Se deseja ver o MENU novamente, digite 0\n");
        try {
            int sc = new Scanner(System.in).nextInt();
            if(sc == 0) {
                mostrarProdutosParaUsuario();
                //PORQUE DIABBOS ELE PARA DE RODAR TODO
            }
            while (sc < 0 || sc > produtosDisponiveis.size()) {
                System.out.printf("Numero Invalido. Numeros negativos nao existem na nossa maquina " +
                        "e numeros maiores do que %d nao temos", produtosDisponiveis.size());
                System.out.println("\nDigite o numero do item que deseja. Se deseja ver o MENU novamente, digite 0\n");
                sc = new Scanner(System.in).nextInt();
            }
            return sc;
        }
        catch(InputMismatchException e) {
            System.out.println("Precisa digitar um numero! Digite novamente");
            //continue. Como voltar pro inicio do try?? Nao quero dar aquele return no fim?? TODO
            pedeNumeroItem();
        }
            return 1;
        }





    private static void criarProdutosIniciais(){
        Produto produto1 = new Produto((short)1, 3F, "Doritos", CategoriaProduto.SALGADO);
        Produto produto2 = new Produto((short)2, 5F, "Coca", CategoriaProduto.BEBIDA);
        Produto produto3 = new Produto((short)3, 4F, "Trakinas", CategoriaProduto.DOCE);
        Produto produto4 = new Produto((short)4, 1F, "Amendoim", CategoriaProduto.SALGADO);
        Produto produto5 = new Produto((short)5, 8F, "Suquinho", CategoriaProduto.BEBIDA);
        Produto produto6 = new Produto((short)6, 3F, "Chocolate", CategoriaProduto.DOCE);

        produtosDisponiveis.add(produto1);
        produtosDisponiveis.add(produto2);
        produtosDisponiveis.add(produto3);
        produtosDisponiveis.add(produto4);
        produtosDisponiveis.add(produto5);
        produtosDisponiveis.add(produto6);
    }


    private static void criarEstoqueInicial(){
       Estoque estoquep1 = new Estoque(produtosDisponiveis.get(0), 10);
        Estoque estoquep2 = new Estoque(produtosDisponiveis.get(1), 10);
        Estoque estoquep3 = new Estoque(produtosDisponiveis.get(2), 10);
        Estoque estoquep4 = new Estoque(produtosDisponiveis.get(3), 10);
        Estoque estoquep5 = new Estoque(produtosDisponiveis.get(4), 10);
        Estoque estoquep6 = new Estoque(produtosDisponiveis.get(5), 10);

        estoqueDeProdutos = new ArrayList<>();
        estoqueDeProdutos.add(estoquep1);
        estoqueDeProdutos.add(estoquep2);
        estoqueDeProdutos.add(estoquep3);
        estoqueDeProdutos.add(estoquep4);
        estoqueDeProdutos.add(estoquep5);
        estoqueDeProdutos.add(estoquep6);

    }

}
