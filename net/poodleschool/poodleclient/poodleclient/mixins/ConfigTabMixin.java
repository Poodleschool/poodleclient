/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.util.config.ConfigModifier;
/*    */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*    */ import meteordevelopment.meteorclient.gui.tabs.TabScreen;
/*    */ import meteordevelopment.meteorclient.gui.tabs.builtin.ConfigTab;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin(value = {ConfigTab.class}, remap = false)
/*    */ public class ConfigTabMixin
/*    */ {
/*    */   @Inject(method = {"createScreen"}, at = {@At("HEAD")})
/*    */   private void createScreen(GuiTheme theme, CallbackInfoReturnable<TabScreen> cir) {
/* 17 */     ConfigModifier.get();
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/ConfigTabMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */