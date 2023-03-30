package net.harry.yu.tutorialmod.item;

import net.harry.yu.tutorialmod.TutorialMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //creates a registry to register items inside the item section under our
    //mod's section
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    //lowecase chars only
    public static final RegistryObject<Item> GWAGGIUM = ITEMS.register("gwaggium",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> GWASHIMOTO = ITEMS.register("gwashimoto",
            () -> new Item(new Item.Properties().fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
