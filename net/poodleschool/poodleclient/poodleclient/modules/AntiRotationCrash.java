/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_3532;
/*    */ 
/*    */ public class AntiRotationCrash
/*    */   extends Module {
/*    */   public AntiRotationCrash() {
/* 12 */     super(Addon.CATEGORY, "anti-rotation-crash", "");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Pre event) {
/* 17 */     this.mc.field_1724.method_36456(class_3532.method_15393(this.mc.field_1724.method_5705(this.mc.method_1488())));
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/AntiRotationCrash.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */