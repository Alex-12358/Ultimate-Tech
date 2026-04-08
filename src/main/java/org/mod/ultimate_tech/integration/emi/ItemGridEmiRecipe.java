package org.mod.ultimate_tech.integration.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemGridEmiRecipe implements EmiRecipe {
    private final EmiRecipeCategory category;
    private final ResourceLocation id;
    private final List<EmiStack> stacks;
    private final int columns;

    public ItemGridEmiRecipe(EmiRecipeCategory category, ResourceLocation id, List<EmiStack> stacks, int columns) {
        this.category = category;
        this.id = id;
        this.stacks = new ArrayList<>(stacks);
        this.columns = Math.max(1, columns);
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return category;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return Collections.emptyList();
    }

    @Override
    public List<EmiStack> getOutputs() {
        return stacks;
    }

    @Override
    public int getDisplayWidth() {
        return 18 * columns + 8;
    }

    @Override
    public int getDisplayHeight() {
        int rows = (int) Math.ceil(stacks.size() / (double) columns);
        return 18 * Math.max(1, rows) + 8;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        int x0 = 4;
        int y0 = 4;

        for (int i = 0; i < stacks.size(); i++) {
            int x = x0 + (i % columns) * 18;
            int y = y0 + (i / columns) * 18;
            widgets.addSlot(stacks.get(i), x, y).drawBack(true);
        }
    }
}
