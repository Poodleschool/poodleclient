/*     */ package de.Jakob.navine.hud;
/*     */ import de.Jakob.navine.util.VanillaTextRenderer;
/*     */ import java.util.List;
/*     */ import meteordevelopment.meteorclient.gui.utils.StarscriptTextBoxRenderer;
/*     */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*     */ import meteordevelopment.meteorclient.settings.ColorSetting;
/*     */ import meteordevelopment.meteorclient.settings.DoubleSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.IntSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.settings.StringSetting;
/*     */ import meteordevelopment.meteorclient.systems.hud.Hud;
/*     */ import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
/*     */ import meteordevelopment.meteorclient.systems.hud.HudRenderer;
/*     */ import meteordevelopment.meteorclient.utils.misc.MeteorStarscript;
/*     */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*     */ import meteordevelopment.meteorclient.utils.render.color.SettingColor;
/*     */ import meteordevelopment.starscript.Section;
/*     */ import meteordevelopment.starscript.compiler.Compiler;
/*     */ import meteordevelopment.starscript.compiler.Parser;
/*     */ import meteordevelopment.starscript.utils.StarscriptError;
/*     */ import net.kyori.adventure.platform.fabric.FabricClientAudiences;
/*     */ import net.kyori.adventure.text.format.TextColor;
/*     */ import net.kyori.adventure.text.minimessage.MiniMessage;
/*     */ import net.minecraft.class_2561;
/*     */ 
/*     */ public class MiniTextHud extends HudElement {
/*  29 */   public static final HudElementInfo<MiniTextHud> INFO = new HudElementInfo(Addon.HUD_GROUP, "mini-text", "Render Text using Starscript and MiniMessage.", MiniTextHud::new);
/*     */   
/*  31 */   private static final Color WHITE = new Color();
/*     */   
/*  33 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*  34 */   private final SettingGroup sgShown = this.settings.createGroup("Shown");
/*  35 */   private final SettingGroup sgScale = this.settings.createGroup("Scale");
/*  36 */   private final SettingGroup sgBackground = this.settings.createGroup("Background");
/*     */   
/*     */   private double originalWidth;
/*     */   
/*     */   private double originalHeight;
/*     */   
/*     */   private boolean needsCompile;
/*     */   private boolean recalculateSize;
/*     */   private int timer;
/*  45 */   public final Setting<String> text = this.sgGeneral.add((Setting)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)(new StringSetting.Builder())
/*  46 */       .name("text"))
/*  47 */       .description("Text to display with Starscript and MiniMessage. Use !hash! to use a #. This does not support Custom Hud Fonts."))
/*  48 */       .defaultValue("<gradient:!hash!084CFB:!hash!B786FD><bold>MiniMessage!</bold></gradient>"))
/*  49 */       .onChanged(s -> recompile()))
/*  50 */       .wide()
/*  51 */       .renderer(StarscriptTextBoxRenderer.class)
/*  52 */       .build());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Integer> updateDelay;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Boolean> shadow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Integer> border;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Shown> shown;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<String> condition;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Boolean> customScale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Double> scale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Boolean> background;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<SettingColor> backgroundColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Script script;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Script conditionScript;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Section section;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean firstTick;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean empty;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean visible;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MiniTextHud() {
/* 148 */     super(INFO); this.updateDelay = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder()).name("update-delay")).description("Update delay in ticks")).defaultValue(Integer.valueOf(4))).onChanged(integer -> { if (this.timer > integer.intValue())
/*     */               this.timer = integer.intValue(); 
/* 150 */           })).min(0).build()); this.shadow = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("shadow")).description("Renders shadow behind text.")).defaultValue(Boolean.valueOf(true))).onChanged(aBoolean -> this.recalculateSize = true)).build()); this.border = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder()).name("border")).description("How much space to add around the text.")).defaultValue(Integer.valueOf(0))).onChanged(integer -> super.setSize(this.originalWidth + (integer.intValue() * 2), this.originalHeight + (integer.intValue() * 2)))).build()); this.shown = this.sgShown.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder()).name("shown")).description("When this text element is shown.")).defaultValue(Shown.Always)).onChanged(s -> recompile())).build()); this.condition = this.sgShown.add((Setting)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)(new StringSetting.Builder()).name("condition")).description("Condition to check when shown is not Always.")).visible(() -> (this.shown.get() != Shown.Always))).defaultValue("")).onChanged(s -> recompile())).renderer(StarscriptTextBoxRenderer.class).build()); this.customScale = this.sgScale.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("custom-scale")).description("Applies custom text scale rather than the global one.")).defaultValue(Boolean.valueOf(false))).onChanged(integer -> this.recalculateSize = true)).build()); Objects.requireNonNull(this.customScale); this.scale = this.sgScale.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder()).name("scale")).description("Custom scale.")).visible(this.customScale::get)).defaultValue(1.0D).onChanged(integer -> this.recalculateSize = true)).min(0.5D).sliderRange(0.5D, 3.0D).build()); this.background = this.sgBackground.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("background")).description("Displays background.")).defaultValue(Boolean.valueOf(false))).build()); Objects.requireNonNull(this.background); this.backgroundColor = this.sgBackground.add((Setting)((ColorSetting.Builder)((ColorSetting.Builder)((ColorSetting.Builder)(new ColorSetting.Builder()).name("background-color")).description("Color used for the background.")).visible(this.background::get)).defaultValue(new SettingColor(25, 25, 25, 50)).build()); this.firstTick = true; this.empty = false; this.needsCompile = true;
/*     */   }
/*     */   
/*     */   private void recompile() {
/* 154 */     this.firstTick = true;
/* 155 */     this.needsCompile = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSize(double width, double height) {
/* 160 */     this.originalWidth = width;
/* 161 */     this.originalHeight = height;
/* 162 */     super.setSize(width + (((Integer)this.border.get()).intValue() * 2), height + (((Integer)this.border.get()).intValue() * 2));
/*     */   }
/*     */   
/*     */   private void calculateSize() {
/* 166 */     double width = 0.0D;
/*     */     
/* 168 */     if (this.section != null) {
/* 169 */       class_2561 txt; String str = this.section.toString();
/*     */ 
/*     */       
/*     */       try {
/* 173 */         txt = FabricClientAudiences.of().toNative(
/* 174 */             MiniMessage.miniMessage().deserialize(str.replace("!hash!", "#")));
/*     */       } catch (Exception e) {
/* 176 */         txt = FabricClientAudiences.of().toNative(Component.text(e.getMessage()).color(TextColor.color(255, 0, 0)));
/*     */       } 
/* 178 */       VanillaTextRenderer.INSTANCE.scale = getScale() * 2.0D;
/*     */       try {
/* 180 */         width = VanillaTextRenderer.INSTANCE.getWidth(txt, ((Boolean)this.shadow.get()).booleanValue());
/* 181 */       } catch (Exception e) {
/* 182 */         width = 0.0D;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 187 */     VanillaTextRenderer.INSTANCE.scale = getScale() * 2.0D;
/* 188 */     if (width != 0.0D) {
/* 189 */       setSize(width, VanillaTextRenderer.INSTANCE.getHeight(((Boolean)this.shadow.get()).booleanValue()));
/* 190 */       this.empty = false;
/*     */     } else {
/*     */       
/* 193 */       setSize(100.0D, VanillaTextRenderer.INSTANCE.getHeight(((Boolean)this.shadow.get()).booleanValue()));
/* 194 */       this.empty = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick(HudRenderer renderer) {
/* 200 */     if (this.recalculateSize) {
/* 201 */       calculateSize();
/* 202 */       this.recalculateSize = false;
/*     */     } 
/*     */     
/* 205 */     if (this.timer <= 0) {
/* 206 */       runTick();
/* 207 */       this.timer = ((Integer)this.updateDelay.get()).intValue();
/*     */     } else {
/* 209 */       this.timer--;
/*     */     } 
/*     */   }
/*     */   private void runTick() {
/* 213 */     if (this.needsCompile) {
/* 214 */       Parser.Result result = Parser.parse((String)this.text.get());
/*     */       
/* 216 */       if (result.hasErrors()) {
/* 217 */         this.script = null;
/* 218 */         this.section = new Section(0, ((Error)result.errors.get(0)).toString());
/* 219 */         calculateSize();
/*     */       } else {
/* 221 */         this.script = Compiler.compile(result);
/*     */       } 
/* 223 */       if (this.shown.get() != Shown.Always) {
/* 224 */         this.conditionScript = Compiler.compile(Parser.parse((String)this.condition.get()));
/*     */       }
/*     */       
/* 227 */       this.needsCompile = false;
/*     */     } 
/*     */     
/*     */     try {
/* 231 */       if (this.script != null) {
/* 232 */         this.section = MeteorStarscript.ss.run(this.script);
/* 233 */         calculateSize();
/*     */       }
/*     */     
/* 236 */     } catch (StarscriptError error) {
/* 237 */       this.section = new Section(0, error.getMessage());
/* 238 */       calculateSize();
/*     */     } 
/*     */     
/* 241 */     if (this.shown.get() != Shown.Always && this.conditionScript != null) {
/* 242 */       String text = MeteorStarscript.run(this.conditionScript);
/*     */       
/* 244 */       if (text == null) { this.visible = false; }
/* 245 */       else { this.visible = (this.shown.get() == Shown.WhenTrue) ? text.equalsIgnoreCase("true") : text.equalsIgnoreCase("false"); }
/*     */     
/*     */     } 
/* 248 */     this.firstTick = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(HudRenderer renderer) {
/* 253 */     if (this.firstTick) runTick();
/*     */     
/* 255 */     boolean visible = (this.shown.get() == Shown.Always || this.visible);
/*     */     
/* 257 */     if ((this.empty || !visible) && isInEditor()) {
/* 258 */       renderer.line(this.x, this.y, (this.x + getWidth()), (this.y + getHeight()), Color.GRAY);
/* 259 */       renderer.line(this.x, (this.y + getHeight()), (this.x + getWidth()), this.y, Color.GRAY);
/*     */     } 
/*     */     
/* 262 */     if (this.section == null || !visible)
/*     */       return; 
/* 264 */     double x = (this.x + ((Integer)this.border.get()).intValue());
/* 265 */     Section s = this.section;
/*     */     
/* 267 */     if (((Boolean)this.background.get()).booleanValue())
/*     */     {
/* 269 */       renderer.drawContext.method_25294(this.x, this.y, this.x + getWidth(), this.y + getHeight(), ((SettingColor)this.backgroundColor.get()).getPacked());
/*     */     }
/*     */     
/* 272 */     while (s != null) {
/*     */       class_2561 txt;
/*     */       try {
/* 275 */         txt = FabricClientAudiences.of().toNative(
/* 276 */             MiniMessage.miniMessage().deserialize(s.text.replace("!hash!", "#")));
/*     */       } catch (Exception e) {
/* 278 */         txt = FabricClientAudiences.of().toNative(Component.text(e.getMessage()).color(TextColor.color(255, 0, 0)));
/* 279 */       }  VanillaTextRenderer.INSTANCE.begin(getScale());
/* 280 */       VanillaTextRenderer.INSTANCE.render(txt, (int)x, (this.y + ((Integer)this.border
/*     */ 
/*     */           
/* 283 */           .get()).intValue()), 
/* 284 */           getSectionColor(s.index), ((Boolean)this.shadow
/* 285 */           .get()).booleanValue());
/*     */       
/* 287 */       VanillaTextRenderer.INSTANCE.end(null);
/* 288 */       x += VanillaTextRenderer.INSTANCE.getWidth(txt, ((Boolean)this.shadow.get()).booleanValue());
/*     */       
/* 290 */       s = s.next;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onFontChanged() {
/* 296 */     this.recalculateSize = true;
/*     */   }
/*     */   
/*     */   private double getScale() {
/* 300 */     return ((Boolean)this.customScale.get()).booleanValue() ? ((Double)this.scale.get()).doubleValue() : Hud.get().getTextScale();
/*     */   }
/*     */   
/*     */   public static Color getSectionColor(int i) {
/* 304 */     List<SettingColor> colors = (List<SettingColor>)(Hud.get()).textColors.get();
/* 305 */     return (i >= 0 && i < colors.size()) ? (Color)colors.get(i) : WHITE;
/*     */   }
/*     */   
/*     */   public enum Shown {
/* 309 */     Always,
/* 310 */     WhenTrue,
/* 311 */     WhenFalse;
/*     */     
/*     */     public String toString() {
/*     */       // Byte code:
/*     */       //   0: getstatic de/Jakob/navine/hud/MiniTextHud$1.$SwitchMap$de$Jakob$navine$hud$MiniTextHud$Shown : [I
/*     */       //   3: aload_0
/*     */       //   4: invokevirtual ordinal : ()I
/*     */       //   7: iaload
/*     */       //   8: tableswitch default -> 36, 1 -> 44, 2 -> 49, 3 -> 54
/*     */       //   36: new java/lang/IncompatibleClassChangeError
/*     */       //   39: dup
/*     */       //   40: invokespecial <init> : ()V
/*     */       //   43: athrow
/*     */       //   44: ldc 'Always'
/*     */       //   46: goto -> 56
/*     */       //   49: ldc 'When True'
/*     */       //   51: goto -> 56
/*     */       //   54: ldc 'When False'
/*     */       //   56: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #315	-> 0
/*     */       //   #316	-> 44
/*     */       //   #317	-> 49
/*     */       //   #318	-> 54
/*     */       //   #315	-> 56
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	57	0	this	Lde/Jakob/navine/hud/MiniTextHud$Shown;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/hud/MiniTextHud.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */