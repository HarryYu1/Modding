package net.harry.yu.tutorialmod.item;

import net.harry.yu.tutorialmod.TutorialMod;
import net.harry.yu.tutorialmod.block.ModBlocks;
import net.harry.yu.tutorialmod.item.custom.EightBallItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //creates a registry to register items inside the item section under our
    //mod's section
    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    //lowecase chars only
    //registry object are stored in the register
    public static final RegistryObject<Item> GWAGGIUM = ITEM.register("gwaggium",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> GWASHIMOTO = ITEM.register("gwashimoto",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EIGHT_BALL = ITEM.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEM.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLUEBERRY = ITEM.register("blueberry",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2)
                    .saturationMod(2f).build()))); //build is necessary since its a builder

    public static void register(IEventBus eventBus) {
        ITEM.register(eventBus);

    }
}
