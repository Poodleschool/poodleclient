/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.modules.BlockAnimation;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import net.minecraft.class_759;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyVariable;
/*    */ 
/*    */ 
/*    */ @Mixin({class_759.class})
/*    */ public class HeldItemRendererMixin
/*    */ {
/*    */   @ModifyVariable(method = {"renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"}, at = @At(value = "STORE", ordinal = 0), index = 6)
/*    */   private float modifySwing(float swingProgress) {
/* 16 */     BlockAnimation module = (BlockAnimation)Modules.get().get(BlockAnimation.class);
/*    */     
/* 18 */     if (module.isBlocking()) {
/* 19 */       return 0.0F;
/*    */     }
/*    */     
/* 22 */     return swingProgress;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/HeldItemRendererMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */