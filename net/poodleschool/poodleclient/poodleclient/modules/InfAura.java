/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ 
/*     */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import meteordevelopment.meteorclient.events.render.Render3DEvent;
/*     */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*     */ import meteordevelopment.meteorclient.settings.EntityTypeListSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.systems.friends.Friends;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.utils.entity.SortPriority;
/*     */ import meteordevelopment.meteorclient.utils.entity.TargetUtils;
/*     */ import meteordevelopment.meteorclient.utils.player.PlayerUtils;
/*     */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1299;
/*     */ import net.minecraft.class_1309;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_2596;
/*     */ import net.minecraft.class_2828;
/*     */ import net.minecraft.class_310;
/*     */ 
/*     */ public class InfAura
/*     */   extends Module {
/*  32 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*     */   
/*  34 */   private final Setting<SortPriority> priority = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  35 */       .name("priority"))
/*  36 */       .description("How to filter targets within range."))
/*  37 */       .defaultValue(SortPriority.LowestHealth))
/*  38 */       .build());
/*     */ 
/*     */   
/*  41 */   private final Setting<Set<class_1299<?>>> entities = this.sgGeneral.add((Setting)((EntityTypeListSetting.Builder)((EntityTypeListSetting.Builder)(new EntityTypeListSetting.Builder())
/*  42 */       .name("entities"))
/*  43 */       .description("Entities to attack."))
/*  44 */       .onlyAttackable()
/*  45 */       .build());
/*     */   public List<class_243> positions;
/*     */   
/*     */   public InfAura() {
/*  49 */     super(Addon.CATEGORY, "inf-aura", "xd");
/*     */ 
/*     */     
/*  52 */     this.positions = new ArrayList<>();
/*     */   }
/*     */   @EventHandler
/*     */   public void onTick(TickEvent.Pre e) {
/*  56 */     if (this.mc.field_1724 == null || this.mc.field_1687 == null || this.mc.field_1761 == null)
/*     */       return; 
/*  58 */     if (this.mc.field_1724.method_7261(0.0F) < 1.0F) {
/*     */       return;
/*     */     }
/*  61 */     this.positions.clear();
/*     */     
/*  63 */     List<class_1297> targets = new ArrayList<>();
/*  64 */     TargetUtils.getList(targets, this::entityCheck, (SortPriority)this.priority.get(), 1);
/*  65 */     Optional<class_1297> entity = Optional.empty();
/*  66 */     if (!targets.isEmpty()) entity = Optional.of(targets.get(0));
/*     */     
/*  68 */     class_243 op = this.mc.field_1724.method_19538();
/*  69 */     if (entity.isPresent()) {
/*  70 */       class_243 playerPos = this.mc.field_1724.method_19538();
/*  71 */       teleportFromTo(this.mc, playerPos, ((class_1297)entity.get()).method_19538());
/*  72 */       this.mc.field_1761.method_2918((class_1657)this.mc.field_1724, entity.get());
/*  73 */       teleportFromTo(this.mc, ((class_1297)entity.get()).method_19538(), playerPos);
/*  74 */       this.mc.field_1724.method_33574(playerPos);
/*  75 */       while (op != this.mc.field_1724.method_19538())
/*  76 */         teleportFromTo(this.mc, this.mc.field_1724.method_19538(), op); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onRender3D(Render3DEvent e) {
/*  82 */     class_243 prev = null;
/*  83 */     for (class_243 position : this.positions) {
/*  84 */       if (prev == null) {
/*  85 */         prev = position; continue;
/*     */       } 
/*  87 */       e.renderer.line(prev.field_1352, prev.field_1351, prev.field_1350, position.field_1352, position.field_1351, position.field_1350, Color.WHITE);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void teleportFromTo(class_310 mc, class_243 fromPos, class_243 toPos) {
/*  92 */     if (mc.field_1724 == null)
/*  93 */       return;  double distancePerBlock = 8.5D;
/*  94 */     double targetDistance = Math.ceil(fromPos.method_1022(toPos) / distancePerBlock);
/*  95 */     for (int i = 1; i <= targetDistance; i++) {
/*  96 */       class_243 tempPos = fromPos.method_35590(toPos, i / targetDistance);
/*  97 */       this.positions.add(tempPos);
/*  98 */       mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2829(tempPos.field_1352, tempPos.field_1351, tempPos.field_1350, true));
/*  99 */       if (i % 4 == 0) {
/*     */         try {
/* 101 */           Thread.sleep(0L);
/* 102 */         } catch (InterruptedException interruptedException) {}
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean entityCheck(class_1297 entity) {
/* 108 */     if (entity.equals(this.mc.field_1724) || entity.equals(this.mc.field_1719)) return false; 
/* 109 */     if ((entity instanceof class_1309 && ((class_1309)entity).method_29504()) || !entity.method_5805()) return false; 
/* 110 */     if (!((Set)this.entities.get()).contains(entity.method_5864())) return false; 
/* 111 */     if (!PlayerUtils.isWithin(entity, 150.0D)) return false;
/*     */     
/* 113 */     if (entity instanceof class_1657) { class_1657 player = (class_1657)entity;
/* 114 */       if (player.method_7337()) return false; 
/* 115 */       if (!Friends.get().shouldAttack(player)) return false;  }
/*     */     
/* 117 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/InfAura.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */