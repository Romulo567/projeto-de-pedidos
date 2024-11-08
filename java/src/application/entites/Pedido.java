package application.entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.entites.enums.StatusDoPedido;

public class Pedido {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momento;
    private StatusDoPedido status;

    private Cliente cliente;
    private List<itemDoPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Date momento, StatusDoPedido status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void addItem(itemDoPedido item){
        itens.add(item);
    }

    public void removeItem(itemDoPedido item){
        itens.remove(item);
    }

    public double total(){
        double soma = 0;
        for (itemDoPedido it : itens) {
            soma += it.subTotal();
        }
        return soma;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ");
        sb.append(sdf.format(momento) + "\n");
        sb.append("status do pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("item do pedido: \n");
        for (itemDoPedido item : itens) {
            sb.append(item + "\n");
        }
        sb.append("Preco total: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
