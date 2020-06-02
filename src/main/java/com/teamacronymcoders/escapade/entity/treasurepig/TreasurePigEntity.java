package com.teamacronymcoders.escapade.entity.treasurepig;

import com.teamacronymcoders.escapade.datagen.impl.loottable.EscapadeEntityLootTableProvider.EscapadeEntityLootTables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class TreasurePigEntity extends PigEntity {

    public TreasurePigEntity(EntityType<? extends TreasurePigEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.75D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerAttributes() {
        this.getAttributes().registerAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35.0D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ARMOR);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS);
        this.getAttributes().registerAttribute(SWIM_SPEED);
        this.getAttributes().registerAttribute(NAMETAG_DISTANCE);
        this.getAttributes().registerAttribute(ENTITY_GRAVITY);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return EscapadeEntityLootTables.TREASURE_PIG;
    }

    @Override
    protected boolean canBeRidden(Entity entityIn) {
        return false;
    }

    @Override
    public boolean canBeSteered() {
        return false;
    }

}
