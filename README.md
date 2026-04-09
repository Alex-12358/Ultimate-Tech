# Ultimate Tech Mod

[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.20.1-green)](https://www.minecraft.net/)
[![Forge Version](https://img.shields.io/badge/Forge-47.x-orange)](https://files.minecraftforge.net/)
[![Java](https://img.shields.io/badge/Java-17+-red)](https://www.java.com/)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

## 📖 Описание

**Ultimate Tech** - это технологический мод для Minecraft 1.20.1, добавляющий новые материалы, инструменты, блоки и жидкости. Проект разработан с использованием Minecraft Forge, Mixin и интегрирован с EMI.

### 🎯 Основные возможности:

- ✅ **8 новых материалов** с полным набором предметов
- ✅ **Руды** в разных биомах (Overworld, Deepslate, Nether, End)
- ✅ **Полный набор инструментов** для каждого материала (меч, кирка, топор, лопата, мотыга)
- ✅ **Кастомные жидкости** (редстоун, сырая нефть) с текстурами
- ✅ **Блоки хранения** (обычные и сырые)
- ✅ **Лифт (Elevator)** с 8 вариантами для разных материалов
- ✅ **Автоматическая система регистрации** через enum
- ✅ **EMI интеграция** с категоризацией предметов

---

## 📦 Что было добавлено

### Материалы (8 типов):
- 🟦 **Кобальт** (Cobalt)
- 🟩 **Цинк** (Zinc)
- 🟫 **Мифрил** (Mithril)
- И ещё 5 других материалов

### Для каждого материала:
- **Руды:** Обычная, Deepslate, Nether, End
- **Слитки** (Ingot)
- **Материалы:** Пыль, Пластина, Самородок, Стержень, Сырьё
- **Блоки хранения:** Обычный блок, Сырой блок
- **Полный набор инструментов:** Меч, Кирка, Топор, Лопата, Мотыга

### Жидкости:
- 🔴 **REDSTONE** - красная жидкость
- ⬛ **CRUDE_OIL** - чёрная жидкость (сырая нефть)

### Специальные блоки:
- 🛗 **Elevator** - лифт для быстрого перемещения (8 вариантов)
- 🎮 **Game Items** - игровые предметы

---

## 🛠️ Технические детали

### Версии:
- **Minecraft:** 1.20.1
- **Forge:** 47.x
- **Java:** 17+
- **Язык программирования:** Java

### Архитектура:

```
enum ModFluid / ModMaterial
    ↓
RegistryInitializer (централизованная инициализация)
    ↓
ModFluidsRegistry / ModItemsUtils / ModBlockUtils
    ↓
DeferredRegister (Forge реестр)
    ↓
Ultimate Tech - готово!
```

---

## 📁 Структура проекта

```
Ultimate Tech/
├── src/main/java/org/mod/ultimate_tech/
│   ├── core/registry/
│   │   ├── RegistryInitializer.java     ← Главный инициализатор
│   │   ├── fluid/
│   │   │   ├── BaseFluidType.java       ← Управление жидкостями
│   │   │   ├── FluidTypesRegistry.java  ← Регистрация типов жидкостей
│   │   │   ├── ModFluidsRegistry.java   ← Автоматическая регистрация
│   │   │   └── ModFluidUtils.java
│   │   ├── item/
│   │   │   ├── material/                ← Генерация материальных предметов
│   │   │   └── tool/                    ← Генерация инструментов
│   │   ├── block/
│   │   │   ├── custom/                  ← Кастомные блоки (elevator)
│   │   │   └── generator/               ← Автогенерация блоков
│   │   └── ModBlockUtils.java
│   ├── common/
│   │   ├── material/ModFluid.java       ← Enum жидкостей
│   │   └── init/Registry.java
│   ├── integration/
│   │   └── emi/                         ← EMI интеграция
│   │       ├── ItemCategoryClassifier.java
│   │       └── EmiCategoryFilterController.java
│   └── mixin/
│       └── emi/EmiScreenManagerMixin.java
└── README.md
```

---

## 🚀 Начало работы

### Для игроков:

1. Установите Minecraft Forge 47.x
2. Скачайте мод JAR файл
3. Поместите в папку `mods`
4. Запустите Minecraft!

### Для разработчиков:

#### 1. Клонируйте репозиторий:
```bash
git clone https://github.com/Alex-12358/Ultimate-Tech.git
cd "Ultimate Tech"
```

#### 2. Сгенерируйте IDE файлы:
```bash
./gradlew genIntellijRuns
```

#### 3. Откройте проект в IntelliJ IDEA

#### 4. Запустите `runClient`

---

## 📚 Система регистрации материалов

### Автоматическая генерация:

#### 1️⃣ Добавьте материал в enum (если нужен новый):

```java
// ModMaterial.java
COBALT(true, true, true, true, true);  
// ore, ingot, block, tool, fluid
```

#### 2️⃣ Система **автоматически создаст:**

✅ Руды (обычная, deepslate, nether, end)
✅ Слитки
✅ Блоки хранения
✅ Все инструменты (меч, кирка, топор, лопата, мотыга)
✅ Материалы (пыль, пластины, самородки, стержни, сырьё)

**Готово!** Ничего больше не нужно писать! 🎉

---

## 💧 Система регистрации жидкостей

### Автоматическая регистрация жидкостей:

#### 1️⃣ Добавьте в `ModFluid.java` enum:

```java
public enum ModFluid {
    REDSTONE(true),
    CRUDE_OIL(true),
    ZINC(true),        // ← Новая жидкость
    ;
    // ...остальное...
}
```

#### 2️⃣ Добавьте в `FluidTypesRegistry.java`:

```java
public static final RegistryObject<FluidType> ZINC_FLUID_TYPE =
        FLUID_TYPES.register("zinc_fluid", () -> new BaseFluidType(
                new ResourceLocation(MOD_ID, "block/zinc_fluid_still"),
                new ResourceLocation(MOD_ID, "block/zinc_fluid_flowing"),
                new ResourceLocation(MOD_ID, "block/zinc_fluid_overlay"),
                0xFF888888  // Цвет (серый)
        ));
```

#### 3️⃣ В метод `getFluidType()`:

```java
if (fluid == ModFluid.ZINC) {
    return ZINC_FLUID_TYPE.get();
}
```

#### 4️⃣ Создайте текстуры:

```
assets/ultimate_tech/textures/block/
- zinc_fluid_still.png (256x256)
- zinc_fluid_flowing.png (256x256)
- zinc_fluid_overlay.png (256x256)
```

#### ✨ Всё! Жидкость автоматически создана с:
- Source жидкость
- Flowing жидкость
- Блок жидкости
- Ведро

---

## 🔍 EMI Интеграция

### Категории поиска:

| Категория | Описание |
|-----------|---------|
| **Ores** | Все руды из всех биомов |
| **Ingots** | Все слитки |
| **Materials** | Пыль, пластины, самородки, стержни, сырьё |
| **Tools** | Все инструменты |
| **Fluids** | Все жидкости |

### Использование в EMI:

1. Откройте инвентарь (E)
2. В EMI нажмите категорию слева
3. Видите только предметы этой категории!

---

## 🎨 Текстуры жидкостей

### Требования:

- **Размер:** 256x256 пикселей
- **Формат:** PNG 32-bit (RGBA)
- **Типы:** Still, Flowing, Overlay

### Текущие жидкости:

| Жидкость | Цвет | RGB Hex |
|----------|------|---------|
| **REDSTONE** | Красная | 0xFFFF0000 |
| **CRUDE_OIL** | Чёрная | 0xFF1a1a1a |

---

## 📊 Статистика

### Генерируется автоматически:
- **Материальные предметы:** 8 материалов × 6 типов = 48 предметов
- **Инструменты:** 8 материалов × 5 типов = 40 инструментов
- **Блоки:** 8 материалов × 8 типов = 64 блока
- **Жидкости:** 2 жидкости = 6 компонентов (source, flowing, block, bucket × 2)

**Всего:** 150+ предметов и блоков!

---

## 🔧 Конфигурация

### `gradle.properties`:
```properties
minecraft_version=1.20.1
forge_version=47.4.10
loader_version_range=[0,)
```

### `build.gradle`:
```gradle
minecraft {
    version = "1.20.1-47.4.10"
}
```

---

## 🐛 Известные проблемы

- Пока нет известных критических багов

---

## 📝 TODO

- [ ] Добавить крафт рецепты
- [ ] Добавить достижения (Advancements)
- [ ] Добавить звуковые эффекты
- [ ] Оптимизировать текстуры
- [ ] Добавить еду (SOON)
- [ ] Добавить больше материалов

---

## 🙏 Спасибо

- **Kaupenjoe** - лучшие туториалы по Forge разработке
- **Forge Team** - отличный фреймворк
- **Minecraft Community** - за вдохновение

---

## 📄 Лицензия

Проект лицензирован под MIT License

---

Made with ❤️ by Ultimate Tech Team

**Последнее обновление:** 2026-04-09 | **Версия:** 1.0.0

