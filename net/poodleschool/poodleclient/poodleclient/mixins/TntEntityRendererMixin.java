/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.modules.TNTTimer;
/*    */ import java.text.DecimalFormat;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import net.minecraft.class_124;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1541;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_4587;
/*    */ import net.minecraft.class_4597;
/*    */ import net.minecraft.class_5617;
/*    */ import net.minecraft.class_897;
/*    */ import net.minecraft.class_956;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({class_956.class})
/*    */ public abstract class TntEntityRendererMixin extends class_897<class_1541> {
/*    */   protected TntEntityRendererMixin(class_5617.class_5618 ctx) {
/* 25 */     super(ctx);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"render(Lnet/minecraft/entity/TntEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/EntityRenderer;render(Lnet/minecraft/entity/Entity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V")})
/*    */   private void renderTntLabel(class_1541 entity, float yaw, float delta, class_4587 matrixStack, class_4597 vertexConsumerProvider, int light, CallbackInfo ci) {
/* 34 */     if (Modules.get().isActive(TNTTimer.class))
/* 35 */       method_3926((class_1297)entity, getTime(entity.method_6969()), matrixStack, vertexConsumerProvider, light); 
/*    */   }
/*    */   
/*    */   @Unique
/* 39 */   private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
/*    */   
/*    */   @Unique
/*    */   private static class_2561 getTime(double ticks) {
/* 43 */     class_124 format = class_124.field_1068;
/* 44 */     boolean colored = areChatColors();
/*    */     
/* 46 */     double timing = ticks / 20.0D;
/*    */     
/* 48 */     if (!colored) {
/* 49 */       return (class_2561)class_2561.method_30163(decimalFormat.format(timing)).method_27661().method_27692(class_124.field_1068);
/*    */     }
/* 51 */     if (timing > 7.0D) {
/* 52 */       format = class_124.field_1062;
/* 53 */     } else if (timing > 6.0D) {
/* 54 */       format = class_124.field_1075;
/* 55 */     } else if (timing > 4.0D) {
/* 56 */       format = class_124.field_1077;
/* 57 */     } else if (timing > 3.0D) {
/* 58 */       format = class_124.field_1060;
/* 59 */     } else if (timing > 2.0D) {
/* 60 */       format = class_124.field_1065;
/* 61 */     } else if (timing > 1.0D) {
/* 62 */       format = class_124.field_1061;
/* 63 */     } else if (timing > 0.0D) {
/* 64 */       format = class_124.field_1079;
/*    */     } 
/* 66 */     return (class_2561)class_2561.method_30163(decimalFormat.format(timing)).method_27661().method_27692(format);
/*    */   }
/*    */ 
/*    */   
/*    */   private static boolean areChatColors() {
/* 71 */     return ((Boolean)(class_310.method_1551()).field_1690.method_42427().method_41753()).booleanValue();
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/TntEntityRendererMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */