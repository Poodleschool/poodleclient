/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.meteorclient.utils.player.PlayerUtils;
/*    */ import meteordevelopment.meteorclient.utils.player.Rotations;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_742;
/*    */ 
/*    */ public class AutoSneakAt extends Module {
/*    */   public AutoSneakAt() {
/* 14 */     super(Addon.CATEGORY, "auto-sneak-at", "\"i sexed your mom :>\"");
/*    */ 
/*    */     
/* 17 */     this.sneak = false;
/*    */   } private boolean sneak;
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Pre e) {
/* 21 */     class_742 ent = this.mc.field_1687.method_18456().stream().filter(p -> (p != this.mc.field_1724)).filter(p -> PlayerUtils.isWithin((class_1297)p, 1.0D)).findAny().orElse(null);
/*    */     
/* 23 */     if (ent != null)
/* 24 */     { Rotations.rotate(180.0D + Rotations.getYaw((class_1297)ent), 90.0D);
/* 25 */       this.sneak = !this.sneak; }
/* 26 */     else { this.sneak = false; }
/*    */   
/*    */   }
/*    */   
/*    */   public boolean doSneak() {
/* 31 */     return this.sneak;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/AutoSneakAt.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */