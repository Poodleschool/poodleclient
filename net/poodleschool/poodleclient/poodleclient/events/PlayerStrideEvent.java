/*    */ package de.Jakob.navine.events;
/*    */ 
/*    */ public class PlayerStrideEvent
/*    */ {
/*    */   private float strideForce;
/*    */   
/*    */   public PlayerStrideEvent(float strideForce) {
/*  8 */     this.strideForce = strideForce;
/*    */   }
/*    */   
/*    */   public float getStrideForce() {
/* 12 */     return this.strideForce;
/*    */   }
/*    */   
/*    */   public void setStrideForce(float strideForce) {
/* 16 */     this.strideForce = strideForce;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/events/PlayerStrideEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */