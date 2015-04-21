package d.grzesiak.Projekt3.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;


public class Home extends WebDriverPage{

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://tao.inf.ug.edu.pl/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//functions, which operates on webelements
	public void clickNOSQL(){
		findElement(By.xpath(".//*[@ href='http://wbzyl.inf.ug.edu.pl/nosql/']")).click();
	}
	public void clickC(){
		findElement(By.xpath(".//*[@ href='http://wbzyl.inf.ug.edu.pl/c/']")).click();
	}
	public void clickRails4(){
		findElement(By.xpath(".//*[@ href='http://wbzyl.inf.ug.edu.pl/rails4/']")).click();
	}
	public void clickTI(){
		findElement(By.xpath(".//*[@ href='http://wbzyl.inf.ug.edu.pl/hcj/']")).click();
	}
	public void clickSeminarium(){
		findElement(By.xpath(".//*[@ href='http://wbzyl.inf.ug.edu.pl/seminarium/']")).click();
	}
}
