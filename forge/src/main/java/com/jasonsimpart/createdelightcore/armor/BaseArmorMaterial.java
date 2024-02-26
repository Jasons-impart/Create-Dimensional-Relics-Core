package com.jasonsimpart.createdelightcore.armor;

import com.jasonsimpart.createdelightcore.CreateDelightCore;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum BaseArmorMaterial implements ArmorMaterial {
    BASE_ARMOR(CreateDelightCore.MODID + "base_armor", 3169, new int[]{2, 8, 10, 2}, 15, SoundEvents.ARMOR_EQUIP_GOLD, 100.0f,
            () -> {return Ingredient.of(Items.NETHERITE_INGOT);}, 0);
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{11, 16, 15, 13};//基础耐久(头，腿，胸，脚)
    private final String name;
    private final int maxDamageFactor;//耐久倍数（总耐久 = 耐久倍速 * 基础耐久）
    private final int[] damageReductionAmountArray;//生命值上面的盔甲槽 1为半个格子
    private final int enchantmentValue;
    private final SoundEvent soundEvent;//穿上的声音
    private final float toughness;//保护效果(护甲任性)
    private final Supplier<Ingredient> repairIngredient;//用来修复的材料
    private final float knockbackResistance;

    BaseArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantmentValue, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairIngredient, float knockbackResistance) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantmentValue = enchantmentValue;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairIngredient = repairIngredient;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
        return MAX_DAMAGE_ARRAY[equipmentSlot.getIndex()] *  this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
        return this.damageReductionAmountArray[equipmentSlot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
