package net.ciupa.tutorialmod.datagen;

import net.ciupa.tutorialmod.TutorialMod;
import net.ciupa.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_ALEXANDRITE.get());
        basicItem(ModItems.ALEXANDRITE.get());
        basicItem(ModItems.CUP.get());
        basicItem(ModItems.AURORA_ASHES.get());
        basicItem(ModItems.BABY_OIL.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.DOG_TREAT.get());
        basicItem(ModItems.KOHLRABI.get());
        basicItem(ModItems.RUBY.get());
    }
}
