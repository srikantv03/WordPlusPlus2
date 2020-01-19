package MainPage;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class testMain {

	public static void main(String[] args)  throws IOException {

		String fileName = System.getProperty("user.dir") + "/src/test/amd.txt";
		File filePath = new File(fileName);

        String fileText = readLineByLineJava8( fileName );

		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(fileText);

		while(m.find()) {
			String temp = m.group(1);
			String price = getStockPrice(temp);
			fileText = fileText.replace("\\stocks[" + temp + "]", price);
		}

		System.out.println(fileText);

	}

	private static String getStockPrice(String company) throws IOException {
		String url = "https://finance.yahoo.com/quote/" + company;
		Document document = Jsoup.connect(url).get();
		Element testElem = document.getElementsByClass("Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)").first();
		String output = testElem.html();
		return output;
	}

	private static String readLineByLineJava8(String filePath) 
	{
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
		{
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	public static String compile(String fileText) throws IOException {
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(fileText);

		String original = fileText;
		while(m.find()) {
			String temp = m.group(1);
			String price = getStockPrice(temp);
			//fileText = original.replace("\\stocks[" + temp + "]", price);
			fileText = original.replace("\\stocks[" + temp + "]", price);
		}

		System.out.println(fileText);
		return fileText;
	}

}