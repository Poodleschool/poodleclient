/*    */ package de.Jakob.navine.mixins;
/*    */ 
/*    */ import de.Jakob.navine.modules.NavineNametags;
/*    */ import java.text.DecimalFormat;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_327;
/*    */ import net.minecraft.class_4587;
/*    */ import net.minecraft.class_4597;
/*    */ import net.minecraft.class_5250;
/*    */ import net.minecraft.class_5348;
/*    */ import net.minecraft.class_897;
/*    */ import org.joml.Matrix4f;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({class_897.class})
/*    */ public abstract class EntityRendererMixin<T extends class_1297> {
/*    */   @Shadow
/*    */   public abstract class_327 method_3932();
/*    */   
/*    */   @Unique
/* 30 */   class_310 minecraft = class_310.method_1551();
/*    */ 
/*    */   
/*    */   @Inject(method = {"renderLabelIfPresent"}, at = {@At("TAIL")})
/*    */   protected void renderLabelIfPresent(T entity, class_2561 text, class_4587 matrices, class_4597 vertexConsumers, int light, CallbackInfo callbackInfo) {
/* 35 */     if (entity instanceof class_1657) { class_1657 player = (class_1657)entity; if (Modules.get().isActive(NavineNametags.class)) {
/*    */         
/* 37 */         DecimalFormat df = new DecimalFormat("#.#");
/* 38 */         class_5250 class_52501 = class_2561.method_43470(String.format("%s §a↔ %s", new Object[] { getHealth(player, df), df
/* 39 */                 .format(player.method_5739((class_1297)this.minecraft.field_1724)) }));
/* 40 */         class_5250 class_52502 = class_2561.method_43470(String.format("§d%s %s %s", new Object[] { df.format((player.method_19538()).field_1352), df
/* 41 */                 .format((player.method_19538()).field_1351), df.format((player.method_19538()).field_1350) }));
/*    */         
/* 43 */         double d = this.minecraft.method_1561().method_23168((class_1297)player);
/* 44 */         if (d <= 4096.0D) {
/*    */           
/* 46 */           boolean isNotSneaky = !player.method_21751();
/* 47 */           class_327 textRenderer = method_3932();
/*    */           
/* 49 */           float backgroundOpacity = this.minecraft.field_1690.method_19343(0.25F);
/* 50 */           int backgroundColor = (int)(backgroundOpacity * 255.0F) << 24;
/*    */           
/* 52 */           float f = player.method_17682() + 0.5F;
/* 53 */           matrices.method_22903();
/* 54 */           matrices.method_22904(0.0D, f, 0.0D);
/* 55 */           matrices.method_22907(this.minecraft.method_1561().method_24197());
/* 56 */           matrices.method_22905(-0.025F, -0.025F, 0.025F);
/* 57 */           Matrix4f matrix4f = matrices.method_23760().method_23761();
/*    */           
/* 59 */           float infoRow1X = (-textRenderer.method_27525((class_5348)class_52501) / 2);
/* 60 */           float infoRow2X = (-textRenderer.method_27525((class_5348)class_52502) / 2);
/* 61 */           float textX = (-textRenderer.method_27525((class_5348)text) / 2);
/* 62 */           int y = -10;
/*    */ 
/*    */           
/* 65 */           textRenderer.method_30882((class_2561)class_52501, infoRow1X, y - 10.0F, 553648127, false, matrix4f, vertexConsumers, isNotSneaky ? class_327.class_6415.field_33994 : class_327.class_6415.field_33993, backgroundColor, light);
/* 66 */           textRenderer.method_30882((class_2561)class_52502, infoRow2X, y, 553648127, false, matrix4f, vertexConsumers, isNotSneaky ? class_327.class_6415.field_33994 : class_327.class_6415.field_33993, backgroundColor, light);
/*    */           
/* 68 */           if (isNotSneaky) {
/*    */             
/* 70 */             textRenderer.method_30882((class_2561)class_52501, infoRow1X, y - 10.0F, -1, false, matrix4f, vertexConsumers, class_327.class_6415.field_33993, 0, light);
/* 71 */             textRenderer.method_30882((class_2561)class_52502, infoRow2X, y, -1, false, matrix4f, vertexConsumers, class_327.class_6415.field_33993, 0, light);
/*    */           } 
/* 73 */           matrices.method_22909();
/*    */         } 
/*    */       }  }
/*    */   
/*    */   }
/*    */   @Unique
/*    */   private static String getHealth(class_1657 player, DecimalFormat df) {
/* 80 */     float Health = player.method_6032() + player.method_6067();
/* 81 */     return (Health > 20.0F) ? ("§6❤" + 
/* 82 */       df.format(Health)) : (
/* 83 */       (Health >= 15.0D && Health <= 20.9D) ? ("§a❤" + 
/* 84 */       df.format(Health)) : (
/* 85 */       (Health >= 10.0D && Health <= 14.9D) ? ("§e❤" + 
/* 86 */       df.format(Health)) : (
/* 87 */       (Health >= 5.0D && Health <= 9.9D) ? ("§c❤" + 
/* 88 */       df.format(Health)) : (
/* 89 */       (Health >= 1.0D && Health <= 4.9D) ? ("§4❤" + 
/* 90 */       df.format(Health)) : ("§0❤" + 
/*    */       
/* 92 */       df.format(Health))))));
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/mixins/EntityRendererMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */