package test;

import join.HashJoin;
import relation.IncompatibleNumberOfElementsException;
import relation.Relation;
import relation.TemporaryRelation;

public class Main {

	public static void main(String[] args) {
		TemporaryRelation cachorros = new TemporaryRelation("Cães", "ID", "Raça", "Idade", "Cor", "ID_Dono");
		try {
			cachorros.addTuple(1, "Doberman", 20, "preto", 1);
			cachorros.addTuple(2, "Rotweiller", 5, "preto", 1);
			cachorros.addTuple(3, "Yorkshire", 3, "cinza", 2);
			cachorros.addTuple(4, "Vira-lata", 20, "indefinido", 3);
		} catch (IncompatibleNumberOfElementsException e) {
			e.printStackTrace();
		}
		
		TemporaryRelation donos = new TemporaryRelation("Pessoas", "ID", "Nome", "Idade");
		try {
			donos.addTuple(1, "Bob", 21);
			donos.addTuple(2, "Lily", 19);
			donos.addTuple(3, "Zé", 37);
		} catch (IncompatibleNumberOfElementsException e) {
			e.printStackTrace();
		}
		
		HashJoin join = new HashJoin("Pessoas-Cães", donos, cachorros, donos.getAttribute("ID"), cachorros.getAttribute("ID_Dono"));
		Relation resultado = join.execute();
		
		System.out.println(cachorros);
		System.out.println(donos);
		System.out.println(resultado);
	}

}
