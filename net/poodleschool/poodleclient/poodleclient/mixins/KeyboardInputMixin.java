/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.modules.AutoSneakAt;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import net.minecraft.class_743;
/*    */ import net.minecraft.class_744;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({class_743.class})
/*    */ public class KeyboardInputMixin
/*    */   extends class_744 {
/*    */   @Inject(method = {"tick"}, at = {@At("TAIL")})
/*    */   private void isPressed(boolean slowDown, float f, CallbackInfo ci) {
/* 17 */     if (((AutoSneakAt)Modules.get().get(AutoSneakAt.class)).doSneak()) this.field_3903 = true; 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/KeyboardInputMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */