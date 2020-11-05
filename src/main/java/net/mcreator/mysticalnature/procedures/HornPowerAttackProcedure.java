package net.mcreator.mysticalnature.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mysticalnature.potion.HornPowerPotion;
import net.mcreator.mysticalnature.item.InvisibleItem;
import net.mcreator.mysticalnature.MysticalNatureModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

@MysticalNatureModElements.ModElement.Tag
public class HornPowerAttackProcedure extends MysticalNatureModElements.ModElement {
	public HornPowerAttackProcedure(MysticalNatureModElements instance) {
		super(instance, 202);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure HornPowerAttack!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HornPowerAttack!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((sourceentity instanceof PlayerEntity)) {
			if ((new Object() {
				boolean check(LivingEntity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = _entity.getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == HornPowerPotion.potion)
								return true;
						}
					}
					return false;
				}
			}.check((LivingEntity) sourceentity))) {
				if (world instanceof World && !world.getWorld().isRemote && sourceentity instanceof LivingEntity) {
					InvisibleItem.shoot(world.getWorld(), (LivingEntity) sourceentity, new Random(), (float) 0.5, (float) 0, (int) 3);
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
