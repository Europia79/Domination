BattleArena Domination
======
Bukkit plugin that adds Domination & Conquest game types to
Minecraft servers running BattleArena (dependency).

Each team starts with a number of tickets (300 for example).
This means that each team can respawn 300 times total.
So you can think of tickets like "lives." 


Domination ends when a team reaches zero tickets.
The team with zero tickets left loses.


To help in this endeavor, there are beacon objectives 
placed around the map. Controlling the beacons mean 
that you can increase the bleed rate of your enemy tickets. 
Also, each time you get a kill, the other team loses 1 ticket.


Good luck! And have fun!


Timeline:
---
<dl>
<dt>Next Important Task</dt>
<dd>Track the number of tickets, add a ticket bleed rate, 
add a config file, and end the arena with getMatch().setVictor(team); 
Also, right now, BeaconListener implements Listener because it's 
easier to test because we don't have to actually make and join an Arena 
in order to test it out. But in the future, BeaconListener will extend 
Arena instead.</dd>

<dt>3/19/2014 - debug lib</dt>
<dd>debug.jar was made internal library in order 
to reduce the number of dependencies. This makes the 
Domination plugin easier to install on minecraft servers.<dd>

<dt>3/09/2014 - debug.jar</dt>
<dd>created basic debugging library that can
toggle debug mode on/off.</dd>

<dt>3/01/2014 - GameTimer.java</dt>
<dd>Created a very basic timer: Tested & working.</dd>

<dt>2/28/2014 - InventoryListener.java</dt>
<dd>Listens for players who click on the Beacon (main objective).
And starts the timer.</dd>
</dl>


Contact:
======

Nick at Nikolai.Kalashnikov@hotmail.com

[http://www.Battlecraft.co/](http://www.Battlecraft.co/ "Battlecraft")
