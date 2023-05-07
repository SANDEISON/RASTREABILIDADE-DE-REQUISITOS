package lf2.plp.expressions2.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

import lf2.plp.expressions2.expression.Id;
import lf2.plp.expressions2.expression.Valor;
import lf2.plp.functional1.memory.ContextoExecucaoFuncional;

public class ContextoExecucao extends Contexto<Valor> implements AmbienteExecucao {

	private Map<Id, List<Id>> requisitos;
	private List<Id> funcoesUtilizadas;

	public ContextoExecucao() {
		requisitos = new HashMap<>();
		funcoesUtilizadas = new ArrayList<>();
	}

	public void addRequisito(Id idFun, List<Id> reqs) {

		List<Id> aux;
		for (Id id : reqs) {
			aux = requisitos.get(id);
			if (aux != null)
				aux.add(idFun);
			else {
				aux = new ArrayList<>();
				aux.add(idFun);
				requisitos.put(id, aux);
			}
		}

		System.out.println(pilha);
		System.out.println(requisitos);

	}

	public String rastrearRequisitos() {

		String retorno = "";

		for (Id id : requisitos.keySet()) {
			retorno += "as funções " + requisitos.get(id) + " pertencem ao requisito " + id + "\n";
		}

		return retorno;
	}

	public ContextoExecucao clone() {
		ContextoExecucaoFuncional retorno = new ContextoExecucaoFuncional();

		Stack<HashMap<Id, Valor>> novaPilha = new Stack<HashMap<Id, Valor>>();

		HashMap<Id, Valor> novoMap = new HashMap<Id, Valor>();
		novaPilha.add(novoMap);

		for (HashMap<Id, Valor> map : this.pilha) {
			for (Entry<Id, Valor> entry : map.entrySet()) {
				novoMap.put(entry.getKey(), entry.getValue());
			}
		}

		retorno.setPilha(novaPilha);

		return retorno;
	}
}
