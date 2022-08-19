package model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import model.builder.PedidoVendaBuilder;

public class PedidoVendaTest {
	
	// Exemplo sem Builder.
	@Test
	public void deveCalcularValorTotalPedidoParaClienteVip() {
		PedidoVenda pedidoVenda = new PedidoVenda();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Jo�o");
		cliente.setVip(true);
		pedidoVenda.setCliente(cliente);
		
		ItemPedido item1 = new ItemPedido();
		item1.setNome("Calculadora");
		item1.setValorUnitario(new BigDecimal("200"));
		item1.setQuantidade(2);
		
		ItemPedido item2 = new ItemPedido();
		item2.setNome("Mochila");
		item2.setValorUnitario(new BigDecimal("200"));
		item2.setQuantidade(1);
		
		List<ItemPedido> itensPedido = Arrays.asList(item1, item2);
		pedidoVenda.setItensPedido(itensPedido);
		
		BigDecimal valorTotal = pedidoVenda.getValorTotal();
		
		assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue(), 0.0001);
	}
	
	// Exemplo com Builder.
	@Test
	public void deveCalcularValorTotalPedidoParaClienteVipComBuilder() {
		PedidoVenda pedidoVenda = new PedidoVendaBuilder()
										.comClienteVip("Jo�o Silva")
										.comItem("Calculadora", 2, "200")
										.comItem("Mochila", 1, "200")
										.comNumero("01234")
										.construir();
		
		BigDecimal valorTotal = pedidoVenda.getValorTotal();
		
		assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue(), 0.0001);
	}

}
