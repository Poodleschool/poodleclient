/*     */ package de.Jakob.navine.animation;
/*     */ 
/*     */ 
/*     */ public class Animation
/*     */ {
/*     */   private float value;
/*     */   private long lastTime;
/*     */   private float changePerMillisecond;
/*     */   
/*     */   public Animation(float duration, float start, float end) {
/*  11 */     this((long)(duration * 1000.0F), start, end, Easing.LINEAR);
/*     */   }
/*     */ 
/*     */   
/*     */   private float start;
/*     */   private float end;
/*     */   boolean increasing;
/*     */   private Easing easing;
/*     */   
/*     */   public Animation(float duration, float start, float end, Easing easing) {
/*  21 */     this((long)(duration * 1000.0F), start, end, easing);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation(long duration, float start, float end) {
/*  30 */     this(duration, start, end, Easing.LINEAR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation(long duration, float start, float end, Easing easing) {
/*  40 */     this.value = start;
/*  41 */     this.end = end;
/*  42 */     this.start = start;
/*  43 */     this.increasing = (end > start);
/*  44 */     float difference = Math.abs(start - end);
/*  45 */     this.changePerMillisecond = difference / (float)duration;
/*  46 */     this.lastTime = System.currentTimeMillis();
/*  47 */     this.easing = easing;
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
/*     */   public static Animation fromChangePerSecond(float changePerSecond, float start, float end) {
/*  59 */     return fromChangePerSecond(changePerSecond, start, end, Easing.LINEAR);
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
/*     */   public static Animation fromChangePerSecond(float changePerSecond, float start, float end, Easing easing) {
/*  72 */     return new Animation(Math.abs(start - end) / changePerSecond, start, end, easing);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 111 */     this.value = this.start;
/* 112 */     this.lastTime = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getValue() {
/* 120 */     return getEased((this.easing != null) ? this.easing : Easing.LINEAR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float loadValue() {
/* 127 */     if (this.value == this.end) return this.value; 
/* 128 */     if (this.increasing) {
/* 129 */       if (this.value >= this.end) {
/* 130 */         this.value = this.end;
/* 131 */         return this.value;
/*     */       } 
/* 133 */       this.value += this.changePerMillisecond * (float)(System.currentTimeMillis() - this.lastTime);
/* 134 */       if (this.value > this.end)
/* 135 */         this.value = this.end; 
/* 136 */       this.lastTime = System.currentTimeMillis();
/* 137 */       return this.value;
/*     */     } 
/* 139 */     if (this.value <= this.end) {
/* 140 */       this.value = this.end;
/* 141 */       return this.value;
/*     */     } 
/* 143 */     this.value -= this.changePerMillisecond * (float)(System.currentTimeMillis() - this.lastTime);
/* 144 */     if (this.value < this.end)
/* 145 */       this.value = this.end; 
/* 146 */     this.lastTime = System.currentTimeMillis();
/* 147 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 155 */     return (this.value == this.end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getEased(Easing easing) {
/* 163 */     if (easing == Easing.LINEAR) return loadValue(); 
/* 164 */     return map(Easings.getEasingValue(map(loadValue(), this.start, this.end, 0.0F, 1.0F), easing), 0.0F, 1.0F, this.start, this.end);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 169 */     return "Animation{value=" + this.value + ", lastTime=" + this.lastTime + ", changePerMillisecond=" + this.changePerMillisecond + ", start=" + this.start + ", end=" + this.end + ", increasing=" + this.increasing + ", easing=" + this.easing + "}";
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
/*     */   private static float map(float value, float minInput, float maxInput, float minMapped, float maxMapped) {
/* 184 */     return (value - minInput) / (maxInput - minInput) * (maxMapped - minMapped) + minMapped;
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/animation/Animation.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */