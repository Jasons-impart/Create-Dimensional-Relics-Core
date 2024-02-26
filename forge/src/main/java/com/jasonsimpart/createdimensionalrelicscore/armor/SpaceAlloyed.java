package com.jasonsimpart.createdimensionalrelicscore.armor;

import com.jasonsimpart.createdimensionalrelicscore.CreateDimensionalRelicsCore;
import earth.terrarium.ad_astra.common.config.SpaceSuitConfig;
import earth.terrarium.ad_astra.common.item.armor.JetSuit;
import earth.terrarium.ad_astra.common.util.ModKeyBindings;
import earth.terrarium.ad_astra.common.util.ModUtils;
import earth.terrarium.botarium.api.energy.EnergyHooks;
import earth.terrarium.botarium.api.item.ItemStackHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class SpaceAlloyed extends JetSuit{
    private boolean isFallFlying;
    private boolean emitParticles;
    public SpaceAlloyed(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void fly(Player player, ItemStack stack)
    {
        emitParticles = false;
        ItemStackHolder stackHolder = new ItemStackHolder(stack);
        //创造不启用
        if (player.getAbilities().flying) {
            return;
        }

        if (ModKeyBindings.sprintKeyDown(player)) {
            this.fallFly(player, stackHolder);
        } else {
            this.flyUpward(player, stackHolder);
        }

        if (isFallFlying) {
            if (!player.isFallFlying()) {
                player.startFallFlying();
            }
        } else {
            if (player.isFallFlying()) {
                player.stopFallFlying();
            }
        }
        emitParticles = true;
        if (stackHolder.isDirty()) player.setItemSlot(EquipmentSlot.CHEST, stackHolder.getStack());
        ModUtils.sendUpdatePacket((ServerPlayer) player);
    }

    @Override
    public void flyUpward(Player player, ItemStackHolder stack) {
        if (EnergyHooks.isEnergyItem(stack.getStack())) {
            player.fallDistance /= 2;

            var energy = EnergyHooks.getItemEnergyManager(stack.getStack());
            long tickEnergy = 60;
            if (!player.isCreative()) {
                //energy.extract(stack, tickEnergy, false);
            }
            isFallFlying = false;

            double speed = 0.5;
            player.setDeltaMovement(player.getDeltaMovement().add(0.0, speed, 0.0));
            if (player.getDeltaMovement().y() > speed) {
                player.setDeltaMovement(player.getDeltaMovement().x(), speed, player.getDeltaMovement().z());
            }
        }
    }

    @Override
    public void fallFly(Player player, ItemStackHolder stack) {
        if (player.isOnGround()) {
            player.fallDistance /= 2;
        }
        var energy = EnergyHooks.getItemEnergyManager(stack.getStack());
        long tickEnergy = SpaceSuitConfig.jetSuitEnergyPerTick;
        if (!player.isCreative()) {
            //energy.extract(stack, tickEnergy, false);
        }
        isFallFlying = true;

        double speed = SpaceSuitConfig.jetSuitSpeed - (ModUtils.getEntityGravity(player) * 0.25);
        Vec3 rotationVector = player.getLookAngle().scale(speed);
        Vec3 velocity = player.getDeltaMovement();
        player.setDeltaMovement(velocity.add(rotationVector.x() * 0.1 + (rotationVector.x() * 1.5 - velocity.x()) * 0.5, rotationVector.y() * 0.1 + (rotationVector.y() * 1.5 - velocity.y()) * 0.5, rotationVector.z() * 0.1 + (rotationVector.z() * 1.5 - velocity.z()) * 0.5));
    }

    public void setFallFlying(boolean fallFlying) {
        isFallFlying = fallFlying;
    }

    public boolean setEmitParticles(boolean emitParticles) {
        return this.emitParticles = emitParticles;
    }

    @Override
    public long getFluidAmount(ItemStack stack) {
        return 114514;
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return new ResourceLocation(CreateDimensionalRelicsCore.MODID, "textures/item/space_alloyed_suit.png").toString();
    }
}
