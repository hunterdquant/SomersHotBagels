package app.shb.somershotbagels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/9/2016.
 */



//TODO - add options to the items
public class MenuRetrieval {

    public static final String[] CATEGORY_NAMES = {"Beverages", "Bagels", "Breakfast Foods", "Baked Goods", "Wraps", "Sandwiches", "Salads"};
    public static final int[] IMAGE_IDS = {R.mipmap.beverages, R.mipmap.bagels, R.mipmap.breakfast, R.mipmap.bakedgoods, R.mipmap.wrap, R.mipmap.sandwiches, R.mipmap.salad};
    public static List<Item> retreveCategory(String menuName){
        List<Item> itemList = new ArrayList<Item>();
        switch (menuName) {
            case "Beverages":
                itemList.add(new Item("Coffee"));
                itemList.add(new Item("Decaf Coffee"));
                itemList.add(new Item("Tea"));
                itemList.add(new Item("Hot Chocolate"));
                itemList.add(new Item("Espresso"));
                itemList.add(new Item("Latte"));
                itemList.add(new Item("Chai Tea"));
                itemList.add(new Item("Iced Coffee"));
                itemList.add(new Item("Iced Tea"));
                itemList.add(new Item("Iced Cappuccino"));
                break;
            case "Bagels":
                Item iter = new Item();
                itemList.add(new Item("Bagel"));
                itemList.get(0).addOption(new QuantityOptions());
                itemList.get(0).addOption(new BagelOptions());
                itemList.get(0).addOption(new SpreadOptions());
                itemList.add(new Item("Bagel Pop"));
                itemList.add(new Item("Kaiser Roll"));
                itemList.add(new Item("Mini-Bagel"));
                break;
            case "Breakfast Foods":
                itemList.add(new Item("Bacon, Egg, and Cheese"));
                itemList.add(new Item("One Egg"));
                itemList.add(new Item("Two Eggs"));
                itemList.add(new Item("Egg and Cheese"));
                itemList.add(new Item("Egg and Bacon"));
                itemList.add(new Item("Egg and Ham"));
                itemList.add(new Item("Egg and Sausage"));
                itemList.add(new Item("Ultimate Sandwich",
                        "Two eggs, bacon sausage, ham, and cheese"));
                itemList.add(new Item("Breakfast Burrito",
                        "Two scrambled eggs, sausage, scallions, green " +
                        "peppers, cheddar, cheese on a wrap. Sour cream " +
                        "and salsa on the side"));
                itemList.add(new Item("Tony's Wrap",
                        "Four egg whites, turkey, spinach, hot peppers, alpine lace Swiss"));
                itemList.add(new Item("American Omelette",
                        "Three eggs, bacon, tomato, American cheese"));
                itemList.add(new Item("Italian Omelette",
                        "Three eggs, ham, mozzarella, tomato"));
                itemList.add(new Item("Mexican Omelette",
                        "Three eggs, sausage, peppers, onions, pepper jack cheese"));
                itemList.add(new Item("Western Omelette",
                        "Three eggs, ham, peppers, Swiss cheese"));
                itemList.add(new Item("Healthy Omelette",
                        "Four egg whites, spinach, tomato, alpine lace Swiss"));
                itemList.add(new Item("Steak Omelette",
                        "Four egg whites, roast beef, onions, peppers, cheddar"));
                itemList.add(new Item("Spicy Chicken Omelette",
                        "Four egg whites, buffalo chicken, onions, provolone, hot sauce, ranch"));
                itemList.add(new Item("California Breakfast Wrap",
                        "Four egg whites, avocado, bacon, tomato, Swiss"));
                break;
            case "Baked Goods":
                itemList.add(new Item("Muffin"));
                itemList.add(new Item("Scone"));
                itemList.add(new Item("Croissant"));
                itemList.add(new Item("Apple Turnover"));
                itemList.add(new Item("Cinnamon Bun"));
                itemList.add(new Item("Black & White Cookie"));
                itemList.add(new Item("Pound Cake"));
                break;
            case "Wraps":
                itemList.add(new Item("Cracked Pepper Turkey",
                        "Turkey, Alpine Lace Swiss, lettuce, tomato and ranch dressing"));
                itemList.add(new Item("Grilled Chicken Supreme",
                        "Grilled chicken, roasted peppers, fresh mozzarella," +
                        " and balsamic vinaigrette"));
                itemList.add(new Item("Healthy Wrap",
                        "Turkey, spring mix, tomato, cucumber and ranch dressing"));
                itemList.add(new Item("Tuna Special",
                        "Vegetable tuna, Muenster, lettuce, tomato and red onion"));
                itemList.add(new Item("Buffalo Chicken",
                        "Buffalo chicken, cheddar, lettuce, tomato, red onion " +
                                "and bleu cheese dressing"));
                itemList.add(new Item("Chicken Salad BLT"));
                itemList.add(new Item("Egg Salad BLT"));
                itemList.add(new Item("Tuna Salad BLT"));
                itemList.add(new Item("Island Wrap",
                        "Grilled chicken, romaine, dried cranberries, walnuts," +
                        " and lite raspberry dressing"));
                itemList.add(new Item("Chipotle Chicken",
                        "Grilled chicken, romaine, tomato, red onion, bacon" +
                        " and chipotle dressing"));
                itemList.add(new Item("Turkey Club",
                        "Turkey, bacon, lettuce, tomato, and mayo"));
                itemList.add(new Item("Chicken Caesar",
                        "Grilled chicken, romaine, parmesan, and Caesar dressing"));
                itemList.add(new Item("Roast Beef",
                        "Roast beef, muenster, lettuce, tomato, red onion," +
                        " and horseradish Dijon dressing"));
                itemList.add(new Item("Italian Combo",
                        "Mortadella, salami, pepperoni and provolone"));
                itemList.add(new Item("American Combo",
                        "Ham, roast beef, turkey, and American cheese"));
                itemList.add(new Item("Asian Chicken Wrap",
                        "Grilled Asian chicken, spring mix, tomato, carrots, " +
                        "scallions and Asian dressing"));
                itemList.add(new Item("Honey Turkey",
                        "Honey turkey, lettuce, tomato and honey mustard dressing"));
                itemList.add(new Item("Garden Veggie",
                        "Spring mix, tomato, red onion, carrots, and ranch dressing"));
                itemList.add(new Item("Honey Ham",
                        "Honey ham, pepper jack cheese, lettuce, tomato and" +
                        " honey mustard dressing"));
                itemList.add(new Item("Ham and Swiss",
                        "Ham, swiss, lettuce, tomato, mustard, and mayo"));
                itemList.add(new Item("Spring Wrap",
                        "Grilled chicken, leaf lettuce, avocado, cucumber," +
                        " tomato, and read onion"));
                break;
            case "Sandwiches":
                itemList.add(new Item("Veggie Tuna"));
                itemList.add(new Item("Asian Grilled Chicken"));
                itemList.add(new Item("Egg Salad"));
                itemList.add(new Item("Chicken Salad"));
                itemList.add(new Item("Whitefish Salad"));
                itemList.add(new Item("Sliced Nova Scotia Salmon"));
                itemList.add(new Item("Boars Head Deli Sandwich"));
                itemList.add(new Item("BLT"));
                itemList.add(new Item("American Combo"));
                itemList.add(new Item("Cheese"));
                itemList.add(new Item("The Lunch Speical",
                        "Honey Maple Ham, bacon, coleslaw, cheddar " +
                        "cheese, and Russian dressing"));
                itemList.add(new Item("Somer's Steak Combo",
                        "Roast Beef, onions, peppers, melted cheddar and mozzarella cheese"));
                itemList.add(new Item("Pastrami Reuben",
                        "Hot Pastrami, sauerkraut, melted Swiss, with Russian dressing"));
                itemList.add(new Item("Low-fat Reuben",
                        "Grilled turkey, sauerkraut, alpine lace swiss with Russian dressing"));
                itemList.add(new Item("Chicken Quesadilla",
                        "Grilled chicken in a tortilla with cheddar cheese, lettuce, tomato, " +
                        "and red onions. Served with salsa, sour cream, and jalapeno slices on the side."));
                itemList.add(new Item("Chicken Fajita",
                        "Grilled chicken wrapped in a tortilla with peppers, onions and cheddar cheese"));
                break;
            case "Salads":
                itemList.add(new Item("House Salad",
                        "Spring mix, cucumber, tomato, carrots, " +
                        "peppers, choice of dressing"));
                itemList.add(new Item("Caesar Salad",
                        "Romaine, cherry tomato, carrots, peppers, choice of dressing"));
                itemList.add(new Item("Spinach Salad",
                        "Baby spinach, almonds, carrots, choice of dressing"));
                itemList.add(new Item("Island Salad",
                        "Romaine, dried cranberries, walnuts, lite raspberry dressing"));
                break;
        }
        return itemList;
    }
}
