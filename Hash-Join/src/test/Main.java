package test;

import join.HashJoin;
import relation.IncompatibleNumberOfElementsException;
import relation.Relation;
import relation.TemporaryRelation;

public class Main {

	public static void main(String[] args) {
		TemporaryRelation cachorros = new TemporaryRelation("Cães", "ID_Cachorro", "Raça", "Idade_Cachorro", "Cor");
		try {
			cachorros.addTuple(1, "Doberman", 20, "preto");
			cachorros.addTuple(2, "Rotweiller", 5, "preto");
			cachorros.addTuple(3, "Yorkshire", 3, "cinza");
			cachorros.addTuple(4, "Vira-lata", 20, "indefinido");
		} catch (IncompatibleNumberOfElementsException e) {
			e.printStackTrace();
		}
		
		TemporaryRelation donos = new TemporaryRelation("Pessoas", "ID_Dono", "Nome", "Idade_Dono", "ID_Cachorro");
		try {
			donos.addTuple(1, "Bob", 21, 1);
			donos.addTuple(1, "Bob", 21, 2);
			donos.addTuple(2, "Lily", 19, 3);
			donos.addTuple(3, "Zé", 37, 4);
		} catch (IncompatibleNumberOfElementsException e) {
			e.printStackTrace();
		}
		
		HashJoin join = new HashJoin(donos, cachorros, "ID_Cachorro");
		Relation resultado = join.execute();
		
		System.out.println(cachorros);
		System.out.println(donos);
		System.out.println(resultado);
	}

}
