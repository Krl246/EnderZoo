package crazypants.enderzoo.enchantment;

import net.minecraft.enchantment.Enchantment;
import crazypants.enderzoo.Log;
import crazypants.enderzoo.config.Config;

public class Enchantments {

  private static Enchantments instance;

  public static Enchantments getInstance() {
    if(instance == null) {
      instance = new Enchantments();
      instance.registerEnchantments();
    }
    return instance;
  }

  private EnchantmentWitherArrow witherArrow;
  private EnchantmentWitherWeapon witherWeapon;

  private void registerEnchantments() {
    int id = Config.enchantmentWitherArrowId;
    if(id < 0) {
      id = getEmptyEnchantId();
    }
    if(id < 0) {
      Log.error("Could not find an empty enchantment ID to add enchanments");
      return;
    }
    witherArrow = new EnchantmentWitherArrow(id);

    id = Config.enchantmentWitherWeaponId;
    if(id < 0) {
      id = getEmptyEnchantId();
    }
    if(id < 0) {
      Log.error("Could not find an empty enchantment ID to add enchanments");
      return;
    }
    witherWeapon = new EnchantmentWitherWeapon(id);
  }

  private int getEmptyEnchantId() {
    for (int i = 0; i < 256; i++) {
      if(Enchantment.getEnchantmentById(i) == null) {
    	  
        return i;
      }
    }
    return -1;
  }

}
