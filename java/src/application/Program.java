package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import application.entites.Cliente;
import application.entites.Pedido;
import application.entites.Produto;
import application.entites.itemDoPedido;
import application.entites.enums.StatusDoPedido;

public class Program {
    public static void main(String[] args) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("entre com os dados do cliente: ");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("email: ");
        String email = sc.nextLine();
        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Date dataNascimento = sdf.parse(sc.next());

        Cliente cliente = new Cliente(nome, email, dataNascimento);

        System.out.println("Entre com os dados do pedido: ");
        System.out.print("Status: ");
        StatusDoPedido status = StatusDoPedido.valueOf(sc.next());

        Pedido pedido = new Pedido(new Date(), status, cliente);

        System.out.print("quantos itens o pedido vai ter? ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Entre com os dados do item #" + (i +1) + ": ");
            System.out.print("Nome do Produto: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();
            System.out.print("Preco do produto: ");
            double precoProduto = sc.nextDouble();
            System.out.print("quantidade: ");
            int quantidade = sc.nextInt();

            Produto produto = new Produto(nomeProduto, precoProduto);

            itemDoPedido it = new itemDoPedido(quantidade, precoProduto, produto);

            pedido.addItem(it);
        }

        System.out.println();
        System.out.println(pedido);
        sc.close();
    }
}
