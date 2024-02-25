/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ 
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.settings.DoubleSetting;
/*    */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import meteordevelopment.meteorclient.utils.player.Rotations;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ 
/*    */ public class RotationSpoof extends Module {
/* 14 */   private final SettingGroup sgYaw = this.settings.createGroup("Yaw");
/* 15 */   private final SettingGroup sgPitch = this.settings.createGroup("Pitch");
/*    */   
/*    */   public enum YawMode
/*    */   {
/* 19 */     None,
/* 20 */     Fixed,
/* 21 */     Spin,
/* 22 */     Inverted;
/*    */   }
/*    */ 
/*    */   
/*    */   public enum PitchMode
/*    */   {
/* 28 */     None,
/* 29 */     Fixed,
/* 30 */     Inverted;
/*    */   }
/*    */ 
/*    */   
/* 34 */   private final Setting<YawMode> yawMode = this.sgYaw.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/* 35 */       .name("yaw-mode"))
/* 36 */       .defaultValue(YawMode.Fixed))
/* 37 */       .build());
/*    */ 
/*    */   
/* 40 */   private final Setting<Double> yawAngle = this.sgYaw.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/* 41 */       .name("yaw-angle"))
/* 42 */       .description("Yaw angle in degrees."))
/* 43 */       .defaultValue(0.0D)
/* 44 */       .sliderMax(360.0D)
/* 45 */       .max(360.0D)
/* 46 */       .visible(() -> (this.yawMode.get() == YawMode.Fixed)))
/* 47 */       .build());
/*    */ 
/*    */   
/* 50 */   private final Setting<Double> yawSpinSpeed = this.sgYaw.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/* 51 */       .name("yaw-spin-speed"))
/* 52 */       .description("Yaw spin speed"))
/* 53 */       .defaultValue(5.0D)
/* 54 */       .sliderRange(1.0D, 5.0D)
/* 55 */       .visible(() -> (this.yawMode.get() == YawMode.Spin)))
/* 56 */       .build());
/*    */ 
/*    */   
/* 59 */   private final Setting<PitchMode> pitchMode = this.sgPitch.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/* 60 */       .name("pitch-mode"))
/* 61 */       .defaultValue(PitchMode.Fixed))
/* 62 */       .build());
/*    */ 
/*    */   
/* 65 */   private final Setting<Double> pitchAngle = this.sgPitch.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/* 66 */       .name("pitch-angle"))
/* 67 */       .description("Pitch angle in degrees."))
/* 68 */       .defaultValue(0.0D)
/* 69 */       .range(-90.0D, 90.0D)
/* 70 */       .sliderRange(-90.0D, 90.0D)
/* 71 */       .visible(() -> (this.pitchMode.get() == PitchMode.Fixed)))
/* 72 */       .build());
/*    */ 
/*    */   
/*    */   public RotationSpoof() {
/* 76 */     super(Addon.CATEGORY, "rotation-spoof", "Spoofs your Server-Side rotation.");
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Pre ignored) {
/* 81 */     if (this.mc.field_1724 == null) {
/*    */       return;
/*    */     }
/* 84 */     switch ((YawMode)this.yawMode.get()) { default: throw new IncompatibleClassChangeError();
/*    */       case None: 
/*    */       case Fixed: 
/*    */       case Inverted: 
/*    */       case null:
/* 89 */         break; }  double yaw = (180.0F + this.mc.field_1724.method_5705(this.mc.method_1488()));
/*    */ 
/*    */     
/* 92 */     switch ((PitchMode)this.pitchMode.get()) { default: throw new IncompatibleClassChangeError();
/*    */       case None: 
/*    */       case Fixed: 
/*    */       case Inverted:
/* 96 */         break; }  double pitch = -this.mc.field_1724.method_5695(this.mc.method_1488());
/*    */ 
/*    */     
/* 99 */     Rotations.rotate(yaw, pitch);
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/RotationSpoof.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */