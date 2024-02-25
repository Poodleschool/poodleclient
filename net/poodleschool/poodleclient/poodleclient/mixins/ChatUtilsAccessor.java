/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import meteordevelopment.meteorclient.utils.player.ChatUtils;
/*    */ import net.minecraft.class_2561;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.gen.Accessor;
/*    */ 
/*    */ @Mixin(value = {ChatUtils.class}, remap = false, priority = 1500)
/*    */ public interface ChatUtilsAccessor
/*    */ {
/*    */   @Accessor(value = "PREFIX", remap = false)
/*    */   static void setPrefix(class_2561 text) {
/* 13 */     throw new AssertionError();
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/ChatUtilsAccessor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */