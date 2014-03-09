CHANGELOG:

Error fixed on March 9th, 2014: inside InventoryListener.java
Obtaining a reference to Main.debug now works:
        // causes NoSuchMethodError
        // at onEnable() line 20
        this.plugin = instance;
        // causes NullPointerExeception
        // at InventoryListener line 57
        this.plugin = Main.getSelf();
		// This last line worked:
        this.plugin = (Main) Bukkit.getServer().getPluginManager().getPlugin("BattlecraftFlags");
		
		this.plugin = Main.getSelf();
		// causes NPE
2014-03-08 23:37:12 [Server thread][ERROR] Could not pass event InventoryOpenEvent to BattlecraftFlags v0.1
org.bukkit.event.EventException
	at org.bukkit.plugin.java.JavaPluginLoader$1.execute(JavaPluginLoader.java:320) ~[craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at org.bukkit.plugin.RegisteredListener.callEvent(RegisteredListener.java:62) ~[craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at org.bukkit.plugin.SimplePluginManager.fireEvent(SimplePluginManager.java:486) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at org.bukkit.plugin.SimplePluginManager.callEvent(SimplePluginManager.java:471) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at org.bukkit.craftbukkit.v1_7_R1.event.CraftEventFactory.callInventoryOpenEvent(CraftEventFactory.java:578) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.EntityPlayer.openBeacon(EntityPlayer.java:693) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.BlockBeacon.interact(SourceFile:29) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.PlayerInteractManager.interact(PlayerInteractManager.java:383) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.PlayerConnection.a(PlayerConnection.java:628) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.PacketPlayInBlockPlace.a(SourceFile:60) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.PacketPlayInBlockPlace.handle(SourceFile:9) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.NetworkManager.a(NetworkManager.java:146) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.ServerConnection.c(SourceFile:134) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.MinecraftServer.u(MinecraftServer.java:655) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.DedicatedServer.u(DedicatedServer.java:250) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.MinecraftServer.t(MinecraftServer.java:545) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.MinecraftServer.run(MinecraftServer.java:457) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.ThreadServerApplication.run(SourceFile:617) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
Caused by: java.lang.NullPointerException
	at co.battlecraft.Flags.InventoryListener.onInventoryOpen(InventoryListener.java:53) ~[?:?]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:1.6.0_45]
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) ~[?:1.6.0_45]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) ~[?:1.6.0_45]
	at java.lang.reflect.Method.invoke(Unknown Source) ~[?:1.6.0_45]
	at org.bukkit.plugin.java.JavaPluginLoader$1.execute(JavaPluginLoader.java:318) ~[craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	... 17 more
2014-03-08 23:39:30 [Server thread][INFO] CONSOLE: Stopping the server


Error fixed on March 1st, 2014: GameTimer works.
pmap.get(e.getPlayer()) should have been 
pmap.get(e.getPlayer().getName()) 

2014-03-01 21:51:19 [Server thread][ERROR] Could not pass event InventoryCloseEvent to BattlecraftFlags v0.1
org.bukkit.event.EventException
	at org.bukkit.plugin.java.JavaPluginLoader$1.execute(JavaPluginLoader.java:320) ~[craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at org.bukkit.plugin.RegisteredListener.callEvent(RegisteredListener.java:62) ~[craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at org.bukkit.plugin.SimplePluginManager.fireEvent(SimplePluginManager.java:486) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at org.bukkit.plugin.SimplePluginManager.callEvent(SimplePluginManager.java:471) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at org.bukkit.craftbukkit.v1_7_R1.event.CraftEventFactory.handleInventoryCloseEvent(CraftEventFactory.java:701) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.PlayerConnection.a(PlayerConnection.java:1154) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.PacketPlayInCloseWindow.a(PacketPlayInCloseWindow.java:15) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.PacketPlayInCloseWindow.handle(PacketPlayInCloseWindow.java:27) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.NetworkManager.a(NetworkManager.java:146) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.ServerConnection.c(SourceFile:134) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.MinecraftServer.u(MinecraftServer.java:655) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.DedicatedServer.u(DedicatedServer.java:250) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.MinecraftServer.t(MinecraftServer.java:545) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.MinecraftServer.run(MinecraftServer.java:457) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	at net.minecraft.server.v1_7_R1.ThreadServerApplication.run(SourceFile:617) [craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
Caused by: java.lang.NullPointerException
	at co.battlecraft.Flags.InventoryListener.onInventoryClose(InventoryListener.java:65) ~[?:?]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:1.6.0_45]
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) ~[?:1.6.0_45]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) ~[?:1.6.0_45]
	at java.lang.reflect.Method.invoke(Unknown Source) ~[?:1.6.0_45]
	at org.bukkit.plugin.java.JavaPluginLoader$1.execute(JavaPluginLoader.java:318) ~[craftbukkit.jar:git-Bukkit-1.7.2-R0.3-b3020jnks]
	... 14 more