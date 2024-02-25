/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*     */ import java.util.ArrayList;
/*     */ import meteordevelopment.meteorclient.events.packets.PacketEvent;
/*     */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*     */ import meteordevelopment.meteorclient.settings.DoubleSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.KeybindSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.utils.Utils;
/*     */ import meteordevelopment.meteorclient.utils.entity.fakeplayer.FakePlayerEntity;
/*     */ import meteordevelopment.meteorclient.utils.misc.Keybind;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_2596;
/*     */ import net.minecraft.class_2828;
/*     */ import org.joml.Vector3d;
/*     */ 
/*     */ public class BlinkPlus extends Module {
/*     */   public enum Mode {
/*  23 */     OnDisable,
/*  24 */     AfterDistance,
/*  25 */     OnInterval,
/*  26 */     OnGround;
/*     */   }
/*     */ 
/*     */   
/*  30 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*     */   
/*  32 */   private final Setting<Mode> mode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  33 */       .name("send-mode"))
/*  34 */       .description("Packet sending mode."))
/*  35 */       .defaultValue(Mode.OnDisable))
/*  36 */       .build());
/*     */ 
/*     */   
/*  39 */   private final Setting<Double> distance = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/*  40 */       .name("distance"))
/*  41 */       .description("Max distance between sending packets."))
/*  42 */       .visible(() -> (this.mode.get() == Mode.AfterDistance)))
/*  43 */       .min(0.0D)
/*  44 */       .sliderRange(0.0D, 8.0D)
/*  45 */       .defaultValue(2.0D)
/*  46 */       .build());
/*     */ 
/*     */   
/*  49 */   private final Setting<Double> interval = this.sgGeneral.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/*  50 */       .name("interval"))
/*  51 */       .description("Interval between sending packets."))
/*  52 */       .visible(() -> (this.mode.get() == Mode.OnInterval)))
/*  53 */       .min(0.1D)
/*  54 */       .sliderRange(0.1D, 5.0D)
/*  55 */       .defaultValue(2.5D)
/*  56 */       .build());
/*     */ 
/*     */   
/*  59 */   private final Setting<Boolean> renderOriginal = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  60 */       .name("render-original"))
/*  61 */       .description("Renders your player model at the original position."))
/*  62 */       .defaultValue(Boolean.valueOf(true)))
/*  63 */       .build());
/*     */ 
/*     */   
/*  66 */   private final Setting<Keybind> cancelBlink = this.sgGeneral.add((Setting)((KeybindSetting.Builder)((KeybindSetting.Builder)((KeybindSetting.Builder)(new KeybindSetting.Builder())
/*  67 */       .name("cancel-blink"))
/*  68 */       .description("Cancels sending packets and sends you back to your original position."))
/*  69 */       .defaultValue(Keybind.none()))
/*  70 */       .action(() -> {
/*     */           this.cancelled = true;
/*     */           if (isActive())
/*     */             toggle(); 
/*  74 */         }).build());
/*     */ 
/*     */   
/*  77 */   private final List<class_2828> packets = new ArrayList<>();
/*     */   private FakePlayerEntity model;
/*  79 */   private final Vector3d start = new Vector3d();
/*     */   
/*     */   private boolean cancelled = false;
/*  82 */   private int timer = 0;
/*     */   
/*     */   public BlinkPlus() {
/*  85 */     super(Addon.CATEGORY, "blink-plus", "Allows you to essentially teleport while suspending motion updates.");
/*     */   }
/*     */ 
/*     */   
/*     */   public void onActivate() {
/*  90 */     if (((Boolean)this.renderOriginal.get()).booleanValue()) {
/*  91 */       this.model = new FakePlayerEntity((class_1657)this.mc.field_1724, this.mc.field_1724.method_7334().getName(), 20.0F, true);
/*  92 */       this.model.doNotPush = true;
/*  93 */       this.model.hideWhenInsideCamera = true;
/*  94 */       this.model.spawn();
/*     */     } 
/*     */     
/*  97 */     Utils.set(this.start, this.mc.field_1724.method_19538());
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDeactivate() {
/* 102 */     dumpPackets(!this.cancelled);
/* 103 */     if (this.cancelled) this.mc.field_1724.method_23327(this.start.x, this.start.y, this.start.z); 
/* 104 */     this.cancelled = false;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onTick(TickEvent.Post event) {
/* 109 */     this.timer++;
/*     */     
/* 111 */     if (this.mode.get() == Mode.OnGround && this.mc.field_1724.method_24828()) {
/* 112 */       toggle();
/* 113 */       toggle();
/*     */     } 
/*     */     
/* 116 */     if (this.mode.get() == Mode.OnInterval && (this.timer / 20.0F) >= ((Double)this.interval.get()).doubleValue()) {
/* 117 */       toggle();
/* 118 */       toggle();
/*     */     } 
/*     */   }
/*     */   @EventHandler
/*     */   private void onSendPacket(PacketEvent.Send event) {
/*     */     class_2828 p;
/* 124 */     class_2596 class_2596 = event.packet; if (class_2596 instanceof class_2828) { p = (class_2828)class_2596; } else { return; }
/* 125 */      event.cancel();
/*     */     
/* 127 */     class_2828 prev = this.packets.isEmpty() ? null : this.packets.get(this.packets.size() - 1);
/*     */     
/* 129 */     if (prev != null && p
/* 130 */       .method_12273() == prev.method_12273() && p
/* 131 */       .method_12271(-1.0F) == prev.method_12271(-1.0F) && p
/* 132 */       .method_12270(-1.0F) == prev.method_12270(-1.0F) && p
/* 133 */       .method_12269(-1.0D) == prev.method_12269(-1.0D) && p
/* 134 */       .method_12268(-1.0D) == prev.method_12268(-1.0D) && p
/* 135 */       .method_12274(-1.0D) == prev.method_12274(-1.0D)) {
/*     */       return;
/*     */     }
/* 138 */     synchronized (this.packets) {
/* 139 */       this.packets.add(p);
/*     */     } 
/*     */     
/* 142 */     if (this.mode.get() == Mode.AfterDistance && PlayerUtils.distanceTo(this.start.x, this.start.y, this.start.z) >= ((Double)this.distance.get()).doubleValue()) {
/* 143 */       toggle();
/* 144 */       toggle();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getInfoString() {
/* 150 */     return String.format("%.1f", new Object[] { Float.valueOf(this.timer / 20.0F) });
/*     */   }
/*     */   
/*     */   private void dumpPackets(boolean send) {
/* 154 */     synchronized (this.packets) {
/* 155 */       if (send) { Objects.requireNonNull(this.mc.field_1724.field_3944); this.packets.forEach(this.mc.field_1724.field_3944::method_52787); }
/* 156 */        this.packets.clear();
/*     */     } 
/*     */     
/* 159 */     if (this.model != null) {
/* 160 */       this.model.despawn();
/* 161 */       this.model = null;
/*     */     } 
/*     */     
/* 164 */     this.timer = 0;
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/BlinkPlus.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */