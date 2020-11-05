package net.mcreator.mysticalnature.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.mysticalnature.entity.AngryBloodSpiderEntity;
import net.mcreator.mysticalnature.MysticalNatureModElements;

import java.util.Map;

@MysticalNatureModElements.ModElement.Tag
public class BloodSpiderEggMobplayerCollidesWithPlantProcedure extends MysticalNatureModElements.ModElement {
	public BloodSpiderEggMobplayerCollidesWithPlantProcedure(MysticalNatureModElements instance) {
		super(instance, 194);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BloodSpiderEggMobplayerCollidesWithPlant!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BloodSpiderEggMobplayerCollidesWithPlant!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BloodSpiderEggMobplayerCollidesWithPlant!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BloodSpiderEggMobplayerCollidesWithPlant!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BloodSpiderEggMobplayerCollidesWithPlant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof PlayerEntity)) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			if ((Math.random() <= 0.7)) {
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new AngryBloodSpiderEntity.CustomEntity(AngryBloodSpiderEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			} else {
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new AngryBloodSpiderEntity.CustomEntity(AngryBloodSpiderEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new AngryBloodSpiderEntity.CustomEntity(AngryBloodSpiderEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
