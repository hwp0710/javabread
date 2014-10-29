package concurrencyinpractice.net.jcip.examples.ch7_22;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * WebCrawler
 * <p/>
 * Using TrackingExecutorService to save unfinished tasks for later execution
 * 
 * @author Brian Goetz and Tim Peierls
 */
public class WebCrawlerApp extends WebCrawler {

	public WebCrawlerApp(URL startUrl) {
		super(startUrl);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected List<URL> processPage(URL url) {
		List<URL> list = new ArrayList<URL>();
		try {

			for (int i = 0; i < 10; i++) {
				list.add(new URL("www" + i + ".javabread.com:"
						+ new Random().nextDouble()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) throws MalformedURLException,
			InterruptedException {
		WebCrawlerApp app = new WebCrawlerApp(new URL("www.javabread.com"));
		app.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		app.stop();
	}

}
