/*    */ package de.Jakob.packets;
/*    */ 
/*    */ import eu.byncing.net.api.protocol.packet.EmptyPacket;
/*    */ import eu.byncing.net.api.protocol.packet.buffer.IPacketBuffer;
/*    */ 
/*    */ public class LoginPacket extends EmptyPacket {
/*    */   private String user;
/*    */   private String hwid;
/*    */   
/*    */   public LoginPacket(String user, String hwid) {
/* 11 */     this.user = user;
/* 12 */     this.hwid = hwid;
/*    */   }
/*    */ 
/*    */   
/*    */   public LoginPacket() {}
/*    */   
/*    */   public String getUser() {
/* 19 */     return this.user;
/*    */   }
/*    */   
/*    */   public String getHwid() {
/* 23 */     return this.hwid;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(IPacketBuffer buffer) {
/* 28 */     buffer.writeString(this.user);
/* 29 */     buffer.writeString(this.hwid);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(IPacketBuffer buffer) {
/* 34 */     this.user = buffer.readString();
/* 35 */     this.hwid = buffer.readString();
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/packets/LoginPacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */