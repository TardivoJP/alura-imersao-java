package aula1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinha {

	void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		
		//leitura da imagem
		//InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
		//InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
		var imagemOriginal = ImageIO.read(inputStream);
		
		//cria nova imagem em memória com transparência e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = (int) (altura+Math.round(altura*0.20));
		
		var novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		//copiar a imagem original pra nova imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		//configurar a fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, largura/8);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);
		
		//escrever uma frase na nova imagem
		graphics.drawString("TOPZERA", largura/5, (novaAltura-(Math.round(altura*0.07))));
		
		//escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
	}

}
