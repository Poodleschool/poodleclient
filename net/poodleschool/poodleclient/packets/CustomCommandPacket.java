/*    */ package de.Jakob.packets;
/*    */ 
/*    */ import eu.byncing.net.api.protocol.packet.EmptyPacket;
/*    */ import eu.byncing.net.api.protocol.packet.buffer.IPacketBuffer;
/*    */ 
/*    */ public class CustomCommandPacket
/*    */   extends EmptyPacket {
/*    */   private String command;
/*    */   private String[] args;
/*    */   
/*    */   public CustomCommandPacket(String command, String[] args) {
/* 12 */     this.command = command;
/* 13 */     this.args = args;
/*    */   }
/*    */ 
/*    */   
/*    */   public CustomCommandPacket() {}
/*    */   
/*    */   public String getCommand() {
/* 20 */     return this.command;
/*    */   }
/*    */   
/*    */   public String[] getArgs() {
/* 24 */     return this.args;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(IPacketBuffer buffer) {
/* 29 */     buffer.writeString(this.command);
/* 30 */     buffer.writeInt(this.args.length);
/* 31 */     for (int i = 0; i < this.args.length; i++) {
/* 32 */       buffer.writeString(this.args[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(IPacketBuffer buffer) {
/* 38 */     this.command = buffer.readString();
/* 39 */     int size = buffer.readInt();
/* 40 */     this.args = new String[size];
/* 41 */     for (int i = 0; i < size; i++)
/* 42 */       this.args[i] = buffer.readString(); 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/packets/CustomCommandPacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */