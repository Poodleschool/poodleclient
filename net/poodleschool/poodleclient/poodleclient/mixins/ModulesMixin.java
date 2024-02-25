/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.events.ModuleToggleEvent;
/*    */ import meteordevelopment.meteorclient.MeteorClient;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(value = {Modules.class}, remap = false)
/*    */ public class ModulesMixin
/*    */ {
/*    */   @Inject(method = {"addActive"}, at = {@At("HEAD")})
/*    */   private void addActive(Module module, CallbackInfo ci) {
/* 17 */     MeteorClient.EVENT_BUS.post(new ModuleToggleEvent(module, true));
/*    */   }
/*    */   
/*    */   @Inject(method = {"removeActive"}, at = {@At("HEAD")})
/*    */   private void removeActive(Module module, CallbackInfo ci) {
/* 22 */     MeteorClient.EVENT_BUS.post(new ModuleToggleEvent(module, false));
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/ModulesMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */