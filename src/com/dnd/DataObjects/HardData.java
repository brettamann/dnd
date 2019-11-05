package com.dnd.DataObjects;

import com.dnd.DataObjects.Races.Race;
import com.dnd.DataObjects.Races.Races;
import com.dnd.DataObjects.Spells.Spell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardData {
    Races races = new Races();
    List<Race> raceData = races.generateRaceData();
    List<Location> locationList = new ArrayList<Location>((Arrays.asList(
            new Location("Berlstrom", "Slums on the east side of the city", new ArrayList<>(Arrays.asList("Thieves hideout", "Ramshackle Hospital", "orphanage", "peddler street", "Shack City")), new ArrayList<>(Arrays.asList("War & Judgement District", "Lakeshore Community", "Woodland Haven Forest", "Thunderfoot", "East Gate Market", "The Sewers")), 0, 0, 1, 1, 4, 4, 0, 3, 1, 1, 3, 3, 4, 3, 1, 1, 2, 3, 6, 2, 3, 6, 10, 4, 3, 1, 6, 3, 5, 9, 1, 1, 1, 10, 15, 70, 5, 0, 0, 3, 3, -5, 2, 0, 0, 0, 20, 0, 100, 0, 100, 0, 0, 0, 3, 1, 1, 2, 10, 25, 80, 1, 10),
            new Location("Overlook Ridge", "Wealthiest district, surrounds The Citadel on a plateau overlooking the city", new ArrayList<>(Arrays.asList("Cathedral", "Hospital", "Jewelcourt Market", "bath house", "performance hall", "Hilltop Mansions")), new ArrayList<>(Arrays.asList("The Citadel", "Jewelcourt Market", "The Sewers")), 0, 0, 3, 11, 1, 1, 3, 4, 4, 4, 7, 4, 4, 4, 4, 1, 4, 4, 2, 3, 1, 7, 1, 1, 1, 1, 1, 2, 4, 1, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 30, 3, 10, 30, 1, 6, 1, 4, 20, 1, 8),
            new Location("The Citadel", "The capital building of Grand Bastion. It's a large, beautiful, well-guarded fortress", new ArrayList<>(Arrays.asList("Council chambers", "Meeting hall", "Offices", "Kitchens", "High Court", "Living spaces", "Dungeon")), new ArrayList<>(Arrays.asList("Overlook Ridge", "The Sewers")), 0, 0, 3, 11, 1, 0, 4, 4, 4, 4, 7, 4, 4, 4, 4, 0, 4, 4, 4, 4, 0, 7, 0, 0, 2, 2, 0, 2, 4, 1, 4, 4, 4, 15, 0, 0, 0, 40, 25, -10, 5, 100, 15, 1, 50, 1, 250, 0, 100, 0, 100, 22, 40, 1, 10, 95, 3, 8, 1, 1, 60, 1, 8),
            new Location("The Carnival", "Middle of the city at an intersection of main paths, next to the Roost Inn, houses lots of games and entertainment", new ArrayList<>(Arrays.asList("See encounters in story points")), new ArrayList<>(Arrays.asList("Woodland Haven Forest", "The Roost Inn", "The Sewers")), 0, 0, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 3, 3, 4, 3, 5, 3, 6, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 95, 5, 0, 0, 0, 0, 0, 0, -3, -4, 0, 2, 0, 100, 0, 100, 0, 100, 10, 25, 1, 14, 100, 1, 4, 4, 10, 100, 1, 25),
            new Location("Woodland Haven Forest", "Large wooded area in the center of the city, houses woodland creatures", new ArrayList<>(Arrays.asList("Lots of trees, woodland animals, and random things to run into")), new ArrayList<>(Arrays.asList("The Roost Inn", "Dragons' Landing", "Thunderfoot","The Carnival","Rethsberg Hills","The Greenbelt","Lakeshore Community","Angelfall Square Memorial", "The Sewers")), 0, 0, 3, 1, 10, 5, 25, 1, 1, 1, 10, 5, 1, 3, 1, 5, 1, 5, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 5, 1, 0, 1, 1, 25, 15, 10,40, 5, 5, 5, 2, -5, 5, 0, 1, 0, 25, 0, 100, 0, 100, 5, 15, 0, 5, 2, 2, 5, 8, 40, 8, 1, 15),
            new Location("The Roost Inn", "Biggest inn in the city. Huge cylindrical pit carved into floors of rooms with a large central common area.", new ArrayList<>(Arrays.asList("Entertainers platform", "wine cellar", "managers offices", "kitchens", "stables", "bar")), new ArrayList<>(Arrays.asList("The Carnival", "Woodland Haven Forest", "The Sewers")), 0, 0, 1, 3, 1, 3, 3, 3, 3, 3, 3, 3, 4, 3, 5, 3, 4, 4, 3, 5, 3, 6, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 100, 0, 0, 0, 0, 0, -2, 0, 5, 0, 0, 10, 0, 100, 0, 200, 0, 200, 12, 25, 0, 6, 100, 4, 8, 4, 10, 95, 6, 20),
            new Location("Dragons' Landing", "Hollowed-out mountain home to mostly flying creatures. Has flying transportation for hire.", new ArrayList<>(Arrays.asList("Dragons Landing","Dragon Dens", "Winged Stables","Spire homes")), new ArrayList<>(Arrays.asList("Thunderfoot", "Woodland Haven Forest","Angelfall Square Memorial", "The Sewers")), 0, 0, 40, 10, 1, 1, 0, 2, 2, 0, 0, 0, 0, 0, 2, 2, 2, 0, 2, 2, 2, 2, 19, 0, 0, 2, 2, 0, 0, 5, 0, 0, 2, 5, 5, 40, 40, 9, 1, 0, 0, -1, 0, 0, 10, 0, 200, 0, 150, 0, 150, 10, 20, 0, 5, 5, 1, 2, 6, 12, 50, 1, 5),
            new Location("Thunderfoot", "Main industrial sector of the city. Lots of large creatures live here.", new ArrayList<>(Arrays.asList("Construction Center", "Machine Yards", "Giants Retreat Homes")), new ArrayList<>(Arrays.asList("Woodland Haven Forest", "Berlstrom","War & Judgement District", "The Sewers")), 0, 0, 0, 1, 1, 2, 5, 5, 1, 15, 1, 15, 1, 0, 0, 0, 20, 0, 10, 0, 2, 1, 0, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 20, 5, 15, 50, 8, 2, -2, 2, -1, 0, 0, 5, 0, 50, 0, 100, 0, 100, 10, 20, 0, 5, 5, 2, 4, 4, 15, 25, 1, 4),
            new Location("East Gate Market", "Self explanatory", new ArrayList<>(Arrays.asList("Carriage for hire","basic shops for food,gear,armor,weapons,and other supplies")), new ArrayList<>(Arrays.asList("Berlstrom", "The Sewers")), 0, 0, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 3, 3, 4, 3, 5, 3, 6, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 80, 20, 0, 0, 0, 0, -5, -5, 4, -5, 0, 10, 0, 10, 0, 100, 0, 100, 5, 20, 0, 10, 90, 1, 3, 4, 8, 100, 5, 25),
            new Location("West Gate Market", "Self explanatory", new ArrayList<>(Arrays.asList("Carriage for hire", "basic shops for food,gear,armor,weapons,and other supplies")), new ArrayList<>(Arrays.asList("Rethsberg Hills", "The Greenbelt", "The Sewers")), 0, 0, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 3, 3, 4, 3, 5, 3, 6, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 95, 5, 0, 0, 0, 0, -2, -3, 7, -4, 0, 10, 0, 10, 0, 100, 0, 100, 5, 20, 0, 10, 90, 1, 3, 4, 8, 100, 5, 25),
            new Location("Lakeshore Community", "Surrounds a lake, middle to wealthy classes live here, lots of aquatic races.", new ArrayList<>(Arrays.asList("Swimming Pier", "flooded triton caverns", "community garden", "lakeshore rows housing")), new ArrayList<>(Arrays.asList("Woodland Haven Forest", "Rethsberg Hills", "Berlstrom", "The Sewers")), 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 10, 5, 5, 4, 3, 0, 0, 5, 0, 1, 0, 15, 0, 0, 5, 0, 0, 3, 2, 0, 18, 18, 3, 5, 5, 0, 60, 28, 2, -4, -2, 2, 0, 0, 10, 0, 10, 0, 100, 0, 100, 15, 28, 0, 6, 20, 1, 3, 5, 8, 33, 1, 10),
            new Location("Angelfall Square Memorial", "Large square with important infrastructure for the city. Bank, library, museum, other big businesses. Named for a large memorial in its center plaza", new ArrayList<>(Arrays.asList("Angelfall Square Memorial","Pelor & Dawnbringer Statue", "Memorial of the Fallen", "The Arcanum Library", "Grand Bastion Museum", "Bastion Central Bank", "The Sewers")), new ArrayList<>(Arrays.asList("The Greenbelt", "Woodland Haven Forest", "Jewelcourt Market", "Dragons' Landing")), 0, 0, 3, 5, 1, 3, 3, 4, 3, 3, 5, 3, 3, 3, 5, 1, 3, 6, 1, 5, 1, 8, 3, 1, 3, 3, 1, 3, 3, 1, 3, 3, 5, 95, 5, 0, 0, 0, 0, -5, 0, 10, 5, 0, 10, 0, 100, 0, 100, 0, 100, 18, 30, 0, 10, 90, 1, 5, 2, 6, 90, 3, 25),
            new Location("Rethsberg Hills", "Mostly manmade hilly area settled by shorter and underground-dwelling creatures. Large underground community.", new ArrayList<>(Arrays.asList("The Burrows", "Tammer tavern", "Cavernforge Smithy", "the Line apartments")), new ArrayList<>(Arrays.asList("Upper Caverns", "Lakeshore Community", "West Gate Market", "The Greenbelt", "Woodland Haven Forest", "The Sewers")), 0, 0, 0, 0, 1, 1, 0, 2, 18, 0, 0, 5, 2, 2, 18, 2, 2, 1, 2, 15, 2, 3, 4, 2, 1, 2, 3, 0, 1, 9, 0, 0, 2, 5, 5, 20, 60, 8, 2, 3, -3, -2, 1, 0, 15, 8, 100, 10, 100, 10, 100, 14, 25, 0, 5, 5, 1, 4, 6, 12, 30, 2, 6),
            new Location("Upper Caverns", "Has a ghetto version of Rethsberg Hills, most dark-loving creatures live here. Has the start of a mining community and large forge/refinery", new ArrayList<>(Arrays.asList("Mining Guild Offices", "Foundries", "Worker Dorms", "DarkDweller Hovel")), new ArrayList<>(Arrays.asList("Lower Caverns", "Rethsberg Hills", "The Sewers")), 0, 0, 0, 0, 1, 10, 0, 2, 10, 0, 0, 0, 0, 0, 5, 10, 0, 0, 5, 2, 10, 0, 0, 10, 0, 10, 10, 0, 5, 10, 0, 0, 0, 5, 10, 70, 12, 2, 1, 8, 5, -5, 0, 0, 2, 0, 20, 0, 100, 0, 100, 5, 20, 0, 4, 5, 4, 6, 10, 30, 100, 1, 10),
            new Location("Lower Caverns", "Huge active mine but with lots of abandoned shafts and tunnels. Easy place to get shanked in the dark.", new ArrayList<>(Arrays.asList("Black Market", "Hobo Camp")), new ArrayList<>(Arrays.asList("Upper Caverns")), 0, 0, 0, 0, 1, 10, 0, 1, 2, 1, 1, 1, 1, 1, 2, 10, 5, 1, 2, 1, 10, 2, 1, 13, 1, 5, 20, 1, 2, 2, 1, 1, 1, 5, 90, 5, 0, 0, 0, 10, 5, -10, 5, 0, 5, 0, 100, 0, 100, 0, 100, 5, 20, 0, 6, 0, 4, 8, 100, 300, 3, 1, 6),
            new Location("War & Judgement District", "The militial center of Grand Bastion. Has lots of government buildings and military bases.", new ArrayList<>(Arrays.asList("Courthouse", "Barracks", "Captains Mansion", "Training yards", "Academy", "Translocator Center", "Prison", "Gallows")), new ArrayList<>(Arrays.asList("Berlstrom", "Thunderfoot", "Jewelcourt Market", "The Sewers")), 0, 0, 3, 4, 1, 0, 4, 4, 4, 4, 4, 3, 4, 4, 5, 0, 4, 4, 4, 5, 0, 6, 1, 0, 4, 4, 1, 4, 4, 3, 4, 4, 4, 80, 0, 3, 7, 6, 4, -5, 0, 100, 4, 0, 10, 5, 100, 0, 100, 0, 100, 15, 30, 0, 7, 95, 1, 3, 3, 6, 90, 1, 8),
            new Location("Jewelcourt Market", "Fanciest market in Grand Bastion, at the front of Overlook Ridge.", new ArrayList<>(Arrays.asList("Shops, see encounters for more")), new ArrayList<>(Arrays.asList("Overlook Ridge", "Angelfall Square Memorial","War & Judgement District", "The Sewers")), 0, 0, 3, 11, 1, 1, 3, 4, 4, 4, 7, 4, 4, 4, 4, 1, 4, 4, 2, 3, 1, 7, 1, 1, 1, 1, 1, 2, 4, 1, 4, 4, 4, 98, 2, 0, 0, 0, 0, -8, 4, 8, 4, 1, 10, 10, 200, 20, 200, 20, 200, 18, 30, 2, 10, 100, 1, 8, 2, 5, 95, 1, 15),
            new Location("The Greenbelt", "Manmade swamp area for lots of aquatic and marshland creatures.", new ArrayList<>(Arrays.asList("Sunning Ponds", "Hatching Grounds", "Herb Farms", "Sunken Dens")), new ArrayList<>(Arrays.asList("West Gate Market", "Rethsberg Hills","Woodland Haven Forest","Angelfall Square Memorial", "The Sewers")), 0, 0, 0, 0, 1, 0, 4, 2, 0, 2, 2, 2, 2, 2, 0, 1, 0, 1, 0, 0, 2, 2, 1, 0, 19, 0, 2, 20, 2, 0, 15, 19, 0, 5, 15, 25, 36, 18, 1, 3, 2, -2, 1, 0, 5, 0, 80, 0, 100, 0, 100, 12, 24, 0, 4, 5, 1, 5, 5, 10, 25, 1, 7),
            new Location("The Sewers", "City-wide sewer system. Most pipes are too small to fit people but plenty of main shafts are quite large.", new ArrayList<>(Arrays.asList("Some hidden areas - see encounters for more")), new ArrayList<>(Arrays.asList("The Greenbelt","Jewelcourt Market","War & Judgement District","Upper Caverns","Rethsberg Hills","Angelfall Square Memorial","Lakeshore Community","West Gate Market","East Gate Market","Thunderfoot","Dragons' Landing","The Roost Inn","Woodland Haven Forest","The Citadel","Overlook Ridge", "Berlstrom")), 0, 0, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 3, 3, 4, 3, 5, 3, 6, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 95, 0, 0, 0, 0, 10, 5, -10, 0, 0, 0, 0, 10, 0, 80, 0, 80, 5, 14, 0, 2, 1, 2, 6, 20, 40, 6, 1, 3)
    )));

    /*
    31 races
    ~3% per is an even distribution for a race, leaving 7 remaining to boost 7 up to 4%
     */

    public List<Location> getLocationList() {
        return locationList;
    }

    public Races getRaces() {
        return races;
    }

    public List<Race> getRaceData() {
        return raceData;
    }

    public List<Spell> spellList = new ArrayList<Spell>(Arrays.asList(
        //TODO: fill out spell data
        new Spell("Acid Splash",0,"","1 action", 60, "v,s","instant","sorc, wiz","You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage."),
        new Spell("Chill Touch",0,"","1 action",120,"","1 round","sorc, wiz, war","You create a ghostly, skeletal hand in the space of a creature within range. Make a ranged spell attack against the creature to assail it with the chill of the grave. On a hit, the target takes 1d8 necrotic damage, and it can’t regain hit points until the start of your next turn. Until then, the hand clings to the target.\n" +
                "\tIf you hit an undead target, it also has disadvantage on attack rolls against you until the end of your next turn."),
        new Spell("Dancing Lights",0,"","1 action",120,"v,s,m","concentration, up to 1 min","","You create up to four torch-sized lights within range, making them appear as torches, lanterns, or glowing orbs that hover in the air for the duration. You can also combine the four lights into one glowing vaguely humanoid form of Medium size. Whichever form you choose, each light sheds dim light in a 10-foot radius.\n" +
                "\tAs a bonus action on your turn, you can move the lights up to 60 feet to a new spot within range. A light must be within 20 feet of another light created by this spell, and a light winks out if it exceeds the spell’s range"),
        new Spell("Druidcraft",0,"","1 action",30,"v,s","instant","","Whispering to the spirits of nature, you create one of the following effects within range:\n" +
                "\tYou create a tiny, harmless sensory effect that predicts what the weather will be at your location for the next 24 hours. The effect might manifest as a golden orb for clear skies, a cloud for rain, falling snowflakes for snow, and so on. This effect persists for 1 round.\n" +
                "\tYou instantly make a flower blossom, a seed pod open, or a leaf bud bloom.\n" +
                "\tYou create an instantaneous, harmless sensory effect, such as falling leaves, a puff of wind, the sound of a small animal, or the faint odor of skunk. The effect must fit in a 5-foot cube.\n" +
                "\tYou instantly light or snuff out a candle, a torch, or a small campfire."),
        new Spell("Eldritch Blast",0,"","1 action",120,"v,s","instant","","A beam of crackling energy streaks toward a creature within range. Make a ranged spell attack against the target. On a hit, the target takes 1d10 force damage.\n" +
                "\tThe spell creates more than one beam when you reach higher levels: two beams at 5th level, three beams at 11th level, and four beams at 17th level. You can direct the beams at the same target or at different ones. Make a separate attack roll for each beam."),
        new Spell("Fire Bolt",0,"","1 action",0,"v,s","instant","","You hurl a mote of fire at a creature or object within range. Make a ranged spell attack against the target. On a hit, the target takes 1d10 fire damage. A flammable object hit by this spell ignites if it isn’t being worn or carried."),
        new Spell("Guidance",0,"","1 action",0,"v,s","conc, 1 min","","You touch one willing creature. Once before the spell ends, the target can roll a d4 and add the number rolled to one ability check of its choice. It can roll the die before or after making the ability check. The spell then ends."),
        new Spell("Light",0,"","1 action",0,"v,m: firefly or phosphorescent moss","1 hr","","You touch one object that is no larger than 10 feet in any dimension. Until the spell ends, the object sheds bright light in a 20-foot radius and dim light for an additional 20 feet. The light can be colored as you like. Completely covering the object with something opaque blocks the light. The spell ends if you cast it again or dismiss it as an action.\n" +
                "\tIf you target an object held or worn by a hostile creature, that creature must succeed on a Dexterity saving throw to avoid the spell.\n"),
        new Spell("Mage Hand",0,"","1 action",30,"v,s","1 min","","A spectral, floating hand appears at a point you choose within range. The hand lasts for the duration or until you dismiss it as an action. The hand vanishes if it is ever more than 30 feet away from you or if you cast this spell again.\n" +
                "\tYou can use your action to control the hand. You can use the hand to manipulate an object, open an unlocked door or container, stow or retrieve an item from an open container, or pour the contents out of a vial. You can move the hand up to 30 feet each time you use it.\n" +
                "\tThe hand can’t attack, activate magic items, or carry more than 10 pounds."),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","",""),
        new Spell("",0,"","",0,"","","","")

    ));
}
