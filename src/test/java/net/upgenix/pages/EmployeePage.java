package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EmployeePage {

    public EmployeePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login")
    public WebElement inputLogin;

    @FindBy(id = "password")
    public WebElement inputPass;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;

    @FindBy(partialLinkText = "Employees")
    public WebElement emplStage;

    @FindBy(partialLinkText = "Badges")
    public WebElement badgesBtn;

    @FindBy(partialLinkText = "Challenges")
    public WebElement challengesBtn;

    @FindBy(partialLinkText = "Goals History")
    public WebElement goalsHistoryBtn;

    @FindBy(partialLinkText = "Departments")
    public WebElement departmentsBtn;

//    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/button[1]")
    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']")
    public WebElement createBtn;

    @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement employeesName;

    public void login(){
        this.inputLogin.sendKeys("posmanager50@info.com");
        this.inputPass.sendKeys("posmanager");
        this.loginButton.click();
    }

    public void login(String inputLogin, String inputPass){
        this.inputLogin.sendKeys("posmanager50@info.com");
        this.inputPass.sendKeys("posmanager");
        this.loginButton.click();
    }

}