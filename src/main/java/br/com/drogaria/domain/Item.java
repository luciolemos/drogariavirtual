/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author lucio
 */
@Entity
@Table(name = "tbl_itens")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="it_codigo")
    private Long id;   
        
    @Column (name="it_quantidade")
    private Integer qtde;
    
    @Column (name="it_valor_parcial",precision = 7,scale = 2,nullable = false)
    private BigDecimal valor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="tbl_vendas_ven_codigo",referencedColumnName = "ven_codigo")
    private Vendas venda;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="tbl_produtos_pro_codigo",referencedColumnName = "pro_codigo")
    private Produto produto;

    public Item() {
    }

    public Item(Long id, Integer qtde, BigDecimal valor, Vendas venda, Produto produto) {
        this.id = id;
        this.qtde = qtde;
        this.valor = valor;
        this.venda = venda;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Vendas getVenda() {
        return venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", qtde=" + qtde + ", valor=" + valor + ", venda=" + venda + ", produto=" + produto + '}';
    }
    
    
    

}