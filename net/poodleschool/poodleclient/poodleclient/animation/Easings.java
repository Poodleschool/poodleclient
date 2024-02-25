/*     */ package de.Jakob.navine.animation;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Easings
/*     */ {
/*     */   public static float linear(float x) {
/*   8 */     return x;
/*     */   }
/*     */   
/*     */   public static float easeInSine(float x) {
/*  12 */     return (float)(1.0D - Math.cos(x * Math.PI / 2.0D));
/*     */   }
/*     */   
/*     */   public static float easeOutSine(float x) {
/*  16 */     return (float)Math.sin(x * Math.PI / 2.0D);
/*     */   }
/*     */   
/*     */   public static float easeInOutSine(float x) {
/*  20 */     return (float)(-(Math.cos(Math.PI * x) - 1.0D) / 2.0D);
/*     */   }
/*     */   
/*     */   public static float easeInCubic(float x) {
/*  24 */     return x * x * x;
/*     */   }
/*     */   
/*     */   public static float easeOutCubic(float x) {
/*  28 */     return (float)(1.0D - Math.pow((1.0F - x), 3.0D));
/*     */   }
/*     */   
/*     */   public static float easeInOutCubic(float x) {
/*  32 */     return (float)((x < 0.5D) ? (4.0F * x * x * x) : (1.0D - Math.pow((-2.0F * x + 2.0F), 3.0D) / 2.0D));
/*     */   }
/*     */   
/*     */   public static float easeInQuint(float x) {
/*  36 */     return x * x * x * x * x;
/*     */   }
/*     */   
/*     */   public static float easeOutQuint(float x) {
/*  40 */     return (float)(1.0D - Math.pow((1.0F - x), 5.0D));
/*     */   }
/*     */   
/*     */   public static float easeInOutQuint(float x) {
/*  44 */     return (float)((x < 0.5D) ? (16.0F * x * x * x * x * x) : (1.0D - Math.pow((-2.0F * x + 2.0F), 5.0D) / 2.0D));
/*     */   }
/*     */   
/*     */   public static float easeInCirc(float x) {
/*  48 */     return (float)(1.0D - Math.sqrt(1.0D - Math.pow(x, 2.0D)));
/*     */   }
/*     */   
/*     */   public static float easeOutCirc(float x) {
/*  52 */     return (float)Math.sqrt(1.0D - Math.pow((x - 1.0F), 2.0D));
/*     */   }
/*     */   
/*     */   public static float easeInOutCirc(float x) {
/*  56 */     return (float)((x < 0.5D) ? ((1.0D - Math.sqrt(1.0D - Math.pow((2.0F * x), 2.0D))) / 2.0D) : ((Math.sqrt(1.0D - Math.pow((-2.0F * x + 2.0F), 2.0D)) + 1.0D) / 2.0D));
/*     */   }
/*     */   
/*     */   public static float easeInElastic(float x) {
/*  60 */     if (x <= 0.0F) return 0.0F; 
/*  61 */     if (x >= 1.0F) return 1.0F; 
/*  62 */     return (float)(-Math.pow(2.0D, (10.0F * x - 10.0F)) * Math.sin(((x * 10.0F) - 10.75D) * 2.0943951023931953D));
/*     */   }
/*     */   
/*     */   public static float easeOutElastic(float x) {
/*  66 */     if (x <= 0.0F) return 0.0F; 
/*  67 */     if (x >= 1.0F) return 1.0F; 
/*  68 */     return (float)(Math.pow(2.0D, (-10.0F * x)) * Math.sin(((x * 10.0F) - 0.75D) * 2.0943951023931953D) + 1.0D);
/*     */   }
/*     */   
/*     */   public static float easeInOutElastic(float x) {
/*  72 */     if (x <= 0.0F) return 0.0F; 
/*  73 */     if (x >= 1.0F) return 1.0F; 
/*  74 */     return (float)((x < 0.5D) ? (-(Math.pow(2.0D, (20.0F * x - 10.0F)) * Math.sin(((20.0F * x) - 11.125D) * 1.3962634015954636D)) / 2.0D) : (Math.pow(2.0D, (-20.0F * x + 10.0F)) * Math.sin(((20.0F * x) - 11.125D) * 1.3962634015954636D) / 2.0D + 1.0D));
/*     */   }
/*     */   
/*     */   public static float easeInQuad(float x) {
/*  78 */     return x * x;
/*     */   }
/*     */   
/*     */   public static float easeOutQuad(float x) {
/*  82 */     return 1.0F - (1.0F - x) * (1.0F - x);
/*     */   }
/*     */   
/*     */   public static float easeInOutQuad(float x) {
/*  86 */     return (float)((x < 0.5D) ? (2.0F * x * x) : (1.0D - Math.pow((-2.0F * x + 2.0F), 2.0D) / 2.0D));
/*     */   }
/*     */   
/*     */   public static float easeInQuart(float x) {
/*  90 */     return x * x * x * x;
/*     */   }
/*     */   
/*     */   public static float easeOutQuart(float x) {
/*  94 */     return (float)(1.0D - Math.pow((1.0F - x), 4.0D));
/*     */   }
/*     */   
/*     */   public static float easeInOutQuart(float x) {
/*  98 */     return (float)((x < 0.5D) ? (8.0F * x * x * x * x) : (1.0D - Math.pow((-2.0F * x + 2.0F), 4.0D) / 2.0D));
/*     */   }
/*     */   
/*     */   public static float easeInExponential(float x) {
/* 102 */     return (float)((x == 0.0F) ? 0.0D : Math.pow(2.0D, (10.0F * x - 10.0F)));
/*     */   }
/*     */   
/*     */   public static float easeOutExponential(float x) {
/* 106 */     return (float)((x == 1.0F) ? 1.0D : (1.0D - Math.pow(2.0D, (-10.0F * x))));
/*     */   }
/*     */   
/*     */   public static float easeInOutExponential(float x) {
/* 110 */     return (float)((x == 0.0F) ? 0.0D : ((x == 1.0F) ? 1.0D : ((x < 0.5D) ? (Math.pow(2.0D, (20.0F * x - 10.0F)) / 2.0D) : ((2.0D - Math.pow(2.0D, (-20.0F * x + 10.0F))) / 2.0D))));
/*     */   }
/*     */   
/*     */   public static float easeInBack(float x) {
/* 114 */     float c1 = 1.70158F;
/* 115 */     return (c1 + 1.0F) * x * x * x - c1 * x * x;
/*     */   }
/*     */   
/*     */   public static float easeOutBack(float x) {
/* 119 */     float c1 = 1.70158F;
/* 120 */     return (float)(1.0D + (c1 + 1.0F) * Math.pow((x - 1.0F), 3.0D) + c1 * Math.pow((x - 1.0F), 2.0D));
/*     */   }
/*     */   
/*     */   public static float easeInOutBack(float x) {
/* 124 */     float c1 = 1.70158F;
/* 125 */     float c2 = c1 * 1.525F;
/*     */     
/* 127 */     return (float)((x < 0.5D) ? (Math.pow((2.0F * x), 2.0D) * ((c2 + 1.0F) * 2.0F * x - c2) / 2.0D) : ((Math.pow((2.0F * x - 2.0F), 2.0D) * ((c2 + 1.0F) * (x * 2.0F - 2.0F) + c2) + 2.0D) / 2.0D));
/*     */   }
/*     */   
/*     */   public static float easeInBounce(float x) {
/* 131 */     return 1.0F - easeOutBounce(1.0F - x);
/*     */   }
/*     */   
/*     */   public static float easeOutBounce(float x) {
/* 135 */     float n1 = 7.5625F;
/* 136 */     float d1 = 2.75F;
/*     */     
/* 138 */     if (x < 1.0F / d1)
/* 139 */       return n1 * x * x; 
/* 140 */     if (x < 2.0F / d1)
/* 141 */       return (float)((n1 * (x = (float)(x - 1.5D / d1)) * x) + 0.75D); 
/* 142 */     if (x < 2.5D / d1) {
/* 143 */       return (float)((n1 * (x = (float)(x - 2.25D / d1)) * x) + 0.9375D);
/*     */     }
/* 145 */     return (float)((n1 * (x = (float)(x - 2.625D / d1)) * x) + 0.984375D);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float easeInOutBounce(float x) {
/* 150 */     return (x < 0.5D) ? ((1.0F - easeOutBounce(1.0F - 2.0F * x)) / 2.0F) : ((1.0F + easeOutBounce(2.0F * x - 1.0F)) / 2.0F);
/*     */   }
/*     */   
/*     */   public static float getEasingValue(float x, Easing easing) {
/* 154 */     if (x <= 0.0F) return 0.0F; 
/* 155 */     if (x >= 1.0F) return 1.0F; 
/* 156 */     switch (easing) {
/*     */       case LINEAR:
/* 158 */         return linear(x);
/*     */       case EASE_IN_SINE:
/* 160 */         return easeInSine(x);
/*     */       case EASE_OUT_SINE:
/* 162 */         return easeOutSine(x);
/*     */       case EASE_IN_OUT_SINE:
/* 164 */         return easeInOutSine(x);
/*     */       case EASE_IN_CUBIC:
/* 166 */         return easeInCubic(x);
/*     */       case EASE_OUT_CUBIC:
/* 168 */         return easeOutCubic(x);
/*     */       case EASE_IN_OUT_CUBIC:
/* 170 */         return easeInOutCubic(x);
/*     */       case EASE_IN_QUINT:
/* 172 */         return easeInQuint(x);
/*     */       case EASE_OUT_QUINT:
/* 174 */         return easeOutQuint(x);
/*     */       case EASE_IN_OUT_QUINT:
/* 176 */         return easeInOutQuint(x);
/*     */       case EASE_IN_CIRC:
/* 178 */         return easeInCirc(x);
/*     */       case EASE_OUT_CIRC:
/* 180 */         return easeOutCirc(x);
/*     */       case EASE_IN_OUT_CIRC:
/* 182 */         return easeInOutCirc(x);
/*     */       case EASE_IN_ELASTIC:
/* 184 */         return easeInElastic(x);
/*     */       case EASE_OUT_ELASTIC:
/* 186 */         return easeOutElastic(x);
/*     */       case EASE_IN_OUT_ELASTIC:
/* 188 */         return easeInOutElastic(x);
/*     */       case EASE_IN_QUAD:
/* 190 */         return easeInQuad(x);
/*     */       case EASE_OUT_QUAD:
/* 192 */         return easeOutQuad(x);
/*     */       case EASE_IN_OUT_QUAD:
/* 194 */         return easeInOutQuad(x);
/*     */       case EASE_IN_QUART:
/* 196 */         return easeInQuart(x);
/*     */       case EASE_OUT_QUART:
/* 198 */         return easeOutQuart(x);
/*     */       case EASE_IN_OUT_QUART:
/* 200 */         return easeInOutQuart(x);
/*     */       case EASE_IN_EXPONENTIAL:
/* 202 */         return easeInExponential(x);
/*     */       case EASE_OUT_EXPONENTIAL:
/* 204 */         return easeOutExponential(x);
/*     */       case EASE_IN_OUT_EXPONENTIAL:
/* 206 */         return easeInOutExponential(x);
/*     */       case EASE_IN_BACK:
/* 208 */         return easeInBack(x);
/*     */       case EASE_OUT_BACK:
/* 210 */         return easeOutBack(x);
/*     */       case EASE_IN_OUT_BACK:
/* 212 */         return easeInOutBack(x);
/*     */       case EASE_IN_BOUNCE:
/* 214 */         return easeInBounce(x);
/*     */       case EASE_OUT_BOUNCE:
/* 216 */         return easeOutBounce(x);
/*     */       case EASE_IN_OUT_BOUNCE:
/* 218 */         return easeInOutBounce(x);
/*     */     } 
/* 220 */     System.err.println("Unkown Easing type " + easing.name());
/* 221 */     return x;
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/animation/Easings.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */