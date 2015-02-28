package crazypants.enderzoo.item;

import java.util.HashMap;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import crazypants.enderzoo.EnderZoo;
import crazypants.enderzoo.EnderZooTab;
import crazypants.enderzoo.Log;

public class ItemWitheringDust extends Item {

  public static final String NAME = "witheringDust";

  public static ItemWitheringDust create() {
    ItemWitheringDust res = new ItemWitheringDust();
    res.init();
    return res;
  }

  private ItemWitheringDust() {
    setUnlocalizedName(NAME);
    setCreativeTab(EnderZooTab.tabEnderZoo);
    setHasSubtypes(false);
  }
  
  private void init() {
    GameRegistry.registerItem(this, NAME);    
    try {
      HashMap myPotionRequirements = (HashMap)ReflectionHelper.getPrivateValue(PotionHelper.class, null, "potionRequirements", "field_77927_l");      
      myPotionRequirements.put(Integer.valueOf(Potion.wither.getId()), "0 & 1 & !2 &  3 & 0+6");
    } catch (Exception e) {
      Log.error("ItemWitheringDust: Could not register wither potion recipe " + e);
    }   
    
  }
  
  @Override
  public String getPotionEffect(ItemStack p_150896_1_) {
    return "+0+1-2+3&4-4+13";
  }
  
  
  
}
