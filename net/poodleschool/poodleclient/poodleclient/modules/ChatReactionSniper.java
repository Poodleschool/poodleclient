/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ 
/*     */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import meteordevelopment.meteorclient.events.game.ReceiveMessageEvent;
/*     */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*     */ import meteordevelopment.meteorclient.settings.StringSetting;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.utils.player.ChatUtils;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_3544;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ public class ChatReactionSniper
/*     */   extends Module
/*     */ {
/*  20 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*     */   
/*  22 */   private Pattern pattern = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<String> filter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Boolean> removeWhitespaces;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Boolean> stripColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Boolean> resultFeedback;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Setting<Boolean> autoSend;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onActivate() {
/*     */     try {
/*  72 */       this.pattern = Pattern.compile((String)this.filter.get());
/*  73 */     } catch (Exception e) {
/*  74 */       error("Failed to compile regex pattern: " + e.getLocalizedMessage(), new Object[0]);
/*  75 */       this.pattern = null;
/*  76 */       toggle();
/*     */     } 
/*     */   }
/*     */   
/*     */   public ChatReactionSniper() {
/*  81 */     super(Addon.CATEGORY, "chat-reaction-sniper", "(WIP) Snipes chat reactions from PlotMe"); this.filter = this.sgGeneral.add((Setting)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)(new StringSetting.Builder()).name("filter")).description("Filter to extract the word. Supports regex.\nRegex must contain a group called \"word\"!")).wide().onChanged(str -> { try {
/*     */               this.pattern = Pattern.compile(str);
/*     */             } catch (Exception e) {
/*     */               error("Failed to compile regex pattern: " + e.getLocalizedMessage(), new Object[0]); this.pattern = null; toggle();
/*     */             } 
/*  86 */           })).defaultValue("First one to type (?<word>[A-Za-z]+) wins!")).build()); this.removeWhitespaces = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("remove-whitespaces")).description("Removes all beginning and trailing whitespaces.")).defaultValue(Boolean.valueOf(true))).build()); this.stripColor = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("strip-color")).description("Removes all formatting from messages.")).defaultValue(Boolean.valueOf(true))).build()); this.resultFeedback = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("result-feedback")).description("Log found words to chat.")).defaultValue(Boolean.valueOf(true))).build()); this.autoSend = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder()).name("auto-send")).description("Automatically sends the found word in chat.")).defaultValue(Boolean.valueOf(true))).build()); } @EventHandler private void onReceiveMessage(ReceiveMessageEvent event) { if (this.pattern == null || (!((Boolean)this.resultFeedback.get()).booleanValue() && !((Boolean)this.autoSend.get()).booleanValue())) {
/*     */       return;
/*     */     }
/*  89 */     String text = event.getMessage().getString();
/*     */     
/*  91 */     if (((Boolean)this.removeWhitespaces.get()).booleanValue())
/*  92 */       text = StringUtils.normalizeSpace(text); 
/*  93 */     if (((Boolean)this.stripColor.get()).booleanValue()) {
/*  94 */       text = class_3544.method_15440(text);
/*     */     }
/*  96 */     if (text.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     try {
/* 100 */       Matcher matcher = this.pattern.matcher(text);
/* 101 */       if (!matcher.matches())
/*     */         return; 
/* 103 */       String str = matcher.group("word");
/* 104 */       if (((Boolean)this.resultFeedback.get()).booleanValue())
/* 105 */         info("Extracted: §r" + str, new Object[0]); 
/* 106 */       if (((Boolean)this.autoSend.get()).booleanValue())
/* 107 */         ChatUtils.sendPlayerMsg(str); 
/* 108 */     } catch (Exception e) {
/* 109 */       error(e.getLocalizedMessage(), new Object[0]);
/*     */     }  }
/*     */ 
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/ChatReactionSniper.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */