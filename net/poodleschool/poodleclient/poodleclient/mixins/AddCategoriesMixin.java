/*    */ package de.Jakob.navine.mixins;
/*    */ import de.Jakob.navine.Addon;
/*    */ import java.util.function.BiConsumer;
/*    */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*    */ import meteordevelopment.meteorclient.gui.widgets.containers.WContainer;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(targets = {"meteordevelopment.meteorclient.gui.screens.ModulesScreen$WCategoryController"}, remap = false)
/*    */ public abstract class AddCategoriesMixin extends WContainer {
/*    */   @Unique
/* 17 */   private static final Logger LOGGER = LogManager.getLogger("Crystal");
/*    */   
/*    */   @Inject(method = {"init"}, at = {@At("TAIL")})
/*    */   private void addCustomWidgets(CallbackInfo ci) {
/*    */     try {
/* 22 */       Addon.myWidgets.forEach(s -> s.accept(this.theme, this));
/*    */     }
/* 24 */     catch (Exception e) {
/* 25 */       LOGGER.error("An error occurred during AddCategoriesMixin addCustomWidgets:", e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/AddCategoriesMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */