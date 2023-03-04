package view;

import controller.ThreadSapo;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println(" == A corrida começou! == ");
		
		for (int i = 0; i < 5; i++) {
			Thread threadSapo = new ThreadSapo();
			threadSapo.start();
		}

	}

}
