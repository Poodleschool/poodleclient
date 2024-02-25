/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import meteordevelopment.meteorclient.events.render.Render3DEvent;
/*     */ import meteordevelopment.meteorclient.renderer.ShapeMode;
/*     */ import meteordevelopment.meteorclient.settings.BlockListSetting;
/*     */ import meteordevelopment.meteorclient.settings.ColorSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.IntSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.systems.modules.movement.Scaffold;
/*     */ import meteordevelopment.meteorclient.utils.player.FindItemResult;
/*     */ import meteordevelopment.meteorclient.utils.player.InvUtils;
/*     */ import meteordevelopment.meteorclient.utils.render.RenderUtils;
/*     */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*     */ import meteordevelopment.meteorclient.utils.render.color.SettingColor;
/*     */ import meteordevelopment.meteorclient.utils.world.BlockUtils;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_2248;
/*     */ import net.minecraft.class_2338;
/*     */ import net.minecraft.class_2350;
/*     */ import net.minecraft.class_2374;
/*     */ 
/*     */ public class BuildTool extends Module {
/*  28 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*  29 */   private final SettingGroup sgRender = this.settings.createGroup("Render");
/*     */   
/*  31 */   private class_2338 bp = (class_2338)new class_2338.class_2339();
/*     */   
/*     */   private class_2350 direction;
/*     */   private boolean up = false;
/*     */   
/*     */   public enum Mode
/*     */   {
/*  38 */     Line,
/*  39 */     Staircase;
/*     */   }
/*     */ 
/*     */   
/*  43 */   private final Setting<Mode> mode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  44 */       .name("mode"))
/*  45 */       .description("The Mode."))
/*  46 */       .defaultValue(Mode.Staircase))
/*  47 */       .build());
/*     */ 
/*     */   
/*  50 */   private final Setting<List<class_2248>> blocks = this.sgGeneral.add((Setting)((BlockListSetting.Builder)((BlockListSetting.Builder)(new BlockListSetting.Builder())
/*  51 */       .name("blocks"))
/*  52 */       .description("Selected blocks."))
/*  53 */       .build());
/*     */ 
/*     */   
/*  56 */   private final Setting<Scaffold.ListMode> blocksFilter = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  57 */       .name("blocks-filter"))
/*  58 */       .description("How to use the block list setting"))
/*  59 */       .defaultValue(Scaffold.ListMode.Blacklist))
/*  60 */       .build());
/*     */ 
/*     */   
/*  63 */   private final Setting<ShapeMode> shapeMode = this.sgRender.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  64 */       .name("shape-mode"))
/*  65 */       .description("How the shapes are rendered."))
/*  66 */       .defaultValue(ShapeMode.Both))
/*  67 */       .build());
/*     */ 
/*     */   
/*  70 */   private final Setting<SettingColor> sideColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)(new ColorSetting.Builder())
/*  71 */       .name("side-color"))
/*  72 */       .description("The color of the sides of the blocks being rendered."))
/*  73 */       .defaultValue(new SettingColor(204, 0, 0, 10))
/*  74 */       .build());
/*     */ 
/*     */   
/*  77 */   private final Setting<SettingColor> lineColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)(new ColorSetting.Builder())
/*  78 */       .name("line-color"))
/*  79 */       .description("The color of the lines of the blocks being rendered."))
/*  80 */       .defaultValue(new SettingColor(204, 0, 0, 255))
/*  81 */       .build());
/*     */ 
/*     */   
/*  84 */   private final Setting<Integer> length = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/*  85 */       .name("length"))
/*  86 */       .sliderRange(5, 100)
/*  87 */       .defaultValue(Integer.valueOf(50)))
/*  88 */       .description("Length of the Bridge"))
/*  89 */       .build());
/*     */ 
/*     */   
/*     */   public BuildTool() {
/*  93 */     super(Addon.CATEGORY, "build-tool", "Helps you build structures quickly");
/*     */   }
/*     */ 
/*     */   
/*     */   public void onActivate() {
/*  98 */     if (this.mc.field_1724.method_36455() <= 0.0F) {
/*  99 */       this.up = true;
/*     */     } else {
/* 101 */       this.up = false;
/*     */     } 
/* 103 */     this.bp = this.mc.field_1724.method_24515();
/* 104 */     this.direction = this.mc.field_1724.method_5755();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onRender(Render3DEvent event) {
/* 109 */     if (this.mc.field_1724 == null || this.mc.field_1687 == null)
/*     */       return; 
/* 111 */     for (int i = 0; i < 100; i++) {
/* 112 */       class_2338 target = this.bp.method_10081(this.direction.method_10163().method_34592(0, -this.direction.method_10163().method_10264(), 0).method_35862(i + 1)).method_10069(0, (this.mode.get() == Mode.Staircase) ? (this.up ? i : -i) : 0, 0);
/* 113 */       if (this.mc.field_1687.method_8320(target).method_26215() && 
/* 114 */         target.method_19769((class_2374)this.mc.field_1724.method_19538(), 15.0D)) event.renderer.box(target, (Color)this.sideColor.get(), (Color)this.lineColor.get(), (ShapeMode)this.shapeMode.get(), 0); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean validItem(class_1799 itemStack, class_2338 pos) {
/* 119 */     if (this.mc.field_1687 == null)
/* 120 */       return false; 
/* 121 */     if (!(itemStack.method_7909() instanceof class_1747)) return false;
/*     */     
/* 123 */     class_2248 block = ((class_1747)itemStack.method_7909()).method_7711();
/*     */     
/* 125 */     if (this.blocksFilter.get() == Scaffold.ListMode.Blacklist && ((List)this.blocks.get()).contains(block)) return false; 
/* 126 */     if (this.blocksFilter.get() == Scaffold.ListMode.Whitelist && !((List)this.blocks.get()).contains(block)) return false;
/*     */     
/* 128 */     if (!class_2248.method_9614(block.method_9564().method_26220((class_1922)this.mc.field_1687, pos))) return false; 
/* 129 */     return (!(block instanceof class_2346) || !class_2346.method_10128(this.mc.field_1687.method_8320(pos)));
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   private void onTick(TickEvent.Pre event) {
/* 135 */     if (this.mc.field_1724 == null || this.mc.field_1687 == null) {
/*     */       return;
/*     */     }
/* 138 */     List<class_2338> bps = new ArrayList<>();
/* 139 */     for (int i = 0; i < 100; i++) {
/* 140 */       class_2338 tmp = this.bp.method_10081(this.direction.method_10163().method_34592(0, -this.mc.field_1724.method_5755().method_10163().method_10264(), 0).method_35862(i + 1)).method_10069(0, (this.mode.get() == Mode.Staircase) ? (this.up ? i : -i) : 0, 0);
/* 141 */       if (this.mc.field_1687.method_8320(tmp).method_26215() && tmp.method_19769((class_2374)this.mc.field_1724.method_19538(), 4.0D)) bps.add(tmp);
/*     */     
/*     */     } 
/* 144 */     if (bps.isEmpty())
/*     */       return; 
/* 146 */     class_2338 chosen = bps.get(0);
/*     */     
/* 148 */     FindItemResult item = InvUtils.findInHotbar(itemStack -> validItem(itemStack, chosen));
/* 149 */     if (!item.found())
/*     */       return; 
/* 151 */     if (BlockUtils.place(chosen, item, true, 50, true, true))
/*     */     {
/* 153 */       RenderUtils.renderTickingBlock(chosen.method_10062(), (Color)this.sideColor.get(), (Color)this.lineColor.get(), (ShapeMode)this.shapeMode.get(), 0, 8, true, false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/BuildTool.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */