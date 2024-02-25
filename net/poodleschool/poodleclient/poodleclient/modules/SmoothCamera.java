/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ 
/*    */ public class SmoothCamera
/*    */   extends Module {
/*    */   public SmoothCamera() {
/* 11 */     super(Addon.CATEGORY, "smooth-camera", "Keep your camera on one Y axis.");
/*    */ 
/*    */     
/* 14 */     this.startY = -2048.0D;
/*    */   }
/*    */   private double startY;
/*    */   public void onActivate() {
/* 18 */     if (this.mc.field_1724 != null)
/* 19 */       this.startY = this.mc.field_1724.method_23320(); 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Post event) {
/* 24 */     if (this.startY == -2048.0D)
/* 25 */       this.startY = this.mc.field_1724.method_23318(); 
/* 26 */     if (this.mc.field_1719.method_5757()) (this.mc.method_1560()).field_5960 = true; 
/*    */   }
/*    */   
/*    */   public double getStartY() {
/* 30 */     return this.startY;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/SmoothCamera.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */