package View;
import java.util.concurrent.Semaphore;
import Controller.Processos;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		for (int threadId = 1; threadId < 5; threadId ++) {
			Thread thread = new Processos(threadId, semaforo);
			thread.start();
			
		}
	}

}