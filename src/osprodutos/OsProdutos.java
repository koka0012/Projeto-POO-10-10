/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osprodutos;

import osprodutos.Classes.Produto;
import java.util.*;

/**
 *
 * @author ads
 */
public class OsProdutos {

    static GenericMenu genericMenu = new GenericMenu();
    static List<Produto> ListaDeProdutos = new ArrayList<Produto>();
    static Scanner scanner = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        configureMenu();
        
        genericMenu.initMenu();
    }
    
    public static void configureMenu() {
        genericMenu.addMenuItem("1", "Cadastrar produto", new Runnable() {
            @Override
            public void run() {
                AddProduto();
            }
        });
        
        genericMenu.addMenuItem("2", "Vizualizar o produto", new Runnable() {
            @Override
            public void run() {
                VizualizarProduto();
            }
        });
        
        genericMenu.addMenuItem("3", "Editar Produto", new Runnable() {
            @Override
            public void run() {
                EditarProduto();
            }
        });
        
        genericMenu.addMenuItem("4", "Remover Produto", new Runnable() {
            @Override
            public void run() {
                DeletarProduto();
            }
        });
        
        genericMenu.addMenuItem("5", "Listar Produtos", new Runnable() {
            @Override
            public void run() {
                ListaProdutos();
            }
        });
    }
    
    static private void AddProduto() {
        System.out.println("Digite a descrição do produto: ");
        String descricao = scanner.next();
        System.out.println("Digite o valor do produto: (Use , para separar)");
        float valor = scanner.nextFloat(); 
        int id = ListaDeProdutos.size();
        
        Produto novoProduto = new Produto(id, descricao, valor);
        ListaDeProdutos.add(novoProduto);
        
        System.out.printf("O produto foi adicionado com o id %d", id);
    }
    
    static private void VizualizarProduto() {
        System.out.println("Digite o ID do produto: ");
        int id = scanner.nextInt();
        
        Produto produto = ListaDeProdutos.get(id);
        if(produto == null) {
            System.out.println("Produto não encontrado!");
        }
        
        System.out.printf("Produto: %s\nValor: R$ %s\nID: %s", produto.descricao, produto.valor, produto.ID);
    }
    
    static private void DeletarProduto() {
        System.out.println("Digite o ID que deseja deletar: ");
        int id = scanner.nextInt();
        
        ListaDeProdutos.remove(id);
        System.out.printf("Item com o ID %s excluido.", id);
    }
    
    static private void EditarProduto() {
        System.out.println("Digite o ID que deseja editar: ");
        int id = scanner.nextInt();
        
        Produto produto = ListaDeProdutos.get(id);
        if(produto == null) {
            System.out.println("Produto não encontrado!");
        }
        
        System.out.printf("Qual é a nova descrição?\nA atual é: %s\n", produto.descricao);
        String descricao = scanner.next();
        
        System.out.printf("Qual é o novo valor? (Use , para separar)\nO atual é: %s\n", produto.valor);
        float valor = scanner.nextFloat();
        
        Produto novoProduto = new Produto(id, descricao, valor);
        
        ListaDeProdutos.set(id, novoProduto);
        System.out.println("Produto salvo com sucesso!");
    }
    
    static private void ListaProdutos() {
        ListaDeProdutos.forEach((produto) -> {
            System.out.printf("\nDescrição: %s", produto.descricao);
            System.out.printf("\nValor: %s", produto.valor);
            System.out.printf("\nID: %s\n", produto.ID);
        });
    }
    
}
