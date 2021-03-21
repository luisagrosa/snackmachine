package programa;
import br.com.tt.snackmachine.model.CategoriaProduto;
import br.com.tt.snackmachine.model.Estoque;
import br.com.tt.snackmachine.model.Produto;

import java.util.*;

public class Aplicacao {

    private static Set<Produto> produtosDisponiveis = new TreeSet<>();
    private static List<Estoque> estoqueDeProdutos;

    public static void main (String[] args){


        criarProdutosEEstoqueInicial();
        mostrarProdutosParaUsuario();
        pedeNumeroItem();
        //solicitaPagamento();
        //dispensaProduto();

    }

    private static void mostrarProdutosParaUsuario(){
        System.out.println("\n--M-E-N-U---- Hoje temos os seguintes produtos para voce experimentar: ----M-E-N-U--");
        for (Estoque e : estoqueDeProdutos)   {
            if(e.getQuantidade() > 0) {
                produtosDisponiveis.add(e.getProduto());
            }
        }
        for (Produto p : produtosDisponiveis) {  // porque que esta permitindo duplicacao TODO
            System.out.println(p.getDescricaoCompleta());
        }
    }


    private static int pedeNumeroItem() {
        System.out.println("\nDigite o numero do item que deseja. Se deseja ver o MENU novamente, digite 0\n");
        int produtoDesejado = retornarIntDeIDDeProdutoDisponivel();
        //System.out.println(produtoDesejado);
        return produtoDesejado;

        }
    /*
    private static int pedeNumeroItem() {
        System.out.println("\nDigite o numero do item que deseja. Se deseja ver o MENU novamente, digite 0\n");
        try {
            int sc = new Scanner(System.in).nextInt();
            if(sc == 0) {
                mostrarProdutosParaUsuario(); //PORQUE DIABBOS ELE PARA DE RODAR O PROGRAMA TODO
            }

            while (sc < 0 || sc != produtosDisponiveis.size()) {
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

*/



    private static void criarProdutosEEstoqueInicial(){


        Produto doritos = new Produto((short)1, 3F, "Doritos", CategoriaProduto.SALGADO);
        Produto cocaCola = new Produto((short)2, 5F, "Coca", CategoriaProduto.BEBIDA);
        Produto trakinas = new Produto((short)3, 4F, "Trakinas", CategoriaProduto.DOCE);
        Produto amendoim = new Produto((short)4, 1F, "Amendoim", CategoriaProduto.SALGADO);
        Produto suco = new Produto((short)5, 8F, "Suquinho", CategoriaProduto.BEBIDA);
        Produto chocolate = new Produto((short)6, 3F, "Chocolate", CategoriaProduto.DOCE);

        Estoque estoquep1 = new Estoque(doritos, 10);
        Estoque estoquep2 = new Estoque(cocaCola, 10);
        Estoque estoquep3 = new Estoque(trakinas, 10);
        Estoque estoquep4 = new Estoque(amendoim, 10);
        Estoque estoquep5 = new Estoque(suco, 10);
        Estoque estoquep6 = new Estoque(chocolate, 10);
        Estoque estoque7 = new Estoque(chocolate, 5);


        estoqueDeProdutos = new ArrayList<>();

        estoqueDeProdutos.add(estoquep1);
        estoqueDeProdutos.add(estoquep2);
        estoqueDeProdutos.add(estoquep3);
        estoqueDeProdutos.add(estoquep4);
        estoqueDeProdutos.add(estoquep5);
        estoqueDeProdutos.add(estoquep6);
        estoqueDeProdutos.add(estoque7);

    }

    private static int retornarIntDeIDDeProdutoDisponivel() {
        List<Integer>  idsDisponiveis = new ArrayList<>();
        for (Produto p : produtosDisponiveis){
            idsDisponiveis.add(p.getId().intValue());
        }


        int sc = 0;
        try {
            sc = new Scanner(System.in).nextInt();
        }
        catch(InputMismatchException e) {
            System.out.println("Você não digitou um numero. Você precisa digitar um NÚMERO de algum produto disponível.");
            pedeNumeroItem();
        }
        if(sc < 0){
            System.out.println("Você digitou um número negativo. Você precisa digitar um número de algum produto disponível");
            pedeNumeroItem();
        }

        if(idsDisponiveis.contains(Integer.valueOf(sc))) {
            return sc; }
        else {
            System.out.println("Você digitou um id inexistente. Você precisa digitar um número de algum produto disponível. São eles:");
            for (Integer i : idsDisponiveis){
                System.out.print(i + ",");
            }
            pedeNumeroItem();
        } // por que as vezes eu ponho um id que existe e mesmo assim ele retorna que nao!

        return sc;
    }

}
