package br.com.will.esqueciminhasenha.controller;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.will.esqueciminhasenha.database.CartaoDatabase;
import br.com.will.esqueciminhasenha.database.dao.RoomCartaoDAO;
import br.com.will.esqueciminhasenha.model.Cartao;

public class CartaoController {

    final RoomCartaoDAO roomCartaoDAO;

    public CartaoController(Context context) {
        roomCartaoDAO = CartaoDatabase.getInstance(context).getRoomCartaoDAO();
    }

    public void cadastrar(Cartao cartao) {
        roomCartaoDAO.salvar(cartao);
    }

    public List<Cartao> getListaDeCartoesSalvos() {
        return roomCartaoDAO.todos();
    }

    public void editar(Cartao cartao) {
        roomCartaoDAO.editar(cartao);
    }

    public void excluir(Cartao cartao) {
        roomCartaoDAO.deletar(cartao);
    }

    public Cartao ultimoRegistro() {
        return roomCartaoDAO.ultimoRegistro();
    }

    public List<Cartao> pesquisar(String descricao, List<Cartao> list){
        List<Cartao> resultado = new ArrayList<>();
        if(descricao.equals("")){
            resultado = list;
        }
        else{
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getDescricao().contains(descricao)){
                    resultado.add(list.get(i));
                }
            }
        }
        return resultado;
    }
}
