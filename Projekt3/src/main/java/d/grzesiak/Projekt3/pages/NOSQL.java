package d.grzesiak.Projekt3.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class NOSQL extends WebDriverPage {

	public NOSQL(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://wbzyl.inf.ug.edu.pl/nosql/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
}
