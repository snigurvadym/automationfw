package web.test.com.core;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Utils {

	public static int checkDomainInResultLinks(List<String> links, String domain) {
		int detected = 0;
		for (String link : links) {
			if (getDomain(link).equals(domain)) {
				detected++;
			}
		}
		return detected;
	}

	private static String getDomain(String link) {
		URI uri = null;
		try {
			uri = new URI(link);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return uri.getHost();
	}
}
