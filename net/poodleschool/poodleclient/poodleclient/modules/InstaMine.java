/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import meteordevelopment.meteorclient.events.entity.player.InteractBlockEvent;
/*     */ import meteordevelopment.meteorclient.events.entity.player.StartBreakingBlockEvent;
/*     */ import meteordevelopment.meteorclient.events.render.Render3DEvent;
/*     */ import meteordevelopment.meteorclient.renderer.ShapeMode;
/*     */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*     */ import meteordevelopment.meteorclient.settings.ColorSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.IntSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.utils.player.Rotations;
/*     */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*     */ import meteordevelopment.meteorclient.utils.render.color.SettingColor;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_1268;
/*     */ import net.minecraft.class_1802;
/*     */ import net.minecraft.class_2338;
/*     */ import net.minecraft.class_2350;
/*     */ import net.minecraft.class_2596;
/*     */ import net.minecraft.class_2846;
/*     */ 
/*     */ public class InstaMine extends Module {
/*  27 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*  28 */   private final SettingGroup sgRender = this.settings.createGroup("Render");
/*     */   
/*  30 */   private final Setting<Integer> tickDelay = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/*  31 */       .name("delay"))
/*  32 */       .description("The delay between breaks."))
/*  33 */       .defaultValue(Integer.valueOf(0)))
/*  34 */       .min(0)
/*  35 */       .sliderMax(20)
/*  36 */       .build());
/*     */ 
/*     */   
/*  39 */   private final Setting<Boolean> pick = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  40 */       .name("only-pick"))
/*  41 */       .description("Only tries to mine the block if you are holding a pickaxe."))
/*  42 */       .defaultValue(Boolean.valueOf(true)))
/*  43 */       .build());
/*     */ 
/*     */   
/*  46 */   private final Setting<Boolean> rotate = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  47 */       .name("rotate"))
/*  48 */       .description("Faces the blocks being mined server side."))
/*  49 */       .defaultValue(Boolean.valueOf(true)))
/*  50 */       .build());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   private final Setting<Boolean> render = this.sgRender.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  56 */       .name("render"))
/*  57 */       .description("Renders a block overlay on the block being broken."))
/*  58 */       .defaultValue(Boolean.valueOf(true)))
/*  59 */       .build());
/*     */ 
/*     */   
/*  62 */   private final Setting<ShapeMode> shapeMode = this.sgRender.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  63 */       .name("shape-mode"))
/*  64 */       .description("How the shapes are rendered."))
/*  65 */       .defaultValue(ShapeMode.Both))
/*  66 */       .build());
/*     */ 
/*     */   
/*  69 */   private final Setting<SettingColor> sideColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)(new ColorSetting.Builder())
/*  70 */       .name("side-color"))
/*  71 */       .description("The color of the sides of the blocks being rendered."))
/*  72 */       .defaultValue(new SettingColor(204, 0, 0, 10))
/*  73 */       .build());
/*     */ 
/*     */   
/*  76 */   private final Setting<SettingColor> lineColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)(new ColorSetting.Builder())
/*  77 */       .name("line-color"))
/*  78 */       .description("The color of the lines of the blocks being rendered."))
/*  79 */       .defaultValue(new SettingColor(204, 0, 0, 255))
/*  80 */       .build());
/*     */ 
/*     */   
/*     */   private int ticks;
/*     */   
/*  85 */   private final class_2338.class_2339 blockPos = new class_2338.class_2339(0, -1, 0);
/*     */   
/*     */   private class_2350 direction;
/*  88 */   private HashMap<class_2338.class_2339, class_2350> map = new HashMap<>();
/*     */   
/*     */   public InstaMine() {
/*  91 */     super(Addon.CATEGORY, "insta-mine+", "Attempts to instantly mine blocks.");
/*     */   }
/*     */ 
/*     */   
/*     */   public void onActivate() {
/*  96 */     this.ticks = 0;
/*  97 */     this.blockPos.method_10103(0, -128, 0);
/*  98 */     this.map.clear();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onStartBreakingBlock(StartBreakingBlockEvent event) {
/* 103 */     this.direction = event.direction;
/* 104 */     this.blockPos.method_10101((class_2382)event.blockPos);
/* 105 */     this.map.put(event.blockPos.method_25503(), this.direction);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onRightClick(InteractBlockEvent event) {
/* 110 */     this.map.remove(event.result.method_17777().method_25503());
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onTick(TickEvent.Pre event) {
/* 115 */     if (this.ticks >= ((Integer)this.tickDelay.get()).intValue()) {
/* 116 */       this.ticks = 0;
/*     */       
/* 118 */       if (shouldMine()) {
/* 119 */         if (((Boolean)this.rotate.get()).booleanValue()) {
/* 120 */           for (Map.Entry<class_2338.class_2339, class_2350> entry : this.map.entrySet()) {
/* 121 */             Rotations.rotate(Rotations.getYaw((class_2338)entry.getKey()), Rotations.getPitch((class_2338)entry.getKey()), () -> this.mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12973, (class_2338)entry.getKey(), (class_2350)entry.getValue())));
/*     */           }
/*     */         } else {
/*     */           
/* 125 */           for (Map.Entry<class_2338.class_2339, class_2350> entry : this.map.entrySet()) {
/* 126 */             this.mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12973, (class_2338)entry.getKey(), entry.getValue()));
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 131 */         this.mc.method_1562().method_52787((class_2596)new class_2879(class_1268.field_5808));
/*     */       } 
/*     */     } else {
/*     */       
/* 135 */       this.ticks++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean shouldMine() {
/* 140 */     if (this.blockPos.method_10264() == -128) return false; 
/* 141 */     if (!BlockUtils.canBreak((class_2338)this.blockPos)) return false; 
/* 142 */     return (!((Boolean)this.pick.get()).booleanValue() || this.mc.field_1724.method_6047().method_7909() == class_1802.field_8377 || this.mc.field_1724.method_6047().method_7909() == class_1802.field_22024);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onRender(Render3DEvent event) {
/* 147 */     if (!((Boolean)this.render.get()).booleanValue() || !shouldMine())
/* 148 */       return;  for (class_2338.class_2339 pos : this.map.keySet())
/* 149 */       event.renderer.box((class_2338)pos, (Color)this.sideColor.get(), (Color)this.lineColor.get(), (ShapeMode)this.shapeMode.get(), 0); 
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/InstaMine.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */