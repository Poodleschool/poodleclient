/*     */ package net.poodleschool.poodleclient.poodleclient.util;
/*     */ 
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_287;
/*     */ import net.minecraft.class_290;
/*     */ import net.minecraft.class_293;
/*     */ import net.minecraft.class_757;
/*     */ import org.joml.Matrix4f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends Renderer.R3D.Renderable
/*     */ {
/*     */   null(class_243 pos) {
/* 114 */     super(pos);
/*     */   }
/*     */   void draw() {
/* 117 */     Renderer.R3D.useBuffer(class_293.class_5596.field_27380, class_290.field_1576, class_757::method_34540, bufferBuilder1 -> {
/*     */           double r;
/*     */           for (r = 0.0D; r < 360.0D; r += 360.0D / segments1) {
/*     */             double rad1 = Math.toRadians(r);
/*     */             double sin = Math.sin(rad1);
/*     */             double cos = Math.cos(rad1);
/*     */             double offX = sin * rad;
/*     */             double offY = cos * rad;
/*     */             bufferBuilder1.method_22918(matrix, (float)offX, 0.0F, (float)offY).method_22915(col[0], col[1], col[2], col[3]).method_1344();
/*     */             bufferBuilder1.method_22918(matrix, (float)(offX + sin * width), 0.0F, (float)(offY + cos * width)).method_22915(col[0], col[1], col[2], col[3]).method_1344();
/*     */           } 
/*     */         });
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/Renderer$R3D$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */