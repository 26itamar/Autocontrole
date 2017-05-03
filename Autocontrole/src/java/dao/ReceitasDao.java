package dao;

import java.util.List;

import modelo.Receitas;

public interface ReceitasDao {
	
	public void salvar(Receitas receitas);
	public void atualizar(Receitas receitas);
	public void remover(Receitas receitas);
	public List<Receitas> getListAll();
	public Receitas findById(int id);

}
