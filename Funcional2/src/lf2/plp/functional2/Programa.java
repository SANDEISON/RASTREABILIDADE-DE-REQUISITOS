package lf2.plp.functional2;

import lf2.plp.expressions2.expression.Expressao;
import lf2.plp.expressions2.expression.Valor;
import lf2.plp.expressions2.memory.AmbienteCompilacao;
import lf2.plp.expressions2.memory.AmbienteExecucao;
import lf2.plp.expressions2.memory.ContextoCompilacao;
import lf2.plp.expressions2.memory.ContextoExecucao;
import lf2.plp.expressions2.memory.VariavelJaDeclaradaException;
import lf2.plp.expressions2.memory.VariavelNaoDeclaradaException;

public class Programa {

	private Expressao exp;
	private String retornoRequisito;

	public Programa(Expressao exp) {
		this.exp = exp;
	}

	public Valor executar() throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {
		AmbienteExecucao ambExec = new ContextoExecucao();
		Valor retorno = exp.avaliar(ambExec);
		retornoRequisito = ((ContextoExecucao) ambExec).rastrearRequisitos();
		return retorno;
	}

	public boolean checaTipo() throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {
		AmbienteCompilacao ambComp = new ContextoCompilacao();
		return exp.checaTipo(ambComp);
	}

	public Expressao getExpressao() {
		return exp;
	}
	
	public String getRetornoRequisito() {
		return retornoRequisito;
	}

}
