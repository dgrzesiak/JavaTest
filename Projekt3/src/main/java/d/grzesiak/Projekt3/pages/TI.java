package d.grzesiak.Projekt3.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class TI extends WebDriverPage {

	//page elements
	
	/**********************/
	public TI(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://wbzyl.inf.ug.edu.pl/hcj/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//functions
	
	
}
