package d.grzesiak.Projekt3;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class InfUgSteps {

	private final Pages pages;
	
	public InfUgSteps(Pages pages) {
		this.pages = pages;
	}

	//wbzyl inf ug simple test
	@Given("user is on home page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("click ASI link")
    public void clicksASILink(){        
        pages.home().clickRails4();
    }
    @Then("he open page with Rails4")
    public void openPageWithASI(){
       assertEquals("WB@Rails4", pages.rails4().getTitle());
    }	
    //next
    @When("click NOSQL")
    public void clickNOSQLLink(){
    	pages.home().clickNOSQL();
    }
    @Then("he open page with NOSQL")
    public void openPageWithNOSQL(){
    	assertEquals("WB@NOSQL", pages.rails4().getTitle());
    }
    //next
    @When("click TI")
    public void clickTILink(){
    	pages.home().clickTI();
    }
    @Then("he open page with TI")
    public void openPageWithTI(){
    	assertEquals("WB@HCJ", pages.ti().getTitle());
    }
    //next
    @When("click C")
    public void clickCLink(){
    	pages.home().clickC();
    }
    @Then("he open page with C")
    public void openPageWithC(){
    	assertEquals("WB@C", pages.ce().getTitle());
    }
}
