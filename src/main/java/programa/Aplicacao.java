package programa;
import br.com.tt.snackmachine.model.CategoriaProduto;
import br.com.tt.snackmachine.model.Estoque;
import br.com.tt.snackmachine.model.Produto;

import java.util.*;

public class Aplicacao {

    private static Set<Produto> produtosDisponiveis = new TreeSet<>();
    private static List<Estoque> estoqueDeProdutos;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static Produto produtoDesejado;


    public static void main(String[] args) {


        criarProdutosEEstoqueInicial();
        mostrarProdutosParaUsuario();
        //pedeNumeroItem();
        solicitarPagamento(pedeNumeroItem());
        //dispensaProduto();



        //retornarIntDeIDDeProdutoDisponivel___2();
    }

    private static void mostrarProdutosParaUsuario() {
        System.out.println("\n--M-E-N-U---- Hoje temos os seguintes produtos para voce experimentar: ----M-E-N-U--");
        for (Estoque e : estoqueDeProdutos) {
            if (e.getQuantidade() > 0) {
                produtosDisponiveis.add(e.getProduto());
            }
        }
        for (Produto p : produtosDisponiveis) {  // por que que esta permitindo duplicacao TODO
            System.out.println(p.getDescricaoCompleta());
        }
    }


    private static Produto pedeNumeroItem() {
        int idDoProdutoDesejado = retornarIntDeIDDeProdutoDisponivel();
        for(Produto p :produtosDisponiveis){
            if(p.getId() == idDoProdutoDesejado){
                produtoDesejado = p;
            }
        }
        return produtoDesejado;
    }

    private static Produto solicitarPagamento(Produto produtoDesejado){
        System.out.printf("Preço do produto desejado: R$%.2f",
                        produtoDesejado.getPreco());
        System.out.println("\n Digite os 16 dígitos do cartão: ");
        String numeroDoCartao = validarNumerodoCartao();
        return produtoDesejado;
    }


    private static void criarProdutosEEstoqueInicial() {

        Produto doritos = new Produto((short) 1, 3F, "Doritos", CategoriaProduto.SALGADO);
        Produto cocaCola = new Produto((short) 2, 5F, "Coca", CategoriaProduto.BEBIDA);
        Produto trakinas = new Produto((short) 3, 4F, "Trakinas", CategoriaProduto.DOCE);
        Produto amendoim = new Produto((short) 4, 1F, "Amendoim", CategoriaProduto.SALGADO);
        Produto suco = new Produto((short) 5, 8F, "Suquinho", CategoriaProduto.BEBIDA);
        Produto chocolate = new Produto((short) 6, 3F, "Chocolate", CategoriaProduto.DOCE);

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

    private static String validarNumerodoCartao(){
       //try {
        Scanner scanner = new Scanner(System.in);
           String numeroDoCartaoValidado = scanner.nextLine();

           while(numeroDoCartaoValidado.length() != 16 || !numeroDoCartaoValidado.matches("[0-9]+"))
           {

               if (!numeroDoCartaoValidado.matches("[0-9]+")) {
                   System.out.printf("Você digitou %d dígitos e também digitou outros caractéres não-numericos. Precisa digitar os 16.",  numeroDoCartaoValidado.length());
                   numeroDoCartaoValidado = scanner.nextLine();
               }

               System.out.printf("Você digitou %d dígitos. Precisa digitar exatamente 16.", numeroDoCartaoValidado.length());
               numeroDoCartaoValidado = scanner.nextLine();

           }

           return numeroDoCartaoValidado;

        //}

        /* catch(InputMismatchException e) {
           System.out.println("Você só pode digitar números. Digite os 16 números do seu cartão");
           return validarNumerodoCartao();
       }
         */
       }


    private static int retornarIntDeIDDeProdutoDisponivel() {
        System.out.println("\nDigite o numero do item que deseja. Se deseja ver o MENU novamente, digite 0\n");

        List<Integer> idsDisponiveis = new ArrayList<>();
        for (Produto p : produtosDisponiveis) {
            idsDisponiveis.add(p.getId().intValue());
        }

        try {
           String stringSc = SCANNER.nextLine();
            int sc = Integer.valueOf(stringSc);
            if (sc < 0) {
                System.out.println("Você digitou um número negativo. Você precisa digitar um número de algum produto disponível");
                return retornarIntDeIDDeProdutoDisponivel();
            }
            if (sc == 0) {
                mostrarProdutosParaUsuario();
                return retornarIntDeIDDeProdutoDisponivel();
            }

            if (!idsDisponiveis.contains(Integer.valueOf(sc))) {
                System.out.printf("\nVocê digitou %d um id inexistente. Você precisa " +
                        "digitar um número de algum produto disponível. São eles:", sc);
                for (Integer i : idsDisponiveis) {
                    System.out.print(i + ",");
                }
                return retornarIntDeIDDeProdutoDisponivel(); // parece que todas as vezes que a gente chama esse método de novo,
                // ele "espera um resultado", entao por isso ele printa e retorna todos numeros que eu botei no console
            }

            return sc;
        }

        catch (NumberFormatException e) {
            System.out.println("Você não digitou um numero." +
                    " Você precisa digitar um NÚMERO de algum produto disponível.");
            return retornarIntDeIDDeProdutoDisponivel();
        }


    }



    private static int retornarIntDeIDDeProdutoDisponivel___2() {
        List<Integer> idsDisponiveis = new ArrayList<>();
        for (Produto p : produtosDisponiveis) {
            idsDisponiveis.add(p.getId().intValue());
        }

        Integer sc2 = new Scanner(System.in).nextInt();

        while(!idsDisponiveis.contains(sc2)) {
            System.out.println("\nDigite o numero do item que deseja. Se deseja ver o MENU novamente, digite 0\n");
            sc2 = new Scanner(System.in).nextInt();

        }
        return sc2;
    }

}

