package com.dnd.DataObjects.Items;

import java.util.ArrayList;
import java.util.Arrays;

public class StandardArmor {
    //TODO: create a magical armor class, and a "custom armor" class for legendaries
    public static final Armor natural = new Armor("Natural", "Not wearing any armor (ac 10 + dex mod)", new ArrayList<>(), 0, 10, 100, "none", 0, 0, 0, 0, Rarities.common);
    public static final Armor padded = new Armor("Padded", "(ac 11 + dex mod) light armor", new ArrayList<>(Arrays.asList("Disadvantage on stealth rolls")), 0, 11, 100, "Quilted layers of cloth and batting", 0, 5, 0, 0, Rarities.common);
    public static final Armor leather = new Armor("Leather", "(ac 11 + dex mod) light armor", new ArrayList<>(), 0, 11, 100, "The Breastplate and shoulder protectors of this armor are made of leather that has been stiffened by being boiled in oil. The rest of the armor is made of softer and more flexible materials", 0, 10, 0, 0, Rarities.common);
    public static final Armor studdedLeather = new Armor("Studded Leather", "(ac 12 + dex mod) light armor", new ArrayList<>(), 0, 12, 100, "Made from tough but flexible leather, studded leather is reinforced with close-set rivets or spikes.", 0, 45, 0, 0, Rarities.common);

    public static final Armor hide = new Armor("Hide", "(ac 12 + 2 dex mod max) medium armor", new ArrayList<>(), 0, 12, 2, "thick furs and pelts", 0, 10, 0, 0, Rarities.common);
    public static final Armor breastplate = new Armor("Breastplate", "(ac 14 + 2 dex mod max) medium armor", new ArrayList<>(), 0, 14, 2, "a fitted metal chest piece worn with supple leather", 0, 400, 0, 0, Rarities.common);
    public static final Armor chainShirt = new Armor("Chain Shirt", "(ac 13 + 2 dex mod max) medium armor", new ArrayList<>(), 0, 13, 2, "interlocking metal rings, a chain shirt is worn between layers of clothing or leather", 0, 50, 0, 0, Rarities.common);
    public static final Armor halfPlate = new Armor("Half Plate", "(ac 15 + 2 dex mod max) medium armor", new ArrayList<>(Arrays.asList("Disadvantage on stealth rolls")), 0, 15, 2, "shaped metal plates that cover most of the wearer's body", 0, 750, 0, 0, Rarities.common);
    public static final Armor scaleMail = new Armor("Scale Mail", "(ac 14 + 2 dex mod max) medium armor", new ArrayList<>(Arrays.asList("Disadvantage on stealth rolls")), 0, 14, 2, "coat and leggings (and perhaps a separate skirt) of leather covered with overlapping pieces of metal, much like the scales of a fish. The suit includes gauntlets", 0, 50, 0, 0, Rarities.common);

    public static final Armor chainMail = new Armor("Chain Mail", "(ac 16) heavy armor", new ArrayList<>(Arrays.asList("Disadvantage on stealth rolls")), 13, 16, 0, " interlocking metal rings, chain mail includes a layer of quilted fabric worn underneath the mail to prevent chafing and to cushion the impact of blows. The suit includes gauntlets.", 0, 75, 0, 0, Rarities.common);
    public static final Armor fullPlate = new Armor("Full Plate Mail", "(ac 18) heavy armor", new ArrayList<>(Arrays.asList("Disadvantage on stealth rolls")), 15, 18, 0, "shaped, interlocking metal plates to cover the entire body", 0, 1500, 0, 0, Rarities.common);
    public static final Armor ringMail = new Armor("Ring Mail", "(ac 14) heavy armor", new ArrayList<>(Arrays.asList("Disadvantage on stealth rolls")), 0, 14, 0, "leather armor with heavy rings sewn into it", 0, 30, 0, 0, Rarities.common);
    public static final Armor splint = new Armor("Splint Mail", "(ac 17) heavy armor", new ArrayList<>(Arrays.asList("Disadvantage on stealth rolls")), 15, 17, 0, "narrow vertical strips of metal riveted to a backing of leather that is worn over cloth padding. Flexible chain mail protects the joints", 0, 200, 0, 0, Rarities.common);

    public static final Armor shield = new Armor("Shield", "(ac 2) misc armor", new ArrayList<>(Arrays.asList("Takes an arm slot to use")), 0, 2, 0, "A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.", 0, 10, 0, 0, Rarities.common);

    //public static final Armor thing = new Armor("name", "(ac ?? + dex mod) thing", new ArrayList<>(Arrays.asList("")), 0, 10, 100, "materialComp", 0, 0, 0, 0, Rarities.common);
}
