/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.modules.GrimNoSlow;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import meteordevelopment.meteorclient.systems.modules.movement.NoSlow;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin(value = {NoSlow.class}, remap = false)
/*    */ public class NoSlowMixin
/*    */ {
/*    */   @Inject(method = {"items"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void items(CallbackInfoReturnable<Boolean> cir) {
/* 16 */     if (((GrimNoSlow)Modules.get().get(GrimNoSlow.class)).canNoSlow())
/* 17 */       cir.setReturnValue(Boolean.valueOf(true)); 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/NoSlowMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */