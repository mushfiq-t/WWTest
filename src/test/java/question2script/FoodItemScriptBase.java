package question2script;

import general_scripting.question2.ScriptBase;
import org.testng.annotations.Test;

public class FoodItemScriptBase extends ScriptBase {

    @Test
    public void thirdAndFifthItemDisplay(){

        System.out.println(foodItemPage.displayItem(3));
        System.out.println(foodItemPage.displayItem(5));
    }

    @Test
    public void displayAllItems(){

        foodItemPage.listAllItemsAndTheirServings();
    }
}
