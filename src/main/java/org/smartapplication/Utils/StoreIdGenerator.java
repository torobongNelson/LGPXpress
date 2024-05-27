package org.smartapplication.Utils;

import java.security.SecureRandom;
public class StoreIdGenerator {
      private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      private static final int CODE_LENGTH = 12;
      private static final SecureRandom RANDOM = new SecureRandom();

      public static String generateStoreId() {
         StringBuilder code = new StringBuilder(CODE_LENGTH);
         for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
         }
         return code.toString();
      }
}
