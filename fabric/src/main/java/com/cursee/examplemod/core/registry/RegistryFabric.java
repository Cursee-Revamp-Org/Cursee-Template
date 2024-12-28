package com.cursee.examplemod.core.registry;

import com.cursee.examplemod.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.function.Supplier;

public class RegistryFabric {

    public static void register() {}

    protected static <T extends Block> T registerBlock(String objectID, Supplier<T> objectSupplier) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, objectID), objectSupplier.get());
    }

    protected static <T extends Item> T registerItem(String objectID, Supplier<T> objectSupplier) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, objectID), objectSupplier.get());
    }

    protected static <T extends Block> T registerBlockWithItem(String objectID, Supplier<T> objectSupplier) {
        final T toReturn = registerBlock(objectID, objectSupplier);
        registerItem(objectID, () -> new BlockItem(toReturn, new Item.Properties()));
        return toReturn;
    }

    protected static <T extends CreativeModeTab> T registerTab(String objectID, Supplier<T> objectSupplier) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MOD_ID, objectID), objectSupplier.get());
    }

    protected static <T extends BlockEntityType<?>> T registerBlockEntityType(String objectID, Supplier<T> objectSupplier) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Constants.MOD_ID, objectID), objectSupplier.get());
    }

    protected static <T extends EntityType<?>> T registerEntityType(String objectID, Supplier<T> objectSupplier) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(Constants.MOD_ID, objectID), objectSupplier.get());
    }

    protected static <T extends ParticleType<?>> T registerParticle(String objectID, Supplier<T> objectSupplier) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, new ResourceLocation(Constants.MOD_ID, objectID), objectSupplier.get());
    }

    protected static <T extends Feature<?>> T registerFeature(String objectID, Supplier<T> objectSupplier) {
        return Registry.register(BuiltInRegistries.FEATURE, new ResourceLocation(Constants.MOD_ID, objectID), objectSupplier.get());
    }
}
