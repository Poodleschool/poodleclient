/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.packets.PacketEvent;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2743;
/*    */ import net.minecraft.class_2828;
/*    */ import net.minecraft.class_2846;
/*    */ 
/*    */ public class GrimVelocity extends Module {
/*    */   private int ticks;
/*    */   
/*    */   public GrimVelocity() {
/* 17 */     super(Addon.CATEGORY, "grim-velocity", "grim fail return v2 2024 real!1!!");
/*    */ 
/*    */     
/* 20 */     this.ticks = 0;
/*    */   }
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Pre e) {
/* 24 */     if (this.ticks > 0) {
/* 25 */       this.ticks--;
/* 26 */       if (this.ticks == 0) {
/* 27 */         for (int i = 0; i < 4; i++) {
/* 28 */           this.mc.method_1562().method_52787((class_2596)new class_2828.class_2830(this.mc.field_1724.method_23317(), this.mc.field_1724.method_23318(), this.mc.field_1724.method_23321(), this.mc.field_1724.method_36454(), this.mc.field_1724.method_36455(), this.mc.field_1724.method_24828()));
/*    */         }
/* 30 */         this.mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12973, this.mc.field_1724
/* 31 */               .method_24515(), this.mc.field_1724
/* 32 */               .method_5735().method_10153()));
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPacket(PacketEvent.Receive e) {
/* 39 */     class_2596<?> packet = e.packet;
/*    */     
/* 41 */     if ((packet instanceof class_2743 && ((class_2743)packet).method_11818() == this.mc.field_1724.method_5628()) || packet instanceof net.minecraft.class_2664) {
/* 42 */       e.setCancelled(true);
/* 43 */       this.ticks = 1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/GrimVelocity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */