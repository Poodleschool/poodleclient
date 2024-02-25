/*    */ package de.Jakob.packets;
/*    */ import eu.byncing.net.api.protocol.packet.EmptyPacket;
/*    */ import eu.byncing.net.api.protocol.packet.buffer.IPacketBuffer;
/*    */ 
/*    */ public class AuthResultPacket extends EmptyPacket {
/*    */   private AuthResult result;
/*    */   private String message;
/*    */   
/*    */   public enum AuthResult {
/* 10 */     FAIL,
/* 11 */     SUCCESS;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AuthResultPacket(AuthResult result, String message) {
/* 19 */     this.result = result;
/* 20 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public AuthResultPacket() {}
/*    */   
/*    */   public AuthResult getResult() {
/* 27 */     return this.result;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 31 */     return this.message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(IPacketBuffer buffer) {
/* 36 */     buffer.writeEnum(this.result);
/* 37 */     buffer.writeString(this.message);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(IPacketBuffer buffer) {
/* 42 */     this.result = (AuthResult)buffer.readEnum(AuthResult.class);
/* 43 */     this.message = buffer.readString();
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/packets/AuthResultPacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */