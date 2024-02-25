/*     */ package net.poodleschool.poodleclient.poodleclient.util;
/*     */ 
/*     */ import com.mojang.blaze3d.systems.RenderSystem;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_286;
/*     */ import net.minecraft.class_287;
/*     */ import net.minecraft.class_289;
/*     */ import net.minecraft.class_290;
/*     */ import net.minecraft.class_293;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_3532;
/*     */ import net.minecraft.class_4184;
/*     */ import net.minecraft.class_4587;
/*     */ import net.minecraft.class_5944;
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
/*     */ public class R3D
/*     */ {
/*  48 */   static final class_4587 empty = new class_4587();
/*  49 */   static final List<FadingBlock> fades = new CopyOnWriteArrayList<>();
/*  50 */   static List<Renderable> currentStack = new ArrayList<>();
/*     */   
/*     */   public static void renderFadingBlock(Color outlineColor, Color fillColor, class_243 start, class_243 dimensions, long lifeTimeMs) {
/*  53 */     FadingBlock fb = new FadingBlock(outlineColor, fillColor, start, dimensions, System.currentTimeMillis(), lifeTimeMs);
/*     */     
/*  55 */     fades.removeIf(fadingBlock -> (fadingBlock.start.equals(start) && fadingBlock.dimensions.equals(dimensions)));
/*  56 */     fades.add(fb);
/*     */   }
/*     */   
/*     */   public static void renderFadingBlocks(class_4587 stack) {
/*  60 */     fades.removeIf(FadingBlock::isDead);
/*  61 */     for (FadingBlock fade : fades) {
/*  62 */       if (fade == null) {
/*     */         continue;
/*     */       }
/*  65 */       long lifetimeLeft = fade.getLifeTimeLeft();
/*  66 */       double progress = lifetimeLeft / fade.lifeTime;
/*  67 */       progress = class_3532.method_15350(progress, 0.0D, 1.0D);
/*  68 */       double ip = 1.0D - progress;
/*  69 */       Color out = Renderer.Util.modify(fade.outline, -1, -1, -1, (int)(fade.outline.getAlpha() * progress));
/*  70 */       Color fill = Renderer.Util.modify(fade.fill, -1, -1, -1, (int)(fade.fill.getAlpha() * progress));
/*  71 */       renderEdged(stack, fill, out, fade.start
/*     */ 
/*     */ 
/*     */           
/*  75 */           .method_1019((new class_243(0.2D, 0.2D, 0.2D)).method_1021(ip)), fade.dimensions
/*  76 */           .method_1020((new class_243(0.4D, 0.4D, 0.4D)).method_1021(ip)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static class_243 transformVec3d(class_243 in) {
/*  82 */     class_4184 camera = (class_310.method_1551()).field_1773.method_19418();
/*  83 */     class_243 camPos = camera.method_19326();
/*  84 */     return in.method_1020(camPos);
/*     */   }
/*     */   
/*     */   static float[] getColor(Color c) {
/*  88 */     return new float[] { c.getRed() / 255.0F, c.getGreen() / 255.0F, c.getBlue() / 255.0F, Renderer.transformColor(c.getAlpha() / 255.0F) };
/*     */   }
/*     */   
/*     */   private static void useBuffer(class_293.class_5596 mode, class_293 format, Supplier<class_5944> shader, Consumer<class_287> runner) {
/*  92 */     class_289 t = class_289.method_1348();
/*  93 */     class_287 bb = t.method_1349();
/*     */     
/*  95 */     bb.method_1328(mode, format);
/*     */     
/*  97 */     runner.accept(bb);
/*     */     
/*  99 */     Renderer.setupRender();
/* 100 */     RenderSystem.setShader(shader);
/* 101 */     class_286.method_43433(bb.method_1326());
/* 102 */     Renderer.endRender();
/*     */   }
/*     */   
/*     */   public static void renderCircleOutline(class_4587 stack, Color c, class_243 start, final double rad, final double width, double segments) {
/* 106 */     stack.method_22903();
/* 107 */     class_243 vec3d = transformVec3d(start);
/* 108 */     stack.method_22904(vec3d.field_1352, vec3d.field_1351, vec3d.field_1350);
/* 109 */     final double segments1 = class_3532.method_15350(segments, 2.0D, 90.0D);
/*     */     
/* 111 */     final Matrix4f matrix = stack.method_23760().method_23761();
/* 112 */     stack.method_22909();
/* 113 */     final float[] col = getColor(c);
/* 114 */     doAction(new Renderable(start)
/*     */         {
/*     */           void draw() {
/* 117 */             Renderer.R3D.useBuffer(class_293.class_5596.field_27380, class_290.field_1576, class_757::method_34540, bufferBuilder1 -> {
/*     */                   double r;
/*     */                   for (r = 0.0D; r < 360.0D; r += 360.0D / segments1) {
/*     */                     double rad1 = Math.toRadians(r);
/*     */                     double sin = Math.sin(rad1);
/*     */                     double cos = Math.cos(rad1);
/*     */                     double offX = sin * rad;
/*     */                     double offY = cos * rad;
/*     */                     bufferBuilder1.method_22918(matrix, (float)offX, 0.0F, (float)offY).method_22915(col[0], col[1], col[2], col[3]).method_1344();
/*     */                     bufferBuilder1.method_22918(matrix, (float)(offX + sin * width), 0.0F, (float)(offY + cos * width)).method_22915(col[0], col[1], col[2], col[3]).method_1344();
/*     */                   } 
/*     */                 });
/*     */           }
/*     */         });
/*     */   }
/*     */   static void doAction(Renderable ac) {
/* 133 */     currentStack.add(ac);
/*     */   }
/*     */   
/*     */   public static void renderOutline(class_4587 stack, final Color color, final class_243 start, final class_243 dimensions) {
/* 137 */     final Matrix4f m = stack.method_23760().method_23761();
/* 138 */     doAction(new Renderable(start.method_1019(dimensions.method_1021(0.5D)))
/*     */         {
/*     */           void draw() {
/* 141 */             Renderer.R3D.genericAABBRender(class_293.class_5596.field_29344, class_290.field_1576, class_757::method_34540, m, start, dimensions, color, (buffer, x1, y1, z1, x2, y2, z2, red, green, blue, alpha, matrix) -> {
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                 });
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class_4587 getEmptyMatrixStack() {
/* 186 */     empty.method_34426();
/* 187 */     return empty;
/*     */   }
/*     */   
/*     */   public static void renderEdged(class_4587 stack, Color colorFill, Color colorOutline, class_243 start, class_243 dimensions) {
/* 191 */     final Matrix4f matrix = stack.method_23760().method_23761();
/* 192 */     float[] fill = getColor(colorFill);
/* 193 */     float[] outline = getColor(colorOutline);
/*     */     
/* 195 */     class_243 vec3d = transformVec3d(start);
/* 196 */     class_243 end = vec3d.method_1019(dimensions);
/* 197 */     final float x1 = (float)vec3d.field_1352;
/* 198 */     final float y1 = (float)vec3d.field_1351;
/* 199 */     final float z1 = (float)vec3d.field_1350;
/* 200 */     final float x2 = (float)end.field_1352;
/* 201 */     final float y2 = (float)end.field_1351;
/* 202 */     final float z2 = (float)end.field_1350;
/* 203 */     final float redFill = fill[0];
/* 204 */     final float greenFill = fill[1];
/* 205 */     final float blueFill = fill[2];
/* 206 */     final float alphaFill = fill[3];
/* 207 */     final float redOutline = outline[0];
/* 208 */     final float greenOutline = outline[1];
/* 209 */     final float blueOutline = outline[2];
/* 210 */     final float alphaOutline = outline[3];
/* 211 */     doAction(new Renderable(start.method_1019(dimensions.method_1021(0.5D)))
/*     */         {
/*     */           void draw() {
/* 214 */             Renderer.R3D.useBuffer(class_293.class_5596.field_27382, class_290.field_1576, class_757::method_34540, buffer -> {
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(redFill, greenFill, blueFill, alphaFill).method_1344();
/*     */                 });
/* 246 */             Renderer.R3D.useBuffer(class_293.class_5596.field_29344, class_290.field_1576, class_757::method_34540, buffer -> {
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(redOutline, greenOutline, blueOutline, alphaOutline).method_1344();
/*     */                 });
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void genericAABBRender(class_293.class_5596 mode, class_293 format, Supplier<class_5944> shader, Matrix4f stack, class_243 start, class_243 dimensions, Color color, RenderAction action) {
/* 283 */     float red = color.getRed() / 255.0F;
/* 284 */     float green = color.getGreen() / 255.0F;
/* 285 */     float blue = color.getBlue() / 255.0F;
/* 286 */     float alpha = Renderer.transformColor(color.getAlpha() / 255.0F);
/* 287 */     class_243 vec3d = transformVec3d(start);
/* 288 */     class_243 end = vec3d.method_1019(dimensions);
/* 289 */     float x1 = (float)vec3d.field_1352;
/* 290 */     float y1 = (float)vec3d.field_1351;
/* 291 */     float z1 = (float)vec3d.field_1350;
/* 292 */     float x2 = (float)end.field_1352;
/* 293 */     float y2 = (float)end.field_1351;
/* 294 */     float z2 = (float)end.field_1350;
/* 295 */     useBuffer(mode, format, shader, bufferBuilder -> action.run(bufferBuilder, x1, y1, z1, x2, y2, z2, red, green, blue, alpha, stack));
/*     */   }
/*     */   
/*     */   public static void renderFilled(class_4587 stack, final Color color, final class_243 start, final class_243 dimensions) {
/* 299 */     final Matrix4f s = stack.method_23760().method_23761();
/* 300 */     doAction(new Renderable(start.method_1019(dimensions.method_1021(0.5D)))
/*     */         {
/*     */           void draw() {
/* 303 */             Renderer.R3D.genericAABBRender(class_293.class_5596.field_27382, class_290.field_1576, class_757::method_34540, s, start, dimensions, color, (buffer, x1, y1, z1, x2, y2, z2, red, green, blue, alpha, matrix) -> {
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y2, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x2, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z2).method_22915(red, green, blue, alpha).method_1344();
/*     */                 });
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderLine(class_4587 matrices, final Color color, final class_243 start, final class_243 end) {
/* 348 */     final Matrix4f s = matrices.method_23760().method_23761();
/* 349 */     doAction(new Renderable(start.method_1019(end.method_1020(start)).method_1021(0.5D))
/*     */         {
/*     */           void draw() {
/* 352 */             Renderer.R3D.genericAABBRender(class_293.class_5596.field_29344, class_290.field_1576, class_757::method_34540, s, start, end
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 358 */                 .method_1020(start), color, (buffer, x, y, z, x1, y1, z1, red, green, blue, alpha, matrix) -> {
/*     */                   buffer.method_22918(matrix, x, y, z).method_22915(red, green, blue, alpha).method_1344();
/*     */                   buffer.method_22918(matrix, x1, y1, z1).method_22915(red, green, blue, alpha).method_1344();
/*     */                 });
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class_243 getCrosshairVector() {
/* 370 */     class_4184 camera = (class_310.method_1551()).field_1773.method_19418();
/*     */     
/* 372 */     float pi = 3.1415927F;
/* 373 */     float yawRad = (float)Math.toRadians(-camera.method_19330());
/* 374 */     float pitchRad = (float)Math.toRadians(-camera.method_19329());
/* 375 */     float f1 = class_3532.method_15362(yawRad - pi);
/* 376 */     float f2 = class_3532.method_15374(yawRad - pi);
/* 377 */     float f3 = -class_3532.method_15362(pitchRad);
/* 378 */     float f4 = class_3532.method_15374(pitchRad);
/*     */     
/* 380 */     return (new class_243((f2 * f3), f4, (f1 * f3))).method_1019(camera.method_19326());
/*     */   }
/*     */   
/*     */   public static void renderActions() {
/* 384 */     class_4184 c = (class_310.method_1551()).field_1773.method_19418();
/* 385 */     class_243 cp = c.method_19326();
/* 386 */     currentStack.stream().sorted(Comparator.comparingDouble(value -> -value.pos.method_1022(cp))).forEach(Renderable::draw);
/* 387 */     currentStack.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static abstract class Renderable
/*     */   {
/*     */     class_243 pos;
/*     */ 
/*     */     
/*     */     public Renderable(class_243 pos) {
/* 398 */       this.pos = pos;
/*     */     }
/*     */     
/*     */     abstract void draw();
/*     */     
/*     */     public class_243 getPos() {
/* 404 */       return this.pos;
/*     */     } }
/*     */   static final class FadingBlock extends Record { private final Color outline; private final Color fill; private final class_243 start; private final class_243 dimensions; private final long created; private final long lifeTime;
/*     */     
/* 408 */     FadingBlock(Color outline, Color fill, class_243 start, class_243 dimensions, long created, long lifeTime) { this.outline = outline; this.fill = fill; this.start = start; this.dimensions = dimensions; this.created = created; this.lifeTime = lifeTime; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lde/Jakob/navine/util/Renderer$R3D$FadingBlock;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #408	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/* 408 */       //   0	7	0	this	Lde/Jakob/navine/util/Renderer$R3D$FadingBlock; } public Color outline() { return this.outline; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lde/Jakob/navine/util/Renderer$R3D$FadingBlock;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #408	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lde/Jakob/navine/util/Renderer$R3D$FadingBlock; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lde/Jakob/navine/util/Renderer$R3D$FadingBlock;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #408	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lde/Jakob/navine/util/Renderer$R3D$FadingBlock;
/* 408 */       //   0	8	1	o	Ljava/lang/Object; } public Color fill() { return this.fill; } public class_243 start() { return this.start; } public class_243 dimensions() { return this.dimensions; } public long created() { return this.created; } public long lifeTime() { return this.lifeTime; }
/*     */      long getLifeTimeLeft() {
/* 410 */       return Math.max(0L, this.created - System.currentTimeMillis() + this.lifeTime);
/*     */     }
/*     */     
/*     */     boolean isDead() {
/* 414 */       return (getLifeTimeLeft() == 0L);
/*     */     } }
/*     */ 
/*     */   
/*     */   static interface RenderAction {
/*     */     void run(class_287 param2class_287, float param2Float1, float param2Float2, float param2Float3, float param2Float4, float param2Float5, float param2Float6, float param2Float7, float param2Float8, float param2Float9, float param2Float10, Matrix4f param2Matrix4f);
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/Renderer$R3D.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */