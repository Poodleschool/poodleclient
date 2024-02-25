/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import net.poodleschool.poodleclient.poodleclient.events.PlayerStrideEvent;
/*    */ import java.util.List;
/*    */ import meteordevelopment.meteorclient.settings.DoubleSetting;
/*    */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*    */ import meteordevelopment.meteorclient.settings.ModuleListSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ 
/*    */ public class AirStride extends Module {
/*    */   public enum Mode {
/* 15 */     WhenEnabled,
/* 16 */     WhenModule;
/*    */   }
/*    */ 
/*    */   
/* 20 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*    */   
/* 22 */   private final Setting<Mode> mode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/* 23 */       .name("mode"))
/* 24 */       .description("Activation mode"))
/* 25 */       .defaultValue(Mode.WhenEnabled))
/* 26 */       .build());
/*    */ 
/*    */   
/* 29 */   private final Setting<List<Module>> modules = this.sgGeneral.add((Setting)((ModuleListSetting.Builder)((ModuleListSetting.Builder)((ModuleListSetting.Builder)(new ModuleListSetting.Builder())
/* 30 */       .name("modules"))
/* 31 */       .description("Modules for activation"))
/* 32 */       .visible(() -> (this.mode.get() == Mode.WhenModule)))
/* 33 */       .build());
/*    */ 
/*    */   
/* 36 */   private final Setting<Double> strength = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/* 37 */       .name("strength"))
/* 38 */       .description("Controls the Strength of the Bobbing"))
/* 39 */       .noSlider()
/* 40 */       .build());
/*    */ 
/*    */   
/*    */   public AirStride() {
/* 44 */     super(Addon.CATEGORY, "air-stride", "View Bobbing in the Air");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onStride(PlayerStrideEvent e) {
/* 49 */     if (this.mode.get() == Mode.WhenModule) {
/* 50 */       for (Module module : this.modules.get()) {
/* 51 */         if (module != null && module.isActive()) {
/* 52 */           e.setStrideForce(((Double)this.strength.get()).floatValue());
/*    */           return;
/*    */         } 
/*    */       } 
/*    */     } else {
/* 57 */       e.setStrideForce(((Double)this.strength.get()).floatValue());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/AirStride.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */