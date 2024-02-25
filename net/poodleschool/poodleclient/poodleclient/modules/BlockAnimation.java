/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ 
/*     */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*     */ import net.poodleschool.poodleclient.poodleclient.events.PlayerStrideEvent;
/*     */ import meteordevelopment.meteorclient.events.render.ArmRenderEvent;
/*     */ import meteordevelopment.meteorclient.events.render.HeldItemRendererEvent;
/*     */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*     */ import meteordevelopment.meteorclient.systems.modules.combat.KillAura;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_1268;
/*     */ import net.minecraft.class_1802;
/*     */ import net.minecraft.class_4587;
/*     */ import net.minecraft.class_7833;
/*     */ import org.joml.Vector3d;
/*     */ 
/*     */ public class BlockAnimation extends Module {
/*     */   private boolean blocking;
/*     */   private SettingGroup sgGeneral;
/*     */   
/*     */   public BlockAnimation() {
/*  26 */     super(Addon.CATEGORY, "block-animation", "(WIP) 1.8.9 blocking but in 1.20.1");
/*     */ 
/*     */     
/*  29 */     this.blocking = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  39 */     this.sgGeneral = this.settings.getDefaultGroup();
/*     */     
/*  41 */     this.mode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  42 */         .name("mode"))
/*  43 */         .description("Animation Mode"))
/*  44 */         .defaultValue(Mode.Push))
/*  45 */         .build());
/*     */ 
/*     */     
/*  48 */     this.onlySword = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  49 */         .name("only-sword"))
/*  50 */         .description("Only block when holding sword"))
/*  51 */         .defaultValue(Boolean.valueOf(true)))
/*  52 */         .build());
/*     */ 
/*     */     
/*  55 */     this.onlyAura = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  56 */         .name("only-aura"))
/*  57 */         .description("Only block when targeting with KillAura"))
/*  58 */         .defaultValue(Boolean.valueOf(true)))
/*  59 */         .build());
/*     */   } private Setting<Mode> mode; private Setting<Boolean> onlySword; private Setting<Boolean> onlyAura; public enum Mode {
/*     */     Push, ReversePush, SlideDown, SlideUp, Spin; }
/*     */   public boolean isBlocking() {
/*  63 */     return (isActive() && this.blocking);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onHandRender(ArmRenderEvent e) {
/*  68 */     if (this.mc.field_1724 == null) {
/*     */       return;
/*     */     }
/*  71 */     this
/*     */       
/*  73 */       .blocking = (this.mc.field_1724.method_6047().method_7909() != class_1802.field_8162 && (!((Boolean)this.onlySword.get()).booleanValue() || this.mc.field_1724.method_6047().method_7909() instanceof net.minecraft.class_1829) && (!((Boolean)this.onlyAura.get()).booleanValue() || ((KillAura)Modules.get().get(KillAura.class)).getTarget() != null));
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onHeldItemRender(HeldItemRendererEvent event) {
/*  78 */     if (this.mc.field_1724 == null) {
/*     */       return;
/*     */     }
/*  81 */     this
/*     */       
/*  83 */       .blocking = (this.mc.field_1724.method_6047().method_7909() != class_1802.field_8162 && (!((Boolean)this.onlySword.get()).booleanValue() || this.mc.field_1724.method_6047().method_7909() instanceof net.minecraft.class_1829) && (!((Boolean)this.onlyAura.get()).booleanValue() || ((KillAura)Modules.get().get(KillAura.class)).getTarget() != null));
/*     */     
/*  85 */     if (event.hand == class_1268.field_5808 && this.blocking) {
/*  86 */       float swingProgress = this.mc.field_1724.method_6055(this.mc.method_1488());
/*  87 */       double sinAnimation = Math.sin(Math.toRadians((swingProgress * 180.0F)));
/*  88 */       switch ((Mode)this.mode.get()) {
/*     */         
/*     */         case Push:
/*  91 */           rotate(event.matrix, new Vector3d(-100.0D, 0.0D, 71.0D - sinAnimation * 20.0D));
/*  92 */           scale(event.matrix, new Vector3d(1.0D, 1.0D, 1.0D));
/*  93 */           translate(event.matrix, new Vector3d(-0.1D, 0.2D, 0.1D));
/*     */           break;
/*     */         
/*     */         case ReversePush:
/*  97 */           rotate(event.matrix, new Vector3d(-100.0D, 0.0D, 71.0D + sinAnimation * 20.0D));
/*  98 */           scale(event.matrix, new Vector3d(1.0D, 1.0D, 1.0D));
/*  99 */           translate(event.matrix, new Vector3d(-0.1D, 0.2D, 0.1D));
/*     */           break;
/*     */         
/*     */         case SlideUp:
/* 103 */           rotate(event.matrix, new Vector3d(-100.0D, 0.0D, 71.0D));
/* 104 */           scale(event.matrix, new Vector3d(1.0D, 1.0D, 1.0D));
/* 105 */           translate(event.matrix, new Vector3d(-0.1D, 0.2D, 0.1D + sinAnimation / 20.0D));
/*     */           break;
/*     */         
/*     */         case SlideDown:
/* 109 */           rotate(event.matrix, new Vector3d(-100.0D, 0.0D, 71.0D));
/* 110 */           scale(event.matrix, new Vector3d(1.0D, 1.0D, 1.0D));
/* 111 */           translate(event.matrix, new Vector3d(-0.1D, 0.2D, 0.1D - sinAnimation / 20.0D));
/*     */           break;
/*     */         
/*     */         case Spin:
/* 115 */           rotate(event.matrix, new Vector3d(-100.0D, 0.0D - sinAnimation * 20.0D, 71.0D));
/* 116 */           scale(event.matrix, new Vector3d(1.0D, 1.0D, 1.0D));
/* 117 */           translate(event.matrix, new Vector3d(-0.1D, 0.2D, 0.1D));
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler(priority = -100)
/*     */   private void onStride(PlayerStrideEvent e) {
/* 126 */     if (this.blocking)
/* 127 */       e.setStrideForce(0.0F); 
/*     */   }
/*     */   
/*     */   private void rotate(class_4587 matrix, Vector3d rotation) {
/* 131 */     matrix.method_22907(class_7833.field_40714.rotationDegrees((float)rotation.x));
/* 132 */     matrix.method_22907(class_7833.field_40716.rotationDegrees((float)rotation.y));
/* 133 */     matrix.method_22907(class_7833.field_40718.rotationDegrees((float)rotation.z));
/*     */   }
/*     */   
/*     */   private void scale(class_4587 matrix, Vector3d scale) {
/* 137 */     matrix.method_22905((float)scale.x, (float)scale.y, (float)scale.z);
/*     */   }
/*     */   
/*     */   private void translate(class_4587 matrix, Vector3d translation) {
/* 141 */     matrix.method_46416((float)translation.x, (float)translation.y, (float)translation.z);
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/BlockAnimation.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */