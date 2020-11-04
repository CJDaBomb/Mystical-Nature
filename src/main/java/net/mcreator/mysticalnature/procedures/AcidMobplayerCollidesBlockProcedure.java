package net.mcreator.mysticalnature.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mysticalnature.potion.CorrosionPotion;
import net.mcreator.mysticalnature.item.CorrosiveArmorItem;
import net.mcreator.mysticalnature.entity.SulfuricGolemEntity;
import net.mcreator.mysticalnature.entity.GastrofrogEntity;
import net.mcreator.mysticalnature.entity.CorrosiveSpiderEntity;
import net.mcreator.mysticalnature.entity.AcidophilixEntity;
import net.mcreator.mysticalnature.entity.AcidmanderEntity;
import net.mcreator.mysticalnature.MysticalNatureModElements;

import java.util.Map;

@MysticalNatureModElements.ModElement.Tag
public class AcidMobplayerCollidesBlockProcedure extends MysticalNatureModElements.ModElement {
	public AcidMobplayerCollidesBlockProcedure(MysticalNatureModElements instance) {
		super(instance, 74);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AcidMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((!(entity instanceof GastrofrogEntity.CustomEntity))
				&& ((!(entity instanceof AcidophilixEntity.CustomEntity)) && ((!(entity instanceof AcidmanderEntity.CustomEntity))
						&& ((!(entity instanceof CorrosiveSpiderEntity.CustomEntity)) && (!(entity instanceof SulfuricGolemEntity.CustomEntity))))))
				|| (!((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(CorrosiveArmorItem.helmet, (int) (1)).getItem())
						&& ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
								.getItem() == new ItemStack(CorrosiveArmorItem.body, (int) (1)).getItem())
								&& ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
										.getItem() == new ItemStack(CorrosiveArmorItem.legs, (int) (1)).getItem())
										&& (((entity instanceof PlayerEntity)
												? ((PlayerEntity) entity).inventory.armorInventory.get(4)
												: ItemStack.EMPTY).getItem() == new ItemStack(CorrosiveArmorItem.boots, (int) (1)).getItem()))))))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(CorrosionPotion.potion, (int) 60, (int) 1));
		}
	}
}
