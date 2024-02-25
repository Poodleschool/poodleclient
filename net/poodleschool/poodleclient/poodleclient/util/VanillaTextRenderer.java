/*     */ package net.poodleschool.poodleclient.poodleclient.util;
/*     */ 
/*     */ import com.mojang.blaze3d.systems.RenderSystem;
/*     */ import java.util.Objects;
/*     */ import meteordevelopment.meteorclient.MeteorClient;
/*     */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*     */ import net.minecraft.class_2561;
/*     */ import net.minecraft.class_287;
/*     */ import net.minecraft.class_327;
/*     */ import net.minecraft.class_4587;
/*     */ import net.minecraft.class_4597;
/*     */ import net.minecraft.class_5348;
/*     */ import org.joml.Matrix4f;
/*     */ 
/*     */ public class VanillaTextRenderer {
/*  16 */   public static final VanillaTextRenderer INSTANCE = new VanillaTextRenderer();
/*     */   
/*  18 */   private final class_287 buffer = new class_287(2048);
/*  19 */   private final class_4597.class_4598 immediate = class_4597.method_22991(this.buffer);
/*     */   
/*  21 */   private final class_4587 matrices = new class_4587();
/*  22 */   private final Matrix4f emptyMatrix = new Matrix4f();
/*     */   
/*  24 */   public double scale = 2.0D;
/*     */   
/*     */   public boolean scaleIndividually;
/*     */   private boolean building;
/*  28 */   private double alpha = 1.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlpha(double a) {
/*  35 */     this.alpha = a;
/*     */   }
/*     */   
/*     */   public double getWidth(class_2561 text, boolean shadow) {
/*  39 */     return (MeteorClient.mc.field_1772.method_27525((class_5348)text) + (shadow ? 1 : 0)) * this.scale;
/*     */   }
/*     */   
/*     */   public double getHeight(boolean shadow) {
/*  43 */     Objects.requireNonNull(MeteorClient.mc.field_1772); return (9 + (shadow ? 1 : 0)) * this.scale;
/*     */   }
/*     */   
/*     */   public void begin(double scale) {
/*  47 */     if (this.building) throw new RuntimeException("VanillaTextRenderer.begin() called twice");
/*     */     
/*  49 */     this.scale = scale * 2.0D;
/*  50 */     this.building = true;
/*     */   }
/*     */   
/*     */   public double render(class_2561 text, double x, double y, Color color, boolean shadow) {
/*  54 */     boolean wasBuilding = this.building;
/*  55 */     if (!wasBuilding) begin(1.0D);
/*     */     
/*  57 */     x += 0.5D * this.scale;
/*  58 */     y += 0.5D * this.scale;
/*     */     
/*  60 */     int preA = color.a;
/*  61 */     color.a = (int)((color.a / 255) * this.alpha * 255.0D);
/*     */     
/*  63 */     Matrix4f matrix = this.emptyMatrix;
/*  64 */     if (this.scaleIndividually) {
/*  65 */       this.matrices.method_22903();
/*  66 */       this.matrices.method_22905((float)this.scale, (float)this.scale, 1.0F);
/*  67 */       matrix = this.matrices.method_23760().method_23761();
/*     */     } 
/*     */     
/*  70 */     double x2 = MeteorClient.mc.field_1772.method_30882(text, (float)(x / this.scale), (float)(y / this.scale), color.getPacked(), shadow, matrix, (class_4597)this.immediate, class_327.class_6415.field_33993, 0, 15728880);
/*     */     
/*  72 */     if (this.scaleIndividually) this.matrices.method_22909();
/*     */     
/*  74 */     color.a = preA;
/*     */     
/*  76 */     if (!wasBuilding) end(null); 
/*  77 */     return (x2 - 1.0D) * this.scale;
/*     */   }
/*     */   
/*     */   public boolean isBuilding() {
/*  81 */     return this.building;
/*     */   }
/*     */   
/*     */   public void end(class_4587 matrices) {
/*  85 */     if (!this.building) throw new RuntimeException("VanillaTextRenderer.end() called without calling begin()");
/*     */     
/*  87 */     class_4587 matrixStack = RenderSystem.getModelViewStack();
/*     */     
/*  89 */     RenderSystem.disableDepthTest();
/*  90 */     matrixStack.method_22903();
/*  91 */     if (matrices != null) matrixStack.method_34425(matrices.method_23760().method_23761()); 
/*  92 */     if (!this.scaleIndividually) matrixStack.method_22905((float)this.scale, (float)this.scale, 1.0F); 
/*  93 */     RenderSystem.applyModelViewMatrix();
/*     */     
/*  95 */     this.immediate.method_22993();
/*     */     
/*  97 */     matrixStack.method_22909();
/*  98 */     RenderSystem.enableDepthTest();
/*  99 */     RenderSystem.applyModelViewMatrix();
/*     */     
/* 101 */     this.scale = 2.0D;
/* 102 */     this.building = false;
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/VanillaTextRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */