package controller;

public class ThreadSapo extends Thread {
	
	private static final int SALTO_MAX = 10;
	private static final int DIST_MAX = 100;
	private static final int TOTAL_SAPOS = 5;
	
	public ThreadSapo() {
		super();
	}
	
	
	// Sapo realiza saltos até chegar na distância máxima
	@Override
	public void run() {
		int distPercorrida = 0;
		int numSapo = (int) getId();
		
		while (distPercorrida < DIST_MAX) {
			try {
				sleep((int) (Math.random() * 1001));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			distPercorrida = darSalto(distPercorrida, numSapo);
		}
	}

	// Dá salto e mostrar no console qual foi o tamanho do salto e quanto o sapo percorreu
	private int darSalto(int distPercorrida, int numSapo) {
		int salto = (int) (Math.random() * (SALTO_MAX + 1));
		distPercorrida = (distPercorrida + salto) < DIST_MAX ? (distPercorrida + salto) : DIST_MAX;
		System.out.println("O sapo #" + numSapo + " deu um salto de " + salto + " metros! (" + distPercorrida + "/" + DIST_MAX + " metros percorridos)" );
		
		if (distPercorrida == DIST_MAX) {
			int posicao = (TOTAL_SAPOS - (activeCount() - 1)) + 1;
			System.out.println("O sapo #" + numSapo + " chegou a linha de chegada em " + posicao + "º lugar! Parabéns!");
			if (posicao == TOTAL_SAPOS
					) {
				System.out.println("== Fim da corrida! ==");
			}
		}
		return distPercorrida;
	}
	
}
