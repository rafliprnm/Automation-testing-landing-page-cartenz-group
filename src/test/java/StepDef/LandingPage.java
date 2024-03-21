package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class LandingPage {

    WebDriver driver;
    String dateNews;
    String address;
    @Given("I open browser")
    public void iOpenBrowser() {
        // membuka browser chrome
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Then("I open website cartenz group")
    public void iOpenWebsiteCartenzGroup() throws InterruptedException {
        //membuka website cartenz group
        driver.navigate().to("http://cartenzgroup.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @When("I click button play")
    public void iClickButtonPlay() {
        //menekan button play video
        driver.findElement(By.xpath("//*[@id=\"video-wrap\"]/div/div/div/div[2]/div/a")).click();

    }

    @Then("Video profile company playing")
    public void videoProfileCompanyPlaying() throws InterruptedException {
        //memastikan video berhasil dijalankan
        boolean isPlaying = driver.findElement(By.xpath("//*[@id=\"cartenz-video\"]")).isDisplayed();
        if(isPlaying == true){
            System.out.println("video playing success");
        }else{
            System.out.println("failed to play video");
        }
        Thread.sleep(5000);
        driver.quit();
    }

    @When("I click {string} on navbar")
    public void iClickOnNavbar(String nav) throws InterruptedException {
        //Klik navbar berdasarkan kebutuhan
        driver.findElement(By.partialLinkText(nav)).click();
        Thread.sleep(1000);
    }

    @Then("Information about the company appears")
    public void informationAboutTheCompanyAppears() throws InterruptedException {
        //Memastikan berada di section About Company
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"whoweare\"]/div/div/div[1]/div/h4")).getText(), "Who Are We");
        Thread.sleep(3000);
        driver.quit();
    }

    @And("News about the company appears")
    public void newsAboutTheCompanyAppears() {
        //Memastikan berada di section News Company
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"news\"]/div/div[1]/div[1]/div/h4")).getText(), "News");
    }

    @When("I click news detail")
    public void iClickNewsDetail() {
        //Mengambil tanggal berita yang disimpan pada variabel dateNews
        dateNews = driver.findElement(By.xpath("//*[@id=\"news\"]/div/div[2]/div[1]/a/div/div[3]")).getText();
        //Klik berita
        driver.findElement(By.xpath("//*[@id=\"news\"]/div/div[2]/div[1]/a")).click();

    }

    @Then("The news detail open")
    public void theNewsDetailOpen() throws InterruptedException {
        Thread.sleep(1000);
        //Memastikan url pada browser membuka website http://cartenzgroup.com/page/news/1.html
        Assert.assertEquals(driver.getCurrentUrl(),"http://cartenzgroup.com/page/news/1.html");
        Thread.sleep(5000);
        //Memastikan tanggal berita pada detail sama dengan tanggal berita di halaman sebelumnya
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"news\"]/div/div/div[1]/div[1]/div/div[2]")).getText(),dateNews);
        Thread.sleep(2000);
        driver.quit();
    }

    @Then("Information Value the company appears")
    public void informationValueTheCompanyAppears() throws InterruptedException {
        //Memastikan berada di section company values
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"values\"]/div/div[1]/h1")).getText(),"Values");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"values\"]/div/div[2]/div/div/div[1]/div/h4")).getText(),"Innovation");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"values\"]/div/div[2]/div/div/div[2]/div/h4")).getText(),"Persistence");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"values\"]/div/div[2]/div/div/div[3]/div/h4")).getText(),"Impact");
        Thread.sleep(1000);
        driver.quit();
    }

    @When("I click learn more about cartenz technology")
    public void iClickLearnMoreAboutCartenzTechnology() {
        //klik "learn more"
        driver.findElement(By.xpath("//*[@id=\"ourcompanies\"]/div/div[2]/div[2]/div/p[2]/a")).click();
    }

    @Then("I was directed to the website cartenz.co.id")
    public void iWasDirectedToTheWebsiteCartenzCoId() throws InterruptedException {
        Thread.sleep(2000);
        //Pindah Tab
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        //Memastikan url pada browser membuka website http://cartenz.co.id/
        Assert.assertEquals(driver.getCurrentUrl(), "https://cartenz.co.id/");
        Thread.sleep(1000);
        driver.quit();
    }

    @When("Carrer about the company appears")
    public void carrerAboutTheCompanyAppears() {
        //Memastikan berada di section Career
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"jointeam\"]/div/div[1]/div/div/h1")).getText(), "Join The Team!");
    }

    @Then("I choose an available role")
    public void iChooseAnAvailableRole() throws InterruptedException {
        //Memilih role career
        driver.findElement(By.xpath("//*[@id=\"jointeam\"]/div/div[2]/div[1]/ul/li[1]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"jointeam\"]/div/div[2]/div[1]/ul/li[2]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"jointeam\"]/div/div[2]/div[1]/ul/li[3]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"jointeam\"]/div/div[2]/div[2]/ul/li[1]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"jointeam\"]/div/div[2]/div[2]/ul/li[2]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"jointeam\"]/div/div[2]/div[2]/ul/li[3]/a")).click();
        Thread.sleep(1500);
        driver.quit();
    }


    @And("I copy company address")
    public void iCopyCompanyAddress() {
        //Mengambil alamat perusahaan yang disimpan pada variabel address
        address = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div/div[1]/div/ul/li[1]/div/p")).getText();
    }

    @And("I open google maps")
    public void iOpenGoogleMaps() throws InterruptedException {
        //Membuka halaman goole maps
        driver.navigate().to("https://www.google.com/maps");
        Thread.sleep(1000);
    }

    @When("I paste company addres")
    public void iPasteCompanyAddres() throws InterruptedException {
        //Menuliskan alamat pada pencarian google maps
        driver.findElement(By.xpath("//*[@id=\"searchboxinput\"]")).sendKeys("PT Cartenz Tekno Lab "+address,Keys.RETURN);
        Thread.sleep(2000);
    }

    @Then("Company appears on google maps")
    public void companyAppearsOnGoogleMaps() throws InterruptedException {
        //Menemukan alamat perusahaan
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"QA0Szd\"]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div[1]/h1")).getText(), "PT Cartenz Tekno Lab");
        Thread.sleep(1000);
        driver.quit();
    }

    @When("I click icon linkedin")
    public void iClickIconLinkedin() throws InterruptedException {
        //Klik icon linkedin perusahaan
        driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div/div[2]/ul/li[1]/a")).click();
    }

    @Then("I was directed to the linkedin cartenz.co.id")
    public void iWasDirectedToTheLinkedinCartenzCoId() throws InterruptedException {
        Thread.sleep(2000);
        //Pindah Tab
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        //Memastikan url pada browser membuka website http://www.linkedin.com/company/cartenz-group
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/cartenz-group");
        Thread.sleep(1000);
        driver.quit();
    }

    @Then("Information about leader of the company appears")
    public void informationAboutLeaderOfTheCompanyAppears() throws InterruptedException {
        //Melakukan inisiasi pada element
        WebElement CEO = driver.findElement(By.xpath("//*[@id=\"ourleaders\"]/div/div[2]/div[1]/div"));
        Actions action1 = new Actions(driver);
        //Membuat cursor bergerak ke element tujuan sehingga menghasilkan element yang tertutup menjadi muncul
        action1.moveToElement(CEO).perform();
        Thread.sleep(1000);
        //Memastikan cursor yang terpilih pada CEO
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ourleaders\"]/div/div[2]/div[1]/div/div/div[1]/h3")).getText(), "Gito Wahyudi");

        //Melakukan inisiasi pada element
        WebElement CTO = driver.findElement(By.xpath("//*[@id=\"ourleaders\"]/div/div[2]/div[2]/div"));
        Actions action2 = new Actions(driver);
        //Membuat cursor bergerak ke element tujuan sehingga menghasilkan element yang tertutup menjadi muncul
        action2.moveToElement(CTO).perform();
        Thread.sleep(1000);
        //Memastikan cursor yang terpilih pada CTO
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ourleaders\"]/div/div[2]/div[2]/div/div/div[1]/h3")).getText(), "Devriady Pratama");

        Thread.sleep(1000);
        driver.quit();
    }

    @When("I scroll into value section")
    public void iScrollIntoValueSection() throws InterruptedException {
        //Melakukan scrolling sampai section values
        WebElement section = driver.findElement(By.id("values"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
        Thread.sleep(1000);
    }

    @When("I scroll into ourleader section")
    public void iScrollIntoOurleaderSection() throws InterruptedException {
        //Melakukan scrolling sampai section ourleaders
        WebElement section = driver.findElement(By.id("ourleaders"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
        Thread.sleep(1000);
    }

    @And("I scroll into footer section")
    public void iScrollIntoFooterSection() throws InterruptedException {
        //Melakukan scrolling sampai section footer
        WebElement section = driver.findElement(By.id("footer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
        Thread.sleep(1000);
    }

    @Then("Information people about the company appears")
    public void informationPeopleAboutTheCompanyAppears() throws InterruptedException {
        //Melihat informasi pada section our people
        driver.findElement(By.xpath("//*[@id=\"people-slider\"]/div[3]/div[1]")).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"people-slider\"]/div[1]/div/div[3]/div/div[2]/div[2]/div[1]/h2")).getText(), "Compassion");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"people-slider\"]/div[3]/div[2]")).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"people-slider\"]/div[1]/div/div[4]/div/div[2]/div[2]/div[1]/h2")).getText(), "Integrity");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"people-slider\"]/div[3]/div[3]")).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"people-slider\"]/div[1]/div/div[5]/div/div[2]/div[2]/div[1]/h2")).getText(), "Proactivity");
        Thread.sleep(1500);
        driver.quit();
    }
}
