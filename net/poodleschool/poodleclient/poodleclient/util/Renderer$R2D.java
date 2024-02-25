/*      */ package net.poodleschool.poodleclient.poodleclient.util;
/*      */ 
/*      */ import com.mojang.blaze3d.systems.RenderSystem;
/*      */ import java.awt.Color;
/*      */ import net.minecraft.class_241;
/*      */ import net.minecraft.class_243;
/*      */ import net.minecraft.class_286;
/*      */ import net.minecraft.class_287;
/*      */ import net.minecraft.class_289;
/*      */ import net.minecraft.class_290;
/*      */ import net.minecraft.class_293;
/*      */ import net.minecraft.class_310;
/*      */ import net.minecraft.class_3532;
/*      */ import net.minecraft.class_4184;
/*      */ import net.minecraft.class_4587;
/*      */ import net.minecraft.class_757;
/*      */ import net.minecraft.class_7833;
/*      */ import org.joml.Matrix4f;
/*      */ import org.joml.Matrix4fc;
/*      */ import org.joml.Vector3f;
/*      */ import org.joml.Vector4f;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class R2D
/*      */ {
/*      */   public static class_241 renderTooltip(class_4587 stack, Color color, double arrowX, double arrowY, double width, double height, boolean renderUpsideDown) {
/*  434 */     double centerX = class_310.method_1551().method_22683().method_4486() / 2.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  449 */     boolean placeLeft = (centerX < arrowX);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  464 */     double arrowDimX = 10.0D;
/*  465 */     double arrowDimY = 5.0D;
/*  466 */     double roundStartX = placeLeft ? (arrowX + arrowDimX / 2.0D + 10.0D - width) : (arrowX - arrowDimX / 2.0D - 10.0D);
/*  467 */     double roundStartY = renderUpsideDown ? (arrowY - arrowDimY - height) : (arrowY + arrowDimY);
/*  468 */     Matrix4f mat = stack.method_23760().method_23761();
/*      */     
/*  470 */     Renderer.setupRender();
/*  471 */     RenderSystem.setShader(class_757::method_34540);
/*  472 */     float alpha = Renderer.transformColor(color.getAlpha() / 255.0F);
/*  473 */     renderRoundedQuadInternal(mat, color
/*      */         
/*  475 */         .getRed() / 255.0F, color
/*  476 */         .getGreen() / 255.0F, color
/*  477 */         .getBlue() / 255.0F, alpha, roundStartX, roundStartY, roundStartX + width, roundStartY + height, 5.0D, 5.0D, 5.0D, 5.0D, 20.0D);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  489 */     class_289 t = class_289.method_1348();
/*  490 */     class_287 bb = t.method_1349();
/*  491 */     bb.method_1328(class_293.class_5596.field_27379, class_290.field_1576);
/*  492 */     if (renderUpsideDown) {
/*  493 */       bb.method_22918(mat, (float)arrowX, (float)arrowY - 0.5F, 0.0F).method_22915(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, alpha).method_1344();
/*  494 */       bb.method_22918(mat, (float)(arrowX - arrowDimX / 2.0D), (float)(arrowY - arrowDimY - 0.5D), 0.0F)
/*  495 */         .method_22915(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, alpha)
/*  496 */         .method_1344();
/*  497 */       bb.method_22918(mat, (float)(arrowX + arrowDimX / 2.0D), (float)(arrowY - arrowDimY - 0.5D), 0.0F)
/*  498 */         .method_22915(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, alpha)
/*  499 */         .method_1344();
/*      */     } else {
/*  501 */       bb.method_22918(mat, (float)arrowX, (float)arrowY + 0.5F, 0.0F).method_22915(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, alpha).method_1344();
/*  502 */       bb.method_22918(mat, (float)(arrowX - arrowDimX / 2.0D), (float)(arrowY + arrowDimY + 0.5D), 0.0F)
/*  503 */         .method_22915(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, alpha)
/*  504 */         .method_1344();
/*  505 */       bb.method_22918(mat, (float)(arrowX + arrowDimX / 2.0D), (float)(arrowY + arrowDimY + 0.5D), 0.0F)
/*  506 */         .method_22915(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, alpha)
/*  507 */         .method_1344();
/*      */     } 
/*  509 */     t.method_1350();
/*  510 */     Renderer.endRender();
/*  511 */     return new class_241((float)roundStartX, (float)roundStartY);
/*      */   }
/*      */   
/*      */   public static float[] getCheckmarkDimensions(float firstPart, float secondPart, float angle) {
/*  515 */     double a = Math.toRadians((angle - 90.0F));
/*  516 */     double b = Math.toRadians(angle);
/*      */     
/*  518 */     double firstPointY = Math.sin(a) * firstPart;
/*  519 */     double firstPointX = Math.cos(a) * firstPart;
/*      */     
/*  521 */     double secondPointY = Math.sin(b) * secondPart;
/*  522 */     double secondPointX = Math.cos(b) * secondPart;
/*      */     
/*  524 */     double minX = Math.min(0.0D, Math.min(firstPointX, secondPointX));
/*  525 */     double maxX = Math.max(0.0D, Math.max(firstPointX, secondPointX));
/*      */     
/*  527 */     double minY = Math.min(0.0D, Math.min(firstPointY, secondPointY));
/*  528 */     double maxY = Math.max(0.0D, Math.max(firstPointY, secondPointY));
/*      */     
/*  530 */     double width = maxX - minX;
/*  531 */     double height = maxY - minY;
/*      */     
/*  533 */     return new float[] { (float)minX, (float)minY, (float)maxX, (float)maxY, (float)width, (float)height };
/*      */   }
/*      */   
/*      */   public static void renderCheckmark(class_4587 matrices, Color color, double x, double y, float firstPart, float secondPart, float width, float angle) {
/*  537 */     matrices.method_22903();
/*  538 */     matrices.method_22904(x, y, 0.0D);
/*  539 */     matrices.method_22907(class_7833.field_40718.rotationDegrees(angle));
/*  540 */     matrices.method_46416(-secondPart / 2.0F, firstPart / 2.0F, 0.0F);
/*  541 */     Matrix4f matrix = matrices.method_23760().method_23761();
/*  542 */     float a = Renderer.transformColor(color.getAlpha() / 255.0F);
/*  543 */     float r = color.getRed() / 255.0F;
/*  544 */     float g = color.getGreen() / 255.0F;
/*  545 */     float b = color.getBlue() / 255.0F;
/*  546 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*  547 */     Renderer.setupRender();
/*  548 */     RenderSystem.setShader(class_757::method_34540);
/*  549 */     bufferBuilder.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  557 */     bufferBuilder.method_22918(matrix, 0.0F, -firstPart, 0.0F).method_22915(r, g, b, a).method_1344();
/*  558 */     bufferBuilder.method_22918(matrix, 0.0F, 0.0F, 0.0F).method_22915(r, g, b, a).method_1344();
/*  559 */     bufferBuilder.method_22918(matrix, width, 0.0F, 0.0F).method_22915(r, g, b, a).method_1344();
/*  560 */     bufferBuilder.method_22918(matrix, width, -firstPart, 0.0F).method_22915(r, g, b, a).method_1344();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  567 */     bufferBuilder.method_22918(matrix, 0.0F, 0.0F, 0.0F).method_22915(r, g, b, a).method_1344();
/*  568 */     bufferBuilder.method_22918(matrix, secondPart, 0.0F, 0.0F).method_22915(r, g, b, a).method_1344();
/*  569 */     bufferBuilder.method_22918(matrix, secondPart, -width, 0.0F).method_22915(r, g, b, a).method_1344();
/*  570 */     bufferBuilder.method_22918(matrix, 0.0F, -width, 0.0F).method_22915(r, g, b, a).method_1344();
/*      */     
/*  572 */     class_286.method_43433(bufferBuilder.method_1326());
/*  573 */     Renderer.endRender();
/*  574 */     matrices.method_22909();
/*      */   }
/*      */   
/*      */   public static void beginScissor(double x, double y, double endX, double endY) {
/*  578 */     double width = endX - x;
/*  579 */     double height = endY - y;
/*  580 */     width = Math.max(0.0D, width);
/*  581 */     height = Math.max(0.0D, height);
/*  582 */     float mulScale = (float)class_310.method_1551().method_22683().method_4495();
/*  583 */     int invertedY = (int)((class_310.method_1551().method_22683().method_4502() - y + height) * mulScale);
/*  584 */     RenderSystem.enableScissor((int)(x * mulScale), invertedY, (int)(width * mulScale), (int)(height * mulScale));
/*      */   }
/*      */   
/*      */   public static void endScissor() {
/*  588 */     RenderSystem.disableScissor();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderTexture(class_4587 matrices, double x0, double y0, double width, double height, float u, float v, double regionWidth, double regionHeight, double textureWidth, double textureHeight) {
/*  593 */     double x1 = x0 + width;
/*  594 */     double y1 = y0 + height;
/*  595 */     double z = 0.0D;
/*  596 */     renderTexturedQuad(matrices
/*  597 */         .method_23760().method_23761(), x0, x1, y0, y1, z, (u + 0.0F) / (float)textureWidth, (u + (float)regionWidth) / (float)textureWidth, (v + 0.0F) / (float)textureHeight, (v + (float)regionHeight) / (float)textureHeight);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void renderRoundedShadowInternal(Matrix4f matrix, float cr, float cg, float cb, float ca, double fromX, double fromY, double toX, double toY, double rad, double samples, double wid) {
/*  612 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*  613 */     bufferBuilder.method_1328(class_293.class_5596.field_27380, class_290.field_1576);
/*      */     
/*  615 */     double toX1 = toX - rad;
/*  616 */     double toY1 = toY - rad;
/*  617 */     double fromX1 = fromX + rad;
/*  618 */     double fromY1 = fromY + rad;
/*  619 */     double[][] map = { { toX1, toY1 }, { toX1, fromY1 }, { fromX1, fromY1 }, { fromX1, toY1 } };
/*      */     
/*  621 */     for (int i = 0; i < map.length; i++) {
/*  622 */       double[] arrayOfDouble = map[i]; double r;
/*  623 */       for (r = i * 90.0D; r < 90.0D + i * 90.0D; r += 90.0D / samples) {
/*  624 */         float f1 = (float)Math.toRadians(r);
/*  625 */         float f2 = (float)(Math.sin(f1) * rad);
/*  626 */         float f3 = (float)(Math.cos(f1) * rad);
/*  627 */         bufferBuilder.method_22918(matrix, (float)arrayOfDouble[0] + f2, (float)arrayOfDouble[1] + f3, 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*  628 */         float f4 = (float)(f2 + Math.sin(f1) * wid);
/*  629 */         float f5 = (float)(f3 + Math.cos(f1) * wid);
/*  630 */         bufferBuilder.method_22918(matrix, (float)arrayOfDouble[0] + f4, (float)arrayOfDouble[1] + f5, 0.0F).method_22915(cr, cg, cb, 0.0F).method_1344();
/*      */       } 
/*      */     } 
/*  633 */     double[] current = map[0];
/*  634 */     float rad1 = (float)Math.toRadians(0.0D);
/*  635 */     float sin = (float)(Math.sin(rad1) * rad);
/*  636 */     float cos = (float)(Math.cos(rad1) * rad);
/*  637 */     bufferBuilder.method_22918(matrix, (float)current[0] + sin, (float)current[1] + cos, 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*  638 */     float sin1 = (float)(sin + Math.sin(rad1) * wid);
/*  639 */     float cos1 = (float)(cos + Math.cos(rad1) * wid);
/*  640 */     bufferBuilder.method_22918(matrix, (float)current[0] + sin1, (float)current[1] + cos1, 0.0F).method_22915(cr, cg, cb, 0.0F).method_1344();
/*  641 */     class_286.method_43433(bufferBuilder.method_1326());
/*      */   }
/*      */   
/*      */   public static void renderRoundedShadow(class_4587 matrices, Color innerColor, double fromX, double fromY, double toX, double toY, double rad, double samples, double shadowWidth) {
/*  645 */     int color = innerColor.getRGB();
/*  646 */     Matrix4f matrix = matrices.method_23760().method_23761();
/*  647 */     float f = (color >> 24 & 0xFF) / 255.0F;
/*  648 */     float g = (color >> 16 & 0xFF) / 255.0F;
/*  649 */     float h = (color >> 8 & 0xFF) / 255.0F;
/*  650 */     float k = (color & 0xFF) / 255.0F;
/*  651 */     Renderer.setupRender();
/*  652 */     RenderSystem.setShader(class_757::method_34540);
/*      */     
/*  654 */     renderRoundedShadowInternal(matrix, g, h, k, Renderer.transformColor(f), fromX, fromY, toX, toY, rad, samples, shadowWidth);
/*  655 */     Renderer.endRender();
/*      */   }
/*      */   
/*      */   public static void renderLoadingSpinner(class_4587 stack, float alpha, double x, double y, double rad, double width, double segments) {
/*  659 */     float v = Renderer.transformColor(alpha);
/*  660 */     stack.method_22903();
/*  661 */     stack.method_22904(x, y, 0.0D);
/*  662 */     float rot = (float)(System.currentTimeMillis() % 2000L) / 2000.0F;
/*  663 */     stack.method_22907(class_7833.field_40718.rotationDegrees(rot * 360.0F));
/*  664 */     double segments1 = class_3532.method_15350(segments, 2.0D, 90.0D);
/*      */     
/*  666 */     Matrix4f matrix = stack.method_23760().method_23761();
/*  667 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*      */     
/*  669 */     Renderer.setupRender();
/*  670 */     RenderSystem.setShader(class_757::method_34540);
/*  671 */     bufferBuilder.method_1328(class_293.class_5596.field_27380, class_290.field_1576); double r;
/*  672 */     for (r = 0.0D; r < 90.0D; r += 90.0D / segments1) {
/*  673 */       double rad1 = Math.toRadians(r);
/*  674 */       double sin = Math.sin(rad1);
/*  675 */       double cos = Math.cos(rad1);
/*  676 */       double offX = sin * rad;
/*  677 */       double offY = cos * rad;
/*  678 */       float prog = (float)r / 360.0F;
/*  679 */       prog -= rot;
/*  680 */       prog %= 1.0F;
/*  681 */       Color hsb = Color.getHSBColor(prog, 0.6F, 1.0F);
/*  682 */       float g = hsb.getRed() / 255.0F;
/*  683 */       float h = hsb.getGreen() / 255.0F;
/*  684 */       float k = hsb.getBlue() / 255.0F;
/*  685 */       bufferBuilder.method_22918(matrix, (float)offX, (float)offY, 0.0F).method_22915(g, h, k, v).method_1344();
/*  686 */       bufferBuilder.method_22918(matrix, (float)(offX + sin * width), (float)(offY + cos * width), 0.0F).method_22915(g, h, k, v).method_1344();
/*      */     } 
/*      */     
/*  689 */     class_286.method_43433(bufferBuilder.method_1326());
/*  690 */     stack.method_22909();
/*  691 */     Renderer.endRender();
/*      */   }
/*      */   
/*      */   private static void renderTexturedQuad(Matrix4f matrix, double x0, double x1, double y0, double y1, double z, float u0, float u1, float v0, float v1) {
/*  695 */     RenderSystem.setShader(class_757::method_34542);
/*  696 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*  697 */     bufferBuilder.method_1328(class_293.class_5596.field_27382, class_290.field_1585);
/*  698 */     bufferBuilder.method_22918(matrix, (float)x0, (float)y1, (float)z).method_22913(u0, v1).method_1344();
/*  699 */     bufferBuilder.method_22918(matrix, (float)x1, (float)y1, (float)z).method_22913(u1, v1).method_1344();
/*  700 */     bufferBuilder.method_22918(matrix, (float)x1, (float)y0, (float)z).method_22913(u1, v0).method_1344();
/*  701 */     bufferBuilder.method_22918(matrix, (float)x0, (float)y0, (float)z).method_22913(u0, v0).method_1344();
/*  702 */     class_286.method_43433(bufferBuilder.method_1326());
/*      */   }
/*      */   
/*      */   public static void runWithinBlendMask(Runnable maskDrawer, Runnable regularDrawer) {
/*  706 */     RenderSystem.enableBlend();
/*  707 */     RenderSystem.colorMask(false, false, false, true);
/*  708 */     RenderSystem.clearColor(0.0F, 0.0F, 0.0F, 0.0F);
/*  709 */     RenderSystem.clear(16384, false);
/*  710 */     RenderSystem.colorMask(true, true, true, true);
/*  711 */     RenderSystem.setShader(class_757::method_34540);
/*      */     
/*  713 */     maskDrawer.run();
/*      */     
/*  715 */     RenderSystem.blendFunc(772, 773);
/*      */     
/*  717 */     regularDrawer.run();
/*      */     
/*  719 */     RenderSystem.defaultBlendFunc();
/*      */   }
/*      */   
/*      */   public static void renderCircle(class_4587 matrices, Color c, double originX, double originY, double rad, int segments) {
/*  723 */     int segments1 = class_3532.method_15340(segments, 4, 360);
/*  724 */     int color = c.getRGB();
/*      */     
/*  726 */     Matrix4f matrix = matrices.method_23760().method_23761();
/*  727 */     float f = Renderer.transformColor((color >> 24 & 0xFF) / 255.0F);
/*  728 */     float g = (color >> 16 & 0xFF) / 255.0F;
/*  729 */     float h = (color >> 8 & 0xFF) / 255.0F;
/*  730 */     float k = (color & 0xFF) / 255.0F;
/*  731 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*  732 */     Renderer.setupRender();
/*  733 */     RenderSystem.setShader(class_757::method_34540);
/*  734 */     bufferBuilder.method_1328(class_293.class_5596.field_27381, class_290.field_1576); int i;
/*  735 */     for (i = 0; i < 360; i += Math.min(360 / segments1, 360 - i)) {
/*  736 */       double radians = Math.toRadians(i);
/*  737 */       double sin = Math.sin(radians) * rad;
/*  738 */       double cos = Math.cos(radians) * rad;
/*  739 */       bufferBuilder.method_22918(matrix, (float)(originX + sin), (float)(originY + cos), 0.0F).method_22915(g, h, k, f).method_1344();
/*      */     } 
/*  741 */     class_286.method_43433(bufferBuilder.method_1326());
/*      */   }
/*      */   
/*      */   public static boolean isOnScreen(class_243 pos) {
/*  745 */     return (pos != null && pos.field_1350 > -1.0D && pos.field_1350 < 1.0D);
/*      */   }
/*      */   
/*      */   public static class_243 getScreenSpaceCoordinate(class_243 pos, class_4587 stack) {
/*  749 */     class_4184 camera = (class_310.method_1551().method_1561()).field_4686;
/*  750 */     Matrix4f matrix = stack.method_23760().method_23761();
/*  751 */     int displayHeight = class_310.method_1551().method_22683().method_4507();
/*  752 */     int[] viewport = new int[4];
/*  753 */     Vector3f target = new Vector3f();
/*      */     
/*  755 */     double deltaX = pos.field_1352 - (camera.method_19326()).field_1352;
/*  756 */     double deltaY = pos.field_1351 - (camera.method_19326()).field_1351;
/*  757 */     double deltaZ = pos.field_1350 - (camera.method_19326()).field_1350;
/*      */     
/*  759 */     GL11.glGetIntegerv(2978, viewport);
/*      */     
/*  761 */     Vector4f transformedCoordinates = (new Vector4f((float)deltaX, (float)deltaY, (float)deltaZ, 1.0F)).mul((Matrix4fc)matrix);
/*      */     
/*  763 */     Matrix4f matrixProj = new Matrix4f((Matrix4fc)RenderSystem.getProjectionMatrix());
/*  764 */     Matrix4f matrixModel = new Matrix4f((Matrix4fc)RenderSystem.getModelViewMatrix());
/*      */     
/*  766 */     matrixProj.mul((Matrix4fc)matrixModel).project(transformedCoordinates.x(), transformedCoordinates.y(), transformedCoordinates.z(), viewport, target);
/*      */     
/*  768 */     return new class_243(target.x / 
/*  769 */         class_310.method_1551().method_22683().method_4495(), (displayHeight - target.y) / 
/*  770 */         class_310.method_1551().method_22683().method_4495(), target.z);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class_243 screenSpaceToWorldOffset(double x, double y, double z) {
/*  776 */     double yCopy = y;
/*  777 */     double xCopy = x;
/*  778 */     Matrix4f projMat = RenderSystem.getProjectionMatrix();
/*  779 */     xCopy /= class_310.method_1551().method_22683().method_4489();
/*  780 */     yCopy /= class_310.method_1551().method_22683().method_4506();
/*  781 */     xCopy = xCopy * 2.0D - 1.0D;
/*  782 */     yCopy = yCopy * 2.0D - 1.0D;
/*  783 */     Vector4f pos = new Vector4f((float)xCopy, (float)yCopy, (float)z, 1.0F);
/*  784 */     pos.mul((Matrix4fc)projMat);
/*  785 */     if (pos.w() == 0.0F) {
/*  786 */       return null;
/*      */     }
/*  788 */     pos.normalize();
/*  789 */     return new class_243(pos.x(), pos.y(), pos.z());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderQuad(class_4587 matrices, Color c, double x1, double y1, double x2, double y2) {
/*  794 */     double x11 = x1;
/*  795 */     double x21 = x2;
/*  796 */     double y11 = y1;
/*  797 */     double y21 = y2;
/*  798 */     int color = c.getRGB();
/*      */     
/*  800 */     if (x11 < x21) {
/*  801 */       double j = x11;
/*  802 */       x11 = x21;
/*  803 */       x21 = j;
/*      */     } 
/*      */     
/*  806 */     if (y11 < y21) {
/*  807 */       double j = y11;
/*  808 */       y11 = y21;
/*  809 */       y21 = j;
/*      */     } 
/*  811 */     Matrix4f matrix = matrices.method_23760().method_23761();
/*  812 */     float f = Renderer.transformColor((color >> 24 & 0xFF) / 255.0F);
/*  813 */     float g = (color >> 16 & 0xFF) / 255.0F;
/*  814 */     float h = (color >> 8 & 0xFF) / 255.0F;
/*  815 */     float k = (color & 0xFF) / 255.0F;
/*  816 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*  817 */     Renderer.setupRender();
/*  818 */     RenderSystem.setShader(class_757::method_34540);
/*  819 */     bufferBuilder.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
/*  820 */     bufferBuilder.method_22918(matrix, (float)x11, (float)y21, 0.0F).method_22915(g, h, k, f).method_1344();
/*  821 */     bufferBuilder.method_22918(matrix, (float)x21, (float)y21, 0.0F).method_22915(g, h, k, f).method_1344();
/*  822 */     bufferBuilder.method_22918(matrix, (float)x21, (float)y11, 0.0F).method_22915(g, h, k, f).method_1344();
/*  823 */     bufferBuilder.method_22918(matrix, (float)x11, (float)y11, 0.0F).method_22915(g, h, k, f).method_1344();
/*  824 */     class_286.method_43433(bufferBuilder.method_1326());
/*  825 */     Renderer.endRender();
/*      */   }
/*      */   
/*      */   public static void renderQuadGradient(class_4587 matrices, Color c2, Color c1, double x1, double y1, double x2, double y2, boolean vertical) {
/*  829 */     double x11 = x1;
/*  830 */     double x21 = x2;
/*  831 */     double y11 = y1;
/*  832 */     double y21 = y2;
/*  833 */     float r1 = c1.getRed() / 255.0F;
/*  834 */     float g1 = c1.getGreen() / 255.0F;
/*  835 */     float b1 = c1.getBlue() / 255.0F;
/*  836 */     float a1 = Renderer.transformColor(c1.getAlpha() / 255.0F);
/*  837 */     float r2 = c2.getRed() / 255.0F;
/*  838 */     float g2 = c2.getGreen() / 255.0F;
/*  839 */     float b2 = c2.getBlue() / 255.0F;
/*  840 */     float a2 = Renderer.transformColor(c2.getAlpha() / 255.0F);
/*      */ 
/*      */ 
/*      */     
/*  844 */     if (x11 < x21) {
/*  845 */       double j = x11;
/*  846 */       x11 = x21;
/*  847 */       x21 = j;
/*      */     } 
/*      */     
/*  850 */     if (y11 < y21) {
/*  851 */       double j = y11;
/*  852 */       y11 = y21;
/*  853 */       y21 = j;
/*      */     } 
/*  855 */     Matrix4f matrix = matrices.method_23760().method_23761();
/*  856 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*  857 */     Renderer.setupRender();
/*      */     
/*  859 */     RenderSystem.setShader(class_757::method_34540);
/*  860 */     bufferBuilder.method_1328(class_293.class_5596.field_27382, class_290.field_1576);
/*  861 */     if (vertical) {
/*  862 */       bufferBuilder.method_22918(matrix, (float)x11, (float)y11, 0.0F).method_22915(r1, g1, b1, a1).method_1344();
/*  863 */       bufferBuilder.method_22918(matrix, (float)x11, (float)y21, 0.0F).method_22915(r2, g2, b2, a2).method_1344();
/*  864 */       bufferBuilder.method_22918(matrix, (float)x21, (float)y21, 0.0F).method_22915(r2, g2, b2, a2).method_1344();
/*  865 */       bufferBuilder.method_22918(matrix, (float)x21, (float)y11, 0.0F).method_22915(r1, g1, b1, a1).method_1344();
/*      */     } else {
/*  867 */       bufferBuilder.method_22918(matrix, (float)x11, (float)y11, 0.0F).method_22915(r1, g1, b1, a1).method_1344();
/*  868 */       bufferBuilder.method_22918(matrix, (float)x11, (float)y21, 0.0F).method_22915(r1, g1, b1, a1).method_1344();
/*  869 */       bufferBuilder.method_22918(matrix, (float)x21, (float)y21, 0.0F).method_22915(r2, g2, b2, a2).method_1344();
/*  870 */       bufferBuilder.method_22918(matrix, (float)x21, (float)y11, 0.0F).method_22915(r2, g2, b2, a2).method_1344();
/*      */     } 
/*      */     
/*  873 */     class_286.method_43433(bufferBuilder.method_1326());
/*  874 */     Renderer.endRender();
/*      */   }
/*      */   
/*      */   public static void renderRoundedQuadInternal(Matrix4f matrix, float cr, float cg, float cb, float ca, double fromX, double fromY, double toX, double toY, double rad, double samples) {
/*  878 */     renderRoundedQuadInternal(matrix, cr, cg, cb, ca, fromX, fromY, toX, toY, rad, rad, rad, rad, samples);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderRoundedQuadInternal(Matrix4f matrix, float cr, float cg, float cb, float ca, double fromX, double fromY, double toX, double toY, double radC1, double radC2, double radC3, double radC4, double samples) {
/*  883 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*  884 */     bufferBuilder.method_1328(class_293.class_5596.field_27381, class_290.field_1576);
/*      */     
/*  886 */     double[][] map = { { toX - radC4, toY - radC4, radC4 }, { toX - radC2, fromY + radC2, radC2 }, { fromX + radC1, fromY + radC1, radC1 }, { fromX + radC3, toY - radC3, radC3 } };
/*      */     
/*  888 */     for (int i = 0; i < 4; i++) {
/*  889 */       double[] current = map[i];
/*  890 */       double rad = current[2]; double r;
/*  891 */       for (r = i * 90.0D; r < 90.0D + i * 90.0D; r += 90.0D / samples) {
/*  892 */         float f1 = (float)Math.toRadians(r);
/*  893 */         float f2 = (float)(Math.sin(f1) * rad);
/*  894 */         float f3 = (float)(Math.cos(f1) * rad);
/*  895 */         bufferBuilder.method_22918(matrix, (float)current[0] + f2, (float)current[1] + f3, 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*      */       } 
/*  897 */       float rad1 = (float)Math.toRadians(90.0D + i * 90.0D);
/*  898 */       float sin = (float)(Math.sin(rad1) * rad);
/*  899 */       float cos = (float)(Math.cos(rad1) * rad);
/*  900 */       bufferBuilder.method_22918(matrix, (float)current[0] + sin, (float)current[1] + cos, 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*      */     } 
/*  902 */     class_286.method_43433(bufferBuilder.method_1326());
/*      */   }
/*      */   
/*      */   public static void renderRoundedQuadWithShadow(class_4587 matrices, Color c, double fromX, double fromY, double toX, double toY, double rad, double samples) {
/*  906 */     int color = c.getRGB();
/*  907 */     Matrix4f matrix = matrices.method_23760().method_23761();
/*  908 */     float f = Renderer.transformColor((color >> 24 & 0xFF) / 255.0F);
/*  909 */     float g = (color >> 16 & 0xFF) / 255.0F;
/*  910 */     float h = (color >> 8 & 0xFF) / 255.0F;
/*  911 */     float k = (color & 0xFF) / 255.0F;
/*  912 */     Renderer.setupRender();
/*  913 */     RenderSystem.setShader(class_757::method_34540);
/*      */     
/*  915 */     renderRoundedQuadInternal(matrix, g, h, k, f, fromX, fromY, toX, toY, rad, rad, rad, rad, samples);
/*      */     
/*  917 */     renderRoundedShadow(matrices, new Color(10, 10, 10, 100), fromX, fromY, toX, toY, rad, samples, 3.0D);
/*  918 */     Renderer.endRender();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderRoundedQuad(class_4587 matrices, Color c, double fromX, double fromY, double toX, double toY, double radC1, double radC2, double radC3, double radC4, double samples) {
/*  923 */     int color = c.getRGB();
/*  924 */     Matrix4f matrix = matrices.method_23760().method_23761();
/*  925 */     float f = Renderer.transformColor((color >> 24 & 0xFF) / 255.0F);
/*  926 */     float g = (color >> 16 & 0xFF) / 255.0F;
/*  927 */     float h = (color >> 8 & 0xFF) / 255.0F;
/*  928 */     float k = (color & 0xFF) / 255.0F;
/*  929 */     Renderer.setupRender();
/*  930 */     RenderSystem.setShader(class_757::method_34540);
/*      */     
/*  932 */     renderRoundedQuadInternal(matrix, g, h, k, f, fromX, fromY, toX, toY, radC1, radC2, radC3, radC4, samples);
/*  933 */     Renderer.endRender();
/*      */   }
/*      */   
/*      */   public static void renderRoundedQuad(class_4587 stack, Color c, double x, double y, double x1, double y1, double rad, double samples) {
/*  937 */     renderRoundedQuad(stack, c, x, y, x1, y1, rad, rad, rad, rad, samples);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderRoundedOutlineInternal(Matrix4f matrix, float cr, float cg, float cb, float ca, double fromX, double fromY, double toX, double toY, double radC1, double radC2, double radC3, double radC4, double width, double samples) {
/*  942 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*  943 */     bufferBuilder.method_1328(class_293.class_5596.field_27380, class_290.field_1576);
/*      */     
/*  945 */     double[][] map = { { toX - radC4, toY - radC4, radC4 }, { toX - radC2, fromY + radC2, radC2 }, { fromX + radC1, fromY + radC1, radC1 }, { fromX + radC3, toY - radC3, radC3 } };
/*      */     int i;
/*  947 */     for (i = 0; i < 4; i++) {
/*  948 */       double[] arrayOfDouble = map[i];
/*  949 */       double d1 = arrayOfDouble[2]; double r;
/*  950 */       for (r = i * 90.0D; r < 90.0D + i * 90.0D; r += 90.0D / samples) {
/*  951 */         float f2 = (float)Math.toRadians(r);
/*  952 */         double d2 = Math.sin(f2);
/*  953 */         float f3 = (float)(d2 * d1);
/*  954 */         double d3 = Math.cos(f2);
/*  955 */         float f4 = (float)(d3 * d1);
/*  956 */         bufferBuilder.method_22918(matrix, (float)arrayOfDouble[0] + f3, (float)arrayOfDouble[1] + f4, 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*  957 */         bufferBuilder.method_22918(matrix, (float)(arrayOfDouble[0] + f3 + d2 * width), (float)(arrayOfDouble[1] + f4 + d3 * width), 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*      */       } 
/*  959 */       float rad1 = (float)Math.toRadians(90.0D + i * 90.0D);
/*  960 */       double sin1 = Math.sin(rad1);
/*  961 */       float sin = (float)(sin1 * d1);
/*  962 */       double cos1 = Math.cos(rad1);
/*  963 */       float f1 = (float)(cos1 * d1);
/*  964 */       bufferBuilder.method_22918(matrix, (float)arrayOfDouble[0] + sin, (float)arrayOfDouble[1] + f1, 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*  965 */       bufferBuilder.method_22918(matrix, (float)(arrayOfDouble[0] + sin + sin1 * width), (float)(arrayOfDouble[1] + f1 + cos1 * width), 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*      */     } 
/*  967 */     i = 0;
/*  968 */     double[] current = map[i];
/*  969 */     double rad = current[2];
/*  970 */     float cos = (float)rad;
/*  971 */     bufferBuilder.method_22918(matrix, (float)current[0], (float)current[1] + cos, 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*  972 */     bufferBuilder.method_22918(matrix, (float)current[0], (float)(current[1] + cos + width), 0.0F).method_22915(cr, cg, cb, ca).method_1344();
/*  973 */     class_286.method_43433(bufferBuilder.method_1326());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderRoundedOutline(class_4587 matrices, Color c, double fromX, double fromY, double toX, double toY, double rad1, double rad2, double rad3, double rad4, double width, double samples) {
/*  978 */     int color = c.getRGB();
/*  979 */     Matrix4f matrix = matrices.method_23760().method_23761();
/*  980 */     float f = (color >> 24 & 0xFF) / 255.0F;
/*  981 */     float g = (color >> 16 & 0xFF) / 255.0F;
/*  982 */     float h = (color >> 8 & 0xFF) / 255.0F;
/*  983 */     float k = (color & 0xFF) / 255.0F;
/*  984 */     Renderer.setupRender();
/*  985 */     RenderSystem.setShader(class_757::method_34540);
/*      */     
/*  987 */     renderRoundedOutlineInternal(matrix, g, h, k, f, fromX, fromY, toX, toY, rad1, rad2, rad3, rad4, width, samples);
/*  988 */     Renderer.endRender();
/*      */   }
/*      */   
/*      */   public static void renderLine(class_4587 stack, Color c, double x, double y, double x1, double y1) {
/*  992 */     float g = c.getRed() / 255.0F;
/*  993 */     float h = c.getGreen() / 255.0F;
/*  994 */     float k = c.getBlue() / 255.0F;
/*  995 */     float f = Renderer.transformColor(c.getAlpha() / 255.0F);
/*  996 */     Matrix4f m = stack.method_23760().method_23761();
/*  997 */     class_287 bufferBuilder = class_289.method_1348().method_1349();
/*  998 */     Renderer.setupRender();
/*  999 */     RenderSystem.setShader(class_757::method_34540);
/* 1000 */     bufferBuilder.method_1328(class_293.class_5596.field_29344, class_290.field_1576);
/* 1001 */     bufferBuilder.method_22918(m, (float)x, (float)y, 0.0F).method_22915(g, h, k, f).method_1344();
/* 1002 */     bufferBuilder.method_22918(m, (float)x1, (float)y1, 0.0F).method_22915(g, h, k, f).method_1344();
/* 1003 */     class_286.method_43433(bufferBuilder.method_1326());
/* 1004 */     Renderer.endRender();
/*      */   }
/*      */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/Renderer$R2D.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */