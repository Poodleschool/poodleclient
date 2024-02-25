/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import net.poodleschool.poodleclient.poodleclient.screen.BrowserScreen;
/*    */ import meteordevelopment.meteorclient.events.entity.player.InteractBlockEvent;
/*    */ import meteordevelopment.meteorclient.events.entity.player.InteractEntityEvent;
/*    */ import meteordevelopment.meteorclient.events.entity.player.InteractItemEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_1268;
/*    */ import net.minecraft.class_1269;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_1802;
/*    */ import net.minecraft.class_437;
/*    */ 
/*    */ public class MinefortBrowser extends Module {
/*    */   public MinefortBrowser() {
/* 18 */     super(Addon.CATEGORY, "minefort-browser", "An alternative server browser for minefort");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onInteractBlock(InteractBlockEvent e) {
/* 23 */     if (interact(e.hand))
/* 24 */       e.setCancelled(true); 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onInteractEntity(InteractEntityEvent e) {
/* 29 */     if (interact(e.hand))
/* 30 */       e.setCancelled(true); 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onInteractItem(InteractItemEvent e) {
/* 35 */     if (interact(e.hand))
/* 36 */       e.toReturn = class_1269.field_5811; 
/*    */   }
/*    */   
/*    */   private boolean interact(class_1268 hand) {
/* 40 */     if (((hand == class_1268.field_5808) ? this.mc.field_1724.method_6047() : this.mc.field_1724.method_6079()) != null && (
/* 41 */       (hand == class_1268.field_5808) ? this.mc.field_1724.method_6047() : this.mc.field_1724.method_6079()).method_31574(class_1802.field_8137)) {
/*    */       
/* 43 */       class_1799 is = (hand == class_1268.field_5808) ? this.mc.field_1724.method_6047() : this.mc.field_1724.method_6079();
/* 44 */       if (!is.method_7964().getString().equals("Server Browser (Right Click)")) return false;
/*    */       
/* 46 */       if (this.mc.field_1755 != null) return true;
/*    */       
/* 48 */       this.mc.method_1507((class_437)new BrowserScreen());
/*    */ 
/*    */       
/* 51 */       return true;
/*    */     } 
/* 53 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/MinefortBrowser.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */