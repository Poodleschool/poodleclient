/*    */ package net.poodleschool.poodleclient.poodleclient.richText;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import com.mojang.logging.LogUtils;
/*    */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*    */ import net.poodleschool.poodleclient.poodleclient.util.JsonUtils;
/*    */ import net.poodleschool.poodleclient.poodleclient.util.MapUtil;
/*    */ import de.Jakob.packets.RichTextPacket;
/*    */ import eu.byncing.net.api.channel.INetChannel;
/*    */ import java.util.HashMap;
/*    */ import java.util.function.BiConsumer;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_3414;
/*    */ import net.minecraft.class_3419;
/*    */ import org.slf4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RichTextHandler
/*    */ {
/* 25 */   private static final Logger log = LogUtils.getLogger();
/*    */   private static class_310 mc;
/*    */   
/*    */   static {
/* 29 */     consumers = MapUtil.map(new MapUtil.Entry[] {
/* 30 */           MapUtil.entry("ACTIONBAR", (json, ch) -> {
/*    */               if (!json.has("data")) {
/*    */                 return;
/*    */               }
/*    */               String content = json.get("data").getAsString();
/*    */               mc.field_1705.method_1758((class_2561)class_2561.method_43470(content), false);
/* 36 */             }), MapUtil.entry("SOUND", (json, ch) -> {
/*    */               if (!json.has("data")) {
/*    */                 return;
/*    */               }
/*    */ 
/*    */               
/*    */               JsonObject data = json.get("data").getAsJsonObject();
/*    */               
/*    */               if (JsonUtils.requireFields(data, new String[] { "volume", "pitch", "sound" })) {
/*    */                 return;
/*    */               }
/*    */               
/*    */               try {
/*    */                 mc.field_1724.method_17356(class_3414.method_47908(new class_2960(data.get("sound").getAsString())), class_3419.field_15250, data.get("volume").getAsFloat(), data.get("pitch").getAsFloat());
/* 50 */               } catch (Exception e) {
/*    */                 Addon.LOG.warn("Couldn't understand server rich text sound.");
/*    */               } 
/*    */             }) });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static final HashMap<String, BiConsumer<JsonObject, INetChannel>> consumers;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handleRichPacket(RichTextPacket pkt, INetChannel ch) {
/* 78 */     mc = class_310.method_1551();
/*    */     try {
/* 80 */       JsonObject message = JsonParser.parseString(pkt.getJson()).getAsJsonObject();
/* 81 */       if (!message.has("type")) {
/* 82 */         log.warn("Invalid RichText: " + message);
/*    */         
/*    */         return;
/*    */       } 
/* 86 */       String type = message.get("type").getAsString();
/*    */       
/* 88 */       ((BiConsumer<JsonObject, INetChannel>)consumers.getOrDefault(type, (j, c) -> log.warn("Unknown RichText message type: " + type))).accept(message, ch);
/* 89 */     } catch (Exception e) {
/* 90 */       log.warn("Couldn't understand rich text packet!", e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/richText/RichTextHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */