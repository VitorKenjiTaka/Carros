package Controller;
import java.util.concurrent.Semaphore;

public class Processos extends Thread{
	private int threadId;
	private Semaphore semaforo;
	
	public Processos(int threadId, Semaphore semaforo) {
		this.threadId = threadId;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		atravessar();
		
	}

	private void atravessar() {
		String direcao = "";
		switch(threadId) {
		case 1:
			direcao = "norte";
			break;
		case 2:
			direcao = "sul";
			break;
		case 3:
			direcao = "leste";
			break;
		case 4:
			direcao = "oeste";
			break;
		}
		
		System.out.println("O carro #"+ threadId + " está indo para o "+ direcao);
		
		try {
			semaforo.acquire();
			
			System.out.println("O carro #"+ threadId + " está atravessando!!");
			sleep(1000);
			System.out.println("O carro #"+ threadId + " atravessou!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	
	
}
