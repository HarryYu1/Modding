package net.harry.yu.tutorialmod.block;

import net.harry.yu.tutorialmod.TutorialMod;
import net.harry.yu.tutorialmod.block.custom.GwaggiumLampBlock;
import net.harry.yu.tutorialmod.block.custom.jumpy;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.harry.yu.tutorialmod.item.ModItems;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    //specifies location and type of register
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    //make some blocks and blockitems
    public static final RegistryObject<Block> GWAGGIUM_BLOCK = registerBlock("gwaggium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST).friction(0.99f).strength(6f).lightLevel((anystate)->10)));
    public static final RegistryObject<Item> GWAGGIUM_BLOCK_ITEM = registerBlockItem("gwaggium_block", GWAGGIUM_BLOCK, new Item.Properties().fireResistant().stacksTo(16));
    public static final RegistryObject<Block> GWAGGIUM_ORE = registerBlock("gwaggium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST).strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Item> GWAGGIUM_ORE_ITEM = registerBlockItem("gwaggium_ore", GWAGGIUM_ORE, new Item.Properties().fireResistant().stacksTo(64));
    public static final RegistryObject<Block> DEEP_GWAGGIUM_ORE = registerBlock("deepslate_gwaggium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST).strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Item> DEEP_GWAGGIUM_ORE_ITEM = registerBlockItem("deepslate_gwaggium_ore", DEEP_GWAGGIUM_ORE, new Item.Properties().fireResistant().stacksTo(64));

    public static final RegistryObject<Block> JUMPY = registerBlock("jumpy_block",
            () -> new jumpy(BlockBehaviour.Properties.of(Material.STONE).lightLevel((anystate)->15)));
    public static final RegistryObject<Item> JUMPY_ITEM = registerBlockItem("jumpy_block", JUMPY, new Item.Properties().fireResistant().stacksTo(64));
    //register block
    public static final RegistryObject<Block> GWAGGIUM_LAMP = registerBlock("gwaggium_lamp",
            () -> new GwaggiumLampBlock(BlockBehaviour.Properties.of(Material.GLASS).lightLevel(state -> state.getValue(GwaggiumLampBlock.LIT) ? 15:0)));
    public static final RegistryObject<Item> GWAGGIUM_LAMP_ITEM = registerBlockItem("gwaggium_lamp", GWAGGIUM_LAMP, new Item.Properties().fireResistant().stacksTo(64));
    //register block


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        //generics -> registryobject returns type T, and T is a block of sopme kind
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        return toReturn;

    }
    private static <T extends Block> RegistryObject <Item> registerBlockItem(String name, Supplier<T> block, Item.Properties properties)
    {
        return ModItems.ITEM.register(name, () -> new BlockItem(block.get(), properties));
    }

    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus); //so we can register blocks at the right time
    }
}
