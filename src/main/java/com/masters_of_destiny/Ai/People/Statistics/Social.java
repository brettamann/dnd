package com.masters_of_destiny.Ai.People.Statistics;

public class Social {
    public int base;
    public int persuasion; // persuasion, romance
    public int entertainment; // jokes, stories, songs, good for distraction, making money
    public int bartering; // better buy and sell prices
    public int intimidation; // ability to bluff, scare, interrogate, dominate
    public int empathy;
    // helps diffuse situations and displays emotional states of creatures, animal & npc
    // also helps avoid offending others, always present)
    public int deception; // how well you can lie convincingly
}

/*
When it comes to social interactions, I want to take a narrative role in conversations
rather than a point-by-point role.
Rather than have a conversation be like this:

p"Hi how are you?"
npc"fine. what do you want?"
p"I hate your mom"
npc"you'll die for that"

I want it to be more like a menu that shows up where a player connects things.
<Get info> <Build relationship> <barter> <ask for help> <Give info> <Give item> <entertain>
then select "get info" and get this menu:
<ask [persuasion]> <interrogate [intimidation]> <Bribe [bartering]> <fool [deception]>
p : Ask npc about what he knows about the security at the bank"
Computer does rolls to determine if you are successful, if you offend the person, etc
and then determines how much information you would get out of them based on what they know.
then the player would see something like:
"<player> approached <npc>, and struck up a conversation. After some small talk <player> slipped
in that he/she wanted to know (x) about (y). <npc> hesitated, but with their past friendship relented.
Here's what was learned:..."
 */