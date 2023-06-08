package me.char321.mixin;

import me.char321.AdvancementScreenshotMod;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "tick", at=@At("TAIL"))
    public void ontick(CallbackInfo ci){
        AdvancementScreenshotMod.tick();
    }
}
