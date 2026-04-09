# EMI Integration Guide - Руководство интеграции EMI

## 📋 Общая информация

Код EMI (Everyone's Margin Improvement) был скопирован в ваш проект Ultimate Tech для полной интеграции и кастомизации.

**Исходный репозиторий:** https://github.com/emilyploszaj/emi/tree/1.20

## 📂 Структура скопированных файлов

```
src/main/java/dev/emi/
├── emi/                    # Основной код EMI (xplat - кроссплатформенный)
│   ├── api/               # Public API
│   ├── bom/               # Build of Materials
│   ├── chess/             # Шахматная доска (UI система)
│   ├── com/               # Компоненты
│   ├── config/            # Конфигурация
│   ├── data/              # Обработка данных
│   ├── handler/           # Обработчики
│   ├── input/             # Ввод команд
│   ├── jemi/              # Java EMI API
│   ├── mixin/             # Mixins (инъекции кода)
│   ├── network/           # Сетевые функции
│   ├── platform/          # Поддержка платформ
│   ├── recipe/            # Система рецептов
│   ├── registry/          # Реестр предметов
│   ├── runtime/           # Runtime компоненты
│   ├── screen/            # Экраны/UI
│   └── search/            # Поиск
│
└── forge_emi/             # Forge-специфичный код
    ├── platform/forge/    # Forge платформа
    └── api/forge/         # Forge API
```

## 🔧 Что нужно сделать для адаптации

### 1. **Обновить package names** (если нужно)

Текущие пакеты:
- `dev.emi.emi.*` - основной код
- `dev.emi.emi.platform.forge.*` - Forge специфичный код

Если вы хотите изменить на `org.mod.ultimate_tech.emi.*`, нужно:
```bash
# Переименовать папки
# Обновить все import'ы в файлах
# Обновить META-INF/mods.toml
```

### 2. **Обновить зависимости в gradle**

В файле `build.gradle` нужно проверить/добавить:

```gradle
dependencies {
    // Для EMI API
    // modImplementation('dev.emi:emi:${emi_version}:api')
    
    // Но так как мы встроили код, это не нужно
    // Нужно только убедиться, что все либы установлены
}
```

### 3. **Обновить entry points**

В файле `src/main/resources/META-INF/mods.toml` добавьте:

```toml
[[entrypoints]]
entrypoint = "dev.emi.emi.platform.forge.EmiForge"
stage = "COMMON"

[[entrypoints]]
entrypoint = "dev.emi.emi.platform.forge.EmiClientForge"
stage = "CLIENT"
```

### 4. **Обновить mixins**

Проверьте файл `src/main/resources/emi-forge.mixins.json` и интегрируйте в ваш основной mixins файл.

## 🚀 Основные компоненты EMI

### EMI API
- **RegistryEntry** - представление предмета в реестре
- **EmiStack** - стек предметов
- **EmiRecipe** - интерфейс для рецептов
- **EmiIngredient** - ингредиент рецепта

### EMI Screen
- **Screen** - основной экран UI
- **Widget** - виджет UI
- **Input** - обработка ввода

### EMI Platform
- **EmiForge** - инициализация для Forge
- **EmiClientForge** - клиентская часть
- **EmiPacketHandler** - обработка пакетов

## 📝 Примеры использования

### Регистрация кастомного рецепта

```java
package org.mod.ultimate_tech;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.jemi.JEmiRecipe;

public class UltimateTechRecipes {
    public static void registerRecipes() {
        // Регистрируйте ваши рецепты здесь
    }
}
```

### Регистрация предметов в EMI

```java
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.registry.EmiRecipeCategories;

public class EMIIntegration {
    public static void init() {
        // Интегрируйте ваши рецепты категории
    }
}
```

## ⚠️ Важные замечания

1. **Лицензирование** - EMI лицензирована под MIT License. Убедитесь, что вы соответствуете этой лицензии в вашем проекте.

2. **Зависимости** - EMI может зависеть от других библиотек. Проверьте `build.gradle` в оригинальном репозитории.

3. **Совместимость** - Этот код для Minecraft 1.20 и Forge 47.4.10+.

4. **Обновления** - Если EMI обновляется, вам нужно будет повторить процесс синхронизации.

## 🔗 Полезные ссылки

- **EMI GitHub:** https://github.com/emilyploszaj/emi
- **EMI Wiki:** https://github.com/emilyploszaj/emi/wiki
- **Minecraft Forge Docs:** https://docs.minecraftforge.net

## 📋 Чек-лист интеграции

- [ ] Проверены package names
- [ ] Обновлены зависимости в gradle
- [ ] Обновлены entry points в mods.toml
- [ ] Обновлены mixins конфигурация
- [ ] Проверены и разрешены конфликты импортов
- [ ] Протестирована компиляция
- [ ] Протестирована функциональность в игре

---

**Дата интеграции:** 2026-04-09  
**Версия EMI:** 1.20  
**Версия Forge:** 47.4.10+

