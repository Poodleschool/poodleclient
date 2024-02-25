/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import meteordevelopment.meteorclient.renderer.ShapeMode;
/*     */ import meteordevelopment.meteorclient.settings.BlockListSetting;
/*     */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*     */ import meteordevelopment.meteorclient.settings.ColorSetting;
/*     */ import meteordevelopment.meteorclient.settings.DoubleSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.IntSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.utils.player.FindItemResult;
/*     */ import meteordevelopment.meteorclient.utils.player.PlayerUtils;
/*     */ import meteordevelopment.meteorclient.utils.render.RenderUtils;
/*     */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*     */ import meteordevelopment.meteorclient.utils.render.color.SettingColor;
/*     */ import meteordevelopment.meteorclient.utils.world.BlockUtils;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_2248;
/*     */ import net.minecraft.class_2338;
/*     */ import net.minecraft.class_2350;
/*     */ import net.minecraft.class_2382;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_2596;
/*     */ import net.minecraft.class_2828;
/*     */ import net.minecraft.class_2848;
/*     */ 
/*     */ public class ScaffoldPlus extends Module {
/*  34 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*  35 */   private final SettingGroup sgRender = this.settings.createGroup("Render");
/*     */   
/*  37 */   private final Setting<List<class_2248>> blocks = this.sgGeneral.add((Setting)((BlockListSetting.Builder)((BlockListSetting.Builder)(new BlockListSetting.Builder())
/*  38 */       .name("blocks"))
/*  39 */       .description("Selected blocks."))
/*  40 */       .build());
/*     */ 
/*     */   
/*  43 */   private final Setting<Boolean> grimScaffold = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  44 */       .name("grim-rotation"))
/*  45 */       .description("Funny Grim"))
/*  46 */       .defaultValue(Boolean.valueOf(false)))
/*  47 */       .build());
/*     */ 
/*     */   
/*  50 */   private final Setting<ListMode> blocksFilter = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  51 */       .name("blocks-filter"))
/*  52 */       .description("How to use the block list setting"))
/*  53 */       .defaultValue(ListMode.Blacklist))
/*  54 */       .build());
/*     */ 
/*     */   
/*  57 */   private final Setting<Boolean> fastTower = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  58 */       .name("fast-tower"))
/*  59 */       .description("Whether or not to scaffold upwards faster."))
/*  60 */       .defaultValue(Boolean.valueOf(false)))
/*  61 */       .build());
/*     */ 
/*     */   
/*  64 */   private final Setting<Boolean> sameY = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  65 */       .name("same-y"))
/*  66 */       .description("Whether or not to scaffold on the same Y-Axis."))
/*  67 */       .defaultValue(Boolean.valueOf(false)))
/*  68 */       .build());
/*     */ 
/*     */   
/*  71 */   private final Setting<Boolean> onlyOnClick = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  72 */       .name("only-on-click"))
/*  73 */       .description("Only places blocks when holding right click."))
/*  74 */       .defaultValue(Boolean.valueOf(false)))
/*  75 */       .build());
/*     */ 
/*     */   
/*  78 */   private final Setting<Boolean> renderSwing = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  79 */       .name("swing"))
/*  80 */       .description("Renders your client-side swing."))
/*  81 */       .defaultValue(Boolean.valueOf(false)))
/*  82 */       .build());
/*     */ 
/*     */   
/*  85 */   private final Setting<Boolean> autoSwitch = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  86 */       .name("auto-switch"))
/*  87 */       .description("Automatically swaps to a block before placing."))
/*  88 */       .defaultValue(Boolean.valueOf(true)))
/*  89 */       .build());
/*     */ 
/*     */   
/*  92 */   private final Setting<Boolean> rotate = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  93 */       .name("rotate"))
/*  94 */       .description("Rotates towards the blocks being placed."))
/*  95 */       .defaultValue(Boolean.valueOf(true)))
/*  96 */       .build());
/*     */ 
/*     */   
/*  99 */   private final Setting<Boolean> airPlace = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/* 100 */       .name("air-place"))
/* 101 */       .description("Allow air place."))
/* 102 */       .defaultValue(Boolean.valueOf(false)))
/* 103 */       .build());
/*     */ 
/*     */   
/* 106 */   private final Setting<Double> placeRange = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/* 107 */       .name("closest-block-range"))
/* 108 */       .description("How far can scaffold place blocks."))
/* 109 */       .defaultValue(4.0D)
/* 110 */       .min(0.0D)
/* 111 */       .sliderMax(8.0D)
/* 112 */       .visible(() -> !((Boolean)this.airPlace.get()).booleanValue()))
/* 113 */       .build());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 118 */   private final Setting<Boolean> render = this.sgRender.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/* 119 */       .name("render"))
/* 120 */       .description("Whether to render blocks that have been placed."))
/* 121 */       .defaultValue(Boolean.valueOf(true)))
/* 122 */       .build());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<ShapeMode> shapeMode;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<SettingColor> sideColor;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<SettingColor> lineColor;
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Integer> fadeDuration;
/*     */ 
/*     */ 
/*     */   
/*     */   private final class_2338.class_2339 bp;
/*     */ 
/*     */ 
/*     */   
/*     */   private final class_2338.class_2339 prevBp;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean lastWasSneaking;
/*     */ 
/*     */ 
/*     */   
/*     */   private double lastSneakingY;
/*     */ 
/*     */ 
/*     */   
/*     */   private int startY;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScaffoldPlus() {
/* 167 */     super(Addon.CATEGORY, "scaffold-plus", "Automatically places blocks under you."); Objects.requireNonNull(this.render); this.shapeMode = this.sgRender.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder()).name("shape-mode")).description("How the shapes are rendered.")).defaultValue(ShapeMode.Both)).visible(this.render::get)).build()); Objects.requireNonNull(this.render); this.sideColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)(new ColorSetting.Builder()).name("side-color")).description("The side color of the target block rendering.")).defaultValue(new SettingColor(197, 137, 232, 10)).visible(this.render::get)).build()); Objects.requireNonNull(this.render);
/*     */     this.lineColor = this.sgRender.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)(new ColorSetting.Builder()).name("line-color")).description("The line color of the target block rendering.")).defaultValue(new SettingColor(197, 137, 232)).visible(this.render::get)).build());
/*     */     Objects.requireNonNull(this.render);
/*     */     this.fadeDuration = this.sgRender.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder()).name("fade-duration")).description("How long for the rendered blocks to fade in ticks.")).min(2).defaultValue(Integer.valueOf(10))).visible(this.render::get)).build());
/*     */     this.bp = new class_2338.class_2339();
/* 172 */     this.prevBp = new class_2338.class_2339(); } public void onActivate() { this.lastWasSneaking = this.mc.field_1690.field_1832.method_1434();
/* 173 */     if (this.lastWasSneaking) this.lastSneakingY = this.mc.field_1724.method_23318(); 
/* 174 */     this.startY = this.mc.field_1724.method_31478() - 1; }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   private void onTick(TickEvent.Pre event) {
/* 179 */     if (((Boolean)this.onlyOnClick.get()).booleanValue() && !this.mc.field_1690.field_1904.method_1434())
/*     */       return; 
/* 181 */     if (((Boolean)this.airPlace.get()).booleanValue()) {
/* 182 */       class_243 vec = this.mc.field_1724.method_19538().method_1019(this.mc.field_1724.method_18798()).method_1031(0.0D, -0.5D, 0.0D);
/* 183 */       this.bp.method_10102(vec.method_10216(), vec.method_10214(), vec.method_10215());
/*     */     
/*     */     }
/* 186 */     else if (BlockUtils.getPlaceSide(this.mc.field_1724.method_24515().method_10074()) != null) {
/* 187 */       this.bp.method_10101((class_2382)this.mc.field_1724.method_24515().method_10074());
/*     */     } else {
/*     */       class_2350 facing;
/* 190 */       class_243 pos = this.mc.field_1724.method_19538();
/* 191 */       pos = pos.method_1031(0.0D, -0.9800000190734863D, 0.0D);
/* 192 */       pos.method_1019(this.mc.field_1724.method_18798());
/* 193 */       if (((Boolean)this.sameY.get()).booleanValue()) {
/* 194 */         pos = new class_243(pos.field_1352, this.startY, pos.field_1350);
/*     */       }
/* 196 */       if (!PlayerUtils.isWithin((class_2338)this.prevBp, ((Double)this.placeRange.get()).doubleValue())) {
/* 197 */         List<class_2338> blockPosArray = new ArrayList<>();
/*     */         
/* 199 */         for (int x = (int)(this.mc.field_1724.method_23317() - ((Double)this.placeRange.get()).doubleValue()); x < this.mc.field_1724.method_23317() + ((Double)this.placeRange.get()).doubleValue(); x++) {
/* 200 */           for (int z = (int)(this.mc.field_1724.method_23321() - ((Double)this.placeRange.get()).doubleValue()); z < this.mc.field_1724.method_23321() + ((Double)this.placeRange.get()).doubleValue(); z++) {
/* 201 */             for (int y = (int)Math.max(this.mc.field_1687.method_31607(), this.mc.field_1724.method_23318() - ((Double)this.placeRange.get()).doubleValue()); y < Math.min(this.mc.field_1687.method_31600(), this.mc.field_1724.method_23318() + ((Double)this.placeRange.get()).doubleValue()); y++) {
/* 202 */               this.bp.method_10103(x, y, z);
/* 203 */               if (!this.mc.field_1687.method_8320((class_2338)this.bp).method_26215()) blockPosArray.add(new class_2338((class_2382)this.bp)); 
/*     */             } 
/*     */           } 
/*     */         } 
/* 207 */         if (blockPosArray.size() == 0) {
/*     */           return;
/*     */         }
/*     */         
/* 211 */         blockPosArray.sort(Comparator.comparingDouble(PlayerUtils::squaredDistanceTo));
/*     */         
/* 213 */         this.prevBp.method_10101((class_2382)blockPosArray.get(0));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 218 */       class_243 vecPrevBP = new class_243(this.prevBp.method_10263() + 0.5D, this.prevBp.method_10264() + 0.5D, this.prevBp.method_10260() + 0.5D);
/*     */       
/* 220 */       class_243 sub = pos.method_1020(vecPrevBP);
/*     */       
/* 222 */       if (sub.method_10214() < -0.5D)
/* 223 */       { facing = class_2350.field_11033; }
/* 224 */       else if (sub.method_10214() > 0.5D)
/* 225 */       { facing = class_2350.field_11036; }
/* 226 */       else { facing = class_2350.method_10142(sub.method_10216(), 0.0D, sub.method_10215()); }
/*     */       
/* 228 */       this.bp.method_10101((class_2382)this.prevBp.method_10093(facing));
/*     */     } 
/*     */ 
/*     */     
/* 232 */     FindItemResult item = InvUtils.findInHotbar(itemStack -> validItem(itemStack, (class_2338)this.bp));
/* 233 */     if (!item.found()) {
/*     */       return;
/*     */     }
/* 236 */     if (item.getHand() == null && !((Boolean)this.autoSwitch.get()).booleanValue()) {
/*     */       return;
/*     */     }
/* 239 */     if (this.mc.field_1690.field_1832.method_1434() && !this.mc.field_1690.field_1903.method_1434()) {
/* 240 */       if (this.lastSneakingY - this.mc.field_1724.method_23318() < 0.1D) {
/* 241 */         this.lastWasSneaking = false;
/*     */         return;
/*     */       } 
/*     */     } else {
/* 245 */       this.lastWasSneaking = false;
/*     */     } 
/* 247 */     if (!this.lastWasSneaking) this.lastSneakingY = this.mc.field_1724.method_23318();
/*     */     
/* 249 */     if (this.mc.field_1690.field_1903.method_1434() && !this.mc.field_1690.field_1832.method_1434() && ((Boolean)this.fastTower.get()).booleanValue()) {
/* 250 */       this.mc.field_1724.method_18800(0.0D, 0.41999998688697815D, 0.0D);
/*     */     }
/*     */     
/* 253 */     if (((Boolean)this.sameY.get()).booleanValue()) {
/* 254 */       this.bp.method_33098(this.startY);
/*     */     }
/*     */     
/* 257 */     if (!this.mc.field_1724.method_24828() || !((Boolean)this.grimScaffold.get()).booleanValue() || item.found());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 263 */     if (((Boolean)this.grimScaffold.get()).booleanValue()) {
/*     */       
/* 265 */       class_2350 side = BlockUtils.getPlaceSide((class_2338)this.bp);
/*     */       
/* 267 */       if (side == null) {
/* 268 */         side = class_2350.field_11033;
/*     */       }
/*     */       
/* 271 */       this.mc.field_1724.method_5728(false);
/*     */       
/* 273 */       if (BlockUtils.canPlace((class_2338)this.bp)) {
/* 274 */         this.mc.method_1562().method_52787((class_2596)new class_2848((class_1297)this.mc.field_1724, class_2848.class_2849.field_12979));
/* 275 */         this.mc.method_1562().method_52787((class_2596)new class_2828.class_2831(getYaw(side), (float)Rotations.getPitch((class_2338)this.bp), this.mc.field_1724.method_24828()));
/* 276 */         this.mc.field_1724.method_18799(new class_243(this.mc.field_1724.method_18798().method_10216() * 0.2D, this.mc.field_1724.method_18798().method_10214(), this.mc.field_1724.method_18798().method_10215() * 0.2D));
/* 277 */         BlockUtils.place((class_2338)this.bp, item, false, 50, ((Boolean)this.renderSwing.get()).booleanValue(), true);
/* 278 */         this.mc.method_1562().method_52787((class_2596)new class_2828.class_2831(this.mc.field_1724.method_36454(), this.mc.field_1724.method_36455(), this.mc.field_1724.method_24828()));
/* 279 */         this.mc.method_1562().method_52787((class_2596)new class_2848((class_1297)this.mc.field_1724, class_2848.class_2849.field_12984));
/*     */         
/* 281 */         if (((Boolean)this.render.get()).booleanValue())
/* 282 */           RenderUtils.renderTickingBlock(this.bp.method_10062(), (Color)this.sideColor.get(), (Color)this.lineColor.get(), (ShapeMode)this.shapeMode.get(), 0, 8, true, false); 
/*     */       } 
/* 284 */     } else if (BlockUtils.place((class_2338)this.bp, item, ((Boolean)this.rotate.get()).booleanValue(), 50, ((Boolean)this.renderSwing.get()).booleanValue(), true)) {
/*     */       
/* 286 */       if (((Boolean)this.render.get()).booleanValue()) RenderUtils.renderTickingBlock(this.bp.method_10062(), (Color)this.sideColor.get(), (Color)this.lineColor.get(), (ShapeMode)this.shapeMode.get(), 0, 8, true, false);
/*     */ 
/*     */       
/* 289 */       if (this.mc.field_1690.field_1903.method_1434() && !this.mc.field_1690.field_1832.method_1434() && !this.mc.field_1724.method_24828() && !this.mc.field_1687.method_8320((class_2338)this.bp).method_26215() && ((Boolean)this.fastTower.get()).booleanValue()) {
/* 290 */         this.mc.field_1724.method_18800(0.0D, -0.2800000011920929D, 0.0D);
/*     */       }
/*     */     } 
/*     */     
/* 294 */     if (!this.mc.field_1687.method_8320((class_2338)this.bp).method_26215()) {
/* 295 */       this.prevBp.method_10101((class_2382)this.bp);
/*     */     }
/*     */   }
/*     */   
/*     */   private float getYaw(class_2350 direction) {
/* 300 */     switch (direction) { case field_11043: case field_11035: case field_11034: case field_11039:  }  return 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 306 */       this.mc.field_1724.method_36454();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float getPitch(class_2350 dir) {
/* 312 */     switch (dir) { case field_11033: case field_11036:  }  return 
/*     */ 
/*     */ 
/*     */       
/* 316 */       76.55F + (new Random()).nextFloat(2.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean scaffolding() {
/* 322 */     return (isActive() && (!((Boolean)this.onlyOnClick.get()).booleanValue() || (((Boolean)this.onlyOnClick.get()).booleanValue() && this.mc.field_1690.field_1904.method_1434())));
/*     */   }
/*     */   
/*     */   private boolean validItem(class_1799 itemStack, class_2338 pos) {
/* 326 */     if (!(itemStack.method_7909() instanceof class_1747)) return false;
/*     */     
/* 328 */     class_2248 block = ((class_1747)itemStack.method_7909()).method_7711();
/*     */     
/* 330 */     if (this.blocksFilter.get() == ListMode.Blacklist && ((List)this.blocks.get()).contains(block)) return false; 
/* 331 */     if (this.blocksFilter.get() == ListMode.Whitelist && !((List)this.blocks.get()).contains(block)) return false;
/*     */     
/* 333 */     if (!class_2248.method_9614(block.method_9564().method_26220((class_1922)this.mc.field_1687, pos))) return false; 
/* 334 */     return (!(block instanceof class_2346) || !class_2346.method_10128(this.mc.field_1687.method_8320(pos)));
/*     */   }
/*     */ 
/*     */   
/*     */   public enum ListMode
/*     */   {
/* 340 */     Whitelist,
/* 341 */     Blacklist;
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/ScaffoldPlus.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */