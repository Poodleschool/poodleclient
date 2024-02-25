/*    */ package net.poodleschool.poodleclient.poodleclient.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*    */ 
/*    */ 
/*    */ public class Gradient
/*    */ {
/*    */   private List<Color> colors;
/*    */   
/*    */   public Gradient(List<Color> colors) {
/* 14 */     this.colors = colors;
/*    */   }
/*    */   public Gradient(Color... colors) {
/* 17 */     this.colors = new ArrayList<>(Arrays.<Color>stream(colors).toList());
/*    */   }
/*    */   public Gradient() {
/* 20 */     this.colors = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public Color getColor(float value, float maxValue) {
/* 24 */     if (this.colors.isEmpty())
/* 25 */       this.colors.add(new Color(255, 255, 255)); 
/* 26 */     if (this.colors.size() == 1) {
/* 27 */       this.colors.add(new Color(0, 0, 0));
/*    */     }
/* 29 */     value /= maxValue / (this.colors.size() - 1);
/*    */     
/* 31 */     return lerpColor(this.colors
/* 32 */         .get((int)value), this.colors
/* 33 */         .get((int)value + 1), value - (int)value, 1.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   private Color lerpColor(Color start, Color end, float step, float maxStep) {
/* 38 */     float rStep = (end.r - start.r) / maxStep;
/* 39 */     float gStep = (end.g - start.g) / maxStep;
/* 40 */     float bStep = (end.b - start.b) / maxStep;
/*    */     
/* 42 */     return new Color(start.r + (int)(rStep * step), start.g + (int)(gStep * step), start.b + (int)(bStep * step));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Color> getColors() {
/* 48 */     return this.colors;
/*    */   }
/*    */   
/*    */   public void setColors(List<Color> colors) {
/* 52 */     this.colors = colors;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/Gradient.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */