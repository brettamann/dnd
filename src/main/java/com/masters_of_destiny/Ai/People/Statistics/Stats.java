package com.masters_of_destiny.Ai.People.Statistics;

public class Stats {
    // All stats connect to the person's uuid in the db.
    public Physical physical;
    public Mental mental;
    public Social social;
    public Spiritual spiritual;

}

/*
Each level you get to spend 1 point in a main (base) stat.
Each time you spend a point in a main (base) stat you get 2 points to spend in the minor stats.
All stat levels are checked as the combination of the substat and corresponding main stat.
For example,
3 points into physical and 2 points into strength makes strength 5 (3+2)
 */

/*
How do I want to handle combat?
Izzy was frustrated in DnD because the roll against AC feels like a "miss".
Part of that was how it was presented, you could talk about things being blocked, parried, stopped by armor

in a "realistic" situation, HP is an arbitrary number that doesn't really mean anything other than
"you run out of this, you DIE", Which is insanely vague and allows people to be bullet sponges.
p=player
dm=dungeon master
p"I hit this unarmed person with my longsword."
dm"Success! You deal 243 damage to him".
p"Is he dead?"
dm"Nope."
p"So what exactly did I just do to him then?"
dm"uh... he has 500 hp so you... half killed him? Nothing really changes though until he hits 0".

That system has the advantage of being simple, and it's just math. Hostile actions reduce their hit
points, when their hit points reach 0 they die.
This is excellent for ARPGs where you are meant to cleave through monsters quickly and efficiently.
But it's NOT cinematic at ALL for DnD. "You hit and removed 10 hit points" is waaaay less interesting than
"Your arrow flies true and strikes the Orc's shoulder. The brute staggers, roaring, and rips the arrow
clean out. blood flows from the fresh wound as it turns towards you, hand drenched in gore and
clenching the projectile."

What I want to do is make a more specific system.
p"I hit this unarmed person in the neck with my longsword."
dm"Ok, let's see if you hit. Well, the person tried to dodge but you were too quick and hit."
p"So what happened?"
dm"You had enough strength to cleanly lop his head off. He's dead."
p"Cool."

or:
p"I fire my bow at his left leg which has only leather armor."
dm"Accuracy check... you hit. The arrow didn't have enough force to go clean through, it's stuck inside his leg."
p"So what happens?"
dm"He begins bleeding. He doesn't have much pain tolerance, so he collapses screaming and can't walk normal."
p"What's his hit points then?"
dm"Irrelevant. He's bleeding though, so if he doesn't get treated he'll die from that eventually."
p"So if I continually punch his leg it won't kill him?"
dm"Not because you hurt his leg per se, as much as it means he bleeds out faster"
p"Ok, but he's fairly disabled so I could try a killing stroke then."
dm"Yep. He'd still try to save his life so he's not 'safe', but he's a lot easier to kill."
 */
