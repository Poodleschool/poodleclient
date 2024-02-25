/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ 
/*    */ public class JumpFly
/*    */   extends Module {
/*    */   public JumpFly() {
/* 11 */     super(Addon.CATEGORY, "jump-fly", "Jump on one Y axis.");
/*    */ 
/*    */     
/* 14 */     this.startY = -2048.0D;
/*    */   }
/*    */   private double startY;
/*    */   public void onActivate() {
/* 18 */     if (this.mc.field_1724 != null)
/* 19 */       this.startY = this.mc.field_1724.method_23318(); 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Post event) {
/* 24 */     if (this.startY == -2048.0D)
/* 25 */       this.startY = this.mc.field_1724.method_23318(); 
/* 26 */     if (this.mc.field_1724.method_23318() <= this.startY)
/* 27 */       this.mc.field_1724.method_6043(); 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/JumpFly.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */