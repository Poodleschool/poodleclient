/*    */ package de.Jakob.packets;
/*    */ 
/*    */ import eu.byncing.net.api.protocol.packet.EmptyPacket;
/*    */ import eu.byncing.net.api.protocol.packet.buffer.IPacketBuffer;
/*    */ 
/*    */ public class RichTextPacket extends EmptyPacket {
/*    */   private String json;
/*    */   
/*    */   public RichTextPacket() {}
/*    */   
/*    */   public RichTextPacket(String json) {
/* 12 */     this.json = json;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(IPacketBuffer buffer) {
/* 17 */     buffer.writeString(this.json);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(IPacketBuffer buffer) {
/* 22 */     this.json = buffer.readString();
/*    */   }
/*    */   
/*    */   public String getJson() {
/* 26 */     return this.json;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/packets/RichTextPacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */