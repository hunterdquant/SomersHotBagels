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
                itemList.get(0).addOption(new Option("Quantity"));
                itemList.get(0).addOption(new Option("Coffee"));
                itemList.get(0).addOption(new Option("Size"));
                itemList.get(0).addOption(new Option("Sugar"));
                itemList.get(0).addOption(new Option("Milk"));
                itemList.get(0).addOption(new Option("To-go"));
                itemList.add(new Item("Decaf Coffee"));
                itemList.get(1).addOption(new Option("Quantity"));
                itemList.get(1).addOption(new Option("Decaf Coffee"));
                itemList.get(1).addOption(new Option("Size"));
                itemList.get(1).addOption(new Option("Sugar"));
                itemList.get(1).addOption(new Option("Milk"));
                itemList.get(1).addOption(new Option("To-go"));
                itemList.add(new Item("Tea"));
                itemList.get(2).addOption(new Option("Quantity"));
                itemList.get(2).addOption(new Option("Size"));
                itemList.get(2).addOption(new Option("Sugar"));
                itemList.get(2).addOption(new Option("Milk"));
                itemList.get(2).addOption(new Option("To-go"));
                itemList.add(new Item("Hot Chocolate"));
                itemList.get(3).addOption(new Option("Quantity"));
                itemList.get(3).addOption(new Option("Size"));
                itemList.get(3).addOption(new Option("To-go"));
                itemList.add(new Item("Espresso"));
                itemList.get(4).addOption(new Option("Quantity"));
                itemList.get(4).addOption(new Option("Size"));
                itemList.get(4).addOption(new Option("Sugar"));
                itemList.get(4).addOption(new Option("Milk"));
                itemList.get(4).addOption(new Option("To-go"));
                itemList.add(new Item("Latte"));
                itemList.get(5).addOption(new Option("Quantity"));
                itemList.get(5).addOption(new Option("Size"));
                itemList.get(5).addOption(new Option("Sugar"));
                itemList.get(5).addOption(new Option("Milk"));
                itemList.get(5).addOption(new Option("To-go"));
                itemList.add(new Item("Chai Tea"));
                itemList.get(6).addOption(new Option("Quantity"));
                itemList.get(6).addOption(new Option("Size"));
                itemList.get(6).addOption(new Option("Sugar"));
                itemList.get(6).addOption(new Option("Milk"));
                itemList.get(6).addOption(new Option("To-go"));
                itemList.add(new Item("Iced Coffee"));
                itemList.get(7).addOption(new Option("Quantity"));
                itemList.get(7).addOption(new Option("Coffee"));
                itemList.get(7).addOption(new Option("Size"));
                itemList.get(7).addOption(new Option("Sugar"));
                itemList.get(7).addOption(new Option("Milk"));
                itemList.get(7).addOption(new Option("To-go"));
                itemList.add(new Item("Iced Tea"));
                itemList.get(8).addOption(new Option("Quantity"));
                itemList.get(8).addOption(new Option("Size"));
                itemList.get(8).addOption(new Option("Sugar"));
                itemList.get(8).addOption(new Option("Milk"));
                itemList.get(8).addOption(new Option("To-go"));
                itemList.add(new Item("Iced Cappuccino"));
                itemList.get(9).addOption(new Option("Quantity"));
                itemList.get(9).addOption(new Option("Size"));
                itemList.get(9).addOption(new Option("Sugar"));
                itemList.get(9).addOption(new Option("Milk"));
                itemList.get(9).addOption(new Option("To-go"));
                break;
            case "Bagels":
                itemList.add(new Item("Bagel"));
                itemList.get(0).addOption(new Option("Quantity"));
                itemList.get(0).addOption(new Option("Bagel"));
                itemList.get(0).addOption(new Option("Spread"));
                itemList.get(0).addOption(new Option("Toasted"));
                itemList.get(0).addOption(new Option("To-go"));
                itemList.add(new Item("Bagel Pop"));
                itemList.get(1).addOption(new Option("Quantity"));
                itemList.get(1).addOption(new Option("To-go"));
                itemList.add(new Item("Kaiser Roll"));
                itemList.get(2).addOption(new Option("Quantity"));
                itemList.get(2).addOption(new Option("Spread"));
                itemList.get(2).addOption(new Option("Toasted"));
                itemList.get(2).addOption(new Option("To-go"));
                itemList.add(new Item("Mini-Bagel"));
                itemList.get(3).addOption(new Option("Quantity"));
                itemList.get(3).addOption(new Option("Mini-Bagel"));
                itemList.get(3).addOption(new Option("Spread"));
                itemList.get(3).addOption(new Option("Toasted"));
                itemList.get(3).addOption(new Option("To-go"));
                break;
            case "Breakfast Foods":
                itemList.add(new Item("Bacon, Egg, and Cheese"));
                itemList.add(new Item("One Egg"));
                itemList.add(new Item("Two Eggs"));
                itemList.add(new Item("Egg and Cheese"));
                itemList.add(new Item("Egg and Bacon"));
                itemList.add(new Item("Egg and Ham"));
                itemList.add(new Item("Egg and Sausage"));
                int size1 = 0;
                int size2 = itemList.size();
                for (; size1 < size2; size1++){
                    itemList.get(size1).addOption(new Option("Quantity"));
                    itemList.get(size1).addOption(new Option("Spread"));
                    itemList.get(size1).addOption(new Option("Toasted"));
                    itemList.get(size1).addOption(new Option("On"));
                    itemList.get(size1).addOption(new Option("Cheese"));
                    itemList.get(size1).addOption(new Option("Ketchup"));
                    itemList.get(size1).addOption(new Option("Mayo"));
                    itemList.get(size1).addOption(new Option("Salt"));
                    itemList.get(size1).addOption(new Option("Pepper"));
                    itemList.get(size1).addOption(new Option("Hot Sauce"));
                    itemList.get(size1).addOption(new Option("To-go"));
                }
                itemList.add(new Item("Ultimate Sandwich",
                        "Two eggs, bacon sausage, ham, and cheese"));
                itemList.add(new Item("Breakfast Burrito",
                        "Two scrambled eggs, sausage, scallions, green " +
                        "peppers, cheddar, cheese on a wrap. Sour cream " +
                        "and salsa on the side"));
                itemList.add(new Item("Tony's Wrap",
                        "Four egg whites, turkey, spinach, hot peppers, alpine lace Swiss"));
                size2 = itemList.size();
                for (; size1 < size2; size1++){
                    itemList.get(size1).addOption(new Option("Quantity"));
                    itemList.get(size1).addOption(new Option("To-go"));
                }
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
                size2 = itemList.size();
                for (; size1 < size2; size1++){
                    itemList.get(size1).addOption(new Option("Quantity"));
                    itemList.get(size1).addOption(new Option("Bagel"));
                    itemList.get(size1).addOption(new Option("Toasted"));
                    itemList.get(size1).addOption(new Option("Butter"));
                    itemList.get(size1).addOption(new Option("To-go"));
                }
                itemList.add(new Item("Extras and Sides"));
                break;
            case "Baked Goods":
                itemList.add(new Item("Muffin"));
                itemList.get(0).addOption(new Option("Quantity"));
                itemList.get(0).addOption(new Option("Muffin"));
                itemList.get(0).addOption(new Option("Spread"));
                itemList.get(0).addOption(new Option("Toasted"));
                itemList.get(0).addOption(new Option("To-go"));
                itemList.add(new Item("Scone"));
                itemList.get(1).addOption(new Option("Quantity"));
                itemList.get(1).addOption(new Option("Scone"));
                itemList.get(1).addOption(new Option("Spread"));
                itemList.get(1).addOption(new Option("Toasted"));
                itemList.get(1).addOption(new Option("To-go"));
                itemList.add(new Item("Croissant"));
                itemList.get(2).addOption(new Option("Quantity"));
                itemList.get(2).addOption(new Option("Croissant"));
                itemList.get(2).addOption(new Option("To-go"));
                itemList.add(new Item("Apple Turnover"));
                itemList.get(3).addOption(new Option("Quantity"));
                itemList.get(3).addOption(new Option("To-go"));
                itemList.add(new Item("Cinnamon Bun"));
                itemList.get(4).addOption(new Option("Quantity"));
                itemList.get(4).addOption(new Option("To-go"));
                itemList.add(new Item("Black & White Cookie"));
                itemList.get(5).addOption(new Option("Quantity"));
                itemList.get(5).addOption(new Option("Size"));
                itemList.get(5).addOption(new Option("To-go"));
                itemList.add(new Item("Pound Cake"));
                itemList.get(6).addOption(new Option("Quantity"));
                itemList.get(6).addOption(new Option("Pound Cake"));
                itemList.get(6).addOption(new Option("To-go"));
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
                int length = itemList.size();
                for (int p =0; p <length; p++){
                    itemList.get(p).addOption(new Option("Quantity"));
                    itemList.get(p).addOption(new Option("To-go"));
                }
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
                length =  itemList.size();
                for (int p =0; p <length; p++){
                    itemList.get(p).addOption(new Option("Quantity"));
                    itemList.get(p).addOption(new Option("Toasted"));
                    itemList.get(p).addOption(new Option("Mustard"));
                    itemList.get(p).addOption(new Option("Mayo"));
                    itemList.get(p).addOption(new Option("Ketchup"));
                    itemList.get(p).addOption(new Option("Hot Sauce"));
                    itemList.get(p).addOption(new Option("To-go"));
                }
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
                length = itemList.size();
                for (int p = 0; p < length; p++){
                    itemList.get(p).addOption(new Option("Quantity"));
                    if (p != length -1)
                        itemList.get(p).addOption(new Option("Dressing"));
                    itemList.get(p).addOption(new Option("Chicken Breast"));
                    itemList.get(p).addOption(new Option("Salad"));
                    itemList.get(p).addOption(new Option("Cold Cuts"));
                    itemList.get(p).addOption(new Option("To-go"));
                }
                break;

        }
        return itemList;
    }
}
