import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class websiteParser {
	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Main_Page").get();
		FileOutputStream fileOutputStream = new FileOutputStream("D:/web-content.txt");
		fileOutputStream.write(doc.toString().getBytes());
		fileOutputStream.close();
	}
}
