/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*     */ import meteordevelopment.meteorclient.events.entity.player.AttackEntityEvent;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.IntSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_1109;
/*     */ import net.minecraft.class_1113;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1309;
/*     */ import net.minecraft.class_2246;
/*     */ import net.minecraft.class_2394;
/*     */ import net.minecraft.class_2398;
/*     */ import net.minecraft.class_3417;
/*     */ 
/*     */ public class AttackEffects extends Module {
/*     */   public enum Particle {
/*  21 */     None,
/*  22 */     Blood,
/*  23 */     Fire,
/*  24 */     Heart,
/*  25 */     Water,
/*  26 */     Smoke,
/*  27 */     Magic,
/*  28 */     Crits;
/*     */   }
/*     */   
/*     */   public enum Sound {
/*  32 */     None,
/*  33 */     Hit,
/*  34 */     Orb;
/*     */   }
/*     */   
/*  37 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*     */   
/*  39 */   private final Setting<Particle> particle = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  40 */       .name("particle"))
/*  41 */       .defaultValue(Particle.Fire))
/*  42 */       .build());
/*     */ 
/*     */   
/*  45 */   private final Setting<Integer> particleAmount = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/*  46 */       .name("particle-amount"))
/*  47 */       .range(1, 20)
/*  48 */       .defaultValue(Integer.valueOf(1)))
/*  49 */       .build());
/*     */ 
/*     */   
/*  52 */   private final Setting<Sound> sound = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  53 */       .name("sound"))
/*  54 */       .defaultValue(Sound.Orb))
/*  55 */       .build());
/*     */ 
/*     */   
/*     */   public AttackEffects() {
/*  59 */     super(Addon.CATEGORY, "attack-effects", "Show effects when you hit an entity.");
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onAttack(AttackEntityEvent e) {
/*  64 */     class_1297 class_1297 = e.entity; if (class_1297 instanceof class_1309) { class_1309 ent = (class_1309)class_1297;
/*  65 */       for (int i = 0; i < ((Integer)this.particleAmount.get()).intValue(); i++) {
/*  66 */         doEffect(ent);
/*     */       }
/*  68 */       doSound(); }
/*     */   
/*     */   }
/*     */   
/*     */   private void doSound() {
/*  73 */     if (this.sound.get() == Sound.None)
/*  74 */       return;  switch ((Sound)this.sound
/*  75 */       .get()) { default: throw new IncompatibleClassChangeError();
/*     */       case Blood: 
/*     */       case Fire: 
/*  78 */       case Heart: break; }  this.mc.method_1483().method_4873((class_1113)class_1109.method_4758(class_3417.field_14627, 1.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doEffect(class_1309 target) {
/*  84 */     if (this.particle.get() == Particle.None)
/*  85 */       return;  switch ((Particle)this.particle.get()) { case Blood:
/*  86 */         target.method_37908().method_31595(target
/*  87 */             .method_24515().method_10086(1), class_2246.field_10002
/*  88 */             .method_9564()); break;
/*     */       case Fire:
/*  90 */         this.mc.field_1713.method_3061((class_1297)target, (class_2394)class_2398.field_11239); break;
/*  91 */       case Heart: this.mc.field_1713.method_3061((class_1297)target, (class_2394)class_2398.field_11201); break;
/*  92 */       case Water: this.mc.field_1713.method_3061((class_1297)target, (class_2394)class_2398.field_18306); break;
/*  93 */       case Smoke: this.mc.field_1713.method_3061((class_1297)target, (class_2394)class_2398.field_11251); break;
/*  94 */       case Magic: this.mc.field_1713.method_3061((class_1297)target, (class_2394)class_2398.field_11208); break;
/*  95 */       case Crits: this.mc.field_1713.method_3061((class_1297)target, (class_2394)class_2398.field_11205);
/*     */         break;
/*     */       case None:
/*     */         return; }
/*     */   
/*     */   } public boolean shouldPlaySound() {
/* 101 */     return (isActive() && this.sound.get() != Sound.None);
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/AttackEffects.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */