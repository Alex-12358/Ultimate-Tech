package org.mod.ultimate_tech.mixin.emi;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.screen.EmiScreenManager;
import net.minecraft.resources.ResourceLocation;
import org.mod.ultimate_tech.integration.emi.EmiSidebarModTabState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = EmiScreenManager.class, remap = false)
public abstract class EmiScreenManagerMixin {
    @Shadow
    private static List<? extends EmiIngredient> searchedStacks;

    @Inject(method = "getSearchSource", at = @At("RETURN"), cancellable = true, remap = false)
    private static void ultimateTech$filterByActiveNamespace(CallbackInfoReturnable<List<? extends EmiIngredient>> cir) {
        String namespace = EmiSidebarModTabState.getActiveNamespace();
        if (namespace == null || namespace.isBlank()) {
            return;
        }

        cir.setReturnValue(ultimateTech$filterListByNamespace(cir.getReturnValue(), namespace));
    }

    @Inject(method = "updateSearchSidebar", at = @At("RETURN"), remap = false)
    private static void ultimateTech$filterVisibleSidebar(CallbackInfo ci) {
        String namespace = EmiSidebarModTabState.getActiveNamespace();
        if (namespace == null || namespace.isBlank()) {
            return;
        }
        searchedStacks = ultimateTech$filterListByNamespace(searchedStacks, namespace);
    }

    @Unique
    private static List<? extends EmiIngredient> ultimateTech$filterListByNamespace(List<? extends EmiIngredient> source, String namespace) {
        if (source == null || source.isEmpty()) {
            return source;
        }

        // Используем stream для более эффективной фильтрации
        return source.stream()
                .filter(ingredient -> ultimateTech$matchesNamespace(ingredient, namespace))
                .toList();
    }

    @Unique
    private static boolean ultimateTech$matchesNamespace(EmiIngredient ingredient, String namespace) {
        if (ingredient == null) {
            return false;
        }
        // Используем anyMatch для ранего выхода из цикла
        return ingredient.getEmiStacks().stream()
                .anyMatch(stack -> {
                    ResourceLocation id = stack.getId();
                    return id != null && namespace.equals(id.getNamespace());
                });
    }
}

