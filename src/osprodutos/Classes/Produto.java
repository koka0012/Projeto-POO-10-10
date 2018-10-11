/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osprodutos.Classes;

/**
 *
 * @author ads
 */
public class Produto {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    public int ID;
    public String descricao;
    public float valor;
    
    public Produto(int id, String descricao, float valor) {
        this.ID = id;
        this.descricao = descricao;
        this.valor = valor;
    }
}
