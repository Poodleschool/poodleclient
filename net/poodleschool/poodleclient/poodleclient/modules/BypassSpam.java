/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ import java.time.Instant;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import meteordevelopment.meteorclient.events.game.GameLeftEvent;
/*     */ import meteordevelopment.meteorclient.events.game.OpenScreenEvent;
/*     */ import meteordevelopment.meteorclient.mixin.ClientPlayNetworkHandlerAccessor;
/*     */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.IntSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.StringListSetting;
/*     */ import meteordevelopment.meteorclient.settings.StringSetting;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.utils.Utils;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_2596;
/*     */ import net.minecraft.class_2797;
/*     */ import net.minecraft.class_3515;
/*     */ import net.minecraft.class_634;
/*     */ import net.minecraft.class_7469;
/*     */ import net.minecraft.class_7608;
/*     */ import net.minecraft.class_7637;
/*     */ 
/*     */ public class BypassSpam extends Module {
/*  26 */   private int space = 0;
/*     */   
/*     */   private boolean back = false;
/*  29 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*     */   
/*     */   public enum SpamMode
/*     */   {
/*  33 */     NORMAL,
/*  34 */     MATRIX;
/*     */   }
/*     */ 
/*     */   
/*  38 */   public final Setting<SpamMode> mode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  39 */       .name("mode"))
/*  40 */       .description("The Mode to choose."))
/*  41 */       .defaultValue(SpamMode.NORMAL))
/*  42 */       .build());
/*     */ 
/*     */   
/*  45 */   private final Setting<List<String>> messages = this.sgGeneral.add((Setting)((StringListSetting.Builder)((StringListSetting.Builder)((StringListSetting.Builder)((StringListSetting.Builder)(new StringListSetting.Builder())
/*  46 */       .name("messages"))
/*  47 */       .description("Messages to use for spam."))
/*  48 */       .defaultValue(List.of("Meteor on Crack!")))
/*  49 */       .visible(() -> (this.mode.get() == SpamMode.NORMAL)))
/*  50 */       .build());
/*     */ 
/*     */   
/*  53 */   private final Setting<Integer> amount = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/*  54 */       .name("amount"))
/*  55 */       .description("Messages per Tick"))
/*  56 */       .range(1, 50)
/*  57 */       .sliderRange(1, 20)
/*  58 */       .defaultValue(Integer.valueOf(5)))
/*  59 */       .build());
/*     */ 
/*     */   
/*  62 */   private final Setting<String> bypassCommand = this.sgGeneral.add((Setting)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)(new StringSetting.Builder())
/*  63 */       .name("command"))
/*  64 */       .description("The Command used to bypass"))
/*  65 */       .defaultValue("/skill"))
/*  66 */       .build());
/*     */ 
/*     */   
/*  69 */   private final Setting<Boolean> disableOnLeave = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  70 */       .name("disable-on-leave"))
/*  71 */       .description("Disables spam when you leave a server."))
/*  72 */       .defaultValue(Boolean.valueOf(true)))
/*  73 */       .build());
/*     */ 
/*     */ 
/*     */   
/*  77 */   private final Setting<Boolean> disableOnDisconnect = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  78 */       .name("disable-on-disconnect"))
/*  79 */       .description("Disables spam when you are disconnected from a server."))
/*  80 */       .defaultValue(Boolean.valueOf(true)))
/*  81 */       .build());
/*     */ 
/*     */   
/*  84 */   private final Setting<Boolean> random = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  85 */       .name("randomise"))
/*  86 */       .description("Selects a random message from your spam message list."))
/*  87 */       .defaultValue(Boolean.valueOf(false)))
/*  88 */       .build());
/*     */   
/*     */   private int messageI;
/*     */ 
/*     */   
/*     */   public BypassSpam() {
/*  94 */     super(Addon.CATEGORY, "bypass-spam", "Bypass spigot AntiSpam.");
/*     */   }
/*     */ 
/*     */   
/*     */   public void onActivate() {
/*  99 */     this.messageI = 0;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onScreenOpen(OpenScreenEvent event) {
/* 104 */     if (((Boolean)this.disableOnDisconnect.get()).booleanValue() && event.screen instanceof net.minecraft.class_419) {
/* 105 */       toggle();
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onGameLeft(GameLeftEvent event) {
/* 111 */     if (((Boolean)this.disableOnLeave.get()).booleanValue()) toggle(); 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   private void onTick(TickEvent.Post event) {
/* 116 */     if (((List)this.messages.get()).isEmpty())
/*     */       return; 
/* 118 */     for (int times = 0; times <= ((Integer)this.amount.get()).intValue(); times++) {
/* 119 */       if (this.mode.get() == SpamMode.NORMAL) {
/*     */         int i;
/* 121 */         if (((Boolean)this.random.get()).booleanValue()) {
/* 122 */           i = Utils.random(0, ((List)this.messages.get()).size());
/*     */         } else {
/*     */           
/* 125 */           if (this.messageI >= ((List)this.messages.get()).size()) this.messageI = 0; 
/* 126 */           i = this.messageI++;
/*     */         } 
/*     */         
/* 129 */         String text = (String)this.bypassCommand.get() + " " + (String)this.bypassCommand.get();
/*     */         
/* 131 */         Instant instant = Instant.now();
/* 132 */         long l = class_3515.class_7426.method_43531();
/* 133 */         class_634 handler = this.mc.method_1562();
/* 134 */         class_7637.class_7816 lastSeenMessages = ((ClientPlayNetworkHandlerAccessor)handler).getLastSeenMessagesCollector().method_46266();
/* 135 */         class_7469 messageSignatureData = ((ClientPlayNetworkHandlerAccessor)handler).getMessagePacker().pack(new class_7608(text, instant, l, lastSeenMessages.comp_1073()));
/* 136 */         handler.method_52787((class_2596)new class_2797(text, instant, l, messageSignatureData, lastSeenMessages.comp_1074()));
/*     */       } 
/*     */       
/* 139 */       if (this.mode.get() == SpamMode.MATRIX) {
/* 140 */         StringBuilder loool = new StringBuilder();
/* 141 */         for (int i = 0; i < 15; i++) {
/* 142 */           loool.append((new Random()).nextInt(0, 2));
/*     */         }
/* 144 */         String text = (String)this.bypassCommand.get() + " " + (String)this.bypassCommand.get();
/*     */         
/* 146 */         Instant instant = Instant.now();
/* 147 */         long l = class_3515.class_7426.method_43531();
/* 148 */         class_634 handler = this.mc.method_1562();
/* 149 */         class_7637.class_7816 lastSeenMessages = ((ClientPlayNetworkHandlerAccessor)handler).getLastSeenMessagesCollector().method_46266();
/* 150 */         class_7469 messageSignatureData = ((ClientPlayNetworkHandlerAccessor)handler).getMessagePacker().pack(new class_7608(text, instant, l, lastSeenMessages.comp_1073()));
/* 151 */         handler.method_52787((class_2596)new class_2797(text, instant, l, messageSignatureData, lastSeenMessages.comp_1074()));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/BypassSpam.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */