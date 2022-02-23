package com.masters_of_destiny.Ai;

public class GeneralNotes {/*
There will be limits to what I can do, but here are the things I want
Keep in mind that whatever I build, the objective is FUN
For all players

Wish List
Multiplayer compatible
No need for a dedicated DM, the AI takes care of that
Capability to be creative and take things in unexpected ways
Able to be specific and even silly with creativity
    give ability to interact with almost everything in as many ways possible
    make things work realistically without being too complex

Able to tell a story, things are descriptive and can be narrated
Have some sort of UI with visuals, not just text-based


example use cases to handle:

Tie a person to another object
have characters behave according to a specific injury in a specific place
    eg missing a hand? can't use it or wear things on that hand
lie to a person and have them behave as if it were true
make an object out of other object(s)



How would I make multiplayer work, risk to warzone style?

warzone vs DnD
Similar:
turn-based
long live sessions
social, has elements of competition and cooperation at times

differences
DnD is extremely complex in goals, tools, scenarios, is an actual narrative
so yeah... all of those differences
* warzone is all combat all the time, DnD has battles but also free-roaming events
* In DnD, 5 minutes real-time can mean 10 seconds in-game time, or days of time whereas in warzone
  every turn, regardless of the time set up, is the same amount of "in-game" time

Changes made to risk to make it fit warzone, plus ideas of how to do with DnD:
* instead of a 1 by 1 turn structure, everyone defines what they want to happen with the parts under their control,
  and then they are executed without any ability to change them, in a specified order
-- During battles this could function the same way. each character chooses what they are going to do, and
   then the turn is executed in initiative order. In some ways this is more "realistic" as in real-life
   multiple people make decisions at the same time. People will be able to talk with each other and
   avoid stepping on each others' toes in that way, and will know the turn order.
-- The bigger challenge here would be: How do you handle non-combat time?
   * You don't want to do the same turn-by-turn structure. You could have "maintenance" rounds
     where after combat or when in a new place without an "event" going on, players have a chance
     to do all the shopping they need to in places they've previously discovered, rest, gather gear,
     and so forth, take care of the more "boring" parts without needing to make it more tedious than normal.
   * So say the party is in a cave. They just finished a brutal battle and need to get out. They currently
     have left the turn-by-turn structure, so they are free to choose what the party does next. They
     choose to try to leave the cave area and go back to town to heal and resupply.
     The AI looks around and decides if they manage to get back without further trouble.
     if no events happen, the party exits the hostile area and goes into "free roam" mode.
     They can buy/sell items, rest, prepare spells, make gear adjustments, do crafting, etc.
   * You could maybe have 3 times of time:
     1. Turn-by-turn, active when in combat, sneaking, committing crimes, etc., where time is very
        specifically marked out where "this round will take up x seconds"
     2. Adventure Mode: Each player gets about 3 turns worth of actions or so to do stuff, and it plays out in
        an initiative order, but a player may also choose to trade order with someone else if that is
        accepted. Orders are loaded up. Any action that could lead to a player causing the turn style to change
        whether by hostility, taking the group to down time (which happens by a vote, and on that topic if the
        vote isn't unanimous then the turn still happens but down time goes in afterward), or otherwise,
        the entire group is notified that someone is planning on doing so. Also conversations are handled like
        so: When making an order to do a conversation, a player may choose to either do a generic conversation
        or a custom one. A generic one offers predetermined paths that can be resolved quickly whereas a custom
        one means that the turn will resolve until the conversation starts, and then the player is notified.
        After the notification goes through, that player is given a specific amount of time to do
        the conversation, after which point the turn will resume.
     3. Down Time, where characters can freely buy/sell (given an area that isn't hostile to them with such
        services exists), rest, craft (given tools or craftsmen to work with), find basic info that wouldn't
        require tough investigation to discover, prepare spells/items, move things around in personal areas.
        level up, and so on. All of these things would be committed in a single "round" without any need to
        coordinate or interact with other players, and won't change the narrative.
* Turns have a time limit. After x amount of time you are booted or the turn happens without you if you didn't
  take your turn.
  -- For Dnd you could fairly easily do the same thing. Didn't take your turn? You could set up how to handle
     that situation in settings, like during a battle the player is controlled by the AI or something

How to generate the world? You want to have SOME kind of visuals...
DnD uses a grid, so we would too for ease of use.
However, each grid piece has attributes:

height of each corner and the center of the tile (to determine slopes)
coordinates of the center of the tile (each tile would be considered 5x5x5')





*/
}
