package com.cursee.examplemod.core.registry;

import com.cursee.examplemod.Constants;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RegistryNeoForge {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Constants.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Constants.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Constants.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, Constants.MOD_ID);

    public static void register(IEventBus modEventBus) {

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        ENTITY_TYPES.register(modEventBus);
        PARTICLE_TYPES.register(modEventBus);
        FEATURES.register(modEventBus);
    }

    protected static <T extends Block> DeferredHolder<Block, T> registerBlock(String objectID, Supplier<T> objectSupplier) {
        return BLOCKS.register(objectID, objectSupplier);
    }

    protected static <T extends Item> DeferredHolder<Item, T> registerItem(String objectID, Supplier<T> objectSupplier) {
        return ITEMS.register(objectID, objectSupplier);
    }

    protected static <T extends Block> DeferredHolder<Block, T> registerBlockWithItem(String objectID, Supplier<T> objectSupplier) {
        final DeferredHolder<Block, T> toReturn = registerBlock(objectID, objectSupplier);
        registerItem(objectID, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    protected static <T extends CreativeModeTab> DeferredHolder<CreativeModeTab, T> registerTab(String objectID, Supplier<T> objectSupplier) {
        return TABS.register(objectID, objectSupplier);
    }

    protected static <T extends BlockEntityType<?>> DeferredHolder<BlockEntityType<?>, T> registerBlockEntityType(String objectID, Supplier<T> objectSupplier) {
        return BLOCK_ENTITY_TYPES.register(objectID, objectSupplier);
    }

    protected static <T extends EntityType<?>> DeferredHolder<EntityType<?>, T> registerEntityType(String objectID, Supplier<T> objectSupplier) {
        return ENTITY_TYPES.register(objectID, objectSupplier);
    }

    protected static <T extends ParticleType<?>> DeferredHolder<ParticleType<?>, T> registerParticle(String objectID, Supplier<T> objectSupplier) {
        return PARTICLE_TYPES.register(objectID, objectSupplier);
    }

    protected static <T extends Feature<?>> DeferredHolder<Feature<?>, T> registerFeature(String objectID, Supplier<T> objectSupplier) {
        return FEATURES.register(objectID, objectSupplier);
    }
}
