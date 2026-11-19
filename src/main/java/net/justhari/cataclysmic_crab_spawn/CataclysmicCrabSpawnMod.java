package net.justhari.cataclysmic_crab_spawn;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(CataclysmicCrabSpawnMod.MOD_ID)
public final class CataclysmicCrabSpawnMod {
    public static final String MOD_ID = "cataclysmic_crab_spawn";

    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<SuspiciousLookingCrabItem> SUSPICIOUS_LOOKING_CRAB = ITEMS.register(
            "suspicious_looking_crab",
            () -> new SuspiciousLookingCrabItem(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)));

    public CataclysmicCrabSpawnMod(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreativeContents);
    }

    private void addCreativeContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(SUSPICIOUS_LOOKING_CRAB);
        }
    }
}
