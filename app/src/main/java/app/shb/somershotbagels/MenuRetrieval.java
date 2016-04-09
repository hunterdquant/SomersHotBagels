package app.shb.somershotbagels;

/**
 * Created by Robert on 4/9/2016.
 */


//TODO - add options to the items
public class MenuRetrieval {
    public static void buildMenu(Category category){
        switch (category.getName()) {
            case "Beverages":
                category.addItem(new Item("Coffee", category));
                category.addItem(new Item("Decaf Coffee", category));
                category.addItem(new Item("Tea", category));
                category.addItem(new Item("Hot Chocolate", category));
                category.addItem(new Item("Espresso", category));
                category.addItem(new Item("Latte", category));
                category.addItem(new Item("Chai Tea", category));
                category.addItem(new Item("Iced Coffee", category));
                category.addItem(new Item("Iced Tea", category));
                category.addItem(new Item("Iced Cappuccino", category));
                break;
            case "Bagels":
               /* category.addItem(new Item("Plain Bagel", category));
                category.addItem(new Item("Poppy Seed Bagel", category));
                category.addItem(new Item("Sesame Seed Bagel", category));
                category.addItem(new Item("Cinnamon Raisin Bagel", category));
                category.addItem(new Item("Everything Bagel", category));
                category.addItem(new Item("Wheat Bagel", category));
                category.addItem(new Item("Wheat Everything Bagel", category));
                category.addItem(new Item("Egg Bagel", category));
                category.addItem(new Item("Egg Everything Bagel", category));
                category.addItem(new Item("Marble Bagel", category));
                category.addItem(new Item("Pumpernickel Bagel", category));
                category.addItem(new Item("Pumpernickel Seasame Bagel", category));
                category.addItem(new Item("7-Grain Bagel", category));
                category.addItem(new Item("Onion Bagel", category));
                category.addItem(new Item("Garlic Bagel", category));
                category.addItem(new Item("Salt Bagel", category));
                category.addItem(new Item("Berry Bagel", category));
                category.addItem(new Item("Baker's Dozen", category));*/
                category.addItem(new Item("Bagel", category));
                category.addItem(new Item("Bagel Pop", category));
                category.addItem(new Item("Kaiser Roll", category));
                category.addItem(new Item("Mini-Bagel", category));
/*                category.addItem(new Item("Everything Mini-Bagel", category));
                category.addItem(new Item("Plain Mini-Bagel", category));
                category.addItem(new Item("Poppy Seed Mini-Bagel", category));
                category.addItem(new Item("Sesame Seed Mini-Bagel", category));
                category.addItem(new Item ("Cinnamon Raisin Mini-Bagel", category));*/
                break;
            case "Breakfast Foods":
                category.addItem(new Item("Bacon, Egg, and Cheese", category));
                category.addItem(new Item("One Egg", category));
                category.addItem(new Item("Two Eggs", category));
                category.addItem(new Item("Egg and Cheese", category));
                category.addItem(new Item("Egg and Bacon", category));
                category.addItem(new Item("Egg and Ham", category));
                category.addItem(new Item("Egg and Sausage", category));
                category.addItem(new Item("Ultimate Sandwich", category,
                        "Two eggs, bacon sausage, ham, and cheese"));
                category.addItem(new Item("Breakfast Burrito", category,
                        "Two scrambled eggs, sausage, scallions, green " +
                        "peppers, cheddar, cheese on a wrap. Sour cream " +
                        "and salsa on the side"));
                category.addItem(new Item("Tony's Wrap", category,
                        "Four egg whites, turkey, spinach, hot peppers, alpine lace Swiss"));
                category.addItem(new Item("American Omelette", category,
                        "Three eggs, bacon, tomato, American cheese"));
                category.addItem(new Item("Italian Omelette", category,
                        "Three eggs, ham, mozzarella, tomato"));
                category.addItem(new Item("Mexican Omelette", category,
                        "Three eggs, sausage, peppers, onions, pepper jack cheese"));
                category.addItem(new Item("Western Omelette", category,
                        "Three eggs, ham, peppers, Swiss cheese"));
                category.addItem(new Item("Healthy Omelette", category,
                        "Four egg whites, spinach, tomato, alpine lace Swiss"));
                category.addItem(new Item("Steak Omelette", category,
                        "Four egg whites, roast beef, onions, peppers, cheddar"));
                category.addItem(new Item("Spicy Chicken Omelette", category,
                        "Four egg whites, buffalo chicken, onions, provolone, hot sauce, ranch"));
                category.addItem(new Item("California Breakfast Wrap", category,
                        "Four egg whites, avocado, bacon, tomato, Swiss"));
                break;
            case "Baked Goods":
                category.addItem(new Item("Muffin", category));
                category.addItem(new Item("Scone", category));
                category.addItem(new Item("Croissant", category));
                category.addItem(new Item("Apple Turnover", category));
                category.addItem(new Item("Cinnamon Bun", category));
                category.addItem(new Item("Black & White Cookie", category));
                category.addItem(new Item("Pound Cake", category));
                break;
            case "Wraps":
                category.addItem(new Item("Cracked Pepper Turkey", category,
                        "Turkey, Alpine Lace Swiss, lettuce, tomato and ranch dressing"));
                category.addItem(new Item("Grilled Chicken Supreme", category,
                        "Grilled chicken, roasted peppers, fresh mozzarella," +
                        " and balsamic vinaigrette"));
                category.addItem(new Item("Healthy Wrap", category,
                        "Turkey, spring mix, tomato, cucumber and ranch dressing"));
                category.addItem(new Item("Tuna Special", category,
                        "Vegetable tuna, Muenster, lettuce, tomato and red onion"));
                category.addItem(new Item("Buffalo Chicken", category,
                        "Buffalo chicken, cheddar, lettuce, tomato, red onion " +
                                "and bleu cheese dressing"));
                category.addItem(new Item("Chicken Salad BLT", category));
                category.addItem(new Item("Egg Salad BLT", category));
                category.addItem(new Item("Tuna Salad BLT", category));
                category.addItem(new Item("Island Wrap", category,
                        "Grilled chicken, romaine, dried cranberries, walnuts," +
                        " and lite raspberry dressing"));
                category.addItem(new Item("Chipotle Chicken", category,
                        "Grilled chicken, romaine, tomato, red onion, bacon" +
                        " and chipotle dressing"));
                category.addItem(new Item("Turkey Club", category,
                        "Turkey, bacon, lettuce, tomato, and mayo"));
                category.addItem(new Item("Chicken Caesar", category,
                        "Grilled chicken, romaine, parmesan, and Caesar dressing"));
                category.addItem(new Item("Roast Beef", category,
                        "Roast beef, muenster, lettuce, tomato, red onion," +
                        " and horseradish Dijon dressing"));
                category.addItem(new Item("Italian Combo", category,
                        "Mortadella, salami, pepperoni and provolone"));
                category.addItem(new Item("American Combo", category,
                        "Ham, roast beef, turkey, and American cheese"));
                category.addItem(new Item("Asian Chicken Wrap", category,
                        "Grilled Asian chicken, spring mix, tomato, carrots, " +
                        "scallions and Asian dressing"));
                category.addItem(new Item("Honey Turkey", category,
                        "Honey turkey, lettuce, tomato and honey mustard dressing"));
                category.addItem(new Item("Garden Veggie", category,
                        "Spring mix, tomato, red onion, carrots, and ranch dressing"));
                category.addItem(new Item("Honey Ham", category,
                        "Honey ham, pepper jack cheese, lettuce, tomato and" +
                        " honey mustard dressing"));
                category.addItem(new Item("Ham and Swiss", category,
                        "Ham, swiss, lettuce, tomato, mustard, and mayo"));
                category.addItem(new Item("Spring Wrap", category,
                        "Grilled chicken, leaf lettuce, avocado, cucumber," +
                        " tomato, and read onion"));
                break;
            case "Sandwiches":
                category.addItem(new Item("Veggie Tuna", category));
                category.addItem(new Item("Asian Grilled Chicken", category));
                category.addItem(new Item("Egg Salad", category));
                category.addItem(new Item("Chicken Salad", category));
                category.addItem(new Item("Whitefish Salad", category));
                category.addItem(new Item("Sliced Nova Scotia Salmon", category));
                category.addItem(new Item("Boars Head Deli Sandwich", category));
                category.addItem(new Item("BLT", category));
                category.addItem(new Item("American Combo", category));
                category.addItem(new Item("Cheese", category));
                category.addItem(new Item("The Lunch Speical", category,
                        "Honey Maple Ham, bacon, coleslaw, cheddar " +
                        "cheese, and Russian dressing"));
                category.addItem(new Item("Somer's Steak Combo", category,
                        "Roast Beef, onions, peppers, melted cheddar and mozzarella cheese"));
                category.addItem(new Item("Pastrami Reuben", category,
                        "Hot Pastrami, sauerkraut, melted Swiss, with Russian dressing"));
                category.addItem(new Item("Low-fat Reuben", category,
                        "Grilled turkey, sauerkraut, alpine lace swiss with Russian dressing"));
                category.addItem(new Item("Chicken Quesadilla", category,
                        "Grilled chicken in a tortilla with cheddar cheese, lettuce, tomato, " +
                        "and red onions. Served with salsa, sour cream, and jalapeno slices on the side."));
                category.addItem(new Item("Chicken Fajita", category,
                        "Grilled chicken wrapped in a tortilla with peppers, onions and cheddar cheese"));
                break;
            case "Salads":
                category.addItem(new Item("House Salad", category,
                        "Spring mix, cucumber, tomato, carrots, " +
                        "peppers, choice of dressing"));
                category.addItem(new Item("Caesar Salad", category,
                        "Romaine, cherry tomato, carrots, peppers, choice of dressing"));
                category.addItem(new Item("Spinach Salad", category,
                        "Baby spinach, almonds, carrots, choice of dressing"));
                category.addItem(new Item("Island Salad", category,
                        "Romaine, dried cranberries, walnuts, lite raspberry dressing"));
                break;
        }
    }
}
