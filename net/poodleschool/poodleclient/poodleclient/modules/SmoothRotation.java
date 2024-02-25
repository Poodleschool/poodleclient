/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ 
/*     */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*     */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*     */ import meteordevelopment.meteorclient.settings.DoubleSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*     */ import meteordevelopment.meteorclient.systems.modules.combat.KillAura;
/*     */ import meteordevelopment.meteorclient.utils.entity.Target;
/*     */ import meteordevelopment.meteorclient.utils.player.Rotations;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_1297;
/*     */ import org.joml.Math;
/*     */ 
/*     */ public class SmoothRotation
/*     */   extends Module
/*     */ {
/*     */   public enum Mode
/*     */   {
/*  23 */     Custom,
/*  24 */     Line,
/*  25 */     Quad,
/*  26 */     Sine,
/*  27 */     QuadSine;
/*     */   }
/*     */ 
/*     */   
/*  31 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*     */   
/*  33 */   private final Setting<Mode> mode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  34 */       .name("mode"))
/*  35 */       .description("RotationMode"))
/*  36 */       .defaultValue(Mode.Custom))
/*  37 */       .build());
/*     */ 
/*     */   
/*  40 */   private final Setting<Double> rotationSmoothValue = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/*  41 */       .name("rotation-smooth-value"))
/*  42 */       .description("Rotation Speed"))
/*  43 */       .range(1.0D, 10.0D)
/*  44 */       .defaultValue(2.0D)
/*  45 */       .visible(() -> (this.mode.get() == Mode.Custom)))
/*  46 */       .build());
/*     */ 
/*     */   
/*  49 */   private final Setting<Double> maxTurnSpeedValue = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/*  50 */       .name("max-turn-speed"))
/*  51 */       .description("Rotation Speed"))
/*  52 */       .range(1.0D, 360.0D)
/*  53 */       .sliderRange(1.0D, 360.0D)
/*  54 */       .defaultValue(360.0D)
/*  55 */       .visible(() -> (this.mode.get() != Mode.Custom)))
/*  56 */       .build());
/*     */ 
/*     */   
/*  59 */   private final Setting<Double> minTurnSpeedValue = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/*  60 */       .name("min-turn-speed"))
/*  61 */       .description("Rotation Speed"))
/*  62 */       .range(1.0D, 360.0D)
/*  63 */       .sliderRange(1.0D, 360.0D)
/*  64 */       .defaultValue(360.0D)
/*  65 */       .visible(() -> (this.mode.get() != Mode.Custom)))
/*  66 */       .build());
/*     */   private boolean lastTarget;
/*     */   
/*     */   public SmoothRotation() {
/*  70 */     super(Addon.CATEGORY, "smooth-rotation", "Smooth Kill Aura Rotations. Turn off rotations in KillAura!");
/*     */ 
/*     */     
/*  73 */     this.lastTarget = false;
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onTick(TickEvent.Post event) {
/*  79 */     double v = ((Double)this.minTurnSpeedValue.get()).doubleValue();
/*  80 */     if (v > ((Double)this.maxTurnSpeedValue.get()).doubleValue()) this.maxTurnSpeedValue.set(Double.valueOf(v));
/*     */ 
/*     */     
/*  83 */     v = ((Double)this.maxTurnSpeedValue.get()).doubleValue();
/*  84 */     if (v < ((Double)this.minTurnSpeedValue.get()).doubleValue()) this.minTurnSpeedValue.set(Double.valueOf(v));
/*     */ 
/*     */     
/*  87 */     class_1297 ent = ((KillAura)Modules.get().get(KillAura.class)).getTarget();
/*  88 */     if (ent == null) {
/*  89 */       this.lastTarget = false;
/*     */       
/*     */       return;
/*     */     } 
/*  93 */     this.lastTarget = true;
/*     */     
/*  95 */     AngleRot directRotation = new AngleRot((float)Rotations.getYaw(ent), (float)Rotations.getPitch(ent, Target.Head));
/*  96 */     float diffAngle = (float)getRotationDifference(AngleRot.server(), directRotation);
/*  97 */     if (diffAngle < 0.0F) diffAngle = -diffAngle; 
/*  98 */     if (diffAngle > 180.0F) diffAngle = 180.0F;
/*     */     
/* 100 */     switch ((Mode)this.mode.get()) { default: throw new IncompatibleClassChangeError();
/*     */       case Custom: 
/*     */       case Line: 
/*     */       case Quad: 
/*     */       case Sine: 
/* 105 */       case QuadSine: break; }  float calculateSpeed = (float)(Math.pow(-Math.cos((diffAngle / 180.0F) * Math.PI) * 0.5D + 0.5D, 2.0D) * ((Double)this.maxTurnSpeedValue.get()).doubleValue() + (1.0D - Math.pow(-Math.cos((diffAngle / 180.0F) * Math.PI) * 0.5D + 0.5D, 2.0D)) * ((Double)this.minTurnSpeedValue.get()).doubleValue());
/*     */ 
/*     */     
/* 108 */     AngleRot rot = limitAngleChange(
/* 109 */         AngleRot.server(), directRotation, calculateSpeed);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     Rotations.rotate(rot.getYaw(), rot.getPitch());
/*     */     
/* 116 */     this.mc.field_1724.method_5728(false);
/*     */   }
/*     */   
/*     */   public static double getRotationDifference(AngleRot a, AngleRot b) {
/* 120 */     return Math.hypot(getAngleDifference(a.getYaw(), b.getYaw()), (a.getPitch() - b.getPitch()));
/*     */   }
/*     */   
/*     */   public static float getAngleDifference(float a, float b) {
/* 124 */     return ((a - b) % 360.0F + 540.0F) % 360.0F - 180.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static AngleRot limitAngleChange(AngleRot currentRotation, AngleRot targetRotation, float turnSpeed) {
/* 129 */     float yawDifference = getAngleDifference(targetRotation.getYaw(), currentRotation.getYaw());
/* 130 */     float pitchDifference = getAngleDifference(targetRotation.getPitch(), currentRotation.getPitch());
/*     */     
/* 132 */     return new AngleRot(currentRotation
/* 133 */         .getYaw() + ((yawDifference > turnSpeed) ? turnSpeed : Math.max(yawDifference, -turnSpeed)), currentRotation
/* 134 */         .getPitch() + ((pitchDifference > turnSpeed) ? turnSpeed : Math.max(pitchDifference, -turnSpeed)));
/*     */   }
/*     */   
/*     */   public static class AngleRot { private float yaw;
/*     */     private float pitch;
/*     */     
/*     */     public static AngleRot server() {
/* 141 */       return new AngleRot(Rotations.serverYaw, Rotations.serverPitch);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public AngleRot(float yaw, float pitch) {
/* 147 */       this.yaw = yaw;
/* 148 */       this.pitch = pitch;
/*     */     }
/*     */     
/*     */     public float getYaw() {
/* 152 */       return this.yaw;
/*     */     }
/*     */     
/*     */     public float getPitch() {
/* 156 */       return this.pitch;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/SmoothRotation.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */