package general_scripting.question2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class FoodItemPage {

    /**
     * Below is the source code of a sample webpage which
     * displays a food item along with its servings.

     <html>
     <head>
     </head>

     <body>
     <div class=”itemContent”>

     <span class="title ng-binding" ng-bind="food.name">Apple butter</span>
     <span class="description ng-binding" ng-bind="food._servingDesc">1 Tbsp</span>

     <span class="title ng-binding" ng-bind="food.name">Apple(s) fresh</span>
     <span class="description ng-binding" ng-bind="food._servingDesc">1 medium</span>

     <span class="title ng-binding" ng-bind="food.name">Applesauce, unsweetened </span>
     <span class="description ng-binding" ng-bind="food._servingDesc">1/2 cup(s)</span>

     <span class="title ng-binding" ng-bind="food.name">Apple(s), dried</span>
     <span class="description ng-binding" ng-bind="food._servingDesc">1/4 cup(s)</span>

     <span class="title ng-binding" ng-bind="food.name">Juice, Cranberry-apple drink</span>
     <span class="description ng-binding" ng-bind="food._servingDesc">8 fl oz</span>

     </div>
     </body>

     </html>
     */

    public static final String ALL_FOOD_NAMES_CSS = "span[class*='title']";
    public static final String ALL_FOOD_SERVINGS_CSS = "span[class*='description']";

    private WebDriver driver;


    @FindBy(css = ALL_FOOD_NAMES_CSS)
    private List<WebElement> allFoodItems;
    @FindBy(css = ALL_FOOD_SERVINGS_CSS)
    private List<WebElement> allFoodServings;


    public FoodItemPage (WebDriver driver){

        PageFactory.initElements(driver,this);
    }


    /**
     * a)Display the third and fifth item from the above list.
     * Your output should be:
     * Applesauce, unsweetened
     * Juice, Cranberry-apple drink
     */

    /**
     * --> This method takes in an integer value and returns the text from the list of items
     * @param itemNumber the desired food item number.
     * @return String
     */
    public String displayItem(int itemNumber){

        if (itemNumber > allFoodItems.size() || itemNumber <= 0) {

            throw new IndexOutOfBoundsException("Invalid item number. Please try again!");
        }

        return allFoodItems.get(itemNumber - 1).getText();

    }

    /**
     *  b)	Fetch each food name and its servings and store them in a Map.
     *  Iterate through all the entries in the Map and print them.
     */

    /**
     * --> This method prints out the list of items with their servings respectively.
     */

    public void listAllItemsAndTheirServings(){

        Map<String, String> itemsMap = new LinkedHashMap<>();

        for (int i = 0; i < allFoodItems.size(); i++){

            itemsMap.put(allFoodItems.get(i).getText(),allFoodServings.get(i).getText());
        }

        for (Map.Entry<String, String> entry : itemsMap.entrySet()){
            System.out.printf("%s : %s %n", entry.getKey(), entry.getValue());
        }


    }
}
