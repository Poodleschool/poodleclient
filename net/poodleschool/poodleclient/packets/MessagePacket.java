/*    */ package de.Jakob.packets;
/*    */ 
/*    */ import eu.byncing.net.api.protocol.packet.EmptyPacket;
/*    */ import eu.byncing.net.api.protocol.packet.buffer.IPacketBuffer;
/*    */ 
/*    */ public class MessagePacket
/*    */   extends EmptyPacket {
/*    */   private String message;
/*    */   
/*    */   public MessagePacket(String message) {
/* 11 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public MessagePacket() {}
/*    */   
/*    */   public String getMessage() {
/* 18 */     return this.message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(IPacketBuffer buffer) {
/* 23 */     buffer.writeString(this.message);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(IPacketBuffer buffer) {
/* 28 */     this.message = buffer.readString();
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/packets/MessagePacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */