/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.packets.PacketEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2846;
/*    */ 
/*    */ public class GrimSpeedMine extends Module {
/*    */   public GrimSpeedMine() {
/* 13 */     super(Addon.CATEGORY, "grim-speed-mine", "use with normal speed mine");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPacket(PacketEvent.Send event) {
/* 18 */     class_2596<?> packet = event.packet;
/* 19 */     if (packet instanceof class_2846 && ((class_2846)packet).method_12363() == class_2846.class_2847.field_12973) {
/* 20 */       class_2338 blockPos = ((class_2846)packet).method_12362();
/*    */       
/* 22 */       this.mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12971, blockPos.method_10084(), ((class_2846)packet).method_12360()));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/GrimSpeedMine.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */