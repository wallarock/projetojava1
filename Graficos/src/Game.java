import java.awt.Canvas; //Canvas tem as propriedades para especificar as configurações das janelas com ex. tamanho
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	public static JFrame frame;
	private Thread thread; //Implementado da classe Runnable
	private boolean isRunning = true;
	private final int WIDTH = 160;
	private final int HEIGHT = 120;
	private final int SCALE = 4;
	private BufferedImage image;
	
	public Game() {
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE)); //Define as dimensões e escala de tamanho das janelas
		initFrame();
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		
	}
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
		
	}
	
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join(); //Esse método é uma garantia que o programa encerrará, caso dê um erro.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void initFrame() {
		frame = new JFrame("Devagar nóis chega lá!");
		frame.add(this); //Pega as propriedades do Canvas
		frame.setResizable(false); //Ipmede  usuário de redimensionar a janela
		frame.pack(); //Calcula as dimensões do Canvas para exibir
		frame.setLocationRelativeTo(null); //Faz com que a janela inicialize no centro da tela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ao fechar a janela, o programa é finalizado
		frame.setVisible(true); //Janela visível ao inicializar
	}
	
	public static void main (String[] args) {
		Game game = new Game();
		game.start(); //inicia o jogo
		
	}
	
	public void tick() {
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy(); //O método BufferStrategy é usado para otimizar a renderização através de Buffers
		if (bs == null) {
			this.createBufferStrategy(3); //Geralmente o BufferStrategy é usado valor entre 2 e 3
			return; //Usa-se o return para quebra do método para que no próximo loop, não entrará na condição novamente.
		}
		Graphics g = image.getGraphics(); //Graphics é o método para uso de gráficos.
		g.setColor(new Color(0,0,0)); //Color é o método para uso de cores, definindo através do RGB como parâmetros na sequência
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE); //Renderiza um retângulo usando parâmetros posição xy e dimensões.
		
		//g.setColor(Color.blue); //Renderizando uma figura dentro da janela
		//g.fillRect(x, y, width, height);
		g.setFont(new Font("Arial", Font.BOLD, 10));
		g.setColor(Color.red);
		g.drawString("Devagar nóis chega lá!", 5, 50);
		
		
		g = bs.getDrawGraphics();
		g.drawImage(image,0,0,WIDTH*SCALE,HEIGHT*SCALE,null);
		bs.show(); //Para mostrar os gráficos configurados.
		
	}
	
	@Override
	public void run() {
		long lasttime = System.nanoTime(); //Nanotime pega o tempo atual do sistema em nano segundos para maior precisão
		double amountOFTicks = 60.0; //Criando a taxa de quadros por segundo
		double ns = 1000000000 / amountOFTicks; //Cálculo para determinar o update dos frames para os segundos em nano
		double delta = 0;
		
		int frames = 0;
		double timer = System.currentTimeMillis();
		
		while(isRunning) {
			//System.out.println("Jogo rodando!!!!");
			long now = System.nanoTime(); //tempo em nano passado para a variável now (agora)
			delta += (now - lasttime) / ns;	//Cálculo do intervalo para realizar o tick
			lasttime = now;
			
			if(delta >= 1) {
				tick();
				render();
				frames ++;
				delta--;
				
				if (System.currentTimeMillis() - timer >= 1000) {
					System.out.println("FPS: "+ frames);
					frames = 0;
					timer += 1000;
				}
				
			}
			
		}
		
		stop(); //O método Stop é uma garantia que o progravm encerrará, caso dê um erro.
		
	}

	
	
}
