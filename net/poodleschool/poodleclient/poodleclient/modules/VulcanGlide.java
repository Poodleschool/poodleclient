/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_243;
/*    */ 
/*    */ public class VulcanGlide
/*    */   extends Module {
/*    */   private static boolean wait = false;
/*    */   
/*    */   public VulcanGlide() {
/* 14 */     super(Addon.CATEGORY, "vulcan-gide", "Yippee!!!");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Post e) {
/* 19 */     if (this.mc.field_1724.field_6017 <= 0.0F || (this.mc.field_1724.method_18798()).field_1351 > 0.0D)
/*    */       return; 
/* 21 */     wait = !wait;
/* 22 */     if (!wait)
/*    */       return; 
/* 24 */     class_243 vec = this.mc.field_1724.method_18798();
/* 25 */     this.mc.field_1724.method_18799(new class_243(vec.field_1352, -0.1D, vec.field_1350));
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/VulcanGlide.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */