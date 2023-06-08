package me.char321.mixin;

import me.char321.AdvancementScreenshotMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientAdvancementManager;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientAdvancementManager.class)
public class AdvancementManagerMixin {

	@Shadow @Final private MinecraftClient client;

	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/toast/ToastManager;add(Lnet/minecraft/client/toast/Toast;)V", shift = At.Shift.AFTER), method = "onAdvancements")
	private void screenshot(CallbackInfo info) {
		AdvancementScreenshotMod.scheduleScreenshot(client);
	}
}