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
/* 211 */     super(pos);
/*     */   }
/*     */   void draw() {
/* 214 */     Renderer.R3D.useBuffer(class_293.class_5596.field_27382, class_290.field_1576, class_757::method_34540, buffer -> {
/*     */           buffer.method_22918(matrix, x1, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           
/*     */           buffer.method_22918(matrix, x1, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           
/*     */           buffer.method_22918(matrix, x2, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           
/*     */           buffer.method_22918(matrix, x2, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           
/*     */           buffer.method_22918(matrix, x1, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           
/*     */           buffer.method_22918(matrix, x2, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           
/*     */           buffer.method_22918(matrix, x2, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x2, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x2, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x2, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */         });
/* 246 */     Renderer.R3D.useBuffer(class_293.class_5596.field_29344, class_290.field_1576, class_757::method_34540, buffer -> {
/*     */           buffer.method_22918(matrix, x1, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x2, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */           buffer.method_22918(matrix, x1, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */         });
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/Renderer$R3D$3.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */