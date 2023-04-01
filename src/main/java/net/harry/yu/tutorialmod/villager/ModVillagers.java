package net.harry.yu.tutorialmod.villager;

import com.google.common.collect.ImmutableSet;
import com.ibm.icu.impl.locale.XCldrStub;
import net.harry.yu.tutorialmod.TutorialMod;
import net.harry.yu.tutorialmod.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    //poi is point of interest -> where entities go to hide
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TutorialMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TutorialMod.MOD_ID);
    //registry object for the POI
    //range is where they can find
    //the craziness with the statedefinition means that the villager can use it with any state
    public static final RegistryObject<PoiType> JUMPY_BLOCK_POI =
            POI_TYPES.register("jumpy_block_poi",
            ()-> new PoiType(ImmutableSet.copyOf(ModBlocks.JUMPY.get().getStateDefinition().getPossibleStates()),
                    1, 1));
    //predicate x->x.get == ... so on is to check if the two are the same
    //the two predicates are the two worksites(?) primary/secondary

    public static final RegistryObject<VillagerProfession> JUMP_MASTER = VILLAGER_PROFESSION.register(
            "jump_master", () -> new VillagerProfession("jump_master", x-> x.get() == JUMPY_BLOCK_POI.get(), x-> x.get() == JUMPY_BLOCK_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));




    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates",
                    PoiType.class).invoke(null, JUMPY_BLOCK_POI.get());


        } catch (InvocationTargetException | IllegalAccessException exception)
        {
            exception.printStackTrace();
        }

    }

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSION.register(eventBus);
    }
}
