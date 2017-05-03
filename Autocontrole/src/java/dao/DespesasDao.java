package dao;

import java.util.List;

import modelo.Despesas;

public interface DespesasDao {
	
	public void salvar(Despesas despesas);
	public void atualizar(Despesas despesas);
	public void remover(Despesas despesas);
	public List<Despesas> getListAll();
	public Despesas findById(int id);

}
