import java.util.ArrayList;

public class Game implements Runnable {

	private boolean isRunning;
	private Thread thread;
	
	private ArrayList<Entidade> entidades = new ArrayList<>();
	
	public Game() {
		entidades.add(new Entidade());
		entidades.add(new Entidade());
		entidades.add(new Entidade());
		entidades.add(new Entidade());
		
		for(int i = 0; i < entidades.size(); i++) {
			System.out.println("Olá!!!!");
		}
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.start();
	}
	
	//Método para sincronizar o game start
	public synchronized void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	//Método para atualizar a lógica do game
	public void tick() {
		//System.out.println("Tick!");
	}
	
	//método para renderizar a imagem do game
	public void render() {
		//System.out.println("Render!");

	}
	
	
	@Override
	public void run() {
		while (isRunning) {
			tick();
			render();
				
		}
		
	}

	
	
	
}
