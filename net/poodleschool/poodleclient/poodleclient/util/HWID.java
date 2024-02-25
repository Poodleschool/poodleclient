/*    */ package net.poodleschool.poodleclient.poodleclient.util;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ public class HWID {
/*  7 */   private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
/*    */   
/*    */   public static byte[] generateHWID() {
/*    */     try {
/* 11 */       MessageDigest hash = MessageDigest.getInstance("MD5");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 20 */       String s = System.getProperty("os.name") + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + Runtime.getRuntime().availableProcessors() + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432");
/* 21 */       return hash.digest(s.getBytes());
/* 22 */     } catch (NoSuchAlgorithmException e) {
/* 23 */       throw new Error("Algorithm wasn't found.", e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static byte[] hexStringToByteArray(String s) {
/* 29 */     int len = s.length();
/* 30 */     byte[] data = new byte[len / 2];
/* 31 */     for (int i = 0; i < len; i += 2) {
/* 32 */       data[i / 2] = 
/* 33 */         (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
/*    */     }
/* 35 */     return data;
/*    */   }
/*    */   
/*    */   public static String bytesToHex(byte[] bytes) {
/* 39 */     char[] hexChars = new char[bytes.length * 2];
/* 40 */     for (int j = 0; j < bytes.length; j++) {
/* 41 */       int v = bytes[j] & 0xFF;
/* 42 */       hexChars[j * 2] = hexArray[v >>> 4];
/* 43 */       hexChars[j * 2 + 1] = hexArray[v & 0xF];
/*    */     } 
/* 45 */     return new String(hexChars);
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/HWID.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */