package org.mod.ultimate_tech.integration.emi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Shared state for custom EMI mod tabs and a small bridge to request sidebar refresh.
 */
public final class EmiSidebarModTabState {
    private static final Logger LOGGER = LoggerFactory.getLogger("UltimateTech/EMI");
    private static volatile String activeNamespace;

    private EmiSidebarModTabState() {
    }

    public static String getActiveNamespace() {
        return activeNamespace;
    }

    public static void setActiveNamespace(String namespace) {
        if (namespace != null && namespace.isBlank()) {
            namespace = null;
        }
        activeNamespace = namespace;
        requestRecalculate();
    }


    private static void requestRecalculate() {
        try {
            Class<?> manager = Class.forName("dev.emi.emi.screen.EmiScreenManager");
            invokeNoArg(manager, "forceRecalculate");
            invokeNoArg(manager, "updateSearchSidebar");
            invokeRepopulate(manager, "INDEX");
            invokeRepopulate(manager, "CRAFTABLES");
        } catch (ClassNotFoundException e) {
            LOGGER.debug("EMI not available for sidebar recalculation");
        } catch (Exception e) {
            LOGGER.warn("Failed to request EMI sidebar recalculation", e);
        }
    }

    private static void invokeNoArg(Class<?> manager, String methodName) {
        try {
            Method method = manager.getMethod(methodName);
            method.invoke(null);
        } catch (NoSuchMethodException e) {
            LOGGER.debug("EMI method {} not found, EMI version may differ", methodName);
        } catch (Exception e) {
            LOGGER.warn("Failed to invoke EMI method {}", methodName, e);
        }
    }

    private static void invokeRepopulate(Class<?> manager, String sidebarTypeName) {
        try {
            Class<?> sidebarTypeClass = Class.forName("dev.emi.emi.config.SidebarType");
            Object sidebarType = Enum.valueOf((Class<Enum>) sidebarTypeClass.asSubclass(Enum.class), sidebarTypeName);
            Method method = manager.getMethod("repopulatePanels", sidebarTypeClass);
            method.invoke(null, sidebarType);
        } catch (ClassNotFoundException e) {
            LOGGER.debug("EMI SidebarType not found");
        } catch (Exception e) {
            LOGGER.debug("Failed to repopulate EMI panels for {}", sidebarTypeName, e);
        }
    }
}



