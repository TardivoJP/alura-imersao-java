package aula1;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		
		//ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
		//String url = "https://api.nasa.gov/planetary/apod?api_key=tc74LKUaAZVWfa9jBm0O8erVwnAcOXGse8lM4tUC&start_date=2022-06-12&end_date=2022-06-14";
		
		//ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
		//String url = "https://alura-filmes.herokuapp.com/conteudos";
		
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
		String url = "http://alura-linguagens-api-jp.herokuapp.com/linguagens";
		
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
		
		var geradora = new GeradoraDeFigurinha();
		
		for(int i=0;i<3;i++) {
			
			Conteudo conteudo = conteudos.get(i);
			
			String nomeArquivo = "saida/"+conteudo.getTitulo()+".png";
			nomeArquivo = nomeArquivo.replaceAll("[^a-zA-Z0-9 /]", " ");
			
			try {
				InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
				geradora.cria(inputStream, nomeArquivo);
			} catch (Exception e) {
				System.out.println("Ocorreu um erro: Falha ao acessar a URL para "+conteudo.getTitulo());
			}
			
			
			System.out.println(conteudo.getTitulo());
			System.out.println();
		}
		
	}

}
