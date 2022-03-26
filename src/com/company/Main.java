package com.company;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SerializeException {


        System.setProperty("webdriver.chrome.driver", "F:\\browser driver\\chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.aph.gov.au/Senators_and_Members/Parliamentarian_Search_Results?q=&mem=1&par=-1&gen=0&ps=0");
        FileWriter fileWriter = new FileWriter("F:\\senator\\src\\com\\company\\json_file1.json");
        PrintWriter out = new PrintWriter(fileWriter);


        for (int j = 0; j < 13; j++) {
            String nameComb = null;
            String stateComb = null;
            String partyComb = null;
            String constComb = null;
            String profileComb = null;
            String addressComb = null;
            String phoneComb = null;
            String faxCom = null;

            Boolean bool = true;
            try {
                for (int i = 0; i < 12; i++) {

                    String old_url = driver1.getCurrentUrl();
                    System.out.println(old_url);
                    List<WebElement> name = driver1.findElements(By.cssSelector("h4[class='title']"));
                    nameComb = name.get(i).getText();
                    System.out.println("Name " + name.get(i).getText());

                    List<WebElement> state = driver1.findElements(By.cssSelector("dl[class='dl--inline__result text-small']>dd:nth-child(2)"));
                    stateComb = state.get(i).getText();
                    System.out.println("State (for)" + state.get(i).getText());

                    List<WebElement> name_clickDriver = driver1.findElements(By.cssSelector("h4>a"));
                    WebElement nameClick = name_clickDriver.get(i);
                    nameClick.click();

                    String driver2 = driver1.getCurrentUrl();
                    driver1.get(driver2);

                    List<WebElement> profile = driver1.findElements(By.xpath("//dl[@class='dl--inline__result']//dt[contains(text(),\"Positions\")]/following-sibling::dd"));
                    if (!profile.isEmpty()) {
                        profileComb = profile.get(0).getText();
                        System.out.println("Profile position:-" + profile.get(0).getText());
                    }

                    List<WebElement> party = driver1.findElements(By.xpath("//dl[@class='dl--inline__result']//dt[contains(text(),\"Party\")]/following-sibling::dd"));
                    if (!party.isEmpty()) {
                        partyComb = party.get(0).getText();
                        System.out.println("Party :-" + party.get(0).getText());
                    }

                    List<WebElement> constituency = driver1.findElements(By.xpath("//dl[@class='dl--inline__result']//dt[contains(text(),\"Chamber\")]/following-sibling::dd"));
                    if (!constituency.isEmpty()) {
                        constComb = constituency.get(0).getText();
                        System.out.println("Constituency chamber:-" + constituency.get(0).getText());
                    }

                    List<WebElement> address = driver1.findElements(By.cssSelector("div[class='columns medium-6']>p"));
                    String addressCombSlice = address.get(1).getText();
                    addressComb = addressCombSlice.replace("\n", " ");
                    System.out.println(address.get(1).getText());

                    List<WebElement> phone = driver1.findElements(By.cssSelector("dl.dl--inline>dd>a"));
                    phoneComb = phone.get(0).getText();
                    System.out.println(phone.get(0).getText());

                    List<WebElement> Fax = driver1.findElements(By.cssSelector("dl.dl--inline>dd"));
                    faxCom = Fax.get(1).getText();
                    System.out.println(Fax.get(1).getText());
                    System.out.println("-----------------");
                    System.out.println("-----------------");


                    Combined combined = new Combined(nameComb, partyComb, stateComb, constComb, profileComb, addressComb, phoneComb, faxCom, "Federal", "Australia");
                    JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
                    String all = jsonSerializer.serialize(combined);
                    out.append(all);


                    System.out.println(combined);


                    driver1.navigate().back();
                    System.out.println("-----------------");

                }


//           PrintWriter out = new PrintWriter(fileWriter);
//           Combined combined = new Combined(nameComb,partyComb,stateComb,constComb,profileComb,addressComb,phoneComb,faxCom,"Federal","Australia");
//           JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
//           String all = jsonSerializer.serialize(combined);
//           out.append(all);
//           out.flush();

                List<WebElement> nextDriver = driver1.findElements(By.cssSelector("li.next > a"));
                WebElement nextLink = nextDriver.get(0);
                nextLink.click();
            }catch (IndexOutOfBoundsException e){
                System.out.println("flush");

            }

out.flush();
        }

    }
}