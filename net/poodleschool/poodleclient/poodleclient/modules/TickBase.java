/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.settings.DoubleSetting;
/*    */ import meteordevelopment.meteorclient.settings.IntSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*    */ import meteordevelopment.meteorclient.systems.modules.world.Timer;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ 
/*    */ public class TickBase
/*    */   extends Module {
/* 16 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*    */   
/*    */   private boolean lastTick = false;
/*    */   
/* 20 */   public final Setting<Double> timer = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/* 21 */       .name("timer"))
/* 22 */       .description("Timer override."))
/* 23 */       .defaultValue(1.0D)
/* 24 */       .min(0.01D)
/* 25 */       .sliderMin(0.01D)
/* 26 */       .sliderMax(10.0D)
/* 27 */       .build());
/*    */ 
/*    */   
/* 30 */   public final Setting<Integer> length = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 31 */       .name("length"))
/* 32 */       .description("How long to slow down"))
/* 33 */       .defaultValue(Integer.valueOf(3)))
/* 34 */       .range(1, 20)
/* 35 */       .build());
/*    */ 
/*    */   
/*    */   public TickBase() {
/* 39 */     super(Addon.CATEGORY, "tick-base", "Slows down your Game when you take Damage");
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDeactivate() {
/* 44 */     ((Timer)Modules.get().get(Timer.class)).setOverride(1.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Post e) {
/* 52 */     assert this.mc.field_1724 != null;
/* 53 */     if (this.mc.field_1724.field_6235 > this.mc.field_1724.field_6254 - ((Integer)this.length.get()).intValue() && this.mc.field_1724.field_6235 != 0) {
/* 54 */       ((Timer)Modules.get().get(Timer.class)).setOverride(((Double)this.timer.get()).doubleValue());
/* 55 */       this.lastTick = true;
/* 56 */     } else if (this.lastTick) {
/* 57 */       this.lastTick = false;
/* 58 */       ((Timer)Modules.get().get(Timer.class)).setOverride(1.0D);
/* 59 */       Strafe.strafe((float)this.mc.field_1724.method_18798().method_37267(), Strafe.getDirection());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/TickBase.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */