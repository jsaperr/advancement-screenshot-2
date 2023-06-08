package me.char321;

import net.fabricmc.api.ModInitializer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancementScreenshotMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("advancement-screenshot-2");
	private static long screenshotTimer;
	private static MinecraftClient client;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

	}


	public static void scheduleScreenshot(MinecraftClient client) {
		screenshotTimer = 20;
		AdvancementScreenshotMod.client = client;
	}

	public static void tick() {
		if (--screenshotTimer == 0) {
			ScreenshotRecorder.saveScreenshot(client.runDirectory, client.getFramebuffer(), message -> client.execute(() -> client.inGameHud.getChatHud().addMessage((Text)message)));
		}
	}
}