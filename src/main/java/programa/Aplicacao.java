package programa;
import br.com.tt.snackmachine.model.CategoriaProduto;
import br.com.tt.snackmachine.model.Estoque;
import br.com.tt.snackmachine.model.Produto;

import java.util.*;

public class Aplicacao {

    private static Set<Produto> produtosDisponiveis = new TreeSet<>();
    private static List<Estoque> estoqueDeProdutos;
    private static int produtoDesejadofinal;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {


        criarProdutosEEstoqueInicial();
        mostrarProdutosParaUsuario();
        pedeNumeroItem();
        //solicitaPagamento(pedeNumeroItem());
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


    private static int pedeNumeroItem() {
        int produtoDesejado = retornarIntDeIDDeProdutoDisponivel();

        System.out.println("o produtoDesejado ficou com valor de:" + produtoDesejado);
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

        //eu queria poder voltar pro inicio do try caso desse essa exceção... como faz isso?? Instintivamente eu chamaria de novo
        //esse propprio metodo, mas nao pode ne ? porque fica "recursivo". Tem um jeito de voltar pro try ou pro inicio desse metodo
        // depois de informar o usuario no catch que ele tem que digitar um numero e nao uma letra ??? TODO

        catch (InputMismatchException e) {
            System.out.println("Você não digitou um numero. Você precisa digitar um NÚMERO de algum produto disponível.");
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

