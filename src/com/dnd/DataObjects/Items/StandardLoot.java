package com.dnd.DataObjects.Items;

import java.util.ArrayList;
import java.util.Arrays;

public class StandardLoot {
    //TODO: fill out loot items
    //good to find loot descriptions https://www.dndbeyond.com/search?q=backpack
    //money is always a loot type but doesn't need to be explicitly stated here
    public static final Loot callGlyph = new Loot("Call Glyph Tablet", "A circular stone tablet ~1\" thick and 5\" in diameter with an etching of Grand Bastion's emblem, used to call emergency services.", ItemTypes.misc, new ArrayList<>(Arrays.asList("Call guards","Call Fire services","Call medical services")), 1, Rarities.common, 0, 0, 0, 0);
    public static final Loot barrel = new Loot("barrel","a 1x1 wooden barrel with a lid",ItemTypes.misc, new ArrayList<>(Arrays.asList("Stores items")), 1,Rarities.common,0,0,0,1);
    public static final Loot backpack = new Loot("backpack", "leather pack carried on the back, typically with straps to secure it", ItemTypes.misc, new ArrayList<>(Arrays.asList("can hold 1 cubic foot/ 30 pounds of gear. You can also strap items, such as a bedroll or a coil of rope, to the outside of a backpack")), 1, Rarities.common, 0, 0, 0, 2);
    public static final Loot ballBearings = new Loot("ball bearings", "A bag of 1000 tiny metal balls in a pouch", ItemTypes.misc, new ArrayList<>(Arrays.asList("As an action, you can spill these tiny metal balls from their pouch to cover a level, square area that is 10 feet on a side. A creature moving across the covered area must succeed on a DC 10 Dexterity saving throw or fall prone. A creature moving through the area at half speed doesn’t need to make the save.")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot basket = new Loot("basket", "a 2x2 wicker basket with no lid", ItemTypes.misc, new ArrayList<>(Arrays.asList("Stores items")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot bedroll = new Loot("bedroll", "bedding and a thing blanket small enough to roll up and tie.", ItemTypes.misc, new ArrayList<>(Arrays.asList("You never know where you’re going to sleep, and a bedroll helps you get better sleep in a hayloft or on the cold ground. A bedroll consists of bedding and a blanket thin enough to be rolled up and tied. In an emergency, it can double as a stretcher.")), 1, Rarities.common, 0, 1, 0, 0);;
    //public static final Loot thing = new Loot("name","desc",ItemTypes.misc, new ArrayList<>(Arrays.asList("abilities")),1,Rarities.common,0,0,0,0);
}
