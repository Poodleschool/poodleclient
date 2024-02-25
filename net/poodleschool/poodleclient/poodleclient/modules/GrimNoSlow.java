/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.settings.IntSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_1713;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_1802;
/*    */ import net.minecraft.class_1935;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2813;
/*    */ 
/*    */ public class GrimNoSlow extends Module {
/* 19 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*    */   
/* 21 */   private Setting<Integer> slotIndex = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 22 */       .name("slot-index"))
/* 23 */       .description("The slotIndex of the Packet"))
/* 24 */       .noSlider()
/* 25 */       .defaultValue(Integer.valueOf(36)))
/* 26 */       .build());
/*    */ 
/*    */   
/* 29 */   private Setting<Integer> button = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 30 */       .name("button"))
/* 31 */       .description("The button of the Packet"))
/* 32 */       .noSlider()
/* 33 */       .defaultValue(Integer.valueOf(0)))
/* 34 */       .build());
/*    */ 
/*    */   
/*    */   private boolean packetSent;
/*    */ 
/*    */   
/* 40 */   private int timer = 0;
/*    */   
/*    */   public GrimNoSlow() {
/* 43 */     super(Addon.CATEGORY, "grim-no-slow", "GRIM FAIL 2023 COPE VERY HALAL XDDDD");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onActivate() {
/* 49 */     this.packetSent = false;
/* 50 */     this.timer = 0;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Post e) {
/* 55 */     if (this.mc.field_1724 == null) {
/*    */       return;
/*    */     }
/* 58 */     if (this.timer > 0) {
/* 59 */       this.timer--;
/*    */     }
/* 61 */     if (this.timer == 0 && this.mc.field_1724.method_6115()) {
/* 62 */       for (int i = 0; i < 2; i++) {
/* 63 */         Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap();
/* 64 */         int2ObjectOpenHashMap.put(0, new class_1799((class_1935)class_1802.field_8094));
/* 65 */         this.mc.field_1724.field_3944.method_52787((class_2596)new class_2813(this.mc.field_1724.field_7512.field_7763, this.mc.field_1724.field_7512.method_37421(), 36, 0, class_1713.field_7791, this.mc.field_1724.field_7512.method_34255(), (Int2ObjectMap)int2ObjectOpenHashMap));
/*    */       } 
/* 67 */       this.packetSent = true;
/* 68 */       this.timer = 5;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canNoSlow() {
/* 99 */     return (isActive() && this.packetSent);
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/GrimNoSlow.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */