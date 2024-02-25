/*     */ package de.Jakob.navine.hud;
/*     */ import de.Jakob.navine.util.Gradient;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*     */ import meteordevelopment.meteorclient.settings.ColorListSetting;
/*     */ import meteordevelopment.meteorclient.settings.ColorSetting;
/*     */ import meteordevelopment.meteorclient.settings.DoubleSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.IntSetting;
/*     */ import meteordevelopment.meteorclient.settings.ModuleListSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.systems.hud.Alignment;
/*     */ import meteordevelopment.meteorclient.systems.hud.HudRenderer;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*     */ import meteordevelopment.meteorclient.utils.render.color.SettingColor;
/*     */ 
/*     */ public class ActiveModulesHud extends HudElement {
/*  20 */   public static final HudElementInfo<ActiveModulesHud> INFO = new HudElementInfo(Addon.HUD_GROUP, "navine-active-modules", "Displays your active modules.", ActiveModulesHud::new);
/*     */   
/*  22 */   private static final Color WHITE = new Color();
/*     */   
/*  24 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*     */   
/*  26 */   private final Setting<List<Module>> hiddenModules = this.sgGeneral.add((Setting)((ModuleListSetting.Builder)((ModuleListSetting.Builder)(new ModuleListSetting.Builder())
/*  27 */       .name("hidden-modules"))
/*  28 */       .description("Which modules not to show in the list."))
/*  29 */       .build());
/*     */ 
/*     */   
/*  32 */   private final Setting<Sort> sort = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  33 */       .name("sort"))
/*  34 */       .description("How to sort active modules."))
/*  35 */       .defaultValue(Sort.Biggest))
/*  36 */       .build());
/*     */ 
/*     */   
/*  39 */   private final Setting<Boolean> activeInfo = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  40 */       .name("additional-info"))
/*  41 */       .description("Shows additional info from the module next to the name in the active modules list."))
/*  42 */       .defaultValue(Boolean.valueOf(true)))
/*  43 */       .build());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<SettingColor> moduleInfoColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<ColorMode> colorMode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<List<SettingColor>> gradientColors;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Integer> gradientTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<SettingColor> flatColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Boolean> shadow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Alignment> alignment;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Boolean> outlines;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Integer> outlineWidth;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Boolean> customScale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Double> scale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Double> rainbowSpeed;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Double> rainbowSpread;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Double> rainbowSaturation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Setting<Double> rainbowBrightness;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final List<Module> modules;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Color rainbow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double rainbowHue1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double rainbowHue2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double prevX;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double prevTextLength;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Color prevColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ActiveModulesHud() {
/* 185 */     super(INFO); Objects.requireNonNull(this.activeInfo); this.moduleInfoColor = this.sgGeneral.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)(new ColorSetting.Builder()).name("module-info-color")).description("Color of module info text.")).defaultValue(new SettingColor(175, 175, 175)).visible(this.activeInfo::get)).build()); this.colorMode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder()).name("color-mode")).description("What color to use for active modules.")).defaultValue(ColorMode.Rainbow)).build()); this.gradientColors = this.sgGeneral.add((Setting)((ColorListSetting.Builder)((ColorListSetting.Builder)((ColorListSetting.Builder)((ColorListSetting.Builder)(new ColorListSetting.Builder()).name("gradient-colors")).description("The colors of the gradient.")).defaultValue(List.of(new SettingColor(Color.CYAN.getPacked()), new SettingColor(Color.BLUE.getPacked())))).visible(() -> (this.colorMode.get() == ColorMode.Gradient))).build()); this.gradientTime = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder()).name("gradient-time")).description("The time the gradient takes.")).defaultValue(Integer.valueOf(5000))).min(0).range(1, 5000).visible(() -> (this.colorMode.get() == ColorMode.Gradient))).build()); this.flatColor = this.sgGeneral.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)(new ColorSetting.Builder()).name("flat-color")).description("Color for flat color mode.")).defaultValue(new SettingColor(225, 25, 25)).visible(() -> (this.colorMode.get() == ColorMode.Flat))).build()); this.shadow = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("shadow")).description("Renders shadow behind text.")).defaultValue(Boolean.valueOf(true))).build()); this.alignment = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder()).name("alignment")).description("Horizontal alignment.")).defaultValue(Alignment.Auto)).build()); this.outlines = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("outlines")).description("Whether or not to render outlines")).defaultValue(Boolean.valueOf(false))).build()); Objects.requireNonNull(this.outlines); this.outlineWidth = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder()).name("outline-width")).description("Outline width")).defaultValue(Integer.valueOf(2))).min(1).sliderMin(1).visible(this.outlines::get)).build()); this.customScale = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("custom-scale")).description("Applies custom text scale rather than the global one.")).defaultValue(Boolean.valueOf(false))).build()); Objects.requireNonNull(this.customScale); this.scale = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder()).name("scale")).description("Custom scale.")).visible(this.customScale::get)).defaultValue(1.0D).min(0.5D).sliderRange(0.5D, 3.0D).build()); this.rainbowSpeed = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder()).name("rainbow-speed")).description("Rainbow speed of rainbow color mode.")).defaultValue(0.05D).sliderMin(0.01D).sliderMax(0.2D).decimalPlaces(4).visible(() -> (this.colorMode.get() == ColorMode.Rainbow))).build()); this.rainbowSpread = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder()).name("rainbow-spread")).description("Rainbow spread of rainbow color mode.")).defaultValue(0.01D).sliderMin(0.001D).sliderMax(0.05D).decimalPlaces(4).visible(() -> (this.colorMode.get() == ColorMode.Rainbow))).build());
/*     */     this.rainbowSaturation = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder()).name("rainbow-saturation")).defaultValue(1.0D).sliderRange(0.0D, 1.0D).visible(() -> (this.colorMode.get() == ColorMode.Rainbow))).build());
/*     */     this.rainbowBrightness = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder()).name("rainbow-brightness")).defaultValue(1.0D).sliderRange(0.0D, 1.0D).visible(() -> (this.colorMode.get() == ColorMode.Rainbow))).build());
/*     */     this.modules = new ArrayList<>();
/*     */     this.rainbow = new Color(255, 255, 255);
/* 190 */     this.prevColor = new Color(); } public void tick(HudRenderer renderer) { this.modules.clear();
/*     */     
/* 192 */     for (Module module : Modules.get().getActive()) {
/* 193 */       if (!((List)this.hiddenModules.get()).contains(module)) this.modules.add(module);
/*     */     
/*     */     } 
/* 196 */     if (this.modules.isEmpty()) {
/* 197 */       if (isInEditor()) {
/* 198 */         setSize(renderer.textWidth("Active Modules", ((Boolean)this.shadow.get()).booleanValue(), getScale()), renderer.textHeight(((Boolean)this.shadow.get()).booleanValue(), getScale()));
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 203 */     this.modules.sort((e1, e2) -> { switch ((Sort)this.sort.get()) { default: throw new IncompatibleClassChangeError();
/*     */             case Alphabetical:
/*     */             
/*     */             case Biggest:
/*     */             
/*     */             case Smallest:
/* 209 */               break; }  return Double.compare(getModuleWidth(renderer, e1), getModuleWidth(renderer, e2)); }); double width = 0.0D;
/* 210 */     double height = 0.0D;
/*     */     
/* 212 */     for (int i = 0; i < this.modules.size(); i++) {
/* 213 */       Module module = this.modules.get(i);
/*     */       
/* 215 */       width = Math.max(width, getModuleWidth(renderer, module));
/* 216 */       height += renderer.textHeight(((Boolean)this.shadow.get()).booleanValue(), getScale());
/* 217 */       if (i > 0) height += 2.0D;
/*     */     
/*     */     } 
/* 220 */     setSize(width, height); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(HudRenderer renderer) {
/* 225 */     double x = this.x;
/* 226 */     double y = this.y;
/*     */     
/* 228 */     if (this.modules.isEmpty()) {
/* 229 */       if (isInEditor()) {
/* 230 */         renderer.text("Active Modules", x, y, WHITE, ((Boolean)this.shadow.get()).booleanValue(), getScale());
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 235 */     this.rainbowHue1 += ((Double)this.rainbowSpeed.get()).doubleValue() * renderer.delta;
/* 236 */     if (this.rainbowHue1 > 1.0D) { this.rainbowHue1--; }
/* 237 */     else if (this.rainbowHue1 < -1.0D) { this.rainbowHue1++; }
/*     */     
/* 239 */     this.rainbowHue2 = this.rainbowHue1;
/*     */     
/* 241 */     this.prevX = x;
/*     */     
/* 243 */     for (int i = 0; i < this.modules.size(); i++) {
/* 244 */       double offset = alignX(getModuleWidth(renderer, this.modules.get(i)), (Alignment)this.alignment.get());
/* 245 */       renderModule(renderer, this.modules, i, x + offset, y);
/*     */       
/* 247 */       this.prevX = x + offset;
/* 248 */       y += 2.0D + renderer.textHeight(((Boolean)this.shadow.get()).booleanValue(), getScale());
/*     */     }  } private void renderModule(HudRenderer renderer, List<Module> modules, int index, double x, double y) {
/*     */     int c;
/*     */     Gradient grad;
/*     */     float offset;
/* 253 */     Module module = modules.get(index);
/* 254 */     Color color = (Color)this.flatColor.get();
/*     */     
/* 256 */     switch ((ColorMode)this.colorMode.get()) { case Alphabetical:
/* 257 */         color = module.color; break;
/*     */       case Biggest:
/* 259 */         this.rainbowHue2 += ((Double)this.rainbowSpread.get()).doubleValue();
/* 260 */         c = Color.HSBtoRGB((float)this.rainbowHue2, ((Double)this.rainbowSaturation.get()).floatValue(), ((Double)this.rainbowBrightness.get()).floatValue());
/* 261 */         this.rainbow.r = Color.toRGBAR(c);
/* 262 */         this.rainbow.g = Color.toRGBAG(c);
/* 263 */         this.rainbow.b = Color.toRGBAB(c);
/* 264 */         color = this.rainbow;
/*     */         break;
/*     */       
/*     */       case Smallest:
/* 268 */         if (((List)this.gradientColors.get()).size() < 2) {
/* 269 */           color = (Color)this.flatColor.get(); break;
/*     */         } 
/* 271 */         grad = new Gradient((List)((List)this.gradientColors.get()).stream().map(sc -> new Color(sc.getPacked())).collect(Collectors.toList()));
/* 272 */         offset = index;
/* 273 */         if (((Integer)this.gradientTime.get()).intValue() > 1)
/* 274 */           offset = ((index + modules.size()) - (float)(System.currentTimeMillis() % ((Integer)this.gradientTime.get()).intValue()) / ((Integer)this.gradientTime.get()).intValue() * modules.size()) % modules.size(); 
/* 275 */         color = grad.getColor(offset, modules.size());
/*     */         break; }
/*     */ 
/*     */ 
/*     */     
/* 280 */     renderer.text(module.title, x, y, color, ((Boolean)this.shadow.get()).booleanValue(), getScale());
/*     */     
/* 282 */     double emptySpace = renderer.textWidth(" ", ((Boolean)this.shadow.get()).booleanValue(), getScale());
/* 283 */     double textHeight = renderer.textHeight(((Boolean)this.shadow.get()).booleanValue(), getScale());
/* 284 */     double textLength = renderer.textWidth(module.title, ((Boolean)this.shadow.get()).booleanValue(), getScale());
/*     */     
/* 286 */     if (((Boolean)this.activeInfo.get()).booleanValue()) {
/* 287 */       String info = module.getInfoString();
/* 288 */       if (info != null) {
/* 289 */         renderer.text(info, x + emptySpace + textLength, y, (Color)this.moduleInfoColor.get(), ((Boolean)this.shadow.get()).booleanValue(), getScale());
/* 290 */         textLength += emptySpace + renderer.textWidth(info, ((Boolean)this.shadow.get()).booleanValue(), getScale());
/*     */       } 
/*     */     } 
/*     */     
/* 294 */     if (((Boolean)this.outlines.get()).booleanValue()) {
/* 295 */       if (index == 0) {
/* 296 */         renderer.quad(x - 2.0D - ((Integer)this.outlineWidth.get()).intValue(), y - 2.0D, ((Integer)this.outlineWidth.get()).intValue(), textHeight + 4.0D, this.prevColor, this.prevColor, color, color);
/* 297 */         renderer.quad(x + textLength + 2.0D, y - 2.0D, ((Integer)this.outlineWidth.get()).intValue(), textHeight + 4.0D, this.prevColor, this.prevColor, color, color);
/*     */         
/* 299 */         renderer.quad(x - 2.0D - ((Integer)this.outlineWidth.get()).intValue(), y - 2.0D - ((Integer)this.outlineWidth.get()).intValue(), textLength + 4.0D + (((Integer)this.outlineWidth.get()).intValue() * 2), ((Integer)this.outlineWidth.get()).intValue(), this.prevColor, this.prevColor, color, color);
/* 300 */         if (index == modules.size() - 1) {
/* 301 */           renderer.quad(x - 2.0D - ((Integer)this.outlineWidth.get()).intValue(), y + textHeight + 2.0D, textLength + 4.0D + (((Integer)this.outlineWidth.get()).intValue() * 2), ((Integer)this.outlineWidth.get()).intValue(), this.prevColor, this.prevColor, color, color);
/*     */         }
/* 303 */       } else if (index == modules.size() - 1) {
/* 304 */         renderer.quad(x - 2.0D - ((Integer)this.outlineWidth.get()).intValue(), y, ((Integer)this.outlineWidth.get()).intValue(), textHeight + 2.0D + ((Integer)this.outlineWidth.get()).intValue(), this.prevColor, this.prevColor, color, color);
/* 305 */         renderer.quad(x + textLength + 2.0D, y, ((Integer)this.outlineWidth.get()).intValue(), textHeight + 2.0D + ((Integer)this.outlineWidth.get()).intValue(), this.prevColor, this.prevColor, color, color);
/*     */         
/* 307 */         renderer.quad(x - 2.0D - ((Integer)this.outlineWidth.get()).intValue(), y + textHeight + 2.0D, textLength + 4.0D + (((Integer)this.outlineWidth.get()).intValue() * 2), ((Integer)this.outlineWidth.get()).intValue(), this.prevColor, this.prevColor, color, color);
/*     */       } 
/*     */       
/* 310 */       if (index > 0) {
/* 311 */         if (index < modules.size() - 1) {
/*     */           
/* 313 */           renderer.quad(x - 2.0D - ((Integer)this.outlineWidth.get()).intValue(), y, ((Integer)this.outlineWidth.get()).intValue(), textHeight + 2.0D, this.prevColor, this.prevColor, color, color);
/* 314 */           renderer.quad(x + textLength + 2.0D, y, ((Integer)this.outlineWidth.get()).intValue(), textHeight + 2.0D, this.prevColor, this.prevColor, color, color);
/*     */         } 
/*     */         
/* 317 */         renderer.quad(Math.min(this.prevX, x) - 2.0D - ((Integer)this.outlineWidth.get()).intValue(), (Math.max(this.prevX, x) == x) ? y : (y - ((Integer)this.outlineWidth.get()).intValue()), 
/* 318 */             Math.max(this.prevX, x) - 2.0D - Math.min(this.prevX, x) - 2.0D - ((Integer)this.outlineWidth.get()).intValue(), ((Integer)this.outlineWidth.get()).intValue(), this.prevColor, this.prevColor, color, color);
/*     */ 
/*     */         
/* 321 */         renderer.quad(Math.min(this.prevX + this.prevTextLength, x + textLength) + 2.0D, (Math.min(this.prevX + this.prevTextLength, x + textLength) == x + textLength) ? y : (y - ((Integer)this.outlineWidth.get()).intValue()), 
/* 322 */             Math.max(this.prevX + this.prevTextLength, x + textLength) + 2.0D + ((Integer)this.outlineWidth.get()).intValue() - Math.min(this.prevX + this.prevTextLength, x + textLength) + 2.0D, ((Integer)this.outlineWidth.get()).intValue(), this.prevColor, this.prevColor, color, color);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 327 */     this.prevTextLength = textLength;
/* 328 */     this.prevColor = color;
/*     */   }
/*     */   
/*     */   private double getModuleWidth(HudRenderer renderer, Module module) {
/* 332 */     double width = renderer.textWidth(module.title, ((Boolean)this.shadow.get()).booleanValue(), getScale());
/*     */     
/* 334 */     if (((Boolean)this.activeInfo.get()).booleanValue()) {
/* 335 */       String info = module.getInfoString();
/* 336 */       if (info != null) width += renderer.textWidth(" ", ((Boolean)this.shadow.get()).booleanValue(), getScale()) + renderer.textWidth(info, ((Boolean)this.shadow.get()).booleanValue(), getScale());
/*     */     
/*     */     } 
/* 339 */     return width;
/*     */   }
/*     */   
/*     */   private double getScale() {
/* 343 */     return ((Boolean)this.customScale.get()).booleanValue() ? ((Double)this.scale.get()).doubleValue() : -1.0D;
/*     */   }
/*     */   
/*     */   public enum Sort {
/* 347 */     Alphabetical,
/* 348 */     Biggest,
/* 349 */     Smallest;
/*     */   }
/*     */   
/*     */   public enum ColorMode {
/* 353 */     Flat,
/* 354 */     Random,
/* 355 */     Rainbow,
/* 356 */     Gradient;
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/hud/ActiveModulesHud.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */