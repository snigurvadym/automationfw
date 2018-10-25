package web.test.com.core;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Utils {

	/**
	 * 	Find domain in the search results links
	 * @param links list of the links to check
	 * @param domain - domain to check in the links
	 * @return - count of detected links
	 */
	public static int checkDomainInResultLinks(List<String> links, String domain) {
		int detected = 0;
		for (String link : links) {
			if (getDomain(link).equals(domain)) {
				detected++;
			}
		}
		return detected;
	}

	/**
	 * get domain from provided link
	 * @param link - link for ex.: https://stackoverflow.com/questions/21099072
	 * @return domain string stackoverflow.com
	 */
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
