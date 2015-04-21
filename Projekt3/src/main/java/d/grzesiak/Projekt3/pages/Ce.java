package d.grzesiak.Projekt3.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Ce extends WebDriverPage {

	public Ce(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://wbzyl.inf.ug.edu.pl/c/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}
