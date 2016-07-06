package me.bauer.BauerCam;

import java.io.File;

import org.lwjgl.input.Keyboard;

import me.bauer.BauerCam.Commands.CamCommand;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = Main.modId, version = Main.version, clientSideOnly = true, acceptedMinecraftVersions = Main.minecraftTargetVersion)
public final class Main {

	public static final String modId = "BauerCam";
	public static final String version = "1.7";
	public static final String minecraftTargetVersion = "1.10.2";

	public final static KeyBinding point = new KeyBinding("bauercam.key.addPoint", Keyboard.KEY_P, modId);
	public final static KeyBinding cameraClock = new KeyBinding("bauercam.key.clockwise", Keyboard.KEY_L, modId);
	public final static KeyBinding cameraCounterClock = new KeyBinding("bauercam.key.counterClockwise", Keyboard.KEY_J,
			modId);
	public final static KeyBinding cameraReset = new KeyBinding("bauercam.key.reset", Keyboard.KEY_K, modId);

	public final static File bauercamDirectory = new File("bauercam");

	static {
		if (!bauercamDirectory.isDirectory()) {
			bauercamDirectory.mkdir();
		}
	}

	@Mod.EventHandler
	public void init(final FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new EventListener());
		ClientCommandHandler.instance.registerCommand(new CamCommand());
	}

	@Mod.EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		ClientRegistry.registerKeyBinding(point);
		ClientRegistry.registerKeyBinding(cameraClock);
		ClientRegistry.registerKeyBinding(cameraCounterClock);
		ClientRegistry.registerKeyBinding(cameraReset);
	}

	/**
	 * Localized strings
	 */

	public final static LocalizedString pathStarted = new LocalizedString("bauercam.path.started");
	public final static LocalizedString pathStopped = new LocalizedString("bauercam.path.stopped");
	public final static LocalizedString pathIsEmpty = new LocalizedString("bauercam.path.isEmpty");
	public final static LocalizedString pathUndo = new LocalizedString("bauercam.path.undo");
	public final static LocalizedString pathDoesNotExist = new LocalizedString("bauercam.path.doesNotExist");
	public final static LocalizedString pathReset = new LocalizedString("bauercam.path.reset");
	public final static LocalizedString pathReplace = new LocalizedString("bauercam.path.replace");
	public final static LocalizedString pathAdd = new LocalizedString("bauercam.path.add");

	public final static LocalizedString commands = new LocalizedString("bauercam.cmd.commands");
	public final static LocalizedString commandHasToBePlayer = new LocalizedString("bauercam.cmd.hasToBePlayer");
	public final static LocalizedString commandTravelledTo = new LocalizedString("bauercam.cmd.travelledTo");
	public final static LocalizedString commandAtLeastTwoPoints = new LocalizedString("bauercam.cmd.atLeastTwoPoints");
	public final static LocalizedString commandInvalidFrames = new LocalizedString("bauercam.cmd.invalidFrames");

	public final static LocalizedString exportSuccessful = new LocalizedString("bauercam.exporter.successfulWrite");
	public final static LocalizedString importSuccessful = new LocalizedString("bauercam.exporter.successfulRead");
	public final static LocalizedString IOError = new LocalizedString("bauercam.exporter.IOError");
	public final static LocalizedString positionCannotBeParsed = new LocalizedString(
			"bauercam.exporter.posCannotBeParsed");
	public final static LocalizedString fileDoesNotExist = new LocalizedString("bauercam.exporter.fileDoesNotExist");

}
