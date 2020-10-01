import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {

		List<URL> urls = new ArrayList<>();
		urls.add(new URL("https://www.youtube.com/"));
		urls.add(new URL("https://www.google.com"));
		urls.add(new URL("https://lefunes.wordpress.com"));
		urls.add(new URL("https://www.facebook.com"));

		System.out.println("Iniciando peticiones..");
		while (true) {
			for (URL url : urls) {
				consumirUrl(url);
			}
		}

	}

	static void consumirUrl(URL url) throws Exception {

		URLConnection con = url.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

	}
}