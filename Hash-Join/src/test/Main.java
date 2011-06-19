package test;

import join.HashJoin;
import relation.Relation;
import relation.TemporaryRelation;
import relation.Tuple;

public class Main {

	public static void main(String[] args) {
		TemporaryRelation cachorros = new TemporaryRelation("ID_Cachorro", "Raça", "Idade_Cachorro", "Cor");
		try {
			cachorros.addTuple(new Tuple(cachorros, 1, "Doberman", 20, "preto"));
			cachorros.addTuple(new Tuple(cachorros, 2, "Rotweiller", 5, "preto"));
			cachorros.addTuple(new Tuple(cachorros, 3, "Yorkshire", 3, "cinza"));
			cachorros.addTuple(new Tuple(cachorros, 4, "Vira-lata", 20, "indefinido"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TemporaryRelation donos = new TemporaryRelation("ID_Dono", "Nome", "Idade_Dono", "ID_Cachorro");
		try {
			donos.addTuple(new Tuple(donos, 1, "Bob", 21, 1));
			donos.addTuple(new Tuple(donos, 1, "Bob", 21, 2));
			donos.addTuple(new Tuple(donos, 2, "Lily", 19, 3));
			donos.addTuple(new Tuple(donos, 3, "Zé", 37, 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HashJoin join = new HashJoin(donos, cachorros, "ID_Cachorro");
		Relation resultado = join.execute();
		
		System.out.println(cachorros);
		System.out.println(donos);
		System.out.println(resultado);
	}

}
