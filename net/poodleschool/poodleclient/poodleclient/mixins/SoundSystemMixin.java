/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.modules.TimerSounds;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import meteordevelopment.meteorclient.systems.modules.world.Timer;
/*    */ import net.minecraft.class_1113;
/*    */ import net.minecraft.class_1140;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1140.class})
/*    */ public class SoundSystemMixin
/*    */ {
/*    */   @Inject(method = {"getAdjustedPitch"}, cancellable = true, at = {@At("RETURN")})
/*    */   public void getAdjustedPitch(class_1113 sound, CallbackInfoReturnable<Float> cir) {
/* 18 */     if (Modules.get().isActive(TimerSounds.class))
/* 19 */       cir.setReturnValue(Float.valueOf((float)(((Float)cir.getReturnValue()).floatValue() * ((Timer)Modules.get().get(Timer.class)).getMultiplier()))); 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/SoundSystemMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */