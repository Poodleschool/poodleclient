/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.modules.BlockAnimation;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import meteordevelopment.meteorclient.systems.modules.render.HandView;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin(value = {HandView.class}, remap = false)
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class HandViewMixin
/*    */ {
/*    */   @Inject(method = {"oldAnimations"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void oldAnimations(CallbackInfoReturnable<Boolean> cir) {
/* 19 */     if (Modules.get().isActive(BlockAnimation.class))
/* 20 */       cir.setReturnValue(Boolean.valueOf(true)); 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/HandViewMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */