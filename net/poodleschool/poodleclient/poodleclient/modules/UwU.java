/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import net.poodleschool.poodleclient.poodleclient.util.UwUSource;
/*    */ import meteordevelopment.meteorclient.events.game.SendMessageEvent;
/*    */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*    */ import meteordevelopment.meteorclient.settings.IntSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ 
/*    */ public class UwU
/*    */   extends Module {
/* 15 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*    */   
/* 17 */   private final Setting<Integer> stutterChance = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 18 */       .name("stutter-chance"))
/* 19 */       .description("UwU"))
/* 20 */       .defaultValue(Integer.valueOf(25)))
/* 21 */       .range(0, 100)
/* 22 */       .sliderRange(0, 100)
/* 23 */       .build());
/*    */ 
/*    */   
/* 26 */   private final Setting<Integer> emojiChance = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 27 */       .name("emoji-chance"))
/* 28 */       .description("OwO"))
/* 29 */       .defaultValue(Integer.valueOf(80)))
/* 30 */       .range(0, 100)
/* 31 */       .sliderRange(0, 100)
/* 32 */       .build());
/*    */ 
/*    */   
/* 35 */   private final Setting<Boolean> furry = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/* 36 */       .name("furry"))
/* 37 */       .description("bruh."))
/* 38 */       .defaultValue(Boolean.valueOf(false)))
/* 39 */       .build());
/*    */ 
/*    */   
/*    */   public UwU() {
/* 43 */     super(Addon.CATEGORY, "UwU", "yes, i have brain damage");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onChat(SendMessageEvent e) {
/* 48 */     e.message = (new UwUSource(((Integer)this.stutterChance.get()).intValue(), ((Integer)this.emojiChance.get()).intValue())).uwuify(e.message);
/*    */   }
/*    */   
/*    */   public boolean editSkins() {
/* 52 */     return (isActive() && ((Boolean)this.furry.get()).booleanValue());
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/UwU.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */