/*    */ package net.poodleschool.poodleclient.poodleclient.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.CopyOnWriteArrayList;
/*    */ import meteordevelopment.meteorclient.events.packets.PacketEvent;
/*    */ import meteordevelopment.meteorclient.events.render.Render2DEvent;
/*    */ import meteordevelopment.orbit.EventHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameDataUtil
/*    */ {
/* 20 */   private static final List<Long> fpsCounter = new ArrayList<>();
/* 21 */   private static final List<Long> packetInCounter = new CopyOnWriteArrayList<>();
/* 22 */   private static final List<Long> packetOutCounter = new CopyOnWriteArrayList<>();
/*    */   
/*    */   public static int getFPS() {
/* 25 */     return fpsCounter.size();
/*    */   }
/*    */   
/*    */   public static int getPacketInCount() {
/* 29 */     return packetInCounter.size();
/*    */   }
/*    */   
/*    */   public static int getPacketOutCount() {
/* 33 */     return packetOutCounter.size();
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPacket(PacketEvent.Receive event) {
/* 38 */     synchronized (packetInCounter) {
/* 39 */       packetInCounter.add(Long.valueOf(System.currentTimeMillis() + 1000L));
/* 40 */       packetInCounter.removeIf(l -> (System.currentTimeMillis() > l.longValue()));
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPacket(PacketEvent.Sent ignored) {
/* 46 */     synchronized (packetOutCounter) {
/* 47 */       packetOutCounter.add(Long.valueOf(System.currentTimeMillis() + 1000L));
/* 48 */       packetOutCounter.removeIf(l -> (System.currentTimeMillis() > l.longValue()));
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onRender2D(Render2DEvent ignored) {
/* 54 */     synchronized (fpsCounter) {
/* 55 */       fpsCounter.add(Long.valueOf(System.currentTimeMillis() + 1000L));
/* 56 */       fpsCounter.removeIf(l -> (System.currentTimeMillis() > l.longValue()));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/GameDataUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */