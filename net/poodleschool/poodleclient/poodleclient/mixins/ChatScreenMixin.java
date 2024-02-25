/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import net.minecraft.class_342;
/*    */ import net.minecraft.class_408;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ 
/*    */ @Mixin({class_408.class})
/*    */ public abstract class ChatScreenMixin
/*    */ {
/*    */   @Shadow
/*    */   protected class_342 field_2382;
/*    */   
/*    */   @Redirect(method = {"sendMessage"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/ChatScreen;normalize(Ljava/lang/String;)Ljava/lang/String;"))
/*    */   String sendMessage(class_408 instance, String chatText) {
/* 18 */     return chatText;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/ChatScreenMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */