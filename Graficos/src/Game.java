import java.awt.Canvas; //Canvas tem as propriedades para especificar as configura��es das janelas com ex. tamanho
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
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE)); //Define as dimens�es e escala de tamanho das janelas
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
			thread.join(); //Esse m�todo � uma garantia que o programa encerrar�, caso d� um erro.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void initFrame() {
		frame = new JFrame("Devagar n�is chega l�!");
		frame.add(this); //Pega as propriedades do Canvas
		frame.setResizable(false); //Ipmede  usu�rio de redimensionar a janela
		frame.pack(); //Calcula as dimens�es do Canvas para exibir
		frame.setLocationRelativeTo(null); //Faz com que a janela inicialize no centro da tela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ao fechar a janela, o programa � finalizado
		frame.setVisible(true); //Janela vis�vel ao inicializar
	}
	
	public static void main (String[] args) {
		Game game = new Game();
		game.start(); //inicia o jogo
		
	}
	
	public void tick() {
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy(); //O m�todo BufferStrategy � usado para otimizar a renderiza��o atrav�s de Buffers
		if (bs == null) {
			this.createBufferStrategy(3); //Geralmente o BufferStrategy � usado valor entre 2 e 3
			return; //Usa-se o return para quebra do m�todo para que no pr�ximo loop, n�o entrar� na condi��o novamente.
		}
		Graphics g = image.getGraphics(); //Graphics � o m�todo para uso de gr�ficos.
		g.setColor(new Color(0,0,0)); //Color � o m�todo para uso de cores, definindo atrav�s do RGB como par�metros na sequ�ncia
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE); //Renderiza um ret�ngulo usando par�metros posi��o xy e dimens�es.
		
		//g.setColor(Color.blue); //Renderizando uma figura dentro da janela
		//g.fillRect(x, y, width, height);
		g.setFont(new Font("Arial", Font.BOLD, 10));
		g.setColor(Color.red);
		g.drawString("Devagar n�is chega l�!", 5, 50);
		
		
		g = bs.getDrawGraphics();
		g.drawImage(image,0,0,WIDTH*SCALE,HEIGHT*SCALE,null);
		bs.show(); //Para mostrar os gr�ficos configurados.
		
	}
	
	@Override
	public void run() {
		long lasttime = System.nanoTime(); //Nanotime pega o tempo atual do sistema em nano segundos para maior precis�o
		double amountOFTicks = 60.0; //Criando a taxa de quadros por segundo
		double ns = 1000000000 / amountOFTicks; //C�lculo para determinar o update dos frames para os segundos em nano
		double delta = 0;
		
		int frames = 0;
		double timer = System.currentTimeMillis();
		
		while(isRunning) {
			//System.out.println("Jogo rodando!!!!");
			long now = System.nanoTime(); //tempo em nano passado para a vari�vel now (agora)
			delta += (now - lasttime) / ns;	//C�lculo do intervalo para realizar o tick
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
		
		stop(); //O m�todo Stop � uma garantia que o progravm encerrar�, caso d� um erro.
		
	}

	
	
}
