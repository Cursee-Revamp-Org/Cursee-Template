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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RegistryForge {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Constants.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Constants.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Constants.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Constants.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Constants.MOD_ID);

    public static void register(IEventBus modEventBus) {
        
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        ENTITY_TYPES.register(modEventBus);
        PARTICLE_TYPES.register(modEventBus);
        FEATURES.register(modEventBus);
    }

    protected static <T extends Block> RegistryObject<T> registerBlock(String objectID, Supplier<T> objectSupplier) {
        return BLOCKS.register(objectID, objectSupplier);
    }

    protected static <T extends Item> RegistryObject<T> registerItem(String objectID, Supplier<T> objectSupplier) {
        return ITEMS.register(objectID, objectSupplier);
    }

    protected static <T extends Block> RegistryObject<T> registerBlockWithItem(String objectID, Supplier<T> objectSupplier) {
        final RegistryObject<T> toReturn = registerBlock(objectID, objectSupplier);
        registerItem(objectID, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    protected static <T extends CreativeModeTab> RegistryObject<T> registerTab(String objectID, Supplier<T> objectSupplier) {
        return TABS.register(objectID, objectSupplier);
    }

    protected static <T extends BlockEntityType<?>> RegistryObject<T> registerBlockEntityType(String objectID, Supplier<T> objectSupplier) {
        return BLOCK_ENTITY_TYPES.register(objectID, objectSupplier);
    }

    protected static <T extends EntityType<?>> RegistryObject<T> registerEntityType(String objectID, Supplier<T> objectSupplier) {
        return ENTITY_TYPES.register(objectID, objectSupplier);
    }

    protected static <T extends ParticleType<?>> RegistryObject<T> registerParticle(String objectID, Supplier<T> objectSupplier) {
        return PARTICLE_TYPES.register(objectID, objectSupplier);
    }

    protected static <T extends Feature<?>> RegistryObject<T> registerFeature(String objectID, Supplier<T> objectSupplier) {
        return FEATURES.register(objectID, objectSupplier);
    }
}
